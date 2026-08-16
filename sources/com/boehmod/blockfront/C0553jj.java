package com.boehmod.blockfront;

import com.boehmod.bflib.common.util.HardwareId;
import com.boehmod.bflib.common.util.HexUtils;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;

/* JADX INFO: renamed from: com.boehmod.blockfront.jj */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jj.class */
public class C0553jj {

    /* JADX INFO: renamed from: c */
    private static final byte[] f3290c = new byte[0];

    /* JADX INFO: renamed from: d */
    private static final byte[] f3291d = m2502b();

    /* JADX INFO: renamed from: a */
    public static byte[] m2501a() {
        return f3291d;
    }

    /* JADX INFO: renamed from: b */
    private static byte[] m2502b() {
        C0530jM.log("Generating enhanced unique and secure hardware ID.", new Object[0]);
        try {
            HardwareAbstractionLayer hardware = new SystemInfo().getHardware();
            ComputerSystem computerSystem = hardware.getComputerSystem();
            CentralProcessor processor = hardware.getProcessor();
            List diskStores = hardware.getDiskStores();
            List networkIFs = hardware.getNetworkIFs();
            StringBuilder sb = new StringBuilder();
            sb.append(m2503e(m2504f(computerSystem.getHardwareUUID())));
            sb.append(m2503e(m2504f(computerSystem.getBaseboard().getSerialNumber())));
            sb.append(m2503e(m2504f(processor.getProcessorIdentifier().getProcessorID())));
            diskStores.stream().map((v0) -> {
                return v0.getSerial();
            }).filter(str -> {
                return (str == null || str.isEmpty()) ? false : true;
            }).sorted().forEach(str2 -> {
                sb.append(m2503e(m2504f(str2)));
            });
            networkIFs.stream().map((v0) -> {
                return v0.getMacaddr();
            }).filter(str3 -> {
                return (str3 == null || str3.isEmpty()) ? false : true;
            }).sorted().forEach(str4 -> {
                sb.append(m2503e(m2504f(str4)));
            });
            sb.append(m2503e(System.getProperty("os.name")));
            sb.append(m2503e(System.getProperty("os.arch")));
            sb.append(m2503e(System.getProperty("os.version")));
            return MessageDigest.getInstance(HardwareId.ALGORITHM).digest(sb.toString().getBytes(StandardCharsets.UTF_8));
        } catch (Throwable th) {
            C0530jM.m2338a("Failed to generate unique and secure hardware ID.", th, new Object[0]);
            return f3290c;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    private static String m2503e(@Nullable String str) {
        return str != null ? str : "";
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    private static String m2504f(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            return HexUtils.bytesToHex(MessageDigest.getInstance(HardwareId.ALGORITHM).digest(str.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
