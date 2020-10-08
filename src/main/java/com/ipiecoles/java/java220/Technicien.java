package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Technicien extends Employe {
    private Integer grade;

    public Technicien() { }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) throws Exception {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire + (1 * (grade / 10)));
    }

    @Override
    public Integer getNbConges() {
        return super.getNbConges() + this.getNombreAnneeAnciennete();
    }

    @Override
    public Double getPrimeAnnuelle() {
        return super.getPrimeAnnuelle()
                + (super.getPrimeAnnuelle() * (grade / 10))
                + (Entreprise.PRIME_ANCIENNETE * getNombreAnneeAnciennete());
    }

    /**
     * Redéfinir la méthode `getPrimeAnnuelle` pour qu'elle renvoie la prime annuelle de base à laquelle on ajoute un pourcentage
     * en fonction du grade (+10% pour grade 1, +30% pour grade 3...) ainsi que la prime d'ancienneté multipliée par le nombre d'année d'ancienneté
     */
}