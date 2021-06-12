package mz.ac.isutc.projeto_exame;

import java.util.Calendar;
public class Evento {
    private int duracao;
    private String descricao;
    private String tipo_de_evento;
    private Calendar hora;
    private Calendar data;

    public Evento() {
    }

    public Evento(int duracao, String descricao, String tipo_de_evento, Calendar hora, Calendar data) {
        this.duracao = duracao;
        this.descricao = descricao;
        this.tipo_de_evento = tipo_de_evento;
        this.hora = hora;
        this.data = data;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo_de_evento() {
        return tipo_de_evento;
    }


    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
}
