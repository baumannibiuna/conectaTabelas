package com.baumannibiuna.domain.service;

import org.springframework.stereotype.Service;

import com.baumannibiuna.domain.exception.EntidadeNaoEncontradaException;
import com.baumannibiuna.domain.model.Entrega;
import com.baumannibiuna.domain.repository.EntregaRepository;

@Service
public class BuscarEntregaService {
	
	private EntregaRepository entregaRepository;

	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}

	public BuscarEntregaService(EntregaRepository entregaRepository) {
		super();
		this.entregaRepository = entregaRepository;
	}
	
	
}
