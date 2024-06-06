import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Agenda {
    private Map<String, Anotacao> anotacoes;
  

    public Agenda() {
        anotacoes = new HashMap<>();
    }


    public void visualizarAgenda() {
        for (Map.Entry<String, Anotacao> anotacaoEntry : anotacoes.entrySet()) {
            Anotacao anotacao = anotacaoEntry.getValue();
            for (String s : Arrays.asList(STR."Data: \{anotacao.getData()}", "Título: " + anotacao.getTitulo(), STR."Conteúdo: \{anotacao.getConteudo()}", "-------------------------")) {
                System.out.println(s);
            }
        }
    }

   
    public void salvarAnotacoes() {
        FileDescriptor fileName = null;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(anotacoes);
            System.out.println("Anotações salvas com sucesso no arquivo: " + fileName);
        } catch (IOException e) {
            System.err.println("Erro ao salvar anotações: " + e.getMessage());
        }
    }

    public void criarAnotacao(String data, String titulo, String conteudo) {
        Anotacao anotacao = new Anotacao();
        anotacoes.put(data, anotacao);
    }






}


