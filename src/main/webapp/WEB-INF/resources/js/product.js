/**
 * http://usejsdoc.org/
 */
function enrollcheck(){
	var Form = document.enrollform;
	if(Form.name.value==""){
		alert("상품 이름을 입력해주세요.");
		return Form.name.focus();
	}else if(Form.price1.value==""){
		alert("원가를 입력해주세요.");
		return Form.price1.focus();
	}else if(isNaN(Form.price1.value)==true){ // price1이 문자라면
		alert("숫자를 입력해주세요.");
		return Form.price1.focus();
	}else if(Form.price2.value==""){
		alert("판매가를 입력해주세요.");
		return Form.price2.focus();
	}else if(isNaN(Form.price2.value)==true){
		alert("숫자를 입력해주세요.");
		return Form.price2.focus();
	}else {
		Form.action = "admin_enroll_product";
		Form.submit();
	}
}