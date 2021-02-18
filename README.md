# Simple REST-app on H2db with Spring Security

#### For testing app you should use POSTMAN and next links:
http://localhost:8080/users/login (with body which includes username and password)  -  generate token (PostMapping)

http://localhost:8080/helloworld (Bearer token auth)- access admin, user (GetMapping)

http://localhost:8080/books (Bearer token auth) - access admin, user (GetMapping)

http://localhost:8080/books (Bearer token auth) (with body book entity) = access admin (PostMapping)

http://localhost:8080/books/{bookId} (Bearer token auth) - access admin, user (GetMapping)

http://localhost:8080/books/{bookId} (Bearer token auth) - access admin  (DeleteMapping)

Username: user   |   admin
Password: password | admin




