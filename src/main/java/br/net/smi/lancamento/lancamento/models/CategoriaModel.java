package br.net.smi.lancamento.lancamento.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CategoriaModel {

	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;
	
	@OneToMany
	private Collection<LancamentoModel> lstLancamentos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
