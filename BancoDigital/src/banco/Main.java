package banco;

import banco.model.*;
import banco.service.*;

public class Main {
    public static void main(String[] args) {
        BancoService banco = new BancoService();

        System.out.println("Banco digital - Versão 1.0");
        System.out.println("--------------------------");

        System.out.println("Criando Contas novas");
        Conta contaCorrenteRafael = banco.criarConta("Rafael","Corrente");
        Conta contaPoupancaVitoria = banco.criarConta("Vitoria","Poupança");

        if (contaCorrenteRafael != null) {
            System.out.println("Conta Corrente criada com sucesso! Número: " + contaCorrenteRafael.getNumConta());
            System.out.println("Saldo inicial conta de " + contaCorrenteRafael.getNome()+ ": " + contaCorrenteRafael.getSaldo());
        }
        
        if (contaPoupancaVitoria != null) {
            System.out.println("Conta Poupança criada com sucesso! Número: " + contaPoupancaVitoria.getNumConta());
            System.out.println("Saldo inicial conta 2: " + contaPoupancaVitoria.getSaldo());
        }
        System.out.println("----------------------------------");
        
        System.out.println("Depositando 1000 na conta de " + contaCorrenteRafael.getNome());
        contaCorrenteRafael.depositar(1000);
        System.out.println("Saldo da conta " + contaCorrenteRafael.getNome()+ ":" + contaCorrenteRafael.getSaldo());
        
        System.out.println("----------------------------------");

        System.out.println("Transferencia da conta de Rafael para Vitoria");
        banco.realizarTransferencia(contaCorrenteRafael,contaPoupancaVitoria,1300);

        System.out.println("Saldo Final Vitoria:" + contaPoupancaVitoria.getSaldo());
        System.out.println("Saldo Final " + contaCorrenteRafael.getNome()+ ":" + contaCorrenteRafael.getSaldo());

    }
    
}
