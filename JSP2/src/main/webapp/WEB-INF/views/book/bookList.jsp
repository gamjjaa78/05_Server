<%-- c : 자주 사용하는 Java 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- fn : 컬렉션/문자열 관련 기능 --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록 조회</title>
	<%-- CSS/JS 파일은 브라우저에서 직접 요청하는 정적파일
	이런 정적 컨텐츠느는 브라우저에서 직접 접근 가능해야 하므로
	webapp 안에 있어야함
	*WEB-INF 폴더 안에 넣으면 인식안됨
	
	webapp 기준으로 작성
	 --%>
	<link rel="stylesheet" href="/resources/cssbook.css">


	

</head>
<body>
	
	<h1>책 목록 조회</h1>
	<hr>
	<h3>전체 책 수량 : ${fn:length(bookList)}권</h3>
	<hr>
	bookList:${bookList}
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>저자</th>
				<th>가격(원)</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${bookList}" varStatus="vs">
				<tr>
					<th>${vs.count}</th>
					<td>${book.title}</td>
					<td>${book.writer}</td>
					<td>${book.price}</td>
				</tr>
				
				<%-- 3배수 번재 반복시 --%>
				<c:if test="${vs.count%3==0}">
					<tr>
						<td colspan="4">&nbsp;</td>
					</tr>
				</c:if>
				
			</c:forEach>
		</tbody>
	</table>

	<%-- webapp 폴더 기준 --%>
	<script type="/resources/js/book.js"></script>
</body>
</html>