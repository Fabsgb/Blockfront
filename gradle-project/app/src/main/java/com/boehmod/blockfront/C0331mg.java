package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Camera;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.mg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mg.class */
public class C0331mg {

    @NotNull
    public static final Codec<C0331mg> o = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("fadeFromDuration").forGetter(c0331mg -> {
            return Float.valueOf(c0331mg.hC);
        }), Codec.FLOAT.fieldOf("fadeToDuration").forGetter(c0331mg2 -> {
            return Float.valueOf(c0331mg2.hD);
        }), Codec.FLOAT.fieldOf("startRoll").forGetter(c0331mg3 -> {
            return Float.valueOf(c0331mg3.hE);
        }), Codec.FLOAT.fieldOf("endRoll").forGetter(c0331mg4 -> {
            return Float.valueOf(c0331mg4.hF);
        }), oX.s.fieldOf("start").forGetter(c0331mg5 -> {
            return c0331mg5.f244a;
        }), oX.s.fieldOf("end").forGetter(c0331mg6 -> {
            return c0331mg6.f245b;
        }), Codec.INT.fieldOf("fov").forGetter(c0331mg7 -> {
            return Integer.valueOf(c0331mg7.kq);
        }), Codec.INT.fieldOf("startRelativeMode").forGetter(c0331mg8 -> {
            return Integer.valueOf(c0331mg8.a.ordinal());
        }), Codec.INT.fieldOf("endRelativeMode").forGetter(c0331mg9 -> {
            return Integer.valueOf(c0331mg9.b.ordinal());
        }), Codec.FLOAT.fieldOf("durationSeconds").forGetter(c0331mg10 -> {
            return Float.valueOf(c0331mg10.hH);
        }), Codec.INT.fieldOf("interpolationType").forGetter(c0331mg11 -> {
            return Integer.valueOf(c0331mg11.f246a.ordinal());
        }), Codec.STRING.listOf().fieldOf("instructions").forGetter(c0331mg12 -> {
            return c0331mg12.ac;
        }), C0344mt.q.listOf().fieldOf("textElements").forGetter(c0331mg13 -> {
            return c0331mg13.ad;
        })).apply(instance, (f, f2, f3, f4, oXVar, oXVar2, num, num2, num3, f5, num4, list, list2) -> {
            C0331mg c0331mg14 = new C0331mg();
            c0331mg14.hC = f.floatValue();
            c0331mg14.hD = f2.floatValue();
            c0331mg14.hE = f3.floatValue();
            c0331mg14.hF = f4.floatValue();
            c0331mg14.f244a = oXVar;
            c0331mg14.f245b = oXVar2;
            c0331mg14.kq = num.intValue();
            c0331mg14.a = EnumC0336ml.values()[num2.intValue()];
            c0331mg14.b = EnumC0336ml.values()[num3.intValue()];
            c0331mg14.hH = f5.floatValue();
            c0331mg14.f246a = EnumC0334mj.values()[num4.intValue()];
            c0331mg14.ac.addAll(list);
            c0331mg14.ad.addAll(list2);
            return c0331mg14;
        });
    });
    protected float hC;
    protected float hD;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected oX f244a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    protected oX f245b;
    private oX c;
    private oX d;
    protected float hE;
    protected float hF;
    private float hG;
    protected float hH;

    @NotNull
    protected final List<String> ac = new ObjectArrayList();

    @NotNull
    protected final List<C0344mt> ad = new ObjectArrayList();

    @NotNull
    protected EnumC0336ml a = EnumC0336ml.NONE;

    @NotNull
    protected EnumC0336ml b = EnumC0336ml.NONE;
    protected int kq = 70;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    protected EnumC0334mj f246a = EnumC0334mj.LINEAR;

    @NotNull
    public C0331mg a(int i) {
        this.kq = i;
        return this;
    }

    @NotNull
    public C0331mg a(float f) {
        this.hE = f;
        return this;
    }

    @NotNull
    public C0331mg b(float f) {
        this.hF = f;
        return this;
    }

    public float ah() {
        return this.hE;
    }

    public float ai() {
        return this.hF;
    }

    @NotNull
    public C0331mg a(@NotNull oX oXVar) {
        this.f244a = oXVar;
        return this;
    }

    @NotNull
    public C0331mg b(@NotNull oX oXVar) {
        this.f245b = oXVar;
        return this;
    }

    @NotNull
    public C0331mg c(float f) {
        this.hH = f;
        return this;
    }

    @NotNull
    public C0331mg a(@NotNull EnumC0334mj enumC0334mj) {
        this.f246a = enumC0334mj;
        return this;
    }

    @NotNull
    public C0331mg d(float f) {
        this.hC = f;
        return this;
    }

    @NotNull
    public C0331mg e(float f) {
        this.hD = f;
        return this;
    }

    @NotNull
    public C0331mg a(@NotNull EnumC0336ml enumC0336ml) {
        this.a = enumC0336ml;
        return this;
    }

    @NotNull
    public C0331mg b(@NotNull EnumC0336ml enumC0336ml) {
        this.b = enumC0336ml;
        return this;
    }

    @NotNull
    public C0331mg a(@NotNull String str) {
        this.ac.add(str);
        return this;
    }

    @NotNull
    public C0331mg a(@NotNull C0344mt c0344mt) {
        this.ad.add(c0344mt);
        return this;
    }

    public int aq() {
        return this.kq;
    }

    public float aj() {
        return this.hC;
    }

    public float ak() {
        return this.hD;
    }

    public List<String> r() {
        return Collections.unmodifiableList(this.ac);
    }

    public void j(@Nullable LocalPlayer localPlayer) {
        this.c = a(this.f244a, this.a, localPlayer);
        this.d = a(this.f245b, this.b, localPlayer);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public oX m683a(float f) {
        float fApply = this.f246a.apply(f);
        double dLerp = Mth.lerp(fApply, this.c.c.x, this.d.c.x);
        double dLerp2 = Mth.lerp(fApply, this.c.c.y, this.d.c.y);
        double dLerp3 = Mth.lerp(fApply, this.c.c.z, this.d.c.z);
        float fA = a(fApply, this.c.h.y, this.d.h.y);
        float fA2 = a(fApply, this.c.h.x, this.d.h.x);
        float fA3 = a(fApply, this.hE, this.hF);
        oX oXVar = new oX(dLerp, dLerp2, dLerp3, fA2, fA);
        this.hG = fA3;
        return oXVar;
    }

    private oX a(oX oXVar, EnumC0336ml enumC0336ml, @Nullable LocalPlayer localPlayer) {
        if (localPlayer == null || enumC0336ml == EnumC0336ml.NONE) {
            return oXVar;
        }
        double x = oXVar.c.x;
        double y = oXVar.c.y;
        double z = oXVar.c.z;
        float xRot = oXVar.h.x;
        float yRot = oXVar.h.y;
        if (enumC0336ml == EnumC0336ml.POSITION || enumC0336ml == EnumC0336ml.POSITION_ROTATION) {
            x += localPlayer.getX();
            y += localPlayer.getY();
            z += localPlayer.getZ();
        }
        if (enumC0336ml == EnumC0336ml.POSITION_ROTATION) {
            xRot += localPlayer.getXRot();
            yRot += localPlayer.getYRot();
        }
        return new oX(x, y, z, xRot, yRot);
    }

    private float a(float f, float f2, float f3) {
        return C0634xm.f(f3, f2, f);
    }

    public oX a() {
        return this.f244a;
    }

    public oX b() {
        return this.f245b;
    }

    public float al() {
        return this.hH;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public EnumC0334mj m684a() {
        return this.f246a;
    }

    public void b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        this.hC = registryFriendlyByteBuf.readFloat();
        this.hD = registryFriendlyByteBuf.readFloat();
        this.hE = registryFriendlyByteBuf.readFloat();
        this.hF = registryFriendlyByteBuf.readFloat();
        this.a = EnumC0336ml.values()[registryFriendlyByteBuf.readInt()];
        this.b = EnumC0336ml.values()[registryFriendlyByteBuf.readInt()];
        this.f244a = oX.a((FriendlyByteBuf) registryFriendlyByteBuf);
        this.f245b = oX.a((FriendlyByteBuf) registryFriendlyByteBuf);
        this.kq = registryFriendlyByteBuf.readInt();
        this.hH = registryFriendlyByteBuf.readFloat();
        this.f246a = EnumC0334mj.values()[registryFriendlyByteBuf.readInt()];
        this.ac.clear();
        int i = registryFriendlyByteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.ac.add(registryFriendlyByteBuf.readUtf());
        }
        this.ad.clear();
        int i3 = registryFriendlyByteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.ad.add(new C0344mt((FriendlyByteBuf) registryFriendlyByteBuf));
        }
    }

    public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        registryFriendlyByteBuf.writeFloat(this.hC);
        registryFriendlyByteBuf.writeFloat(this.hD);
        registryFriendlyByteBuf.writeFloat(this.hE);
        registryFriendlyByteBuf.writeFloat(this.hF);
        registryFriendlyByteBuf.writeInt(this.a.ordinal());
        registryFriendlyByteBuf.writeInt(this.b.ordinal());
        this.f244a.b((FriendlyByteBuf) registryFriendlyByteBuf);
        this.f245b.b((FriendlyByteBuf) registryFriendlyByteBuf);
        registryFriendlyByteBuf.writeInt(this.kq);
        registryFriendlyByteBuf.writeFloat(this.hH);
        registryFriendlyByteBuf.writeInt(this.f246a.ordinal());
        int size = this.ac.size();
        registryFriendlyByteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            registryFriendlyByteBuf.writeUtf(this.ac.get(i));
        }
        int size2 = this.ad.size();
        registryFriendlyByteBuf.writeInt(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.ad.get(i2).a(registryFriendlyByteBuf);
        }
    }

    public void a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera) {
        Iterator<C0344mt> it = this.ad.iterator();
        while (it.hasNext()) {
            it.next().a(poseStack, font, guiGraphics, camera);
        }
    }

    public float am() {
        return this.hG;
    }

    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        this.hC = byteBuf.readFloat();
        this.hD = byteBuf.readFloat();
        this.hE = byteBuf.readFloat();
        this.hF = byteBuf.readFloat();
        this.a = EnumC0336ml.values()[byteBuf.readInt()];
        this.b = EnumC0336ml.values()[byteBuf.readInt()];
        this.f244a = new oX();
        this.f244a.b(byteBuf);
        this.f245b = new oX();
        this.f245b.b(byteBuf);
        this.kq = byteBuf.readInt();
        this.hH = byteBuf.readFloat();
        this.f246a = EnumC0334mj.values()[byteBuf.readInt()];
        this.ac.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.ac.add(IPacket.readString(byteBuf));
        }
        this.ad.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.ad.add(new C0344mt(byteBuf));
        }
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeFloat(this.hC);
        byteBuf.writeFloat(this.hD);
        byteBuf.writeFloat(this.hE);
        byteBuf.writeFloat(this.hF);
        byteBuf.writeInt(this.a.ordinal());
        byteBuf.writeInt(this.b.ordinal());
        this.f244a.c(byteBuf);
        this.f245b.c(byteBuf);
        byteBuf.writeInt(this.kq);
        byteBuf.writeFloat(this.hH);
        byteBuf.writeInt(this.f246a.ordinal());
        int size = this.ac.size();
        byteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            IPacket.writeString(byteBuf, this.ac.get(i));
        }
        int size2 = this.ad.size();
        byteBuf.writeInt(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.ad.get(i2).c(byteBuf);
        }
    }
}
