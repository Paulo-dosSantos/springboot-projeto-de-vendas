package com.educandoweb.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.projeto.entities.ItemDePedido;

public interface RepositorioItemDePedido extends JpaRepository< ItemDePedido, Long> {

}
