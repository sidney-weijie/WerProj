<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>My论坛登录</title>
	</head>
<body>
	<c:if test="${!empty error}">
		<font color="red"><c:out value="${error}" /></font>
	</c:if>
	<form action="<c:url value="loginCheck.html"/>" method="post">
		用户名： <input type="text" name="userName"> <br> 密 码： <input
			type="password" name="password"> <br> <input
			type="submit" value="登录" /> <input type="reset" value="重置" />
	</form>

	<script>
			document.write("<h1>This is a heading</h1>");
			document.write("<p>This is a paragraph.</p>");
		</script>

	<p id="demo">段落</p>

	<button type="button" onClick="alert('Welcome')">点击这里</button>

	<script>
			function myFun(){
				x=document.getElementById("demo");
				//改变内容
				x.innerHTML="Hello JavaScript"
				//改变内容颜色
				x.style.color="#FF0000";
			}
		</script>
	<script type="text/javascript">
			function verify(){
				var x = document.getElementById("demo");
				if(x == "" ||isNaN(x)){
					alert("Not Number");
				}
			}
		</script>
	<script>
			function variable() {
				var carname="Volvo";
				document.getElementById("demo2").innerHTML=carname;
			}
		</script>
	<button type="button" onClick="myFun()">FunctionTest</button>
	<p></p>
	<button type="button" onclick="verify()">IsDemoNumber</button>

	<p id="demo2"></p>
	<button type="button" onclick="variable()">TestChanger</button>

	<p id="demo3">
		______________________________________________________________________________</p>
	<script type="text/javascript">
		
		/* 数组的用法　*/
			var i;
			var cars = new Array();
			cars[0] = "Audi";
			cars[1] = "BMW";
			cars[2] = "HONDA";
			for(i = 0; i < cars.length;i++){
				document.write(cars[i] + "<br />");
			}
		</script>

	<script>
			var person={
				firstname:"Bill",
				lastname:"Gates",
				id      : 5566
			};
			document.write(person.lastname + "<br />");
			document.write(person["lastname"] + "<br />");
		</script>

	<script>
			person1 = new Object();
			person1.firstname="bill";
			person1lastname="Gates";
			person1.age=56;
			person1.eyecolor="blue";
			document.write(person1.firstname + " is " + person1.age + " years old.");
		</script>



	<script>
function myThrowFun() {
			try {
				var x = document.getElementById("demo3").value;
				if (x == "")
					throw "值为空";
				if (isNaN(x))
					throw "不是数字";
				if (x > 10)
					throw "太大";
				if (x < 5)
					throw "太小";
			} catch (err) {
				var y = document.getElementById("mess");
				y.innerHTML = "错误：" + err + "。";
			}
		}
	</script>

	<h1>我的第一个 JavaScript 程序</h1>
	<p>请输入 5 到 10 之间的数字：</p>
	<input id="demo3" type="text">
	<button type="button" onclick="myThrowFun()">测试输入值</button>
	<p id="mess"></p>

	<script type="text/javascript">
		function validate_email(field, alerttxt) {
			with (field) {
				apos = value.indexOf("@")
				dotpos = value.lastIndexOf(".")
				if (apos < 1 || dotpos - apos < 2) {
					alert(alerttxt);
					return false
				} else {
					return true
				}
			}
		}

		function validate_form(thisform) {
			with (thisform) {
				if (validate_email(email, "Not a valid e-mail address!") == false) {
					email.focus();
					return false
				}
			}
		}
	</script>

	<form action="submitpage.htm" onsubmit="return validate_form(this);"method="post">
		Email: <input type="text" name="email" size="30"> 
		<input type="submit" value="Submit">
	</form>
</body>


</html>
