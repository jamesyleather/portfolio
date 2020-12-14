/**
 * http://usejsdoc.org/
 */

// 주소 찾기
function openZipSearch() {
	new daum.Postcode({
		oncomplete: function(data) {
			$('[name=zip_code]').val(data.zonecode); // 우편번호 (5자리)
			$('[name=addr1]').val(data.address);
			$('[name=addr2]').val(data.buildingName);
		}
	}).open();
}

function go_save(){
	
	if(document.joinform.id.value==""){
		alert("아이디를 입력해주세요.");
		console.log(document.joinform.id.value);
		document.joinform.id.focus();
	} else if(document.joinform.pwd.value==""){
		alert("비밀번호를 입력해주세요.");
		document.joinform.pwd.focus();
	} else if(document.joinform.pwd.value != document.joinform.pwdcheck.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.joinform.pwdcheck.focus();
	} else if(document.joinform.name.value==""){
		alert("이름을 입력해주세요.");
		document.joinform.name.focus();
	} else if(document.joinform.email.value==""){
		alert("이메일을 입력해주세요.");
		document.joinform.email.focus();
	} else if(document.joinform.zip_code.value==""){
		alert("주소를 입력해주세요.");
		document.joinform.zip_code.focus();
	} else if(document.joinform.phone.value==""){
		alert("전화번호를 입력해주세요.");
		document.joinform.phone.focus();
	} else{
		document.joinform.action="join";
		document.joinform.submit();
	}
}

function sns_go_save(){
	
	if(document.joinform.id.value==""){
		alert("아이디를 입력해주세요.");
		console.log(document.joinform.id.value);
		document.joinform.id.focus();
	} else if(document.joinform.zip_code.value==""){
		alert("주소를 입력해주세요.");
		document.joinform.zip_code.focus();
	} else if(document.joinform.phone.value==""){
		alert("전화번호를 입력해주세요.");
		document.joinform.phone.focus();
	} else{
		document.joinform.action="sns_join";
		document.joinform.submit();
	}
}

function idcheck(){
	if(document.joinform.id.value==""){
		alert("아이디를 입력해주세요.");
		document.joinform.id.focus();
		return false;
	}
	
	var url="id_check_form?id=" + document.joinform.id.value;
	
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=300");
}

function findid(){
	var url="find_id_form";
	
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, height=500");
}

function go_update(){
	if(document.joinform.pwd.value==""){
		alert("비밀번호를 입력해주세요.");
		document.joinform.pwd.focus();
		return false;
	} else if(document.joinform.pwd.value != document.joinform.pwdcheck.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.joinform.pwd.focus();
		return false;
	} else {
		document.joinform.action="update_user_info"
		document.joinform.submit();
	}
}