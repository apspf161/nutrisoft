<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageReq" value="${pageContext.request}" scope="page" />
<c:set var="urlBase" value="${fn:replace(pageReq.requestURL, pageReq.requestURI, pageReq.contextPath)}/" scope="request" />

<html>
<head>
<c:import url="/WEB-INF/views/imports.jsp" />
</head>
<body>
	<c:import url="/WEB-INF/views/header.jsp"></c:import>

	<div class="container">
		<c:import url="/WEB-INF/views/menu.jsp"></c:import>
		
		<div id="welcome"></div> 
	</div>
	<c:import url="/WEB-INF/views/footer.jsp"></c:import>
</body>
</html>
