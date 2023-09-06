<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.BorrowDate"%>
<%@ page import="model.MedicalEquipment"%>
<%@ page import="model.Place"%>
<%@ page import="java.time.format.DateTimeFormatter"%>

<%
BorrowDate borrowdays = (BorrowDate) session.getAttribute("borrowdays");
MedicalEquipment medicalEquipmen = (MedicalEquipment) session.getAttribute("medicalEquipmen");
String placename = (String) session.getAttribute("placename");
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
String formattedDate = borrowdays.getBorrowdays().toLocalDate().format(formatter);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BorrowDone</title>
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
p {
	color: #2F2E2E;
	font-size: 16px;
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
	margin-right: 15px;
}

a:last-child {
	margin-right: 0;
}
a:hover {
	color: #2C44C8;
}
</style>
</head>
<body>
	<h1>貸出登録終了</h1>
	<p>
		<%=medicalEquipmen.getMedicalEquipmen()%>
		を
		<%=placename%>へ貸出登録完了
	</p>
	<p>
		貸出日時:<%=formattedDate%></p>
	<ul>
		<li><a href="BorrowStartServlet">Borrow</a></li>
		<li><a href="ReturnStartServlet">Return</a></li>
	</ul>
</body>
</html>



