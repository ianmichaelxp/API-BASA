package br.com.ian.portal.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ian.portal.model.Processo;
import br.com.ian.portal.model.enums.SegredoJustica;
import br.com.ian.portal.model.enums.Situacao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProcessoDTO {

	private Long numero;	
	private LocalDateTime dataCadastro;	
	private SegredoJustica segredoJustica;	
	private Situacao situacao;
	private Integer qtdPartes;
	
	public ProcessoDTO(Processo processo) {
		this.numero = processo.getNumero();
		this.dataCadastro = processo.getDataCadastro();
		this.segredoJustica = processo.getSegredoJustica();
		this.situacao = processo.getSituacao();
		this.qtdPartes = processo.getQtdPartes();
	}
	
	public static List<ProcessoDTO> processoToDTO(List<Processo> processos) {
	    List<ProcessoDTO> processosDTOs = processos.stream().map(processo -> {
	        return new ProcessoDTO(processo);
	    }).collect(Collectors.toList());

	    return processosDTOs;
	}

}
