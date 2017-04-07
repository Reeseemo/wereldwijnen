<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt'%>
<%@taglib uri='http://vdab.be/tags' prefix='v'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title='Wereldwijnen' />
</head>
<body>

	<c:if test='${not empty wijn}'>
		<h1>Wijn toevoegen aan mandje</h1>
		<a href="./index.htm" class="Home">Terug naar overzicht</a>

		<table>
			<tr>
				<th scope="row">Land</th>
				<td>${land.naam}</td>
			</tr>
			<tr>
				<th scope="row">Soort</th>
				<td>${soort.naam}</td>
			</tr>
			<tr>
				<th scope="row">Jaar</th>
				<td>${wijn.jaar}</td>
			</tr>
			<tr>
				<th scope="row">Beoordeling</th>
				<td><c:forEach var="i" begin="1" end="${wijn.beoordeling}">
				&#9733;
				</c:forEach></td>
			</tr>
			<tr>
				<th scope="row">Prijs</th>
				<td>${wijn.prijs}</td>
			</tr>

		</table>

	</c:if>


</body>
</html>