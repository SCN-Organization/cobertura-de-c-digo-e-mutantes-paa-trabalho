package br.ufrpe.poo.banco.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import br.ufrpe.poo.banco.exceptions.ClienteJaPossuiContaException;
import br.ufrpe.poo.banco.exceptions.ClienteNaoPossuiContaException;

/**
 * Classe de teste respons�vel por testar as condi��es dos m�todos
 * adicionarConta e removerConta da classe Cliente.
 * 
 * @author Aluno
 * 
 */
public class TesteCliente {
	private static Cliente cliente;

	/**
	 * Testa a inser��o de uma nova conta vinculada ao cliente
	 */
	@Test
	public void adicionarContaTest() {
		Cliente c1 = new Cliente("nome", "123");
		try {
			c1.adicionarConta("1");
		} catch (ClienteJaPossuiContaException e) {
			fail();
		}
		assertEquals(c1.procurarConta("1"), 0);
	}

	/**
	 * Testa a condi��o da tentativa de adicionar uma conta j� existente � lista
	 * de contas do cliente
	 * 
	 * @throws ClienteJaPossuiContaException
	 */
	@Test(expected = ClienteJaPossuiContaException.class)
	public void adicionarContaJaExistenteTest()
			throws ClienteJaPossuiContaException {
		Cliente c1 = new Cliente("nome", "123");
		c1.adicionarConta("1"); // adiciona a conta a 1� vez
		c1.adicionarConta("1"); // tentativa de adicionar a mesma conta
								// novamente
	}

	/**
	 * Teste a remo��o de uma conta da lista de contas do cliente
	 */
	@Test
	public void removerContaClienteTest() {
		Cliente c1 = new Cliente("nome", "123");
		try {
			c1.adicionarConta("1"); // adiciona conta com n�mero 1
			c1.removerConta("1"); // remove a conta de n�mero 1
		} catch (Exception e) {
			fail("Exce��o inesperada lancada!");
		}

		assertEquals(c1.procurarConta("1"), -1);
	}

	/**
	 * Testa a remo��o de uma determinada conta que n�o est� vinculada ao
	 * cliente
	 * 
	 * @throws ClienteNaoPossuiContaException
	 */
	@Test(expected = ClienteNaoPossuiContaException.class)
	public void removerContaClienteSemContaTest()
			throws ClienteNaoPossuiContaException {
		Cliente c1 = new Cliente("nome", "123");
		c1.removerConta("1"); // tenta remover a conta de um cliente sem contas
	}

	/**
	 * Testa a remocao de todas as conta de um
	 * cliente
	 * 
	 */
	@Test
	public void removerTodasAsContasTest() {
		Cliente cliente = new Cliente("Nome Teste", "12345678900");

		try {
			cliente.adicionarConta("123");
			cliente.adicionarConta("456");
			cliente.adicionarConta("789");
		} catch (ClienteJaPossuiContaException e) {
			fail("Não deveria lançar exceção ao adicionar contas.");
		}
		cliente.removerTodasAsContas();
		// Verifica se a lista de contas está vazia
		assertTrue(cliente.getContas().isEmpty());

	}

	@Test
	public void testConstrutor() {
		Cliente c = new Cliente("nome", "123");
		assertEquals("nome", c.getNome());
		assertEquals("123", c.getCpf());
		assertTrue(c.getContas().isEmpty());
	}

	@Test
	public void testConsultarNumeroConta() {
		Cliente cliente = new Cliente("Nome Teste", "12345678900");

		try {
			cliente.adicionarConta("123");
			cliente.adicionarConta("456");
			cliente.adicionarConta("789");
		} catch (ClienteJaPossuiContaException e) {
			fail("Não deveria lançar exceção ao adicionar contas.");
		}

		// Testa se o método retorna a conta correta
		assertEquals("123", cliente.consultarNumeroConta(0));
		assertEquals("456", cliente.consultarNumeroConta(1));
		assertEquals("789", cliente.consultarNumeroConta(2));

		// Testa se o método lança exceção para índice inválido
		try {
			cliente.consultarNumeroConta(3); // Índice fora do intervalo
			fail("Deveria lançar exceção para índice fora do intervalo.");
		} catch (IndexOutOfBoundsException e) {
			// Esperado
		}
	}

	@Test
	public void testGetNome() {
		Cliente c1 = new Cliente("Nome Teste", "12345678911");
		assertEquals("Nome Teste", c1.getNome());
	}

	@Test
	public void testSetNome() {
		Cliente c1 = new Cliente("Nome Teste", "12345678911");
		c1.setNome("Novo Nome");
		assertEquals("Novo Nome", c1.getNome());
	}

	@Test
	public void testGetCpf() {
		Cliente c1 = new Cliente("Nome Teste", "12345678900");
		assertEquals("12345678900", c1.getCpf());
	}

	@Test
	public void testSetCpf() {
		Cliente c1 = new Cliente("NOME", "12345678911");
		c1.setCpf("09876543211");
		assertEquals("09876543211", c1.getCpf());
	}

	@Test
	public void testGetContas() {
		Cliente c1 = new Cliente("Nome Teste", "12345678911");
		assertNotNull(c1.getContas());
		assertTrue(c1.getContas().isEmpty());
	}

	@Test
	public void testEquals() {
		Cliente c1 = new Cliente("Nome Teste", "12345678900");
		Cliente c2 = new Cliente("Nome Teste", "12345678900");
		assertTrue(c1.equals(c2));
		assertTrue(c2.equals(c1));
	}

	@Test
	public void testEqualsFalse(){
		Cliente c1 = new Cliente("Nome Teste", "12345678900");
		Cliente c2 = new Cliente("Nome Teste", "12345678911");
		assertFalse(c1.equals(c2));
		assertFalse(c2.equals(c1));
	}

	@Test
	public void testEqualsNotInstanceof(){
		Cliente c1 = new Cliente("Nome Teste", "12345678900");
		Integer a = 20;
		assertFalse(c1.equals(a));
		assertFalse(a.equals(c1));
	}


	@Test
	public void testToString() {
		Cliente c1 = new Cliente("Nome Teste", "12345678900");
		String expectedString = "Nome: Nome Teste\nCPF: 12345678900\nContas: []";
		assertEquals(expectedString, c1.toString());
	}
}