<!DOCTYPE html>
<html>
	<head>
		<script>
			<#assign message = message!""> 
			<#if message != "">
				alert("${message}");
			</#if>
		</script>
		<title> 회원가입 </title>
		<link rel="stylesheet" href="/css/boot/bootstrap.min.css">
		<link rel="stylesheet" href="/css/boot/bootstrap-theme.min.css">
		<style>
			.right {
				text-align: right;
			}
		</style>
	</head>
	<body>
		<div class="container" style="margin-left:25%; margin-top:5%">
			<h1> 회원 가입 </h1>
			<form id="form" action="/join" method="post">
				<input type="hidden" id="passwordBool" value="false"/>
				<input type="hidden" id="emailBool" value="false"/>
				<div class="container">
					<div class="row">
						<div class="col-md-6">
							<div class="row">
								<div class="col-md-4">
									<label for="email">이메일 : </label>
								</div>
								<div class="col-md-8">
									<input type="text" id="email" class="form-control" name="email"/>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 right">
									<span id="emailSpan"></span>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<label for="password">비밀번호 : </label>
								</div>
								<div class="col-md-8">
									<input type="password" id="password" class="form-control" name="password"/>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 right">
									<font>6자 이상 15자 이하로 입력하셔야 합니다.</font>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<label for="passwordConfirm">비밀번호 확인 : </label>
								</div>
								<div class="col-md-8">
									<input type="password" id="passwordConfirm" class="form-control" name="passwordConfirm"/>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 right">
									<span id="passwordSpan"></span>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<label for="name">이름 : </label>
								</div>
								<div class="col-md-8">
									<input type="text" id="name" class="form-control" name="name"/>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="col-md-5"></div>
							<button type="button" id="joinBtn" class="btn btn-primary">회원가입</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript" src="/js/common/jquery-1.12.3.min.js"></script>
		<script type="text/javascript" src="/js/boot/bootstrap.min.js"></script>
		<script type="text/javascript" src="/js/common/common.js"></script>
		<script type="text/javascript" src="/js/user/join.js"></script>
	</body>
</html>