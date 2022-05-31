package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.Categoria;
import com.example.demo.services.CategoriaService;

import java.util.List;

@RestController
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@GetMapping("categorias")
	public ResponseEntity<?> getAllCategorias(){

		List<Categoria> allCategorias = service.findAllCategorias();
		return ResponseEntity.ok().body(allCategorias);
	}

	@GetMapping("/categorias/{id}")
	public ResponseEntity<?> getCategoriaById(@PathVariable Integer id) {

		Categoria obj = service.findCategoriasById(id);
		return ResponseEntity.ok().body(obj);
	}
}
