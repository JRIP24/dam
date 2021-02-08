#coding:utf-8

archivo = open("archivo.txt" , "r")

#palabras = [i for i in archivo for word in i.split()]
#print(palabras)
palabras = []
for line in archivo:

    for word in line.split():

        word = word.replace("," , "").lower()

        if word not in palabras:
            palabras.append(word)

palabras.sort()
print(palabras)

archivo.close()