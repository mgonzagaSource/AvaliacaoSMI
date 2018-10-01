package br.net.smi.lancamento.lancamento.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LancamentoModel {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private EmpresaModel empresa;
	
	@OneToOne
	private CategoriaModel categoria;
	
	private String tipo;
	private LocalDate vencimento;
	private BigDecimal valor;
	
	 public LancamentoModel()
	{
		this.categoria = new CategoriaModel();
		this.empresa = new EmpresaModel();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    public EmpresaModel getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaModel empresa) {
		this.empresa = empresa;
	}
	public CategoriaModel getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria; 
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public LocalDate getVencimento() {
		return vencimento;
	}
	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}	
}
