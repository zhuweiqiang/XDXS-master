package com.qylm.tool;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.qylm.common.utils.StringUtil;

public class GenericCodeBeanCreator {
	public static void create() throws Throwable {
		int rowNum = 1;

		InputStream is = new BufferedInputStream(new FileInputStream(
				"泛用CD一览表.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		is.close();
		HSSFSheet sheet = workbook.getSheetAt(0);
		HSSFRow row = sheet.getRow(rowNum);

		Map<String,List<Data>> map = new TreeMap<String,List<Data>>();

		while (row != null) {
			Data readedData = new Data(row);
			if ((!(readedData.disable))
					&& (!(StringUtil.isBlank(readedData.kind)))) {
				List<Data> dataList;
				if (map.containsKey(readedData.kind)) {
					dataList = (List<Data>) map.get(readedData.kind);
				} else {
					dataList = new ArrayList<Data>();
					map.put(readedData.kind, dataList);
				}
				dataList.add(readedData);
			}
			++rowNum;
			row = sheet.getRow(rowNum);
		}
		
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
				"src/com/qylm/bean/GenericCodeBean.java")));
		pw.println("package com.qylm.bean;");
		pw.println();
		
		pw.println("import javax.faces.bean.ApplicationScoped;");
		pw.println("import javax.faces.bean.ManagedBean;");
		pw.println("import javax.faces.model.SelectItem;");
		pw.println();
		pw.println("@ApplicationScoped");
		pw.println("@ManagedBean(eager=true)");
		pw.println("public class GenericCodeBean {");
		pw.println();

		for (Iterator<Entry<String, List<Data>>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<String, List<Data>> entry = it.next();
			pw.println();
			pw.println("\tprivate SelectItem[] "
					+ ((String) entry.getKey()).toLowerCase() + ";");
		}
		pw.println();

		pw.println("\tpublic GenericCodeBean() {");

		for (Iterator<Entry<String, List<Data>>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<String, List<Data>> entry = it.next();
			pw.println();
			String fieldName = ((String) entry.getKey()).toLowerCase();
			List<Data> dataList = (List<Data>) entry.getValue();
			pw.println("\t\t" + fieldName + " = new SelectItem["
					+ dataList.size() + "];");
			int i = 0;
			Collections.sort(dataList, new Comparator<Data>() {
				public int compare(GenericCodeBeanCreator.Data d1,
						GenericCodeBeanCreator.Data d2) {
					return (d1.order - d2.order);
				}
			});
			for (Data data : dataList) {
				pw.println("\t\t" + fieldName + "[" + i
						+ "] = new SelectItem(\"" + data.value + "\", \""
						+ data.label + "\");");
				++i;
			}
		}
		pw.println("\t}");

		for (Iterator<Entry<String, List<Data>>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<String, List<Data>> entry = it.next();
			pw.println();
			pw.println("\tpublic SelectItem[] get"
					+ ((String) entry.getKey()).toUpperCase() + "() {return "
					+ ((String) entry.getKey()).toLowerCase() + ";}");
		}
		pw.println();
		pw.println("}");
		pw.close();
	}

	private static class Data {
		private static final short disableN = 0;
		private static final short kindN = 5;
		private static final short valueN = 10;
		private static final short labelN = 15;
		private static final short orderN = 26;
		public boolean disable;
		public String kind;
		public String value;
		public String label;
		public int order;

		public Data(HSSFRow row) {
			this.disable = "y".equalsIgnoreCase(row.getCell(0)
					.getRichStringCellValue().toString());
			this.kind = row.getCell(5).getRichStringCellValue().toString();
			HSSFCell cell = row.getCell(10);
			if (cell.getCellType() == 0)
				this.value = Integer.toString((int) cell.getNumericCellValue());
			else {
				this.value = cell.getRichStringCellValue().toString();
			}
			if (row.getCell(15) != null) {
				if (row.getCell(15).getRichStringCellValue() != null) {
					this.label = row.getCell(15).getRichStringCellValue().toString();
				}
			}
			if (row.getCell(26) != null) {
				this.order = (int) row.getCell(26).getNumericCellValue();
			}
		}
	}
}
