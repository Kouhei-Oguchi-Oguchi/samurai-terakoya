<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BiomBorrow</title>
<style>
body {
	font-family: 'Arial', sans-serif;
	background-color: #F7F8FA;
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
}

h1 {
	color: #2F2E2E; 
	margin-bottom: 20px;
}

ul {
	display: flex;
	justify-content: center;
	padding: 0;
}

li {
	list-style-type: none;
	margin: 0 15px; 
}

a {
	color: #3E67EF; 
	text-decoration: none;
	font-size: 20px;
	font-weight: bold;
	transition: color 0.3s;
}

a:hover {
	color: #2C44C8; /* クリック時の色を少し暗く */
}
</style>
</head>
<body>
	<h1>BiomBorrow</h1>
	<ul>
		<li><a href="BorrowStartServlet">Borrow</a></li>
		<li><a href="ReturnStartServlet">Return</a></li>
		<li><a href="SearchStartServlet">Search</a></li>
	</ul>
</body>
</html>