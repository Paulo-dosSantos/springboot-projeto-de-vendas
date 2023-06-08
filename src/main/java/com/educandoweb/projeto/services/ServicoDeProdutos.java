package com.educandoweb.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.projeto.entities.Produto;
import com.educandoweb.projeto.exceptions.ResourceNotFoundException;
import com.educandoweb.projeto.repositories.RepositorioDeProdutos;


@Service
public class ServicoDeProdutos {
	
	@Autowired
	private RepositorioDeProdutos repositorio;
	
	public List<Produto> listarTodos(){
		return repositorio.findAll();
		
	}
	public Produto encontrarPorId(Long id) {
		Optional<Produto>obj= repositorio.findById(id);
		
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	

}
