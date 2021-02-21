#coding:utf-8
from client import Client

class Llibreta:

    def __init__(self):
        self.llista_clients = []
        self.last_id = -1


    def isEmpty(self):
        return not self.llista_clients



    def get_llista_clients(self):
        for i in self.llista_clients:
            print(i)
            

    def afegir_client(self, name, lastname, phone, email, address, city):
        self.last_id += 1
        id = self.last_id
        client = Client(id, name, lastname, phone,email,address,city)
        self.llista_clients.append(client)

    def eliminar_client(self, identificador):

        for i in self.llista_clients:
            if str(i.id) == identificador:#founded
                cliente = i
                break
        self.llista_clients.remove(cliente)
        print("Cliente eliminado")

    def modify_client(self, identificador):

        indice = int(identificador)

        client = self.llista_clients[indice]
        salir = False
        opciones = {
                "1": client.setName,
                "2": client.setLastName,
                "3": client.setPhone,
                "4": client.setEmail,
                "5": client.setAddress,
                "6": client.setCity
                }

        while(salir == False):
            print("Qué campo desea modificar? ")
            print("1. Nombre ")
            print("2. Apellido ")
            print("3. Teléfono ")
            print("4. Correo ")
            print("5. Dirección ")
            print("6. Ciudad ")

            opcion = input("Introduzca una opción: ")

            action = opciones.get(opcion)
            if action:
                valor = input("Introduzca un nuevo valor: ")
                action(valor)
                salir = True
            else:
                print("{0} no es una opción válida".format(opcion))

            self.llista_clients[indice] = client


    def cercar_per_id(self, identificador):
        resultado = []
        for i in self.llista_clients:
            if str(i.id) == identificador:#founded
                resultado.append(i)
                break
        return resultado

    def cercar_per_nom(self, nom):
        resultado = []
        for i in self.llista_clients:
            if str(i.name) == nom:#founded
                resultado.append(i)
        return resultado

    def cercar_per_cognom(self, cognom):
        resultado = []
        for i in self.llista_clients:
            if str(i.lastname) == cognom:#founded
                resultado.append(i)
        return resultado
    