package br.com.ian.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ian.portal.controller.dto.ProcessoDTO;
import br.com.ian.portal.model.Processo;
import br.com.ian.portal.repository.ProcessoRepository;

@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository processoRepository;
	
	public List<ProcessoDTO> listarProcessos(){
		List<Processo> processos = processoRepository.findAll();
		List<ProcessoDTO> processoDTOs = ProcessoDTO.processoToDTO(processos);
		return processoDTOs;

	}
}
