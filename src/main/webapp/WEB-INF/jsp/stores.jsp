<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>One Stop Groceries | Stores</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  </head>
  <body>
  	<nav class="navbar navbar-expand-sm navbar-light bg-light border-bottom fixed-top">
  		<div class="container">
  			<span class="navbar-brand mt-1 h1">One<span class="text-warning">Stop</span>Groceries
        <i class="fa-solid fa-truck"></i>
        </span>

        <button type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" class="navbar-toggler" 
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle Navigation"><span class="navbar-toggler-icon"></span>
        </button>
    
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a href="/" class="nav-link">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a href="#" class="nav-link">About</a>
                    </li>
                    <li class="nav-item active">
                        <a href="/stores" class="nav-link">Stores</a>
                    </li>
                </ul>
  		</div>
  	</nav>
 
    <!-- main section -->
    <main>
        <section class="py-4 text-center container mt-5">
            <div class="row py-lg-5">
                <div class="col-lg-9 mx-auto">
                    <h2 class="fw-light">Locate your nearest store!</h2>
                    <p class="lead text-muted">We are a digital learing and talents platform with the mission to deliver growth for talents and enterprises in the digital economy.</p>
                    <a href="/stores"><i class="fa-solid fa-shop"></i> View Stores</a></t>
                    <a href="/new-store"><i class="fa-solid fa-plus"></i> Add Store</a>
                </div>
            </div>

            <div class="input-group mb-5">
                <input class="form-control" type="search" placeholder="Type location or address to find your nearest store here" aria-label="Search">
                <button type="submit" class="btn btn-secondary">Find</button>
            </div>
        </section>

        <section class="container">
        </section>
    </main>

	<!-- if stores not exists, show stores not found -->
	<c:if test="${empty stores}">
	<div class="container"><h2>No Store found.</h2></div>
	</c:if>
	
	<!-- if the stores exists, view stores -->
	<c:if test="${not empty stores}">
	
	
	<!-- store card template -->
	<div class="container mb-5">
        <div class="row row-cols-1 row-cols-md-3 g-4">
        
        	<c:forEach var="store" items="${stores}">
            <div class="col">
                <div class="card h-100">
                  <img src="assets/img/store4_pexels-pixabay-264636.jpg" class="card-img-top" alt="...">
                  <div class="card-body">
                    <h5 class="card-title">${store.name }</h5>
                    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This card has even longer content than the first to show that equal height action.</p>
                    <a href="#" class="btn btn-light">${store.phone }</a>
                  </div>
                  <div class="card-footer">
                    <small class="text-muted">Last updated 5 days ago</small>
                    <a href="#"><i class="fa-solid fa-pen-to-square"style="float: right; display: inline-block;"></i></a>
                  </div>
                </div> 
            </div>
            </c:forEach>
            
        </div>
    </div>
	
	
	</c:if>
	
    
  	
  	<!-- footer -->	
 	<div class="container">
 		<footer class="mb-5">&copy; 2022. Made with <i class="fa-solid fa-heart"></i> in Penang. </footer>
 	</div>
    
    <script src="https://kit.fontawesome.com/e19fcdf015.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
  </body>
</html>