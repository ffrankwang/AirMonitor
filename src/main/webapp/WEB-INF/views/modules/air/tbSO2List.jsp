<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>二氧化硫管理</title>
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
		<li class="active"><a href="${ctx}/air/tbSO2/">二氧化硫列表</a></li>
		<shiro:hasPermission name="air:tbSO2:edit"><li><a href="${ctx}/air/tbSO2/form">二氧化硫添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="tbSO2" action="${ctx}/air/tbSO2/" method="post" class="breadcrumb form-search">
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
				<th>SO2</th>
				<th>更新时间</th>
				<shiro:hasPermission name="air:tbSO2:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbSO2">
			<tr>
				<td><a href="${ctx}/air/tbSO2/form?id=${tbSO2.id}">
					${tbSO2.SO2}
				</a></td>
				<td>
					<fmt:formatDate value="${tbSO2.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="air:tbSO2:edit"><td>
    				<a href="${ctx}/air/tbSO2/form?id=${tbSO2.id}">修改</a>
					<a href="${ctx}/air/tbSO2/delete?id=${tbSO2.id}" onclick="return confirmx('确认要删除该二氧化硫吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>