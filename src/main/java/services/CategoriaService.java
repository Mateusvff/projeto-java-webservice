package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Categoria;
import repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {						//Find a category by id
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
