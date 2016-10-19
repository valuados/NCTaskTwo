<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <script src="js/jquery-3.1.0.js"></script>
    <script type="text/javascript" src="js/price.js"></script>
    <script type="text/javascript" src="js/weight.js"></script>

    <link rel="stylesheet" href="css/table.css" type="text/css">
    <title>Task Two</title>
  </head>
  <body>
  <a href="/precious.jsp">Press to add new precious stone</a>
  <br><br>
  <a href="/semiprecious.jsp">Press to add new semiprecious stone</a>
  <br><br>

  <form action="indexpage" method="GET">
    <input type="submit" value="Show stones"/>
    <input type="hidden" name="command" value="show">
  </form>
  <form action="indexpage" method="GET">
    <input type="submit" value="Show stones sorted by weight"/>
    <input type="hidden" name="command" value="show by weight">
  </form>
  <form action="indexpage" method="GET">
    <input type="submit" value="Show stones sorted by price"/>
    <input type="hidden" name="command" value="show by price">
  </form>
  <hr>

  <input type="submit" onclick="priceCount()" name="Show" value="Show">
  <span class="price">Total price:</span><br>
  <input type="submit" onclick="weightCount()" name="Show" value="Show">
  <span class="weight">Total weight:</span><br><br>

    <table border = 1 width="300px">
    <tr>
      <th>STONE NAME</th>
      <th>TYPE</th>
      <th>COLOUR</th>
      <th>COLOUR FEATURE</th>
      <th>SYNGONY</th>
      <th>SOLIDITY</th>
      <th>DENSITY</th>
      <th>CARAT</th>
      <th>PRICE PER CARAT($)</th>
    </tr>
      <c:forEach var="necklace" items="${necklace}" varStatus="loopStatus">
        <tr class="${loopStatus.index % 2 == 0 ? 'even' : 'odd'}">
          <c:set var="sonclass" scope="session" value="${necklace.sonClass}"/>
          <c:if test="${sonclass=='1'}">
            <td><c:out value="${necklace.name}"></c:out></td>
            <td><c:out value="${necklace.type}"></c:out></td>
            <td><c:out value="${necklace.colour}"></c:out></td>
            <td><c:out value="None"></c:out></td>
            <td><c:out value="${necklace.syngony}"></c:out></td>
            <td><c:out value="${necklace.solidity}"></c:out></td>
            <td><c:out value="${necklace.density}"></c:out></td>
            <td><c:out value="${necklace.carat}"></c:out></td>
            <td><c:out value="${necklace.price}"></c:out></td>

          </c:if>
          <c:if test="${sonclass=='2'}">
            <td><c:out value="${necklace.name}"></c:out></td>
            <td><c:out value="${necklace.type}"></c:out></td>
            <td><c:out value="${necklace.colour}"></c:out></td>
            <td><c:out value="${necklace.colorFeatures}"></c:out></td>
            <td><c:out value="None"></c:out></td>
            <td><c:out value="${necklace.solidity}"></c:out></td>
            <td><c:out value="${necklace.density}"></c:out></td>
            <td><c:out value="${necklace.carat}"></c:out></td>
            <td><c:out value="${necklace.price}"></c:out></td>
          </c:if>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
