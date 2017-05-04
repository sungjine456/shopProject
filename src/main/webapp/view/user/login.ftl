<!DOCTYPE html>
<#import "/spring.ftl" as spring>
<html>
	<head>
		<title>로그인</title>
		<link rel="stylesheet" href="/css/boot/bootstrap.min.css">
		<link rel="stylesheet" href="/css/boot/bootstrap-theme.min.css">
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
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<table class="table table-hover">
					<colgroup>
						<col width="22%"/>
						<col width="38%"/>
						<col width="40%"/>
					</colgroup>
					<tr>
						<th>
							<label for="id">아이디 : </label>
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
							<input id="idSaveCheck" name="idSave" type="checkbox" value="check"> 자동 로그인
						</td>
						<td>
							<a data-target="#layerpop" data-toggle="modal" style="float:right">비밀번호 재발급</a>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<a id="joinBtn">회원가입</a>
						</td>
						<td>
							<button type="submit" id="loginBtn" class="btn btn-primary" style="float:right">로그인</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
		<script type="text/javascript" src="/js/boot/bootstrap.min.js"></script>
	</body>
</html>