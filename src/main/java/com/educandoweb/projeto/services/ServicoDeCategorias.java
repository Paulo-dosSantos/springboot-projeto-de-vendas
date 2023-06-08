package com.educandoweb.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.projeto.entities.Categoria;
import com.educandoweb.projeto.exceptions.ResourceNotFoundException;
import com.educandoweb.projeto.repositories.RepositorioDeCategorias;


@Service
public class ServicoDeCategorias {
	
	@Autowired
	private RepositorioDeCategorias repositorio;
	
	public List<Categoria> listarTodos(){
		return repositorio.findAll();
		
	}
	public Categoria encontrarPorId(Long id) {
		Optional<Categoria>obj= repositorio.findById(id);
		
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	

}
