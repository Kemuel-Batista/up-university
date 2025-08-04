nota = float(input("Digite a nota do aluno: "))
frequencia = float(input("Digite a frequência do aluno (em %): "))

# Verifica a aprovação
if nota >= 6.0 and frequencia >= 75:
  print("Aluno APROVADO.")
else:
  print("Aluno REPROVADO.")

### 1
# é necessário usar and pois precisamos que ambas as condições sejam 
# verdadeiras para que o aluno seja aprovado.

### 2
# Se usasse or, aconteceria que qualquer nota maior ou igual a 6.0 ou frequência maior 
# ou igual a 75% seria suficiente para aprovar o aluno, o que não é o esperado.