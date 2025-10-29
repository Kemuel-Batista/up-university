# 🚀 Sistema de Gerenciamento de Mídias Sociais (Adapter + Strategy)

Este é um projeto de demonstração em Java que ilustra a implementação e a colaboração de dois padrões de projeto fundamentais: **Adapter** e **Strategy**.

O objetivo é construir um sistema de agendamento de publicações que possa interagir com múltiplas APIs de mídias sociais (Twitter, Instagram, LinkedIn). Cada API é "legada" e possui métodos e requisitos de dados completamente diferentes e incompatíveis.

O sistema demonstra como criar um código cliente limpo, desacoplado e extensível, onde novas plataformas podem ser adicionadas sem alterar o código principal.

## 🎯 Problema Solucionado

1.  **APIs Incompatíveis:** Como nosso sistema pode usar `twitterApi.postTweet(key, text)` e `instagramApi.publishPhoto(data, caption)` usando uma única chamada, como `sistema.publicar(conteudo)`?
2.  **Algoritmos Intercambiáveis:** Como nosso sistema pode alternar dinamicamente entre "publicar no Twitter" e "publicar no Instagram" em tempo de execução, sem usar condicionais (`if/else`)?

## ✨ Padrões de Projeto Utilizados

### 1. Padrão Adapter

* **Propósito:** "Traduzir" uma interface incompatível para uma interface unificada que o cliente espera.
* **No Projeto:** Usamos o Adapter para "embrulhar" as APIs legadas (`TwitterApi`, `InstagramApi`). Cada `Adapter` (ex: `TwitterAdapter`) implementa uma interface unificada (`ISocialMediaAdapter`) e traduz as chamadas genéricas (`publish(content)`) para as chamadas específicas da API (`postTweet(...)`).

### 2. Padrão Strategy

* **Propósito:** Definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis.
* **No Projeto:** Usamos o Strategy para encapsular a "lógica de publicação" de cada plataforma. O `SocialMediaContext` (nosso cliente) possui uma `IPublishStrategy`. Podemos trocar essa estratégia em tempo de execução (de `TwitterPublishStrategy` para `InstagramPublishStrategy`) para mudar completamente o comportamento do `Context`.

## 🏗️ Arquitetura e Fluxo de Execução

A parte mais importante deste projeto é como os padrões colaboram. A separação de responsabilidades é clara e segue um fluxo de delegação:

**`Cliente`** ➔ **`Context`** ➔ **`Strategy`** ➔ **`Adapter`** ➔ **`Adaptee (API Legada)`**

1.  O **`Cliente`** (classe `AdapterStrategyDemo`) interage apenas com o **`SocialMediaContext`**. Ele não sabe nada sobre Twitter ou Instagram.
2.  O **`SocialMediaContext`** armazena a estratégia atual (um objeto **`IPublishStrategy`**).
3.  Quando o `Cliente` chama `context.executePublish()`, o `Context` delega a chamada para a **`Strategy`** concreta (ex: `TwitterPublishStrategy`).
4.  A **`Strategy`** (ex: `TwitterPublishStrategy`) não sabe os detalhes da API. Ela sabe apenas como falar com a interface unificada **`ISocialMediaAdapter`**. Ela delega a chamada para o `Adapter`.
5.  O **`Adapter`** (ex: `TwitterAdapter`) é a única classe que conhece a **`ApiLegada`** (ex: `TwitterApi`). Ele finalmente "traduz" a chamada unificada (`publish(content)`) para a chamada específica (`postTweet(apiKey, text)`).

Esta arquitetura nos dá o melhor dos dois mundos:
* **Flexibilidade (Strategy):** O `Context` pode trocar de plataforma dinamicamente.
* **Compatibilidade (Adapter):** As `Strategies` podem trabalhar com qualquer API, desde que ela tenha um `Adapter`.

## 📂 Componentes Principais

### Modelos de Dados
* `Content.java`: Modelo de dados unificado que o cliente usa.
* `Publication.java`: Modelo de dados unificado para a resposta (Tarefa 2).

### APIs Legadas (Adaptees)
* `TwitterApi.java`
* `InstagramApi.java`
* `LinkedInApi.java`

### Padrão Adapter
* `ISocialMediaAdapter.java`: A interface **Target** unificada.
* `TwitterAdapter.java`: Adaptador concreto.
* `InstagramAdapter.java`: Adaptador concreto.
* `LinkedInAdapter.java`: Adaptador concreto.

### Padrão Strategy
* `IPublishStrategy.java`: A interface **Strategy**.
* `TwitterPublishStrategy.java`: Estratégia concreta (que *usa* um `ISocialMediaAdapter`).
* `InstagramPublishStrategy.java`: Estratégia concreta.
* `LinkedInPublishStrategy.java`: Estratégia concreta.
* `SocialMediaContext.java`: O **Contexto**.

### Cliente
* `AdapterStrategyDemo.java`: A classe principal (`main`) que monta e executa o sistema.

## 🛠️ Como Executar

O projeto é escrito em Java puro e não requer dependências externas.

1.  Certifique-se de que todos os arquivos `.java` estejam no mesmo diretório.

2.  Compile todos os arquivos:
    ```bash
    javac *.java
    ```

3.  Execute a classe principal `AdapterStrategyDemo`:
    ```bash
    java AdapterStrategyDemo
    ```

## 📋 Saída Esperada

Você verá no console o log de execução de cada camada, mostrando claramente a delegação da chamada: