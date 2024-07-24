<h3>mutant_3</h3></br></br>
//alteração na verificação do valor a ser debitado ao infez de ser < ficou >= </br></br>
@Override</br>
	public void debitar(double valor) throws SaldoInsuficienteException {</br>
		if (this.getSaldo() >= valor) //alteração aqui</br>
			throw new SaldoInsuficienteException(this.getNumero(),</br>
					this.getSaldo());</br>
		this.setSaldo(this.getSaldo() - valor);</br>
	}</br>
