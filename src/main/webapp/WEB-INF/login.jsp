<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css" >
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">
<style type="text/css">
 /* Add your registration form styling here */
    .login-form {
        background-color: #f2f2f2;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0px 0px 10px 0px #ccc;
        margin: 50px auto;
        width: 500px;
      }

      .form-control {
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
        margin-top: 6px;
        margin-bottom: 16px;
        resize: vertical;
      }
      
      .error {
        color: red;
        font-weight: bold;
        text-align: center;
        padding: 10px;
      }

      input[type=submit] {
        background-color: #4CAF50;
        color: white;
        padding: 12px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }

      input[type=submit]:hover {
        background-color: #45a049;
      }
</style>
</head>
<body>

	<ul>
		<li class="logo"><img src="logo.png" alt="Logo"></li>
		<li class="center">BookMyMovie</li>
		
		<li><a href="registration" style="text-decoration: none">Register</a></li>
		<li><a href="index.html" style="text-decoration: none" >Home</a></li>
	</ul>

	<!-- Add your registration form below -->
   <div class="login-form">
      <h2>Customer Login</h2>
      <%
      	if(request.getAttribute("errorMsg")!= null){
      %>	
      	<p class="error"><%=request.getAttribute("errorMsg")%></p>
      <% 
      	}
      %>
      
      <form action="login" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control" required>

        <input type="submit" style="width:100%;" value="Submit">
      </form>
    </div>

</body>
</html>
