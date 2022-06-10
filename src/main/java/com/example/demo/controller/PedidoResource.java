package com.example.demo.controller;

import com.example.demo.domain.Pedido;
import com.example.demo.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping("pedidos")
	public ResponseEntity<?> getAllPedidos(){

		List<Pedido> allPedidos = pedidoService.findAllPedidos();
		return ResponseEntity.ok().body(allPedidos);
	}

	@GetMapping("/pedidos/{id}")
	public ResponseEntity<?> getPedidoById(@PathVariable Integer id) {

		Pedido obj = pedidoService.findPedidosById(id);
		return ResponseEntity.ok().body(obj);
	}
}
