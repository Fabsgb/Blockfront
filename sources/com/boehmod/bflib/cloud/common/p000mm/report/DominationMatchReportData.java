package com.boehmod.bflib.cloud.common.p000mm.report;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/mm/report/DominationMatchReportData.class */
public final class DominationMatchReportData extends Record implements IMatchReportData {
    private final int scoreLimit;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f7ID = new PacketIdentifier("DominationMatchReportData");

    public DominationMatchReportData(int scoreLimit) {
        this.scoreLimit = scoreLimit;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, DominationMatchReportData.class), DominationMatchReportData.class, "scoreLimit", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/DominationMatchReportData;->scoreLimit:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, DominationMatchReportData.class), DominationMatchReportData.class, "scoreLimit", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/DominationMatchReportData;->scoreLimit:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, DominationMatchReportData.class, Object.class), DominationMatchReportData.class, "scoreLimit", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/DominationMatchReportData;->scoreLimit:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int scoreLimit() {
        return this.scoreLimit;
    }

    public DominationMatchReportData(@NotNull ByteBuf byteBuffer) {
        this(byteBuffer.readInt());
    }

    @Override // com.boehmod.bflib.cloud.common.p000mm.report.IMatchReportData
    @NotNull
    public PacketIdentifier getIdentifier() {
        return f7ID;
    }

    @Override // com.boehmod.bflib.cloud.common.p000mm.report.IMatchReportData
    public void write(@NotNull ByteBuf byteBuffer) throws IOException {
        byteBuffer.writeInt(this.scoreLimit);
    }

    @Override // com.boehmod.bflib.cloud.common.p000mm.report.IMatchReportData
    public void writeJson(@NotNull JsonObject json) {
        json.addProperty("scoreLimit", Integer.valueOf(this.scoreLimit));
    }
}
