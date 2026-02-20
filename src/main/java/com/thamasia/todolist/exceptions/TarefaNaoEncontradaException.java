package com.thamasia.todolist.exceptions;

public class TarefaNaoEncontradaException extends RuntimeException {

    public TarefaNaoEncontradaException(String message) {
        super(message);
    }

    public TarefaNaoEncontradaException() {
        super("Tarefa não encontrada");
    }
}
