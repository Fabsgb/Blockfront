package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sb.class */
public final class C0488sb extends Record {
    private final String cx;
    private final oX j;

    @NotNull
    public static final Codec<C0488sb> Y = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("zoneID").forGetter((v0) -> {
            return v0.ah();
        }), oX.s.fieldOf("position").forGetter((v0) -> {
            return v0.e();
        })).apply(instance, C0488sb::new);
    });

    public C0488sb(String str, oX oXVar) {
        this.cx = str;
        this.j = oXVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0488sb.class), C0488sb.class, "zoneID;position", "FIELD:Lcom/boehmod/blockfront/sb;->cx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/sb;->j:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0488sb.class), C0488sb.class, "zoneID;position", "FIELD:Lcom/boehmod/blockfront/sb;->cx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/sb;->j:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0488sb.class, Object.class), C0488sb.class, "zoneID;position", "FIELD:Lcom/boehmod/blockfront/sb;->cx:Ljava/lang/String;", "FIELD:Lcom/boehmod/blockfront/sb;->j:Lcom/boehmod/blockfront/oX;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public String ah() {
        return this.cx;
    }

    public oX e() {
        return this.j;
    }

    public C0488sb(@NotNull ByteBuf byteBuf) throws IOException {
        this(IPacket.readString(byteBuf), new oX(byteBuf));
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        IPacket.writeString(byteBuf, this.cx);
        this.j.c(byteBuf);
    }
}
