package br.com.ian.portal.controller.dto;

import java.time.LocalDateTime;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonFormat;

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

	private String numero;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
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

	public static Page<ProcessoDTO> processoToDTO(Page<Processo> processos) {
		Page<ProcessoDTO> processosDTOs = processos.map(processo -> {
			return new ProcessoDTO(processo);
		});

		return processosDTOs;
	}

	public static Processo processoToEntity(@Valid ProcessoDTO dto) {
		Processo processo = new Processo(dto.getNumero(), dto.getSegredoJustica(), dto.getSituacao(),
				dto.getQtdPartes());
		return processo;
	}

}
