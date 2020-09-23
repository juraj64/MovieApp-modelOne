<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
	<c:if test="${not empty result}">
		<div id="movie_movieName">
			<label for="_movieName">MovieName:</label>
			<div class="box" id="_movieName">${result.movieName}</div>
		</div>
		<br/>
		<div id="movie_movieLength">
			<label for="_movieLength">MovieLength:</label>
			<div class="box" id="_movieLength">${result.movieLength}</div>
		</div>
		<br/>
		<div id="movie_movieLang">
			<label for="_movieLang">MovieLang:</label>
			<div class="box" id="_movieLang">${result.movieLang}</div>
		</div>
		<br/>
		<div id="movie_releaseDate">
			<label for="_releaseDate">ReleaseDate:</label>
			<div class="box" id="_releaseDate">${result.releaseDate}</div>
		</div>
		<br/>
		<div id="movie_ageCertificate">
			<label for="_ageCertificate">AgeCertificate:</label>
			<div class="box" id="_ageCertificate">${result.ageCertificate}</div>
		</div>
		<br/>
		<div id="movie_domesticTakings">
			<label for="_domesticTakings">DomesticTakings:</label>
			<div class="box" id="_domesticTakings">${result.domesticTakings}</div>
		</div>
		<br/>
		<div id="movie_internationalTakings">
			<label for="_internationalTakings">InternationalTakings:</label>
			<div class="box" id="_internationalTakings">${result.internationalTakings}</div>
		</div>
		<br/>
	</c:if>
	<c:if test="${empty result}">No Movie found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
