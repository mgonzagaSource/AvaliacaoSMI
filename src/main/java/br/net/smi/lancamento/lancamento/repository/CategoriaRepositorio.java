package br.net.smi.lancamento.lancamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.net.smi.lancamento.lancamento.models.CategoriaModel;

@Repository
public interface CategoriaRepositorio extends JpaRepository<CategoriaModel,Integer>  {

	CategoriaModel findById( Long id);
}

