package com.thamasia.todolist.controller;

import com.thamasia.todolist.dto.TodoDto;
import com.thamasia.todolist.dto.TodoRespostaDto;
import com.thamasia.todolist.model.Todo;
import com.thamasia.todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid TodoDto dto){
        Todo todo = service.cadastrarTarefa(dto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(todo.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoRespostaDto> buscarTarefa(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.buscarTarefaPorID(id));
    }

    @GetMapping
    public ResponseEntity<List<TodoRespostaDto>> listar(){
        return ResponseEntity.ok(service.listarTarefas());
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id,
                                          @RequestBody @Valid TodoDto dto){
        service.atualizarTarefa(id,dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        service.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
