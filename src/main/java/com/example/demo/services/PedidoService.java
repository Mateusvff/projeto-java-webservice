package com.example.demo.services;

import com.example.demo.domain.Pedido;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> findAllPedidos() {

		List<Pedido> allPedidos = pedidoRepository.findAll();
		return allPedidos;
	}

	public Pedido findPedidosById(Integer id) { // Find a pedido by id
		Optional<Pedido> pedidos = pedidoRepository.findById(id); //Optional may or may not contain a non-null value.

		return pedidos.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}


}
