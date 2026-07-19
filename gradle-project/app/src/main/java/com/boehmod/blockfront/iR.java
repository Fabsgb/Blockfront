package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.ConnectionType;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/iR.class */
public interface iR {
    @NotNull
    /* JADX INFO: renamed from: a */
    UUID mo409a();

    @NotNull
    String getUsername();

    byte[] getHardwareId();

    @NotNull
    String getVersion();

    @NotNull
    String getVersionHash();

    @NotNull
    ConnectionType getType();

    int b();

    @NotNull
    /* JADX INFO: renamed from: a */
    String mo410a();

    @NotNull
    /* JADX INFO: renamed from: b */
    String mo411b();

    int c();

    void a(@NotNull String str);

    /* JADX INFO: renamed from: a */
    boolean mo412a();
}
