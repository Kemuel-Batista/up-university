age = int(input("Digite sua idade: "))

if age >= 0 and age <= 12:
  print("Classificação: Criança")
elif age >= 13 and age <= 17:
  print("Classificação: Adolescente")
elif age >= 18 and age <= 59:
  print("Classificação: Adulto")
else:
  print("Classificação: Idoso")