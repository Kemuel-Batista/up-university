package payments

import "fmt"

// Serviço que usa a factory para processar pagamento
type PaymentService struct{}

func (s PaymentService) ProcessPayment(factory PaymentFactory, value float64) {
	payment, err := factory.CreatePayment()

	if err != nil {
		fmt.Println("Erro ao criar pagamento:", err)
		return
	}

	payment.processPayment(value)
}
