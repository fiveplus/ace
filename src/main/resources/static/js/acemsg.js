var close_button = '<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>';
var success_class = "alert alert-success alert-dismissable";
var info_class = "alert alert-info alert-dismissable";
var warning_class = "alert alert-warning alert-dismissable";
var danger_class = "alert alert-danger alert-dismissable";
function remove_ace_msg(id){
	$("#"+id).fadeOut("slow");
	setTimeout("$('#'"+id+").remove()", 5000);
}
var AceMsg = function(){
};

AceMsg.prototype.success = function(msg){
	msg = msg == undefined ? "成功！很好地完成了提交。" : msg;
	$("#ace_msg").remove();
	var html = "<div id='ace_msg' class='"+success_class+"'>";
	html += close_button;
	html += msg;
	html += "</div>";
	$("#breadcrumbs").before(html);
	window.location.hash = "#ace_msg";
	window.location.hash = "";
	setTimeout("remove_ace_msg('ace_msg')", 5000);
}
AceMsg.prototype.info = function(msg){
	msg = msg == undefined ? "信息！请注意这个信息。" : msg;
	$("#ace_msg").remove();
	var html = "<div id='ace_msg' class='"+info_class+"'>";
	html += close_button;
	html += msg;
	html += "</div>";
	$("#breadcrumbs").after(html);
	window.location.hash = "#ace_msg";
	window.location.hash = "";
	setTimeout("remove_ace_msg('ace_msg')", 5000);
}
AceMsg.prototype.warning = function(msg){
	msg = msg == undefined ? "警告！请不要提交。" : msg;
	$("#ace_msg").remove();
	var html = "<div id='ace_msg' class='"+warning_class+"'>";
	html += close_button;
	html += msg;
	html += "</div>";
	$("#breadcrumbs").after(html);
	window.location.hash = "#ace_msg";
	window.location.hash = "";
	setTimeout("remove_ace_msg('ace_msg')", 5000);
}
AceMsg.prototype.danger = function(msg){
	msg = msg == undefined ? "错误！请进行一些更改。" : msg;
	$("#ace_msg").remove();
	var html = "<div id='ace_msg' class='"+danger_class+"'>";
	html += close_button;
	html += msg;
	html += "</div>";
	$("#breadcrumbs").after(html);
	window.location.hash = "#ace_msg";
	window.location.hash = "";
	//setTimeout('remove_ace_msg("ace_msg")', 5000);
}

var ace_msg = new AceMsg();
