<h1>grupo</h1>
<li>Carlos Alberto</li>
<li>Daniel Leão</li>
<li>Tom Jones</li>


</br>
<h2>mutant_1</h2>

//trocou a verificação de creditar era <0 ficou == 0 ou seja vai creditar valores negativos </br></br>
public void creditar(ContaAbstrata conta, double valor) throws RepositorioException, ValorInvalidoException {</br>
if (valor == 0)</br>
throw new ValorInvalidoException();</br>
conta.creditar(valor);</br>
}</br></br>


<h2>mutant_2</h2>
//alteração no metodo equals na verificação de cpf ao invez de retornar true caso sejam iguais vai retorna false</br>

@Override</br>
	public boolean equals(Object o) {</br>
		if (o instanceof Cliente) {</br>
			Cliente c = (Cliente) o;</br>
			if (c.getCpf().equals(this.cpf))</br>
				return false;//(alteração aqui era para ser true)</br>
		}</br>
		return true;</br>
	}</br></br>

 <h2>mutant_3</h2>
//alteração na verificação do valor a ser debitado ao infez de ser < ficou >= </br></br>
@Override</br>
	public void debitar(double valor) throws SaldoInsuficienteException {</br>
		if (this.getSaldo() >= valor) //alteração aqui</br>
			throw new SaldoInsuficienteException(this.getNumero(),</br>
					this.getSaldo());</br>
		this.setSaldo(this.getSaldo() - valor);</br>
	}</br></br>



