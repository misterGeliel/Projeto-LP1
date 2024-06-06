import java.time.LocalDateTime;

import static java.lang.StringTemplate.STR;

public class Notificacao {
    private String titulo;
    private String mensagem;
    private LocalDateTime timestamp;

    public Notificacao(String titulo, String mensagem) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.timestamp = LocalDateTime.now();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return STR."Notificacao{titulo='\{titulo}\{'\''}, mensagem='\{mensagem}\{'\''}, timestamp=\{timestamp}\{'}'}";
    }
}