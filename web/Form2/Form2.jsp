<%-- 
    Document   : Form2
    Created on : 06-Oct-2024, 7:39:40 pm
    Author     : gursi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Electronic Repair Request Form</title>
    <link rel="stylesheet" href="Form2.css">
</head>
<body>

<div class="container">
    <h1>Electronic Repair Request Form</h1>
    <form action="submit_request.jsp" method="post">
        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone" pattern="[0-9]{10}" required>

        <label for="device">Device Type:</label>
        <select id="device" name="device" required>
            <option value="">Select Device</option>
            <option value="mobile">Mobile</option>
            <option value="laptop">Laptop</option>
            <option value="tablet">Tablet</option>
            <option value="television">Television</option>
            <option value="other">Other</option>
        </select>

        <label for="issue">Issue Description:</label>
        <textarea id="issue" name="issue" rows="4" placeholder="Describe the problem with your device..." required></textarea>

        <label for="preferredDate">Preferred Service Date:</label>
        <input type="date" id="preferredDate" name="preferredDate" required>

        <input type="submit" value="Submit Request">
    </form>
</div>
       </body>
</html>