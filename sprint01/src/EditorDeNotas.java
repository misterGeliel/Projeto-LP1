import javax.swing.text.*;

import java.util.Stack;
import java.io.*;
import java.time.LocalDateTime;
// Importar biblioteca para lidar com datas e horas

public class EditorDeNotas {

    private Notas notaAtual; // Armazena a nota que está sendo editada no momento

    // Construtor
    public EditorDeNotas() {

        this.notaAtual = new Notas("", ""); // Cria uma nova nota vazia como padrão
    }

    // Método para abrir uma nota existente (por ID ou nome)
    public void abrirNota(int id) {
        // Definir o caminho do arquivo onde a nota está armazenada
        String caminhoArquivo = "notas/" + id + ".txt";

        // Tentar ler o conteúdo do arquivo
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            // Ler o título da nota
            String titulo = leitor.readLine();

            // Ler o conteúdo da nota
            StringBuilder conteudo = new StringBuilder();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }

            // Criar um novo objeto Nota com os dados obtidos
            Notas nota = new Notas(titulo, conteudo.toString());

            // Atualizar a variável `notaAtual` com a nota encontrada
            this.notaAtual = nota;
        } catch (FileNotFoundException e) {
            // Exibir uma mensagem de erro informando que o arquivo não foi encontrado
            System.out.println("Nota com o ID " + id + " não encontrada.");
        } catch (IOException e) {
            // Tratar outros erros de leitura de arquivo
            e.printStackTrace();
        }
    }

    public void abrirNota(String nome) {
        // Definir o caminho do arquivo onde a nota está armazenada
        String caminhoArquivo = "notas/" + nome + ".txt";

        // Tentar ler o conteúdo do arquivo
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            // Ler o título da nota (considerando que o título está na primeira linha)
            String titulo = leitor.readLine();

            // Ler o conteúdo da nota
            StringBuilder conteudo = new StringBuilder();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }

            // Criar um novo objeto Nota com os dados obtidos
            Notas nota = new Notas(titulo, conteudo.toString());

            // Atualizar a variável `notaAtual` com a nota encontrada
            this.notaAtual = nota;
        } catch (FileNotFoundException e) {
            // Exibir uma mensagem de erro informando que o arquivo não foi encontrado
            System.out.println("Nota com o nome " + nome + " não encontrada.");
        } catch (IOException e) {
            // Tratar outros erros de leitura de arquivo
            e.printStackTrace();
        }
    }

    // Método para criar uma nova nota
    public void criarNota() {

        this.notaAtual = new Notas("", ""); // Cria uma nova nota vazia
    }

    // Método para salvar a nota atual
    public void salvarNota() {
        // Verificar se a nota atual foi carregada (possui um título)
        if (this.notaAtual != null && this.notaAtual.getTitulo() != null && !this.notaAtual.getTitulo().isEmpty()) {
            // Definir o caminho do arquivo onde a nota será salva
            String caminhoArquivo = "notas/" + this.notaAtual.getTitulo() + ".txt";

            // Tentar escrever o conteúdo da nota no arquivo
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo))) {
                // Escrever o título da nota
                escritor.write(this.notaAtual.getTitulo());
                escritor.newLine();

                // Escrever o conteúdo da nota
                escritor.write(this.notaAtual.getConteudo());

                // Exibir uma mensagem de sucesso informando que a nota foi salva
                System.out.println("Nota salva com sucesso!");
            } catch (IOException e) {
                // Tratar erros de escrita no arquivo
                e.printStackTrace();
            }
        } else {
            // Exibir uma mensagem de erro informando que a nota não foi salva
            System.out.println("Erro ao salvar a nota. Título inválido.");
        }
    }

    // Método para adicionar texto à nota atual
    public void adicionarTexto(String texto) {
        this.notaAtual.setConteudo(this.notaAtual.getConteudo() + texto);
    }

    // Método para remover texto da nota atual
    public void removerTexto(int posicaoInicial, int quantidade) {
        String conteudoAtual = this.notaAtual.getConteudo();
        String novoConteudo = conteudoAtual.substring(0, posicaoInicial) + conteudoAtual.substring(posicaoInicial + quantidade);
        this.notaAtual.setConteudo(novoConteudo);
    }

    // Método para buscar texto dentro da nota atual
    public String buscarTexto(String termoBusca) {
        // Verificar se a nota atual foi carregada e se o termo de busca foi informado
        if (this.notaAtual != null && termoBusca != null && !termoBusca.isEmpty()) {
            // Converter o conteúdo da nota para minúsculo para facilitar a busca
            String conteudoMinusculo = this.notaAtual.getConteudo().toLowerCase();

            // Converter o termo de busca para minúsculo para facilitar a busca
            String termoBuscaMinusculo = termoBusca.toLowerCase();

            // Criar uma variável para armazenar os resultados da busca
            StringBuilder resultadosBusca = new StringBuilder();

            // Buscar todas as ocorrências do termo de busca dentro do conteúdo da nota
            int posicaoAtual = 0;
            int posicaoEncontrada;
            while ((posicaoEncontrada = conteudoMinusculo.indexOf(termoBuscaMinusculo, posicaoAtual)) != -1) {
                // Adicionar o texto encontrado antes da ocorrência do termo de busca aos resultados
                resultadosBusca.append(conteudoMinusculo.substring(posicaoAtual, posicaoEncontrada));

                // Adicionar o termo de busca formatado em negrito aos resultados
                resultadosBusca.append("<b>").append(termoBusca).append("</b>");

                // Atualizar a posição atual para continuar a busca após a ocorrência encontrada
                posicaoAtual = posicaoEncontrada + termoBuscaMinusculo.length();
            }

            // Adicionar o texto restante da nota aos resultados
            resultadosBusca.append(conteudoMinusculo.substring(posicaoAtual));

            // Retornar os resultados da busca formatados em HTML
            return resultadosBusca.toString();
        } else {
            // Se a nota atual não foi carregada ou o termo de busca não foi informado, retornar uma string vazia
            return "";
        }
    }
}

