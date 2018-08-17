    <%@page import="org.springframework.validation.ObjectError"%>
<%@ page import="com.candidjava.spring.entity.User" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.err
{
color:red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

	<h2>Simple spring form handling</h2>
	<form action="register" method="POST" modelAttribute="user">
	Name:<input type="text"name="name"/><br>
Gender : Male<input type="radio" name="gender" value="male" path="gender"/>   Female<input type="radio"  name="gender" value="female" path="gender"/><br>
	Email : <input type="text" name="email" path="email"/><br>
	Country : <select name="country" path="country">
					<option value="">select country</option>
					<option value="india">INDIA</option>
					<option value="usa">USA</option>
					<option value="china">CHINA</option>
				 </select>
				 
				<br>  
				Password:<input type="password" name="password" path="password"/><br>  
				<input type="submit" value="submit" />
	</form>
</body>
</html>