 <h2>mutant_6</h2>
//Classe: ContaImposto</br>
//alteração no metodo debitar, ao invéz de debitar o valor da compra + imposto, esse mutante irá debitar apenas o imposto<br>
<br>
@Override</br>
	public void debitar(double valor) throws SaldoInsuficienteException {</br>
		if (this.getSaldo() < valor)</br>
			throw new SaldoInsuficienteException(this.getNumero(),</br>
					this.getSaldo());</br>
		double imposto = valor * CPMF;</br>
		double total = valor + imposto;</br>
		this.setSaldo(this.getSaldo() - imposto); //era pra ser "- total"</br>
	}</br>