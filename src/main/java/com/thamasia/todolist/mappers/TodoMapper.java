package com.thamasia.todolist.mappers;

import com.thamasia.todolist.dtos.TodoRequestDto;
import com.thamasia.todolist.dtos.TodoResponseDto;
import com.thamasia.todolist.model.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    Todo toEntity(TodoRequestDto dto);

    TodoResponseDto toDto(Todo todo);

    List<TodoResponseDto> toDtoList (List<Todo> todos);
}
