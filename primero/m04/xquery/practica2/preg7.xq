for $i in doc("playstore.xml")/playstore/jocs/joc
where contains($i/nom, 'ge')
return ($i/nom, $i/companyia)