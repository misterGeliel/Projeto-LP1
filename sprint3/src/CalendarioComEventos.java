import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalendarioComEventos {
    private static final String CAMINHO_ARQUIVO_EVENTOS = "eventos.txt";
    private static final DateTimeFormatter FORMATADOR_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public List<Evento> eventos;

    public CalendarioComEventos() {
        String caminhoArquivoEventos = "";
        this.eventos = carregarEventosDoArquivo(caminhoArquivoEventos);
    }

    private List<Evento> carregarEventosDoArquivo(String caminhoArquivoEventos) {
        List<Evento> eventosCarregados = new ArrayList<>();
        try (Scanner leitor = new Scanner(new File(caminhoArquivoEventos))) {
            while (leitor.hasNextLine()) {
                String linhaEvento = leitor.nextLine();
                String[] dadosEvento = linhaEvento.split(",");

                if (dadosEvento.length >= 3) {
                    String titulo = dadosEvento[0];
                    String descricao = dadosEvento[1];
                    String dataString = dadosEvento[2];

                    LocalDate dataEvento = LocalDate.parse(dataString, FORMATADOR_DATA);
                    eventosCarregados.add(new Evento(titulo, descricao, dataEvento));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao abrir arquivo de eventos: " + e.getMessage());
        }

        return eventosCarregados;
    }

    public String gerarCalendario(int ano, int mes) {
        StringBuilder calendarioBuilder = new StringBuilder();


        calendarioBuilder.append(String.format("%-30s", "Calendário - " + LocalDate.of(ano, mes, 1).format(FORMATADOR_DATA)))
                .append("\n");
        calendarioBuilder.append("+--------------------------------------------------------------------------+\n");

        calendarioBuilder.append("| Dom | Seg | Ter | Qua | Qui | Sex | Sab |")
                .append("\n");
        calendarioBuilder.append("+--------------------------------------------------------------------------+\n");


        int dia = 1;
        int semana = 1;
        int numeroDiasMes = calcularNumeroDiasMes(mes, ano);
        while (dia <= numeroDiasMes) {
            calendarioBuilder.append(String.format("| %2d ", dia));


            if (temEventoAgendado(dia, mes, ano)) {
                calendarioBuilder.append("(Evento)");
            } else {
                calendarioBuilder.append("     ");
            }


            if (dia % 7 == 0 || dia == numeroDiasMes) {
                calendarioBuilder.append(" |\n");
                semana++;
            }

            dia++;
        }

        calendarioBuilder.append("+--------------------------------------------------------------------------+\n");

        return calendarioBuilder.toString();
    }

    public boolean temEventoAgendado(int dia, int mes, int ano) {
        LocalDate dataEvento = LocalDate.of(ano, mes, dia);

        for (Evento evento : eventos) {
            if (evento.getData().equals(dataEvento)) {
                return true;
            }
        }

        return false;
    }

    private static int calcularNumeroDiasMes(int mes, int ano) {
        switch (mes) {
            case 2:
                if (isAnoBissexto(ano)) {
                    return 29;
                } else {
                    return 28;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }
    private static boolean isAnoBissexto(int ano) {
        return (ano % 4 == 0) && (ano % 100 != 0 || ano % 400 == 0);
    }


}