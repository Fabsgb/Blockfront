package com.boehmod.blockfront;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pt.class */
public class C0881pt {

    /* JADX INFO: renamed from: s */
    @NotNull
    public static final Codec<C0881pt> f4825s = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0881pt -> {
            return Double.valueOf(c0881pt.f4827c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0881pt2 -> {
            return Double.valueOf(c0881pt2.f4827c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0881pt3 -> {
            return Double.valueOf(c0881pt3.f4827c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0881pt4 -> {
            return Float.valueOf(c0881pt4.f4826h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0881pt5 -> {
            return Float.valueOf(c0881pt5.f4826h.y);
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new C0881pt(v1, v2, v3, v4, v5);
        });
    });

    /* JADX INFO: renamed from: h */
    @NotNull
    public Vec2 f4826h;

    /* JADX INFO: renamed from: c */
    @NotNull
    public Vec3 f4827c;

    public C0881pt() {
        this.f4827c = new Vec3(0.0d, 0.0d, 0.0d);
        this.f4826h = new Vec2(0.0f, 0.0f);
    }

    public C0881pt(double d, double d2, double d3, float f, float f2) {
        this.f4827c = new Vec3(d, d2, d3);
        this.f4826h = new Vec2(f, f2);
    }

    public C0881pt(double d, double d2, double d3) {
        this(d, d2, d3, 0.0f, 0.0f);
    }

    public C0881pt(@NotNull BlockPos blockPos, float f, float f2) {
        this(blockPos.getX(), blockPos.getY(), blockPos.getZ(), f, f2);
    }

    public C0881pt(@NotNull Vec3 vec3, float f, float f2) {
        this(vec3.x, vec3.y, vec3.z, f, f2);
    }

    public C0881pt(@NotNull Player player, float f, float f2) {
        this(player.getX(), player.getY(), player.getZ(), f, f2);
    }

    public C0881pt(@NotNull Player player) {
        this(player, player.getYHeadRot(), player.getXRot());
    }

    public C0881pt(@NotNull ByteBuf byteBuf) throws IOException {
        mo3869b(byteBuf);
    }

    /* JADX INFO: renamed from: c */
    public void m4566c(@NotNull C0881pt c0881pt) {
        this.f4827c = c0881pt.f4827c;
        this.f4826h = c0881pt.f4826h;
    }

    /* JADX INFO: renamed from: aQ */
    public float m4567aQ() {
        return this.f4826h.x;
    }

    /* JADX INFO: renamed from: aR */
    public float m4568aR() {
        return this.f4826h.y;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<Player> m4569a(@NotNull Level level, int i, @NotNull Set<UUID> set) {
        return m4570a(level, m4583b(i), set);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<Player> m4570a(@NotNull Level level, @NotNull AABB aabb, @NotNull Set<UUID> set) {
        return level.getEntitiesOfClass(Player.class, aabb, player -> {
            return player.isAlive() && player.tickCount >= 20 && set.contains(player.getUUID());
        });
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<ServerPlayer> m4571a(@NotNull ServerLevel serverLevel, int i, @NotNull Set<UUID> set) {
        return m4572a(serverLevel, m4583b(i), set);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<ServerPlayer> m4572a(@NotNull ServerLevel serverLevel, @NotNull AABB aabb, @NotNull Set<UUID> set) {
        return serverLevel.getEntitiesOfClass(ServerPlayer.class, aabb, serverPlayer -> {
            return serverPlayer.isAlive() && serverPlayer.tickCount >= 20 && set.contains(serverPlayer.getUUID());
        });
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<AbstractC0750nU> m4573a(@NotNull Level level, int i) {
        return level.getEntitiesOfClass(AbstractC0750nU.class, m4583b(i));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C0756na> m4574a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull ServerLevel serverLevel, int i) {
        return m4575a(abstractC0863pb, serverLevel, m4583b(i));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C0756na> m4575a(@NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull ServerLevel serverLevel, @NotNull AABB aabb) {
        return serverLevel.getEntitiesOfClass(C0756na.class, aabb, c0756na -> {
            return c0756na.m3516a() == abstractC0863pb;
        });
    }

    /* JADX INFO: renamed from: b */
    public boolean m4576b(@NotNull Entity entity, int i) {
        return m4577a(entity) <= ((float) i);
    }

    /* JADX INFO: renamed from: a */
    public float m4577a(@NotNull Entity entity) {
        return Mth.sqrt((float) entity.distanceToSqr(this.f4827c));
    }

    /* JADX INFO: renamed from: a */
    public double m4578a(@NotNull C0881pt c0881pt) {
        return Mth.sqrt((float) c0881pt.m4580b(this));
    }

    /* JADX INFO: renamed from: a */
    public double m4579a(@NotNull Vec3 vec3) {
        return Mth.sqrt((float) vec3.distanceToSqr(this.f4827c));
    }

    /* JADX INFO: renamed from: b */
    public double m4580b(@NotNull C0881pt c0881pt) {
        double d = c0881pt.f4827c.x - this.f4827c.x;
        double d2 = c0881pt.f4827c.y - this.f4827c.y;
        double d3 = c0881pt.f4827c.z - this.f4827c.z;
        return (d * d) + (d2 * d2) + (d3 * d3);
    }

    /* JADX INFO: renamed from: a */
    public double m4581a(@NotNull BlockPos blockPos) {
        return Mth.sqrt((float) blockPos.distToLowCornerSqr(this.f4827c.x, this.f4827c.y, this.f4827c.z));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Player m4582a(@NotNull Level level, int i) {
        return level.getNearestPlayer(this.f4827c.x, this.f4827c.y, this.f4827c.z, i, false);
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C0881pt mo3849d() {
        return new C0881pt(new Vec3(this.f4827c.x, this.f4827c.y, this.f4827c.z), this.f4826h.x, this.f4826h.y);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0881pt)) {
            return false;
        }
        C0881pt c0881pt = (C0881pt) obj;
        return c0881pt.f4827c.equals(this.f4827c) && c0881pt.f4826h.equals(this.f4826h);
    }

    public int hashCode() {
        return (31 * ((31 * this.f4827c.hashCode()) + Float.hashCode(this.f4826h.x))) + Float.hashCode(this.f4826h.y);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public AABB m4583b(int i) {
        return new AABB(this.f4827c, this.f4827c).inflate(i, 0.0d, i).expandTowards(0.0d, 2.0d, 0.0d);
    }

    /* JADX INFO: renamed from: s */
    public final double m4584s() {
        return this.f4827c.x;
    }

    /* JADX INFO: renamed from: t */
    public final double m4585t() {
        return this.f4827c.y;
    }

    /* JADX INFO: renamed from: u */
    public final double m4586u() {
        return this.f4827c.z;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public BlockPos m4587c() {
        return BlockPos.containing(this.f4827c);
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: b */
    public void mo3869b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4827c = new Vec3(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble());
        this.f4826h = new Vec2(byteBuf.readFloat(), byteBuf.readFloat());
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: c */
    public void mo3870c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeDouble(this.f4827c.x);
        byteBuf.writeDouble(this.f4827c.y);
        byteBuf.writeDouble(this.f4827c.z);
        byteBuf.writeFloat(this.f4826h.x);
        byteBuf.writeFloat(this.f4826h.y);
    }

    /* JADX INFO: renamed from: a */
    public static C0881pt m4588a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C0881pt(friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: b */
    public void m4589b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeDouble(this.f4827c.x);
        friendlyByteBuf.writeDouble(this.f4827c.y);
        friendlyByteBuf.writeDouble(this.f4827c.z);
        friendlyByteBuf.writeFloat(this.f4826h.x);
        friendlyByteBuf.writeFloat(this.f4826h.y);
    }
}
