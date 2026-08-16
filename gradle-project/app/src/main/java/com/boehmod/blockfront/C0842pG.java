package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pG.class */
public final class C0842pG extends C0881pt {

    /* JADX INFO: renamed from: z */
    @NotNull
    public static final Codec<C0842pG> f4543z = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0842pG -> {
            return Double.valueOf(c0842pG.f4827c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0842pG2 -> {
            return Double.valueOf(c0842pG2.f4827c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0842pG3 -> {
            return Double.valueOf(c0842pG3.f4827c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0842pG4 -> {
            return Float.valueOf(c0842pG4.f4826h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0842pG5 -> {
            return Float.valueOf(c0842pG5.f4826h.y);
        }), Codec.STRING.fieldOf("texture").forGetter(c0842pG6 -> {
            return c0842pG6.f4544ce;
        })).apply(instance, (d, d2, d3, f, f2, str) -> {
            return new C0842pG(d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue(), str);
        });
    });

    /* JADX INFO: renamed from: ce */
    @NotNull
    public String f4544ce;

    /* JADX INFO: renamed from: dS */
    @NotNull
    private ResourceLocation f4545dS;

    public C0842pG() {
    }

    public C0842pG(double d, double d2, double d3, float f, float f2, @NotNull String str) {
        super(d, d2, d3, f, f2);
        this.f4544ce = str;
        this.f4545dS = C0532jO.m2378d("textures/misc/waypoints/" + str + ".png");
    }

    @Override // com.boehmod.blockfront.C0881pt
    /* JADX INFO: renamed from: b */
    public void mo3869b(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo3869b(byteBuf);
        this.f4544ce = IPacket.readString(byteBuf);
        this.f4545dS = C0532jO.m2378d("textures/misc/waypoints/" + this.f4544ce + ".png");
    }

    @Override // com.boehmod.blockfront.C0881pt
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: c */
    public void mo3870c(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo3870c(byteBuf);
        IPacket.writeString(byteBuf, this.f4544ce);
    }

    @Override // com.boehmod.blockfront.C0881pt
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0842pG mo3849d() {
        return new C0842pG(this.f4827c.x, this.f4827c.y, this.f4827c.z, this.f4826h.x, this.f4826h.y, this.f4544ce);
    }

    @NotNull
    /* JADX INFO: renamed from: A */
    public ResourceLocation m3872A() {
        return this.f4545dS;
    }
}
