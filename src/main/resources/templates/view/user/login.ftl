<!DOCTYPE html>
<#import "/spring.ftl" as spring>
<html>
	<head>
		<script>
			<#assign message = message!""> 
			<#if message != "">
				alert("${message}");
			</#if>
		</script>
		<title>로그인</title>
		<link rel="stylesheet" href="/css/boot/bootstrap.min.css">
		<link rel="stylesheet" href="/css/boot/bootstrap-theme.min.css">
		<link rel="stylesheet" href="/css/common/common.css">
		<style type="text/css">
			.container {
				width : 30%;
				height : 50%;
				padding-top : 5%;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<h1> 로그인 </h1>
			<#if error.isPresent()>
				The id or password is wrong, try again
			</#if>
			<form id="form" class="form-signin" action="/login" method="post">
				<table class="table table-hover">
					<colgroup>
						<col width="22%"/>
						<col width="38%"/>
						<col width="40%"/>
					</colgroup>
					<tr>
						<th>
							<label for="email">이메일 : </label>
						</th>
						<td colspan="2">
							<input type="text" id="email" class="form-control" name="email" autofocus/>
						</td>
					</tr>
					<tr>
						<th>
							<label for="password">비밀번호 : </label>
						</th>
						<td colspan="2">
							<input type="password" id="password" class="form-control" name="password" maxlength="15"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input name="auto_login" type="checkbox" value="true"> 자동 로그인
						</td>
						<td>
							<a data-target="#layerpop" data-toggle="modal" style="float:right">비밀번호 재발급</button>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<a href="/join">회원가입</a>
						</td>
						<td>
							<button type="button" id="loginBtn" class="btn btn-primary" style="float:right">로그인</button>
						</td>
					</tr>
				</table>
			</form>
			<div class="modal fade" id="layerpop">
				<div class="modal-dialog modal-sm">
					<div class="modal-content">
						 <div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">×</button>
							<h4 class="modal-title">비밀번호 재발급</h4>
						</div>
	 					<div class="modal-body">
	 						<form id="translateForm" class="form-signin" action="/translatePassword" method="post">
	 							<table>
	 								<tr>
										<th>
											<label for="translateEmail">이메일 : </label> 
										</th>
										<td>
											<input id="translateEmail" class="form-control" name="email" "type="text"/>
										</td>
									</tr>
									<tr>
										<td colspan="2"> 
											<button type="button" id="translatePasswordBtn" class="btn btn-default" style="float:right">재발급</button>
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
		<script type="text/javascript" src="/js/boot/bootstrap.min.js"></script>
		<script type="text/javascript" src="/js/common/common.js"></script>
		<script type="text/javascript" src="/js/user/login.js"></script>
	</body>
</html>