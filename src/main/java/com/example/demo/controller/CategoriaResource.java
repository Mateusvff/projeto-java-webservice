package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.Categoria;
import com.example.demo.services.CategoriaService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<?> getAllCategorias(){

		List<Categoria> allCategorias = categoriaService.findAllCategorias();
		return ResponseEntity.ok().body(allCategorias);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoriaById(@PathVariable Integer id) {

		Categoria categoria = categoriaService.findCategoriasById(id);
		return ResponseEntity.ok().body(categoria);
	}

	//inserir uma nova categoria - Enviar um JSON na requisição do tipo POST e salvar no Banco de Dados

	@PostMapping
	public ResponseEntity<Void> createCategoria(@RequestBody Categoria categoria){

		categoriaService.insertCategoria(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri(); //cria uma URI para o novo registro
		return ResponseEntity.created(uri).build();

	}


}
