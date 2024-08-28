<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignIn Page</title>
</head>
<body>
<br/>
<h2>Login Page</h2>
<form action="usersignin" method="post">
<label>EmailId</label>
<input type="email" name="emailid"/><br/>
<label>Password</label>
<input type="password" name="password"/><br/>
<input type="submit" value="Sign In"/>
<input type="reset" value="reset"/>
</form>

<a href="usersignup">Sign Up</a>

</body>
</html>