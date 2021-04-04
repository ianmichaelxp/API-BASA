package br.com.ian.portal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ian.portal.model.Processo;
import br.com.ian.portal.repository.ProcessoRepository;

@Service
public class ProcessoService {

	private ProcessoRepository processoRepository;
	
	public List<Processo> listarProcessos(){
		List<Processo> processos = processoRepository.findAll();
		return processos;
	}
}
