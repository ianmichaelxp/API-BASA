package br.com.ian.portal.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ian.portal.controller.dto.ProcessoDTO;
import br.com.ian.portal.service.ProcessoService;

@RestController
@RequestMapping("/api/processos")
public class ProcessoController {
	
	@Autowired
	private ProcessoService processoService;
	
	@GetMapping
	public Page<ProcessoDTO> obterListaProcessos(@RequestParam(required = false) String filtro, 
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){
		Page<ProcessoDTO> processosDTO = processoService.listarProcessos(filtro, paginacao);
		return processosDTO;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProcessoDTO> obterProcesso(@PathVariable(value="id") Long id) {		
		ProcessoDTO processoDTO = processoService.obterProcessoPorId(id);		
		return ResponseEntity.ok(processoDTO);
	}
	
	@PostMapping
	public ResponseEntity<ProcessoDTO> criarProcesso(@Valid @RequestBody ProcessoDTO processoDTO) throws URISyntaxException{
		ProcessoDTO processo = processoService.salvarProcesso(processoDTO);
		return ResponseEntity.created(new URI("/processos")).body(processo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProcessoDTO> atualizarProcesso(@PathVariable Long id, @RequestBody @Valid ProcessoDTO processoDTO) {		
		ProcessoDTO dto = processoService.editarProcesso(id, processoDTO);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerProcesso(@PathVariable Long id) {
		processoService.excluirProcesso(id);	
		return ResponseEntity.ok().build();
	}
	
}
