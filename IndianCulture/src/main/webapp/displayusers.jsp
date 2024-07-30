<%@page import="com.klef.ep.models.Admin"%>
<%@page import="com.klef.ep.models.User"%>
<%@page import="java.util.List"%>
<%@page import="com.klef.ep.services.AdminService"%>
<%@page import="javax.naming.InitialContext"%>

<%
Admin admin = (Admin) session.getAttribute("admin");

if (admin == null) {
    response.sendRedirect("sessionexpired.html");
}

// JSP with JPA Integration
InitialContext context = new InitialContext();
AdminService adminService = (AdminService) context.lookup("java:global/IndianCulture/AdminServiceIMPL!com.klef.ep.services.AdminService");

List<User> userlist = adminService.viewallusers();
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View All Employees</title>

    <!-- CSS Styles -->
    <style>
        /* General body styling */
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            overflow: hidden;
            color: #333;
        }

        h3 {
            color: #444;
            margin-top: 20px;
        }

        /* Video Background styling */
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

        /* Buttons styling */
        .button-container {
            position: absolute;
            top: 10px;
            width: 100%;
            display: flex;
            justify-content: space-between; /* Space between left and right */
            padding: 0 20px; /* Add padding to prevent buttons from touching edges */
            box-sizing: border-box; /* Include padding in width calculation */
            z-index: 1; /* Ensure buttons are above the video */
        }

        .button-container .left-buttons {
            display: flex;
            gap: 10px; /* Space between buttons on the left */
        }

        .button-container a {
            text-decoration: none;
            color: #fff;
            background-color: rgba(0, 0, 0, 0.6); /* Semi-transparent black */
            padding: 10px 20px;
            border-radius: 5px;
            border: 1px solid #ddd;
            transition: background-color 0.3s ease, color 0.3s ease;
            font-weight: bold;
        }

        .button-container a:hover {
            background-color: rgba(0, 0, 0, 0.8);
            color: #fff;
        }

        /* Table styling */
        .table-container {
            margin-top: 80px; /* To create space between buttons and table */
            overflow-y: auto; /* If needed for large tables */
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: separate; /* Allows for rounded corners */
            border-spacing: 0; /* Remove default spacing */
            box-shadow: none; /* Remove shadow for transparency */
            background-color: rgba(255, 255, 255, 0.4); /* Semi-transparent background */
            border-radius: 15px; /* Rounded corners */
            z-index: 1;
        }

        th, td {
            padding: 15px;
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.3); /* Light transparent border */
        }

        th {
            background: rgba(0, 0, 0, 0.5); /* Semi-transparent background */
            color: white;
            font-weight: bold;
            border-top-left-radius: 15px; /* Rounded corners for the top */
            border-top-right-radius: 15px; /* Rounded corners for the top */
        }

        td {
            background-color: rgba(255, 255, 255, 0.5); /* Semi-transparent cell background */
        }

        tr:nth-child(even) td {
            background-color: rgba(240, 240, 240, 0.5); /* Semi-transparent alternating rows */
        }

        tr:hover td {
            background-color: rgba(220, 220, 220, 0.7); /* Slightly darker hover effect */
        }

        /* Welcome message styling */
        .welcome-message {
            text-align: center;
            margin: 20px;
            font-size: 18px;
            z-index: 1; /* Ensure it stays above video */
            position: relative;
            color: white;
        }
    </style>
</head>
<body>

<!-- Video Background -->
<div class="video">
    <video id="video" autoplay="autoplay" loop="loop" muted="muted">
        <source type="video/mp4" src="images/v1.mp4" />
    </video>
</div>

<!-- Navigation Buttons -->
<div class="button-container">
    <div class="left-buttons">
        <a href="logginedadminhome.jsp">Home</a>
        <a href="displayusers.jsp">View Citizens</a>
    </div>
    <a href="adminlogout.jsp">Logout</a>
</div>

<!-- Welcome message -->
<div class="welcome-message">
    Welcome <%=admin.getUsername()%>
</div>

<!-- Employee Table -->
<div class="table-container">
    <table align="center">
        <thead>
            <tr>
                <th>Name</th>
                <th>Gender</th>
                <th>Email</th>
                <th>Contact No</th>
            </tr>
        </thead>
        <tbody>
            <%
            for(User user : userlist)
            {
            %>
                <tr>
                    <td><%=user.getName()%></td>
                    <td><%=user.getGender()%></td>
                    <td><%=user.getEmail()%></td>
                    <td><%=user.getNumber()%></td>
                </tr>
            <%
            }
            %>
        </tbody>
    </table>
</div>

</body>
</html>
	