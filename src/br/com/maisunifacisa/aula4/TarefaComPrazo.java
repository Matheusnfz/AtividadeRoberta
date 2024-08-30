package br.com.maisunifacisa.aula4;

import java.time.LocalDate;


public class TarefaComPrazo extends Tarefa{

    private LocalDate prazo;



    public TarefaComPrazo(String descricao, Prioridade prioridade, LocalDate prazo) {
        super(descricao, prioridade);
        this.prazo = prazo;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    @Override
    public void executar() {
        System.out.println("A tarefa com prazo "+ this.prazo + "e descrição "+ getDescricao() + " está sendo executada.");
        setStatus(Status.doing);
    }

    @Override
    public void finalizar() {
        System.out.println("A tarefa com prazo "+ this.prazo + " e descricao "+  getDescricao() + " está finalizada");
        setStatus(Status.done);
    }

    @Override
    public String toString() {
        String statusPrazo = (LocalDate.now().isAfter(prazo)) ? "atrasada" : "dentro do prazo";
        return "Tarefa: " + getDescricao() + ", Prioridade: " + getPrioridade() + ", Prazo: " + prazo + ", Status: " + statusPrazo;
    }

}