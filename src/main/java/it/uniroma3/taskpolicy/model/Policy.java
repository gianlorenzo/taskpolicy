package it.uniroma3.taskpolicy.model;


import javax.persistence.*;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String yesAnswer;

    @Column
    private String noAnswer;

    @Column
    private String uncertainty;

    public Policy() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYesAnswer() {
        return yesAnswer;
    }

    public void setYesAnswer(String yesAnswer) {
        this.yesAnswer = yesAnswer;
    }

    public String getNoAnswer() {
        return noAnswer;
    }

    public void setNoAnswer(String noAnswer) {
        this.noAnswer = noAnswer;
    }

    public String getUncertainty() {
        return uncertainty;
    }

    public void setUncertainty(String uncertainty) {
        this.uncertainty = uncertainty;
    }
}
