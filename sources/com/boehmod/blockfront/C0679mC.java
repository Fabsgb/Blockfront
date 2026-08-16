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

/* JADX INFO: renamed from: com.boehmod.blockfront.mC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mC.class */
public class C0679mC {

    /* JADX INFO: renamed from: o */
    @NotNull
    public static final Codec<C0679mC> f3718o = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.FLOAT.fieldOf("fadeFromDuration").forGetter(c0679mC -> {
            return Float.valueOf(c0679mC.f3719iu);
        }), Codec.FLOAT.fieldOf("fadeToDuration").forGetter(c0679mC2 -> {
            return Float.valueOf(c0679mC2.f3720iv);
        }), Codec.FLOAT.fieldOf("startRoll").forGetter(c0679mC3 -> {
            return Float.valueOf(c0679mC3.f3729iw);
        }), Codec.FLOAT.fieldOf("endRoll").forGetter(c0679mC4 -> {
            return Float.valueOf(c0679mC4.f3730ix);
        }), C0881pt.f4825s.fieldOf("start").forGetter(c0679mC5 -> {
            return c0679mC5.f3725a;
        }), C0881pt.f4825s.fieldOf("end").forGetter(c0679mC6 -> {
            return c0679mC6.f3726b;
        }), Codec.INT.fieldOf("fov").forGetter(c0679mC7 -> {
            return Integer.valueOf(c0679mC7.f3732mn);
        }), Codec.INT.fieldOf("startRelativeMode").forGetter(c0679mC8 -> {
            return Integer.valueOf(c0679mC8.f3723a.ordinal());
        }), Codec.INT.fieldOf("endRelativeMode").forGetter(c0679mC9 -> {
            return Integer.valueOf(c0679mC9.f3724b.ordinal());
        }), Codec.FLOAT.fieldOf("durationSeconds").forGetter(c0679mC10 -> {
            return Float.valueOf(c0679mC10.f3733iz);
        }), Codec.INT.fieldOf("interpolationType").forGetter(c0679mC11 -> {
            return Integer.valueOf(c0679mC11.f3734a.ordinal());
        }), Codec.STRING.listOf().fieldOf("instructions").forGetter(c0679mC12 -> {
            return c0679mC12.f3721aj;
        }), C0692mP.f3829q.listOf().fieldOf("textElements").forGetter(c0679mC13 -> {
            return c0679mC13.f3722ak;
        })).apply(instance, (f, f2, f3, f4, c0881pt, c0881pt2, num, num2, num3, f5, num4, list, list2) -> {
            C0679mC c0679mC14 = new C0679mC();
            c0679mC14.f3719iu = f.floatValue();
            c0679mC14.f3720iv = f2.floatValue();
            c0679mC14.f3729iw = f3.floatValue();
            c0679mC14.f3730ix = f4.floatValue();
            c0679mC14.f3725a = c0881pt;
            c0679mC14.f3726b = c0881pt2;
            c0679mC14.f3732mn = num.intValue();
            c0679mC14.f3723a = EnumC0684mH.values()[num2.intValue()];
            c0679mC14.f3724b = EnumC0684mH.values()[num3.intValue()];
            c0679mC14.f3733iz = f5.floatValue();
            c0679mC14.f3734a = EnumC0682mF.values()[num4.intValue()];
            c0679mC14.f3721aj.addAll(list);
            c0679mC14.f3722ak.addAll(list2);
            return c0679mC14;
        });
    });

    /* JADX INFO: renamed from: iu */
    protected float f3719iu;

    /* JADX INFO: renamed from: iv */
    protected float f3720iv;

    /* JADX INFO: renamed from: a */
    protected C0881pt f3725a;

    /* JADX INFO: renamed from: b */
    protected C0881pt f3726b;

    /* JADX INFO: renamed from: c */
    private C0881pt f3727c;

    /* JADX INFO: renamed from: d */
    private C0881pt f3728d;

    /* JADX INFO: renamed from: iw */
    protected float f3729iw;

    /* JADX INFO: renamed from: ix */
    protected float f3730ix;

    /* JADX INFO: renamed from: iy */
    private float f3731iy;

    /* JADX INFO: renamed from: iz */
    protected float f3733iz;

    /* JADX INFO: renamed from: aj */
    @NotNull
    protected final List<String> f3721aj = new ObjectArrayList();

    /* JADX INFO: renamed from: ak */
    @NotNull
    protected final List<C0692mP> f3722ak = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    protected EnumC0684mH f3723a = EnumC0684mH.NONE;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected EnumC0684mH f3724b = EnumC0684mH.NONE;

    /* JADX INFO: renamed from: mn */
    protected int f3732mn = 70;

    /* JADX INFO: renamed from: a */
    @NotNull
    protected EnumC0682mF f3734a = EnumC0682mF.LINEAR;

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0679mC m2982a(int i) {
        this.f3732mn = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0679mC m2983a(float f) {
        this.f3729iw = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0679mC m2984b(float f) {
        this.f3730ix = f;
        return this;
    }

    /* JADX INFO: renamed from: an */
    public float m2985an() {
        return this.f3729iw;
    }

    /* JADX INFO: renamed from: ao */
    public float m2986ao() {
        return this.f3730ix;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0679mC m2987a(@NotNull C0881pt c0881pt) {
        this.f3725a = c0881pt;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0679mC m2988b(@NotNull C0881pt c0881pt) {
        this.f3726b = c0881pt;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C0679mC m2989c(float f) {
        this.f3733iz = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0679mC m2990a(@NotNull EnumC0682mF enumC0682mF) {
        this.f3734a = enumC0682mF;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C0679mC m2991d(float f) {
        this.f3719iu = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C0679mC m2992e(float f) {
        this.f3720iv = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0679mC m2993a(@NotNull EnumC0684mH enumC0684mH) {
        this.f3723a = enumC0684mH;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C0679mC m2994b(@NotNull EnumC0684mH enumC0684mH) {
        this.f3724b = enumC0684mH;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0679mC m2995a(@NotNull String str) {
        this.f3721aj.add(str);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0679mC m2996a(@NotNull C0692mP c0692mP) {
        this.f3722ak.add(c0692mP);
        return this;
    }

    /* JADX INFO: renamed from: aF */
    public int m2997aF() {
        return this.f3732mn;
    }

    /* JADX INFO: renamed from: ap */
    public float m2998ap() {
        return this.f3719iu;
    }

    /* JADX INFO: renamed from: aq */
    public float m2999aq() {
        return this.f3720iv;
    }

    /* JADX INFO: renamed from: t */
    public List<String> m3000t() {
        return Collections.unmodifiableList(this.f3721aj);
    }

    /* JADX INFO: renamed from: j */
    public void m3001j(@Nullable LocalPlayer localPlayer) {
        this.f3727c = m3003a(this.f3725a, this.f3723a, localPlayer);
        this.f3728d = m3003a(this.f3726b, this.f3724b, localPlayer);
    }

    /* JADX INFO: renamed from: a */
    public C0881pt m3002a(float f) {
        float fApply = this.f3734a.apply(f);
        double dLerp = Mth.lerp(fApply, this.f3727c.f4827c.x, this.f3728d.f4827c.x);
        double dLerp2 = Mth.lerp(fApply, this.f3727c.f4827c.y, this.f3728d.f4827c.y);
        double dLerp3 = Mth.lerp(fApply, this.f3727c.f4827c.z, this.f3728d.f4827c.z);
        float fM3004a = m3004a(fApply, this.f3727c.f4826h.y, this.f3728d.f4826h.y);
        float fM3004a2 = m3004a(fApply, this.f3727c.f4826h.x, this.f3728d.f4826h.x);
        float fM3004a3 = m3004a(fApply, this.f3729iw, this.f3730ix);
        C0881pt c0881pt = new C0881pt(dLerp, dLerp2, dLerp3, fM3004a2, fM3004a);
        this.f3731iy = fM3004a3;
        return c0881pt;
    }

    /* JADX INFO: renamed from: a */
    private C0881pt m3003a(C0881pt c0881pt, EnumC0684mH enumC0684mH, @Nullable LocalPlayer localPlayer) {
        if (localPlayer == null || enumC0684mH == EnumC0684mH.NONE) {
            return c0881pt;
        }
        double x = c0881pt.f4827c.x;
        double y = c0881pt.f4827c.y;
        double z = c0881pt.f4827c.z;
        float xRot = c0881pt.f4826h.x;
        float yRot = c0881pt.f4826h.y;
        if (enumC0684mH == EnumC0684mH.POSITION || enumC0684mH == EnumC0684mH.POSITION_ROTATION) {
            x += localPlayer.getX();
            y += localPlayer.getY();
            z += localPlayer.getZ();
        }
        if (enumC0684mH == EnumC0684mH.POSITION_ROTATION) {
            xRot += localPlayer.getXRot();
            yRot += localPlayer.getYRot();
        }
        return new C0881pt(x, y, z, xRot, yRot);
    }

    /* JADX INFO: renamed from: a */
    private float m3004a(float f, float f2, float f3) {
        return C1270xJ.m7171g(f3, f2, f);
    }

    /* JADX INFO: renamed from: a */
    public C0881pt m3005a() {
        return this.f3725a;
    }

    /* JADX INFO: renamed from: b */
    public C0881pt m3006b() {
        return this.f3726b;
    }

    /* JADX INFO: renamed from: ar */
    public float m3007ar() {
        return this.f3733iz;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0682mF m3008a() {
        return this.f3734a;
    }

    /* JADX INFO: renamed from: b */
    public void m3009b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        this.f3719iu = registryFriendlyByteBuf.readFloat();
        this.f3720iv = registryFriendlyByteBuf.readFloat();
        this.f3729iw = registryFriendlyByteBuf.readFloat();
        this.f3730ix = registryFriendlyByteBuf.readFloat();
        this.f3723a = EnumC0684mH.values()[registryFriendlyByteBuf.readInt()];
        this.f3724b = EnumC0684mH.values()[registryFriendlyByteBuf.readInt()];
        this.f3725a = C0881pt.m4588a((FriendlyByteBuf) registryFriendlyByteBuf);
        this.f3726b = C0881pt.m4588a((FriendlyByteBuf) registryFriendlyByteBuf);
        this.f3732mn = registryFriendlyByteBuf.readInt();
        this.f3733iz = registryFriendlyByteBuf.readFloat();
        this.f3734a = EnumC0682mF.values()[registryFriendlyByteBuf.readInt()];
        this.f3721aj.clear();
        int i = registryFriendlyByteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f3721aj.add(registryFriendlyByteBuf.readUtf());
        }
        this.f3722ak.clear();
        int i3 = registryFriendlyByteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f3722ak.add(new C0692mP((FriendlyByteBuf) registryFriendlyByteBuf));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3010a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) throws IOException {
        registryFriendlyByteBuf.writeFloat(this.f3719iu);
        registryFriendlyByteBuf.writeFloat(this.f3720iv);
        registryFriendlyByteBuf.writeFloat(this.f3729iw);
        registryFriendlyByteBuf.writeFloat(this.f3730ix);
        registryFriendlyByteBuf.writeInt(this.f3723a.ordinal());
        registryFriendlyByteBuf.writeInt(this.f3724b.ordinal());
        this.f3725a.m4589b((FriendlyByteBuf) registryFriendlyByteBuf);
        this.f3726b.m4589b((FriendlyByteBuf) registryFriendlyByteBuf);
        registryFriendlyByteBuf.writeInt(this.f3732mn);
        registryFriendlyByteBuf.writeFloat(this.f3733iz);
        registryFriendlyByteBuf.writeInt(this.f3734a.ordinal());
        int size = this.f3721aj.size();
        registryFriendlyByteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            registryFriendlyByteBuf.writeUtf(this.f3721aj.get(i));
        }
        int size2 = this.f3722ak.size();
        registryFriendlyByteBuf.writeInt(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.f3722ak.get(i2).m3094a(registryFriendlyByteBuf);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3011a(@NotNull PoseStack poseStack, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera) {
        Iterator<C0692mP> it = this.f3722ak.iterator();
        while (it.hasNext()) {
            it.next().m3096a(poseStack, font, guiGraphics, camera);
        }
    }

    /* JADX INFO: renamed from: as */
    public float m3012as() {
        return this.f3731iy;
    }

    /* JADX INFO: renamed from: b */
    public void m3013b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f3719iu = byteBuf.readFloat();
        this.f3720iv = byteBuf.readFloat();
        this.f3729iw = byteBuf.readFloat();
        this.f3730ix = byteBuf.readFloat();
        this.f3723a = EnumC0684mH.values()[byteBuf.readInt()];
        this.f3724b = EnumC0684mH.values()[byteBuf.readInt()];
        this.f3725a = new C0881pt();
        this.f3725a.mo3869b(byteBuf);
        this.f3726b = new C0881pt();
        this.f3726b.mo3869b(byteBuf);
        this.f3732mn = byteBuf.readInt();
        this.f3733iz = byteBuf.readFloat();
        this.f3734a = EnumC0682mF.values()[byteBuf.readInt()];
        this.f3721aj.clear();
        int i = byteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.f3721aj.add(IPacket.readString(byteBuf));
        }
        this.f3722ak.clear();
        int i3 = byteBuf.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f3722ak.add(new C0692mP(byteBuf));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m3014c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeFloat(this.f3719iu);
        byteBuf.writeFloat(this.f3720iv);
        byteBuf.writeFloat(this.f3729iw);
        byteBuf.writeFloat(this.f3730ix);
        byteBuf.writeInt(this.f3723a.ordinal());
        byteBuf.writeInt(this.f3724b.ordinal());
        this.f3725a.mo3870c(byteBuf);
        this.f3726b.mo3870c(byteBuf);
        byteBuf.writeInt(this.f3732mn);
        byteBuf.writeFloat(this.f3733iz);
        byteBuf.writeInt(this.f3734a.ordinal());
        int size = this.f3721aj.size();
        byteBuf.writeInt(size);
        for (int i = 0; i < size; i++) {
            IPacket.writeString(byteBuf, this.f3721aj.get(i));
        }
        int size2 = this.f3722ak.size();
        byteBuf.writeInt(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.f3722ak.get(i2).m3095c(byteBuf);
        }
    }
}
