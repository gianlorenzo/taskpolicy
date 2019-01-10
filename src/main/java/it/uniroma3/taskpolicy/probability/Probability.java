package it.uniroma3.taskpolicy.probability;

public class Probability {

    private double err;

    private double n1;

    private double n2;

    private double selectivity;

    public double getErr() {
        return err;
    }

    public void setErr(double err) {
        this.err = err;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getSelectivity() {
        return selectivity;
    }

    public void setSelectivity(double selectivity) {
        this.selectivity = selectivity;
    }

    public double yes1(double err) {
        this.err = err;
        return (1-this.err);
    }

    public double yes0(double err) {
        this.err = err;
        return this.err;
    }

    public double no0(double err){
        this.err = err;
        return (1-this.err);
    }

    public double no1(double err) {
        this.err = err;
        return this.err;
    }

    public double pN1N21(double err, double n1, double n2){
        this.err = err;
        this.n1 = n1;
        this.n2 = n2;
        return(((Math.pow(1-this.err,this.n1))*(Math.pow(this.err,this.n2))));
    }

    public double pN1N20(double n1, double n2, double err) {
        this.n1 = n1;
        this.n2 = n2;
        this.err = err;
        return (((Math.pow(this.err,n1))*(Math.pow(1-this.err,this.n2))));
    }

    public double p1N1N2(double n1, double n2, double err, double selectivity) {
        this.n1 = n1;
        this.n2 = n2;
        this.err = err;
        this.selectivity = selectivity;
        return (this.pN1N21(this.err,this.n1,this.n2)*this.selectivity/
                this.pN1N2(this.n1,this.n2,this.err,this.selectivity));
    }

    public double p0N1N2(double n1, double n2, double err, double selectivity) {
        this.n1 = n1;
        this.n2 = n2;
        this.err = err;
        this.selectivity = selectivity;
        return (this.pN1N20(this.n1,this.n2,this.err)*(1-this.selectivity)/
                this.pN1N2(this.n1,this.n2,this.err,this.selectivity));
    }


    public double pN1N2(double n1, double n2, double err, double selectivity) {
        this.n1 = n1;
        this.n2 = n2;
        this.err = err;
        this.selectivity = selectivity;
        return(this.selectivity*this.pN1N21(this.n1,this.n2,this.err)+
                (1-this.selectivity)*this.pN1N20(this.n1, this.n2, this.err));
    }

    public double p1(double n1, double n2,double err, double selectivity) {
        this.n1 = n1;
        this.n2 = n2;
        this.err = err;
        this.selectivity = selectivity;
        return ((this.p1N1N2(this.n1,this.n2, this.err, this.selectivity)*this.yes1(this.err))+
                (this.p0N1N2(this.n1,this.n2,this.err,this.selectivity)*this.yes0(this.err)));
    }

    public double p0(double n1, double n2,double err, double selectivity) {
        this.n1 = n1;
        this.n2 = n2;
        this.err = err;
        this.selectivity = selectivity;
        return ((this.p1N1N2(this.n1,this.n2, this.err, this.selectivity)*this.no1(this.err))+
                (this.p0N1N2(this.n1,this.n2,this.err,this.selectivity)*this.no0(this.err)));
    }
}
