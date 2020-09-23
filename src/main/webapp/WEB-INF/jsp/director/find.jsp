<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>Find Directors</h2>
	<c:url value="/rest/director/find" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">

	<div class="submit" id="director_submit">
		<input id="proceed" type="submit" value="Submit"/>
	</div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>