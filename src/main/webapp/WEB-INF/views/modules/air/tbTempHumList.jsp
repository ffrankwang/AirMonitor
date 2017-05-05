<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>温湿度管理</title>
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
		<li class="active"><a href="${ctx}/air/tbTempHum/">温湿度列表</a></li>
		<shiro:hasPermission name="air:tbTempHum:edit"><li><a href="${ctx}/air/tbTempHum/form">温湿度添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbTempHum" action="${ctx}/air/tbTempHum/" method="post" class="breadcrumb form-search">
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
				<th>温度</th>
				<th>湿度</th>
				<th>更新时间</th>
				<shiro:hasPermission name="air:tbTempHum:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbTempHum">
			<tr>
				<td><a href="${ctx}/air/tbTempHum/form?id=${tbTempHum.id}">
					${tbTempHum.temp}
				</a></td>
				<td>
					${tbTempHum.hum}
				</td>
				<td>
					<fmt:formatDate value="${tbTempHum.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="air:tbTempHum:edit"><td>
    				<a href="${ctx}/air/tbTempHum/form?id=${tbTempHum.id}">修改</a>
					<a href="${ctx}/air/tbTempHum/delete?id=${tbTempHum.id}" onclick="return confirmx('确认要删除该温湿度吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>