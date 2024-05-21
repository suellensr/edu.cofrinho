package edu.cofrinho;

import java.text.DecimalFormat;

public class Dolar extends Moeda {
    private static final double TAXA_CONVERSAO_DOLAR = 5.10;  //valor em 20/05

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return getClass().getSimpleName() + " - Valor: " + valor;
    }

    @Override
    public double converter() {
        return valor * TAXA_CONVERSAO_DOLAR;
    }
}
