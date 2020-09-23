<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>New Director</h2>
	<c:url value="/rest/director" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="director_firstName">
		<label for="_firstName">FirstName:</label>
		<form:input cssStyle="width:300px" id="_firstName" path="firstName"/>
		<br/>
		<form:errors cssClass="errors" id="_firstName" path="firstName"/>
	</div>
	<div id="director_lastName">
		<label for="_lastName">LastName:</label>
		<form:input cssStyle="width:300px" id="_lastName" path="lastName"/>
		<br/>
		<form:errors cssClass="errors" id="_lastName" path="lastName"/>
	</div>
	<div id="director_dateOfBirth">
		<label for="_dateOfBirth">DateOfBirth:</label>
		<form:input cssStyle="width:300px" id="_dateOfBirth" path="dateOfBirth"/>
		<br/>
		<form:errors cssClass="errors" id="_dateOfBirth" path="dateOfBirth"/>
	</div>
	<div id="director_nationality">
		<label for="_nationality">Nationality:</label>
		<form:input cssStyle="width:300px" id="_nationality" path="nationality"/>
		<br/>
		<form:errors cssClass="errors" id="_nationality" path="nationality"/>
	</div>
	<div class="submit" id="director_submit">
		<input id="proceed" type="submit" value="Save"/>
	</div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
