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
	<div id="intro">
		<h1>Wereldwijnen</h1>
		<c:forEach items='${landen}' var='land'>
			<c:url value='' var='url'>
				<c:param name='id' value='${land.id}' />
			</c:url>
			<a href='${url}'><img
				src='<c:url value='images/${land.id}.png'/>' alt='${land.id}'
				id='${land.id}' /></a>
		</c:forEach>
	</div>

	<c:if test='${not empty land}'>
		<h2>Soorten uit ${land.naam}</h2>
		<ul class='soorten'>
			<c:forEach items='${land.soorten}' var='soort'>
				<c:url value='' var='soortUrl'>
					<c:param name='id' value='${land.id}' />
					<c:param name='soort' value='${soort.id}' />
				</c:url>
				<li><a href='${soortUrl}'>${soort.naam} </a></li>
			</c:forEach>
		</ul>
	</c:if>

	<c:if test='${not empty soort}'>
		<h2>Wijnen uit ${soort.naam}</h2>
		<ul class='wijnen'>
			<c:forEach items='${soort.wijnen}' var='wijn'>
				<c:url var='wijnUrl' value='/details.htm'>
					<c:param name='id' value='${land.id}' />
					<c:param name='soort' value='${soort.id}' />
					<c:param name='wijn' value='${wijn.id}' />
				</c:url>
				<li><a href='${wijnUrl}'>${wijn.jaar}</a> <c:forEach var="i"
						begin="1" end="${wijn.beoordeling}">
				&#9733;
				</c:forEach></li>
			</c:forEach>
		</ul>
	</c:if>


</body>
</html>