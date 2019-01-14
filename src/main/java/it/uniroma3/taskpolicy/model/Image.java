package it.uniroma3.taskpolicy.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int width;
    private int height;
    private String page;
    private String type;
    private String path;
    private String row;
    @ManyToOne
    private Manuscript manuscript;
    @ManyToMany(mappedBy = "images")
    private List<Job> jobs;
    @OneToMany(mappedBy = "image")
    private List<Result> results;

    // costruttori
    public Image() {
    }

    public Image(Long id, int width, int height, String page, Manuscript manuscript, String type,
                 List<Job> jobs, List<Result> results) {
        super();
        this.id = id;
        this.width = width;
        this.height = height;
        this.page = page;
        this.manuscript = manuscript;
        this.type = type;
        this.jobs = jobs;
        this.results = results;
    }

    public Image(int width, int height, String type, Manuscript manuscript, String page, String path) {
        this.width = width;
        this.height = height;
        this.type = type;
        this.manuscript = manuscript;
        this.page = page;
        this.path = path.replace("\\", "/");
    }

    //	getter e setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Manuscript getManuscript() {
        return manuscript;
    }

    public void setManuscript(Manuscript manuscript) {
        this.manuscript = manuscript;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path.replace("\\", "/");
    }

    @Override
    public String toString() {
        return "Image [id=" + id;
    }

}
