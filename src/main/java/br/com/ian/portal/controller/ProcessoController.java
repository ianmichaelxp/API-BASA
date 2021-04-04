package br.com.ian.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ian.portal.controller.dto.ProcessoDTO;
import br.com.ian.portal.service.ProcessoService;

@RestController
@RequestMapping("/api/processos")
public class ProcessoController {
	
	@Autowired
	private ProcessoService processoService;
	
	@GetMapping
	public List<ProcessoDTO> obterListaProcessos(){
		List<ProcessoDTO> processosDTO = processoService.listarProcessos();
		return processosDTO;
	}

}
