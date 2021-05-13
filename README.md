# webcalculator
Webcalculator is simple calculation app. It enables addition, subtractaction, multiplication and division of numbers. Two additional endpoints allows to:
- monitor average number of request per second of last minute, hour and day
- get sum of last 10 requests

## How to start app
To start navigate to root directory and use ``` mvn spring-boot:run ``` comand 

## Endpoints with example data
All 4 operation endpoints accept same request body type
``` 
{
    "numbers": [
        6,
        7,
        8,
        9,
        0,
        123
    ]
}
 ```

- addition 
``` POST http://localhost:8080/calculate/add ```
- subtraction
``` POST http://localhost:8080/calculate/subtract ```
- multiplication
``` POST http://localhost:8080/calculate/multiply ```
- division
``` POST http://localhost:8080/calculate/divide ```

#### additional endpoints
- get sum of last 10 operations 
``` GET http://localhost:8080/sumOfLast10Requests ```
- monitor average request per second for each operation endpoint
``` GET  http://localhost:8080/statistic ```

## Database
Webcalculator uses H2 in-memory database instance. It is torn down each time applicaiton is turn off, thus each restart of application guarantees fresh start statistics.
