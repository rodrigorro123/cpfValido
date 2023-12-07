package br.com.rodrigo.cpfValid.application.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import br.com.rodrigo.cpfvalid.application.service.impl.ApiServiceImpl;

class ApiServiceImplTest {

	@InjectMocks
	private ApiServiceImpl service;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testIsValidCpf() throws Exception {
		String cpfValido = "123.456.789-09";

		boolean isValid = service.validCpf(cpfValido);

		assertTrue(isValid);
	}
	@Test
	void testIsNotValidCpf() throws Exception {
		String cpfValido = "123789-AA";

		boolean isValid = service.validCpf(cpfValido);

		assertTrue(!isValid);
	}
}
