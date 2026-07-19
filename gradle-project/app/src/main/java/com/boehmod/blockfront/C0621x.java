package com.boehmod.blockfront;

import com.boehmod.bflib.common.PatternReferences;
import com.boehmod.blockfront.C0459r;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/x.class */
public class C0621x implements InterfaceC0641z<C0459r> {
    private static final String p = "assets/minecraft/shaders";
    private static final String q = "assets/bf/shaders";

    public static boolean a(@NotNull Path path) throws IOException {
        if (!Files.isDirectory(path, new LinkOption[0])) {
            throw new IllegalArgumentException(String.valueOf(path) + " is not a directory.");
        }
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
        try {
            for (Path path2 : directoryStreamNewDirectoryStream) {
                if (Files.isRegularFile(path2, new LinkOption[0])) {
                    if (PatternReferences.XRAY.matcher(path2.getFileName().toString().toLowerCase(Locale.ROOT)).find()) {
                        if (directoryStreamNewDirectoryStream != null) {
                            directoryStreamNewDirectoryStream.close();
                        }
                        return true;
                    }
                }
            }
            if (directoryStreamNewDirectoryStream != null) {
                directoryStreamNewDirectoryStream.close();
                return false;
            }
            return false;
        } catch (Throwable th) {
            if (directoryStreamNewDirectoryStream != null) {
                try {
                    directoryStreamNewDirectoryStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static boolean a(@NotNull Path path, final String str) throws IOException {
        final ObjectArrayList objectArrayList = new ObjectArrayList();
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() { // from class: com.boehmod.blockfront.x.1
            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
            @NotNull
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public FileVisitResult visitFile(@NotNull Path path2, @NotNull BasicFileAttributes basicFileAttributes) throws IOException {
                if (path2.toString().endsWith(".zip") && C0621x.b(path2.toFile(), str)) {
                    objectArrayList.add(path2.toString());
                }
                return FileVisitResult.CONTINUE;
            }

            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public FileVisitResult preVisitDirectory(@NotNull Path path2, @NotNull BasicFileAttributes basicFileAttributes) {
                if (C0621x.a(path2.toFile(), str)) {
                    objectArrayList.add(path2.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return !objectArrayList.isEmpty();
    }

    public static boolean a(@NotNull File file, @NotNull String str) {
        File file2 = new File(file, str);
        return file2.exists() && file2.isDirectory();
    }

    public static boolean b(@NotNull File file, @NotNull String str) throws IOException {
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

    @Override // com.boehmod.blockfront.InterfaceC0641z
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0459r c0459r) {
        try {
            Path resourcePackDirectory = minecraft.getResourcePackDirectory();
            return a(resourcePackDirectory) || a(resourcePackDirectory, p) || a(resourcePackDirectory, q);
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC0641z
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0459r.a mo1294a() {
        return C0459r.a.STARTUP;
    }
}
