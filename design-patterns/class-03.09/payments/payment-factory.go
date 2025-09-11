package payments

type PaymentFactory interface {
	CreatePayment() (Payment, error)
}
