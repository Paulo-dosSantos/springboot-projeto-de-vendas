package com.educandoweb.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.projeto.entities.Produto;


public interface RepositorioDeProdutos extends JpaRepository<Produto, Long>{

}
