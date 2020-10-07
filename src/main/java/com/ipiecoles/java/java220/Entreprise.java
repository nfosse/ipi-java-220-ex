package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Entreprise {
    public static final double SALAIRE_BASE = 1480.27;
    public static final int NB_CONGES_BASE = 25;
    public static final double INDICE_MANAGER = 1.3;
    public static final double PRIME_MANAGER_PAR_TECHNICIEN = 250;
    public static final double PRIME_ANCIENNETE = 100;

    public static double primeAnnuelleBase() {
        double currentYear = LocalDate.now().getYear();

        return currentYear / 2d;
    }
}