<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>PM10管理</title>
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
		<li class="active"><a href="${ctx}/air/tbPM10/">PM10列表</a></li>
		<%-- <shiro:hasPermission name="air:tbPM10:edit"><li><a href="${ctx}/air/tbPM10/form">PM10添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="tbPM10" action="${ctx}/air/tbPM10/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>PM10：</label>
				<form:input path="PM10" htmlEscape="false" class="input-mini"/> 以上
			</li>
			<li><label>更新时间：</label>
				<input name="beginUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tbPM10.beginUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${tbPM10.endUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>PM10</th>
				<th>更新时间</th>
				<%-- <shiro:hasPermission name="air:tbPM10:edit"><th>操作</th></shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="tbPM10">
			<tr>
				<td><a href="${ctx}/air/tbPM10/form?id=${tbPM10.id}">
					${tbPM10.PM10}
				</a></td>
				<td>
					<fmt:formatDate value="${tbPM10.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<%-- <shiro:hasPermission name="air:tbPM10:edit"><td>
    				<a href="${ctx}/air/tbPM10/form?id=${tbPM10.id}">修改</a>
					<a href="${ctx}/air/tbPM10/delete?id=${tbPM10.id}" onclick="return confirmx('确认要删除该PM10吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>