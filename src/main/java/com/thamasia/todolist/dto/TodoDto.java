package com.thamasia.todolist.dto;

import com.thamasia.todolist.model.Prioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TodoDto(

        @NotBlank(message = "nome não pode estar em branco ou nulo")
        @Size(max = 150,message = "nome não pode ultrapassar 150 caracteres")
        String nome,

        @Size(max = 200,message = "descrição não pode ultrapassar 200 caracteres")
        String descricao,

        @NotNull(message = "realizado não pode ser nulo")
        Boolean realizado,

        @NotNull(message = "prioridade não pode ser nula")
        @Size(max = 10,message = "prioridade não pode ultrapassar 10 caracteres")
        Prioridade prioridade
){
}
