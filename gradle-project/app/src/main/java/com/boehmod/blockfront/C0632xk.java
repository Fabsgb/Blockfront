package com.boehmod.blockfront;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xk.class */
public class C0632xk {
    @NotNull
    public static String b(@NotNull Path path) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        try {
            InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
            try {
                byte[] bArr = new byte[InterfaceC0638xq.tU];
                while (true) {
                    int i = inputStreamNewInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i);
                }
                if (inputStreamNewInputStream != null) {
                    inputStreamNewInputStream.close();
                }
            } finally {
            }
        } catch (IOException e) {
            C0263jt.logError("Failed to calculate MD5 hash for file: " + String.valueOf(path), new Object[0]);
        }
        byte[] bArrDigest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
