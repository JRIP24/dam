#coding:utf-8
'''
def mirar_edad():

    nombre = "Ronald"
    edad = 19
    apellido = "Intriago"

    print("Hola me llamo {} {} y tengo {} años".format(nombre, apellido, edad))

mirar_edad()'''

class Persona:

    def __init__(self, name, age, dni):
        self.name = name
        self.age = age
        self.__dni = dni#privada

    def saludo(self):
        print("Hola, soy", self.name)

person = Persona("Ronald", 20, "y2523232")
person.saludo()
