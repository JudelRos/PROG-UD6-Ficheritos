package net.textwriter.actividad4;

import java.io.Serializable;

public class Mesa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String color;
    private int numeroPatas;

    public Mesa(String color, int numeroPatas) {
        this.color = color;
        this.numeroPatas = numeroPatas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumeroPatas() {
        return numeroPatas;
    }

    public void setNumeroPatas(int numeroPatas) {
        this.numeroPatas = numeroPatas;
    }

    @Override
    public String toString() {
        return "Es una mesa de color " + this.color + " y tiene " + this.numeroPatas
                + " patas, una pasada de mesa la verdad.";
    }

}
