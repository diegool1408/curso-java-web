package br.com.tt.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tt.exception.SistemaException;

public class Util {

	public static <T> T jsonToObject(String json, Class<T> valueType) throws SistemaException {

		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, valueType);

		} catch (IOException e) {

			String msgErro = "Falha ao converter o json: ";
			// TODO Auto-generated catch block

			SistemaException sistemaException = new SistemaException(msgErro, e);

			throw sistemaException;
		}

	}

}
