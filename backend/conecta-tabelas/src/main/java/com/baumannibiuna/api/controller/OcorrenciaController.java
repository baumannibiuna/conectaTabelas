package com.baumannibiuna.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.baumannibiuna.api.assembler.OcorrenciaAssembler;
import com.baumannibiuna.api.model.OcorrenciaModel;
import com.baumannibiuna.api.model.input.OcorrenciaInput;
import com.baumannibiuna.domain.model.Entrega;
import com.baumannibiuna.domain.model.Ocorrencia;
import com.baumannibiuna.domain.service.BuscarEntregaService;
import com.baumannibiuna.domain.service.RegistroOcorrenciaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	@Autowired
	private BuscarEntregaService buscarEntregaService;
	@Autowired
	private RegistroOcorrenciaService registroOcorrenciaService;
	@Autowired
	private OcorrenciaAssembler ocorrenciaAssembler;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaModel registrar(@PathVariable Long entregaId, 
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		
		Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
				.registrar(entregaId, ocorrenciaInput.getDescricao());
		
		return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);
	}
	
	@GetMapping
	public java.util.List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
		
		Entrega entrega = buscarEntregaService.buscar(entregaId);
		
		return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
	}

//	public OcorrenciaController(BuscarEntregaService buscarEntregaService, 
//			RegistroOcorrenciaService registroOcorrenciaService,
//			OcorrenciaAssembler ocorrenciaAssembler) {
//		super();
//		this.buscarEntregaService = buscarEntregaService;		
//		this.registroOcorrenciaService = registroOcorrenciaService;
//		this.ocorrenciaAssembler = ocorrenciaAssembler;
//	}

	
}
