# Exemplo do Padrão de Projeto State: Máquina de Pedidos

Este projeto é uma implementação simples em Java do padrão de projeto comportamental State. Ele simula o ciclo de vida de um pedido (Order) em um sistema de e-commerce, onde o comportamento do pedido muda drasticamente dependendo do seu estado atual (Novo, Pago, Enviado, etc.).

## 🎯 O Problema Resolvido pelo Padrão State

Em sistemas complexos, um objeto pode ter muitos estados diferentes, e seu comportamento depende desses estados. Uma abordagem comum (e problemática) é usar grandes estruturas condicionais (`if/else` ou `switch`) dentro dos métodos do objeto para verificar o estado atual antes de executar uma ação.

Isso leva a:

* **Código Macarrão:** Métodos longos e difíceis de manter.
* **Alta Acoplamento:** A classe principal fica sobrecarregada com a lógica de todos os estados.
* **Violação do Princípio Aberto/Fechado:** Adicionar um novo estado exige modificar a classe principal.

O padrão State resolve isso encapsulando o comportamento específico de cada estado em sua própria classe. O objeto principal (o "Contexto") mantém uma referência ao objeto de estado atual e delega a execução para ele.

## 🏗️ Estrutura do Projeto

O código está estruturado em torno dos componentes principais do padrão State:

* **`Order.java` (O Contexto)**
    * É a classe principal que os clientes (como a `Main`) irão interagir.
    * Mantém uma referência ao estado atual (`OrderState state`).
    * Fornece um método `setState(OrderState state)` para permitir que os estados façam a transição.
    * Delega todas as ações (`pay()`, `ship()`, etc.) para o objeto de estado atual.

* **`OrderState.java` (A Interface State)**
    * Define a interface comum para todos os estados.
    * Declara todos os métodos que representam as ações possíveis no contexto (`pay()`, `ship()`, `deliver()`, `cancel()`).

* **Classes de Estado Concretas (Os Estados)**
    * Cada classe implementa a interface `OrderState` e representa um estado específico do ciclo de vida do pedido.
    * Contém a lógica de o que acontece quando uma ação é chamada naquele estado.
    * É responsável por fazer a transição do Contexto (`Order`) para o próximo estado, se aplicável.
    * **`NewOrderState.java`**: O pedido foi criado.
        * Permite: `pay()` (muda para `Paid`), `cancel()` (muda para `Canceled`).
        * Proíbe: `ship()`, `deliver()`.
    * **`PaidOrderState.java`**: O pedido foi pago.
        * Permite: `ship()` (muda para `Shipped`), `cancel()` (muda para `Canceled`).
        * Proíbe: `pay()`, `deliver()`.
    * **`ShippedOrderState.java`**: O pedido foi enviado.
        * Permite: `deliver()` (muda para `Delivered`).
        * Proíbe: `pay()`, `ship()`, `cancel()`.
    * **`DeliveredOrderState.java`**: Estado final. O pedido foi entregue.
        * Proíbe: Todas as ações.
    * **`CanceledOrderState.java`**: Estado final. O pedido foi cancelado.
        * Proíbe: Todas as ações.

* **`Main.java`**
    * Classe de demonstração que simula a criação e interação com os pedidos, testando os diferentes fluxos e transições de estado.

## 🚀 Como Executar

Este é um projeto Java simples e não requer dependências externas.

### Compilar:

Certifique-se de ter o JDK (Java Development Kit) instalado. Navegue até o diretório do projeto e compile todos os arquivos `.java`:

```bash
javac *.java