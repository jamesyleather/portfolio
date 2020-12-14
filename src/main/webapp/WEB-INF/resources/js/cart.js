/**
 * http://usejsdoc.org/
 */
function cartAction(){
	document.form.action="cart_action";
	document.form.submit();
}

function order_action(){
	var count = 0;
	
	// 체크박스가 하나만 체크되어있는 경우, 배열로 인식하지 못한다.
	if(document.form.cartnum.length == undefined){
		if(document.form.cartnum.checked == true){
			count++;
		}
	}
	
	for(var i=0; document.form.cartnum.length; i++){
		if(document.form.cartnum[i].checked == true){
			count++;
		}
	}
	
	if(count == 0){
		alert("주문할 항목을 선택해주세요.");
	} else {
		document.form.action = "order_product";
		document.form.submit();
	}
}

function kepp_shopping(){
	document.form.action = "category";
	document.form.submit();
}