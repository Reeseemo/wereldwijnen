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
		<c:url value='' var='soortUrl'>
			<c:param name='id' value='${soort.id}' />
			<c:param name='soort' value='true' />
		</c:url>
		<ul class='soorten'>
			<c:forEach items='${land.soorten}' var='soort'>
				<a href='${soortUrl}'><li>${soort.naam}</li></a>
			</c:forEach>
		</ul>
	</c:if>

</body>
</html>