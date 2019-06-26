package com.example.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa buscarPeloId(Long codigo) {

		Optional<Pessoa> pessoa = pessoaRepository.findById(codigo);

		if (!pessoa.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoa.get();
	}

	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPeloId(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");

		return pessoaRepository.save(pessoaSalva);

	}

	public void atualiarPropriedadeAtivo(long codigo, Boolean ativo) {
		Pessoa pessoaSalva = buscarPeloId(codigo);
		pessoaSalva.setAtivo(ativo);
		salvar(pessoaSalva);
	}
}
