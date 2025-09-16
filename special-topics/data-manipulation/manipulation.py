import pandas as pd

base = pd.read_csv("forms2semestreup.csv")
print(base.head())
print(base.iloc[:, :5])
print(base.shape)
# Linhas 30 a 40, mas colunas específicas (3 a 6)
print(base.iloc[30:40, 3:6])