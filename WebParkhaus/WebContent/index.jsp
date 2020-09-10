<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>WebParkhaus</title>
		<script src="https://ccmjs.github.io/mkaul-components/parkhaus/versions/ccm.parkhaus-7.0.0.js"></script>
	</head>
	<body>
	<h1>WebParkhaus</h1>
	<ccm-parkhaus-7-0-0
		name="WebParkhaus"
		Max=10
		server_url="http://localhost:8080/WebParkhaus/Parkhaus"
		extra_buttons='["sum", "avg"]'
		></ccm-parkhaus-7-0-0>
	</body>
</html>
