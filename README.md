# HomeWork19
## Simple REST-app on H2db with Spring Security

#### For testing app use you should use POSTMAN and next links:
http://localhost:8080/users/login (with body which includes username and password)  -  generate token (PostMapping)

http://localhost:8080/helloworld (Bearer token authorization)- access admin, user (GetMapping)

http://localhost:8080/books (Bearer token authorization) - access admin, user (GetMapping)

http://localhost:8080/books (Bearer token authorization) (with body book entity) = access admin (PostMapping)

http://localhost:8080/books/{bookId} (Bearer token authorization) - access admin, user (GetMapping)

http://localhost:8080/books/{bookId} (Bearer token authorization) - access admin  (DeleteMapping)


