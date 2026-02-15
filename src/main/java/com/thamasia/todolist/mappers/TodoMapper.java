package com.thamasia.todolist.mappers;

import com.thamasia.todolist.dto.TodoDto;
import com.thamasia.todolist.dto.TodoRespostaDto;
import com.thamasia.todolist.model.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    Todo toEntity(TodoDto dto);

    TodoRespostaDto toDto(Todo todo);

    List<TodoRespostaDto> toDtoList (List<Todo> todos);
}
