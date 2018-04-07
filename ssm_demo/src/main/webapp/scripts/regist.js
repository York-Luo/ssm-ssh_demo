function regist(){
	var username=$('#regist_username').val().trim();
	var nickname=$('#nickname').val().trim();
	var regist_password=$('#regist_password').val().trim();
	var final_password=$('#final_password').val().trim();
	var flag=true;
	$('#regist_username_span').html('');
	$('#regist_password_span').html('');
	$('#final_password_span').html('');
	if(username==""){
		$('#regist_username_span').html('账户名不能为空');
		$('#warning_1').show();
		flag=false;
	}
	if(regist_password==""){
		$('#regist_password_span').html('密码不能为空');
		$('#warning_2').show();
		flag=false;
	}
	if(regist_password.length<6&&regist_password.length>0){
		$('#regist_password_span').html('密码长度小于6位');
		$('#warning_2').show();
		flag=false;
	}
	if(regist_password!=final_password){
		$('#final_password_span').html("密码不一致");
		$('#warning_3').show();
		flag=false;
	}
	if(nickname=""){
		nickname==username;
	}
	if(flag){
		console.log(final_password);
		$.ajax({
			url:path+"/user/regist.do",
			type:"post",
			dataType:"json",
			data:{"username":username,
				"nick":nickname,
				"password":final_password
			},
			success:function(result){
				if(result.state==0){
					var name=result.data.name;
					console.log(name);
					$('#count').val(name);
					$('#back').click();
				}
			},
			error:function(){
				console.log("加载笔记失败");
			}
		});
	}
}