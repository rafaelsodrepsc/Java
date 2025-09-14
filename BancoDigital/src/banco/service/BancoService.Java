package banco.service;

import java.util.ArrayList;

import banco.model.Conta;
import banco.model.ContaCorrente;
import banco.model.ContaPoupanca;

public class BancoService{
    
    public Conta criarConta(String nome, String tipoConta){
        Conta contaNova = null;
        
        if(tipoConta.equals("Poupanca")){
            contaNova = new ContaPoupanca(nome, 0.0, 0.0005);
        }else if(tipoConta.equals("Corrente")){
            contaNova = new ContaCorrente(nome, 0.0, 300.0);
        }else{
            System.out.println("Tipo de conta invalida");
        }
        return contaNova;
    }

    public void realizarTransferencia(Conta origem, Conta destino, double valor){
        if (origem.sacar(valor)){
            destino.depositar(valor);  
        }else{
            System.out.println("Transferencia invalida");
        }
    }
    public Conta buscarContaPorNumero(String numConta, ArrayList<Conta> contas) {
    for (Conta c : contas) {
        if (c.getNumConta().equals(numConta)) {
            return c;
        }
    }
    return null;
}
}