#conding:utf-8

alumnos = {
    "Ronald" : 8,
    "Pepe" : 4,
    "Jhon" : 10,
    "Doe" : 3
}

print("Lista de alumos: ")
print(alumnos.keys())

nombre = input("De qué alumno quiere saber la nota? (escriba nombre del alumno): ")
if nombre in alumnos:
    nota = alumnos.get(nombre)
    print("La nota de", nombre, "es:", nota)
else:
    print("No se ha encontrado el alumno", nombre)