package banco;

import java.util.ArrayList;
import java.util.Scanner;

import banco.model.*;
import banco.service.*;

public class Main {
    public static void main(String[] args) {
        BancoService banco = new BancoService();
        Scanner scanner = new Scanner(System.in);
        ArrayList <Conta> contas = new ArrayList<>();

        while (true) {
            System.out.println("--- BEM-VINDO AO BANCO DIGITAL ---");
            System.out.println("1. Criar Conta");
            System.out.println("2. Acessar Conta");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opção = scanner.nextInt();
            scanner.nextLine();

            switch (opção) {
                case 1:
                        
                    System.out.println(" ");
                    System.out.println("--- Crie sua conta ---");
                    System.out.println("Digite seu nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o tipo de conta que deseja: ");
                    System.out.println("---Poupança ou Corrente---");
                    String tipo = scanner.nextLine();
                    
                    Conta contaNova = banco.criarConta(nome, tipo);
                    if (contaNova != null){
                        contas.add(contaNova);
                        System.out.println("conta adicionada com sucesso");
                    }
                    menuLogado(contaNova, scanner, banco, contas);
                    
                    break;
                case 2:
                    
                    System.out.println(" ");
                    System.out.print("Digite o número da conta para acessar: ");
                    String numConta = scanner.nextLine();
                    Conta contaEncontrada = null;

                    for(Conta c : contas) {
                        if(c.getNumConta().equals(numConta)) {
                            contaEncontrada = c;
                            break;
                        }
                    }

                    if (contaEncontrada != null) {
                        menuLogado(contaEncontrada, scanner, banco, contas);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 3:
                    System.out.println(" ");
                    System.out.println("Obrigado por usar nosso Banco!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção invalida");
                    break;
                
            }
            
        }
    }


    public static void menuLogado(Conta conta, Scanner scanner, BancoService banco,ArrayList<Conta> todasAsContas){
        while (true) {
            System.out.println(" ");
            System.out.println("--- Conta " + conta.getNumConta() + " (" + conta.getNome() + ") ---");
            System.out.println("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Transferir");
            System.out.println("4. Ver Extrato");
            System.out.println("5. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println(" ");
                    System.out.println("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble(); 
                    scanner.nextLine(); 
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.println( " ");
                    System.out.println("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    scanner.nextLine();
                    if(conta.sacar(valorSaque)){
                        System.out.println("Saque realizado.");
                    }else{
                        System.out.println("Saldo insuficiente");
                    }
                    break;
                case 3:
                    System.out.println(" ");
                    System.out.print("Digite o número da conta de destino: ");
                    String numContaDestino = scanner.nextLine();

                     if(numContaDestino.equals(conta.getNumConta())) {
                        System.out.println("Não é possível transferir para a mesma conta.");
                        break;
                    }

                    System.out.print("Digite o valor a ser transferido: ");
                    double valorTransferencia = scanner.nextDouble();
                    scanner.nextLine();

                    Conta contaDestino = null;

                    for(Conta c : todasAsContas){
                        if(c.getNumConta().equals(numContaDestino)){
                            contaDestino = c;
                            break;
                        }
                    }
                    if (contaDestino != null) {
                        banco.realizarTransferencia(conta, contaDestino, valorTransferencia);
                    } else {
                        System.out.println("Conta de destino não encontrada!");
                    }
                    break;                    

                case 4:
                    System.out.println(" ");
                    System.out.println("--- Extrato da Conta " + conta.getNumConta() + " ---");
                    ArrayList<Transacao> historico = conta.getHistorico();
                    if (historico.isEmpty()) {
                        System.out.println("Nenhuma transação encontrada.");
                    } else {
                        for (Transacao transacao : historico) {
                            System.out.println(transacao.toString());
                        }
                    }
                    break;
                case 5:
                    System.out.println(" ");
                    System.out.println("Voltando ao menu principal...");
                    return;
                default:
                    break;
            }

        }
    
    }
}
