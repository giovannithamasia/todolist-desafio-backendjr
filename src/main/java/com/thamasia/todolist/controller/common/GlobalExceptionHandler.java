package com.thamasia.todolist.controller.common;

import com.thamasia.todolist.dto.ErroCampo;
import com.thamasia.todolist.dto.ErroResposta;
import com.thamasia.todolist.exceptions.TarefaNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResposta handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getFieldErrors();

        List<ErroCampo> listaErros = fieldErrors.
                stream()
                .map(fe -> new ErroCampo(fe.getField(),
                        fe.getDefaultMessage()))
                .collect(Collectors.toList());

        return new ErroResposta(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Erro de validação",
                listaErros);
    }

    @ExceptionHandler(TarefaNaoEncontradaException.class)
    public ResponseEntity<ErroResposta> handleTarefaNaoEncontradaException(TarefaNaoEncontradaException e){
        ErroResposta erro = ErroResposta.naoEncontrado(e.getMessage());
        return ResponseEntity.status(erro.status()).body(erro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResposta> handleException(Exception e){
        ErroResposta erro = ErroResposta.erroInternoServidor
                ("Erro interno do servidor");

        return ResponseEntity.status(erro.status()).body(erro);
    }
}
