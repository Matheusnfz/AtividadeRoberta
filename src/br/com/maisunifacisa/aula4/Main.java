package br.com.maisunifacisa.aula4;

import java.time.LocalDate;

import br.com.maisunifacisa.aula4.Tarefa.Prioridade;

public class Main {

    public static void main(String args[]) {


        //Instância de tarefa simples utilizando a classe abstrata
        Tarefa a1 = new TarefaSimples("Tarefa 1", Prioridade.baixa);
        System.out.println(a1.toString());
        a1.executar("Andrey");
        a1.setPrioridade(Tarefa.Prioridade.media);
        System.out.println(a1.toString());
        a1.finalizar();


        //Instância de tarefa simples utilizando a interface
        Executavel a2 = new TarefaSimples("Tarefa 2", Prioridade.alta);
        System.out.println(a2.toString());
        //Por que a linha comentada abaixo gera um erro? Neste caso, o que você faria se mudar a prioridade fosse importante para seu problema?
        //a2.setPrioridade(Prioridade.media);
        //RESPOSTA: Pois não tem sentido adicionar um metódo setPrioridade no a2 que está no Executavel
        a2.executar();
        System.out.println(a2.toString());
        a2.finalizar();

        System.out.println("----------------------------------------");


        //Instância de tarefaComPrazo
        Executavel a3 = new TarefaComPrazo("Tarefa 3", Tarefa.Prioridade.media, LocalDate.of(2024, 11, 11));
        System.out.println(a3.toString());
        //Modifique o código para mostrar o prazo em casos de objetos de TarefaComprazo
        a3.executar();
        System.out.println(a3.toString());
        //Modificar o código para mostrar se a tarefa está dentro do prazo ou atrasada
        a3.finalizar();
        System.out.println();
        //Modificar o código para mostrar se a tarefa foi finazlizado no prazo ou atrasada

        Projeto p1 = new Projeto("Projeto OO", LocalDate.of(2024, 9, 10), LocalDate.of(2024,11,30));
        p1.addTarefas(a1);
        p1.addTarefas(a2);
        p1.addTarefas(a3);

        System.out.println(p1.toString());
    }

}