#coding:utf-8
'''
def mirar_edad():

    nombre = "Ronald"
    edad = 19
    apellido = "Intriago"

    print("Hola me llamo {} {} y tengo {} años".format(nombre, apellido, edad))

mirar_edad()'''

class Gos:

    especie = "gos"

    def __init__(self, nombre, edad, raza):
        self.nombre = nombre
        self.edad = edad
        self.raza = raza

    def saludo(self):
        print("Hola, soy", self.nombre, "con raza", self.especie)

perro = Gos("Ronald", 20, "yatusae")
perro.saludo()