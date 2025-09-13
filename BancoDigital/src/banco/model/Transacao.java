package banco.model;
import java.time.LocalDateTime;

public class Transacao {
    private LocalDateTime hora;
    private TipoTransacao tipo;
    private double valor;
    private String descricao;

    public Transacao(LocalDateTime hora, TipoTransacao tipo, double valor, String descricao){
        this.hora = hora;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
    }

}
