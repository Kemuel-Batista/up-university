package payments

type Payment interface {
	processPayment(amount float64)
}
