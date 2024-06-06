import java.util.Scanner;

public class AlterarDadosDoCliente {


    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;

    public AlterarDadosDoCliente(String nome, String endereco, String telefone, String email, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }


    public void exibirDadosAtuais() {
        System.out.println("Dados do Cliente:");
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
        System.out.println("CPF: " + cpf);
    }


    public void alterarDados() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAlterar Dados do Cliente:");

        System.out.print("Novo nome (ou pressione Enter para manter): ");
        String novoNome = scanner.nextLine();
        if (!novoNome.isEmpty()) {
            this.nome = novoNome;
        }

        System.out.print("Novo endereço (ou pressione Enter para manter): ");
        String novoEndereco = scanner.nextLine();
        if (!novoEndereco.isEmpty()) {
            this.endereco = novoEndereco;
        }


        System.out.println("Dados do cliente atualizados com sucesso!");
    }


}

