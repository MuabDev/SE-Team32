<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>WebParkhaus</title>
		<script src="https://ccmjs.github.io/mkaul-components/parkhaus/versions/ccm.parkhaus-9.1.8.js"></script>
	</head>
	<body>
	<h1>WebParkhaus</h1>
	<ccm-parkhaus-9-1-8
		name="WebParkhaus"
		Max=10
		server_url="http://localhost:8080/WebParkhaus/Parkhaus"
		extra_buttons='["state", "sum", "avg"]'
		client_categories='["Kunde","Familie","Mitarbeiter"]'
		price_factor='{"Kunde":"1","Familie":"2","Mitarbeiter":"0"}'
		></ccm-parkhaus-9-1-8>
	</body>
</html>
