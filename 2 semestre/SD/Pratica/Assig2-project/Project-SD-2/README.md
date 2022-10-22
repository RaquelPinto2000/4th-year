# Projeto-SD-2
Assignment 2 de SD


Student
*      args[0] - name of the platform where is located the table server 
*      args[1] - name of the platform where is located the bar server 
*      args[2] - port number for listening to service requests 
*      args[3] - port number for listening to service requests
*      args[4] - name of the platform where is located the general repository server 
*      args[5] - port number for listening to service requests

sd201@l040101-ws06.ua.pt sd201@l040101-ws07.ua.pt 22300 22307 sd201@l040101-ws01.ua.pt 22302

Chef
*      args[0] - name of the platform where is located the kitchen server 
*      args[1] - name of the platform where is located the bar server 
*      args[2] - port number for listening to service requests 
*      args[3] - port number for listening to service requests 
*      args[4] - name of the platform where is located the general repository server 
*      args[5] - port number for listening to service requests

sd201@l040101-ws02.ua.pt sd201@l040101-ws07.ua.pt 22303 22307 sd201@l040101-ws01.ua.pt 22302

Waiter
*           args[0] - name of the platform where is located the table server 
*           args[1] - name of the platform where is located the bar server 
*           args[2] - name of the platform where is located the kitchen server 
*           args[3] - port number for listening to service requests 
*           args[4] - port number for listening to service requests
*           args[5] - port number for listening to service requests 
*           args[6] - name of the platform where is located the general repository server 
*           args[7] - port number for listening to service requests

sd201@l040101-ws06.ua.pt sd201@l040101-ws07.ua.pt sd201@l040101-ws02.ua.pt 22300 22307 22303 sd201@l040101-ws01.ua.pt 22302

table: sd201@l040101-ws06.ua.pt 22300

bar: sd201@l040101-ws07.ua.pt 22307

kitchen: sd201@l040101-ws02.ua.pt 22303


## serverTable
22300 sd201@l040101-ws01.ua.pt 22302

## serverBar
22307 sd201@l040101-ws01.ua.pt 22302

## serverKitchen
22303 sd201@l040101-ws01.ua.pt 22302

## serverGeneralRepos
22302
