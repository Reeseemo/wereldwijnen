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
	<h1>Mandje</h1>
	<a href='<c:url value='/index.htm'/>'>Terug naar overzicht</a>

	<c:if test='${not empty wijnInMandje}'>

		<table>
			<tr>
				<th>Wijn</th>
				<th>Prijs</th>
				<th>Aantal</th>
				<th>Te betalen</th>
			</tr>
			<c:forEach var="wijn" items='${wijnInMandje}'>
				<tr>
					<td>${land.naam}${wijn.soort.naam}${wijn.jaar}</td>
					<td>${wijn.prijs}</td>
					<td>${bestelbonlijn.aantal}</td>
					<td>${wijn.prijs * bestelbonlijn.aantal}</td>
				</tr>
			</c:forEach>
		</table>


		<form method='post' id='bestelbonform'>

			<label>Naam:<span>${fouten.naam}</span> <input name='naam'
				value='${param.naam}'>
			</label> <label>Straat:<span>${fouten.straat}</span> <input
				name='straat' value='${param.straat}'>
			</label> <label>Huisnummer:<span>${fouten.huisnummer}</span> <input
				name='huisnummer' value='${param.huisnummer}'>
			</label> <label>Postcode:<span>${fouten.postcode}</span> <input
				name='postcode' value='${param.postcode}'>
			</label> <label>Gemeente:<span>${fouten.gemeente}</span> <input
				name='gemeente' value='${param.gemeente}'>
			</label>

			<div>
				<label><span>${fouten.afhalen}</span> <input type='radio'
					name='methode' value='afhalen' ${param.afhalen ? 'checked' : ''}>Afhalen</label><br>
				<label> <input type='radio' name='methode' value='opsturen'
					${param.opsturen ? 'checked' : ''}>Opsturen
				</label>
			</div>

			<input type='submit' value='Als bestelbon bevestigen'
				id='toevoegknop'>
		</form>
		<script>
			document.getElementById('toevoegform').onsubmit = function() {
				document.getElementById('toevoegknop').disabled = true;
			};
		</script>

	</c:if>









</body>
</html>