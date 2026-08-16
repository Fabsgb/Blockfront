package com.boehmod.bflib.cloud.common.player;

import com.boehmod.bflib.cloud.packet.IPacket;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/com.boehmod.blockfront.BlockFrontLibrary-6.0.2.jar:com/boehmod/bflib/cloud/common/player/Punishment.class */
public class Punishment {

    @NotNull
    private static final ThreadLocal<DateFormat> DATE_FORMAT = ThreadLocal.withInitial(() -> {
        return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    });

    @NotNull
    public static final UUID REDACTED_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");

    /* JADX INFO: renamed from: id */
    @NotNull
    private final UUID f12id;

    @NotNull
    private final Date created;

    @NotNull
    private final Date ending;

    @NotNull
    private final String reason;

    @NotNull
    private final UUID issuer;

    @NotNull
    private final PunishmentType type;
    private final boolean isPermanent;
    private boolean closed;

    public Punishment(@NotNull ByteBuf byteBuffer) throws IOException {
        this.closed = false;
        this.f12id = IPacket.readUUID(byteBuffer);
        this.reason = IPacket.readString(byteBuffer);
        this.created = new Date(byteBuffer.readLong());
        this.ending = new Date(byteBuffer.readLong());
        this.type = (PunishmentType) IPacket.readEnum(byteBuffer, PunishmentType.class);
        this.closed = IPacket.readBoolean(byteBuffer);
        this.isPermanent = IPacket.readBoolean(byteBuffer);
        this.issuer = IPacket.readUUID(byteBuffer);
    }

    public Punishment(@NotNull UUID id, @NotNull Date created, @NotNull Date ending, @NotNull String reason, @NotNull PunishmentType punishmentType, @NotNull UUID issuer, boolean closed, boolean isPermanent) {
        this.closed = false;
        this.f12id = id;
        this.created = created;
        this.ending = ending;
        this.reason = reason;
        this.type = punishmentType;
        this.issuer = issuer;
        this.closed = closed;
        this.isPermanent = isPermanent;
    }

    public Punishment(@NotNull UUID id, long duration, @NotNull TimeUnit timeUnit, @NotNull String reason, @NotNull PunishmentType punishmentType, @NotNull UUID issuer, boolean isPermanent) {
        this.closed = false;
        this.f12id = id;
        this.created = new Date();
        this.ending = new Date(System.currentTimeMillis() + timeUnit.toMillis(duration));
        this.reason = reason;
        this.type = punishmentType;
        this.issuer = issuer;
        this.isPermanent = isPermanent;
    }

    public Punishment(@NotNull UUID id, long duration, @NotNull TimeUnit timeUnit, @NotNull String reason, @NotNull PunishmentType punishmentType, @NotNull UUID issuer) {
        this(id, duration, timeUnit, reason, punishmentType, issuer, false);
    }

    public Punishment(long duration, @NotNull TimeUnit timeUnit, @NotNull String reason, @NotNull PunishmentType punishmentType, @NotNull UUID issuer, boolean isPermanent) {
        this(UUID.randomUUID(), duration, timeUnit, reason, punishmentType, issuer, isPermanent);
    }

    public Punishment(long duration, @NotNull TimeUnit timeUnit, @NotNull String reason, @NotNull PunishmentType punishmentType, @NotNull UUID issuer) {
        this(UUID.randomUUID(), duration, timeUnit, reason, punishmentType, issuer, false);
    }

    public void write(@NotNull ByteBuf byteBuffer, boolean redactIssuer) throws IOException {
        IPacket.writeUUID(byteBuffer, this.f12id);
        IPacket.writeString(byteBuffer, this.reason);
        byteBuffer.writeLong(this.created.getTime());
        byteBuffer.writeLong(this.ending.getTime());
        IPacket.writeEnum(byteBuffer, this.type);
        IPacket.writeBoolean(byteBuffer, this.closed);
        IPacket.writeBoolean(byteBuffer, this.isPermanent);
        IPacket.writeUUID(byteBuffer, redactIssuer ? REDACTED_UUID : this.issuer);
    }

    @NotNull
    public String getStatus() {
        if (this.closed) {
            return "Closed (Potential Overlap)";
        }
        if (this.isPermanent) {
            return "Permanent";
        }
        if (this.ending.getTime() <= System.currentTimeMillis()) {
            return "Expired";
        }
        return "Active";
    }

    public void close() {
        setClosed(true);
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isActive() {
        if (this.closed) {
            return false;
        }
        return this.isPermanent || this.ending.getTime() > System.currentTimeMillis();
    }

    @NotNull
    public UUID getId() {
        return this.f12id;
    }

    @NotNull
    public Date getCreated() {
        return this.created;
    }

    @NotNull
    public Date getEnding() {
        return this.ending;
    }

    @NotNull
    public String getReason() {
        return this.reason;
    }

    @NotNull
    public UUID getIssuer() {
        return this.issuer;
    }

    @NotNull
    public PunishmentType getType() {
        return this.type;
    }

    public boolean isPermanent() {
        return this.isPermanent;
    }

    public long getTimeRemaining(@NotNull TimeUnit timeUnit) {
        long diffInMillis = this.ending.getTime() - System.currentTimeMillis();
        return timeUnit.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }

    @NotNull
    public String getTimeRemainingString() {
        if (this.isPermanent) {
            return "Permanent";
        }
        if (isActive()) {
            long minutesLeft = getTimeRemaining(TimeUnit.MINUTES);
            long days = TimeUnit.MINUTES.toDays(minutesLeft);
            long minutesLeft2 = minutesLeft - TimeUnit.DAYS.toMinutes(days);
            long hours = TimeUnit.MINUTES.toHours(minutesLeft2);
            return String.format("%d days %d hours %d minutes", Long.valueOf(days), Long.valueOf(hours), Long.valueOf(minutesLeft2 - TimeUnit.HOURS.toMinutes(hours)));
        }
        return "0 days 0 hours 0 minutes";
    }

    @NotNull
    public String getFormattedDateStarted() {
        return DATE_FORMAT.get().format(this.created);
    }

    @NotNull
    public String toString() {
        return "id=" + String.valueOf(this.f12id) + ",t=" + String.valueOf(this.type) + ",a=" + isActive() + ",by=" + String.valueOf(this.issuer) + ",for=" + this.reason;
    }
}
