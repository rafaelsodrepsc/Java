package banco.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public LocalDateTime getHora() {
        return hora;
    }
    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }
    public TipoTransacao getTipo() {
        return tipo;
    }
    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = hora.format(formatter);
        
        return String.format("%s | %s | R$ %10.2f | %s",
                dataFormatada,
                tipo,
                valor,
                descricao);
    }
}
