package com.papao.cardapio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ItemCardapioDTO(

    @NotBlank(message = "Nome é obrigatório")
    String nome,

    @NotBlank(message = "Descrição é obrigatória")
    String descricao,

    @Positive(message = "Preço deve ser maior que zero")
    double preco
) {}