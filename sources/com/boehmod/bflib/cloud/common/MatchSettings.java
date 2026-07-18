package com.boehmod.bflib.cloud.common;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/MatchSettings.class */
public class MatchSettings {
    public static final int DEFAULT_MAX_SPECTATORS = 4;
    private boolean teamSizeLimit = true;
    private boolean allowSpectators = true;
    private int maxSpectators = 4;

    public void toggleTeamSizeLimit() {
        this.teamSizeLimit = !this.teamSizeLimit;
    }

    public boolean hasTeamSizeLimit() {
        return this.teamSizeLimit;
    }

    public void toggleAllowSpectators() {
        this.allowSpectators = !this.allowSpectators;
    }

    public void setAllowSpectators(boolean allowSpectators) {
        this.allowSpectators = allowSpectators;
    }

    public boolean allowsSpectators() {
        return this.allowSpectators;
    }

    public void setMaxSpectators(int maxSpectators) {
        this.maxSpectators = Math.max(0, maxSpectators);
    }

    public int getMaxSpectators() {
        return this.maxSpectators;
    }

    public void copyFrom(@NotNull MatchSettings other) {
        this.teamSizeLimit = other.teamSizeLimit;
        this.allowSpectators = other.allowSpectators;
        this.maxSpectators = other.maxSpectators;
    }

    public void reset() {
        this.teamSizeLimit = true;
        this.allowSpectators = true;
        this.maxSpectators = 4;
    }

    public boolean isDefault() {
        return this.teamSizeLimit && this.allowSpectators && this.maxSpectators == 4;
    }

    public void read(@NotNull ByteBuf byteBuffer) {
        this.teamSizeLimit = IPacket.readBoolean(byteBuffer);
        this.allowSpectators = IPacket.readBoolean(byteBuffer);
        this.maxSpectators = byteBuffer.readInt();
    }

    public void write(@NotNull ByteBuf byteBuffer) {
        IPacket.writeBoolean(byteBuffer, this.teamSizeLimit);
        IPacket.writeBoolean(byteBuffer, this.allowSpectators);
        byteBuffer.writeInt(this.maxSpectators);
    }
}
