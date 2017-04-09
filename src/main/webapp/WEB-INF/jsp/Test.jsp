<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>  
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>  

<title>脚本编写页面</title>

<script type="text/javascript">
function fun(){
	var targetUrl = "${pageContext.request.contextPath}/getSysRedisOperation.html?reqId="+Math.random();
	var redisKey= $("#redisKey").val();
	var redisValue = $("#redisValue").val();
	var paramData={
		redisKey:redisKey,
		redisValue:redisValue,
	};
	
	$.ajax({
		type: 'POST',
		url: targetUrl,
		data: paramData,
		dataType: "json", //返回数据格式
		scriptCharset: 'utf-8',
		success: function(data){
			if(data){
				if(data['redisValue']){
					alert(data['redisValue']);
					$("#redisValue").val(data['redisValue']);
				}
			}
		},
		error: function(data){
			$.message.pop("error happens");
		}
	});
	
};

function insertFun(){
	
	var targetUrl = "${pageContext.request.contextPath}/insertDataToRedis.html?reqId=" + Math.random();
	var redisKey= $("#redisKey").val();
	var redisValue = $("#redisValue").val();
	var redisTtl = $("#redisTtl").val();
	var paramData={
		redisKey:redisKey,
		redisValue:redisValue,
		ttlMinutes:redisTtl,
	};
	
	
	if(isNull(redisKey) || isNull(redisValue)){
		alert("Redis 的Key或Value为空,请重新输入!");
	}else{
		$.ajax({
			type: 'POST',
			url: targetUrl,
			data: paramData,
			dataType: "json", //返回数据格式
			scriptCharset: 'utf-8',
			success: function(data){
				if(data){
					if(data['resultCode'] = 'COM00000'){
						alert("插入成功! redisKey="+ redisKey + "\t 有效期为" + (isNull(redisTtl)?"永久":(redisTtl+"分钟")) );
					}else{
						alert("插入失败!" + data['resultMsg']);
					}
					
				}
			},
			error: function(data){
				alert("插入发生错误,请稍后重试!");
			}
		});
	}

};

function isNull(str){
	if(str == "") return true;
	var regu = "^[]+$";
	var re = new RegExp(regu);
	return re.test(str);
}

function resetFun() {
	var text = document.getElementById("redisValue");
	var key = document.getElementById("redisKey");
	var result= confirm("确认重置吗?");
	
	if(result){
		$("#redisValue").val("");
		$("#redisKey").val("");	
		$("#redisTtl").val("");
	}
};

function getDataFun(){
	var targetUrl = "${pageContext.request.contextPath}/getResponse.html?reqId="+Math.random();
	var redisKey= $("#redisKey").val();
	var redisValue = $("#redisValue").val();
	var redisTtl = $("#redisTtl").val();
	var paramData={
		redisKey:redisKey,
		redisValue:redisValue,
		ttlMinutes:redisTtl,
	};
	
	$.ajax({
		type: 'POST',
		url: targetUrl,
		data: paramData,
		dataType: "json", //返回数据格式
		scriptCharset: 'utf-8',
		success: function(data){
			if(data){
				if(data['resultCode'] = 'COM00000'){
					var resultData = data['resultData'];
					if(resultData){
						alert("获取成功,数据如下"+ resultData['redisValue']);	
						$("#redisValue").val(resultData['redisValue']);
					}else{
						alert("操作成功,但未有数据返回!");
					}
					
				}else{
					alert("获取失败!" + data['resultMsg']);
				}
				
			}
		},
		error: function(data){
			alert("获取发生错误!");
		}
	});
}

</script>
</head>
<body>
	<div style="margin-top: 50px">
		<form id="searchForm" class="form-horizontal" tabindex="0" style="outline: none;min-width:1400px;">
			<div class="row" style="padding-left:20px;">
				<div class="control-group span4.5" style="padding-left:20px;padding-top=10px;">
					<div class="controls">		
						<textarea id="redisValue" rows="40" cols="120" wrap="hard" placeholder="请输入Redis 数据" ></textarea>	
					</div>
				</div>			
				<div class="control-group span4.5" style="padding-left:20px;">
					<div class="controls">			
						<input id="redisKey" type="text" style="width: 400px;" name="minId"
							class="control-text" placeholder="请输入Redis Key" title="">
					</div>
				</div>
				<div class="control-group span4.5" style="padding-left:20px;">
					<div class="controls">			
						<input id="redisTtl" type="text" style="width: 400px;" name="minId"
							class="control-text" placeholder="请输入失效时间,单位分钟(默认永久)" title=""
							onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
					</div>
				</div>
			</div>
			<div class="row" style="padding-left:20px; padding-top:10px;">
				<div style="width: 120px; float: left; padding-left: 20px; padding-right: 20px;">
					<button id="btnQuery" style="width: 120px;" type="button" onclick = "fun()"
						class="button button-primary">
						<i class="icon-search icon-white"></i>当前Redis数据
					</button>
				</div>
				<div style="width: 120px; float: left; padding-left: 20px; padding-right: 20px;">	
					<button id="btnInsert" style="width:120px;float: left;" type="button" 
						class="button button-primary" onclick="insertFun()">
						<i class="icon-repeat icon-white"></i>插入数据
					</button>
				</div>
				
				<div style="width: 120px; float: left; padding-left: 20px; padding-right: 20px;">	
					<button id="btnReset" style="width:120px;float: left;" type="button" 
			 		onclick="resetFun()">
						<i "></i>重置
					</button>
				</div>
				
				
				<div style="width: 120px; float: left; padding-left: 20px; padding-right: 20px;">	
					<button id="btnGetData" style="width:120px;float: left;" type="button" 
			 		onclick="getDataFun()">
						<i "></i>获取数据测试
					</button>
				</div>
				
				
			</div>
		</form>
	</div>
</body>
</html>