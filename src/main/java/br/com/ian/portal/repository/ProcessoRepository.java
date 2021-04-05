package br.com.ian.portal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ian.portal.model.Processo;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {

	/**
	 * Stored Procedure do banco Oracle 18c não permite retorno. 
	 * O método findByFiltroSegredo permite a consulta em Banco de dados MySql
	 * 
	 * */
	@Query(value = "CALL SP_PROCESSO(:p_segredo_justica);", nativeQuery = true)
	Page<Processo> findByFiltroSegredo(@Param("p_segredo_justica") String filtro, Pageable paginacao);
	
	/**
	 * Stored Procedure do banco Oracle 18c não permite retorno. 
	 * O método findByFiltroSituacao permite a consulta em Banco de dados MySql
	 * 
	 * */
	@Query(value = "CALL SP_SITUACAO(:p_situacao);", nativeQuery = true)
	Page<Processo> findByFiltroSitucao(@Param("p_situacao") String filtro, Pageable paginacao);
	
	
	/**
	 * Métodos de consulta do repositório da JPA
	 * */
	Page<Processo> findBySegredoJustica(String filtro, Pageable paginacao);
	
	Page<Processo> findBySituacao(String filtro, Pageable paginacao);
	
}
