<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="resources/css/login-soft.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="resources/css/validationEngine.jquery.css" rel="stylesheet"
	type="text/css" />
<script src="resources/js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
	function formLoginSubmit(){
		$("#formLogin").submit();
	}
	function formRegSubmit(){
		$("#formReg").submit();
	}
</script>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="" style="">
	<div class="logo" style="text-align: center">
		<img src="" alt="">
	</div>
	<div class="main clearfix">
		<form id="formLogin" class="form_login" action="<%=basePath%>login" method="post">
			<table>
				<tr>
					<td>用户名:</td>
					<td><input class="input_text" type="text" placeholder="请输入用户名"
						name="user.userName" /></td>
				</tr>
				<tr>
					<td>密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
					<td><input class="input_text" type="password"
						placeholder="请输入密码" name="user.userPass" /></td>
				</tr>
				<tr>
					<td>验证码:</td>
					<td><input class="input_yzm" type="text" placeholder="请输入验证码"
						name="imgCode"> <span class="yzm_img"> <img
								alt="验证码" id="ImgValiNum" src="<%=basePath%>RandomCodeCtrl"
								title="验证码不区分大小写"
								style="width: 72px; height: 29px; cursor: pointer;"
								title="看不清可单击图片刷新"
								onclick="this.src='<%=basePath%>RandomCodeCtrl?d='+Math.random();" />
						</span></td>
				</tr>
				<tr>
					<td colspan="2">
						<ul>
							<li class="btn" style="padding-left: 50px;">
								<button onclick="javascript:formLoginSubmit()" value=""
									class="btn_login btn_big">立即登录</button>
								<button
									onclick="javascript:$('.form_reg').show(500);$('.form_login').hide(500);"
									type="button" class="btn_reg btn_small" id="btn_reg">注册</button>
							</li>
						</ul>
					</td>
				</tr>
			</table>
		</form>
		<form id="formReg" class="form_reg" action="<%=basePath%>regist" method="post"  style="display: none;">
			<table>
				<tr>
					<td><span style="color: red;">*</span>用户名:</td>
					<td>
					<input  id="reg_ecode" class="input_text" type="text"
						placeholder="请输入用户名" name="userName"/>
				</tr>
				<tr>
					<td><span style="color: red;">*</span>密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
					<td><input id="regepass" class="input_text" type="password"
						placeholder="请输入密码" name="userPass"></td>
				</tr>
				<tr>
					<td><span style="color: red;">*</span>确认密码:</td>
					<td><input id="regepass1" class="input_text" type="password"
						placeholder="请重复密码" name="userPassq"></td>
				</tr>

				<tr>
					<td><span style="color: red;">*</span>电子邮箱:</td>
					<td><input class="input_text" type="text"
						placeholder="请输入邮箱地址" name="email"></td>
				</tr>
				<tr>
					<td><span style="color: red;">*</span>联系电话:</td>
					<td><input class="input_text" type="text"
						placeholder="请输入您的联系电话" name="phone"></td>
				</tr>

				<tr>
					<td colspan="2">
						<ul>
							<li class="btn" style="padding-left: 70px;"><input
								type="hidden" name="status" value="1" />
								<button type="button" class="btn_reg btn_big"
									onclick="javascript:formRegSubmit()">立即注册</button>
								<button type="button" class="btn_login btn_small" id="btn_login"
									onclick="javascript:$('.form_login').show(500);$('.form_reg').hide(500);">
									登录</button></li>
						</ul>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="copyright"></div>

	<!-- END JAVASCRIPTS -->
	<!-- END BODY -->
	<div class="backstretch"
		style="left: 0px; top: 0px; overflow: hidden; margin: 0px; padding: 0px; height: 595px; width: 1366px; z-index: -999999; position: fixed;">
		<img src=""
			style="position: absolute; margin: 0px; padding: 0px; border: none; width: 1366px; height: 816.5932966483241px; max-width: none; z-index: -999999; left: 0px; top: -110.79664832416205px;" />
	</div>

</body>
</html>
