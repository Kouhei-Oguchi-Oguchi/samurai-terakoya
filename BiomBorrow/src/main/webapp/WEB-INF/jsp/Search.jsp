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
	<h1>機器情報検索</h1>
	<form action='SearchServlet' method='post'>
		<lavel for='medicalEquipment'>4桁番号</lavel>
		<input type='text' name='medicalEquipment' pattern='[1-9][0-9]{3}'>
	</form>
</body>
</html>