package com.qylm.tool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.qylm.common.utils.ReflectionUtil;

public class DxoCreator {

	public static void create(Class<?> dto, Class<?> entity) throws IOException {
		String name = dto.getSimpleName();
		String dtoName = StringUtils.uncapitalize(name).substring(0, name.length() - 3);
		name = name.substring(0, name.length() - 3) + "Dxo";
		create1(name, "dtoToEntity", "entityToDto", dto, entity, null, null);
		Field[] dtoFields = ReflectionUtil.getAllFields(dto);
		Field dtoField;
		int dtoSize = dtoFields.length;
		for (int j = 0; j < dtoSize; j++) {
			dtoField = dtoFields[j];
			try {
				dto.getMethod("set" + StringUtils.capitalize(dtoField.getName()), dtoField
						.getType());
			} catch (Exception e) {
				continue;
			}
			System.out.println("	"+ dtoName +"Dto.set" + StringUtils.capitalize(dtoField.getName())+"(null);");
		}
	}
	
	public static void createCopy(String dxoName, Class<?> bean1, Class<?> bean2) throws IOException {
		create1(dxoName, "b1ToB2", "b2ToB1", bean1, bean2, null, null);
	}
	
	public static void createCopy(String dxoName, Class<?> bean1, Class<?> bean2,
			String[] includeParas, String[] excludeParas) throws IOException {
		create1(dxoName, "b1ToB2", "b2ToB1", bean1, bean2, includeParas, excludeParas);
	}
	
	private static void create1(String dxoName, String methodName1, String methodName2,
			Class<?> dto, Class<?> entity, String[] includeParas, String[] excludeParas)
			throws IOException {
		Field[] dtoFields = ReflectionUtil.getAllFields(dto);
		Field dtoField;
		int dtoSize = dtoFields.length;
		Field[] entityFields = ReflectionUtil.getAllFields(entity);
		Field entityField;
		int entitySize = entityFields.length;
		if (includeParas != null) {
			int includeLength = includeParas.length;
			String str;
			boolean have;
			for (int i = 0; i < dtoSize; i++) {
				str = dtoFields[i].getName();
				have = false;
				for (int j = 0; j < includeLength; j++) {
					if (str.equals(includeParas[j])) {
						have = true;
						break;
					}
				}
				if (!have) {
					dtoFields[i] = null;
				}
			}
			for (int i = 0; i < entitySize; i++) {
				str = entityFields[i].getName();
				have = false;
				for (int j = 0; j < includeLength; j++) {
					if (str.equals(includeParas[j])) {
						have = true;
						break;
					}
				}
				if (!have) {
					entityFields[i] = null;
				}
			}
			dtoFields = removeNullElement(dtoFields);
			entityFields = removeNullElement(entityFields);
			dtoSize = dtoFields.length;
			entitySize = entityFields.length;
		}
		if (excludeParas != null) {
			int excludeLength = excludeParas.length;
			String str;
			for (int i = 0; i < dtoSize; i++) {
				str = dtoFields[i].getName();
				for (int j = 0; j < excludeLength; j++) {
					if (str.equals(excludeParas[j])) {
						dtoFields[i] = null;
						break;
					}
				}
			}
			for (int i = 0; i < entitySize; i++) {
				str = entityFields[i].getName();
				for (int j = 0; j < excludeLength; j++) {
					if (str.equals(excludeParas[j])) {
						entityFields[i] = null;
						break;
					}
				}
			}
			dtoFields = removeNullElement(dtoFields);
			entityFields = removeNullElement(entityFields);
			dtoSize = dtoFields.length;
			entitySize = entityFields.length;
		}
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"src/com/qylm/dxo/" + dxoName + ".java")));
		pw.println("package com.qylm.dxo;");
		pw.println();
		// 引入类
		pw.println("import " + dto.getName() + ";");
		if (!dto.getName().equals(entity.getName())) {
			pw.println("import " + entity.getName() + ";");
		}
		pw.println();
		// 类名
		pw.println("public final class " + dxoName + " {");
		pw.println();
		// 方法dtoToEntity
		pw.println("	public static void " + methodName1 + "(" + dto.getSimpleName() + " dto, "
				+ entity.getSimpleName() + " entity) {");
		boolean isBoolean;
		for (int j = 0; j < entitySize; j++) {
			entityField = entityFields[j];
			try {
				entity.getMethod("set" + StringUtils.capitalize(entityField.getName()), entityField
						.getType());
			} catch (Exception e) {
				continue;
			}
			for (int i = 0; i < dtoSize; i++) {
				dtoField = dtoFields[i];
				if (!dtoField.getName().equals(entityField.getName()) || !dtoField.getType().equals(entityField.getType())) {
					continue;
				}
				isBoolean = false;
				if ("boolean".equals(dtoField.getType().getName())) {
					try {
						dto.getMethod("is" + StringUtils.capitalize(dtoField.getName()), new Class[]{});
						isBoolean = true;
					} catch (Exception e) {
						continue;
					}
				} else {
					try {
						dto.getMethod("get" + StringUtils.capitalize(dtoField.getName()), new Class[]{});
					} catch (Exception e) {
						continue;
					}
				}
				if (isBoolean) {
					pw.println("		entity.set" + StringUtils.capitalize(entityField.getName())
							+ "(dto.is" + StringUtils.capitalize(dtoField.getName()) + "());");
				} else {
					pw.println("		entity.set" + StringUtils.capitalize(entityField.getName())
							+ "(dto.get" + StringUtils.capitalize(dtoField.getName()) + "());");
				}
			}
		}
		pw.println("	}");
		pw.println();
		// 方法entityToDto
		pw.println("	public static void " + methodName2 +"(" + entity.getSimpleName() + " entity, "
				+ dto.getSimpleName() + " dto) {");
		for (int j = 0; j < dtoSize; j++) {
			dtoField = dtoFields[j];
			try {
				dto.getMethod("set" + StringUtils.capitalize(dtoField.getName()), dtoField
						.getType());
			} catch (Exception e) {
				continue;
			}
			for (int i = 0; i < entitySize; i++) {
				entityField = entityFields[i];
				if (!dtoField.getName().equals(entityField.getName()) || !dtoField.getType().equals(entityField.getType())) {
					continue;
				}
				isBoolean = false;
				if ("boolean".equals(entityField.getType().getName())) {
					try {
						dto.getMethod("is" + StringUtils.capitalize(entityField.getName()), new Class[]{});
						isBoolean = true;
					} catch (Exception e) {
						continue;
					}
				} else {
					try {
						dto.getMethod("get" + StringUtils.capitalize(entityField.getName()), new Class[]{});
					} catch (Exception e) {
						continue;
					}
				}
				if (isBoolean) {
					pw.println("		dto.set" + StringUtils.capitalize(dtoField.getName())
							+ "(entity.is" + StringUtils.capitalize(entityField.getName()) + "());");
				} else {
					pw.println("		dto.set" + StringUtils.capitalize(dtoField.getName())
							+ "(entity.get" + StringUtils.capitalize(entityField.getName()) + "());");
				}
			}
		}
		pw.println("	}");
		pw.println();
		pw.println("}");
		pw.close();
	}
	
	private static Field[] removeNullElement(Field[] array) {
		int length = array.length;
		List<Field> list = new ArrayList<Field>();
		Field field;
		for (int i = 0; i < length; i++) {
			field = array[i];
			if (field != null) {
				list.add(field);
			}
		}
		int size = list.size();
		Field[] newArray = new Field[size];
		for (int i = 0; i < size; i++) {
			newArray[i] = list.get(i);
		}
		return newArray;
	}

}
