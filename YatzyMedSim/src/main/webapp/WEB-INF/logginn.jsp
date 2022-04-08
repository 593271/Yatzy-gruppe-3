<%-- Setter contentType og tegnsett --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
    href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Logg inn</title>
</head>
<body>
    <h2>Logg inn</h2>
    
    <p>Det er kun registrerte spillere som får spille.</p>
    <p>
        Trykk <a href="registerservlet">her</a> for å registrere deg
    </p>
     <p>
        <font color="red">${loginMessage}</font>
    </p>
    <form method="post" class="pure-form pure-form-aligned">
        <fieldset>
            <div class="pure-control-group">
                <label for="epost">Epost:</label> <input type="text"
                    name="epost" />
            </div>
            <div class="pure-control-group">
                <label for="passord">Passord:</label> <input
                    type="password" name="passord" />
            </div>
            <div class="pure-controls">
                <button type="submit"
                    class="pure-button pure-button-primary">Logg
                    inn</button>
            </div>
     
        </fieldset>
    </form>

</body>
</html>