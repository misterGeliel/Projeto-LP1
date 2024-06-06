import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServicoNotificacao {
    private List<Notificacao> notificacoes = new ArrayList<>();

    public void adicionarNotificacao(String titulo, String mensagem) {
        String severityLevel = "";
        Notificacao notificacao = new Notificacao(titulo, mensagem, severityLevel, LocalDateTime.now());
        notificacoes.add(notificacao);
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void enviarNotificacao(Notificacao notificacao) {
        // Implemente a lógica para enviar a notificação
        // Isso pode ser enviar um e-mail, uma mensagem para um sistema de mensagens, etc.
        System.out.println("Enviando notificação: " + notificacao);
    }

    public void enviarTodasNotificacoes() {
        for (Notificacao notificacao : notificacoes) {
            enviarNotificacao(notificacao);
        }
    }

    public void limparNotificacoes() {
        notificacoes.clear();
    }
}