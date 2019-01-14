package it.uniroma3.taskpolicy.dao;

import it.uniroma3.taskpolicy.model.Job;
import it.uniroma3.taskpolicy.model.Result;
import it.uniroma3.taskpolicy.model.Task;
import it.uniroma3.taskpolicy.model.TaskWrapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultDaoCustom {
    public void addImageAdnTaskToResult(Task t, Result r, Job j);

    public void updateListResult(TaskWrapper taskResults);
}
