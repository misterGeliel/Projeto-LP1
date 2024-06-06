import java.util.Objects;

public class Usuario {

    private int idCliente;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private Object senha;

    public Usuario() {

    }
    public Usuario(int idCliente, String nome, String endereco, String telefone, String email) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    // Constructor, getters, setters, and other methods as needed


private String username;
    private String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        // For security reasons, avoid returning the plain-text password.
        // Consider implementing a method to verify the password instead.
        return password;
    }

    // You can add a method to verify the password securely (e.g., using hashing)
    public boolean verificarSenha(String password) {
        // Implement password verification logic here (e.g., using a secure hashing algorithm)
        return this.password.equals(password); // Placeholder for secure verification
    }

@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return idCliente == usuario.idCliente &&
                Objects.equals(nome, usuario.nome) && Objects.equals(endereco, usuario.endereco)
                && Objects.equals(telefone, usuario.telefone) && Objects.equals(email, usuario.email)
                && Objects.equals(senha, usuario.senha);
    }
@Override
    public int hashCode() {
        return Objects.hash(idCliente, nome, endereco, telefone, email, senha);
    }
// Constructor, getters, setters, and other methods as needed


@Override
public String toString() {
    return "Usuario{" +
            "username='" + username + '\'' +
            ", password='" + password + '\'' +
            '}';
}
}