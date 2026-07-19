package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pk.class */
public final class C0416pk extends oX {

    @NotNull
    public static final Codec<C0416pk> z = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.DOUBLE.fieldOf("x").forGetter(c0416pk -> {
            return Double.valueOf(c0416pk.c.x);
        }), Codec.DOUBLE.fieldOf("y").forGetter(c0416pk2 -> {
            return Double.valueOf(c0416pk2.c.y);
        }), Codec.DOUBLE.fieldOf("z").forGetter(c0416pk3 -> {
            return Double.valueOf(c0416pk3.c.z);
        }), Codec.FLOAT.fieldOf("pitch").forGetter(c0416pk4 -> {
            return Float.valueOf(c0416pk4.h.x);
        }), Codec.FLOAT.fieldOf("yaw").forGetter(c0416pk5 -> {
            return Float.valueOf(c0416pk5.h.y);
        }), Codec.STRING.fieldOf("texture").forGetter(c0416pk6 -> {
            return c0416pk6.bU;
        })).apply(instance, (d, d2, d3, f, f2, str) -> {
            return new C0416pk(d.doubleValue(), d2.doubleValue(), d3.doubleValue(), f.floatValue(), f2.floatValue(), str);
        });
    });

    @NotNull
    public String bU;

    @NotNull
    private ResourceLocation dU;

    public C0416pk() {
    }

    public C0416pk(double d, double d2, double d3, float f, float f2, @NotNull String str) {
        super(d, d2, d3, f, f2);
        this.bU = str;
        this.dU = C0265jv.d("textures/misc/waypoints/" + str + ".png");
    }

    @Override // com.boehmod.blockfront.oX
    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        super.b(byteBuf);
        this.bU = IPacket.readString(byteBuf);
        this.dU = C0265jv.d("textures/misc/waypoints/" + this.bU + ".png");
    }

    @Override // com.boehmod.blockfront.oX
    @OverridingMethodsMustInvokeSuper
    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        super.c(byteBuf);
        IPacket.writeString(byteBuf, this.bU);
    }

    @Override // com.boehmod.blockfront.oX
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0416pk d() {
        return new C0416pk(this.c.x, this.c.y, this.c.z, this.h.x, this.h.y, this.bU);
    }

    @NotNull
    public ResourceLocation z() {
        return this.dU;
    }
}
