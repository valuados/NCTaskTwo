<%--
  Created by IntelliJ IDEA.
  User: valua
  Date: 10/18/2016
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/table.css" type="text/css">
    <title>Add Semirecious Stone</title>
</head>
<body>
<a href="/precious.jsp">Press to add new precious stone</a>
<br><br>
<a href="/index.jsp">Press to go to the start page</a>
<hr>

<form class="semiprecious stone-form" action="semiprecious" method="GET">
        <div><label>Write stone name:</label> <input type="text" name="sname" pattern="[a-zA-Z]+" required></div>
        <div><label>Write stone type:</label><input type="text" name="stype" pattern="[a-zA-Z]+" required></div>
        <div><label>Write stone colour:</label><input type="text" name="scolour" pattern="[a-zA-Z]+" required></div>
        <div><label>Write stone colour feature:</label><input type="text" name="sfeature" pattern="[a-zA-Z]+" required></div>
        <div><label>Write stone solidity:</label><input type="text" pattern="\d+(\.\d+)?" name="ssolidity" required></div>
        <div><label>Write stone dencity:</label><input type="text" pattern="\d+(\.\d+)?" name="sdencity" required></div>
        <div><label>Write stone carat:</label><input type="text" pattern="\d+(\.\d+)?" name="scarat" required></div>
        <div><label>Write stone price per carat:</label><input type="text" pattern="\d+(\.\d+)?" name="sprice" required></div>
        <input type="submit" name="Add" value="Add">

</form>

</body>
</html>
