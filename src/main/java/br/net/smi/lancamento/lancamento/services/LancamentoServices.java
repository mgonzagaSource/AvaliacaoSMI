package br.net.smi.lancamento.lancamento.services;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.smi.lancamento.lancamento.models.LancamentoModel;
import br.net.smi.lancamento.lancamento.repository.LancamentoRepositorio;

@Service
public class LancamentoServices {

	@Autowired
	LancamentoRepositorio lancamentoRepositorio;

	public Collection<LancamentoModel> listarLancamentos() {

		return lancamentoRepositorio.findAll();
	}

	public Collection<LancamentoModel> filtarLancamentosPorData(LocalDate dataini, LocalDate datafin) {

		return lancamentoRepositorio.findByStartDateBetween(dataini, datafin);
	}

	public LancamentoModel salvar(LancamentoModel lancamento) {

		return lancamentoRepositorio.save(lancamento);

	}

	public void excluir(LancamentoModel lancamento) {
		lancamentoRepositorio.delete(lancamento);
	}

	public LancamentoModel getLancamento(Long id) {
		return lancamentoRepositorio.getOne(id);
	}

	public Double mostrarSaldo() {
		return (lancamentoRepositorio.findValorReceita() - 
				lancamentoRepositorio.findValorDespesa());
	}
}
