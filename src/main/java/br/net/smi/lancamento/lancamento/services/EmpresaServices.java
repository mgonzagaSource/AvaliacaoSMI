package br.net.smi.lancamento.lancamento.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.net.smi.lancamento.lancamento.models.EmpresaModel;
import br.net.smi.lancamento.lancamento.repository.EmpresaRepositorio;

@Service
public class EmpresaServices {

	@Autowired
	EmpresaRepositorio empresaRepositorio;

	public Collection<EmpresaModel> listarEmpresas() {

		return empresaRepositorio.findAll();
	}
	
	public EmpresaModel salvar(EmpresaModel empresa) {
		
		return empresaRepositorio.save(empresa);
		
	}
	
	public EmpresaModel excluir(EmpresaModel empresa ){
		 empresaRepositorio.delete(empresa); 
		 return null;
	}
	
	
	public EmpresaModel getEmpresa( Long id){
		return empresaRepositorio.findById(id);
	}
	
	public EmpresaModel findByCnpj(String cnpj){
		return empresaRepositorio.findByCnpj(cnpj); 
	}
	
	public EmpresaModel findByNome(String nome){
		return empresaRepositorio.findByCnpj(nome); 
	}
}
