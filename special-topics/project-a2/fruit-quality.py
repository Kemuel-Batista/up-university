# EDA
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import plotly.express as px
import seaborn as sns

# Carregar dados para o dataframe
df_frutas = pd.read_csv('./datasets/apple_quality.csv')

# 2. Tratamento inicial
# Padronizar nomes das colunas (lowercase e sem espaços)
df_frutas.columns = df_frutas.columns.str.strip().str.lower()

# Visualizar dataframe
print(df_frutas.head(10))

# Estrutura do dataframe
print(df_frutas.info())

# Transformar a variável quality em numérica (0 e 1)
df_frutas['quality'] = (df_frutas['quality'] == 'good').astype(int)

# Remover a coluna a_id, pois não tem poder preditivo
df_frutas.drop(columns=['a_id'], axis=1, inplace=True)

# 3. Exploração inicial
print("\n--- Estatísticas descritivas ---")
print(df_frutas.describe())

print("\nContagem de frutas boas vs ruins:")
print(df_frutas['quality'].value_counts())

# 4. Visualizações básicas
# Boxplot peso x qualidade
plt.figure(figsize=(6,4))
sns.boxplot(x='quality', y='weight', data=df_frutas, palette='Set2')
plt.title("Peso vs Qualidade da Fruta")
plt.show()

print("Apesar de a amplitude ser maior, a mediana dos pesos entre frutas boas e ruins não apresenta uma diferença significativa, pois os valores são bem próximos. Isso indica que, em termos medianos, o peso das frutas não varia muito entre as duas categorias. No entanto, as frutas boas apresentam uma amplitude maior, sugerindo que tendem a ter um peso relativamente mais elevado em comparação às frutas ruins.")

# 5. Relatório simples no console
print("\n--- Insights ---")
media_peso_boa = df_frutas[df_frutas['quality'] == 1]['weight'].mean()
media_peso_ruim = df_frutas[df_frutas['quality'] == 0]['weight'].mean()
print(f"Média de peso das frutas boas: {media_peso_boa:.2f}")
print(f"Média de peso das frutas ruins: {media_peso_ruim:.2f}")