package unit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CodeLineCounter {

	private static int totalLine;  
//    private static String fileToBeCounted[] = { "java", "jsp", "css",  
//            "html", "htm","xml"};//所需计算的源码文件类型  
//    private static int fileToBeCountedN = 6;//所需计算的源码文件类型个数  
    
    private static String fileToBeCounted[] = { "java", "xhtml"};//所需计算的源码文件类型  
private static int fileToBeCountedN = 2;//所需计算的源码文件类型个数  
  
    private static boolean isFileToBeCounted(String type) {  
        for (int i = 0; i < fileToBeCountedN; i++) {  
            if (type.equals(fileToBeCounted[i]))  
                return true;  
        }  
        return false;  
    }  
  
    private static String getType(String filename) { 
        //System.out.println(filename);  
        byte b[] = filename.getBytes();  
        byte[] type = new byte[10];  
        String rts = null;  
        int i = 0, p = 0, n = filename.length();  
        for (i = 0; i < n; i++) {  
            if (b[i] == '.') {  
                p = i;  
                break;  
            }  
        }  
        //System.out.print(p);  
        i = p + 1;  
        p = 0;  
        for (; i < n&&p<10; i++) {  
            type[p++] = b[i];  
            //System.out.print(b[i]);  
        }  
        rts = new String(type);  
        //System.out.println(rts.substring(0, p));  
        return rts.substring(0, p);  
    }  
  
    private static void countLine(String path) {  
        File file = new File(path);  
        File lists[] = file.listFiles();  
        for (int i = 0; i < lists.length; i++) {  
            if (lists[i].isFile()) {  
                String filename = lists[i].getName();  
                boolean isFileToBeCounted = isFileToBeCounted(getType(filename));  
                if (isFileToBeCounted) {  
                    try {  
                        int lines=0;  
                        FileReader read = new FileReader(path + filename);  
                        BufferedReader br = new BufferedReader(read);  
                        String row;  
                        while ((row = br.readLine()) != null) {  
                            lines++;  
                        }  
                        System.out.println("文件：" + path + filename+"共:"+lines+"行代码;");  
                        totalLine+=lines;  
                    } catch (Exception e) {  
                        e.printStackTrace();  
                    }  
                }  
            } else {  
                String paths = path;  
                paths = paths + lists[i].getName() + "\\";  
                System.out.println("进入目录：" + paths+";");  
                countLine(paths);  
            }  
        }  
    }  
  
    public static void main(String[] args) {  
        totalLine = 0;  
        String path = new String(  
                "E:\\xinwork\\XDXS\\src\\");//项目的绝对地址  
        //E:\\j2ee\\amigo\\amigo\\  
        countLine(path);  
        System.out.println("整个项目共:"+totalLine+"行代码;");  
    }

}
