valor1 = float(input("Digite o primeiro valor: "))
valor2 = float(input("Digite o segundo valor: "))

# Calcula a média
media = (valor1 + valor2) / 2

print(f"A média entre {valor1} e {valor2} é: {media:.2f}")

### 1
# A função input() sempre vai retornar string, logo precisamos converter para float (numero que permite
# decimais) para que assim possamos fazer a média entre os dois valores corretamente.

### 2
# Quando soma duas strings, o python não faz uma soma numérica, ele faz uma concatenação de texto.