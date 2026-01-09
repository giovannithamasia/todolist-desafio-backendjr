package com.thamasia.todolist.dtos;

import com.thamasia.todolist.model.Prioridade;

public record TodoResponseDto (
        Long id , String nome,String descricao,Boolean realizado,
        Prioridade prioridade
){
}
