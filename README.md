# PaymentGatewayInterface

API Urls:
1. Registering a user (and activating the wallet of the user at the same time):
   POST : http://localhost:8080/user/register
   Payload : {
    "firstName" : "a",
    "lastName" : "b",
    "email" : "abcd@gmail.com",
    "address1" : "1",
    "address2" : "2",
    "mobile" : 1433,
    "gender" : "male",
    "isMerchant" : false
    }

2. Registering a merchant (and activating the wallet of the merchant at the same time):
   POST : http://localhost:8080/merchant/register
   Payload : { 
    "firstName" : "A",
    "lastName" : "R",
    "email" : "a@gmail.com",
    "address1" : "1",
    "address2" : "2",
    "mobile" : 9897675365,
    "gender" : "female",
    "isMerchant" : "true"
   }
   
3. Adding money to the wallet:
   PUT : http://localhost:8080/user/add/money/{amount}
   Payload : { "mobileWallet" : 1111111111 }
   
4. Initiating a transaction: 
   POST : http://localhost:8080/transaction/initiate
   Payload : {
     "senderNo" : 1234567890,
     "recieverNo" : 1111111111,
   }
   
5. Checking the status of a done transaction:
  GET : http://localhost:8080/transaction/status/{transactionId}


TECH STACK USED:
Java,
MySql,
Springboot,
Hibernate



