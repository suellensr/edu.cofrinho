package edu.cofrinho;

import java.text.DecimalFormat;

public class Euro extends Moeda {

    private static final double TAXA_CONVERSAO_EURO = 5.54;  //valor em 20/05

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return getClass().getSimpleName() + " - Valor: " + valor;
    }

    @Override
    public double converter() {
        return valor * TAXA_CONVERSAO_EURO;
    }
}
