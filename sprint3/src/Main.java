import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;
public class Main {

    private static Object sistemaLogin;
    private static boolean hasEvents;
    private Evento[] eventos;
    private String arquivoNome;
    private Anotacao novaAnotacao;
    private String logar;
    private Scanner scanner;

    public void main() throws FileNotFoundException, InterruptedException {

        var calendario = new CalendarioComEventos();
        String calendarioJunho = calendario.gerarCalendario(2024, 6);
        System.out.println(calendarioJunho);


        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDeseja fazer login? (s/n)");
        String logar = scanner.nextLine();

        if (logar.equalsIgnoreCase("s")) {
            System.out.print("Digite seu nome de usuário: ");
            String nomeUsuario = scanner.nextLine();
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();
            String nomeUsuario1 = nomeUsuario;
            if (nomeUsuario1 != null && !nomeUsuario1.isEmpty()) {
                System.out.println("Login bem-sucedido!");
                System.out.println("\nBem-vindo(a), " + nomeUsuario1 + "!");
            }

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
                            Anotacao novaAnotacao = new Anotacao();
                            String title = novaAnotacao.getTitulo();
                            System.out.println("Title: " + title);

                            novaAnotacao.setTitulo("Título da anotação atualizado");
                            novaAnotacao.setConteudo("Conteúdo de anotação atualizado.");

                            String conteudo = novaAnotacao.getConteudo();
                            System.out.println("Conteúdo: " + conteudo);

                        case 2:
                            System.out.println("\nVisualizar Agenda:");
                            Calendar calendar = Calendar.getInstance();


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
            }


        }

    }





