import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Anotacao {

    private String titulo;
    private String conteudo;
    private LocalDateTime dataCriacao;
    private String arquivoNome;

    public Anotacao(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataCriacao = LocalDateTime.now();
    }

    // Getters and Setters for all fields
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getArquivoNome() {
        return arquivoNome;
    }

    public void setArquivoNome(String arquivoNome) {
        this.arquivoNome = arquivoNome;
    }

    // Removed unused fields and methods (getISO_LOCAL, getFilePath)

    public void criar() {
        Scanner scanner = new Scanner(System.in); // Initialize outside of method

        System.out.print("Digite o título da anotação: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o conteúdo da anotação: ");
        String conteudo = scanner.nextLine();

        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataCriacao = LocalDate.now().atStartOfDay();

        // Set file name (you might want to implement more robust file name handling)
        this.arquivoNome = titulo.replaceAll("\\s+", "_") + ".txt";

        salvar(); // Save the new note to a file
        System.out.println("Anotação criada com sucesso!");

        scanner.close(); // Close Scanner to release resources
    }

    public void salvar() {
        String dataToWrite = "## Anotação\n\n"
                + "Título: " + this.titulo + "\n"
                + "Conteúdo: \n" + this.conteudo + "\n"
                + "Data de Criação: " + this.dataCriacao.format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n";

        String userHome = System.getProperty("user.home");
        String filePath = userHome + File.separator + "Anotacoes" + File.separator + this.arquivoNome;

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(dataToWrite);
            System.out.println("Anotação salva com sucesso no arquivo: " + filePath);
        } catch (IOException e) {
            System.err.println("Erro ao salvar anotação: " + e.getMessage());
        }
    }

    // Utility method to extract title from file content (optional)
    private String extrairTitulo(String fileContent) {
        String[] lines = fileContent.split("\n");
        if (lines.length > 0) {
            return lines[0].trim();
        } else {
            return "";
        }
    }

   

}

