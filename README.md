# api-soccer-teams

Contains a simple REST API that deals with teams and players in the team. Uses Spring Data JPA (HSQL DB)


to access the application: http://localhost:8080/api-soccer-teams/api/teams

Can access it with:
- http://localhost:8080/api-soccer-teams/api/teams.json or
- http://localhost:8080/api-soccer-teams/api/teams.xml (once the JAXB annotation is present on the model)
- http://localhost:8080/api-soccer-teams/api/teams/Steaua|Dinamo

The actuator has security disabled and can be accessed at:
- http://localhost:8080/api-soccer-teams/actuator/.....

Swagger documentation
for raw JSON: 
- GET: http://<hostname>:<port>/api-soccer-teams/v2/api-docs
- GET: http://localhost:8080/api-soccer-teams/swagger-ui.html

