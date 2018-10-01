package br.net.smi.lancamento.lancamento.models;

//import java.io.Serializable;
import java.util.Collection;

//import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import javassist.SerialVersionUID;

@Entity
public class EmpresaModel /*implements Serializable*/ {
	
	
	//Long SerialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String cnpj;
	private String nomeResponsavel;
	private String contato;
	
	@OneToMany
	private Collection<LancamentoModel> lstLancamentos;
	
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}	
}
