package br.com.rodrigo.cpfValid.application.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiControllerTest {

	  @LocalServerPort
	    private int port;

	    @Autowired
	    private TestRestTemplate restTemplate;

	    @Test
	    void testValidarCpf_Ok() {
	        String cpf = "123.456.789-09";
	        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
	                "http://localhost:" + port + "/validarCpf/" + cpf, String.class);

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals("true", responseEntity.getBody());
	    }

	    @Test
	    void testValidarCpf_CpfInvalido() {
	        String cpf = "111.222ABC-CC";
	        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
	                "http://localhost:" + port + "/validarCpf/" + cpf, String.class);

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals("false", responseEntity.getBody());
	    }

}
