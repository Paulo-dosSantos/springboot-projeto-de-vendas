package com.educandoweb.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.projeto.entities.Pedido;


public interface RepositorioDePedidos extends JpaRepository<Pedido, Long>{

}
