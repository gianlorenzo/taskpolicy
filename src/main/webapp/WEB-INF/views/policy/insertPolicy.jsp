<%--
  Created by IntelliJ IDEA.
  User: gianlorenzo
  Date: 15/01/19
  Time: 10.09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm" %>
<html>
<head>
    <title>ICR-TASK POLICY</title>
    <meta charset="utf-8"/>
    <!--[if lte IE 8]><script src="/js/ie/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/policy.css"/>
    <!--[if lte IE 8]><link rel="stylesheet" href="/css/ie8.css" /><![endif]-->
    <!--[if lte IE 9]><link rel="stylesheet" href="/css/ie9.css" /><![endif]-->

    <!-- Favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico"/>
</head>
<body class="landing">
<h1>Definizione di una politica</h1>
    <div class="form">
        <div id="signup">
            <h1>Inserisci Dati della Politica</h1>
            <form:form method="post" action="setPolicy"
                    modelAttribute="policy" name="form">
                <div class="field-wrap">
                    <label> Soglia Risposte Positive </label>
                    <form:input type="text" value="${policy.yesAnswer}" path="yesAnswer"
                                placeholder="Soglia Risposte positive" onBlur="isnum(this)"/>
                </div>
                <div class="field-wrap">
                    <label> Soglia Risposte Negative </label>
                    <form:input type="text" value="${policy.noAnswer}" path="noAnswer"
                                placeholder="Soglia Risposte Negative" onBlur="isnum(this)"/>
                </div>
                <div class="field-wrap">
                    <label> Soglia di Incertezza </label>
                    <form:input type="text" value="${policy.uncertainty}" path="uncertainty"
                                placeholder="Soglia di Incertezza" onBlur="isnum(this)"/>
                </div>
                <div id="formsubmitbutton">
                    <button type="submit" class="button button-block" name="action"
                            value="WORD" onclick="ButtonClicked()">Conferma
                    </button>
                </div>
            </form:form>
        </div>
    </div>
    <!-- tab-content -->
</div>
<!-- /form -->

<script src="js/selectAll.js"></script>


<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script
        src="${pageContext.request.contextPath}/js/jquery.scrollex.min.js"></script>
<script src="js/selectAll.js"></script>
<script
        src="${pageContext.request.contextPath}/js/jquery.scrolly.min.js"></script>
<script src="${pageContext.request.contextPath}/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/js/util.js"></script>
<!--[if lte IE 8]>-->
<script src="${pageContext.request.contextPath}/js/ie/respond.min.js"></script>
<script src="${pageContext.request.contextPath}/js/main.js"></script>
<script src="${pageContext.request.contextPath}/js/file.js"></script>
<script src="${pageContext.request.contextPath}/js/load.js"></script>
</body>
</html>
