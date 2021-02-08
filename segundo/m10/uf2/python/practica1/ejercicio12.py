#coding:utf-8

print("Fecha")
day = int(input("Introduzca el día: "))
month = int(input("Introduzca el mes: "))
year = int(input("Introduzca el año: "))


if(day <= 0 or month <= 0 or year <= 0 ):
    print("Error: valores incorrectos")
else:

    valid = True

    if(month >= 1 and month <= 12):

        if (year % 4 == 0 and (year % 100 != 0 or year % 400 == 0)):
            bisiesto = True
        else:
            bisiesto = False

        if(month == 4 or month == 6 or month == 9 or month == 11):
            
            if not (day >= 1 and day <= 30):
                valid = False

        elif(month == 1 or month == 3 or month == 5 or month == 7 or month == 8 or month == 10 or month == 12):
            if not (day >= 1 and day <= 31):
                valid = False

        elif(month == 2):
            if(bisiesto):
                if not (day >= 1 and day <=29 ):
                    valid = False
            else:
                if not (day >= 1 and day <=28 ):
                    valid = False

    else:
        valid = False


    

    if(valid):
        print("La fecha introducida es correcta")
    else:
        print("La fecha introducida NO es correcta")

    

