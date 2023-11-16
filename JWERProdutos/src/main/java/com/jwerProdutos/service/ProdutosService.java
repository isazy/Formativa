package com.jwerProdutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwerProdutos.entities.Produtos;
import com.jwerProdutos.repository.ProdutosRepository;

@Service
public class ProdutosService {

	private ProdutosRepository produtosRepository = null;

	@Autowired
	public ProdutosService(ProdutosRepository pedidosRepository) {
		this.produtosRepository = produtosRepository;
	}

	public List<Produtos> getAllProdutos() {
		return produtosRepository.findAll();
	}
	public Produtos getProdutosById(Long id) {
		Optional<Produtos> produtos = produtosRepository.findById(id);
		return produtos.orElse(null);
	}

	public Produtos salvarProdutos(Produtos produtos) {
		return produtosRepository.save(produtos);
	}

	public Produtos updateProdutos(Long id, Produtos updatedProdutos) {
		Optional<Produtos> existingProdutos = produtosRepository.findById(id);
		if (existingProdutos.isPresent()) {
			return produtosRepository.save(updatedProdutos);
		}
		return null;
	}
	public boolean deleteProdutos(Long id) {
		Optional<Produtos> existingProdutos = produtosRepository.findById(id);
		if (existingProdutos.isPresent()) {
			produtosRepository.deleteById(id);
			return true;
		}
		return false;
	}
}






