<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>空气质量管理</title>
<meta name="decorator" content="default" />

<script type="text/javascript">
	$(document).ready(function() {
		$("#monitor").click(function (e) {
			currentAQ();
        });
	});
	var currentAQ=setInterval("requestAQ()", 2500);
	function requestAQ() {
		$.ajax({
			url : "${ctx}/air/tbAirQuality/currentAQ",
			type : "get",
			dataType : "json",
			success : function(data) {
				if (data.isOk) {
					$("#a1").html(data.temp+"℃");
					$("#a2").html(data.hum+"%");
					$("#a3").html(data.CO2+"%");
					$("#a4").html(data.SO2+"mg/m3");
					$("#a5").html(data.PM10+"mg/m3");
					$("#a6").html(data.HCHO+"mg/m3");
					$("#a7").html(data.CO+"mg/m3");
				} else {
					$("#airQuality").html("遇到了点问题。。。");
				}

			},
			error : function() {
				// alert("失败，请稍后再试！");
			}
		});
	}
</script>
</head>
<body>
	<h2 align="center">当前空气质量</h2>
	<button class="btn btn-primary" id="monitor">开始监测</button>
	<div id="airQuality" class="table-responsive">
		<table class="table table-striped table-bordered">
			<tr>
			<thead>
				<tr>
					<th>监测指标</th>
					<th>数值</th>
				</tr>
			</thead>

			<tbody>

				<tr>
					<th>温度</th>
					<td id="a1">Loading...</td>
				</tr>
				<tr>
					<th>湿度</th>
					<td id="a2">Loading...</td>
				</tr>
				<tr>
					<th>二氧化碳</th>
					<td id="a3">Loading...</td>
				</tr>
				<tr>
					<th>二氧化碳</th>
					<td id="a4">Loading...</td>
				</tr>
				<tr>
					<th>可吸入颗粒物(PM10)</th>
					<td id="a5">Loading...</td>
				</tr>
				<tr>
					<th>甲醛</th>
					<td id="a6">Loading...</td>
				</tr>
				<tr>
					<th>一氧化碳</th>
					<td id="a7">Loading...</td>
				</tr>
			</tbody>
			</tr>
		</table>
	</div>
</body>
</html>