package com.thamasia.todolist.exception;

public class TarefaNaoEncontradaException extends RuntimeException {

    public TarefaNaoEncontradaException(String message) {
        super(message);
    }

    public TarefaNaoEncontradaException() {
        super("Tarefa não encontrada");
    }
}
