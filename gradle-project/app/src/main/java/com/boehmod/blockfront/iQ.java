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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iQ.class */
public class iQ {
    private static final byte[] c = new byte[0];
    private static final byte[] d = b();

    public static byte[] a() {
        return d;
    }

    private static byte[] b() {
        C0263jt.log("Generating enhanced unique and secure hardware ID.", new Object[0]);
        try {
            HardwareAbstractionLayer hardware = new SystemInfo().getHardware();
            ComputerSystem computerSystem = hardware.getComputerSystem();
            CentralProcessor processor = hardware.getProcessor();
            List diskStores = hardware.getDiskStores();
            List networkIFs = hardware.getNetworkIFs();
            StringBuilder sb = new StringBuilder();
            sb.append(e(f(computerSystem.getHardwareUUID())));
            sb.append(e(f(computerSystem.getBaseboard().getSerialNumber())));
            sb.append(e(f(processor.getProcessorIdentifier().getProcessorID())));
            diskStores.stream().map((v0) -> {
                return v0.getSerial();
            }).filter(str -> {
                return (str == null || str.isEmpty()) ? false : true;
            }).sorted().forEach(str2 -> {
                sb.append(e(f(str2)));
            });
            networkIFs.stream().map((v0) -> {
                return v0.getMacaddr();
            }).filter(str3 -> {
                return (str3 == null || str3.isEmpty()) ? false : true;
            }).sorted().forEach(str4 -> {
                sb.append(e(f(str4)));
            });
            sb.append(e(System.getProperty("os.name")));
            sb.append(e(System.getProperty("os.arch")));
            sb.append(e(System.getProperty("os.version")));
            return MessageDigest.getInstance(HardwareId.ALGORITHM).digest(sb.toString().getBytes(StandardCharsets.UTF_8));
        } catch (Throwable th) {
            C0263jt.a("Failed to generate unique and secure hardware ID.", th, new Object[0]);
            return c;
        }
    }

    @NotNull
    private static String e(@Nullable String str) {
        return str != null ? str : "";
    }

    @NotNull
    private static String f(@Nullable String str) {
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
