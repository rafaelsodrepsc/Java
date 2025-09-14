package banco.model;

import java.time.LocalDateTime;

public class ContaPoupanca extends Conta{
    private double taxaRendimento = 0.0005;
    
    public ContaPoupanca(String nome, String numConta, double saldo, double taxaRendimento){
        super(nome, numConta, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento(){
        double valorRendido = getSaldo() * taxaRendimento;
        setSaldo(getSaldo() + valorRendido);
        Transacao novaTransacao = new Transacao(LocalDateTime.now(), TipoTransacao.RENDIMENTO, getSaldo(), "Rendimento do saldo realizado.");
        addTransacao(novaTransacao);
    }

}
