package com.developer.cullino.myibdtherapy.Model;

public class FarmacoNotifica {
    Farmaco farmaco;
    Notifica notifica;

    public FarmacoNotifica(){
        farmaco = new Farmaco();
        notifica = new Notifica();
    }

    public FarmacoNotifica (Farmaco farmaco, Notifica notifica){
        this.farmaco = farmaco;
        this.notifica = notifica;
    }

    public Farmaco getFarmaco() {
        return farmaco;
    }

    public void setFarmaco(Farmaco farmaco) {
        this.farmaco = farmaco;
    }

    public Notifica getNotifica() {
        return notifica;
    }

    public void setNotifica(Notifica notifica) {
        this.notifica = notifica;
    }

    @Override
    public String toString() {
        return "FarmacoNotifica{" +
                "farmaco=" + farmaco +
                ", notifica=" + notifica +
                '}';
    }
}
