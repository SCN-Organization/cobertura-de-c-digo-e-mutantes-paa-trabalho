<h3>mutant_2</h3></br></br>
//alteração no metodo equals na verificação de cpf ao invez de retornar true caso sejam iguais vai retorna false

@Override
	public boolean equals(Object o) {
		if (o instanceof Cliente) {
			Cliente c = (Cliente) o;
			if (c.getCpf().equals(this.cpf))
				return false;//(alteração aqui era para ser true)
		}
		return false;
	}
