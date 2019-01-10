package it.uniroma3.taskpolicy.cost;


import it.uniroma3.taskpolicy.probability.Probability;

public class Cost {

    private Probability probability = new Probability();

    private double alfa = 0;
    private double k=0;

    public double Y00(double err, double selectivity, double current_min, double current_max,
                      double m1, double m2, double uncertainity) {

        this.alfa = current_min + (current_max-current_min)/2;
        this.k = probability.p1(0,0,err,selectivity)*Y(err,selectivity,1,0,m1,m2,alfa)+1;
        if(alfa >=k-uncertainity && alfa <=k+uncertainity)
            return alfa;
        if(alfa<k)
            return Y00(err,selectivity,alfa,current_max,m1,m2,uncertainity);
        if(alfa>k)
            return Y00(err,selectivity,current_min,alfa,m1,m2,uncertainity);
        return alfa;
    }

    public double Y(double err, double selectivity, double n1, double n2, double m1, double m2, double y00) {
        if(n1>=m1)
            return 0;
        if(n2>=m2)
            return y00;
        return Math.min(y00,probability.p1(err,selectivity,n1,n2)*
                Y(err,selectivity,n1+1,n2,m1,m2,y00)+
                probability.p0(n1,n2,err,selectivity)*Y(err,selectivity,n1,n2+1,m1,m2,y00)+1);
    }
    
}
