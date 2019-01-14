package it.uniroma3.taskpolicy.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column
    private String description;
    @Column(nullable = false)
    private Integer taskSize;
    private Integer numberOfWords;
    @Column(nullable = false)
    private Integer numberOfStudents;
    @Column
    private String typology;
    @Column(columnDefinition = "boolean default 'false'")
    private boolean tutorial;
    private String difficulty;
    @ManyToOne
    private Manuscript manuscript;
    @ManyToMany
    private List<Image> images;
    @OneToMany(mappedBy = "job")
    private List<Task> tasks;
    @ManyToOne
    private Symbol symbol;

    public Job() {
        this.tasks = new ArrayList<>();
    }

    public Job(Long id, String title, Integer taskSize, Integer numberOfStudents, List<Image> images, List<Task> tasks,
               Symbol symbol) {
        this.id = id;
        this.title = title;
        this.taskSize = taskSize;
        this.numberOfStudents = numberOfStudents;
        this.images = images;
        this.tasks = tasks;
        this.symbol = symbol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public Integer getStudents() {
        return numberOfStudents;
    }

    public void setStudents(Integer students) {
        this.numberOfStudents = students;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isTutorial() {
        return tutorial;
    }

    public void setTutorial(boolean tutorial) {
        this.tutorial = tutorial;
    }

    public Integer getTaskSize() {
        return taskSize;
    }

    public void setTaskSize(Integer taskSize) {
        this.taskSize = taskSize;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Manuscript getManuscript() {
        return manuscript;
    }

    public void setManuscript(Manuscript manuscript) {
        this.manuscript = manuscript;
    }

    public Integer getNumberOfWords() {
        return numberOfWords;
    }

    public void setNumberOfWords(Integer numberOfWords) {
        this.numberOfWords = numberOfWords;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public String getTypology() {
        return typology;
    }

    public void setTypology(String typology) {
        this.typology = typology;
    }
}
