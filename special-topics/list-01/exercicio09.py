word_or_phrase = input("Digite uma palavra ou frase: ")

# Remove espaços e converte para minúsculas
cleaned_word = ''.join(word_or_phrase.split()).lower()

if cleaned_word == cleaned_word[::-1]:
  print(f"{word_or_phrase} é um palíndromo.")
else:
  print(f"{word_or_phrase} não é um palíndromo.")