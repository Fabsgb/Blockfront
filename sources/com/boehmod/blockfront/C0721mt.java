package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.client.Camera;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.mt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mt.class */
public class C0721mt {

    /* JADX INFO: renamed from: q */
    @NotNull
    public static final Codec<C0721mt> f3877q = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("component").forGetter(c0721mt -> {
            return Component.Serializer.toJson(c0721mt.f3878iq, RegistryAccess.EMPTY);
        }), C0836pB.f4470C.fieldOf("position").forGetter(c0721mt2 -> {
            return c0721mt2.f3879J;
        }), Codec.FLOAT.fieldOf("scale").forGetter(c0721mt3 -> {
            return Float.valueOf(c0721mt3.f3880is);
        })).apply(instance, (str, vec3, f) -> {
            return new C0721mt(Component.Serializer.fromJson(str, RegistryAccess.EMPTY), vec3, f.floatValue());
        });
    });

    /* JADX INFO: renamed from: iq */
    private final Component f3878iq;

    /* JADX INFO: renamed from: J */
    private final Vec3 f3879J;

    /* JADX INFO: renamed from: is */
    private final float f3880is;

    public C0721mt(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f3878iq = Component.Serializer.fromJson(friendlyByteBuf.readUtf(32767), RegistryAccess.EMPTY);
        this.f3879J = friendlyByteBuf.readVec3();
        this.f3880is = friendlyByteBuf.readFloat();
    }

    public C0721mt(@NotNull ByteBuf byteBuf) throws IOException {
        this.f3878iq = Component.Serializer.fromJson(IPacket.readString(byteBuf), RegistryAccess.EMPTY);
        this.f3879J = new Vec3(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble());
        this.f3880is = byteBuf.readFloat();
    }

    public C0721mt(@NotNull Component component, @NotNull Vec3 vec3, float f) {
        this.f3878iq = component;
        this.f3879J = vec3;
        this.f3880is = f;
    }

    /* JADX INFO: renamed from: a */
    public void m3260a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUtf(Component.Serializer.toJson(this.f3878iq, RegistryAccess.EMPTY));
        registryFriendlyByteBuf.writeVec3(this.f3879J);
        registryFriendlyByteBuf.writeFloat(this.f3880is);
    }

    /* JADX INFO: renamed from: c */
    public void m3261c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, Component.Serializer.toJson(this.f3878iq, RegistryAccess.EMPTY));
        byteBuf.writeDouble(this.f3879J.x);
        byteBuf.writeDouble(this.f3879J.y);
        byteBuf.writeDouble(this.f3879J.z);
        byteBuf.writeFloat(this.f3880is);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m3262a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera) {
        C0119bk.m520a(poseStack, font, camera, guiGraphics, this.f3878iq, this.f3879J.x, this.f3879J.y, this.f3879J.z, this.f3880is);
    }
}
