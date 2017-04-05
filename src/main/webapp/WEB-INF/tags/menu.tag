<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<div id="intro">
	<h1>Wereldwijnen</h1>
	<c:forEach items='${landen}' var='land'>
		<c:url value='' var='url'>
			<c:param name='id' value='${land.id}' />
		</c:url>
		<a href='${url}'><img src='<c:url value='images/${land.id}.png'/>'
			alt='${land.id}' id='${land.id}' /></a>
	</c:forEach>
</div>

