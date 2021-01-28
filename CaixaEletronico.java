package Projetos;

import java.util.Scanner;

public class CaixaEletronico implements Saldo, Transferencia, Saque, Deposito, InterfaceCaixaEletronico {

    private double saldoContaBancaria = 0;
    Scanner entrada = new Scanner(System.in);


    @Override
    public void saldoConta() {

        System.out.printf("Seu saldo é: R$ %.2f\n", saldoContaBancaria);
        System.out.print("Para mostrar novamente o saldo digite (1) para um novo depósito digite (2) para sair (3): ");
        byte menuDeOpcao = entrada.nextByte();
        if (menuDeOpcao == 1) {
            saldoConta();
        } else if (menuDeOpcao == 2) {
            depositar();
        } else if (menuDeOpcao == 3) {
            System.out.println("Saindo...");
            interfaceUsuario();

        } else {
            System.out.println("VALOR INVÁLIDO!!");
            saldoConta();
        }


    }


    @Override
    public void tranferir() {
        System.out.print("Digite o valor do da transferência: R$ ");
        double valorTransferencia = entrada.nextDouble();


        if (saldoContaBancaria >= valorTransferencia) {
            System.out.println("Ok vamos continuar.");
            saldoContaBancaria -= valorTransferencia;
            System.out.print("Digite o nome do beneficiário: ");
            String beneficiario = entrada.next();

            System.out.print("Digite o CPF do beneficiário: ");
            long cpf = entrada.nextLong();

            System.out.print("Digite nome do banco: ");
            String nomeBanco = entrada.next();

            System.out.printf("---------------------------------\n" +
                    "CUMPOM\n" +
                    "Nome do beneficiado : %s\n" +
                    "Cpf : " + cpf + "\n" +
                    "Nome do banco: %s\n" +
                    "Seu saldo é : %.2f\n" +
                    "---------------------------------\n", beneficiario, nomeBanco, saldoContaBancaria);


            System.out.print("Para novo depósito digite (1) para sair digite (2): ");
            byte menuDeOpcao = entrada.nextByte();
            if (menuDeOpcao == 1) {
                System.out.println("ok vamos continuar.");
                tranferir();
            } else if (menuDeOpcao == 2) {
                System.out.println("Saindo...");
                interfaceUsuario();

            } else {
                System.out.println("VALOR INVÁLIDO!!");
            }

        } else if (saldoContaBancaria < valorTransferencia) {
            System.out.println("Desculpe saldo insuficiente, seu saldo é : " + saldoContaBancaria);

            System.out.print("Digite (1) para fazer um depósito ou (2) para sair: ");

            byte menuDeOpcao = entrada.nextByte();
            if (menuDeOpcao == 1) {
                System.out.println("OK aguarde...");
                depositar();
            } else if (menuDeOpcao == 2) {
                System.out.println("Saindo...");
                interfaceUsuario();

            } else {
                System.out.println("VALOR INVÁLIDO!!");
                tranferir();
            }

        }


    }

    @Override
    public void sacar() {
        System.out.printf("Saldo atual: R$ %.2f\n", saldoContaBancaria);
        System.out.print("Digite o valor do saque: ");


        double valorSaque = entrada.nextDouble();
        if (valorSaque <= saldoContaBancaria) {
            System.out.println("Contando dinheiro...");
            saldoContaBancaria -= valorSaque;
            System.out.print("Digite (1) para fazer novo saque ou (2) para sair:");
            byte menuDeOpcao = entrada.nextByte();
            if (menuDeOpcao == 1) {
                System.out.println("ok vamos continuar.");
                sacar();
            } else if (menuDeOpcao == 2) {
                System.out.println("Saindo...");
                interfaceUsuario();

            } else {
                System.out.println("VALOR INVÁLIDO!!");
                sacar();
            }


        } else if (valorSaque > saldoContaBancaria) {
            System.out.println("Desculpe Saldo insuficiente.");
            System.out.printf("seu saldo é R$ %.2f faça um depósito...\n", saldoContaBancaria);
            System.out.println("------------------------------------------------------");
            depositar();

        }


    }


    @Override
    public void depositar() {

        System.out.print("Digite o valor do depósito: R$ ");
        double valorDeposito = entrada.nextDouble();
        saldoContaBancaria += valorDeposito;


        System.out.print("Para novo depósito digite (1) para sair digite (2): ");
        byte menuDeOpcao = entrada.nextByte();
        if (menuDeOpcao == 1) {
            System.out.println("ok vamos continuar.");
            depositar();
        } else if (menuDeOpcao == 2) {
            System.out.println("Saindo...");
            interfaceUsuario();

        } else {
            System.out.println("VALOR INVÁLIDO!!");
            depositar();
        }


    }

    @Override
    public void interfaceUsuario() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("-----------------------------\n" +
                "Caixa eletrônico\n" +
                "-----------------------------");
        System.out.println("Digite:\n" +
                "(1) Saldo\n" +
                "(2) Tranferência\n" +
                "(3) Saque\n" +
                "(4) Depósito\n" +
                "(5) SAIR\n" +
                "-----------------------------");
        byte menuDeOpcoes = entrada.nextByte();
        if (menuDeOpcoes == 1) {
            saldoConta();

        } else if (menuDeOpcoes == 2) {
            tranferir();

        } else if (menuDeOpcoes == 3) {
            sacar();

        } else if (menuDeOpcoes == 4) {
            depositar();
        } else if (menuDeOpcoes == 5) {
            System.out.println("Obrigado por utilizar o Caixa Eletronico 1.0 ");

        }

        entrada.close();

    }
}

