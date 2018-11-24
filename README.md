# Spring-Rest-MVC-FTJB016
spring rest project.

	1. XML Element Name
	2. XML order retention 
	3. HTTP Methods /Response codes
	4. Use of ResponseEntity
	5. Exception Handling with Rest APIS
	
GET https://myserver.com/getmybusinessdetails/{id}
POST https://myserver.com/movuies/save
PUT https://myserver.com/movuies/update
DELETE https://myserver.com/movuies/{name}


Request:

{

"bizname":"test",
"address":"test street"
}


Response:

{

"bizname":"test",
"address":"test street"
}


GET https://mydomain.com/users/testapi/{id}

 https://mydomain.com/users/testapi/123
 httpstatus=200
 RespoinseObject{
 
 
 CognizantBean{
stutus="success/failure"
reason="resource is not available in db as of now"
 body:{
 "id":"123",
 "name";"test name"
 }
 
 
 }
 
 }
 
 
 HTTP Calls:-
 -----------------
 1. URL Object
 2. HttpURLConnection with the help of URL Object 
 3. set the properties (method type, request headers- content type, accepts)
 4.input stream will be giving the input
 