package com.educandoweb.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.projeto.entities.Usuario;


public interface RepositorioDeUsuarios extends JpaRepository<Usuario, Long>{

}
