package com.baumannibiuna.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baumannibiuna.domain.model.Entrega;
import com.baumannibiuna.domain.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {

	@Autowired
	private EntregaRepository entregaRepository;
	@Autowired
	private BuscarEntregaService buscarEntregaService;
	
			
	@Transactional
	public void finalizar(Long intregaId) {
		Entrega entrega = buscarEntregaService.buscar(intregaId);
		
		entrega.finalizar();
		
		entregaRepository.save(entrega);
	}
}
