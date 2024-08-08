<h1>grupo</h1>
<li>Carlos Alberto</li>
<li>Daniel Leão</li>
<li>Tom Jones</li>


![Screenshot_1](https://github.com/user-attachments/assets/c26e49b2-dc50-4589-a2b4-02935960fa4d)



</br>
<h2>mutant_1</h2>
//Classe: Banco</br>
//trocou a verificação de creditar era <0 ficou == 0 ou seja vai creditar valores negativos </br></br>
public void creditar(ContaAbstrata conta, double valor) throws RepositorioException, ValorInvalidoException {</br>
if (valor == 0)</br>
throw new ValorInvalidoException();</br>
conta.creditar(valor);</br>
}</br></br>


<h2>mutant_2</h2>
//Classe: Cliente</br>
//alteração no metodo equals na verificação de cpf ao invez de retornar true caso sejam iguais vai retorna false</br>
</br>
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
//Classe: Conta</br>
//alteração na verificação do valor a ser debitado ao invez de ser < ficou >= </br></br>
@Override</br>
	public void debitar(double valor) throws SaldoInsuficienteException {</br>
		if (this.getSaldo() >= valor) //alteração aqui</br>
			throw new SaldoInsuficienteException(this.getNumero(),</br>
					this.getSaldo());</br>
		this.setSaldo(this.getSaldo() - valor);</br>
	}</br></br>

<h2>mutant_4</h2>
//Classe: Poupanca</br>
//alteração no metodo renderJuros, ao invéz de multiplicar o saldo pela taxa de juros, esse mutante irá somar<br>
<br>
public void renderJuros(double taxa) {<br>
		double juros = this.getSaldo() + taxa; // o "+" era pra ser um "*"<br>
		this.creditar(juros);<br>
	}<br>

 <h2>mutant_5</h2>
//Classe: ContaEspecial</br>
//alteração no metodo getBonus, ao invéz de retornar o bonnus da conta, esse mutante irá retornar o saldo<br>
<br>
public double getBonus() {<br>
		return this.saldo; // era pra ser this.bonus<br>
	}<br>

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

<h2>mutant_7</h2>

//Classe: Cliente</br>
//o método adicionarConta foi alterado para chamar exceção quando não há conta com o número e para tentar criar conta quando já há uma conta com aquele número </br>
//if (procurarConta(numeroConta) != -1) -> if (procurarConta(numeroConta) == -1)</br>
</br>
public void adicionarConta(String numeroConta)</br>
			throws ClienteJaPossuiContaException {</br>
		if (procurarConta(numeroConta) == -1)</br>
			throw new ClienteJaPossuiContaException();</br>
		this.contas.add(numeroConta);</br>
}</br></br>

<h2>mutant_8</h2>

//Classe: RepositorioContasArray</br>
//foi utilizado o operador -- no indice no método inserir </br>
//if (procurarConta(numeroConta) != -1) -> if (procurarConta(numeroConta) == -1)</br>
</br>
@Override</br>
	public boolean inserir(ContaAbstrata conta) throws RepositorioException {</br>
		if (this.existe(conta.getNumero())) {</br>
			return false;</br>
		}</br>
		if (contas.length == --indice) {</br>
			ContaAbstrata[] aux = new ContaAbstrata[contas.length * 2];</br>
			for (int i = 0; i < indice; i++) {</br>
				aux[i] = contas[i];</br>
			}</br>
			this.contas = aux;</br>
		}</br>
		contas[indice] = conta;</br>
		indice = indice + 1;</br>
		return true;</br>
	}</br></br>

<h2>mutant_9</h2>

//Classe: RepositorioContasArquivoBin</br>
//um operador != foi alterado para >= </br>
//"if (arquivoContas.length() != 0)" -> "if (arquivoContas.length() >= 0)" </br>
</br>
@Override</br>
	public boolean inserir(ContaAbstrata conta) throws RepositorioException {</br>
		if (this.existe(conta.getNumero())) {</br>
			return false;</br>
		}</br>
		if (contas.length == --indice) {</br>
			ContaAbstrata[] aux = new ContaAbstrata[contas.length * 2];</br>
			for (int i = 0; i < indice; i++) {</br>
				aux[i] = contas[i];</br>
			}</br>
			this.contas = aux;</br>
		}</br>
		contas[indice] = conta;</br>
		indice = indice + 1;</br>
		return true;</br>
	}</br></br>

<h2>mutant_10</h2>

//Classe: ContaImposto</br>
//um operador < foi alterado para <=, e logo se o valor da transação for igual ao valor disponível, a exceção de saldo insuficiente será chamada</br>
//"if (this.getSaldo() < valor)" -> "if (this.getSaldo() <= valor)" </br>
</br>
@Override</br>
	public void debitar(double valor) throws SaldoInsuficienteException {</br>
		if (this.getSaldo() < valor)</br>
			throw new SaldoInsuficienteException(this.getNumero(),</br>
					this.getSaldo());</br>
		double imposto = valor * CPMF;</br>
		double total = valor + imposto;</br>
		this.setSaldo(this.getSaldo() - total);</br>
	}</br></br>
