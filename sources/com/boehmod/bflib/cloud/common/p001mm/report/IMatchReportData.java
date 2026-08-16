package com.boehmod.bflib.cloud.common.p001mm.report;

import com.boehmod.bflib.cloud.packet.PacketIdentifier;
import com.google.gson.JsonObject;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/mm/report/IMatchReportData.class */
public interface IMatchReportData {
    @NotNull
    PacketIdentifier getIdentifier();

    void write(@NotNull ByteBuf byteBuf) throws IOException;

    void writeJson(@NotNull JsonObject jsonObject);
}
