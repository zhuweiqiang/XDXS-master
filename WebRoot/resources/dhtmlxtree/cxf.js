
function onloads(){
	
	alert(11); 
	var myTree = new dhtmlXTreeObject("treeboxbox_trees","100%","100%",0);
	myTree.setImagePath("../resources/dhtmlxtree/imgs/dhxtree_skyblue/");
	myTree.enableCheckBoxes(1);alert(123);
	//myTree.enableThreeStateCheckboxes(true);
	//myTree.enableSmartXMLParsing(true);
	alert(123);
	myTree.load("../tree_cl.xml");
	alert(111);
}
