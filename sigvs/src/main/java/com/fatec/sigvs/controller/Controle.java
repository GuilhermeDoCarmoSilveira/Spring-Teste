package com.fatec.sigvs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.sigvs.model.Cliente;

@RestController
public class Controle {

	@GetMapping("/alo-mundo")
	public String aloMundo() {
		return ("Alo mundo!");
	}

	@GetMapping("/clientes")
	public Cliente getCliente() {
		Cliente cliente = new Cliente(1, "Guilherme", "Av. Líder");
		return cliente;
	}

	@GetMapping("/clientes-todos")
	public List<Cliente> getAll(){
		List<Cliente> lista = new ArrayList<>();
		lista.add(new Cliente(1, "Guilherme", "Av. Líder"));
		lista.add(new Cliente(2, "Kauan", "Av. Paulista"));
		lista.add(new Cliente(3, "Gustavo", "Av. Aguia de Haia"));
		return lista;
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente getClientePorId(@PathVariable ("id") int id) {
		return new Cliente(id, "Souza", "Av. Radial Leste");
	}
	
	@PostMapping("/clientes")
	public Cliente cadastrarCliente(@RequestBody Cliente cliente) {
		List<Cliente> lista = new ArrayList<>();
		lista.add(new Cliente(1, cliente.getNome(), cliente.getEndereço()));
		return lista.get(0);
	}
	
	@GetMapping("/clientes1")
	public ResponseEntity<Cliente> obtemCliente() {
		Cliente cliente = new Cliente(1, "Guilherme", "Av. Líder");
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/clientes/{id}/update")
	public Cliente atualizar(@RequestBody Cliente cliente, @PathVariable ("id") int id) {
		Cliente clienteAtualizado = new Cliente(id, cliente.getNome(), cliente.getEndereço());
		return clienteAtualizado;
	}
	
	@DeleteMapping("/clientes/{id}/delete")
	public String deletar(@PathVariable ("id") int id) {
		return "Cliente " + id + " excluido com sucesso ";
	}

}
