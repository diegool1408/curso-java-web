package br.com.tt.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertTest {

	@Test
	public void testCpf() {
		assertEquals("001.385.560-32", new Convert().cpf("00138556032"));
	}

}
