package com.thamasia.todolist.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tarefas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 150)
    private String nome;

    @Column(length = 200)
    private String descricao;

    private boolean realizado;

    @Enumerated(EnumType.STRING)
    @Column(length = 10,nullable = false)
    private Prioridade prioridade;

}
