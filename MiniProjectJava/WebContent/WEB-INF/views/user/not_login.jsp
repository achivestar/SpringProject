<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />
<script>
	alert("잘못된 접근방식입니다. 로그인 하시기 바랍니다.");
	location.href="${root}user/login";
</script>