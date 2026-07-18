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

/* JADX INFO: renamed from: com.boehmod.blockfront.mg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/mg.class */
public class C0708mg {

    /* JADX INFO: renamed from: o */
    @NotNull
    public static final Codec<C0708mg> f3763o = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("fadeFromDuration").forGetter(c0708mg -> {
            return Float.valueOf(c0708mg.f3764hC);
        }), Codec.FLOAT.fieldOf("fadeToDuration").forGetter(c0708mg2 -> {
            return Float.valueOf(c0708mg2.f3765hD);
        }), Codec.FLOAT.fieldOf("startRoll").forGetter(c0708mg3 -> {
            return Float.valueOf(c0708mg3.f3774hE);
        }), Codec.FLOAT.fieldOf("endRoll").forGetter(c0708mg4 -> {
            return Float.valueOf(c0708mg4.f3775hF);
        }), C0805oX.f4422s.fieldOf("start").forGetter(c0708mg5 -> {
            return c0708mg5.f3770a;
        }), C0805oX.f4422s.fieldOf("end").forGetter(c0708mg6 -> {
            return c0708mg6.f3771b;
        }), Codec.INT.fieldOf("fov").forGetter(c0708mg7 -> {
            return Integer.valueOf(c0708mg7.f3777kq);
        }), Codec.INT.fieldOf("startRelativeMode").forGetter(c0708mg8 -> {
            return Integer.valueOf(c0708mg8.f3768a.ordinal());
        }), Codec.INT.fieldOf("endRelativeMode").forGetter(c0708mg9 -> {
            return Integer.valueOf(c0708mg9.f3769b.ordinal());
        }), Codec.FLOAT.fieldOf("durationSeconds").forGetter(c0708mg10 -> {
            return Float.valueOf(c0708mg10.f3778hH);
        }), Codec.INT.fieldOf("interpolationType").forGetter(c0708mg11 -> {
            return Integer.valueOf(c0708mg11.f3779a.ordinal());
        }), Codec.STRING.listOf().fieldOf("instructions").forGetter(c0708mg12 -> {
            return c0708mg12.f3766ac;
        }), C0721mt.f3877q.listOf().fieldOf("textElements").forGetter(c0708mg13 -> {
            return c0708mg13.f3767ad;
        })).apply(instance, (f, f2, f3, f4, c0805oX, c0805oX2, num, num2, num3, f5, num4, list, list2) -> {
            C0708mg c0708mg14 = new C0708mg();
            c0708mg14.f3764hC = f.floatValue();
            c0708mg14.f3765hD = f2.floatValue();
            c0708mg14.f3774hE = f3.floatValue();
            c0708mg14.f3775hF = f4.floatValue();
            c0708mg14.f3770a = c0805oX;
            c0708mg14.f3771b = c0805oX2;
            c0708mg14.f3777kq = num.intValue();
            c0708mg14.f3768a = EnumC0713ml.values()[num2.intValue()];
            c0708mg14.f3769b = EnumC0713ml.values()[num3.intValue()];
            c0708mg14.f3778hH = f5.floatValue();
            c0708mg14.f3779a = EnumC0711mj.values()[num4.intValue()];
            c0708mg14.f3766ac.addAll(list);
            c0708mg14.f3767ad.addAll(list2);
            return c0708mg14;
        });
    });

    /* JADX INFO: renamed from: hC */
    protected float f3764hC;

    /* JADX INFO: renamed from: hD */
    protected float f3765hD;

    /* JADX INFO: renamed from: a */
    protected C0805oX f3770a;

    /* JADX INFO: renamed from: b */
    protected C0805oX f3771b;

    /* JADX INFO: renamed from: c */
    private C0805oX f3772c;

    /* JADX INFO: renamed from: d */
    private C0805oX f3773d;

    /* JADX INFO: renamed from: hE */
    protected float f3774hE;

    /* JADX INFO: renamed from: hF */
    protected float f3775hF;

    /* JADX INFO: renamed from: hG */
    private float f3776hG;

    /* JADX INFO: renamed from: hH */
    protected float f3778hH;

    /* JADX INFO: renamed from: ac */
    @NotNull
    protected final List<String> f3766ac = new ObjectArrayList();

    /* JADX INFO: renamed from: ad */
    @NotNull
    protected final List<C0721mt> f3767ad = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    protected EnumC0713ml f3768a = EnumC0713ml.NONE;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected EnumC0713ml f3769b = EnumC0713ml.NONE;

    /* JADX INFO: renamed from: kq */
    protected int f3777kq = 70;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected EnumC0711mj f3779a = EnumC0711mj.LINEAR;

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0708mg m3151a(int i) {
        this.f3777kq = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0708mg m3152a(float f) {
        this.f3774hE = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0708mg m3153b(float f) {
        this.f3775hF = f;
        return this;
    }

    /* JADX INFO: renamed from: ah */
    public float m3154ah() {
        return this.f3774hE;
    }

    /* JADX INFO: renamed from: ai */
    public float m3155ai() {
        return this.f3775hF;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0708mg m3156a(@NotNull C0805oX c0805oX) {
        this.f3770a = c0805oX;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0708mg m3157b(@NotNull C0805oX c0805oX) {
        this.f3771b = c0805oX;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C0708mg m3158c(float f) {
        this.f3778hH = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0708mg m3159a(@NotNull EnumC0711mj enumC0711mj) {
        this.f3779a = enumC0711mj;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C0708mg m3160d(float f) {
        this.f3764hC = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C0708mg m3161e(float f) {
        this.f3765hD = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0708mg m3162a(@NotNull EnumC0713ml enumC0713ml) {
        this.f3768a = enumC0713ml;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0708mg m3163b(@NotNull EnumC0713ml enumC0713ml) {
        this.f3769b = enumC0713ml;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0708mg m3164a(@NotNull String str) {
        this.f3766ac.add(str);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0708mg m3165a(@NotNull C0721mt c0721mt) {
        this.f3767ad.add(c0721mt);
        return this;
    }

    /* JADX INFO: renamed from: aq */
    public int m3166aq() {
        return this.f3777kq;
    }

    /* JADX INFO: renamed from: aj */
    public float m3167aj() {
        return this.f3764hC;
    }

    /* JADX INFO: renamed from: ak */
    public float m3168ak() {
        return this.f3765hD;
    }

    /* JADX INFO: renamed from: r */
    public List<String> m3169r() {
        return Collections.unmodifiableList(this.f3766ac);
    }

    /* JADX INFO: renamed from: j */
    public void m3170j(@Nullable LocalPlayer localPlayer) {
        this.f3772c = m3172a(this.f3770a, this.f3768a, localPlayer);
        this.f3773d = m3172a(this.f3771b, this.f3769b, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    public C0805oX m3171a(float f) {
        float fApply = this.f3779a.apply(f);
        double dLerp = Mth.lerp(fApply, this.f3772c.f4424c.x, this.f3773d.f4424c.x);
        double dLerp2 = Mth.lerp(fApply, this.f3772c.f4424c.y, this.f3773d.f4424c.y);
        double dLerp3 = Mth.lerp(fApply, this.f3772c.f4424c.z, this.f3773d.f4424c.z);
        float fM3173a = m3173a(fApply, this.f3772c.f4423h.y, this.f3773d.f4423h.y);
        float fM3173a2 = m3173a(fApply, this.f3772c.f4423h.x, this.f3773d.f4423h.x);
        float fM3173a3 = m3173a(fApply, this.f3774hE, this.f3775hF);
        C0805oX c0805oX = new C0805oX(dLerp, dLerp2, dLerp3, fM3173a2, fM3173a);
        this.f3776hG = fM3173a3;
        return c0805oX;
    }

    /* JADX INFO: renamed from: a */
    private C0805oX m3172a(C0805oX c0805oX, EnumC0713ml enumC0713ml, @Nullable LocalPlayer localPlayer) {
        if (localPlayer == null || enumC0713ml == EnumC0713ml.NONE) {
            return c0805oX;
        }
        double x = c0805oX.f4424c.x;
        double y = c0805oX.f4424c.y;
        double z = c0805oX.f4424c.z;
        float xRot = c0805oX.f4423h.x;
        float yRot = c0805oX.f4423h.y;
        if (enumC0713ml == EnumC0713ml.POSITION || enumC0713ml == EnumC0713ml.POSITION_ROTATION) {
            x += localPlayer.getX();
            y += localPlayer.getY();
            z += localPlayer.getZ();
        }
        if (enumC0713ml == EnumC0713ml.POSITION_ROTATION) {
            xRot += localPlayer.getXRot();
            yRot += localPlayer.getYRot();
        }
        return new C0805oX(x, y, z, xRot, yRot);
    }

    /* JADX INFO: renamed from: a */
    private float m3173a(float f, float f2, float f3) {
        return C1290xm.m7844f(f3, f2, f);
    }

    /* JADX INFO: renamed from: a */
    public C0805oX m3174a() {
        return this.f3770a;
    }

    /* JADX INFO: renamed from: b */
    public C0805oX m3175b() {
        return this.f3771b;
    }

    /* JADX INFO: renamed from: al */
    public float m3176al() {
        return this.f3778hH;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0711mj m3177a() {
        return this.f3779a;
    }

    /* JADX INFO: renamed from: b */
    public void m3178b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        this.f3764hC = registryFriendlyByteBuf.readFloat();
        this.f3765hD = registryFriendlyByteBuf.readFloat();
        this.f3774hE = registryFriendlyByteBuf.readFloat();
        this.f3775hF = registryFriendlyByteBuf.readFloat();
        this.f3768a = EnumC0713ml.values()[registryFriendlyByteBuf.readInt()];
        this.f3769b = EnumC0713ml.values()[registryFriendlyByteBuf.readInt()];
        this.f3770a = C0805oX.m4151a((FriendlyByteBuf) registryFriendlyByteBuf);
        this.f3771b = C0805oX.m4151a((FriendlyByteBuf) registryFriendlyByteBuf);
        this.f3777kq = registryFriendlyByteBuf.readInt();
        this.f3778hH = registryFriendlyByteBuf.readFloat();
        this.f3779a = EnumC0711mj.values()[registryFriendlyByteBuf.readInt()];
        this.f3766ac.clear();
        int i = registryFriendlyByteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f3766ac.add(registryFriendlyByteBuf.readUtf());
        }
        this.f3767ad.clear();
        int i3 = registryFriendlyByteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f3767ad.add(new C0721mt((FriendlyByteBuf) registryFriendlyByteBuf));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3179a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        registryFriendlyByteBuf.writeFloat(this.f3764hC);
        registryFriendlyByteBuf.writeFloat(this.f3765hD);
        registryFriendlyByteBuf.writeFloat(this.f3774hE);
        registryFriendlyByteBuf.writeFloat(this.f3775hF);
        registryFriendlyByteBuf.writeInt(this.f3768a.ordinal());
        registryFriendlyByteBuf.writeInt(this.f3769b.ordinal());
        this.f3770a.m4152b((FriendlyByteBuf) registryFriendlyByteBuf);
        this.f3771b.m4152b((FriendlyByteBuf) registryFriendlyByteBuf);
        registryFriendlyByteBuf.writeInt(this.f3777kq);
        registryFriendlyByteBuf.writeFloat(this.f3778hH);
        registryFriendlyByteBuf.writeInt(this.f3779a.ordinal());
        int size = this.f3766ac.size();
        registryFriendlyByteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            registryFriendlyByteBuf.writeUtf(this.f3766ac.get(i));
        }
        int size2 = this.f3767ad.size();
        registryFriendlyByteBuf.writeInt(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.f3767ad.get(i2).m3260a(registryFriendlyByteBuf);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3180a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera) {
        Iterator<C0721mt> it = this.f3767ad.iterator();
        while (it.hasNext()) {
            it.next().m3262a(poseStack, font, guiGraphics, camera);
        }
    }

    /* JADX INFO: renamed from: am */
    public float m3181am() {
        return this.f3776hG;
    }

    /* JADX INFO: renamed from: b */
    public void m3182b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f3764hC = byteBuf.readFloat();
        this.f3765hD = byteBuf.readFloat();
        this.f3774hE = byteBuf.readFloat();
        this.f3775hF = byteBuf.readFloat();
        this.f3768a = EnumC0713ml.values()[byteBuf.readInt()];
        this.f3769b = EnumC0713ml.values()[byteBuf.readInt()];
        this.f3770a = new C0805oX();
        this.f3770a.mo4110b(byteBuf);
        this.f3771b = new C0805oX();
        this.f3771b.mo4110b(byteBuf);
        this.f3777kq = byteBuf.readInt();
        this.f3778hH = byteBuf.readFloat();
        this.f3779a = EnumC0711mj.values()[byteBuf.readInt()];
        this.f3766ac.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f3766ac.add(IPacket.readString(byteBuf));
        }
        this.f3767ad.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f3767ad.add(new C0721mt(byteBuf));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3183c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeFloat(this.f3764hC);
        byteBuf.writeFloat(this.f3765hD);
        byteBuf.writeFloat(this.f3774hE);
        byteBuf.writeFloat(this.f3775hF);
        byteBuf.writeInt(this.f3768a.ordinal());
        byteBuf.writeInt(this.f3769b.ordinal());
        this.f3770a.mo4111c(byteBuf);
        this.f3771b.mo4111c(byteBuf);
        byteBuf.writeInt(this.f3777kq);
        byteBuf.writeFloat(this.f3778hH);
        byteBuf.writeInt(this.f3779a.ordinal());
        int size = this.f3766ac.size();
        byteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            IPacket.writeString(byteBuf, this.f3766ac.get(i));
        }
        int size2 = this.f3767ad.size();
        byteBuf.writeInt(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.f3767ad.get(i2).m3261c(byteBuf);
        }
    }
}
