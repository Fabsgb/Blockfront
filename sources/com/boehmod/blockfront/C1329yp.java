package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager;
import com.boehmod.bflib.cloud.common.profanity.Profanity;
import com.boehmod.bflib.cloud.packet.common.PacketProfanity;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.yp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/yp.class */
public class C1329yp extends AbstractProfanityManager {

    /* JADX INFO: renamed from: c */
    @NotNull
    private final C1280xT f9070c;

    public C1329yp(@NotNull C1280xT c1280xT) {
        this.f9070c = c1280xT;
    }

    @Override // com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager
    protected void handleProfanityImmediately(@NotNull UUID uuid, @NotNull Profanity profanity, @NotNull String str) {
        C1328yo c1328yo = (C1328yo) this.f9070c.m7277a();
        int severity = profanity.getSeverity();
        C1326ym c1326ymB = c1328yo.m1152b(uuid);
        C0530jM.log("Profanity detected in message from '%s' - Severity '%d' - Id '%s' ('%s')", uuid, Integer.valueOf(severity), profanity.getId(), str);
        ((C1278xR) this.f9070c.m7289b()).sendPacket(new PacketProfanity(uuid, str, c1326ymB.m1125k(), severity));
    }

    @Override // com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager
    protected void log(@NotNull String str, Object... objArr) {
        C0530jM.log(str, objArr);
    }

    @Override // com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager
    protected void logError(@NotNull String str, Object... objArr) {
        C0530jM.logError(str, objArr);
    }
}
