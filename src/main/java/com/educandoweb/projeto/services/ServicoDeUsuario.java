package com.educandoweb.projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.projeto.entities.Usuario;
import com.educandoweb.projeto.exceptions.ResourceNotFoundException;
import com.educandoweb.projeto.repositories.RepositorioDeUsuarios;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ServicoDeUsuario {
	
	@Autowired
	private RepositorioDeUsuarios repositorio;
	
	public List<Usuario> listarTodos(){
		return repositorio.findAll();
		
	}
	public Usuario encontrarPorId(Long id) {
		Optional<Usuario>obj= repositorio.findById(id);
		
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	public Usuario inserir(Usuario usuario) {
		return repositorio.save(usuario);
	}
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
	public void atualizarDados(Usuario entidade, Usuario usuario) {
		entidade.setNome(usuario.getNome());
		entidade.setEmail(usuario.getEmail());
		entidade.setTelefone(usuario.getTelefone());
	}
	public Usuario atualizar(Long id, Usuario usuario) {
		try {
		Usuario entidade= repositorio.getReferenceById(id);
		atualizarDados(entidade,usuario);
		return repositorio.save(entidade);
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

}
