<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.104.2">
    <title>Signin Template · Bootstrap v5.2</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    

    

<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="assets/signin.css" rel="stylesheet">
  </head>
  <body >
    
<div class=" m-5">
 
  <div class="row">
    <div class="col-lg-6 col-md-12">
  <form method="post">
    
    <h1 class="h3 mb-3 fw-normal">Connectez-vous</h1>
	<% if((boolean)request.getAttribute("messageconnexionno")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  Adresse e-mail ou mot de passe invalide
								</div>
								<% } %>
    <div class="form-floating">
      <input name="cemail" type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
      <label for="floatingInput">Email</label>
    </div>
    <div class="form-floating my-3">
      <input name="cpassword" type="password" class="form-control" id="floatingPassword" placeholder="Password">
      <label for="floatingPassword">Mot de passe</label>
    </div>

   
    <button name="bconnexion"  class="w-100 btn btn-lg btn-primary" type="submit">Connexion</button>
    
  </form>
</div>
<div class=" col-lg-6 col-md-12 ">
  <form method="post">
    
    <h1 class="h3 mb-3 fw-normal">Inscrivez-vous</h1>
	<% if((boolean)request.getAttribute("messageinscriptionok")==true){ %>
                                <div class="alert alert-success mt-5" role="alert">
								 Votre inscription a bien été prise en compte, veuillez vous connecter
								</div>
								<% } %>
						<% if((boolean)request.getAttribute("userexiste")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								compte déja existant, veuillez vous connecter
								</div>
								<% } %>
                      <% if((boolean)request.getAttribute("inputvide")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  veuillez remplir tous les champs
								</div>
								<% } %>
					  <% if((boolean)request.getAttribute("mdppasidentique")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  le mot de passe et la confirmation du mot de passe doivent être identique
								</div>
								<% } %>
						 <% if((boolean)request.getAttribute("emailinvalide")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  Veuillez entrer un email valide
								</div>
								<% } %>
					 <% if((boolean)request.getAttribute("mdplength")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  le mot de passe n'est pas assez long
								</div>
								<% } %>
					 <% if((boolean)request.getAttribute("mdpweak")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  le mot de passe n'est pas assez sécurisé
								</div>
								<% } %>
    <div class="form-floating my-3">
      <input name="nom" type="name" class="form-control" placeholder="nom">
      <label for="floatingInput">Nom</label>
    </div>
    <div class="form-floating my-3">
      <input name="email" type="email" class="form-control"  placeholder="name@example.com">
      <label for="floatingInput">Email</label>
    </div>
    <div class="form-floating my-3">
      <input name="mdp" type="password" class="form-control"  placeholder="name@example.com">
      <label for="floatingInput">Mot de passe</label>
    </div>
    <div class="form-floating my-3">
      <input name="cmdp" type="password" class="form-control" id="floatingPassword" placeholder="Password">
      <label for="floatingPassword">Confirmez Mot de passe</label>
    </div>

   
    <button name="binscription" class="w-100 btn btn-lg btn-primary" type="submit">Inscription</button>
    
  </form>
</div>
</div>

</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  </body>
</html>
