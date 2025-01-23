package com.example.retornosAPI.dtos;

import jakarta.validation.constraints.*;

public record ProductDTO(
        Long id,
        //Validacao nome
        @NotNull(message = "O campo nome não pode ser nulo")
        @NotEmpty(message = "O nome não pode ser vázio")
        @Size(min = 3, max = 100)
        String name,
        //Validacao do preco
        @NotNull(message = "O campo preço não pode ser nulo")
        @
        Double price,
        @NotNull(message = "O campo nome não pode ser nulo")
        @NotEmpty(message = "O nome não pode ser vázio")
        @Size(min = 3, max = 100)
        String description,
        @NotNull(message = "O campo nome não pode ser nulo")
        @Size(min = 3, max = 100)
        Integer quantity,
        @NotNull(message = "O campo nome não pode ser nulo")
        @NotEmpty(message = "O nome não pode ser vázio")
        @Size(min = 3, max = 100)
        Categories categories
        )
        {
}