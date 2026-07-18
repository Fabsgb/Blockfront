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

/* JADX INFO: renamed from: com.boehmod.blockfront.oX */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oX.class */
public class C0805oX {

    /* JADX INFO: renamed from: s */
    @NotNull
    public static final Codec<C0805oX> f4422s = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0805oX -> {
            return Double.valueOf(c0805oX.f4424c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0805oX2 -> {
            return Double.valueOf(c0805oX2.f4424c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0805oX3 -> {
            return Double.valueOf(c0805oX3.f4424c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0805oX4 -> {
            return Float.valueOf(c0805oX4.f4423h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0805oX5 -> {
            return Float.valueOf(c0805oX5.f4423h.y);
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new C0805oX(v1, v2, v3, v4, v5);
        });
    });

    /* JADX INFO: renamed from: h */
    @NotNull
    public Vec2 f4423h;

    /* JADX INFO: renamed from: c */
    @NotNull
    public Vec3 f4424c;

    public C0805oX() {
        this.f4424c = new Vec3(0.0d, 0.0d, 0.0d);
        this.f4423h = new Vec2(0.0f, 0.0f);
    }

    public C0805oX(double d, double d2, double d3, float f, float f2) {
        this.f4424c = new Vec3(d, d2, d3);
        this.f4423h = new Vec2(f, f2);
    }

    public C0805oX(double d, double d2, double d3) {
        this(d, d2, d3, 0.0f, 0.0f);
    }

    public C0805oX(@NotNull BlockPos blockPos, float f, float f2) {
        this(blockPos.getX(), blockPos.getY(), blockPos.getZ(), f, f2);
    }

    public C0805oX(@NotNull Vec3 vec3, float f, float f2) {
        this(vec3.x, vec3.y, vec3.z, f, f2);
    }

    public C0805oX(@NotNull Player player, float f, float f2) {
        this(player.getX(), player.getY(), player.getZ(), f, f2);
    }

    public C0805oX(@NotNull Player player) {
        this(player, player.getYHeadRot(), player.getXRot());
    }

    public C0805oX(@NotNull ByteBuf byteBuf) throws IOException {
        mo4110b(byteBuf);
    }

    /* JADX INFO: renamed from: c */
    public void m4129c(@NotNull C0805oX c0805oX) {
        this.f4424c = c0805oX.f4424c;
        this.f4423h = c0805oX.f4423h;
    }

    /* JADX INFO: renamed from: aK */
    public float m4130aK() {
        return this.f4423h.x;
    }

    /* JADX INFO: renamed from: aL */
    public float m4131aL() {
        return this.f4423h.y;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<Player> m4132a(@NotNull Level level, int i, @NotNull Set<UUID> set) {
        return m4133a(level, m4146b(i), set);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<Player> m4133a(@NotNull Level level, @NotNull AABB aabb, @NotNull Set<UUID> set) {
        return level.getEntitiesOfClass(Player.class, aabb, player -> {
            return player.isAlive() && player.tickCount >= 20 && set.contains(player.getUUID());
        });
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<ServerPlayer> m4134a(@NotNull ServerLevel serverLevel, int i, @NotNull Set<UUID> set) {
        return m4135a(serverLevel, m4146b(i), set);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<ServerPlayer> m4135a(@NotNull ServerLevel serverLevel, @NotNull AABB aabb, @NotNull Set<UUID> set) {
        return serverLevel.getEntitiesOfClass(ServerPlayer.class, aabb, serverPlayer -> {
            return serverPlayer.isAlive() && serverPlayer.tickCount >= 20 && set.contains(serverPlayer.getUUID());
        });
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<AbstractC0779ny> m4136a(@NotNull Level level, int i) {
        return level.getEntitiesOfClass(AbstractC0779ny.class, m4146b(i));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C0680mE> m4137a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull ServerLevel serverLevel, int i) {
        return m4138a(abstractC0787oF, serverLevel, m4146b(i));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C0680mE> m4138a(@NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull ServerLevel serverLevel, @NotNull AABB aabb) {
        return serverLevel.getEntitiesOfClass(C0680mE.class, aabb, c0680mE -> {
            return c0680mE.m3008a() == abstractC0787oF;
        });
    }

    /* JADX INFO: renamed from: b */
    public boolean m4139b(@NotNull Entity entity, int i) {
        return m4140a(entity) <= ((float) i);
    }

    /* JADX INFO: renamed from: a */
    public float m4140a(@NotNull Entity entity) {
        return Mth.sqrt((float) entity.distanceToSqr(this.f4424c));
    }

    /* JADX INFO: renamed from: a */
    public double m4141a(@NotNull C0805oX c0805oX) {
        return Mth.sqrt((float) c0805oX.m4143b(this));
    }

    /* JADX INFO: renamed from: a */
    public double m4142a(@NotNull Vec3 vec3) {
        return Mth.sqrt((float) vec3.distanceToSqr(this.f4424c));
    }

    /* JADX INFO: renamed from: b */
    public double m4143b(@NotNull C0805oX c0805oX) {
        double d = c0805oX.f4424c.x - this.f4424c.x;
        double d2 = c0805oX.f4424c.y - this.f4424c.y;
        double d3 = c0805oX.f4424c.z - this.f4424c.z;
        return (d * d) + (d2 * d2) + (d3 * d3);
    }

    /* JADX INFO: renamed from: a */
    public double m4144a(@NotNull BlockPos blockPos) {
        return Mth.sqrt((float) blockPos.distToLowCornerSqr(this.f4424c.x, this.f4424c.y, this.f4424c.z));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Player m4145a(@NotNull Level level, int i) {
        return level.getNearestPlayer(this.f4424c.x, this.f4424c.y, this.f4424c.z, i, false);
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C0805oX mo4124d() {
        return new C0805oX(new Vec3(this.f4424c.x, this.f4424c.y, this.f4424c.z), this.f4423h.x, this.f4423h.y);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0805oX)) {
            return false;
        }
        C0805oX c0805oX = (C0805oX) obj;
        return c0805oX.f4424c.equals(this.f4424c) && c0805oX.f4423h.equals(this.f4423h);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public AABB m4146b(int i) {
        return new AABB(this.f4424c, this.f4424c).inflate(i, 0.0d, i).expandTowards(0.0d, 2.0d, 0.0d);
    }

    /* JADX INFO: renamed from: q */
    public final double m4147q() {
        return this.f4424c.x;
    }

    /* JADX INFO: renamed from: r */
    public final double m4148r() {
        return this.f4424c.y;
    }

    /* JADX INFO: renamed from: s */
    public final double m4149s() {
        return this.f4424c.z;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public BlockPos m4150c() {
        return BlockPos.containing(this.f4424c);
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: b */
    public void mo4110b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f4424c = new Vec3(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble());
        this.f4423h = new Vec2(byteBuf.readFloat(), byteBuf.readFloat());
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: c */
    public void mo4111c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeDouble(this.f4424c.x);
        byteBuf.writeDouble(this.f4424c.y);
        byteBuf.writeDouble(this.f4424c.z);
        byteBuf.writeFloat(this.f4423h.x);
        byteBuf.writeFloat(this.f4423h.y);
    }

    /* JADX INFO: renamed from: a */
    public static C0805oX m4151a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new C0805oX(friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat());
    }

    /* JADX INFO: renamed from: b */
    public void m4152b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeDouble(this.f4424c.x);
        friendlyByteBuf.writeDouble(this.f4424c.y);
        friendlyByteBuf.writeDouble(this.f4424c.z);
        friendlyByteBuf.writeFloat(this.f4423h.x);
        friendlyByteBuf.writeFloat(this.f4423h.y);
    }
}
