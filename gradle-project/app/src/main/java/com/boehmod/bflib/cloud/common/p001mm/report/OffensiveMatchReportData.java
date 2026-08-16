package com.boehmod.bflib.cloud.common.p001mm.report;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/mm/report/OffensiveMatchReportData.class */
public final class OffensiveMatchReportData extends Record implements IMatchReportData {
    private final int maxWaves;
    private final int objectiveCount;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f9ID = new PacketIdentifier("OffensiveMatchReportData");

    public OffensiveMatchReportData(int maxWaves, int objectiveCount) {
        this.maxWaves = maxWaves;
        this.objectiveCount = objectiveCount;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, OffensiveMatchReportData.class), OffensiveMatchReportData.class, "maxWaves;objectiveCount", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/OffensiveMatchReportData;->maxWaves:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/OffensiveMatchReportData;->objectiveCount:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, OffensiveMatchReportData.class), OffensiveMatchReportData.class, "maxWaves;objectiveCount", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/OffensiveMatchReportData;->maxWaves:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/OffensiveMatchReportData;->objectiveCount:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, OffensiveMatchReportData.class, Object.class), OffensiveMatchReportData.class, "maxWaves;objectiveCount", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/OffensiveMatchReportData;->maxWaves:I", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/OffensiveMatchReportData;->objectiveCount:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int maxWaves() {
        return this.maxWaves;
    }

    public int objectiveCount() {
        return this.objectiveCount;
    }

    public OffensiveMatchReportData(@NotNull ByteBuf byteBuffer) {
        this(byteBuffer.readInt(), byteBuffer.readInt());
    }

    @Override // com.boehmod.bflib.cloud.common.p001mm.report.IMatchReportData
    @NotNull
    public PacketIdentifier getIdentifier() {
        return f9ID;
    }

    @Override // com.boehmod.bflib.cloud.common.p001mm.report.IMatchReportData
    public void write(@NotNull ByteBuf byteBuffer) throws IOException {
        byteBuffer.writeInt(this.maxWaves);
        byteBuffer.writeInt(this.objectiveCount);
    }

    @Override // com.boehmod.bflib.cloud.common.p001mm.report.IMatchReportData
    public void writeJson(@NotNull JsonObject json) {
        json.addProperty("maxWaves", Integer.valueOf(this.maxWaves));
        json.addProperty("objectiveCount", Integer.valueOf(this.objectiveCount));
    }
}
