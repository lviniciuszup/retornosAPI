package com.example.retornosAPI.dtos;

import com.example.retornosAPI.models.Categories;
import com.example.retornosAPI.validations.GreaterOrEqualsToZero;
import com.example.retornosAPI.validations.GreaterThanZero;
import jakarta.validation.constraints.*;

public record ProductDTO(
        Long id,
        //Validacao nome
        @NotNull(message = "O campo nome não pode ser nulo")
        @NotEmpty(message = "O nome não pode ser vázio")
        @Size(min = 3, max = 100)
        String name,
        //Validacao do preco
        @GreaterThanZero
        Double price,
        //Validacao da descricao
        @NotNull(message = "O campo descrição não pode ser nulo")
        @Size( max = 500)
        String description,
        //Validacao da quantidade
        @GreaterOrEqualsToZero
        Integer quantity,
        //Validacao da categoria
        @NotNull(message = "O campo categoria não pode ser nulo")
        Categories categories
        )
        {
}