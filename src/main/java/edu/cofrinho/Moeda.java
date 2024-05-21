package edu.cofrinho;

public abstract class Moeda {

    protected double valor;

    public Moeda(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public abstract String info();

    public abstract double converter();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - Valor: " + valor;
    }
}
