<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<div>
<p>
<p><font size="5" color="saddlebrown">MovieApp-modelOne</font></p>
</p>
<ul>
<li><a href="<c:url value="/rest/actor" />">Actors</a></li>
<li><a href="<c:url value="/rest/director" />">Directors</a></li>
<li><a href="<c:url value="/rest/movie" />">Movies</a></li>
</ul>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>
