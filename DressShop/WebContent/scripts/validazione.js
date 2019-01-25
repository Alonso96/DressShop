/**
 * 
 */

$(document).ready(function() {

 

  $(".test").click(

  function(e){

 

 

       

        var email = $("input[name='email']").val();

        var nome = $("input[name='nome']").val();

 

        console.log(nome);

        console.log(email);

 

        //Testo

        var re = /[A-Za-z -']$/;

        if(re.test(document.getElementById("firstName").value)){

          console.log("Nome valida");

          document.getElementById("firstName").style.border ='1px solid #3c8f1b';

          validation_name = 1;

        }else{

          console.log("Nome non valido");

          document.getElementById("firstName").style.border ='1px solid #c30000';

          validation_name = 0;

        }

 

 

        //Email

        var checkEmail = email.match(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/);

        console.log(checkEmail);

        if(checkEmail){

          console.log("Email valida");

           document.getElementById("email").style.border ='1px solid #3c8f1b';

           validation_email = 1;

         } else {

           console.log("Email non valida");

           document.getElementById("email").style.border ='1px solid #c30000';

           validation_email = 0;

         }

 

        //Validazione

        if(validation_email == 1 && validation_name == 1){ console.log("INVIO!"); } else { console.log("Validazione non superata"); }

 

        e.preventDefault();

 

 

  });//click

 

});//Dom
