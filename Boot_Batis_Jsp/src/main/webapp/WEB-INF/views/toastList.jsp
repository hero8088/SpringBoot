<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://uicdn.toast.com/tui-grid/latest/tui-grid.css">

<script src="<c:url value="https://code.jquery.com/jquery-3.5.1.slim.js"/>" integrity="sha256-DrT5NfxfbHvMHux31Lkhxg42LY6of8TaYyK50jnxRnM=" crossorigin="anonymous" type="text/javascript"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://uicdn.toast.com/tui-grid/latest/tui-grid.js"></script>
<style>
	#listTable thead th {
		border-right: 1px #788494 solid;
		background: #546478;
		color: #fff;
	}
	
	#listTable td {
		border: 1px #c0cbd4 solid;
	}
</style>
<title>Insert title here</title>
</head>
<body> 
	<h1>Datatable List</h1>
	<hr/>
	<div id="tGrid"></div>
	
	<script type="text/javascript">
       const data = [];
       <c:forEach var="item" items="${result }" varStatus="vSts">
       		data.push({
       			'cddv': '${item.CDDV}',
       			'cd': '${item.CD}',
       			'cdnm': '${item.CDNM}',
       			'attb3': '${item.ATTB3}',
       			'attb1': '${item.ATTB1}',
       			'attb2': '${item.ATTB2}'
       		});
       </c:forEach>
       console.log(data);
       
       const grid = new tui.Grid({
       		el: document.getElementById('tGrid'),
       		columns: [
       			{header: '코드구분', name: 'cddv', align: 'center', width: 100, sortable: true},
       			{header: '코드', name: 'cd', align: 'center', width: 100},
       			{header: '코드명', name: 'cdnm', width: 180},
       			{header: '설명', name: 'attb3', width: 450, ellipsis: true},
       			{header: '관련정보1', name: 'attb1'},
       			{header: '관련정보2', name: 'attb2'}
       		],
       		data: data
       });
	</script>
</body>
</html>