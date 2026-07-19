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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oX.class */
public class oX {

    @NotNull
    public static final Codec<oX> s = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(oXVar -> {
            return Double.valueOf(oXVar.c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(oXVar2 -> {
            return Double.valueOf(oXVar2.c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(oXVar3 -> {
            return Double.valueOf(oXVar3.c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(oXVar4 -> {
            return Float.valueOf(oXVar4.h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(oXVar5 -> {
            return Float.valueOf(oXVar5.h.y);
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new oX(v1, v2, v3, v4, v5);
        });
    });

    @NotNull
    public Vec2 h;

    @NotNull
    public Vec3 c;

    public oX() {
        this.c = new Vec3(0.0d, 0.0d, 0.0d);
        this.h = new Vec2(0.0f, 0.0f);
    }

    public oX(double d, double d2, double d3, float f, float f2) {
        this.c = new Vec3(d, d2, d3);
        this.h = new Vec2(f, f2);
    }

    public oX(double d, double d2, double d3) {
        this(d, d2, d3, 0.0f, 0.0f);
    }

    public oX(@NotNull BlockPos blockPos, float f, float f2) {
        this(blockPos.getX(), blockPos.getY(), blockPos.getZ(), f, f2);
    }

    public oX(@NotNull Vec3 vec3, float f, float f2) {
        this(vec3.x, vec3.y, vec3.z, f, f2);
    }

    public oX(@NotNull Player player, float f, float f2) {
        this(player.getX(), player.getY(), player.getZ(), f, f2);
    }

    public oX(@NotNull Player player) {
        this(player, player.getYHeadRot(), player.getXRot());
    }

    public oX(@NotNull ByteBuf byteBuf) throws IOException {
        b(byteBuf);
    }

    public void c(@NotNull oX oXVar) {
        this.c = oXVar.c;
        this.h = oXVar.h;
    }

    public float aK() {
        return this.h.x;
    }

    public float aL() {
        return this.h.y;
    }

    @NotNull
    public List<Player> a(@NotNull Level level, int i, @NotNull Set<UUID> set) {
        return a(level, b(i), set);
    }

    @NotNull
    public List<Player> a(@NotNull Level level, @NotNull AABB aabb, @NotNull Set<UUID> set) {
        return level.getEntitiesOfClass(Player.class, aabb, player -> {
            return player.isAlive() && player.tickCount >= 20 && set.contains(player.getUUID());
        });
    }

    @NotNull
    public List<ServerPlayer> a(@NotNull ServerLevel serverLevel, int i, @NotNull Set<UUID> set) {
        return a(serverLevel, b(i), set);
    }

    @NotNull
    public List<ServerPlayer> a(@NotNull ServerLevel serverLevel, @NotNull AABB aabb, @NotNull Set<UUID> set) {
        return serverLevel.getEntitiesOfClass(ServerPlayer.class, aabb, serverPlayer -> {
            return serverPlayer.isAlive() && serverPlayer.tickCount >= 20 && set.contains(serverPlayer.getUUID());
        });
    }

    @NotNull
    public List<AbstractC0376ny> a(@NotNull Level level, int i) {
        return level.getEntitiesOfClass(AbstractC0376ny.class, b(i));
    }

    @NotNull
    public List<mE> a(@NotNull oF<?, ?, ?> oFVar, @NotNull ServerLevel serverLevel, int i) {
        return a(oFVar, serverLevel, b(i));
    }

    @NotNull
    public List<mE> a(@NotNull oF<?, ?, ?> oFVar, @NotNull ServerLevel serverLevel, @NotNull AABB aabb) {
        return serverLevel.getEntitiesOfClass(mE.class, aabb, mEVar -> {
            return mEVar.a() == oFVar;
        });
    }

    public boolean b(@NotNull Entity entity, int i) {
        return a(entity) <= ((float) i);
    }

    public float a(@NotNull Entity entity) {
        return Mth.sqrt((float) entity.distanceToSqr(this.c));
    }

    public double a(@NotNull oX oXVar) {
        return Mth.sqrt((float) oXVar.b(this));
    }

    public double a(@NotNull Vec3 vec3) {
        return Mth.sqrt((float) vec3.distanceToSqr(this.c));
    }

    public double b(@NotNull oX oXVar) {
        double d = oXVar.c.x - this.c.x;
        double d2 = oXVar.c.y - this.c.y;
        double d3 = oXVar.c.z - this.c.z;
        return (d * d) + (d2 * d2) + (d3 * d3);
    }

    public double a(@NotNull BlockPos blockPos) {
        return Mth.sqrt((float) blockPos.distToLowCornerSqr(this.c.x, this.c.y, this.c.z));
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Player m806a(@NotNull Level level, int i) {
        return level.getNearestPlayer(this.c.x, this.c.y, this.c.z, i, false);
    }

    @NotNull
    public oX d() {
        return new oX(new Vec3(this.c.x, this.c.y, this.c.z), this.h.x, this.h.y);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof oX)) {
            return false;
        }
        oX oXVar = (oX) obj;
        return oXVar.c.equals(this.c) && oXVar.h.equals(this.h);
    }

    @NotNull
    public AABB b(int i) {
        return new AABB(this.c, this.c).inflate(i, 0.0d, i).expandTowards(0.0d, 2.0d, 0.0d);
    }

    public final double q() {
        return this.c.x;
    }

    public final double r() {
        return this.c.y;
    }

    public final double s() {
        return this.c.z;
    }

    @NotNull
    public BlockPos c() {
        return BlockPos.containing(this.c);
    }

    @OverridingMethodsMustInvokeSuper
    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        this.c = new Vec3(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble());
        this.h = new Vec2(byteBuf.readFloat(), byteBuf.readFloat());
    }

    @OverridingMethodsMustInvokeSuper
    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeDouble(this.c.x);
        byteBuf.writeDouble(this.c.y);
        byteBuf.writeDouble(this.c.z);
        byteBuf.writeFloat(this.h.x);
        byteBuf.writeFloat(this.h.y);
    }

    public static oX a(@NotNull FriendlyByteBuf friendlyByteBuf) {
        return new oX(friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble(), friendlyByteBuf.readDouble(), friendlyByteBuf.readFloat(), friendlyByteBuf.readFloat());
    }

    public void b(@NotNull FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeDouble(this.c.x);
        friendlyByteBuf.writeDouble(this.c.y);
        friendlyByteBuf.writeDouble(this.c.z);
        friendlyByteBuf.writeFloat(this.h.x);
        friendlyByteBuf.writeFloat(this.h.y);
    }
}
