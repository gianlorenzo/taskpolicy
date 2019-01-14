package it.uniroma3.taskpolicy.model;


import javax.persistence.*;


@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Image image;

    @ManyToOne
    private Task task;

    @Column(length = 1024)
    private String answer;

    public Result() {
    }

    public Result(Long id, Image image, Task task, String answer) {
        super();
        this.id = id;
        this.image = image;
        this.task = task;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean equals(Object object) {
        Result result = (Result) object;
        return this.id.equals(result.getId());
    }

    public int hash() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "Result [id=" + id + ", "
                + "image=" + image + ", "
                + "task=" + task + ", "
                + "answer=" + answer + "]";
    }

}
