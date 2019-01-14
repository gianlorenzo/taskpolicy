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
    public void addImageAdnTaskToResult(Task t, Result r, Job j) {
        for (Image i : j.getImages()) {
            r = new Result();
            r.setImage(i);
            r.setTask(t);
        }
    }

}