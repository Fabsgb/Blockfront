package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pk.class */
public final class C0871pk extends C0805oX {

    /* JADX INFO: renamed from: z */
    @NotNull
    public static final Codec<C0871pk> f4574z = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0871pk -> {
            return Double.valueOf(c0871pk.f4424c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0871pk2 -> {
            return Double.valueOf(c0871pk2.f4424c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0871pk3 -> {
            return Double.valueOf(c0871pk3.f4424c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0871pk4 -> {
            return Float.valueOf(c0871pk4.f4423h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0871pk5 -> {
            return Float.valueOf(c0871pk5.f4423h.y);
        }), Codec.STRING.fieldOf("texture").forGetter(c0871pk6 -> {
            return c0871pk6.f4575bU;
        })).apply(instance, (d, d2, d3, f, f2, str) -> {
            return new C0871pk(d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue(), str);
        });
    });

    /* JADX INFO: renamed from: bU */
    @NotNull
    public String f4575bU;

    /* JADX INFO: renamed from: dU */
    @NotNull
    private ResourceLocation f4576dU;

    public C0871pk() {
    }

    public C0871pk(double d, double d2, double d3, float f, float f2, @NotNull String str) {
        super(d, d2, d3, f, f2);
        this.f4575bU = str;
        this.f4576dU = C0564jv.m2555d("textures/misc/waypoints/" + str + ".png");
    }

    @Override // com.boehmod.blockfront.C0805oX
    /* JADX INFO: renamed from: b */
    public void mo4110b(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo4110b(byteBuf);
        this.f4575bU = IPacket.readString(byteBuf);
        this.f4576dU = C0564jv.m2555d("textures/misc/waypoints/" + this.f4575bU + ".png");
    }

    @Override // com.boehmod.blockfront.C0805oX
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: c */
    public void mo4111c(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo4111c(byteBuf);
        IPacket.writeString(byteBuf, this.f4575bU);
    }

    @Override // com.boehmod.blockfront.C0805oX
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0871pk mo4124d() {
        return new C0871pk(this.f4424c.x, this.f4424c.y, this.f4424c.z, this.f4423h.x, this.f4423h.y, this.f4575bU);
    }

    @NotNull
    /* JADX INFO: renamed from: z */
    public ResourceLocation m4384z() {
        return this.f4576dU;
    }
}
