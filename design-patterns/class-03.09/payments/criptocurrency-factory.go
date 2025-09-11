package payments

import "errors"

// Uma struct que guarda os parâmetros necessários para criar o pagamento.
type CriptocurrencyFactory struct {
	coins float64
	price float64
}

/*
* Construtor: função que inicializa a fábrica com os valores recebidos.
* Cria e retorna ponteiro para a fábrica preenchida.
 */
func NewCryptoFactory(coins, price float64) *CriptocurrencyFactory {
	return &CriptocurrencyFactory{coins: coins, price: price}
}

/*
* Factory Method: valida os dados e retorna:
* 	Um Payment (alguma implementação: CriptocurrencyPayment) ou
* 	Um error se os dados forem inválidos.
 */
func (f *CriptocurrencyFactory) CreatePayment() (Payment, error) {
	if f.coins <= 0 || f.price <= 0 {
		return nil, errors.New("valores inválidos para criptomoeda")
	}

	return CriptocurrencyPayment{}, nil
}
