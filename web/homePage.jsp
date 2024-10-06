<%-- 
Document   : homePage
    Created on : 6 Oct 2024, 4:40:52 pm
    Author     : sanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/homePage.css"/>
        <link rel="stylesheet" href="index.css" />
        <title>RenewIT | Request Services</title>
    </head>
    <body>
        <h3 class="company-name">RenewIT</h3>
        <nav>
            
            <ul>
                <li class="nav-item"><a href="#">Services</a></li>
                <li class="nav-item"><a href="#">Bookings</a></li>
                <li class="nav-item"><a href="UserProfileServlet">Profile</a></li>

            </ul>
        </nav>
        <h1><img class="homepage-img" src="styles/tools.svg" alt="services"/> 
            SERVICES</h1>
        <h3>Expert Tech Support for All Your Devices.</h3>
        <div class="homepage-div">
            <article class="card">
  <img
    class="card__background"
    src="https://images.unsplash.com/photo-1514826786317-59744fe2a548?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    alt="Photo of Cartagena's cathedral at the background and some colonial style houses"
    width="1920"
    height="2193"
  />
  <div class="card__content | flow">
    <div class="card__content--container | flow">
      <h2 class="card__title">Computer</h2>
      <p class="card__description">
        Experienced technicians provide diagnostics, repairs, and upgrades for all types of computers and laptops.
      </p>
    </div>
    <button class="card__button">Book Service</button>
  </div>
</article>
            <article class="card">
  <img
    class="card__background"
    src="https://images.unsplash.com/photo-1618658848098-354b39109799?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    alt="Photo of Cartagena's cathedral at the background and some colonial style houses"
    width="1920"
    height="2193"
  />
  <div class="card__content | flow">
    <div class="card__content--container | flow">
      <h2 class="card__title">Mobile</h2>
      <p class="card__description">
        Expert technicians diagnose and repair all types of mobile devices, from smartphones to tablets, quickly and efficiently.
      </p>
    </div>
    <button class="card__button">Book Service</button>
  </div>
</article>
            <article class="card">
  <img
    class="card__background"
    src="https://images.unsplash.com/photo-1593305841991-05c297ba4575?q=80&w=1957&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    alt="Photo of Cartagena's cathedral at the background and some colonial style houses"
    width="1920"
    height="2193"
  />
  <div class="card__content | flow">
    <div class="card__content--container | flow">
        <h2 class="card__title">Gaming</h2>
      <p class="card__description">
        Specialized technicians offer expert repairs, and upgrades for all major gaming consoles and accessories.
      </p>
    </div>
    <button class="card__button">Book Service</button>
  </div>
</article>
        </div>
    </body>
</html>