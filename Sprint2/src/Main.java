import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

    private static Object sistemaLogin;
    private static boolean hasEvents;
    private Evento[] eventos;

    public static void main() throws FileNotFoundException {
        var calendario = new CalendarioComEventos("eventos.txt");
        String calendarioJunho = calendario.gerarCalendario(2024, 6);
        System.out.println(calendarioJunho);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome de usuário:");
        String username = scanner.nextLine();
        System.out.println("Insira a senha:");
        String password = scanner.nextLine();

        CadastrarDadosDoCliente cliente = new CadastrarDadosDoCliente("João Silva", "Rua da Paz, 123", "(83) 9999-9999", "joao@email.com", "123.456.789-00");


        if (cliente.validarDados()) {

            cliente.salvarDados();
        } else {
            System.out.println("Erro ao cadastrar o cliente. Dados inválidos.");
        }
//        SistemaLogin login = new SistemaLogin();
//        System.out.println("Cadastro");
//        Scanner scanner = new Scanner(System.in);
//        ;
//        var nome = scanner.nextLine();
//        login.nome = nome;
//        System.out.println(login.nome);
//        scanner = new Scanner(System.in);
//
//        SistemaLogin sistemaLogin = new SistemaLogin();

        // Option to log in
        System.out.println("\nDeseja fazer login? (s/n)");
        String logar = scanner.nextLine();

        if (logar.equalsIgnoreCase("s")) {
            System.out.print("Digite seu nome de usuário: ");
            String nomeUsuario = scanner.nextLine();
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();
            String nomeUsuario1 = nomeUsuario; // Assigning username to a new variable
            if (nomeUsuario1 != null && !nomeUsuario1.isEmpty()) { // Validating username
                System.out.println("Login bem-sucedido!");
                System.out.println("\nBem-vindo(a), " + nomeUsuario1 + "!");

                boolean continuarMenu = true;
                while (continuarMenu) {
                    System.out.println("\nMenu de Ações:");
                    System.out.println("1. Criar nova anotação");
                    System.out.println("2. Gerenciar Calendário");
                    System.out.println("3. Visualizar Notificações");
                    System.out.println("4. Sair");

                    System.out.print("Escolha a opção desejada (1-4): ");
                    int escolhaMenu = scanner.nextInt();

                    switch (escolhaMenu) {
                        case 1:

                            System.out.println("\nMenu de Gerenciamento de Anotações:");
                            System.out.println("1. Criar nova anotação");
                            System.out.println("2. Editar anotação existente");
                            System.out.println("3. Listar anotações");
                            System.out.println("4. Remover anotação");
                            System.out.println("5. Voltar ao menu principal");

                            System.out.print("Digite sua opção: ");
                            int opcao = scanner.nextInt();
                            scanner.nextLine(); // Consume newline character

                        case 2:
                            System.out.println("\nVisualizar Agenda:");
                            Calendar calendar = Calendar.getInstance();

                            // Choose a date range to display (e.g., current week)
                            int currentDay = calendar.get(Calendar.DAY_OF_WEEK);
                            int daysToAdd = (Calendar.SUNDAY - currentDay) % 7;
                            calendar.add(Calendar.DAY_OF_MONTH, daysToAdd);


                            for (int i = 0; i < 7; i++) {
                                int day = calendar.get(Calendar.DAY_OF_MONTH);
                                int month = calendar.get(Calendar.MONTH) + 1;
                                int year = calendar.get(Calendar.YEAR);


                                System.out.println("\n" + day + "/" + month + "/" + year + ":");


                                
                                if (hasEvents) {
                                    System.out.println("  - Eventos:");

                                } else {
                                    System.out.println("  - Sem eventos.");
                                }

                                calendar.add(Calendar.DAY_OF_MONTH, 1);
                            }
                            break;
                        case 3:
                            System.out.println("\nVisualizar Notificações:");
                            break;

                        case 4:
                            System.out.println("Saindo do menu.");
                            continuarMenu = false;
                            break;

                        default:
                            System.out.println("Opção inválida.");
                    }
                }
            } else {
                System.out.println("Nome de usuário ou senha inválidos.");
            }


        }


    }
    CalendarioComEventos calendario1 = new CalendarioComEventos("calendario_trabalho.txt");
    CalendarioComEventos calendario2 = new CalendarioComEventos("calendario_pessoal.txt");


    public boolean hasEventsOnDate(int day, int month, int year) {
        LocalDate targetDate = LocalDate.of(year, month, day);
        for (Evento evento : eventos) {
            if (evento.getData().equals(targetDate)) {
                return true;
            }
        }
        return false;
    }

    public String gerarCalendario(int i, int i1) {
        return "";
    }
}


