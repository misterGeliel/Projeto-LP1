import java.io.FileWriter;
import java.io.IOException;

public class CadastrarDadosDoCliente {

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;

    // Construtor para inicializar os dados do cliente
    public CadastrarDadosDoCliente(String nome, String endereco, String telefone, String email, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public void salvarDados() {
        try{

            FileWriter writer = new FileWriter("clientes.txt", true);


            String dadosCliente = String.format("%s, %s, %s, %s, %s\n", this.nome, this.endereco, this.telefone, this.email, this.cpf);


            writer.write(dadosCliente);

            
            writer.close();

            System.out.println("Dados do cliente salvos no arquivo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao salvar dados no arquivo.");
        }
    }


    public boolean validarDados() {
        // Validate name
        if (this.nome == null || this.nome.isEmpty() || this.nome.trim().length() < 3) {
            System.out.println("Erro: Nome inválido. Digite um nome com pelo menos 3 caracteres.");
            return false;
        }

        
        if (this.endereco == null || this.endereco.isEmpty() || this.endereco.trim().length() < 5) {
            System.out.println("Erro: Endereço inválido. Digite um endereço completo.");
            return false;
        }


        if (this.telefone == null || this.telefone.isEmpty() || !this.telefone.matches("\\d+[-\\s]*\\d+")) {
            System.out.println("Erro: Telefone inválido. Digite um número de telefone no formato xx-xxxxx-xxxx.");
            return false;
        }


        if (this.email == null || this.email.isEmpty() || !this.email.matches("^([\\w\\.\\+]+@[\\w\\.-]+\\.[\\w]{2,4})?$")) {
            System.out.println("Erro: Email inválido. Digite um email válido.");
            return false;
        }

        if (this.cpf == null || this.cpf.isEmpty() || !this.cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            System.out.println("Erro: CPF inválido. Digite um CPF no formato XXX.XXX.XXX-XX.");
            return false;
        }
        
        
        return true;
    }



}
