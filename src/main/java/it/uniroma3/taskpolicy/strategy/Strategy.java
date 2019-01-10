package it.uniroma3.taskpolicy.strategy;

public class Strategy {

    private int i=0;
    public int rectangular (double n1, double n2, double m1, double m2) {
        if (n1 == m1)
            this.i=1;
        else if (n2 == m2)
            this.i=0;
        return this.i;
    }
}
