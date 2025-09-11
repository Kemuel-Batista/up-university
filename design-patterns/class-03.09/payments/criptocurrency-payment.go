package payments

import "fmt"

type CriptocurrencyPayment struct {
	coins float64
	price float64
}

func (c CriptocurrencyPayment) processPayment(value float64) {
	fmt.Printf("Pagamento de R$%.2f via cripto: %.4f coins @ R$%.2f/coin\n",
		value, c.coins, c.price)
}
