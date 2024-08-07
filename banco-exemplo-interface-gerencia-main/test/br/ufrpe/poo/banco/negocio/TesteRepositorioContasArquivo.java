package br.ufrpe.poo.banco.negocio;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

import br.ufrpe.poo.banco.dados.RepositorioContasArquivoTxt;
import br.ufrpe.poo.banco.exceptions.RepositorioException;
import br.ufrpe.poo.banco.iterator.IteratorContaAbstrata;
import br.ufrpe.poo.banco.negocio.*;

public class TesteRepositorioContasArquivo {

    private File arquivo;
    private RepositorioContasArquivoTxt repositorio;

    @Before
    public void setUp() throws Exception {
        arquivo = new File("test_contas.txt");
        if (arquivo.exists()) {
            arquivo.delete();
        }
        repositorio = new RepositorioContasArquivoTxt(arquivo);
    }

    @After
    public void tearDown() throws Exception {
        if (arquivo.exists()) {
            arquivo.delete();
        }
    }

    @Test
    public void testInserir() throws RepositorioException {
        Conta conta = new Conta("123", 100.0);
        boolean resultado = repositorio.inserir(conta);
        assertTrue(resultado);
        assertEquals(conta, repositorio.procurar("123"));
    }

    @Test
    public void testProcurar() throws RepositorioException {
        Conta conta = new Conta("123", 100.0);
        repositorio.inserir(conta);
        ContaAbstrata resultado = repositorio.procurar("123");
        assertNotNull(resultado);
        assertEquals(conta, resultado);
    }

    @Test
    public void testRemover() throws RepositorioException {
        Conta conta = new Conta("123", 100.0);
        repositorio.inserir(conta);
        boolean resultado = repositorio.remover("123");
        assertTrue(resultado);
        assertNull(repositorio.procurar("123"));
    }

    @Test
    public void testAtualizar() throws RepositorioException {
        Conta conta = new Conta("123", 100.0);
        repositorio.inserir(conta);
        conta.setSaldo(200.0);
        boolean resultado = repositorio.atualizar(conta);
        assertTrue(resultado);
        assertEquals(200.0, repositorio.procurar("123").getSaldo(), 0.01);
    }

    @Test
    public void testExiste() throws RepositorioException {
        Conta conta = new Conta("123", 100.0);
        repositorio.inserir(conta);
        assertTrue(repositorio.existe("123"));
        assertFalse(repositorio.existe("456"));
    }

    @Test
    public void testGetIterator() throws RepositorioException {
        Conta conta1 = new Conta("123", 100.0);
        Conta conta2 = new Conta("456", 200.0);
        repositorio.inserir(conta1);
        repositorio.inserir(conta2);

        IteratorContaAbstrata iterator = repositorio.getIterator();
        assertTrue(iterator.hasNext());
        assertEquals(conta1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(conta2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test(expected = RepositorioException.class)
    public void testArquivoNaoCriado() throws Exception {
        arquivo = new File("nao_criado.txt");
        repositorio = new RepositorioContasArquivoTxt(arquivo);
        repositorio.inserir(new Conta("123", 100.0));
    }
}
