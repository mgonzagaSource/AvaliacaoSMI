package br.net.smi.lancamento.lancamento.repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.net.smi.lancamento.lancamento.models.LancamentoModel;;

@Repository
public interface LancamentoRepositorio extends JpaRepository<LancamentoModel,Long> {
    
	@Query(value="select * from lancamento_model where vencimento between ?1 and ?2",
			nativeQuery=true)
	Collection<LancamentoModel> findByStartDateBetween(LocalDate dataini, LocalDate dadtafim);
	
	@Query( value="select coalesce(sum(valor),0) from lancamento_model where tipo ='receita'", nativeQuery=true)
	double findValorReceita();
	
	@Query( value="select coalesce(sum(valor),0) from lancamento_model where tipo ='despesa'", nativeQuery=true)
	double findValorDespesa();
	
	LancamentoModel findById(int id);
	
}
