<%-- 
    Document   : feedback
    Created on : 07-Oct-2024, 1:11:03 am
    Author     : gursi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Feedback Form</title>
    <link rel="stylesheet" href="./styles/feedback.css">
</head>
<body>

<div class="container">
    <h1>Customer Feedback</h1>
    <form action="submit_feedback.jsp" method="post">
        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="rating">Rate Our Service:</label>
        <select id="rating" name="rating" required>
            <option value="">Select Rating</option>
            <option value="1">1 - Very Poor</option>
            <option value="2">2 - Poor</option>
            <option value="3">3 - Average</option>
            <option value="4">4 - Good</option>
            <option value="5">5 - Excellent</option>
        </select>

        <label for="feedback">Your Feedback:</label>
        <textarea id="feedback" name="feedback" rows="5" placeholder="Tell us about your experience..." required></textarea>

        <input type="submit" value="Submit Feedback">
    </form>
</div>

</body>
</html>
