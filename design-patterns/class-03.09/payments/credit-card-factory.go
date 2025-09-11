package payments

import (
	"errors"
	"regexp"
)

type CreditCardFactory struct {
	cardNumber string
}

func NewCreditCardFactory(cardNumber string) *CreditCardFactory {
	return &CreditCardFactory{cardNumber: cardNumber}
}

func (f *CreditCardFactory) CreatePayment() (Payment, error) {
	match, _ := regexp.MatchString(`^\d{16}$`, f.cardNumber)

	if !match {
		return nil, errors.New("número de cartão inválido: deve conter exatamente 16 dígitos")
	}

	return CreditCardPayment{cardNumber: f.cardNumber}, nil
}
