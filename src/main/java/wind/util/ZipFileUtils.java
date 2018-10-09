package wind.util;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-09-18 15:32
 **/
public class ZipFileUtils {

    public static void main(String[] args) throws Exception {
        // zipSingleFile("F:\\zip\\test1.txt", "F:\\zip\\test1.zip");
        // zipMultipleFiles(Arrays.asList("F:\\zip\\test1.txt", "F:\\zip\\test2.txt"), "F:\\zip\\multiCompressed.zip");
        unzipFile("F:\\zip\\multiCompressed.zip", "F:\\zip\\");
    }

    public static InputStream toInputStream(String dir) throws IOException {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ZipOutputStream zipOut = new ZipOutputStream(byteArrayOutputStream);) {
            File fileToZip = new File(dir);

            zipFile(fileToZip, fileToZip.getName(), zipOut);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw e;
        }
    }

    public static void zipDirectory(String dir, String targetFileName) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(targetFileName));) {
            File fileToZip = new File(dir);

            zipFile(fileToZip, fileToZip.getName(), zipOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            File[] children = fileToZip.listFiles();
            Arrays.stream(children).forEach(childFile -> {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            });
            return;
        }
        try (FileInputStream fis = new FileInputStream(fileToZip);) {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOut.putNextEntry(zipEntry);
            IOUtils.copy(fis, zipOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void zipMultipleFiles(List<String> srcFileNames, String targetFileName) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(targetFileName));) {
            for (String srcFile : srcFileNames) {
                File fileToZip = new File(srcFile);
                try (FileInputStream fis = new FileInputStream(fileToZip);) {
                    ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                    zipOut.putNextEntry(zipEntry);
                    IOUtils.copy(fis, zipOut);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipSingleFile(String sourceFileName, String targetFileName) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(targetFileName));
             FileInputStream fis = new FileInputStream(sourceFileName);) {

            ZipEntry zipEntry = new ZipEntry(new File(sourceFileName).getName());
            zipOut.putNextEntry(zipEntry);
            IOUtils.copy(fis, zipOut);
            zipOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unzipFile(String zipFile, String targetFile) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (null != zipEntry) {
                String fileName = zipEntry.getName();
                File file = new File(targetFile + "/" + fileName);
                if (file.exists()) {
                    file = new File(targetFile + "/" + fileName + "副本");
                }
                try (FileOutputStream fis = new FileOutputStream(file);) {
                    IOUtils.copy(zis, fis);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                zipEntry = zis.getNextEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}