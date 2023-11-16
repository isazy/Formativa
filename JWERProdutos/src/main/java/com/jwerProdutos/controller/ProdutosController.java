package com.jwerProdutos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwerProdutos.entities.Produtos;
import com.jwerProdutos.service.ProdutosService;

import jakarta.validation.Valid;

public class ProdutosController {

	@Tag(name = "Produtos", description = "API REST DE GERENCIAMENTO DE Produtos")
	@RestController
	@RequestMapping("/Produtos")	
	

		private final ProdutosService produtosService;

		@Autowired
		public ProdutosController(ProdutosService produtosService) {
			this.produtosService = produtosService;
		}

		@GetMapping("/{id}")
		public ResponseEntity<Produtos> getProductById(@PathVariable Long id) {
			Produtos produtos = ProdutosService.getProdutosById(id);
			if (produtos != null) {
				return ResponseEntity.ok(produtos);

			} else {
				return ResponseEntity.notFound().build();

			}
		}

		@GetMapping("/")
		public ResponseEntity<List<Produtos>> getAllProdutos() {
			List<Produtos> Produtos = ProdutosService.getAllProdutos();
			return ResponseEntity.ok(Produtos);
		}

		@PostMapping("/")
		public ResponseEntity<Produtos> criarProdutos(@RequestBody @Valid Produtos produtos) {
			Produtos criarProdutos = ProdutosService.salvarProdutos(Produtos);
			return ResponseEntity.status(HttpStatus.CREATED).body(criarProdutos);
		}

		@PutMapping("/{id}")
		public ResponseEntity<Produtos> updatecProdutos(@PathVariable Long id, @RequestBody @Valid Produtos Produtos) {
			Produtos updatedPedido = ProdutosService.updateProdutos(id, Produtos);
			if (updatedProdutos != null) {
				return ResponseEntity.ok(updatedProdutos);
			} else {
				return ResponseEntity.notFound().build();
			}
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<String> deleteProdutos(@PathVariable Long id) {
			boolean deleted = ProdutosService.deleteProdutos(id);
			if (deleted) {
				return ResponseEntity.ok().body("O Produtos foi excluído com sucesso.");
			} else {
				return ResponseEntity.notFound().build();
			}
		}
	}

}
