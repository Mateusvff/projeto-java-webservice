package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Produto;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> findAllCategorias() {

		List<Categoria> allCategorias = categoriaRepository.findAll();
		return allCategorias;
	}

	public Categoria findCategoriasById(Integer id) { // Find a category by id
		Optional<Categoria> categorias = categoriaRepository.findById(id); //Optional may or may not contain a non-null value.

		return categorias.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	//salvar o novo objeto categoria desserializado no banco de dados

	public void insertCategoria(Categoria categoria) {
		 categoria.setId(null);
		 categoriaRepository.save(categoria);
	}
}
