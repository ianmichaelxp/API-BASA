package br.com.ian.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ian.portal.model.Processo;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {

}
