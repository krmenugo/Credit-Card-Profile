API que difine el perfil de tarjetas de crédito en base a datos los siguientes datos recibidos: preferences, salary, age.

Endopoints:

GET
   @RequestMapping
     localhost:8081/CreditCardProfile/{idCreditCardProfile}

     Obtener el perfil de tarjeta de credito con: localhost:8081/CreditCardProfile/viewCreditCardProfile/{idCreditCardProfile}

POST
   @PostMapping
   localhost:8081/CreditCardProfile