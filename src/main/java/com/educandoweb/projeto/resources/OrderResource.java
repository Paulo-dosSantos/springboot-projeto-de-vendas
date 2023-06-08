package com.educandoweb.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.projeto.entities.Pedido;
import com.educandoweb.projeto.services.ServicoDePedidos;

@RestController
@RequestMapping(value="/pedidos")
public class OrderResource {
	
	@Autowired
	private ServicoDePedidos servico;

	@GetMapping
	public ResponseEntity<List<Pedido>> listarTodos(){
		List<Pedido>pedidos= servico.listarTodos();
		
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Pedido> encontrarPorId(@PathVariable Long id){
		Pedido p= servico.encontrarPorId(id);
		
		return ResponseEntity.ok().body(p);
	}
}
