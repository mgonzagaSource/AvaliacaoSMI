package br.net.smi.lancamento.lancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.net.smi.lancamento.lancamento.models.EmpresaModel;

@Repository
public interface EmpresaRepositorio extends JpaRepository<EmpresaModel,Integer>  {


	@Query( value="select * from empresa_model where cnpj = ?1", nativeQuery=true)
	EmpresaModel findByCnpj(String cnpj);
	
	@Query( value="select * from empresa_model where nome = ?1", nativeQuery=true)
	EmpresaModel findByNome(String nome);
	
	EmpresaModel findById(Long id);
	
}

