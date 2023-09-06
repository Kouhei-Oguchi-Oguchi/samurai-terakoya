<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.MedicalEquipment"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.LocalDateTime"%>
<%
MedicalEquipment medicalEquipmentValue = (MedicalEquipment) session.getAttribute("medicalEquipmentValue");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>SearchResult</title>
<style>
body {
	font-family: 'Arial', sans-serif;
	background-color: #FAFAFA;
	color: #333;
	padding: 20px;
}

h1 {
	color: #2F2E2E;
	border-bottom: 2px solid #3E67EF;
	padding-bottom: 10px;
	margin-top: 50px;
}

.container {
	display: flex;
	align-items: center;
}

.container img {
	margin-left: 20px;
	height: 200px;
	width: auto;
}

.info {
	margin-right: 30px;
}

.info-label {
	font-weight: bold;
	margin-right: 10px;
}

a {
	color: #3E67EF;
	text-decoration: none;
}

a:hover {
	color: #2C44C8;
}
</style>
</head>

<body>
	<h1>機器情報</h1>
	<div class="container">
		<div class="info">
			<p>
				<%
				LocalDateTime returnDate = medicalEquipmentValue.getReturnDate();
				String returnDateString;
				if (returnDate == null) {
					returnDateString = "貸出中";
				} else {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					returnDateString = returnDate.format(formatter);
				}
				%>
				<span class="info-label">MENO:</span>
				<%=medicalEquipmentValue.getMedicalEquipmen()%><br> <span
					class="info-label">型式:</span>
				<%=medicalEquipmentValue.getModelNumber()%><br> <span
					class="info-label">S/N:</span>
				<%=medicalEquipmentValue.getSerialNumber()%><br> <span
					class="info-label">製造会社:</span>
				<%=medicalEquipmentValue.getManufacturer()%><br> <span
					class="info-label">導入日:</span>
				<%=medicalEquipmentValue.getIntroducedDate()%><br> <span
					class="info-label">貸出日:</span>
				<%=medicalEquipmentValue.getBorrowDate()%><br> <span
					class="info-label">返却日:</span><%=returnDateString%><br> <span
					class="info-label">現在地:</span>
				<%=medicalEquipmentValue.getPlace()%><br>
			</p>
		</div>
		<img src="<%=session.getAttribute("imageFileName")%>"
			alt="Medical Equipment Image">
	
	</div>
</body>

</html>
