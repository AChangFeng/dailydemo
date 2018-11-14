package wind.util;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-10-15 14:43
 **/
public class StringUtils {

    public static void main(String[] args) {
        String folderName = "xxx///";
        String fileName = "///asdsad";
        while (folderName.endsWith("/")) {
            folderName = folderName.substring(0, folderName.length() - 1);
        }
        while (fileName.startsWith("/")) {
            fileName = fileName.substring(1, fileName.length());
        }
        System.out.println(folderName + "/" + fileName);
    }

}