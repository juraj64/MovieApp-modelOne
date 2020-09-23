<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<c:if test="${not empty result}">
		<div id="actor_firstName">
			<label for="_firstName">FirstName:</label>
			<div class="box" id="_firstName">${result.firstName}</div>
		</div>
		<br/>
		<div id="actor_lastName">
			<label for="_lastName">LastName:</label>
			<div class="box" id="_lastName">${result.lastName}</div>
		</div>
		<br/>
		<div id="actor_dateOfBirth">
			<label for="_dateOfBirth">DateOfBirth:</label>
			<div class="box" id="_dateOfBirth">${result.dateOfBirth}</div>
		</div>
		<br/>
	</c:if>
	<c:if test="${empty result}">No Actor found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
