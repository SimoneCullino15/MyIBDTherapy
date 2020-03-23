package com.developer.cullino.myibdtherapy.Model;

public class Farmaco {
    private int id;
    private String nome;
    private String bugiardino;
    private String img;

    public Farmaco(){}

    public Farmaco(int id, String nome, String bugiardino, String img) {
        this.id = id;
        this.nome = nome;
        this.bugiardino = bugiardino;
        this.img = img;
    }

    public Farmaco(String nome, String bugiardino, String img) {
        id = -1;
        this.nome = nome;
        this.bugiardino = bugiardino;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBugiardino() {
        return bugiardino;
    }

    public void setBugiardino(String bugiardino) {
        this.bugiardino = bugiardino;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Farmaco{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", bugiardino='" + bugiardino + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
