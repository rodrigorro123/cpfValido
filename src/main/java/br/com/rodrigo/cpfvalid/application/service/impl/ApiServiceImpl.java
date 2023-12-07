package br.com.rodrigo.cpfvalid.application.service.impl;

import org.springframework.stereotype.Service;

import br.com.rodrigo.cpfvalid.application.service.ApiService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ApiServiceImpl implements ApiService {

	@Override
	public boolean validCpf(String cpf) throws Exception {
		try {
			cpf = cpf.replaceAll("\\D", "");

			if (cpf.length() != 11) {
				return false;
			}
			
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
			}
			int rest = sum % 11;
			int digitVerify = (rest < 2) ? 0 : (11 - rest);

			sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
			}
			rest = sum % 11;
			int digitVerifySecundary = (rest < 2) ? 0 : (11 - rest);

			return digitVerify == Character.getNumericValue(cpf.charAt(9))
					&& digitVerifySecundary == Character.getNumericValue(cpf.charAt(10));

		} catch (Exception e) {
			log.error("Fail Validate CPF : {}", e.getMessage());
			return false;
		}
	}
}
