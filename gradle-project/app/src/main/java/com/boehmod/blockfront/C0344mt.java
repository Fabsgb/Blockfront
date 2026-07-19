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

/* JADX INFO: renamed from: com.boehmod.blockfront.mt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mt.class */
public class C0344mt {

    @NotNull
    public static final Codec<C0344mt> q = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("component").forGetter(c0344mt -> {
            return Component.Serializer.toJson(c0344mt.iq, RegistryAccess.EMPTY);
        }), pB.C.fieldOf("position").forGetter(c0344mt2 -> {
            return c0344mt2.J;
        }), Codec.FLOAT.fieldOf("scale").forGetter(c0344mt3 -> {
            return Float.valueOf(c0344mt3.is);
        })).apply(instance, (str, vec3, f) -> {
            return new C0344mt(Component.Serializer.fromJson(str, RegistryAccess.EMPTY), vec3, f.floatValue());
        });
    });
    private final Component iq;
    private final Vec3 J;
    private final float is;

    public C0344mt(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.iq = Component.Serializer.fromJson(friendlyByteBuf.readUtf(32767), RegistryAccess.EMPTY);
        this.J = friendlyByteBuf.readVec3();
        this.is = friendlyByteBuf.readFloat();
    }

    public C0344mt(@NotNull ByteBuf byteBuf) throws IOException {
        this.iq = Component.Serializer.fromJson(IPacket.readString(byteBuf), RegistryAccess.EMPTY);
        this.J = new Vec3(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble());
        this.is = byteBuf.readFloat();
    }

    public C0344mt(@NotNull Component component, @NotNull Vec3 vec3, float f) {
        this.iq = component;
        this.J = vec3;
        this.is = f;
    }

    public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUtf(Component.Serializer.toJson(this.iq, RegistryAccess.EMPTY));
        registryFriendlyByteBuf.writeVec3(this.J);
        registryFriendlyByteBuf.writeFloat(this.is);
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, Component.Serializer.toJson(this.iq, RegistryAccess.EMPTY));
        byteBuf.writeDouble(this.J.x);
        byteBuf.writeDouble(this.J.y);
        byteBuf.writeDouble(this.J.z);
        byteBuf.writeFloat(this.is);
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera) {
        C0040bk.a(poseStack, font, camera, guiGraphics, this.iq, this.J.x, this.J.y, this.J.z, this.is);
    }
}
