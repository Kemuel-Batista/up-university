![Java](https://img.shields.io/badge/Java-11%2B-blue?logo=java&style=for-the-badge)
![Design Pattern](https://img.shields.io/badge/Design%20Pattern-Strategy-brightgreen?style=for-the-badge)

# RPG de Combate com Padrão Strategy

Uma implementação prática do Padrão de Projeto (Design Pattern) **Strategy** em Java, simulando um sistema de combate de RPG medieval.

## 🎯 Sobre o Projeto

Este projeto demonstra como o padrão Strategy pode ser usado para criar um sistema flexível onde os algoritmos (neste caso, ataques de armas) podem ser trocados em tempo de execução.

Em vez de o `Personagem` ter uma lógica de ataque fixa (usando `if/else` ou `switch` para cada tipo de arma), ele delega a ação de "atacar" para um objeto de estratégia separado.

* **O Contexto (`Personagem`):** A classe que precisa de um comportamento variável. Ele "tem" uma estratégia.
* **A Estratégia (`ArmaStrategy`):** A interface que define o contrato para todos os comportamentos (ataques).
* **As Estratégias Concretas (`EspadaLonga`, `CajadoArcano`, etc.):** As implementações específicas do algoritmo de ataque.

Isso permite que o `Personagem` mude seu comportamento de ataque simplesmente trocando o objeto `ArmaStrategy` que ele possui (o ato de "equipar uma arma").

## ✨ Funcionalidades

* **Implementação Pura do Padrão Strategy:** Separação clara entre o `Contexto` (Personagem) e as `Estratégias` (Armas).
* **Sistema de Classes de RPG:**
    * `Guerreiro` (Focado em Força, passiva de defesa)
    * `Arqueiro` (Focado em Destreza, passiva de esquiva)
    * `Mago` (Focado em Inteligência, passiva de regeneração de mana)
    * `Paladino` (Classe híbrida de extensão)
* **Armas como Estratégias:**
    * `EspadaLonga` (Dano físico com chance de Sangramento)
    * `MachadoDeGuerra` (Dano físico alto com chance de Atordoar)
    * `ArcoElfico` (Dano em área)
    * `CajadoArcano` (Dano mágico que aplica Queimadura)
    * `AdagaSombria` (Dano bônus em alvos atordoados)
* **Sistema de Batalha por Turnos:** A classe `Batalha` gerencia o fluxo de combate, processando turnos, status e condições de vitória.
* **Efeitos de Status:** Implementação de `StatusEffect` para gerenciar Sangramento, Queimadura e Atordoamento.
* **Requisitos de Equipamento:** Armas verificam os atributos (`forca`, `destreza`, `inteligencia`) e a classe do personagem antes de permitir o equipamento.
* **Mecânicas Adicionais:** Crítico, custo de mana e passivas de classe.

## 📂 Estrutura do Projeto

Aqui está uma visão geral das classes principais e seus papéis dentro do padrão Strategy:

| Classe/Interface | Papel no Padrão | Descrição |
| :--- | :--- | :--- |
| **`ArmaStrategy.java`** | **Strategy (Interface)** | Define o contrato `usar()` e `podeEquipar()` que todas as armas devem implementar. |
| **`EspadaLonga.java`** | **Concrete Strategy** | Implementação do algoritmo de ataque da espada (dano + sangramento). |
| **`CajadoArcano.java`** | **Concrete Strategy** | Implementação do algoritmo de ataque do cajado (dano + queimadura). |
| **`ArcoElfico.java`** | **Concrete Strategy** | Implementação do algoritmo de ataque do arco (dano em área). |
| **`... (outras armas)`** | **Concrete Strategy** | Outras implementações de algoritmos de ataque. |
| **`Personagem.java`** | **Context (Abstrato)** | Possui uma referência à `ArmaStrategy` (`armaEquipada`). Delega a execução para a estratégia. |
| **`Guerreiro.java`** | **Concrete Context** | Define seus atributos, passivas e quais tipos de `ArmaStrategy` pode usar. |
| **`Mago.java`** | **Concrete Context** | Define seus atributos, passivas e quais tipos de `ArmaStrategy` pode usar. |
| **`... (outras classes)`** | **Concrete Context** | Outras implementações de personagens. |
| **`Batalha.java`** | Orquestrador | Gerencia os turnos e a lógica da simulação (não faz parte do padrão). |
| **`StatusEffect.java`** | Classe Auxiliar | Gerencia os efeitos de status aplicados pelas armas. |
| **`RPGDemo.java`** | Cliente (Main) | Configura os objetos, define as estratégias iniciais e inicia a batalha. |

## 🚀 Como Executar

Este projeto é escrito em Java puro e não requer dependências externas.

### Requisitos

* JDK 11 ou superior.

### Passos para Execução

1.  **Clone o repositório** (ou salve todos os arquivos `.java` em um mesmo diretório).

2.  **Abra o terminal** e navegue até o diretório onde os arquivos estão.

3.  **Compile todos os arquivos `.java`:**
    ```bash
    javac *.java
    ```

4.  **Execute a classe principal (`RPGDemo`):**
    ```bash
    java RPGDemo
    ```

## 📝 Exemplo de Saída

A execução do `RPGDemo` simulará uma batalha e produzirá um log no console: