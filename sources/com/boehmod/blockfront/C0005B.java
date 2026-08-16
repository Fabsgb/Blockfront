package com.boehmod.blockfront;

import com.boehmod.bflib.common.PatternReferences;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.B */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/B.class */
public class C0005B implements InterfaceC0009F<C0994s> {

    /* JADX INFO: renamed from: u */
    private static final String f132u = "assets/minecraft/shaders";

    /* JADX INFO: renamed from: v */
    private static final String f133v = "assets/bf/shaders";

    /* JADX INFO: renamed from: aj */
    private static final int f134aj = 10;

    /* JADX INFO: renamed from: a */
    private static void m17a(@NotNull Path path, @NotNull ObjectList<String> objectList) {
        try {
            DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
            try {
                for (Path path2 : directoryStreamNewDirectoryStream) {
                    if (objectList.size() < 10) {
                        try {
                            if (Files.isRegularFile(path2, new LinkOption[0])) {
                                String string = path2.getFileName().toString();
                                if (PatternReferences.XRAY.matcher(string.toLowerCase(Locale.ROOT)).find()) {
                                    objectList.add(string);
                                }
                            }
                        } catch (Throwable th) {
                        }
                    } else {
                        if (directoryStreamNewDirectoryStream != null) {
                            directoryStreamNewDirectoryStream.close();
                            return;
                        }
                        return;
                    }
                }
                if (directoryStreamNewDirectoryStream != null) {
                    directoryStreamNewDirectoryStream.close();
                }
            } catch (Throwable th2) {
                if (directoryStreamNewDirectoryStream != null) {
                    try {
                        directoryStreamNewDirectoryStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        } catch (IOException | SecurityException e) {
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m18a(@NotNull File file, @NotNull String str) {
        File file2 = new File(file, str);
        return file2.exists() && file2.isDirectory();
    }

    /* JADX INFO: renamed from: b */
    private static boolean m19b(@NotNull File file, @NotNull String str) throws IOException {
        ZipFile zipFile = new ZipFile(file);
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (zipEntryNextElement.getName().startsWith(str) && !zipEntryNextElement.isDirectory()) {
                    zipFile.close();
                    return true;
                }
            }
            zipFile.close();
            return false;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m20a(@NotNull final Path path, @NotNull final String str, @NotNull final ObjectList<String> objectList) {
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() { // from class: com.boehmod.blockfront.B.1
                @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                @NotNull
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FileVisitResult visitFile(@NotNull Path path2, @NotNull BasicFileAttributes basicFileAttributes) {
                    if (objectList.size() >= 10) {
                        return FileVisitResult.TERMINATE;
                    }
                    if (path2.toString().toLowerCase(Locale.ROOT).endsWith(".zip")) {
                        try {
                            if (C0005B.m19b(path2.toFile(), str)) {
                                objectList.add(C0005B.m21a(path, path2));
                            }
                        } catch (Throwable th) {
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                @NotNull
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FileVisitResult visitFileFailed(@NotNull Path path2, @NotNull IOException iOException) {
                    return FileVisitResult.CONTINUE;
                }

                @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
                @NotNull
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public FileVisitResult preVisitDirectory(@NotNull Path path2, @NotNull BasicFileAttributes basicFileAttributes) {
                    if (objectList.size() >= 10) {
                        return FileVisitResult.TERMINATE;
                    }
                    try {
                        if (C0005B.m18a(path2.toFile(), str)) {
                            objectList.add(C0005B.m21a(path, path2));
                        }
                    } catch (Throwable th) {
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException | SecurityException e) {
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static String m21a(@NotNull Path path, @NotNull Path path2) {
        try {
            String string = path.relativize(path2).toString();
            return string.isEmpty() ? path2.getFileName().toString() : string;
        } catch (IllegalArgumentException e) {
            return path2.getFileName().toString();
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String mo14a(@NotNull Minecraft minecraft, @NotNull C0994s c0994s) {
        try {
            Path resourcePackDirectory = minecraft.getResourcePackDirectory();
            if (!Files.isDirectory(resourcePackDirectory, new LinkOption[0])) {
                return null;
            }
            ObjectArrayList objectArrayList = new ObjectArrayList();
            m17a(resourcePackDirectory, (ObjectList<String>) objectArrayList);
            m20a(resourcePackDirectory, f132u, objectArrayList);
            m20a(resourcePackDirectory, f133v, objectArrayList);
            if (objectArrayList.isEmpty()) {
                return null;
            }
            return String.join(", ", (Iterable<? extends CharSequence>) objectArrayList);
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0994s.a mo11a() {
        return C0994s.a.STARTUP;
    }

    @Override // com.boehmod.blockfront.InterfaceC0009F
    /* JADX INFO: renamed from: g */
    public int mo12g() {
        return 3;
    }
}
