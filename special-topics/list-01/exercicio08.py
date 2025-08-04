students_qty = float(input("Digite a quantidade de alunos: "))

notes = []

for i in range(int(students_qty)):
  note = float(input(f"Digite a nota do aluno {i + 1}: "))
  notes.append(note)

average = sum(notes) / students_qty
print(f"A média das notas é: {average:.2f}")

greater_note = max(notes)
less_note = min(notes)
print(f"A maior nota é: {greater_note:.2f}")
print(f"A menor nota é: {less_note:.2f}")