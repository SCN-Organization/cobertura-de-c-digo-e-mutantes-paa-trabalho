<h2>mutant_1</h2>

//trocou a verificação de creditar era <0 ficou == 0 ou seja vai creditar valores negativos </br></br>
public void creditar(ContaAbstrata conta, double valor) throws RepositorioException, ValorInvalidoException {</br>
if (valor == 0)</br>
throw new ValorInvalidoException();</br>
conta.creditar(valor);</br>
}</br>

