<%--
  Created by IntelliJ IDEA.
  User: gianlorenzo
  Date: 15/01/19
  Time: 9.25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ICR-TASK POLICY</title>
    <!--[if lte IE 8]><script src="/js/ie/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
    <!--[if lte IE 8]><link rel="stylesheet" href="/css/ie8.css" /><![endif]-->
    <!--[if lte IE 9]><link rel="stylesheet" href="/css/ie9.css" /><![endif]-->

    <!-- Favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico"/>
</head>
<body class="landing">
<div class="relative">
    <jsp:include page="menu.jsp"/>
    <h2>Riepilogo del Politica Creata</h2>
</div>
<table>
    <tr>
        <th>Soglia Risposte Positive</th>
        <th>Soglia Risposte Negative</th>
        <th>Soglia di Incertezza</th>
    </tr>
    <tr>
        <th>${policy.yesAnswer}</th>
        <th>${policy.noAnswer}</th>
        <th>${policy.uncertainty}</th>
    </tr>
</table>

<!-- Scripts -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.scrollex.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.scrolly.min.js"></script>
<script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/js/util.js"></script>
<!--[if lte IE 8]>-->
<script src="${pageContext.request.contextPath}/js/ie/respond.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>
</html>
