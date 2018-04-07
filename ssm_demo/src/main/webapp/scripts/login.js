function login(){
	var name=$('#count').val().trim();
	var password=$('#password').val().trim();
	var flag=true;
	$('#count_span').html('');
	$('#password_span').html('');
	if(name==""){
		$('#count_span').html("用户名为空");
		flag=false;
	}
	if(password==""){
		$('#password_span').html("密码为空");
		flag=false;
	}
	if(flag){
		$.ajax({
			url:path+"/user/login.do",
			type:"post",
			dataType:"json",
			data:{
				"name":name,
				"password":password
			},
			success:function(result){
				if(result.state==0){
					var data=result.data;
					addCookie("user.id",data.id,2);
					location.href="edit.html";
				}else if(result.state==2){
					$('#count_span').html("用户名已存在");
				}else if(result.state==3){
					$('#password_span').html("密码错误");
				}
			},
			error:function(){
				console.log("发送失败");
			}
			
		})		
	}
}