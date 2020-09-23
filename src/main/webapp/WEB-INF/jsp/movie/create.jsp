<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<h2>New Movie</h2>
	<c:url value="/rest/movie" var="action"/>
	<form:form action="${action}" method="POST" modelAttribute="entity">
	<div id="movie_movieName">
		<label for="_movieName">MovieName:</label>
		<form:input cssStyle="width:300px" id="_movieName" path="movieName"/>
		<br/>
		<form:errors cssClass="errors" id="_movieName" path="movieName"/>
	</div>
	<div id="movie_movieLength">
		<label for="_movieLength">MovieLength:</label>
		<form:input cssStyle="width:300px" id="_movieLength" path="movieLength"/>
		<br/>
		<form:errors cssClass="errors" id="_movieLength" path="movieLength"/>
	</div>
	<div id="movie_movieLang">
		<label for="_movieLang">MovieLang:</label>
		<form:input cssStyle="width:300px" id="_movieLang" path="movieLang"/>
		<br/>
		<form:errors cssClass="errors" id="_movieLang" path="movieLang"/>
	</div>
	<div id="movie_releaseDate">
		<label for="_releaseDate">ReleaseDate:</label>
		<form:input cssStyle="width:300px" id="_releaseDate" path="releaseDate"/>
		<br/>
		<form:errors cssClass="errors" id="_releaseDate" path="releaseDate"/>
	</div>
	<div id="movie_ageCertificate">
		<label for="_ageCertificate">AgeCertificate:</label>
		<form:input cssStyle="width:300px" id="_ageCertificate" path="ageCertificate"/>
		<br/>
		<form:errors cssClass="errors" id="_ageCertificate" path="ageCertificate"/>
	</div>
	<div id="movie_domesticTakings">
		<label for="_domesticTakings">DomesticTakings:</label>
		<form:input cssStyle="width:300px" id="_domesticTakings" path="domesticTakings"/>
		<br/>
		<form:errors cssClass="errors" id="_domesticTakings" path="domesticTakings"/>
	</div>
	<div id="movie_internationalTakings">
		<label for="_internationalTakings">InternationalTakings:</label>
		<form:input cssStyle="width:300px" id="_internationalTakings" path="internationalTakings"/>
		<br/>
		<form:errors cssClass="errors" id="_internationalTakings" path="internationalTakings"/>
	</div>
	<div class="submit" id="movie_submit">
		<input id="proceed" type="submit" value="Save"/>
	</div>
	</form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
