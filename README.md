# spring-gradle-openapi-demo
## Spring project with Gradle and OpenAPI

This simple demo project provides automatic Spring code generation from a given OpenAPI 3.0.0 definition.

Be sure to check out [OpenApi Generator Gradle Plugin Github repo](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-gradle-plugin) for further information.

A Gradle wrapper is used to preserve consistency between users.

Tools used for this demo are:
- Spring Boot 2
- Spring web REST
- OpenAPI v.4.3.0 Gradle plugin

### Building the project
To build the project, you may use any Gradle build command such as:
````
gradlew.bat clean build --refresh-dependencies
````

### Running the project
The app is configured to automatically work with the Spring active profile 'dev' on port 8081

To run the project, simply run the command:
````
gradlew.bat bootRun
````

### OpenAPI definition used
````
openapi: 3.0.0
info:
  version: 1.0.0
  title: Demo Book Api
  description: A simple API definition example

paths:
  /books:
    get:
      description: Returns a list of books

      responses:
        '200':
          description: Successfully returned a list of books
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Book'
        '400':
          $ref: '#/components/responses/ErrorResponse'

    post:
      description: Let a user add a new book
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Book'
      responses:
        '200':
          description: Successfully added a new book
        '400':
          $ref: '#/components/responses/ErrorResponse'

  /books/{id}:
    get:
      description: Obtain information about a book from its id
      parameters:
        - $ref: '#/components/parameters/bookId'

      responses:
        '200':
          description: Successfully returned the book information
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Book'

        '400':
          $ref: '#/components/responses/ErrorResponse'

components:

  #  ----- Schemas by reference -------------------------------------
  schemas:

    Book:
      type: object
      required:
        - id
        - title
        - genre
        - author
      properties:
        id:
          type: string
          format: uuid
        title:
          type: string
        genre:
          type: string
          enum: [horror, scifi, fantasy, nonfiction]
        author:
          $ref: '#/components/schemas/Author'
        published_date:
          type: string

    Author:
      type: object
      required:
        - author_email
      properties:
        author_first_name:
          type: string
        author_last_name:
          type: string
        author_email:
          type: string

    Error:
      type: object
      properties:
        status:
          type: number
        message:
          type: string
        meta:
          type: string

  #  ----- Parameters by reference -------------------------------------
  parameters:

    bookId:
      name: id
      in: path
      required: true
      schema:
        type: string
        format: uuid

  responses:
    ErrorResponse:
      description: Bad request error
      content:
        application/json:
          schema:
            $ref : '#/components/schemas/Error'
````

