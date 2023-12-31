<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>One Stop Groceries | Add new store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  </head>
  <body>
  	<nav class="navbar navbar-expand-sm navbar-light bg-light border-bottom fixed-top">
  		<div class="container">
  			<span class="navbar-brand mt-1 h1">One<span class="text-warning">Stop</span>Groceries
  			<i class="fa-solid fa-truck"></i>
  			</span>

            <button type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" class="navbar-toggler" 
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle Navigation"><span class="navbar-toggler-icon"></span></button>
    
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a href="/" class="nav-link">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a href="#" class="nav-link">About</a>
                    </li>
                    <li class="nav-item active">
                        <a href="/stores" class="nav-link">LocateMe</a>
                    </li>
                </ul>
  		</div>
  	
  	</nav>
 
    <!-- main section -->
    <main>
        <section class="py-4 text-center container">
            <div class="row mt-5">
                <div class="col-lg-9 mx-auto">
                    <h2 class="fw-light">Add New Store</h2>
                </div>
            </div>
        </section>
    </main>

    <div class="container" style="width: 40rem; margin: auto;">
      <div class="mb-4">
        <h5>Basic Information</h5>
      </div>
      
      <form action="/add-store" method="post" modelattribute="store">

        <div class="mb-3">
          <label class="form-label">*Store name: </label>
          <input type="text" class="form-control" name="name" id="name" aria-label="Store name" required />
        </div>

        <div class="mb-3">
          <label class="form-label">*Phone: </label>
          <input type="tel" class="form-control" name="phone" id="phone" aria-label="Store phone number" required />
        </div>

      <div class="py-5">
        <a href="#" class="btn btn-danger">Cancel</a>
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
     </form>
      
    </div>

    
  	
  	<!-- footer -->	
 	<div class="container py-lg-5">
 		<footer class="mb-5">&copy; 2022. Made with <i class="fa-solid fa-heart"></i> in Penang. </footer>
 	</div>
    
    <script src="https://kit.fontawesome.com/e19fcdf015.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
  </body>
</html>