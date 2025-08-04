number = float(input("Digite um número: "))
interval = float(input("Digite o intervalo: "))

print(f"\nTabuada do {number} com intervalo de {interval}:")
for i in range(1, 11):
  result = number * (i * interval)
  print(f"{number} x {i * interval} = {result:.2f}")