<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="EUC-KR">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link href="<c:url value="http://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css"/>" rel="stylesheet"/>

<script src="<c:url value="https://code.jquery.com/jquery-3.5.1.slim.js"/>" integrity="sha256-DrT5NfxfbHvMHux31Lkhxg42LY6of8TaYyK50jnxRnM=" crossorigin="anonymous" type="text/javascript"></script>
<script src="<c:url value="http://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"/>" type="text/javascript"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

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
	<div>
		<table id="listTable" class="" >
			<colgroup>
			</colgroup>
			<thead>
				<th class="text-center">Cddv</th>
				<th class="text-center">Code</th>
				<th class="text-center">Code Name</th>
				<th class="text-center">Description</th>
				<th class="text-center">ETC INFO1</th>
				<th class="text-center">ETC INFO2</th>
			</thead>
			<tbody>
				<c:forEach var="item" items="${result }" varStatus="vSts">
					<tr>
						<td class="text-center">${item.CDDV }</td>
						<td class="text-center">${item.CD }</td>
						<td class="text-left">${item.CDNM }</td>
						<td class="text-left">${item.ATTB3 }</td>
						<td class="text-left">${item.ATTB1 }</td>
						<td class="text-left">${item.ATTB2 }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
	
	<script type="text/javascript">
	console.log($('#listTable > tbody > tr > td:first-child').text());
		$('#listTable').DataTable({
			paging: false,
			searching: false,
			info: false,
			ordering: false
		});
	</script>
</body>
</html>