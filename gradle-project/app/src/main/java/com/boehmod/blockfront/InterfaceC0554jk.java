package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ConnectionType;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.jk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/jk.class */
public interface InterfaceC0554jk {
    @NotNull
    /* JADX INFO: renamed from: a */
    UUID mo1729a();

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
    int mo1730b();

    @NotNull
    /* JADX INFO: renamed from: a */
    String mo1731a();

    @NotNull
    /* JADX INFO: renamed from: b */
    String mo1732b();

    /* JADX INFO: renamed from: c */
    int mo1733c();

    /* JADX INFO: renamed from: a */
    void mo1735a(@NotNull String str);

    /* JADX INFO: renamed from: a */
    boolean mo1736a();
}
