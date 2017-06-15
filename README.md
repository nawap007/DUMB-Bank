# DUMBANK
This application was generated using JHipster 4.0.6, you can find documentation and help at [https://jhipster.github.io/documentation-archive/v4.0.6](https://jhipster.github.io/documentation-archive/v4.0.6).

## Development

Please insert required data if Mysql dump is not imported.


INSERT INTO `bank`.`transaction_type` (`transaction_type_id`, `remarks`, `transaction_type_name`) VALUES ('1', 'credit', 'push');
INSERT INTO `bank`.`transaction_type` (`transaction_type_id`, `remarks`, `transaction_type_name`) VALUES ('2', 'debit', 'pull');


## build command 

mvn clean install

## run command 

mvn spring-boot:run

##### REST ENDPOINTS #####

## create new user 

curl -X POST http://localhost:8080/create/users -H 'content-type: application/json' -d '{"firstName":"Raj",	"lastName":"kumar","email":"pawan5@gmail.com"}'


## withdraw money

curl -X POST http://localhost:8080/transaction/pull -H 'content-type: application/json' -d '{"accountNumber":"1014975498359882","amount":100.00}'

## Deposit money

curl -X POST http://localhost:8080/transaction/push -H 'content-type: application/json' -d '{"accountNumber":"1014975498359882",
	"amount":100.00}'
   
   
## get account details 

curl -X GET  http://localhost:8080/accountDetails/1014975498359882

## get all transactions of particular account

curl -X GET http://localhost:8080/transaction/all/1014975498359882
