package br.sp.gov.etec.seetec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.gov.etec.seetec.dtos.CursoDto;
import br.sp.gov.etec.seetec.entity.Curso;
import br.sp.gov.etec.seetec.repository.CursoRepository;



@RestController
public class CursoController {
	
	@Autowired
	private CursoRepository repository;
	
	@PostMapping
	@RequestMapping("/cadastrar")
	public void cadastrarCurso(@RequestBody CursoDto dto) {		
		Curso curso = this.transformarDtoEntity(dto);		
		repository.save(curso);
	}
	
	
	//Mapping
	private Curso transformarDtoEntity(CursoDto dto) {
		Curso c = new Curso();
		c.setNome(dto.getNome());
		c.setDescricao(dto.getDescricao());
		return c;
	}
	
	

}
