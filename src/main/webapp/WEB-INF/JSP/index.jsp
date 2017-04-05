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
	<v:menu />

	<c:if test='${not empty land}'>
		<h2>Soorten uit ${land.naam}</h2>
		<ul class='soorten'>
			<c:forEach items='${land.soorten}' var='soort'>
				<c:url value='' var='soortUrl'>
					<c:param name='id' value='${land.id}' />
					<c:param name='soort' value='${soort.id}' />
				</c:url>
				<a href='${soortUrl}'><li>${soort.naam}</li></a>
			</c:forEach>
		</ul>
	</c:if>

	<c:if test='${not empty soort}'>
		<h2>Wijnen uit ${soort.naam}</h2>
		<ul class='wijnen'>
			<c:forEach items='${soort.wijnen}' var='wijn'>
				<c:url value='' var='wijnUrl'>
					<c:param name='wijn' value='${wijn.id}' />
				</c:url>
				<a href='${wijnUrl}'><li>${wijn.jaar}</a>
				<c:forEach var="i" begin="1" end="${wijn.beoordeling}">
				&#9733;
				</c:forEach>
				</li>
			</c:forEach>
		</ul>
	</c:if>


</body>
</html>