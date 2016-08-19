package com.qylm.tool;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.qylm.common.utils.ReflectionUtil;
import com.qylm.common.utils.StringUtil;

public class SelectConditionCreator {

	public static void create(Class<?> entity) {
		
		Field[] fields = ReflectionUtil.getAllFields(entity);
		int size = fields.length;

		for (int j = 0; j < size; ++j) {
			Field field = fields[j];
			if (!(Modifier.isStatic(field.getModifiers()))) {
				String name = field.getName();
				char[] chars = name.toCharArray();
				int length = chars.length;
				StringBuilder sb = new StringBuilder(64);
				for (int i = 0; i < length; ++i) {
					if (Character.isUpperCase(chars[i])) {
						sb.append("_");
					}
					sb.append(Character.toUpperCase(chars[i]));
				}
				System.out.println("\t/**");
				System.out.println("\t * 检索条件:" + name);
				System.out.println("\t */");
				System.out.println("\tpublic static final String " + sb
						+ " = \"" + name + "\";");
				System.out.println();
			}
		}
	}

	public static void create4Dto(Class<?> dto) {
		Field[] fields = ReflectionUtil.getAllFields(dto);
		String dtoName = StringUtil.uncapitalize(dto.getSimpleName());
		int size = fields.length;

		for (int j = 0; j < size; ++j) {
			Field field = fields[j];
			if (!(Modifier.isStatic(field.getModifiers()))) {
				String name = field.getName();
				if ("boolean".equals(field.getType().getName()))
					System.out.println(field.getType().getSimpleName() + " "
							+ name + " = " + dtoName + ".is"
							+ StringUtil.capitalize(name) + "();");
				else
					System.out.println(field.getType().getSimpleName() + " "
							+ name + " = " + dtoName + ".get"
							+ StringUtil.capitalize(name) + "();");
			}
		}
	}

}
