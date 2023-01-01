
## Api Entpoints ##

 

     - 
         1.GET
         2. POST
         3. PUT
         4. DELETE


        <!-- GET API -->
         localhost:9090/users
            -> To Get All The Users
        <!-- POST API -->
            localhost:9090/users
              

              pass the json object like :

              {
                "name": "Sudip Das"
                "email": "sudip@gamil"
              }

        <!-- PUT API -->

        localhost:9090/users/1
         - To update the User Details 

         like :
         {
            "name" :"sudip",
            "email" : "sudip5428@gmail.com"
         }

         <!-- DELETE API -->
         localhost:9090/users/1
