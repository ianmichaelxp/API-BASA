package br.com.ian.portal.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.ian.portal.model.enums.SegredoJustica;
import br.com.ian.portal.model.enums.Situacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "processo")
public class Processo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "numero", nullable = false, length = 19)
	@NonNull
	private String numero;
	
	@Column(name = "data_cadastro", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	private LocalDateTime dataCadastro = LocalDateTime.now();
	
	@Column(name = "segredo_justica", nullable = false)
	@Enumerated(EnumType.STRING)
	@NonNull
	private SegredoJustica segredoJustica;
	
	@Column(name = "situacao", nullable = false)
	@Enumerated(EnumType.STRING)
	@NonNull
	private Situacao situacao;
	
	@Column(name = "qtd_partes", nullable = false)
	@NonNull
	private Integer qtdPartes;
	
}
