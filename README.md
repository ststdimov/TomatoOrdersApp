# TomatoOrdersApp

This Spring Web MVC application is used to generate random tomato
orders and to handle requests for them.
The application handles GET requests on `/orders/data?size=<X>`
endpoint, where the size parameter is optional. The response is in the following format:

`[{`
`"id": <randomly generated UUID>,`
`"tomatoes": <randomly generated Integer from 1 to 2000>,`
`“provider": <randomly generated String, one of the following:`
`"Heinz", "Hunt's", "Del Monte", "Le Ol' Granma">,`
`“timestamp": <randomly-generated long from the beginning of this year to today>`
`}, ... ]`

##Installation guide

1. Install Java 8 available at `http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html`
2. Clone the project from `https://github.com/ststdimov/TomatoOrdersApp.git`

##Run the application
- Open the terminal console and navigate to the project root. Type `mvnw spring-boot:run` to start the application.
The web application is available at `http://localhost:8080`

- Another option is to import the project in the Spring Tool Suite (available at `https://spring.io/tools`)
and run it as Java application 