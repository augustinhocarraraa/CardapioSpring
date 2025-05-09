package com.papao.cardapio.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.papao.cardapio.dto.ItemCardapioDTO;
import com.papao.cardapio.model.ItemCardapio;
import com.papao.cardapio.service.ItemCardapioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cardapio")
@CrossOrigin(origins = "*") // Permite chamadas de qualquer origem (útil para frontend separado)
public class ItemCardapioController {

    private final ItemCardapioService service;

    public ItemCardapioController(ItemCardapioService service) {
        this.service = service;
    }

    // GET /api/cardapio
    @GetMapping
    public ResponseEntity<List<ItemCardapio>> listar() {
        List<ItemCardapio> itens = service.listarTodos();
        return ResponseEntity.ok(itens);
    }

    // POST /api/cardapio
    @PostMapping
    public ResponseEntity<ItemCardapio> adicionar(@Valid @RequestBody ItemCardapioDTO dto) {
        ItemCardapio novoItem = service.salvar(dto);
        return ResponseEntity.ok(novoItem);
    }

    // DELETE /api/cardapio/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
