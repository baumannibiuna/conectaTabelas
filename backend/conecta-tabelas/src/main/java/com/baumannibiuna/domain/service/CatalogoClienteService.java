package com.baumannibiuna.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baumannibiuna.domain.exception.NegocioException;
import com.baumannibiuna.domain.model.Cliente;
import com.baumannibiuna.domain.repository.ClienteRepository;



@Service
public class CatalogoClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscar(Long clienteId) {

		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new NegocioException("Cliente nao encontrado"));

	}

	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

		if (emailEmUso) {
			throw new NegocioException("Este enail já esta em uso!!");
		}

		return clienteRepository.save(cliente);
	}

	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

}