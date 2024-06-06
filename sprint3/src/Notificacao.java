import java.time.LocalDateTime;
import java.util.List;

public class Notificacao {

    private String titulo;
    private String mensagem;
    private LocalDateTime timestamp;
    private String severityLevel;
    private boolean read;
    private String destinatario;
    private String assunto;

    public Notificacao(String titulo, String mensagem, String severityLevel, LocalDateTime now) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.timestamp = LocalDateTime.now();
        this.severityLevel = "Info";
        this.read = false;
    }

    public Notificacao(String titulo, String mensagem, String severityLevel) {
        this(titulo, mensagem, severityLevel, LocalDateTime.now());
        this.severityLevel = severityLevel;
    }

    @Override
    public String toString() {
        return String.format("Notificacao{titulo='%s', mensagem='%s', timestamp=%s, severityLevel='%s', read=%b}",
                titulo, mensagem, timestamp, severityLevel, read);
    }

    public void markAsRead() {
        this.read = true;
    }

    public boolean isImportant() {
        return severityLevel.equals("Warning") || severityLevel.equals("Error");
    }

    public static List<Notificacao> filterBySeverityLevel(List<Notificacao> notificacoes, String severityLevel) {
        return null;
    }
    public static Anotacao carregarAnotacao(String nomeArquivo) {
        return null;

    }
    static void mostrarAnotacao() {
    }

    private Object getSeverityLevel() {
        return null;
    }

    public void setRead(boolean b) {
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isRead() {
        return read;
    }

    public String getMensagem() {
        return "";
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
