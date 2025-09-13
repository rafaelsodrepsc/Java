package banco.model;
import java.util.ArrayList;

public abstract class Conta{
    private int id;
    private String nome;
    private String numConta;
    private double saldo;
    private ArrayList<Transacao> historico;


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
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

    public void sacar(double valor){
        this.saldo -= valor;       
    }

    public void depositar(double valor){
        this.saldo += valor;       
    }

}