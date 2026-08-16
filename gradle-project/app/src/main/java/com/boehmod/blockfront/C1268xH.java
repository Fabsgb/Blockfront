package com.boehmod.blockfront;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xH */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xH.class */
public class C1268xH {
    /* JADX WARN: Code duplicated, block: B:25:0x0080 A[LOOP:1: B:23:0x0079->B:25:0x0080, LOOP_END] */
    @NotNull
    /* JADX INFO: renamed from: c */
    public static String m7154c(@NotNull Path path) throws NoSuchAlgorithmException, IOException {
        StringBuilder sb;
        int i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        try {
            InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
            try {
                byte[] bArr = new byte[InterfaceC1274xN.f6856vY];
                while (true) {
                    int i2 = inputStreamNewInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i2);
                    C0530jM.logError("Failed to calculate MD5 hash for file: " + String.valueOf(path), new Object[0]);
                    byte[] bArrDigest = messageDigest.digest();
                    sb = new StringBuilder();
                    for (byte b : bArrDigest) {
                        sb.append(String.format("%02x", Byte.valueOf(b)));
                    }
                    return sb.toString();
                }
                if (inputStreamNewInputStream != null) {
                    inputStreamNewInputStream.close();
                }
            } catch (Throwable th) {
                if (inputStreamNewInputStream != null) {
                    try {
                        inputStreamNewInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            C0530jM.logError("Failed to calculate MD5 hash for file: " + String.valueOf(path), new Object[0]);
        }
        byte[] bArrDigest2 = messageDigest.digest();
        sb = new StringBuilder();
        while (i < r0) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }
}
