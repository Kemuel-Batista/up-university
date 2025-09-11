package payments

import "fmt"

type PayPalPayment struct {
	email string
}

func (p PayPalPayment) processPayment(value float64) {
	fmt.Printf("Pagamento de R$%.2f realizado com o paypal.\n", value)
}
