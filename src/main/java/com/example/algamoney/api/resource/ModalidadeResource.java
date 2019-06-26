package com.example.algamoney.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.model.Modalidade;
import com.example.algamoney.api.repository.ModalidadeRepository;
import com.example.algamoney.api.service.CategoriaService;

@RestController
@RequestMapping("/modalidades")
public class ModalidadeResource {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired // Procura uma CategoriaRepository e seta no meu objeto
	private ModalidadeRepository modalidadeRepository;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ApplicationEventPublisher publisher; //Objeto responsavel por acionar eventos (Publicador de eventos da aplicação)

	/*
	 * @GetMapping public ResponseEntity<?> listar(){ //Retorna uma entidade de
	 * response List<Categoria> categorias = categoriaRepository.findAll(); return
	 * !categorias.isEmpty() ? ResponseEntity.ok(categorias) :
	 * ResponseEntity.notFound().build(); }
	 */
	@GetMapping
	public List<Modalidade> listar() {
		return modalidadeRepository.findAll();
	}

	@PostMapping
	public void criar(@Valid @RequestBody Modalidade modalidade, HttpServletResponse response) {
		
		//for (int i = 0; i < 200; i++) {
			//Modalidade modalidadeSalva = new Modalidade();
			//modalidade = new Modalidade();
			modalidade.setNome("Informatica4");
			Modalidade modalidadeSalva = modalidadeRepository.save(modalidade);

			// publisher.publishEvent(new RecursoCriadoEvent(this, response,
			// modalidadeSalva.getCodigo()));
		//}
		//return ResponseEntity.status(HttpStatus.CREATED).body(modalidadeSalva);
		
	}
	
	
}
