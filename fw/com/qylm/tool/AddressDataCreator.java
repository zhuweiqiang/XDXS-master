package com.qylm.tool;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class AddressDataCreator {
	
	public static void create() throws IOException{
		ClassLoader classLoader = AddressDataCreator.class.getClassLoader();
		URL resUrl = classLoader.getResource("com"+ File.separatorChar +"qylm"+ File.separatorChar +"tool" + File.separatorChar + "address.xml");
		InputStream is = new BufferedInputStream(resUrl.openStream());
		parserXml(is);
	}
	
	public static void create(InputStream inputStream) throws IOException{
		parserXml(inputStream);
	}

	public static void parserXml(InputStream inputStream) throws IOException {//D:/Workspaces3.6/lkw/
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/com/qylm/common/address/ProvinceData.java")));
		pw.println("package com.qylm.common.address;");
	    pw.println();
	    pw.println("import java.util.List;");
	    pw.println("import java.util.ArrayList;");
	    pw.println();
	 
	    pw.println("public class ProvinceData {");
	    pw.println();
	 
	    pw.println("\tpublic static final List<Province> getAllProvinceList() {");
	    pw.println("\t\tProvince province;");
	    pw.println("\t\tArrayList<Province> provinceList = new ArrayList<Province>();");
	    
	    PrintWriter pw1 = new PrintWriter(new BufferedWriter(new FileWriter("src/com/qylm/common/address/CityData.java")));
	    pw1.println("package com.qylm.common.address;");
	    pw1.println();
	    pw1.println("import java.util.List;");
	    pw1.println("import java.util.ArrayList;");
	    pw1.println();
	 
	    pw1.println("public class CityData {");
	    pw1.println();
	 
	    pw1.println("\tpublic static final List<City> getAllCityList() {");
	    pw1.println("\t\tProvince province;");
	    pw1.println("\t\tCity city;");
	    pw1.println("\t\tArrayList<City> cityList = new ArrayList<City>();");
	    
	    PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter("src/com/qylm/common/address/DistrictData.java")));
	    pw2.println("package com.qylm.common.address;");
	    pw2.println();
	    pw2.println("import java.util.List;");
	    pw2.println("import java.util.ArrayList;");
	    pw2.println();
	 
	    pw2.println("public class DistrictData {");
	    pw2.println();
	 
	    pw2.println("\tpublic static final List<District> getAllDistrictList1() {");
	    pw2.println("\t\tDistrict district;");
	    pw2.println("\t\tArrayList<District> districtList = new ArrayList<District>();");
	    
		SAXBuilder builder = new SAXBuilder(false);
		try {
			org.jdom.Document document = builder.build(inputStream);
			org.jdom.Element span = document.getRootElement();
			List<org.jdom.Element> selectRoots = span.getChildren("select");
			String provinceId = null;String cityId = null;
			int p = 0;
			for (int i = 0; i < selectRoots.size(); i++) {
				org.jdom.Element selectRoot = selectRoots.get(i);
				List<org.jdom.Element> selectList = selectRoot.getChildren();
				for (int j = 0; j < selectList.size(); j++) {
					org.jdom.Element select = selectList.get(j);
					if(select.getName().equals("option")){
						if(provinceId==null){
							provinceId = select.getAttributeValue("value");
						}else if(!provinceId.equals(select.getAttributeValue("value"))){
							provinceId = select.getAttributeValue("value");
						}
						//System.out.println(select.getName()+ ":"+select.getAttributeValue("value")+":"+ select.getValue()+":"+provinceId+"-------\n");
						pw.println();
					    pw.println("\t\tprovince = new Province();");
					    pw.println("\t\tprovince.setProvinceId(" + provinceId + ");");
					    pw.println("\t\tprovince.setName(\"" + select.getValue() + "\");");
					    pw.println("\t\tprovinceList.add(province);");
					    
					}else if(select.getName().equals("select")){
						List<org.jdom.Element> selectList1 = select.getChildren();
						for (int k = 0; k < selectList1.size(); k++) {
							org.jdom.Element select1 = selectList1.get(k);
							if(select1.getName().equals("option")){
								if(cityId==null){
									cityId = select1.getAttributeValue("value");
								}else if(!cityId.equals(select1.getAttributeValue("value"))){
									cityId = select1.getAttributeValue("value");
								}
								//System.out.println(select1.getName()+ ":"+select1.getAttributeValue("value")+":"+ select1.getValue()+":"+cityId+"+++++\n");
								pw1.println();
							    pw1.println("\t\tcity = new City();");
						        pw1.println("\t\tprovince = new Province();");
						        pw1.println("\t\tprovince.setProvinceId(" + provinceId + ");");
						        pw1.println("\t\tcity.setProvince(province);");
						        pw1.println("\t\tcity.setCityId(" + cityId + ");");
						        pw1.println("\t\tcity.setName(\"" + select1.getValue() + "\");");
						        pw1.println("\t\tcityList.add(city);");
							}else if(select1.getName().equals("select")){
								List<org.jdom.Element> selectList2 = select1.getChildren();
								for (int f = 0; f < selectList2.size(); f++) {
									org.jdom.Element select2 = selectList2.get(f);
									if(select2.getName().equals("option")){
										//System.out.println(select2.getName()+ ":"+select2.getAttributeValue("value")+":"+ select2.getValue()+":"+cityId);
										pw2.println();
										pw2.println("\t\tdistrict = new District(" + select2.getAttributeValue("value") + ", \"" + select2.getValue() + "\"," + " \"" + "" + "\", " + "new City(" + cityId + "));");
										pw2.println("\t\tdistrictList.add(district);");
										if (p == 1001) {
											pw2.println();
											pw2.println("\t\tdistrictList.trimToSize();");
											pw2.println("\t\treturn districtList;");
											pw2.println("\t}");
									        pw2.println();
									 
									        pw2.println("\tpublic static final List<District> getAllDistrictList2() {");
									        pw2.println("\t\tDistrict district;");
									        pw2.println("\t\tArrayList<District> districtList = new ArrayList<District>();");
									      }
									      if (p == 2001) {
									         pw2.println();
									         pw2.println("\t\tdistrictList.trimToSize();");
									         pw2.println("\t\treturn districtList;");
									         pw2.println("\t}");
									         pw2.println();
									 
									         pw2.println("\tpublic static final List<District> getAllDistrictList3() {");
									         pw2.println("\t\tDistrict district;");
									         pw2.println("\t\tArrayList<District> districtList = new ArrayList<District>();");
									       }
									      p++;
									}
								}
							}
						}
						
					}
					
				}
			}
			 pw.println();
		     pw.println("\t\tprovinceList.trimToSize();");
		     pw.println("\t\treturn provinceList;");
		     pw.println("\t}");
		     pw.println();
		     pw.println("}");
		     pw.close();
		     
		     pw1.println();
		     pw1.println("\t\tcityList.trimToSize();");
		     pw1.println("\t\treturn cityList;");
		     pw1.println("\t}");
		     pw1.println();
		     pw1.println("}");
		     pw1.close();
		     
		     pw2.println();
		     pw2.println("\t\tdistrictList.trimToSize();");
		     pw2.println("\t\treturn districtList;");
		     pw2.println("\t}");
		     pw2.println();
		     pw2.println("}");
		     pw2.close();
		     System.out.println("OK！！！！！！！！！！！！！！！！！！！！");
		} catch (JDOMException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
