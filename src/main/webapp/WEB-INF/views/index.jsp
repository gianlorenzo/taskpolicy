<%--
  Created by IntelliJ IDEA.
  User: gianlorenzo
  Date: 14/01/19
  Time: 10.49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ICR-TASK POLICY</title>

    <meta charset="utf-8"/>
    <!--[if lte IE 8]><script src="/js/ie/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css"/>
    <!--[if lte IE 8]><link rel="stylesheet" href="/css/ie8.css" /><![endif]-->
    <!--[if lte IE 9]><link rel="stylesheet" href="/css/ie9.css" /><![endif]-->

    <!-- Favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico"/>
</head>
<body class="landing">
<jsp:include page="menu.jsp"/>
<!-- Banner -->
<section id="banner">
    <div class="inner">
        <h2>Task Policy</h2>
        <p>Microservizio addetto alla gestione</p>
        <p>della politica di assegnazione dei Task</p>
    </div>
</section>

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
