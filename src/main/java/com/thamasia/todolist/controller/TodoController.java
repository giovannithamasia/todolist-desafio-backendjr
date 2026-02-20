package com.thamasia.todolist.controller;

import com.thamasia.todolist.dto.ErroResposta;
import com.thamasia.todolist.dto.TodoDto;
import com.thamasia.todolist.dto.TodoRespostaDto;
import com.thamasia.todolist.model.Todo;
import com.thamasia.todolist.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @PostMapping
    @Operation(description = "Cadastrar a tarefa")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "retorna um header location " +
                            "indicando que a tarefa foi criada"),
            @ApiResponse(responseCode = "422",
            description = "Erro de validacao",
            content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErroResposta.class))
            })
    })
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
    @Operation(description = "buscar tarefa pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "retorna a tarefa encontrada pelo id"),
            @ApiResponse(responseCode = "404",
                    description = "A tarefa não foi encontrada com id informado",
                    content = {
                            @Content
                                    (mediaType = "application/json",
                                            schema = @Schema(implementation = ErroResposta.class))})
    })
    public ResponseEntity<TodoRespostaDto> buscarTarefa(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.buscarTarefaPorID(id));
    }

    @GetMapping
    @Operation(description = "listar todas as tarefas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "listar todas as tarefas criadas")
    })
    public ResponseEntity<List<TodoRespostaDto>> listar(){
        return ResponseEntity.ok(service.listarTarefas());
    }

    @PutMapping("{id}")
    @Operation(description = "atualizar tarefa pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "tarefa atualizada com sucesso"),
            @ApiResponse(responseCode = "404",
                    description = "A tarefa não foi encontrada com id informado",
            content = {
                    @Content
                     (mediaType = "application/json",
                     schema = @Schema(implementation = ErroResposta.class)) }),
            @ApiResponse(responseCode = "422",
                    description = "Erro de validacao",
            content = {
                    @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErroResposta.class))
            })
    })
    public ResponseEntity<Void> atualizar(@PathVariable("id") Long id,
                                          @RequestBody @Valid TodoDto dto){
        service.atualizarTarefa(id,dto);
        return ResponseEntity.noContent().build();
    }

    @Operation(description = "deletar tarefa pelo id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "tarefa deletada com sucesso"),
            @ApiResponse(responseCode = "404",
                    description = "A tarefa não foi encontrada com id informado",
                    content = {
                            @Content
                                    (mediaType = "application/json",
                                            schema = @Schema(implementation = ErroResposta.class)) })
    })
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
        service.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
