// 提交
function resetIsSubmitted() {
	isSubmitted = false;
}
function formSubmit() {
	alert(isSubmitted);
	if (!isSubmitted) {
		isSubmitted = true;
		setTimeout("resetIsSubmitted()", 3000);
		return true;
	} else {
		return false;
	}
}

//信息弹出框提示
function confirmationMess(mess){
	return confirm(mess);
}
function queryConfirm(){
	return confirm("确认要生效吗？生效后不可修改！");
}
function rechargeConfirm(){
	return confirm("确定要充值吗？");
}
function receivablesConfirm(){
	return confirm("确定要消费吗？");
}
function deleteConfirm(){
	return confirm("确定要删除吗？");
}
function queryFinishConfirm(){
	return confirm("是否确认收款完结，确认后将不可修改？");
}
// 绑定回车键
function enterPress(event,id){
	if(event.keyCode == 13){
		document.getElementById(id).click();
		return false;
	}
	return true;
}
// 列表鼠标移动变色
function rowColorChange(element){
	element.style.backgroundColor='#D4EBF7';
}
function rowColorBack(element){
	element.style.backgroundColor='#f5fbfe';
}
PrimeFaces.locales['tr'] = {
	closeText : '关闭',
	prevText : '上一月',
	nextText : '下一月',
	currentText : '今天',
	monthNames : [ '一月', '二月', '三月', '四月', '五月',
			'六月', '七月', '八月', '九月', '十月',
			'十一月', '十二月' ],
	monthNamesShort : [ '一月', '二月', '三月', '四月', '五月', '六月',
			'七月', '八月', '九月', '十月', '十一月', '十二月' ],
	dayNames : [ '天', '一', '二', '三', '四', '五', '六' ],
	dayNamesShort : [ '星期天', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ],
	dayNamesMin : [ '天', '一', '二', '三', '四', '五', '六' ],
	weekHeader : '',
	firstDay : 1,
	isRTL : false,
	showMonthAfterYear : false,
	yearSuffix : '',
	month : '月',
	week : '周',
	day : '日',
	allDayText : '小时'
};