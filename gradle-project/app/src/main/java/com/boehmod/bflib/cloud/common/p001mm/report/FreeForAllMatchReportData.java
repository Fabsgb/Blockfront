package com.boehmod.bflib.cloud.common.p001mm.report;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/mm/report/FreeForAllMatchReportData.class */
public final class FreeForAllMatchReportData extends Record implements IMatchReportData {
    private final int killLimit;

    /* JADX INFO: renamed from: ID */
    @NotNull
    public static final PacketIdentifier f8ID = new PacketIdentifier("FreeForAllMatchReportData");

    public FreeForAllMatchReportData(int killLimit) {
        this.killLimit = killLimit;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FreeForAllMatchReportData.class), FreeForAllMatchReportData.class, "killLimit", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/FreeForAllMatchReportData;->killLimit:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FreeForAllMatchReportData.class), FreeForAllMatchReportData.class, "killLimit", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/FreeForAllMatchReportData;->killLimit:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object o) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FreeForAllMatchReportData.class, Object.class), FreeForAllMatchReportData.class, "killLimit", "FIELD:Lcom/boehmod/bflib/cloud/common/mm/report/FreeForAllMatchReportData;->killLimit:I").dynamicInvoker().invoke(this, o) /* invoke-custom */;
    }

    public int killLimit() {
        return this.killLimit;
    }

    public FreeForAllMatchReportData(@NotNull ByteBuf byteBuffer) {
        this(byteBuffer.readInt());
    }

    @Override // com.boehmod.bflib.cloud.common.p001mm.report.IMatchReportData
    @NotNull
    public PacketIdentifier getIdentifier() {
        return f8ID;
    }

    @Override // com.boehmod.bflib.cloud.common.p001mm.report.IMatchReportData
    public void write(@NotNull ByteBuf byteBuffer) throws IOException {
        byteBuffer.writeInt(this.killLimit);
    }

    @Override // com.boehmod.bflib.cloud.common.p001mm.report.IMatchReportData
    public void writeJson(@NotNull JsonObject json) {
        json.addProperty("killLimit", Integer.valueOf(this.killLimit));
    }
}
