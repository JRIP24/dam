for $i in doc("playstore.xml")/playstore/jocs/joc[plataforma='Wii']
return data($i/nom)
