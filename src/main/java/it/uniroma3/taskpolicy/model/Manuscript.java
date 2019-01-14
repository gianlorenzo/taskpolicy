package it.uniroma3.taskpolicy.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Manuscript {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "manuscript", cascade = CascadeType.ALL)
    private List<Image> images;
    @OneToMany(mappedBy = "manuscript")
    private List<Job> jobs;
    @OneToMany(mappedBy = "manuscript", cascade = CascadeType.ALL)
    private List<Sample> samples;
    @OneToMany(mappedBy = "manuscript")
    private List<Symbol> symbols;
    @OneToMany(mappedBy = "manuscript", cascade = CascadeType.ALL)
    private List<NegativeSample> negativeSamples;

    //costruttori
    public Manuscript() {
        this.images = new ArrayList<>();
        this.jobs = new ArrayList<>();
        this.samples = new ArrayList<>();
        this.symbols = new ArrayList<>();
        this.negativeSamples = new ArrayList<>();
    }

    public Manuscript(String name) {
        this.name = name;
    }

    //getter e setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Sample> getSamples() {
        return samples;
    }

    public void setSamples(List<Sample> samples) {
        this.samples = samples;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public List<NegativeSample> getNegativeSamples() {
        return negativeSamples;
    }

    public void setNegativeSamples(List<NegativeSample> negativeSamples) {
        this.negativeSamples = negativeSamples;
    }

    // add to list

    public void addSymbol(Symbol symbol) {
        this.symbols.add(symbol);
    }

    public void addSample(Sample sample) {
        this.samples.add(sample);
    }

    public void addNegativeSample(NegativeSample negativeSample) {
        this.negativeSamples.add(negativeSample);
    }


    public void addImage(Image img) {
        this.images.add(img);
    }


}
