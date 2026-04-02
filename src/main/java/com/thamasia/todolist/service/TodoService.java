package com.thamasia.todolist.service;

import com.thamasia.todolist.dto.TodoDto;
import com.thamasia.todolist.dto.TodoRespostaDto;
import com.thamasia.todolist.exception.TarefaNaoEncontradaException;
import com.thamasia.todolist.mapper.TodoMapper;
import com.thamasia.todolist.model.Todo;
import com.thamasia.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;
    private final TodoMapper mapper;

    @Transactional
    public Todo cadastrarTarefa(TodoDto dto){
        return repository.save(mapper.toEntity(dto));
    }

    public TodoRespostaDto buscarTarefaPorID(Long id){
        Todo todo = repository.findById(id).orElseThrow(() ->
                new TarefaNaoEncontradaException("Tarefa não encontrada"));

        return mapper.toDto(todo);
    }

    public List<TodoRespostaDto> listarTarefas(){
        return mapper.toDtoList(repository.findAll());
    }

    @Transactional
    public void atualizarTarefa(Long id,TodoDto dto){
        Todo todo = repository.findById(id).orElseThrow(() ->
                new TarefaNaoEncontradaException("Tarefa não encontrada"));

        todo.setNome(dto.nome());
        todo.setDescricao(dto.descricao());
        todo.setPrioridade(dto.prioridade());
        todo.setRealizado(dto.realizado());

        repository.save(todo);
    }

    @Transactional
    public void deletarTarefa(Long id){
         repository.findById(id).orElseThrow(() ->
                new TarefaNaoEncontradaException("Tarefa não encontrada"));

        repository.deleteById(id);
    }
}
