import java.util.Iterator;
import java.util.List;

public class GerenciadorClientes {

    private List<Usuario> clientes; // Data storage (replace with appropriate persistence mechanism)

    // Constructor

    public void adicionarCliente(Usuario novoCliente) {
        clientes.add(novoCliente);
        // Implement data persistence (database, file, etc.)
    }

    public Usuario buscarCliente(int idCliente) {
        for (Usuario cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        return null; // Handle not found scenario
    }

    public void editarCliente(Usuario clienteAtualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdCliente() == clienteAtualizado.getIdCliente()) {
                clientes.set(i, clienteAtualizado);
                // Implement data persistence (update database, file, etc.)
                break;
            }
        }
        // Handle customer not found scenario
    }

    public void removerCliente(int idCliente) {
        for (Iterator<Usuario> iterator = clientes.iterator(); iterator.hasNext();) {
            Usuario cliente = iterator.next();
            if (cliente.getIdCliente() == idCliente) {
                iterator.remove();
                break;
            }
        }

    }

    public List<Usuario> listarClientes() {
        return clientes; // Implement data retrieval from persistence layer
    }

    public GerenciadorClientes(List<Usuario> clientes) {
        this.clientes = clientes;
    }

    public List<Usuario> getClientes() {
        return clientes;
    }

    public void setClientes(List<Usuario> clientes) {
        this.clientes = clientes;
    }
}

