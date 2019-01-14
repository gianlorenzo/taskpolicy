package it.uniroma3.taskpolicy.dao;

import it.uniroma3.taskpolicy.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDaoCustom {

    public void updateEndDate(Task t);

    public List<Object> taskTimes();

}
