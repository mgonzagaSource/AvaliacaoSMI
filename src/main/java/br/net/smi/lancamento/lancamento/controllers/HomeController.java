package br.net.smi.lancamento.lancamento.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.net.smi.lancamento.lancamento.services.*;
import br.net.smi.lancamento.lancamento.models.*;


@Controller
public class HomeController {

	
	@Autowired
	private EmpresaServices es;
	private CategoriaServices cs;
	private LancamentoServices ls;
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	
 @RequestMapping(method=RequestMethod.GET, value="/empresas#", produces=MediaType.APPLICATION_JSON_VALUE)
  public ModelAndView chamarEmpresas(){
	 es = new EmpresaServices();
	 Collection<EmpresaModel> empresas = es.listarEmpresas();
	 ModelAndView mv = new ModelAndView("empresanav");
	 mv.addObject("listarEmpresas", empresas);
	 return mv;
  }
 
 @RequestMapping(method=RequestMethod.GET, value="/categorias#", produces=MediaType.APPLICATION_JSON_VALUE)
 public ModelAndView chamarCategorias(){
	 cs = new CategoriaServices();
	 Collection<CategoriaModel> categorias = cs.listarCategorias();
	 ModelAndView mv = new ModelAndView("categorianav");
	 mv.addObject("listarCategorias", categorias);
	 return mv;
 }
 
 @RequestMapping(method=RequestMethod.GET, value="/lancamentos#", produces=MediaType.APPLICATION_JSON_VALUE)
 public ModelAndView chamarLancamentos(){
	 ls = new LancamentoServices();
	 Collection<LancamentoModel> lancamentos = ls.listarLancamentos();
	 ModelAndView mv = new ModelAndView("lancamentonav");
	 mv.addObject("listarLancamentos", lancamentos);
	 return mv;
 }
}
