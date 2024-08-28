<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Page</title>
</head>
<body>
<br/>
<h3>${msg}</h3>
<h2>Sign Up Page</h2>
<form action="usersignup" method="post">
<label>EmailId</label>
<input type="email" name="emailid"/><br/>
<label>User Type</label>
<select name="usertype">
<option value="Admin">Admin</option>
<option value="Customer">Customer</option>
</select>
<br/>
<label>Password</label>
<input type="password" name="password"/><br/>
<input type="submit" value="Sign Up"/>
<input type="reset" value="reset"/>
</form>

<a href="usersignin">Sign In</a>

</body>
</html>