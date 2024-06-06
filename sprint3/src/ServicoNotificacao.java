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
        System.out.println("**Notificação Enviada:**");
        System.out.println("Destinatário: " + notificacao.getDestinatario());
        System.out.println("Assunto: " + notificacao.getAssunto());
        System.out.println("Mensagem: " + notificacao.getMensagem());
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