<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<style>

	html{
		padding: 0;
		margin: 0;
		font-family: sans-serif;
		text-align: center;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	form{
		/*width: 100px;*/
		display: flex;
		justify-content: center;
		align-items: center;
		}
	div{
		margin: 20px;
		}
	input{
		text-decoration: none;
		outline: none;
		border: none;
		border-radius: 8px;
		font-size: 20px;
		color: tomato;
		border: 2px solid rgba(0,0,0,0.4);
		padding: 6px 10px;
	}
	#submitbtn{
		display: block;
		border: 2px solid black;
		padding: 6px 10px;
	}
</style>
</head>
<body>
	<h1>Welcome, Register Yourself.</h1>
	<form action="welcome.jsp" method="post">
	<div>
			Username: <input type="text" placeholder="Enter username" name="username">
	</div>
	<div>
		E-mail: <input type="email" placeholder="Enter email" name="email">
	</div>
	<div>
		Password: <input type="password" placeholder="Enter password" name="password">
	</div>
	<div>
		<input type="submit" value="Register" id="submitbtn"/>
	</div>
	</form>
</body>
</html>