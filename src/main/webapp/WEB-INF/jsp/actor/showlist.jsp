<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>

<div>
<font size="3" color='saddlebrown'>Actors</font>
<br />
<br />
<font size="2" color='saddlebrown'>To create new Actor - use curl command, e.g.: </font>
<br />
curl -i -H "Content-Type: application/json" -X POST -d "{\"firstName\":\"Ivan\", \"lastName\":\"Trojan\", \"gender\": \"M\", \"dateOfBirth\":\"1964-07-22\"}" http://localhost:8888/rest/actor
<br />
<br />
<font size="2" color='saddlebrown'>To select Actors from database - use curl command, e.g.: </font>
<br />
curl -i -H "Content-Type: application/json" -X POST -d "{}" http://localhost:8888/rest/actor/find
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
		<th>FirstName</th>
		<th>LastName</th>
		<th>DateOfBirth</th>
		<th/>
		<th/>
		</thead>
		<c:forEach items="${result}" var="each" >
			<tr>
				<td>
					<a href="<c:url value="/rest/actor/${each.id}" />">${each.id}</a>
				</td>
				<td>
					${each.firstName}
				</td>
				<td>
					${each.lastName}
				</td>
				<td>
					${each.dateOfBirth}
				</td>
				<td>
					<a href="<c:url value="/rest/actor/${each.id}" />">Show</a>
				</td>
				<td>
					<c:url value="/rest/actor/${each.id}" var="action"/>
					<form:form action="${action}" method="DELETE">
						<input id="delete" type="submit" value="Delete"/>
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${empty result}"><p>There are no Actors yet.</p></c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

