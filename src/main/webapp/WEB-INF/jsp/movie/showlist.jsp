<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>

<div>
<font size="3" color='saddlebrown'>Movies</font>
<br />
<br />
<font size="2" color='saddlebrown'>To create new Movie - use curl command, e.g.: </font>
<br />
curl -i -H "Content-Type: application/json" -X POST -d "{\"movieName\":\"Sarlatan\", \"movieLength\": 118, \"movieLang\":\"cesky\", \"releaseDate\":\"2020-08-20\", \"ageCertificate\":\"15\", \"domesticTakings\": 1520, \"internationalTakings\": 0, \"director\": {\"id\": 4}, \"actors\": [{\"id\": 8}, {\"id\": 9}]}" http://localhost:8888/rest/movie
<br />
<br />
<font size="2" color='saddlebrown'>To select Movies from database - use curl command, e.g.: </font>
<br />
curl -i -H "Content-Type: application/json" -X POST -d "{}" http://localhost:8888/rest/movie/find
<br />
<font>For other select commands - see file curl-commands.</font>
<br />
<br />
</div>

<div>
	<c:if test="${not empty result}">
	<table>
		<thead>
		<th>Id</th>
		<th>MovieName</th>
		<th>MovieLength</th>
		<th>MovieLang</th>
		<th>ReleaseDate</th>
		<th>AgeCertificate</th>
		<th>DomesticTakings</th>
		<th>InternationalTakings</th>
		<th/>
		<th/>
		</thead>
		<c:forEach items="${result}" var="each" >
			<tr>
				<td>
					<a href="<c:url value="/rest/movie/${each.id}" />">${each.id}</a>
				</td>
				<td>
					${each.movieName}
				</td>
				<td>
					${each.movieLength}
				</td>
				<td>
					${each.movieLang}
				</td>
				<td>
					${each.releaseDate}
				</td>
				<td>
					${each.ageCertificate}
				</td>
				<td>
					${each.domesticTakings}
				</td>
				<td>
					${each.internationalTakings}
				</td>
				<td>
					<a href="<c:url value="/rest/movie/${each.id}" />">Show</a>
				</td>
				<td>
					<c:url value="/rest/movie/${each.id}" var="action"/>
					<form:form action="${action}" method="DELETE">
						<input id="delete" type="submit" value="Delete"/>
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${empty result}"><p>There are no Movies yet.</p></c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

