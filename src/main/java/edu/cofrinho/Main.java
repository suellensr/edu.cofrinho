package edu.cofrinho;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale brasil = new Locale("pt", "BR");
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(brasil); // Configura o scanner para usar o locale brasileiro (o separador das casas decimais passa a ser , )
        Cofrinho cofrinho = new Cofrinho();

        while (true) {
            try {
                System.out.println("Menu:");
                System.out.println("1. Adicionar Moeda");
                System.out.println("2. Remover Moeda");
                System.out.println("3. Listar Moedas");
                System.out.println("4. Calcular Total em Reais");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt(); // Lê o próximo inteiro

                switch (opcao) {
                    case 1:
                        menuAdicionarMoeda(scanner, cofrinho);
                        break;
                    case 2:
                        menuRemoverMoeda(scanner, cofrinho);
                        break;
                    case 3:
                        listarMoedas(cofrinho);
                        break;
                    case 4:
                        calcularTotalEmReais(cofrinho);
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                scanner.next(); // Limpa a entrada inválida
            }
            pausarParaContinuar(scanner);
        }
    }

    private static void menuAdicionarMoeda(Scanner scanner, Cofrinho cofrinho) {
        try {
            System.out.println("Escolha o tipo de moeda que deseja adicionar:");
            System.out.println("1-Dolar");
            System.out.println("2-Euro");
            System.out.println("3-Real");
            int tipoMoeda = scanner.nextInt(); // Lê o próximo inteiro
            if (tipoMoeda < 1 || tipoMoeda > 3) {
                System.out.println("Tipo de moeda inválido!");
                return;
            }
            System.out.print("Digite o valor da moeda: ");
            double valor = scanner.nextDouble();  //Recebe o valor que sera adicionado
            if (valor <= 0) {
                System.out.println("Valor inválido! O valor deve ser maior que zero.");
                return;
            }
            Moeda moeda = null;
            switch (tipoMoeda) {   // Chama a conversão adequada baseado no tipo da moeda escolhido
                case 1:
                    moeda = new Dolar(valor);
                    break;
                case 2:
                    moeda = new Euro(valor);
                    break;
                case 3:
                    moeda = new Real(valor);
                    break;
            }

            System.out.println(cofrinho.adicionarMoeda(moeda)); // Chama o método adicionar moeda e imprime o retorno

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, insira um número válido.");
            scanner.next(); // Limpa a entrada inválida
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao adicionar a moeda: " + e.getMessage());
        }
    }

    private static void menuRemoverMoeda(Scanner scanner, Cofrinho cofrinho) {
        try {
            System.out.println("Escolha o tipo de moeda que deseja remover:");
            System.out.println("1-Dolar");
            System.out.println("2-Euro");
            System.out.println("3-Real");
            int tipoMoeda = scanner.nextInt();
            if (tipoMoeda < 1 || tipoMoeda > 3) {
                System.out.println("Tipo de moeda inválido!");
                return;
            }
            System.out.print("Digite o valor da moeda: ");
            double valor = scanner.nextDouble();
            if (valor <= 0) {
                System.out.println("Valor inválido! O valor deve ser maior que zero.");
                return;
            }
            Moeda moeda = null;
            switch (tipoMoeda) {
                case 1:
                    moeda = new Dolar(valor);
                    break;
                case 2:
                    moeda = new Euro(valor);
                    break;
                case 3:
                    moeda = new Real(valor);
                    break;
            }

            String mensagem = cofrinho.removerMoeda(moeda);
            System.out.println(mensagem);

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Por favor, insira um número válido.");
            scanner.next(); // Limpa a entrada inválida
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao remover a moeda: " + e.getMessage());
        }
    }

    private static void listarMoedas(Cofrinho cofrinho) {
        System.out.println("Moedas no cofrinho:");
        List<String> infoMoedas = cofrinho.listarMoedas();
        for (String infoMoeda : infoMoedas) {
            System.out.println(infoMoeda);
        }
    }

    private static void calcularTotalEmReais(Cofrinho cofrinho) {
        double total = cofrinho.totalConvertido();
        System.out.println("Total em Reais no cofrinho: R$ " + total);
    }

    private static void pausarParaContinuar(Scanner scanner) {
        System.out.println("Pressione qualquer tecla para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}