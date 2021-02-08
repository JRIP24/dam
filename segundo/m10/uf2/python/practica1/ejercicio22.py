#coding:utf-8

import math

n1 = int(input("Introduzca un número: "))
n2 = int(input("Introduzca otro número: "))

if(n1 < n2):
    for i in range(n1, n2):
        print("√", i, "=", round(math.sqrt(i), 2))