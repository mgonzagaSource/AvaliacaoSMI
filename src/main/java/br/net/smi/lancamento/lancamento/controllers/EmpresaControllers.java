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
import br.net.smi.lancamento.lancamento.models.EmpresaModel;
import br.net.smi.lancamento.lancamento.services.EmpresaServices;;

@RestController
public class EmpresaControllers {

	@Autowired
	EmpresaServices empresaServices;
	private final String path = "/empresas";

	/*
	 * @RequestMapping("/") public String empresa(){ return
	 * "./empresa/empresanav"; }
	 */

	// end point
	@RequestMapping(method = RequestMethod.POST, value = path, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaModel> cadastrarEmpresa(@RequestBody EmpresaModel empresa) {
		EmpresaModel empresaCadastrada = empresaServices.salvar(empresa);
		return new ResponseEntity<>(empresaCadastrada, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = path + "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaModel> alterarEmpresa(@RequestBody EmpresaModel empresa) {
		try {
			EmpresaModel empresaAlterada = empresaServices.salvar(empresa);
			return new ResponseEntity<>(empresaAlterada, HttpStatus.OK);
		} catch (Exception ex) {
			throw ex;
		}
		// return new ResponseEntity<>(empresaAlterada, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = path, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<EmpresaModel>> obterEmpresas() {
		Collection<EmpresaModel> lstEmpresas = empresaServices.listarEmpresas();
		return new ResponseEntity<>(lstEmpresas, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/empresa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaModel> obterEmpresa(@PathVariable Long id) {
		EmpresaModel empresa = empresaServices.getEmpresa(id);
		return new ResponseEntity<>(empresa, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = path + "/{id}")
	public ResponseEntity<EmpresaModel> excluir(@PathVariable Long id) {
		EmpresaModel empresaEncontrada = empresaServices.getEmpresa(id);
		HttpStatus status;

		if (empresaEncontrada != null) {
			try {
				empresaServices.excluir(empresaEncontrada);
				status = HttpStatus.OK;
			} catch (Exception ex) {
				throw ex;
			}

		} else {
			status = HttpStatus.NOT_FOUND;
		}
		return new ResponseEntity<>(status);
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET, value = "/{cnpj}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<EmpresaModel>
	 * buscaporcpf(@PathVariable String cnpj) { EmpresaModel empresaEncontrada =
	 * empresaServices.findByCnpj(cnpj); HttpStatus status;
	 * 
	 * if (empresaEncontrada != null) { status = HttpStatus.OK; } else { status
	 * = HttpStatus.NOT_FOUND; } return new ResponseEntity<>(status); }
	 * 
	 * @RequestMapping(method = RequestMethod.GET, value = "/{nome}", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<EmpresaModel>
	 * buscapornome(@PathVariable String nome) { EmpresaModel empresaEncontrada
	 * = empresaServices.findByNome(nome); HttpStatus status;
	 * 
	 * if (empresaEncontrada != null) { status = HttpStatus.OK; } else { status
	 * = HttpStatus.NOT_FOUND; } return new ResponseEntity<>(status); }
	 */
}
