/**
 * http://usejsdoc.org/
 */
function start_delivery(){
	var count = 0;
	
	
	if(document.form.ordernum.length == undefined) { // 체크된 갯수가 하나일 때
		if(document.form.ordernum.checked == true){
			count++;
		}
	} else { // 체크된 갯수가 여러개일 때
		for(var i = 0; i < document.form.ordernum.length; i++){
			if(document.form.ordernum[i].checked == true){
				count++;
			}
		}
	}
	
	if(count == 0){ // 체크박스가 하나도 선택되지 않았을 때
		alert("주문처리할 항목을 선택해 주세요.");
	} else {
		document.form.action = "admin_start_order";
		document.form.submit();
	}
}