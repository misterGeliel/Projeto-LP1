import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notas {

    private int id;
    private String titulo;
    private String conteudo;
    private String dataDeCriacao;
    private String dataDeModificacao;

    public Notas(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataDeCriacao = gerarDataAtual();
        this.dataDeModificacao = dataDeCriacao;
    }

    private String gerarDataAtual() {
        // Criar um objeto LocalDateTime com a data e hora atuais
        LocalDateTime dataHoraAtual = LocalDateTime.now();

        // Formatar a data e hora no formato desejado (dd/MM/yyyy HH:mm:ss)
        String dataFormatada = dataHoraAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        // Retornar a string formatada
        return dataFormatada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
        this.dataDeModificacao = gerarDataAtual();
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
        this.dataDeModificacao = gerarDataAtual();
    }

}