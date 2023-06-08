package com.educandoweb.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.projeto.entities.Pedido;
import com.educandoweb.projeto.repositories.RepositorioDePedidos;


@Service
public class ServicoDePedidos {
	
	@Autowired
	private RepositorioDePedidos repositorio;
	
	public List<Pedido> listarTodos(){
		return repositorio.findAll();
		
	}
	public Pedido encontrarPorId(Long id) {
		Optional<Pedido>obj= repositorio.findById(id);
		
		return obj.get();
	}

	

}
