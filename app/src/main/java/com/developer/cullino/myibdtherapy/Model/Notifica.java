package com.developer.cullino.myibdtherapy.Model;

public class Notifica {
    private int idFarmaco;
    private String ora;
    private int quantita;
    private int intervallo;
    private int daysOff;

    public Notifica(){}

    public Notifica(int idFarmaco, String ora, int quantita, int intervallo, int daysOff) {
        this.idFarmaco = idFarmaco;
        this.ora = ora;
        this.quantita = quantita;
        this.intervallo = intervallo;
        this.daysOff = daysOff;
    }

    public int getIdFarmaco() {
        return idFarmaco;
    }

    public void setIdFarmaco(int idFarmaco) {
        this.idFarmaco = idFarmaco;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getIntervallo() {
        return intervallo;
    }

    public void setIntervallo(int intervallo) {
        this.intervallo = intervallo;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    @Override
    public String toString() {
        return "Notifica{" +
                "idFarmaco=" + idFarmaco +
                ", ora='" + ora + '\'' +
                ", quantita=" + quantita +
                ", intervallo=" + intervallo +
                ", daysOff=" + daysOff +
                '}';
    }
}
