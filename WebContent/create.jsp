<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
</head>
<body>
	<form action="NewUser" method="post">
		<label for="first_name">First Name: </label>
		<input id="first_name" type="text" name="first_name">
		<br>
		<label for="last_name">Last Name: </label>
		<input id="last_name" type="text" name="last_name">
		<br>
		<label for="user_name">User Name: </label>
		<input id="user_name" type="text" name="user_name"> 
		<br>
		<label for="accounts">Choose the account you would like to open!</label>
		<select id="accounts" name="account_type">
			<option value="1"> Checking </option>
			<option value="2"> Savings </option>
			<option value="3"> Stock Bond </option>
		</select><br>
		<input type="submit" value="Create Account">
	</form>
	
</body>
</html>