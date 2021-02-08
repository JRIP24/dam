#coding:utf-8

num = int(input("Introduzca un número: "))
  
if num > 1:

    for i in range(2,num):

        if (num % i == 0):

            print("El número introducido NO es primo")
            break
    else:
        print("El número introducido es primo")
         
else:
    print("El número introducido NO es primo")