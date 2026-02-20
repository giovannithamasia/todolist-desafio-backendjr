package com.thamasia.todolist.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record ErroResposta(int status, String mensagem, List<ErroCampo> erros) {

    public static ErroResposta naoEncontrado(String mensagem){
        return new ErroResposta(HttpStatus.NOT_FOUND.value(),mensagem,List.of());
    }
}
