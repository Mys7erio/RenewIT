<%-- 
    Document   : Form
    Created on : 07-Oct-2024, 12:18:02 am
    Author     : sanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Electronic Repair Request Form</title>
        <link rel="stylesheet" href="./styles/Form.css">
        <link rel="stylesheet" href="index.css" />

    </head>
    <body>
        <h3 style="text-align: left; padding-left: 20px" class="company-name">RenewIT</h3>
        <nav style="position: absolute; top: 0; right:0; padding: 20px;">
            <ul>
                <li class="nav-item"><a href="/homePage.jsp">Services</a></li>
                <li class="nav-item"><a href="UserProfileServlet">Profile</a></li>

            </ul>
        </nav>

        <div class="container"style="margin-top: 8rem;">
            <h1>Electronic Repair Request Form</h1>
            <form action="BookingServlet" method="post">

                <input type="hidden" name="itemType" value="phones" /> 

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="phone">Phone Number:</label>
                <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" required>

                <label for="devicemodel">Device Model:</label>
                <input type="text" id="devicemodel" name="devicemodel" required>

                <label for="issue">Issue Description:</label>
                <textarea id="issue" name="issue" rows="4" placeholder="Describe the problem with your device..." required></textarea>

                <label for="preferredDate">Preferred Service Date:</label>
                <input type="date" id="preferredDate" name="preferredDate" required>

                <label for="preferredTime">Preferred Service Time:</label>
                <input type="time" id="preferredTime" name="preferredTime" required>

                <label for="preferredTime">Upload image</label>
                <input type="file" id="#" name="#" style="background-color:  rgba(75, 85, 99, 1);" required>

                <input type="submit" value="Submit Request">
            </form>
        </div>

    </body>
</html>
