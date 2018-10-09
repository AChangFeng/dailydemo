package wind.util;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-09-18 17:12
 **/
public class NioZipFileUtils {

    public static void main(String[] args) throws Exception {
        create("F:\\zip\\1.zip", "F:\\zip\\test1.txt", "F:\\zip\\test2.txt");
    }

    public static void create(String zipFilename, String... filenames) throws IOException {
        try (FileSystem fileSystem = createZipFileSystem(zipFilename, true);) {
            Path root = fileSystem.getPath("/");
            for (String filename : filenames) {
                Path src = Paths.get(filename);
                if (!Files.isDirectory(src)) {
                    Path dest = fileSystem.getPath(root.toString(), src.toString());
                    Path parent = dest.getParent();
                    if (Files.notExists(parent)) {
                        Files.createDirectories(parent);
                    }
                    Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
                } else {
                    Files.walkFileTree(src, new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                            Path dirToCreate = Paths.get(root.toString(), dir.toString());
                            if (Files.notExists(dirToCreate)) {
                                Files.createDirectories(dirToCreate);
                            }
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            Path destFile = Paths.get(root.toString(), file.toString());
                            Files.copy(file, destFile, StandardCopyOption.REPLACE_EXISTING);
                            return FileVisitResult.CONTINUE;
                        }
                    });
                }
            }
        } catch (IOException e) {
            throw e;
        }

    }

    public static void unzip(String zipFile, String dstFile) throws IOException {
        Path destDir = Paths.get(dstFile);
        if (Files.notExists(destDir)) {
            Files.createDirectories(destDir);
        }

        try (FileSystem fileSystem = createZipFileSystem(zipFile, false);) {
            Path root = fileSystem.getPath("/");
            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    Path dirToCreate = Paths.get(destDir.toString(), dir.toString());
                    if (Files.notExists(dirToCreate)) {
                        Files.createDirectories(dirToCreate);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Path destFile = Paths.get(destDir.toString(), file.toString());
                    Files.copy(file, destFile, StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw e;
        }
    }

    public static FileSystem createZipFileSystem(String zipFileName, boolean createIfAbsent) throws IOException {
        Path path = Paths.get(zipFileName);
        if (!Files.isDirectory(path)) {
            path = path.getFileName();
        }
        URI uri = URI.create("jar:file:" + path.toUri().getPath());
        Map<String, String> env = new HashMap<>(1);
        if (createIfAbsent) {
            env.put("create", "true");
        }
        return FileSystems.newFileSystem(uri, env);
    }

}