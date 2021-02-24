#coding:utf-8

import sys
import os
from llibreta import Llibreta

class Menu:

    def __init__(self):
        self.llibreta = Llibreta()
        self.choicesMenu = {
                "1": self.add_client,
                "2": self.delete_client,
                "3": self.search_client,
                "4": self.modify_client,
                "5": self.quit
                }

        self.choicesConsulta = {
                "1": self.search_identifier,
                "2": self.search_name,
                "3": self.search_lasname,
                "4": self.list_all_clients,
                "5": self.list_all_by_name
                }

    def display_main_menu(self):
        print("""
MENU PRINCIPAL
================
Seleccioni una opció u premi Intro
================
1. Afegir client
2. Eliminar client
3. Consultar client
4. Modificar un camp d'un client (*)
5. Sortir
""")

    def run_main_menu(self):
        while True:
            os.system('cls' if os.name == 'nt' else 'clear')#Limpia pantalla
            self.display_main_menu()
            choice = input("Enter an option: ")
            action = self.choicesMenu.get(choice)
            if action:
                action()
                self.pause()
            else:
                print("{0} no es una opción válida".format(choice))


    def display_search_menu(self):
        print("""
MENU CONSULTA
================
Seleccioni una opció u premi Intro
================
1. Cercar client per Identificador
2. Cercar client per Nom
3. Cercar client per Cognom
4. Llistat tots els clients
5. Llistat tots els clients per Nom(*)
6. Enrere
""")

    def run_search_menu(self):
        salir = False
        while salir == False:
            self.display_search_menu()
            choice = input("Enter an option: ")
            
            if choice == "6":
                salir = True
            else:
                action = self.choicesConsulta.get(choice)
                if action:
                    action()
                    self.pause()
                else:
                    print("{0} no es una opción válida".format(choice))

    
    def pause(self):
        tecla = input("\n \nPresiona cualquier tecla para continuar ")
    

    def add_client(self):
        
        name = input("Introduzca el nombre: ")
        lastname = input("Introduzca el apellido: ")
        phone = input("Introduzca el teléfono: ")
        email = input("Introduzca el email: ")
        address = input("Introduzca la dirección: ")
        city = input("Introduzca la ciudad: ")

        self.llibreta.afegir_client(name, lastname, phone, email, address, city)


    def delete_client(self):

        if not self.llibreta.llista_clients:
            print("No hay clientes ")

        else:

            selectedId = self.selectClientId()
            self.llibreta.eliminar_client(selectedId)

    def search_client(self):

        if (self.llibreta.isEmpty()):
            
            print("La libreta está vacía")

        else:
            self.run_search_menu()

    def modify_client(self):
        selectedId = self.selectClientId()
        self.llibreta.modify_client(selectedId)
    
    def selectClientId(self):
        salir = False
        founded = False
        while (salir == False):
            self.llibreta.get_llista_clients()
            selectedId = input("Seleccione un ID: ")

            for i in self.llibreta.llista_clients:

                if str(i.id) == selectedId:#founded
                    founded = True
                    break
            
            if(founded):
                salir = True
        return selectedId


    #Métodos de search menu
    def search_identifier(self):
        selectedId = input("Introduzca un ID: ")
        resultado = self.llibreta.cercar_per_id(selectedId)

        for i in resultado:
            print(i)

    def search_name(self):
        nom = input("Introduzca un Nombre: ")
        resultado = self.llibreta.cercar_per_nom(nom)

        for i in resultado:
            print(i)

    def search_lasname(self):
        lastname = input("Introduzca un Apellido: ")
        resultado = self.llibreta.cercar_per_cognom(lastname)

        for i in resultado:
            print(i)

    def list_all_clients(self):
        self.llibreta.get_llista_clients()

    def list_all_by_name(self):
        self.search_name()#?


    def quit(self):
        print("Saliendo...")
        sys.exit(0)

if __name__ == "__main__":
    Menu().run_main_menu()