<%@page import="com.klef.ep.models.User"%>

<%
    // Retrieve the user object from the session
    User ur = (User)session.getAttribute("us");
    if (ur == null) {
        response.sendRedirect("sessionexpired.html");
        return; // Ensure the rest of the page doesn't execute if redirected
    }

    // Retrieve the username from the User object
   
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Registered User Home</title>
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
                    <a href="registereduserhome.jsp">
                        <h2>!NDIA</h2>
                    </a>
                </div>
                <div class="nav">
                    <ul>
                        <li><a class="menu_hover" href="registereduserhome.jsp">Home</a></li>
                        <li><a class="menu_hover" href="userviewallplaces.indianculture">View Tourist Places</a></li>
                        <li><a class="menu_hover" href="MoreOptions.html">Explore More</a></li>
                       <li><a class="menu_hover" href="userchangepass.indianculture">Change Password</a></li> 
                        <li><a class="menu_hover" href="userprofile.jsp">Profile</a></li>
                        <li><a class="menu_hover" href="userlogout.jsp">Logout</a></li>
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
                <h3 class="typewrite" data-period="2000" data-type='[ "WELCOME, <%= ur.getName()%>!" ]'></h3>
                <p>Welcome to a land where every corner tells a story, and every story is a celebration of life.</p>
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
