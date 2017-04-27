<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>空气质量管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/air/tbAirQuality/">当前空气质量</a></li>
	</ul>
	<form:form id="searchForm" modelAttribute="tbAirQuality" action="${ctx}/air/tbAirQuality/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>temp_hum</th>
				<th>pm25</th>
				<th>co2</th>
				<shiro:hasPermission name="air:tbAirQuality:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbAirQuality">
			<tr>
				<td><a href="${ctx}/air/tbAirQuality/form?id=${tbAirQuality.id}">
					${tbAirQuality.tempHum.temp},${tbAirQuality.tempHum.hum}
				</a></td>
				<td>
					${tbAirQuality.pm25.pm25}
				</td>
				<td>
					${tbAirQuality.co2.co2}
				</td>
				<shiro:hasPermission name="air:tbAirQuality:edit"><td>
    				<a href="${ctx}/air/tbAirQuality/form?id=${tbAirQuality.id}">修改</a>
					<a href="${ctx}/air/tbAirQuality/delete?id=${tbAirQuality.id}" onclick="return confirmx('确认要删除该空气质量吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>