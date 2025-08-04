value = float(input("Digite o valor do saque: "))

if value % 10 != 0:
  print("Valor inválido. O valor do saque deve ser múltiplo de 10.")
else:
  currency_100 = value // 100
  value %= 100

  currency_50 = value // 50
  value %= 50

  currency_20 = value // 20
  value %= 20

  currency_10 = value // 10
  value %= 10

  print("\nCédulas fornecidas:")
  if currency_100: print(f"R$100: {currency_100}")
  if currency_50: print(f"R$50: {currency_50}")
  if currency_20: print(f"R$20: {currency_20}")
  if currency_10: print(f"R$10: {currency_10}")