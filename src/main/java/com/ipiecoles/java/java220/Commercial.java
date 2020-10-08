package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Commercial extends Employe {
    private Double caAnnuel = 0d;
    private Integer performance;

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) throws Exception {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public Boolean performanceEgale(Integer performanceAComparer) {
        return this.performance.equals(performanceAComparer);
    }

    @Override
    public Double getPrimeAnnuelle() {
        Double prime = Math.ceil(caAnnuel * 0.05);

        return prime > 500 ? prime : 500d;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Commercial commercial = (Commercial) obj;
        if (super.equals(obj) && commercial.getCaAnnuel() == this.getCaAnnuel()) {
            return true;
        } else {
            return false;
        }
    }
}