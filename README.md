###Sign-up
POST /api/authentication/sign-up HTTP/1.1
Host: localhost:8080
: 
Content-Type: application/json
Authorization: Basic Og==
Content-Length: 70

{
    "name":"admin",
    "username":"admin",
    "password":"admin"
}

###Sign-in 
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8080
: 
Content-Type: application/json
Authorization: Basic Og==
Content-Length: 55

{
    
    "username":"admin",
    "password":"admin"
}
############################
Resultat
{
    "id": 2,
    "username": "admin",
    "password": "$2a$10$rb7KYQ0JZvDnbpnssQR1fODqNB.BeOU1quhLGFI42yZEAoNxE2AeC",
    "name": "admin",
    "createTime": "2023-08-27T17:47:41.393609",
    "role": "ADMIN",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJST0xFX0FETUlOIiwidXNlcmlkIjoyLCJleHAiOjE2OTMyNTQwNzF9.-fwH2bqnZmg5PIDWTyvhH3l599mam8oFfdrKJ0gEs9UFCpXJDdfwPSvXLB38zIYFCQWn2R5RHXMi5nDolbJViw"
}

###change role   user a comme role user et on le change en admin
PUT /api/user/change/ADMIN HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbjEiLCJyb2xlIjoiUk9MRV9VU0VSIiwidXNlcmlkIjozLCJleHAiOjE2OTMxNTk1NzB9.2k0yU-Lx7S2BUgL2oncpZP4QPYf6O6_vhL3C4P-6dWTbUTVyc4lTB2S239w9OmIFIkQ82O95cDvZvg62FQekUw

################# resultat
true  

pour tester si le role est change
###Sign-in 
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8080
: 
Content-Type: application/json
Authorization: Basic Og==
Content-Length: 55

{
    
    "username":"admin",
    "password":"admin"
}
################ Resultat
{
    "id": 2,
    "username": "admin",
    "password": "$2a$10$rb7KYQ0JZvDnbpnssQR1fODqNB.BeOU1quhLGFI42yZEAoNxE2AeC",
    "name": "admin",
    "createTime": "2023-08-27T17:47:41.393609",
===>"role": "ADMIN",   <=================================
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJST0xFX0FETUlOIiwidXNlcmlkIjoyLCJleHAiOjE2OTMyNTQwNzF9.-fwH2bqnZmg5PIDWTyvhH3l599mam8oFfdrKJ0gEs9UFCpXJDdfwPSvXLB38zIYFCQWn2R5RHXMi5nDolbJViw"
}


################## Test Device
#### add device
POST /api/device HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJST0xFX0FETUlOIiwidXNlcmlkIjoyLCJleHAiOjE2OTMyNDU3NDh9.AhM7nh99Qa_M5mY3TZTnly7T_ZMG-vIV9A9Vbq04oMHT6jNcg1sDAbS3PWGpWeCUQV1QnrQprGKZQlxNQ1zL5A
Content-Length: 126

{
    "name": "ibm 487",
    "description":"strong one",
    "price":"1000",
    "deviceType":"DESKTOP"
                    
}
###### get all device
GET /api/device HTTP/1.1
Host: localhost:8080
###### delete device 
DELETE /api/device/2 HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsInJvbGUiOiJST0xFX0FETUlOIiwidXNlcmlkIjoyLCJleHAiOjE2OTMyNDU3NDh9.AhM7nh99Qa_M5mY3TZTnly7T_ZMG-vIV9A9Vbq04oMHT6jNcg1sDAbS3PWGpWeCUQV1QnrQprGKZQlxNQ1zL5A

###### Purchase
###### add Purchase
POST /api/purchase HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMiIsInJvbGUiOiJST0xFX1VTRVIiLCJ1c2VyaWQiOjQsImV4cCI6MTY5MzI0NzQ1Nn0.mijTlqT9vXhW-mgGcHEhU_9J17DXe9YbZeaBrKQ-lV_njxdsdFEb6PIQwzBJC6yJLgRAesDR7Rqa3tjGdJK9oQ
Content-Length: 74

{
    "userId":4,
    "deviceId":4,
    "price":800,
    "color":"blue"

}