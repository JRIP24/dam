#coding:utf-8
class Client:
    
    def __init__(self, id, name, lastname, phone, email, address, city):
        self.id = id
        self.name = name
        self.lastname = lastname
        self.phone = phone
        self.email = email
        self.address = address
        self.city = city
    
    def __str__(self):
        cadena="ID: {}, Nombre: {}, Apellido: {}, Teléfono: {}, Email: {}, Dirección: {}, Ciudad: {}".format(self.id, self.name, self.lastname, self.phone, self.email, self.address, self.city)
        return cadena

    #Setters
    def setName(self, name):
        self.name = name

    def setLastName(self, lastname):
        self.lastname = lastname

    def setPhone(self, phone):
        self.phone = phone

    def setEmail(self, email):
        self.email = email

    def setAddress(self, address):
        self.address = address

    def setCity(self, city):
        self.city = city