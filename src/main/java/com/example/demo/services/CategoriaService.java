package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public List<Categoria> findAllCategorias() {

		List<Categoria> allCategorias = repo.findAll();
		return allCategorias;
	}

	public Categoria findCategoriasById(Integer id) { // Find a category by id
		Optional<Categoria> categorias = repo.findById(id); //Optional may or may not contain a non-null value.

		return categorias.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
