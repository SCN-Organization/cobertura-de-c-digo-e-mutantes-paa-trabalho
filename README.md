<h3>mutant_2</h3></br></br>
//alteração no metodo equals na verificação de cpf ao invez de retornar true caso sejam iguais vai retorna false</br>

@Override</br>
	public boolean equals(Object o) {</br>
		if (o instanceof Cliente) {</br>
			Cliente c = (Cliente) o;</br>
			if (c.getCpf().equals(this.cpf))</br>
				return false;//(alteração aqui era para ser true)</br>
		}</br>
		return true;</br>
	}</br>
