package banco.model;
import java.time.LocalDateTime;

public class ContaCorrente extends Conta{
    private double chequeEspecial = 500.00;

    public ContaCorrente(String nome, double saldo, double chequeEspecial){
        super(nome,saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public boolean sacar(double valor){
        if(getSaldo() + chequeEspecial >= valor){
            setSaldo(getSaldo() - valor);
            Transacao novaTransacao = new Transacao(LocalDateTime.now(), TipoTransacao.SAQUE, valor, "Saque realizado.");
            addTransacao(novaTransacao);
            return true; 
        }else{
            return false;
        }
    }
    
}