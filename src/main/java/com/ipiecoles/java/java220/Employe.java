package com.ipiecoles.java.java220;

import jdk.vm.ci.meta.Local;
import org.joda.time.DateTimeComparator;
import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public class Employe {
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire = Entreprise.SALAIRE_BASE;

    public Employe() {
        //
    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) throws Exception {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setMatricule(matricule);
        this.setDateEmbauche(dateEmbauche);
        this.setSalaire(salaire);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if (dateEmbauche.isAfter(LocalDate.now())) {
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante !");
        } else {
            this.dateEmbauche = dateEmbauche;
        }
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public final Integer getNombreAnneeAnciennete() {
        return LocalDate.now().getYear() - dateEmbauche.getYear();
    }

    public Integer getNbConges() {
        return Entreprise.NB_CONGES_BASE;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", matricule='" + matricule + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", salaire=" + salaire +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Employe employe = (Employe) obj;
        if (employe.getNom() == this.getNom()
                && employe.getPrenom() == this.getPrenom()
                && employe.getMatricule() == this.getMatricule()
                && employe.getDateEmbauche() == this.getDateEmbauche()
                && employe.getSalaire() == this.getSalaire()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }

    public void augmenterSalaire(Double pourcentageAugmentation) {
        setSalaire(getSalaire() + (getSalaire() * pourcentageAugmentation));
    }

    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase();
    }
}