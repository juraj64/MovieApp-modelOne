<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>

<div>
<font size="3" color='saddlebrown'>Directors</font>
<br />
<br />
<a href="<c:url value="/rest/director/form" />">New Director</a>
<font>(does not work properly)</font>
<br />
<font size="2" color='saddlebrown'>To create new Director - use curl command, e.g.: </font>
<br />
<font>curl -i -H "Content-Type: application/json" -X POST -d "{\"firstName\":\"Agnieszka\", \"lastName\":\"Holland\",\"dateOfBirth\":\"1948-11-28\", \"nationality\":\"Poland\"}" http://localhost:8888/rest/director
<br />
<br />
<a href="<c:url value="/rest/director/form/find" />">Find Directors</a>
<font>(does not work properly)</font>
<br />
<font size="2" color='saddlebrown'>To select Directors from database - use curl command, e.g.: </font>
<br />
curl -i -H "Content-Type: application/json" -X POST -d "{}" http://localhost:8888/rest/director/find
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
		<th>Nationality</th>
		<th/>
		<th/>
		</thead>
		<c:forEach items="${result}" var="each" >
			<tr>
				<td>
					<a href="<c:url value="/rest/director/${each.id}" />">${each.id}</a>
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
					${each.nationality}
				</td>
				<td>
					<a href="<c:url value="/rest/director/${each.id}" />">Show</a>
				</td>
				<td>
					<c:url value="/rest/director/${each.id}" var="action"/>
					<form:form action="${action}" method="DELETE">
						<input id="delete" type="submit" value="Delete"/>
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${empty result}"><p>There are no Directors yet.</p></c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

