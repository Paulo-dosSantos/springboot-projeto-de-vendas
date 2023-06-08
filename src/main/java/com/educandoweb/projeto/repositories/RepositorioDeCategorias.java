package com.educandoweb.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.projeto.entities.Categoria;


public interface RepositorioDeCategorias extends JpaRepository<Categoria, Long>{

}
