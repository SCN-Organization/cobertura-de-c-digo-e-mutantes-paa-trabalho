Mutante 7
Mutante inserido na classe negocio\Cliente, no método adicionarConta

"if (procurarConta(numeroConta) != -1)" -> "if (procurarConta(numeroConta) == -1)"

Com essa mudança, haverá uma tentativa de criar uma conta mesmo que já exista uma com o mesmo identificador, e criação de uma com um identificador novo chamará uma exception