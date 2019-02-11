package it.uniroma3.taskpolicy.dao.impl;




import it.uniroma3.taskpolicy.dao.ResultDaoCustom;
import it.uniroma3.taskpolicy.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = false)
public class ResultDaoImpl implements ResultDaoCustom {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void updateListResult(TaskWrapper taskResults) {
        for (Result r : taskResults.getResultList()) {
            LOGGER.debug("UPDATE result: task " + r.getTask().getId() + " student " + r.getTask().getStudent().getId() + " result " + r.getId());
            String update = "update result set answer = ?1 where id = ?2";
            Query query = this.entityManager.createNativeQuery(update).setParameter(1, r.getAnswer()).
                    setParameter(2, r.getId());
            if (query.executeUpdate() != 1) {
                LOGGER.debug("PROBLEM IN updateListResult - task " + r.getTask().getId() + " student " + r.getTask().getStudent().getId() + " result " + r.getId());
            }
        }
    }

    @Override
    public List<Result> findResultByImage(Long id) {
        String s = "FROM Result r WHERE r.image.id='" + id + "'";
        Query query= this.entityManager.createQuery(s);
        List<Result> results = query.getResultList();
        return results;

    }

    @Override
    public List<BigInteger> findResultWithNoNullAnswer(Long id) {
        List<Object> resultList;
        Result r;
        List<BigInteger> resultsId;
        String s = "select r.id from result r where r.image_id='"+id+"' and r.answer is not null";
        Query query = this.entityManager.createNativeQuery(s);
        resultsId = query.getResultList();
        //String s = "select r.id,r.answer,r.image_id,r.task_id from result r where r.image_id = ?1 and r.answer is not null";
        //Query query = this.entityManager.createNativeQuery(s).setParameter(1,id);
        //resultList = query.getResultList();
        /*for (int i = 0;i<resultList.size();i++) {
            r = (Result)resultList.get(i);
            results.add(r);
        }*/
        return resultsId;
    }

    @Override
    public Long findTaskByImage(Long id) {
        String s = "SELECT r.task.id FROM result r WHERE r.image.id='" + id + "' order by rand() ";
        Query query = this.entityManager.createQuery(s);
        Long taskId = (Long)query.getSingleResult();
        return taskId;
    }


    @Override
    public void addImageAdnTaskToResult(Task t, Result r, Job j) {
        for (Image i : j.getImages()) {
            r = new Result();
            r.setImage(i);
            r.setTask(t);
        }
    }

}