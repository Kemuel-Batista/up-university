package payments

import "fmt"

type CreditCardPayment struct {
	cardNumber string
}

func (c CreditCardPayment) processPayment(value float64) {
	fmt.Printf("Pagamento de R$%.2f realizado com cartão de crédito.\n", value)
}
