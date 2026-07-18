package com.boehmod.blockfront;

import com.boehmod.bflib.common.PatternReferences;
import com.boehmod.blockfront.C0940r;
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
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.client.Minecraft;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.x */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/x.class */
public class C1259x implements InterfaceC1305z<C0940r> {

    /* JADX INFO: renamed from: p */
    private static final String f7445p = "assets/minecraft/shaders";

    /* JADX INFO: renamed from: q */
    private static final String f7446q = "assets/bf/shaders";

    /* JADX INFO: renamed from: a */
    public static boolean m7738a(@NotNull Path path) throws IOException {
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

    /* JADX INFO: renamed from: a */
    public static boolean m7739a(@NotNull Path path, String str) throws IOException {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() { // from class: com.boehmod.blockfront.x.1

            /* JADX INFO: renamed from: r */
            final /* synthetic */ String f7447r;

            /* JADX INFO: renamed from: a */
            final /* synthetic */ List f7448a;

            AnonymousClass1(String str2, List objectArrayList2) {
                str = str2;
                list = objectArrayList2;
            }

            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
            @NotNull
            /* JADX INFO: renamed from: a */
            public FileVisitResult visitFile(@NotNull Path path2, @NotNull BasicFileAttributes basicFileAttributes) throws IOException {
                if (path2.toString().endsWith(".zip") && C1259x.m7741b(path2.toFile(), str)) {
                    list.add(path2.toString());
                }
                return FileVisitResult.CONTINUE;
            }

            @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
            @NotNull
            /* JADX INFO: renamed from: b */
            public FileVisitResult preVisitDirectory(@NotNull Path path2, @NotNull BasicFileAttributes basicFileAttributes) {
                if (C1259x.m7740a(path2.toFile(), str)) {
                    list.add(path2.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return !objectArrayList2.isEmpty();
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.x$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/x$1.class */
    class AnonymousClass1 extends SimpleFileVisitor<Path> {

        /* JADX INFO: renamed from: r */
        final /* synthetic */ String f7447r;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ List f7448a;

        AnonymousClass1(String str2, List objectArrayList2) {
            str = str2;
            list = objectArrayList2;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        @NotNull
        /* JADX INFO: renamed from: a */
        public FileVisitResult visitFile(@NotNull Path path2, @NotNull BasicFileAttributes basicFileAttributes) throws IOException {
            if (path2.toString().endsWith(".zip") && C1259x.m7741b(path2.toFile(), str)) {
                list.add(path2.toString());
            }
            return FileVisitResult.CONTINUE;
        }

        @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
        @NotNull
        /* JADX INFO: renamed from: b */
        public FileVisitResult preVisitDirectory(@NotNull Path path2, @NotNull BasicFileAttributes basicFileAttributes) {
            if (C1259x.m7740a(path2.toFile(), str)) {
                list.add(path2.toString());
            }
            return FileVisitResult.CONTINUE;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m7740a(@NotNull File file, @NotNull String str) {
        File file2 = new File(file, str);
        return file2.exists() && file2.isDirectory();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m7741b(@NotNull File file, @NotNull String str) throws IOException {
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

    @Override // com.boehmod.blockfront.InterfaceC1305z
    /* JADX INFO: renamed from: a */
    public boolean mo6058a(@NotNull Minecraft minecraft, @NotNull C0940r c0940r) {
        try {
            Path resourcePackDirectory = minecraft.getResourcePackDirectory();
            return m7738a(resourcePackDirectory) || m7739a(resourcePackDirectory, f7445p) || m7739a(resourcePackDirectory, f7446q);
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.boehmod.blockfront.InterfaceC1305z
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0940r.a mo6057a() {
        return C0940r.a.STARTUP;
    }
}
