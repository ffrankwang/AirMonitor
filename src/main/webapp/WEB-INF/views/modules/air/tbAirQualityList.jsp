<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>空气质量管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			setInterval("requestAQ()",2500);
		});
		function requestAQ(){
			$.ajax({
				url : "${ctx}/air/tbAirQuality/currentAQ",
				type : "get",
				dataType : "json",
				success : function(data) {
					if(data.isOk){
						var str = "<p>温度："+data.temp.toString()+"</p><p>湿度："+data.hum+"</p><p>co2浓度:"+data.co2+"</p><p>pm2.5:"+data.pm25;
						$("#airQuality").html(str);
					}else{
						$("#airQuality").html("遇到了点问题。。。");
					}
					
				},
				error: function() {
			        // alert("失败，请稍后再试！");
			      }
			 });
		}
		
	</script>
</head>
<body>
	<h2 align="center">当前空气质量</h2>
	<div id="airQuality" align="center" >
	</div>
</body>
</html>