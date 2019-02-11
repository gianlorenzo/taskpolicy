package it.uniroma3.taskpolicy.service.impl;


import it.uniroma3.taskpolicy.dao.ResultDao;
import it.uniroma3.taskpolicy.model.Job;
import it.uniroma3.taskpolicy.model.Result;
import it.uniroma3.taskpolicy.model.Task;
import it.uniroma3.taskpolicy.model.TaskWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultDao resultDao;

    public void addResult(Result r) {
        resultDao.save(r);
    }

    public Result retrieveResult(long id) {
        return this.resultDao.findOne(id);
    }

    public List<Result> retrieveAllResult() {
        return this.resultDao.findAll();
    }

    public List<Result> findTaskResult(Task task) {
        return this.resultDao.findByTask(task);
    }

    public void updateListResult(TaskWrapper taskResults) {
        resultDao.updateListResult(taskResults);
    }

    public void addImageAndTaskToResult(Task t, Result r, Job j) {
        resultDao.addImageAdnTaskToResult(t, r, j);
    }

    public List<Result> findResultByImage(Long id) { return this.resultDao.findResultByImage(id);}

    public Long findTaskByImage(Long id) {return this.resultDao.findTaskByImage(id);}

    public List<BigInteger> findResultWithNoNullAnswer(Long id) {return this.resultDao.findResultWithNoNullAnswer(id);}

    }
