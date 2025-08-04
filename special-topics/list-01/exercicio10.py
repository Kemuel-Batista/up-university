for i in range(3):
  product = input("Digite o nome do produto: ")
  price = float(input(f"Digite o preço do {product}: "))
  quantity = int(input(f"Digite a quantidade comprada de {product}: "))
    
  total_price = price * quantity
  if total_price > 100:
    total_price *= 0.9  # Aplicar 10% de desconto se o total for maior que R$100
  
  print(f"O total a pagar por {quantity} unidades de {product} é: R$ {total_price:.2f}")