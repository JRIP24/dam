#coding:utf-8

seg = int(input("Introduzca segundos: "))

minutos = int(seg/60)
segs = seg%60

print( seg, "segundos equivalen a", str(minutos) + "m", str(segs) + "s" )