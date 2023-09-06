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
	background: #ffffff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
}
label {
	color: #2F2E2E;
	font-weight: bold;
}
input[type='text'], select, input[type='datetime-local'] {
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
}
input[type='submit'] {
	background-color: #3E67EF;
	color: #ffffff;
	padding: 10px 15px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s;
}
input[type='submit']:hover {
	background-color: #2C44C8;
}
p {
	color: red;
	margin-top: 20px;
}
ul {
	margin-top: 20px;
}
a {
	color: #3E67EF;
	text-decoration: none;
	font-size: 16px;
	font-weight: bold;
	transition: color 0.3s;
}
a:hover {
	color: #2C44C8;
}
</style>
<body>
	<h1>貸出先登録</h1>
	<form action='BorrowServlet' method='post'>
		<label for='Borrow-time'>貸出日</label> <input type='datetime-local'
			id='Borrow-time' name='Borrow-time'> <label
			for='medicalEquiment'>4桁番号</label> <input type='text'
			name='medicalEquiment' pattern='[1-9][0-9]{3}'> <label
			for='department'>部署</label> <select id='department'
			name='department'>
			<option value='1'>本館3階東</option>
			<option value='2'>本館3階西</option>
			<option value='3'>本館2階西</option>
			<option value='4'>介護医療院</option>
			<option value='5'>南館4階病棟</option>
			<option value='6'>南館3階病棟</option>
			<option value='7'>南館2階病棟</option>
			<option value='8'>南館1階病棟</option>
			<option value='9'>南新館</option>
			<option value='10'>リハビリ</option>
		</select> <input type='submit' value='submit'>
	</form>
	<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
	<% if (errorMessage != null && !errorMessage.isEmpty()) { %>
	<p style="color: red;"><%= errorMessage %></p>
	<% } %>
	<ul>
		<li><a href="ReturnStartServlet">Return</a></li>
	</ul>
</body>
</html>