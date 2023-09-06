<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BiomBorrow</title>
</head>
<style>
body {
	font-family: 'Arial', sans-serif;
	background-color: #F7F8FA;
	height: 100vh;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	padding: 30px;
}

h1 {
	color: #2F2E2E;
	margin-bottom: 20px;
}

form {
    display: flex;
	flex-direction: column;
	gap: 15px;
	width: 300px;
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

label, input {
	color: #2F2E2E;
	font-weight: bold;
}

input[type="submit"] {
	background-color: #3E67EF;
	color: #ffffff;
	border: none;
	border-radius: 4px;
	padding: 10px 15px;
	cursor: pointer;
	transition: background-color 0.3s;
}

input[type="submit"]:hover {
	background-color: #2C44C8;
}

p[style="color: red;"] {
	color: red;
	background-color: #ffe1e1;
	padding: 10px;
	border-radius: 4px;
}

ul {
	margin-top: 20px;
}

a {
	color: #3E67EF;
	text-decoration: none;
	font-weight: bold;
	margin-right: 15px;
	transition: color 0.3s;
}

a:hover {
	color: #2C44C8;
}
</style>
<body>
	<h1>返却先登録</h1>
	<form action='ReturnServlet' method='post'>
		<label for='Return-time'>返却日</label> <input type='datetime-local'
			id='Return-time' name='Return-time'> <label
			for='medicalEquiment'>4桁番号</label><input type='text'
			name='medicalEquiment' pattern='[1-9][0-9]{3}'> <input
			type='submit' value='submit'>
	</form>
	<%String errorMessage = (String) request.getAttribute("errorMessage"); %>
	<% if (errorMessage != null && !errorMessage.isEmpty()) { %>
	<p style="color: red;"><%= errorMessage %></p>
	<% } %>
	<ul>
		<li><a href="BorrowStartServlet">Borrow</a></li>
	</ul>
</body>
</html>