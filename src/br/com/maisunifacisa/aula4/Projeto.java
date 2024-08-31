package br.com.maisunifacisa.aula4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Projeto {

    private String nome;
    private LocalDate inicio;
    private LocalDate fim;
    private ArrayList<Executavel> tarefas;

    public Projeto(String nome, LocalDate inicio, LocalDate fim) {
        this.nome = nome;
        this.inicio = inicio;
        this.fim = fim;
        tarefas = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getInicio() {
        return inicio;
    }
    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }
    public LocalDate getFim() {
        return fim;
    }
    public void setFim(LocalDate fim) {
        this.fim = fim;
    }
    public ArrayList<Executavel> getTarefas() {
        return tarefas;
    }
    public void setTarefas(ArrayList<Executavel> tarefas) {
        this.tarefas = tarefas;
    }

    public void addTarefas(Executavel tarefa) {

        if(tarefa instanceof TarefaComPrazo) {
            if(((TarefaComPrazo)tarefa).getPrazo().isBefore(this.inicio) || ((TarefaComPrazo)tarefa).getPrazo().isAfter(fim)) {
                System.out.println("Não é possivel adicionar a tarefa");
            } else {
                if (((Tarefa) tarefa).getStatus() == Tarefa.Status.todo) {
                this.tarefas.add(tarefa);
            }
        } else {
            System.out.println("Não é possível adicionar a tarefa com status diferente de TODO.");
        }
    }

    @Override
    public String toString() {
        String retorno = "";
        retorno = "O projeto " + getNome() + " com data de inicio " + getInicio()+ " e data de fim "+ getFim() + "\n";
        if (!tarefas.isEmpty()) {
            for (Executavel executavel : tarefas) {
                retorno += executavel.toString() + "\n";
            }
        }
        return retorno;
    }

}
