//<![CDATA[
function viewDialog(source, event, params, ext, clientId) {
	//alert(params[0].value);为实体类ID 
	jQuery(PrimeFaces.escapeClientId(clientId+":viewCompHid")).val(params[0].value);
	//alert(jQuery(PrimeFaces.escapeClientId("form:viewDialog:viewCompHid")).val());
	var viewDialog = PF('viewCompDialog');
	jQuery('<iframe id="viewiframe" name="viewiframe" src="/DZWL/loading.html" width="100%" height="99.5%"  noresize="noresize" scrolling="yes" frameborder="0" ></iframe>')
			.appendTo(viewDialog.content);
	// alert(jQuery(PrimeFaces.escapeClientId("form:viewDialog:viewCompBtn")).attr("style"));
	jQuery(PrimeFaces.escapeClientId(clientId+":viewCompBtn")).click();
	viewDialog.show();
	viewDialog.closeIcon.click(function(e) {
		viewDialog.content.children().remove();
		viewDialog.hide();
		e.preventDefault();
	});
}
// ]]>

