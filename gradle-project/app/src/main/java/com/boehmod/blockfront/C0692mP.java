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

/* JADX INFO: renamed from: com.boehmod.blockfront.mP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mP.class */
public class C0692mP {

    /* JADX INFO: renamed from: q */
    @NotNull
    public static final Codec<C0692mP> f3829q = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("component").forGetter(c0692mP -> {
            return Component.Serializer.toJson(c0692mP.f3830iC, RegistryAccess.EMPTY);
        }), C0859pX.f4599C.fieldOf("position").forGetter(c0692mP2 -> {
            return c0692mP2.f3831K;
        }), Codec.FLOAT.fieldOf("scale").forGetter(c0692mP3 -> {
            return Float.valueOf(c0692mP3.f3832jk);
        })).apply(instance, (str, vec3, f) -> {
            return new C0692mP(Component.Serializer.fromJson(str, RegistryAccess.EMPTY), vec3, f.floatValue());
        });
    });

    /* JADX INFO: renamed from: iC */
    private final Component f3830iC;

    /* JADX INFO: renamed from: K */
    private final Vec3 f3831K;

    /* JADX INFO: renamed from: jk */
    private final float f3832jk;

    public C0692mP(@NotNull FriendlyByteBuf friendlyByteBuf) {
        this.f3830iC = Component.Serializer.fromJson(friendlyByteBuf.readUtf(32767), RegistryAccess.EMPTY);
        this.f3831K = friendlyByteBuf.readVec3();
        this.f3832jk = friendlyByteBuf.readFloat();
    }

    public C0692mP(@NotNull ByteBuf byteBuf) throws IOException {
        this.f3830iC = Component.Serializer.fromJson(IPacket.readString(byteBuf), RegistryAccess.EMPTY);
        this.f3831K = new Vec3(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble());
        this.f3832jk = byteBuf.readFloat();
    }

    public C0692mP(@NotNull Component component, @NotNull Vec3 vec3, float f) {
        this.f3830iC = component;
        this.f3831K = vec3;
        this.f3832jk = f;
    }

    /* JADX INFO: renamed from: a */
    public void m3094a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUtf(Component.Serializer.toJson(this.f3830iC, RegistryAccess.EMPTY));
        registryFriendlyByteBuf.writeVec3(this.f3831K);
        registryFriendlyByteBuf.writeFloat(this.f3832jk);
    }

    /* JADX INFO: renamed from: c */
    public void m3095c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, Component.Serializer.toJson(this.f3830iC, RegistryAccess.EMPTY));
        byteBuf.writeDouble(this.f3831K.x);
        byteBuf.writeDouble(this.f3831K.y);
        byteBuf.writeDouble(this.f3831K.z);
        byteBuf.writeFloat(this.f3832jk);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m3096a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera) {
        C0129bt.m621a(poseStack, font, camera, guiGraphics, this.f3830iC, this.f3831K.x, this.f3831K.y, this.f3831K.z, this.f3832jk);
    }
}
