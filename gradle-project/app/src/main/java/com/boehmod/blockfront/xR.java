package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager;
import com.boehmod.bflib.cloud.common.profanity.Profanity;
import com.boehmod.bflib.cloud.packet.common.PacketProfanity;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/xR.class */
public class xR extends AbstractProfanityManager {

    @NotNull
    private final xw b;

    public xR(@NotNull xw xwVar) {
        this.b = xwVar;
    }

    @Override // com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager
    protected void handleProfanityImmediately(@NotNull UUID uuid, @NotNull Profanity profanity, @NotNull String str) {
        xQ xQVar = (xQ) this.b.a();
        int severity = profanity.getSeverity();
        xO xOVarB = xQVar.b(uuid);
        C0263jt.log("Profanity detected in message from '%s' - Severity '%d' - Id '%s' ('%s')", uuid, Integer.valueOf(severity), profanity.getId(), str);
        ((xu) this.b.b()).sendPacket(new PacketProfanity(uuid, str, xOVarB.g(), severity));
    }

    @Override // com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager
    protected void log(@NotNull String str, Object... objArr) {
        C0263jt.log(str, objArr);
    }

    @Override // com.boehmod.bflib.cloud.common.profanity.AbstractProfanityManager
    protected void logError(@NotNull String str, Object... objArr) {
        C0263jt.logError(str, objArr);
    }
}
