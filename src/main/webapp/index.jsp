<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="java.util.ArrayList"%> 
    <%@page import="model.TodoDAO"%> 
    <%@page import="model.Todo"%>
    <%ArrayList<Todo> todo = new ArrayList<Todo>();%> 
    <%ArrayList<Todo> todocheck = new ArrayList<Todo>();%> 
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.104.2">
    <title>Index todoList</title>

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
  <body class="text-center">
    
<main class="form-signin w-100 m-auto">
  <h2 class=" mb-3 fw-normal">Bonjour ${usernom }</h2>
    <h4 class=" mb-3 fw-normal">Bienvenue dans Todo App </h4>
    
  <form method="post">
    <span >Ajouter une tâche</span>
    <% if((boolean)request.getAttribute("vide")==true){ %>
                                <div class="alert alert-danger mt-5" role="alert">
								  veuillez remplir tous les champs
								</div>
								<% } %>
    <div class="d-flex">
     
    <input name="titre"  class="form-control me-3 my-3" placeholder="titre*" required>
    <input name="description" class="form-control me-3 my-3" placeholder="description">
    <button name="addt" class="btn h-25 btn-success mt-3" type="submit">+</button>
  </div>
    </form>


   
 <% todo=(ArrayList)request.getAttribute("todo");
                               for(Todo t:todo){%>
   

    <div class="checkbox mb-3">
    
      <label class="d-flex justify-content-center">
           
        <h6><%= t.getTitre() %></h6> <a href="Index?check=<%=t.getId_todo() %>" ><i title="done" class="ms-3">&#10003;</i></a>
      </label>
    </div>
    
<%} %>
<% todocheck=(ArrayList)request.getAttribute("todocheck");
                               for(Todo t:todocheck){%>
   

    <div class="checkbox mb-3">
    
      <label class="d-flex justify-content-center">
           
        <h6><strike> <%= t.getTitre() %></strike></h6> 
      </label>
    </div>
    
<%} %>

  
</main>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  </body>
  
</html>
