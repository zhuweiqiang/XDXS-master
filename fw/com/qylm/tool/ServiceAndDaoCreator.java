package com.qylm.tool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.qylm.common.utils.StringUtil;

public class ServiceAndDaoCreator {

	public static void create(Class<?> entity) throws IOException {
		// 输入
		String name = entity.getSimpleName();
		//路径
		String uslName = "com.qylm.";
		// 实体类名
		String entityName = StringUtil.capitalize(name);
		// 实体类别
		String entityAliasName = StringUtil.uncapitalize(name);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"src/com/qylm/dao/" + entityName + "Dao.java")));
		// Dao
		pw.println("package " + uslName + "dao;");
		pw.println();
		pw.println("import " + uslName + "entity." + entityName + ";");
		pw.println();
		pw.println("public interface " + entityName + "Dao extends GenericDao<"
				+ entityName + ", Integer> {");
		pw.println();
		pw.println("}");
		pw.close();
		
		// DaoImpl
		pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"src/com/qylm/dao/" + entityName + "DaoImpl.java")));
		pw.println("package " + uslName + "dao;");
		pw.println();
		pw.println("import " + uslName + "entity." + entityName + ";");
		pw.println();
		pw.println("public class " + entityName + "DaoImpl extends GenericDaoImpl<"
				+ entityName + ", Integer> implements " + entityName + "Dao {");
		pw.println();
		pw.println("}");
		pw.close();
		
		// service
		pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"src/com/qylm/service/" + entityName + "Service.java")));
		pw.println("package " + uslName + "service;");
		pw.println();
		pw.println("import " + uslName + "entity." + entityName + ";");
		pw.println();
		pw.println("public interface " + entityName + "Service extends GenericService<"
				+ entityName + ", Integer> {");
		pw.println();
		pw.println("}");
		pw.close();
		
		// SeviceImpl
		pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"src/com/qylm/service/" + entityName + "ServiceImpl.java")));
		pw.println("package " + uslName + "service;");
		pw.println();
		pw.println("import org.springframework.beans.factory.annotation.Autowired;");
		pw.println("import org.springframework.stereotype.Service;");
		pw.println("import " + uslName + "dao." + entityName + "Dao;");
		pw.println("import " + uslName + "entity." + entityName + ";");
		pw.println();
		pw.println("@Service(\"" + StringUtil.uncapitalize(entityName) + "Service\")");
		pw.println("public class " + entityName + "ServiceImpl extends GenericServiceImpl<"
				+ entityName + ", Integer> implements " + entityName + "Service {");
		pw.println();
		pw.println("	@Autowired");
		pw.println("	protected " + entityName + "ServiceImpl(" + entityName + "Dao "
				+ entityAliasName + "Dao) {");
		pw.println("		super(" + entityAliasName + "Dao);");
		pw.println("	}");
		pw.println();
		pw.println("}");
		pw.close();
		
		System.out.println("OK！！！！！！！！！！！！！！！！！！！！");
		
	}
}
