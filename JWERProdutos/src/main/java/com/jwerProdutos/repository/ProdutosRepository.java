package com.jwerProdutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwerProdutos.entities.Produtos;


public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

}
