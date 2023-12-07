package br.com.rodrigo.cpfvalid.application.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rodrigo.cpfvalid.application.service.ApiService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@CrossOrigin
@RequestMapping("/validarCpf")
public class ApiController {

	private final ApiService service;

	@GetMapping("/{cpf}")
	public ResponseEntity<Boolean> validarCpf(@PathVariable String cpf) throws Exception {

		return ResponseEntity.ok().body(service.validCpf(cpf));
	}
}
