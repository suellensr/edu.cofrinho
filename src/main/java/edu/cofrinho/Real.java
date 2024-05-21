package edu.cofrinho;

import java.text.DecimalFormat;

public class Real extends Moeda{

    public Real(double valor) {
        super(valor);
    }

    @Override
    public String info() {
        return getClass().getSimpleName() + " - Valor: " + valor;
    }

    @Override
    public double converter() {  //Para real não há taxa de conversão, então retorna o próprio valor
        return valor;
    }
}
