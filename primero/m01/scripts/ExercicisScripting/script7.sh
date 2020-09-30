#!/bin/bash

for i in {1..100};do

	if [[ $i =~ ^[0-9]+[0]$ ]];then
	
	
		echo -ne "$i \n"
		
	else
			
		echo -ne "$i "
		sleep 0.1
	fi
	
done
echo ""
