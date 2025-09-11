package payments

import (
	"errors"
	"strings"
)

type PayPalFactory struct {
	email string
}

func NewPayPalFactory(email string) *PayPalFactory {
	return &PayPalFactory{email: email}
}

func (f *PayPalFactory) CreatePayment() (Payment, error) {
	if !strings.Contains(f.email, "@") {
		return nil, errors.New("email inválido para PayPal")
	}

	return PayPalPayment{email: f.email}, nil
}
