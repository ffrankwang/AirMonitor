<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/WEB-INF/views/include/head.jsp"%>
<title>用户注册</title>
</head>
<body>
	<h1 class="form-signin-heading">用户注册</h1>
	<br />
	<form:form id="inputForm" modelAttribute="user"
		action="${pageContext.request.contextPath}/register/save"
		method="post" class="form-horizontal">
		<input id="id" name="id" type="hidden" value=""/>	
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="50"
					class="required" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">登录名:</label>
			<div class="controls">
				<input id="oldLoginName" name="oldLoginName" type="hidden"
					value="${user.loginName}">
				<form:input path="loginName" htmlEscape="false" maxlength="50"
					class="required userName" />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">密码:</label>
			<div class="controls">
				<input id="newPassword" name="newPassword" type="password" value=""
					maxlength="50" minlength="3" class="${empty user.id?'required':''}" />
				<c:if test="${empty user.id}">
					<span class="help-inline"><font color="red">*</font> </span>
				</c:if>
				<c:if test="${not empty user.id}">
					<span class="help-inline">若不修改密码，请留空。</span>
				</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">确认密码:</label>
			<div class="controls">
				<input id="confirmNewPassword" name="confirmNewPassword"
					type="password" value="" maxlength="50" minlength="3"
					equalTo="#newPassword" />
				<c:if test="${empty user.id}">
					<span class="help-inline"><font color="red">*</font> </span>
				</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<form:input path="email" htmlEscape="false" maxlength="100"
					class="email" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<form:input path="phone" htmlEscape="false" maxlength="100" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机:</label>
			<div class="controls">
				<form:input path="mobile" htmlEscape="false" maxlength="100" />
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit"
				value="保 存" /> <input id="btnCancel" class="btn" type="button"
				value="返 回" onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>