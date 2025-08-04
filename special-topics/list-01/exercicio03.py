num1 = float(input("Digite o primeiro número: "))
num2 = float(input("Digite o segundo número: "))

sum = num1 + num2
print(f"A soma de {num1} e {num2} é: {sum:.2f}")

subtraction = num1 - num2
print(f"A diferença entre {num1} e {num2} é: {subtraction:.2f}")

multiplication = num1 * num2
print(f"A multiplicação de {num1} e {num2} é: {multiplication:.2f}")

if num2 != 0 and num1 != 0:
  division = num1 / num2
  print(f"A divisão de {num1} por {num2} é: {division:.2f}")
else:
  print("Divisão por zero não é permitida.")