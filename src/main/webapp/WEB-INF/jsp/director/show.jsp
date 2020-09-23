<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<c:if test="${not empty result}">
		<div id="director_firstName">
			<label for="_firstName">FirstName:</label>
			<div class="box" id="_firstName">${result.firstName}</div>
		</div>
		<br/>
		<div id="director_lastName">
			<label for="_lastName">LastName:</label>
			<div class="box" id="_lastName">${result.lastName}</div>
		</div>
		<br/>
		<div id="director_dateOfBirth">
			<label for="_dateOfBirth">DateOfBirth:</label>
			<div class="box" id="_dateOfBirth">${result.dateOfBirth}</div>
		</div>
		<br/>
		<div id="director_nationality">
			<label for="_nationality">Nationality:</label>
			<div class="box" id="_nationality">${result.nationality}</div>
		</div>
		<br/>
	</c:if>
	<c:if test="${empty result}">No Director found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
