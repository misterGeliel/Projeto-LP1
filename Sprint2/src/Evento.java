import java.time.LocalDate;

public class Evento {

    private String titulo;
    private String descricao;
    private LocalDate data;

    public Evento(String titulo, String descricao, LocalDate data) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
    }


    public Evento(LocalDate dataEvento, String descricaoEvento) {
        LocalDate dataEvent = LocalDate.of(2024, 5, 25);
        descricaoEvento = "Consulta médica";
        Evento evento = new Evento(dataEvent, descricaoEvento);
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
}