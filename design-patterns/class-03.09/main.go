package main

import "payment/payments"

func main() {
	service := payments.PaymentService{}

	// Testando Cartão de Crédito
	service.ProcessPayment(payments.NewCreditCardFactory("1234567891014587"), 150.0)

	// Testando PayPal
	service.ProcessPayment(payments.NewPayPalFactory("kemuel@paypal.com"), 75.0)

	// Testando Criptomoeda
	service.ProcessPayment(payments.NewCryptoFactory(10, 300), 300.0)

	// Testando erro em Cartão
	service.ProcessPayment(payments.NewCreditCardFactory("123"), 50.0)
}
