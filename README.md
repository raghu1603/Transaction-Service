# Transaction-Service- Consuming a RESTful Web Service
Using RestTemplate to make an HTTP GET request to fetch a transaction data from URL.

## Thing to run the application

__Go the folder__
```
transaction-service
```
__Run the application__
```
mvn clean spring-boot:run
```
__Result in console__
```
----------------------------------------------------------------------------------------------------------------------------------------------------------
                      JANUARY | FEBRUARY |    MARCH |    APRIL |      MAY |     JUNE |     JULY |   AUGUST |SEPTEMBER |  OCTOBER | NOVEMBER | DECEMBER |
----------------------------------------------------------------------------------------------------------------------------------------------------------
 Transaction Count |       10 |       10 |        1 |        1 |       10 |       11 |        6 |       10 |       13 |       11 |        8 |        0 |
      Credit Count |        1 |        1 |        0 |        0 |        1 |        1 |        0 |        1 |        1 |        1 |        0 |        0 |
       Debit Count |        9 |        9 |        1 |        1 |        9 |       10 |        6 |        9 |       12 |       10 |        8 |        0 |
      Credit Value |  2290.00 |  2290.00 |     0.00 |     0.00 |  2290.00 |  2290.00 |     0.00 |  2290.00 |  2290.00 |  2290.00 |     0.00 |     0.00 |
       Debit Value |  1787.86 |  1615.30 |   500.00 |   203.93 |  1893.27 |  1545.47 |  1393.75 |  1931.31 |  2274.57 |  2087.13 |  1522.22 |     0.00 |
```
