package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager;
import com.boehmod.bflib.cloud.common.profanity.Profanity;
import com.boehmod.bflib.cloud.packet.common.PacketProfanity;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xR.class */
public class C1277xR extends AbstractProfanityManager {

    /* JADX INFO: renamed from: b */
    @NotNull
    private final C1300xw f7486b;

    public C1277xR(@NotNull C1300xw c1300xw) {
        this.f7486b = c1300xw;
    }

    @Override // com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager
    protected void handleProfanityImmediately(@NotNull UUID uuid, @NotNull Profanity profanity, @NotNull String str) {
        C1276xQ c1276xQ = (C1276xQ) this.f7486b.m7950a();
        int severity = profanity.getSeverity();
        C1274xO c1274xOB = c1276xQ.m1135b(uuid);
        C0562jt.log("Profanity detected in message from '%s' - Severity '%d' - Id '%s' ('%s')", uuid, Integer.valueOf(severity), profanity.getId(), str);
        ((C1298xu) this.f7486b.m7961b()).sendPacket(new PacketProfanity(uuid, str, c1274xOB.m1108g(), severity));
    }

    @Override // com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager
    protected void log(@NotNull String str, Object... objArr) {
        C0562jt.log(str, objArr);
    }

    @Override // com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager
    protected void logError(@NotNull String str, Object... objArr) {
        C0562jt.logError(str, objArr);
    }
}
