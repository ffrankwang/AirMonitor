<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="${ctxStatic }/images/favicon.png"
	type="image/png">

<title>Bracket Responsive Bootstrap3 Admin</title>

<link href="${ctxStatic }/mycss/style.default.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="${ctxStatic }/myjshtml5shiv.js"></script>
  <script src="${ctxStatic }/myjsrespond.min.js"></script>
  <![endif]-->
</head>

<body class="signin">





	<section>

		<div class="signuppanel">

			<div class="row">

				<div class="col-md-6">

					<div class="signup-info">
						<div class="logopanel">
							<h1>
								<span>[</span> bracket <span>]</span>
							</h1>
						</div>
						<!-- logopanel -->

						<div class="mb20"></div>

						<h5>
							<strong>Bootstrap 3 Admin Template!</strong>
						</h5>
						<p>Bracket is a theme that is perfect if you want to create
							your own content management, monitoring or any other system for
							your project.</p>
						<p>Below are some of the benefits you can have when purchasing
							this template.</p>
						<div class="mb20"></div>

						<div class="feat-list">
							<i class="fa fa-wrench"></i>
							<h4 class="text-success">Easy to Customize</h4>
							<p>Bracket is made using Bootstrap 3 so you can easily
								customize any element of this template following the structure
								of Bootstrap 3.</p>
						</div>

						<div class="feat-list">
							<i class="fa fa-compress"></i>
							<h4 class="text-success">Fully Responsive Layout</h4>
							<p>Bracket is design to fit on all browser widths and all
								resolutions on all mobile devices. Try to scale your browser and
								see the results.</p>
						</div>

						<div class="feat-list mb20">
							<i class="fa fa-search-plus"></i>
							<h4 class="text-success">Retina Ready</h4>
							<p>When a user load a page, a script checks each image on the
								page to see if there's a high-res version of that image. If a
								high-res exists, the script will swap that image in place.</p>
						</div>

						<h4 class="mb20">and much more...</h4>

					</div>
					<!-- signup-info -->

				</div>
				<!-- col-sm-6 -->

				<div class="col-md-6">
					<form:form id="inputForm" modelAttribute="user"
						action="${pageContext.request.contextPath}/register/save"
						method="post">

						<h3 class="nomargin">注 册</h3>
						<p class="mt5 mb20">
							已经是会员? <a href="${ctx }"><strong>登录</strong></a>
						</p>

						<div class="mb10">

							<label class="control-label">姓名<font color="red">*</font></label>
							<form:input path="name" htmlEscape="false" maxlength="50"
								class="form-control required" />
						</div>

						<div class="mb10">


							<label class="control-label">用户名<font color="red">*</font></label>
							<input id="oldLoginName" name="oldLoginName" type="hidden"
								value="${user.loginName}">
							<form:input path="loginName" htmlEscape="false" maxlength="50"
								class="form-control required userName" />
						</div>

						<div class="mb10">
							<label class="control-label">密码<font color="red">*</font></label>
							<input id="newPassword" name="newPassword" type="password"
								value="" maxlength="50" minlength="3"
								class="form-control ${empty user.id?'required':''}" />
							<c:if test="${empty user.id}">
							</c:if>
							<c:if test="${not empty user.id}">
								<span class="help-inline">若不修改密码，请留空。</span>
							</c:if>
						</div>

						<div class="mb10">
							<label class="control-label">确认密码<font color="red">*</font></label><input
								id="confirmNewPassword" name="confirmNewPassword"
								type="password" value="" maxlength="50" minlength="3"
								equalTo="#newPassword" class="form-control" />
							<c:if test="${empty user.id}">
							</c:if>
						</div>


						<div class="mb10">
							<label class="control-label">邮件地址</label> <form:input path="email" htmlEscape="false" maxlength="100"
					class="form-control" />
						</div>

						<br />

						<button class="btn btn-success btn-block">注册</button>
					</form:form>
				</div>
				<!-- col-sm-6 -->

			</div>
			<!-- row -->

			<div class="signup-footer">
				<div class="pull-left"></div>
				<div class="pull-right">
					Copyright &copy; 2012-${fns:getConfig('copyrightYear')} <a
						href="${pageContext.request.contextPath}${fns:getFrontPath()}">${fns:getConfig('productName')}</a>
					- Powered By <a href="https://github.com/wanghuu/AirMonitor"
						target="_blank">AirMonitor</a> ${fns:getConfig('version')}
				</div>
			</div>

		</div>
		<!-- signuppanel -->

	</section>


	<script src="${ctxStatic }/myjsjquery-1.11.1.min.js"></script>
	<script src="${ctxStatic }/myjsjquery-migrate-1.2.1.min.js"></script>
	<script src="${ctxStatic }/myjsbootstrap.min.js"></script>
	<script src="${ctxStatic }/myjsmodernizr.min.js"></script>
	<script src="${ctxStatic }/myjsjquery.sparkline.min.js"></script>
	<script src="${ctxStatic }/myjsjquery.cookies.js"></script>

	<script src="${ctxStatic }/myjstoggles.min.js"></script>
	<script src="${ctxStatic }/myjsretina.min.js"></script>

	<script src="${ctxStatic }/myjsselect2.min.js"></script>

	<script src="${ctxStatic }/myjscustom.js"></script>
	<script>
		jQuery(document).ready(
				function() {

					jQuery(".select2").select2({
						width : '100%',
						minimumResultsForSearch : -1
					});

					jQuery(".select2-2").select2({
						width : '100%'
					});

					// Please do not use the code below
					// This is for demo purposes only
					var c = jQuery.cookie('change-skin');
					if (c && c == 'greyjoy') {
						jQuery('.btn-success').addClass('btn-orange')
								.removeClass('btn-success');
					} else if (c && c == 'dodgerblue') {
						jQuery('.btn-success').addClass('btn-primary')
								.removeClass('btn-success');
					} else if (c && c == 'katniss') {
						jQuery('.btn-success').addClass('btn-primary')
								.removeClass('btn-success');
					}

				});
	</script>

</body>
</html>
