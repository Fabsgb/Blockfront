package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ConnectionType;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.iR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iR.class */
public interface InterfaceC0481iR {
    @NotNull
    /* JADX INFO: renamed from: a */
    UUID mo1723a();

    @NotNull
    String getUsername();

    byte[] getHardwareId();

    @NotNull
    String getVersion();

    @NotNull
    String getVersionHash();

    @NotNull
    ConnectionType getType();

    /* JADX INFO: renamed from: b */
    int mo1724b();

    @NotNull
    /* JADX INFO: renamed from: a */
    String mo1725a();

    @NotNull
    /* JADX INFO: renamed from: b */
    String mo1726b();

    /* JADX INFO: renamed from: c */
    int mo1727c();

    /* JADX INFO: renamed from: a */
    void mo1729a(@NotNull String str);

    /* JADX INFO: renamed from: a */
    boolean mo1730a();
}
