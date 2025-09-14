package banco.model;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Conta{
    private String nome;
    private String numConta;
    private double saldo;
    private ArrayList<Transacao> historico;
    private static int contadorContas = 1;

    public Conta(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
        this.numConta = String.valueOf(contadorContas);
        contadorContas++;
        this.historico = new ArrayList<>();
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    public String getNumConta(){
        return numConta;
    }

    public void setNumConta(String numConta){
        this.numConta = numConta;
    }

    public void addTransacao(Transacao transacao){
        this.historico.add(transacao);
    }

    public boolean sacar(double valor){
        if(getSaldo() >= valor){
            this.saldo -= valor;
            Transacao novaTransacao = new Transacao(LocalDateTime.now(), TipoTransacao.SAQUE, valor, "Saque realizado.");
            historico.add(novaTransacao);
            return true; 
        }else{
            return false;
        }
    }

    public boolean depositar(double valor){
        this.saldo += valor;
        Transacao novaTransacao = new Transacao(LocalDateTime.now(), TipoTransacao.DEPOSITO, valor, "Deposito realizado.");
        historico.add(novaTransacao);
        return true;
    }

}