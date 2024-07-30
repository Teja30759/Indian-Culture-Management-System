<%@page import="com.klef.ep.models.User"%>

<%
User ur = (User)session.getAttribute("us");
if(ur == null)
{
    response.sendRedirect("sessionexpired.html");
}
%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:f="http://www.w3.org/jsf/core"
      xmlns:h="http://www.w3.org/jsf/html">

<head>
    <title>Employee Home</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <link type="text/css" rel="stylesheet" href="css/font-awesome.min.css" />

    <!-- Add CSS for transparent card -->
    <style>
        body {
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        .video {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: -1; /* Behind other content */
            overflow: hidden;
        }

        .video video {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .card {
            background-color: rgba(255, 255, 255, 0.8); /* White with 80% opacity */
            border-radius: 15px; /* Rounded corners */
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            padding: 20px;
            max-width: 400px;
            margin: auto; /* Center the card horizontally */
            position: absolute;
            top: 50%; /* Position the card 50% from the top */
            left: 50%; /* Position the card 50% from the left */
            transform: translate(-50%, -50%); /* Center the card vertically and horizontally */
            border: 1px solid #ddd; /* Optional border */
            text-align: center;
            z-index: 1; /* On top of the video */
        }

        .card h3, .card h4 {
            margin-bottom: 20px;
        }

        .card a {
            text-decoration: none;
            color: #333;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
            margin: 5px;
        }

        .card a:hover {
            background-color: #ddd;
        }

        .card .info {
            margin-bottom: 20px;
            text-align: left;
        }

        .card .info p {
            margin: 10px 0;
        }

        .card .info label {
            font-weight: bold;
        }

        nav {
            background-color: #333;
            color: white;
            padding: 10px;
            position: absolute;
            top: 0;
            width: 100%;
            z-index: 1; /* On top of other content */
        }

        nav .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        nav .logo-par h2 {
            margin: 0;
        }

        nav .nav ul {
            list-style: none;
            margin: 0;
            padding: 0;
        }

        nav .nav ul li {
            display: inline;
            margin-right: 10px;
        }

        nav .nav ul li a {
            color: white;
            text-decoration: none;
            padding: 10px;
            border-radius: 5px;
        }

        nav .nav ul li a:hover {
            background-color: #555;
        }
    </style>
</head>

<body>

    <!-- Navbar from index.html -->
    <nav>
        <div class="container">
            <div class="logo-par">
                <a href="index.html">
                    <h2>!NDIA</h2>
                </a>
            </div>
            <div class="nav">
                <ul>
                    <li><a class="menu_hover" href="registereduserhome.jsp">Home</a></li>
                    <li><a class="menu_hover" href="userlogout.jsp">Logout</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Header Section with Video Background -->
    <header>
        <div class="video">
            <video id="video" autoplay="autoplay" loop="loop" muted="muted">
                <source type="video/mp4" src="images/v1.mp4" />
            </video>
        </div>
    </header>

    <!-- User Profile Card Centered Above Video -->
    <div class="card">
        <h2>Profile</h2>
        
        <div class="info">
            <p><strong>Name:</strong> <%=ur.getName()%></p>
            <p><strong>Contact:</strong> <%=ur.getNumber() %></p>
            <p><strong>Email:</strong> <%=ur.getEmail() %></p>
        </div>
    </div>

</body>

</html>
