package br.net.smi.lancamento.lancamento.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.net.smi.lancamento.lancamento.models.CategoriaModel;
import br.net.smi.lancamento.lancamento.repository.CategoriaRepositorio;

@Service
public class CategoriaServices {

	@Autowired
	CategoriaRepositorio categoriaRepositorio;

	public Collection<CategoriaModel> listarCategorias() {

		return categoriaRepositorio.findAll();
	}

	public CategoriaModel salvar(CategoriaModel categoria) {

		return categoriaRepositorio.save(categoria);
	}

	public void excluir(CategoriaModel categoria) {
		categoriaRepositorio.delete(categoria);
	}

	/*
	 * public CategoriaModel getCategoria(int id){ return
	 * categoriaRepositorio.getOne(id); }
	 */

	public CategoriaModel getCategoria(Long id) {
		return categoriaRepositorio.findById(id);
	}
}
