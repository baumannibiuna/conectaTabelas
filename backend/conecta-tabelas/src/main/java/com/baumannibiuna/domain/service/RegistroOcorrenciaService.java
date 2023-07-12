package com.baumannibiuna.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baumannibiuna.domain.model.Entrega;
import com.baumannibiuna.domain.model.Ocorrencia;

@Service
public class RegistroOcorrenciaService {

	@Autowired
	private BuscarEntregaService buscarEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao){
		Entrega entrega = buscarEntregaService.buscar(entregaId);	
		return entrega.adicionarOcorrencia(descricao);
	}

	public RegistroOcorrenciaService(BuscarEntregaService buscarEntregaService) {
		super();
		this.buscarEntregaService = buscarEntregaService;
	}
	
	
}
