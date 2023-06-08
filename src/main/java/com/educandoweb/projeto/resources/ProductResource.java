package com.educandoweb.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.projeto.entities.Produto;
import com.educandoweb.projeto.services.ServicoDeProdutos;

@RestController
@RequestMapping(value="/produtos")
public class ProductResource {
	
	@Autowired
	private ServicoDeProdutos servico;

	@GetMapping
	public ResponseEntity<List<Produto>> listarTodos(){
		List<Produto>usuarios= servico.listarTodos();
		
		return ResponseEntity.ok().body(usuarios);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Produto> encontrarPorId(Long id){
		Produto p= servico.encontrarPorId(id);
		
		return ResponseEntity.ok().body(p);
	}
}
