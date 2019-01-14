package it.uniroma3.taskpolicy.service.editor;


import it.uniroma3.taskpolicy.model.Task;
import it.uniroma3.taskpolicy.service.impl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class TaskEditor extends PropertyEditorSupport {

    private @Autowired
    TaskService taskService;

    @Override
    public void setAsText(String text) {
        Task t = this.taskService.retrieveTask(Long.valueOf(text));
        this.setValue(t);
    }

}
