package com.thamasia.todolist.service;

import com.thamasia.todolist.dto.TodoDto;
import com.thamasia.todolist.dto.TodoRespostaDto;
import com.thamasia.todolist.exceptions.TarefaNaoEncontradaException;
import com.thamasia.todolist.mappers.TodoMapper;
import com.thamasia.todolist.model.Todo;
import com.thamasia.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {

    private final TodoRepository repository;
    private final TodoMapper mapper;

    public TodoService(TodoRepository repository, TodoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public Todo cadastrarTarefa(TodoDto dto){
        return repository.save(mapper.toEntity(dto));
    }

    public TodoRespostaDto buscarTarefaPorID(Long id){
        Todo todo = repository.findById(id).orElseThrow(() ->
                new TarefaNaoEncontradaException("Tarefa não encontrada"));

        return mapper.toDto(todo);
    }
}
