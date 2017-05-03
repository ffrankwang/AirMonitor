<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>PM2.5管理</title>
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
		<li class="active"><a href="${ctx}/air/tbPm25/">PM2.5列表</a></li>
		<%-- <shiro:hasPermission name="air:tbPm25:edit"><li><a href="${ctx}/air/tbPm25/form">PM2.5添加</a></li></shiro:hasPermission> --%>
	</ul>
<%-- 	<form:form id="searchForm" modelAttribute="tbPm25" action="${ctx}/air/tbPm25/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form> --%>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>pm2.5</th>
				<th>更新时间</th>
				<shiro:hasPermission name="air:tbPm25:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbPm25">
			<tr>
				<td><a href="${ctx}/air/tbPm25/form?id=${tbPm25.id}">
					${tbPm25.pm25}
				</a></td>
				<td>
					<fmt:formatDate value="${tbPm25.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="air:tbPm25:edit"><td>
    				<a href="${ctx}/air/tbPm25/form?id=${tbPm25.id}">修改</a>
					<a href="${ctx}/air/tbPm25/delete?id=${tbPm25.id}" onclick="return confirmx('确认要删除该PM2.5吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>