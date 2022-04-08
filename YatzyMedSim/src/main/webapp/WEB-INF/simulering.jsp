<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simulering</title>
</head>
<body>

    <form action="SimulereSpillServlet" method="post">
        <h2>Yahtzee</h2>
        <table>

            <tr bgcolor="#cccccc">
                <th>Deltakere</th>
                <c:forEach items="${deltakere}" var="deltaker">
                    <th><c:out value="${deltaker.navn}" /></th>
                </c:forEach>
            </tr>

            <c:forEach items="${runder}" var="runde" varStatus="loop">
                <tr>
                    <td><c:out value="${runde}" /></td>
                    <c:forEach items="${tabell[loop.index]}" var="rekke">
                            <td><c:out value="${rekke}" /></td>
                       
                    </c:forEach>
                </tr>
            </c:forEach>


        </table>
    </form>


    <p>
        <a href="MenyServlet">Tilbake til meny</a>
    </p>

</body>
</html>