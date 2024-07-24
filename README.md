Mutante 10
Mudança na classe ContaImposto, no método debitar, resultando num comportamento em que não é 
possivel debitar da conta se o valor a ser cobrado for exatamente igual ao valor disponível

"if (this.getSaldo() < valor)" -> "if (this.getSaldo() <= valor)"