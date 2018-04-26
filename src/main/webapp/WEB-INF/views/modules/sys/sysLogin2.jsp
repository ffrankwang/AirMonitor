<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="shortcut icon" href="images/favicon.png" type="image/png">

  <title>${fns:getConfig('productName')}</title>

  <link href="${ctxStatic }/mycss/style.default.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="signin">





<section>
  
    <div class="signinpanel">
        
        <div class="row">
            
            <div class="col-md-7">
                
                <div class="signin-info">
                    <div class="logopanel">
                        <h1><span></span> ${fns:getConfig('productName')} <span></span></h1>
                    </div><!-- logopanel -->
                
                    <div class="mb20"></div>
                
                    <h4><strong>体验科技变革的魅力！</strong></h4>
                    <ul>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> 实时监测</li>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> 二氧化碳CO2</li>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> 甲醛</li>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> PM10</li>
                        <li><i class="fa fa-arrow-circle-o-right mr5"></i> SO2...</li>
                    </ul>
                    <div class="mb20"></div>
                    <strong>还不是会员? <a href="${pageContext.request.contextPath}/register">注册</a></strong>
                </div><!-- signin0-info -->
            
            </div><!-- col-sm-7 -->
            
            <div class="col-md-5">
                
                <form id="loginForm" class="form-signin" action="${ctx}/login" method="post">
                    <h4 class="nomargin">登录</h4>
                    <p class="mt5 mb20">登录以访问你的账户.</p>
                
                    <input type="text" name="username" class="form-control uname" placeholder="Username" />
                    <input type="password" name="password" class="form-control pword" placeholder="Password" />
                    <a href=""><small>忘记密码?</small></a>
                    <button class="btn btn-success btn-block">登录</button>
                    
                </form>
            </div><!-- col-sm-5 -->
            
        </div><!-- row -->
        
        <div class="signup-footer">
            <div class="pull-left">
               
            </div>
            <div class="pull-right">
                Copyright &copy; 2012-${fns:getConfig('copyrightYear')} <a href="${pageContext.request.contextPath}${fns:getFrontPath()}">${fns:getConfig('productName')}</a> - Powered By <a href="https://github.com/wanghuu/AirMonitor" target="_blank">AirMonitor</a> ${fns:getConfig('version')} 
            </div>
        </div>
        
    </div><!-- signin -->
  
</section>


<script src="${ctxStatic }/myjs/jquery-1.11.1.min.js"></script>
<script src="${ctxStatic }/myjs/jquery-migrate-1.2.1.min.js"></script>
<script src="${ctxStatic }/myjs/bootstrap.min.js"></script>
<script src="${ctxStatic }/myjs/modernizr.min.js"></script>
<script src="${ctxStatic }/myjs/jquery.sparkline.min.js"></script>
<script src="${ctxStatic }/myjs/jquery.cookies.js"></script>

<script src="${ctxStatic }/myjs/toggles.min.js"></script>
<script src="${ctxStatic }/myjs/retina.min.js"></script>

<script src="${ctxStatic }/myjs/custom.js"></script>
<script>
    jQuery(document).ready(function(){
        
        // Please do not use the code below
        // This is for demo purposes only
        var c = jQuery.cookie('change-skin');
        if (c && c == 'greyjoy') {
            jQuery('.btn-success').addClass('btn-orange').removeClass('btn-success');
        } else if(c && c == 'dodgerblue') {
            jQuery('.btn-success').addClass('btn-primary').removeClass('btn-success');
        } else if (c && c == 'katniss') {
            jQuery('.btn-success').addClass('btn-primary').removeClass('btn-success');
        }
    });
</script>

</body>
</html>
