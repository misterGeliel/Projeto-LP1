import java.time.LocalDate;
import java.util.Calendar;

public class Evento {

    private String titulo;
    private String descricao;
    private LocalDate data;
    private String conteudo;

    public Evento(String titulo, String descricao, LocalDate data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
    }


    public Evento(LocalDate dataEvento, String descricaoEvento, String titulo, String descricao) {
        LocalDate dataEvent = LocalDate.of(2024, 5, 25);
        descricaoEvento = "Consulta médica";
        Evento evento = new Evento(dataEvent, descricaoEvento, titulo, descricao);
    }


    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                '}';
    }


    public LocalDate getDataEvento() {
        return null;
    }

    public String getHora() {
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY); // 24-hour format
        // You can also use Calendar.HOUR if you prefer 12-hour format (0-11)
        return String.format("%02d", hora); // Format hour with leading zero (00-23)
    }


    public String getConteudo() {
        return this.conteudo;
    }
}