weight = float(input("Digite o peso em kg: "))
height = float(input("Digite a altura em metros: "))

imc = weight / (height ** 2)

print(f"O IMC é: {imc:.2f}")

if imc < 18.5:
  print("Classificação: Magreza")
elif imc > 18.5 and imc <= 24.9:
  print("Classificação: Normal")
elif imc >= 25 and imc <= 29.9:
  print("Classificação: Sobrepeso")
elif imc >= 30 and imc <= 39.9:
  print("Classificação: Obesidade")
else:
  print("Classificação: Obesidade grave")