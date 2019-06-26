package com.example.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Categoria;
import com.example.algamoney.api.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscarPeloId(Long codigo) {

		Optional<Categoria> categoria = categoriaRepository.findById(codigo);

		if (!categoria.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return categoria.get();
	}

	public Categoria salvar(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public Categoria atualizar(Long codigo, Categoria categoria) {
		Categoria categoriaSalva = buscarPeloId(codigo);
		BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");

		return categoriaRepository.save(categoriaSalva);
	}
}
