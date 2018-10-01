package br.net.smi.lancamento.lancamento.controllers;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.net.smi.lancamento.lancamento.models.LancamentoModel;
import br.net.smi.lancamento.lancamento.services.LancamentoServices;;

@RestController
public class LancamentoControllers {
	
	@Autowired
	LancamentoServices lancamentoServices;
	private final String path ="/lancamentos";
	
	//end point
	@RequestMapping(method=RequestMethod.POST, value=path, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LancamentoModel> cadastrarLancamento(@RequestBody LancamentoModel lancamento){
		LancamentoModel lancCadastrado =  lancamentoServices.salvar(lancamento);
		return new ResponseEntity<>(lancCadastrado, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value=path+"/{id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LancamentoModel> alterarLancamento(@RequestBody LancamentoModel lancamento){
		LancamentoModel lancAlterado =  lancamentoServices.salvar(lancamento);
		return new ResponseEntity<>(lancAlterado, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value=path, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<LancamentoModel>> obterLancamentos(){
		Collection<LancamentoModel> lstLanc =  lancamentoServices.listarLancamentos();
		return new ResponseEntity<>(lstLanc, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value=path+"/{id}")
	public ResponseEntity<LancamentoModel> excluir(@PathVariable Long id){
		LancamentoModel lancEncontrado = lancamentoServices.getLancamento(id);
		HttpStatus status;
		
		if ( lancEncontrado != null ){
			lancamentoServices.excluir(lancEncontrado);
			status = HttpStatus.OK;
		}else {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(status);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="mostrarsaldo", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> obterSaldo(){
		double saldo =  lancamentoServices.mostrarSaldo();
		return new ResponseEntity<>(saldo, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="filtrarpordata/{dataini}/{datafim}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<LancamentoModel>> obterLancamentos(@PathVariable LocalDate dataini, @PathVariable LocalDate datafim ){
		Collection<LancamentoModel> lstLanc =  lancamentoServices.filtarLancamentosPorData(dataini, datafim);
		return new ResponseEntity<>(lstLanc, HttpStatus.OK);
	}
}
