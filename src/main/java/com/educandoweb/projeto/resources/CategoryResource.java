package com.educandoweb.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.projeto.entities.Categoria;
import com.educandoweb.projeto.services.ServicoDeCategorias;

@RestController
@RequestMapping(value="/categorias")
public class CategoryResource {
	
	@Autowired
	private ServicoDeCategorias servico;

	@GetMapping
	public ResponseEntity<List<Categoria>> listarTodos(){
		List<Categoria>categorias= servico.listarTodos();
		
		return ResponseEntity.ok().body(categorias);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> encontrarPorId(Long id){
		Categoria c= servico.encontrarPorId(id);
		
		return ResponseEntity.ok().body(c);
	}
}
