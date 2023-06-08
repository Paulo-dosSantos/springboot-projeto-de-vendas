package com.educandoweb.projeto.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.projeto.entities.Categoria;
import com.educandoweb.projeto.entities.ItemDePedido;
import com.educandoweb.projeto.entities.Pagamento;
import com.educandoweb.projeto.entities.Pedido;
import com.educandoweb.projeto.entities.Produto;
import com.educandoweb.projeto.entities.Usuario;
import com.educandoweb.projeto.enums.StatusDoPedido;
import com.educandoweb.projeto.repositories.RepositorioDeCategorias;
import com.educandoweb.projeto.repositories.RepositorioDePedidos;
import com.educandoweb.projeto.repositories.RepositorioDeProdutos;
import com.educandoweb.projeto.repositories.RepositorioDeUsuarios;
import com.educandoweb.projeto.repositories.RepositorioItemDePedido;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private RepositorioDeUsuarios repositorioDeUsuario;
	@Autowired
	private RepositorioDePedidos repositorioDePedidos;
	
	@Autowired
	private RepositorioDeProdutos repositorioDeProdutos;
	
	@Autowired
	private RepositorioDeCategorias repositorioDeCategorias;
	
	@Autowired
	private RepositorioItemDePedido repositorioItens;
	
	@Override
	public void run(String... args) throws Exception {
		Produto p1= new Produto(null, "O senhor dos anéis", "Lorem ipsum dolor sit amet, consectetur", 90.5	, "");
		Produto p2= new Produto(null, "Smart TV", "nulla eu imperdiet purus. Maecenas ante", 2190.0, "");
		Produto p3= new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis", 1250.0, "");
		Produto p4= new Produto(null,"PC Gamer","Donec aliquet odio ac rhoncus cursus",1200.0,"");
		Produto p5= new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel fauvibus", 100.99, "");
		
		Usuario u1= new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2= new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido ped1= new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),StatusDoPedido.PAGO, u1);
		Pedido ped2= new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),StatusDoPedido.AGUARDANDO_PAGAMENTO, u2);
		Pedido ped3= new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),StatusDoPedido.AGUARDANDO_PAGAMENTO, u1);
		
		
		Categoria c1= new Categoria(null, "Eletrônica");
		Categoria c2= new Categoria(null, "Livros");
		Categoria c3= new Categoria(null, "Computadores");
		
		
		
		
		
		
		
		
		repositorioDeUsuario.saveAll(Arrays.asList(u1,u2));
		repositorioDePedidos.saveAll(Arrays.asList(ped1,ped2,ped3));
		repositorioDeProdutos.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		repositorioDeCategorias.saveAll(Arrays.asList(c1,c2,c3));
		
		
		p1.getCategorias().add(c2);
		p2.getCategorias().add(c1);
		p2.getCategorias().add(c3);
		p3.getCategorias().add(c3);
		p4.getCategorias().add(c3);
		p5.getCategorias().add(c2);
		
		repositorioDeProdutos.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		ItemDePedido oi1 = new ItemDePedido(ped1, p1, 2, p1.getPreco());
		ItemDePedido oi2 = new ItemDePedido(ped1, p3, 1, p3.getPreco());
		ItemDePedido oi3 = new ItemDePedido(ped2, p3, 2, p3.getPreco());
		ItemDePedido oi4 = new ItemDePedido(ped3, p5, 2, p5.getPreco()); 
		
		repositorioItens.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		Pagamento pag1= new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), ped1);
		ped1.setPagamento(pag1);
		
		
		
		repositorioDePedidos.save(ped1);
		
	}

}
