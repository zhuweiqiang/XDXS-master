package com.qylm.tool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.qylm.common.utils.StringUtil;

public class ReturnerBeanCreator {

	public static void createManage(String packScan, Class<?> entity, Class<?> dto) throws IOException {
		// 输入名
		String name = entity.getSimpleName();
		// 实体类名
		String entityName = StringUtil.capitalize(name);
		//
		String dtoName = dto.getSimpleName();
		//
		String returnerName = dtoName.substring(0, dtoName.indexOf("Dto"));
		//路径
		String packUrl = "src/"+packScan.replace(".", "/")+"/";
		// ManageBean
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(packUrl + returnerName + "Returner.java")));
		
		pw.println("package " + packScan + ";");
		pw.println();
		pw.println("import com.qylm.bean.back.returner.Returner;");
		pw.println("import " + dto.getName() +";");
		pw.println("import " + entity.getName() +";");
		pw.println();
		pw.println("public class " + returnerName + "Returner extends Returner<"+ returnerName +"Bean,"+dtoName+","+entityName+"> {");
		pw.println();
		pw.println("\tpublic " + returnerName + "Returner(" + dtoName + " "+ StringUtil.uncapitalize(dtoName) + ",Integer firstResult) {");
		pw.println("\t\tsuper("+StringUtil.uncapitalize(dtoName)+",firstResult);");
		pw.println("\t}");
		pw.println();
		pw.println("\t@Override");
		pw.println("\tpublic String returnOnly(" + returnerName +"Bean backBean) {");
		pw.println("\t\tbackBean.set"+dtoName+"(dto);");
		pw.println("\t\tbackBean.setFirstResult(firstResult);");
		pw.println("\t\treturn backBean.currentBack();");
		pw.println("\t}");
		pw.println();
		pw.println("}");
		pw.close();
		
		System.out.println("OK！！！！！！！！！！！！！！！！！！！！");
		
	}
	
/*	@Override
	public String returnEntityList(CommodityRecordCreateBean backBean, List<Commodity> entityList) {
		backBean.setCommodityRecordCreateDto(dto);
		return backBean.choiceModels(entityList);
	}*/
	public static void createCreate(String packScan, Class<?> entity, Class<?> dto) throws IOException {
		// 输入名
		String name = entity.getSimpleName();
		// 实体类名
		String entityName = StringUtil.capitalize(name);
		//
		String dtoName = dto.getSimpleName();
		//
		String returnerName = dtoName.substring(0, dtoName.indexOf("Dto"));
		//路径
		String packUrl = "src/"+packScan.replace(".", "/")+"/";
		// ManageBean
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(packUrl + returnerName + "Returner.java")));
		
		pw.println("package " + packScan + ";");
		pw.println();
		pw.println("import com.qylm.bean.back.returner.Returner;");
		pw.println("import " + dto.getName() +";");
		pw.println("import " + entity.getName() +";");
		pw.println();
		pw.println("public class " + returnerName + "Returner extends Returner<"+ returnerName +"Bean,"+dtoName+","+entityName+"> {");
		pw.println();
		pw.println("\tpublic " + returnerName + "Returner(" + dtoName + " "+ StringUtil.uncapitalize(dtoName) + ") {");
		pw.println("\t\tsuper("+StringUtil.uncapitalize(dtoName)+");");
		pw.println("\t}");
		pw.println();
		pw.println("\t@Override");
		pw.println("\tpublic String returnEntityList(" + returnerName +"Bean backBean,List<"+entityName+"> entityList) {");
		pw.println("\t\tbackBean.set"+dtoName+"(dto);");
		pw.println("\t\treturn backBean.choiceModels(entityList);");
		pw.println("\t}");
		pw.println();
		pw.println("\t@Override");
		pw.println("\tpublic String returnOnly(" + returnerName +"Bean backBean) {");
		pw.println("\t\tbackBean.set"+dtoName+"(dto);");
		pw.println("\t\treturn backBean.currentBack();");
		pw.println("\t}");
		pw.println();
		pw.println("}");
		pw.close();
		
		System.out.println("OK！！！！！！！！！！！！！！！！！！！！");
		
	}
	
	public static void createView(String packScan, Class<?> entity, Class<?> dto) throws IOException {
		// 输入名
		String name = entity.getSimpleName();
		// 实体类名
		String entityName = StringUtil.capitalize(name);
		//
		String dtoName = dto.getSimpleName();
		//
		String returnerName = dtoName.substring(0, dtoName.indexOf("Dto"));
		//路径
		String packUrl = "src/"+packScan.replace(".", "/")+"/";
		// ManageBean
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(packUrl + returnerName + "Returner.java")));
		
		pw.println("package " + packScan + ";");
		pw.println();
		pw.println("import com.qylm.bean.back.returner.Returner;");
		pw.println("import " + dto.getName() +";");
		pw.println("import " + entity.getName() +";");
		pw.println();
		pw.println("public class " + returnerName + "Returner extends Returner<"+ returnerName +"Bean,"+dtoName+","+entityName+"> {");
		pw.println();
		pw.println("\tpublic " + returnerName + "Returner(" + dtoName + " "+ StringUtil.uncapitalize(dtoName) + ") {");
		pw.println("\t\tsuper("+StringUtil.uncapitalize(dtoName)+");");
		pw.println("\t}");
		pw.println();
		pw.println("\t@Override");
		pw.println("\tpublic String returnOnly(" + returnerName +"Bean backBean) {");
		pw.println("\t\tbackBean.set"+dtoName+"(dto);");
		pw.println("\t\treturn backBean.currentBack();");
		pw.println("\t}");
		pw.println();
		pw.println("}");
		pw.close();
		
		System.out.println("OK！！！！！！！！！！！！！！！！！！！！");
		
	}
	
}
