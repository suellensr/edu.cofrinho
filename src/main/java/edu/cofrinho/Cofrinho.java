package edu.cofrinho;

import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
    private ArrayList<Moeda> moedas;

    public Cofrinho() {
        moedas = new ArrayList<>();
    }

    public String adicionarMoeda(Moeda moeda) {
        // Verifica se a moeda já está no cofrinho
        for (Moeda m : moedas) {
            if (m.getClass().equals(moeda.getClass())) {
                // Se a moeda já existir, atualiza o valor
                m.setValor(m.getValor() + moeda.getValor());
                return "Quantidade de moeda atualizada: " + m.info();
            }
        }
        // Se a moeda não existir, adiciona ela ao cofrinho
        moedas.add(moeda);
        return "Moeda adicionada: " + moeda.info();
    }

    public String removerMoeda(Moeda moeda) {
        // Verifica se a moeda está no cofrinho
        boolean moedaEncontrada = false;
        for (Moeda m : moedas) {
            if (m.getClass().equals(moeda.getClass()) && m.getValor() >= moeda.getValor()) {
                // Atualiza a quantidade da moeda no cofrinho
                m.setValor(m.getValor() - moeda.getValor());
                moedaEncontrada = true;
                break;
            }
        }

        // Se a moeda não foi encontrada, retorna uma mensagem
        if (!moedaEncontrada) {
            return "Moeda não encontrada no cofrinho ou quantidade insuficiente: " + moeda.info();
        }

        // Se a quantidade da moeda se tornar zero, remove ela do cofrinho
        moedas.removeIf(m -> m.getValor() == 0);

        return "Moeda removida: " + moeda.info();
    }

    public List<String> listarMoedas() {
        List<String> infoMoedas = new ArrayList<>();
        //para cada moeda na lista, será retornada a sua informação
        for (Moeda moeda : this.moedas) {
            infoMoedas.add(moeda.info());
        }
        return infoMoedas;
    }

    public double totalConvertido() {
        double total = 0;
        for (Moeda moeda : this.moedas) {
            total += moeda.converter();
        }
        return total;
    }
}