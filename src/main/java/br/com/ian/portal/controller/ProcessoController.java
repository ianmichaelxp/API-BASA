package br.com.ian.portal.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<ProcessoDTO> obterProcesso(@PathVariable(value="id") Long id) {		
		ProcessoDTO processoDTOs = processoService.obterProcessoPorId(id);		
		return ResponseEntity.ok(processoDTOs);
	}
	
	@PostMapping
	public ResponseEntity<ProcessoDTO> criarProcesso(@Valid @RequestBody ProcessoDTO processoDTO) throws URISyntaxException{
		ProcessoDTO processo = processoService.salvarProcesso(processoDTO);
		return ResponseEntity.created(new URI("/processos")).body(processo);
	}
	
	

}
