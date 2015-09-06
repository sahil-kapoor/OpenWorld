<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
     <link rel="stylesheet" type="text/css" href="/css/home.css" />
     <link rel="stylesheet" type="text/css" href="/css/registration.css" />
    <title>Log in</title>
</head>
<body>
<nav role="navigation">
   <div id="cssmenu">
	    <ul>
	        <li><a href="/">Home</a></li>
	    </ul>
	 </div>
</nav>

<div id="cssmenu">
	<ul>
		<li><a href="/users">All users</a></li> 
	</ul>
</div>

<div id="wrapper">
<form role="form" action="/login" method="post">
	<fieldset>
	<h1>Log in</h1>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div>
        <input type="email" name="email" id="email" placeholder="Email" required autofocus/>
    </div>
    <div>
        <input type="password" name="password" id="password"  placeholder="Password" required/>
    </div>
    <div>
        <label for="remember-me">Remember me</label>
        <input type="checkbox" name="remember-me" id="remember-me"/>
    </div>
    <button type="submit">Sign in</button>
    </fieldset>

</form>
</div>
<#if error.isPresent()>
<p>The email or password you have entered is invalid, try again.</p>
</#if>
</body>
</html>