package com.papao.cardapio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.papao.cardapio.dto.ItemCardapioDTO;
import com.papao.cardapio.model.ItemCardapio;
import com.papao.cardapio.repository.ItemCardapioRepository;

@Service
public class ItemCardapioService {

    private final ItemCardapioRepository repository;

    public ItemCardapioService(ItemCardapioRepository repository) {
        this.repository = repository;
    }

    public List<ItemCardapio> listarTodos() {
        return repository.findAll();
    }

    public ItemCardapio salvar(ItemCardapioDTO dto) {
        ItemCardapio item = new ItemCardapio(null, dto.nome(), dto.descricao(), dto.preco());
        return repository.save(item);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
