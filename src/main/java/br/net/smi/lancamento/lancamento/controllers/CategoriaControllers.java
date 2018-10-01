package br.net.smi.lancamento.lancamento.controllers;

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
import br.net.smi.lancamento.lancamento.models.CategoriaModel;
import br.net.smi.lancamento.lancamento.services.CategoriaServices;

@RestController
public class CategoriaControllers {

	@Autowired
	CategoriaServices categoriaServices;
	
	private final String path = "/categorias";

	// end point
	@RequestMapping(method = RequestMethod.POST, value = path, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaModel> cadastrarCategoria(@RequestBody CategoriaModel categoria) {
		try {
			CategoriaModel categoriaCadastrada = categoriaServices.salvar(categoria);
			return new ResponseEntity<>(categoriaCadastrada, HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = path + "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaModel> alterarCategoria(@RequestBody CategoriaModel categoria) {
		try {
			CategoriaModel categoriaEncontrada = categoriaServices.salvar(categoria);
			return new ResponseEntity<>(categoriaEncontrada, HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
		
	}

	@RequestMapping(method = RequestMethod.GET, value = path, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<CategoriaModel>> obterCategorias() {
		Collection<CategoriaModel> lstCategorias = categoriaServices.listarCategorias();
		return new ResponseEntity<>(lstCategorias, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = path + "/{id}")
	public ResponseEntity<CategoriaModel> excluir(@PathVariable Long id) {
		CategoriaModel categoriaEncontrada = categoriaServices.getCategoria(id);
		HttpStatus status;

		if (categoriaEncontrada != null) {
			try {
				categoriaServices.excluir(categoriaEncontrada);
				status = HttpStatus.OK;
			} catch (Exception ex) {
				throw ex;
			}
		} else {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(status);
	}
}
