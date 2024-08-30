package br.com.maisunifacisa.aula4;

public abstract class Tarefa implements Executavel{

    private String descricao;
    private Status status;
    private Prioridade prioridade;

    protected enum Status{todo, doing, done};
    protected enum Prioridade{baixa, media, alta}

    public Tarefa(String descricao, Prioridade prioridade) {
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = Status.todo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Prioridade getPrioridade() {
        return prioridade;
    }
    public void setPrioridade(Prioridade media) {
        this.prioridade = prioridade;
    };


    @Override
    public String toString() {
        String retorno = "A tarefa com descricao "+ this.descricao + " tem priodade "+ this.prioridade + " e status " + this.status;
        return retorno;
    }
    @Override
    public void executar() {
        System.out.println("A tarefa "+ this.descricao + " está sendo executada");
        setStatus(Status.doing);
    }

    public void executar(String nome) {
        System.out.println("A tarefa" + this.descricao + "está sendo executada por "+ nome);
    }
    @Override
    public void finalizar() {
        System.out.println("A tarefa "+ this.descricao + " foi finalizada");
        setStatus(Status.done);

    }
}
