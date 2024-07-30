<%@page import="com.klef.ep.models.Admin"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="javax.ejb.EJB"%>
<%
Admin admin = (Admin) session.getAttribute("admin");

if (admin == null) {
    response.sendRedirect("sessionexpired.html");
    return;
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin Home</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <link type="text/css" rel="stylesheet" href="css/font-awesome.min.css" />
    <link type="text/css" rel="stylesheet" href="css/owl.carousel.min.css" />
    <link type="text/css" rel="stylesheet" href="css/owl.theme.default.min.css" />
    <link type="image" rel="icon" href="https://upload.wikimedia.org/wikipedia/en/thumb/4/41/Flag_of_India.svg/800px-Flag_of_India.svg.png?20111003033457" />
    <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,600i,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,500i,600,600i" rel="stylesheet">
</head>
<body>

    <!-- Scroll to top arrow -->
    <div id="arrow">
        <i class="fa fa-arrow-up" aria-hidden="true"></i>
    </div>

    <!-- Navigation Bar -->
    <nav>
        <div class="container">
            <div class="menu-par">
                <div class="logo-par">
                    <a href="loggedinadminhome.jsp">
                        <h2>!NDIA</h2>
                    </a>
                </div>
                <div class="nav">
                    <ul>
                        <li><a class="menu_hover" href="logginedadminhome.jsp">Home</a></li>
                        <li><a class="menu_hover" href="displayusers.jsp">View Citizens</a></li>
                        <li><a class="menu_hover" href="addnewplc.indianculture">Add Place</a></li>
                        <li><a class="menu_hover" href="ViewAllPlaces.indianculture">View Place</a></li>
                        <li><a class="menu_hover" href="deletePlace.indianculture">Delete Place</a></li>
                        <li><a class="menu_hover" href="UpdatePlaceDetails.indianculture">Update Place</a></li>
                        <li><a class="menu_hover" href="adminchangepass.indianculture">Change Password</a></li> 
                        <li><a class="menu_hover" href="adminlogout.jsp">Logout</a></li>
                    </ul>
                </div>
                <div class="toggle-btn">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </div>
    </nav>

    <!-- Header Section -->
    <header>
        <div class="container">
            <div class="home_header_info">
                <h3 class="typewrite" data-period="2000" data-type='[ "WELCOME, <%= admin.getUsername() %>!" ]'></h3>
                <p>Manage and celebrate the diversity of India with us.</p>
            </div>
        </div>
        <div class="video">
            <video id="video" autoplay loop muted>
                <source type="video/mp4" src="images/v1.mp4" />
            </video>
        </div>
    </header>

    <!-- JavaScript Files -->
    <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/owl.carousel.min.js"></script>
    <script type="text/javascript" src="js/extrenaljq.js"></script>
</body>
</html>
	