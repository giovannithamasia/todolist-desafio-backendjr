package com.thamasia.todolist.dto;

import com.thamasia.todolist.model.Prioridade;

public record TodoRespostaDto(
        Long id , String nome,String descricao,Boolean realizado,
        Prioridade prioridade
){
}
