import java.util.Map;
import java.util.Scanner;

public class Anotacao {
    public String data;
    public String titulo;
    public String conteudo;
    private Anotacao minhaAnotacao;
    private String content;

    public Anotacao() {
        this.content = content;
    }

    public Anotacao getMinhaAnotacao() {
        return minhaAnotacao;
    }

    public String getContent() {
        return content;
    }

    public Map<String, Anotacao> getAnotacoes() {
        return anotacoes;
    }


    public void updateAnnotation(String newTitulo, String newConteudo) {
        if (newTitulo != null) {
            this.titulo = newTitulo;
        }
        if (newConteudo != null) {
            this.conteudo = newConteudo;
        }
    }

    private Map<String, Anotacao> anotacoes;


    public void criar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o título da anotação: ");
        String titulo = scanner.nextLine();

        System.out.println("\nDigite o conteúdo da anotação: ");
        String content = scanner.nextLine();


        Anotacao novaAnotacao = new Anotacao(titulo, content);

        System.out.println("\nAnotação criada com sucesso!");
        System.out.println("Título: " + novaAnotacao.getTitulo());
        System.out.println("Conteúdo: " + novaAnotacao.getConteudo());
    }


    static Anotacao getAnotacao(Anotacao anotacao) {

        anotacao.setConteudo("Conteúdo atualizado");

        return anotacao;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }


    public Anotacao(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public Object getData() {
        return data;
    }
    public static String getTitulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o título da anotação (ou pressione Enter para deixar sem título): ");
        return scanner.nextLine();
    }

    public static String getConteudo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nDigite o conteúdo da anotação: ");
        return scanner.nextLine();
    }

}