package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pp.class */
public class C0421pp {
    public static final int nN = 240;
    private float kB;

    @Nullable
    private UUID w;

    @Nullable
    private UUID x;

    @NotNull
    private final ObjectList<AbstractC0422pq> P = new ObjectArrayList();
    public int nM = 0;

    @NotNull
    private EnumC0428pw a = EnumC0428pw.DEFAULT;
    private float kC = 0.0f;

    @NotNull
    public C0421pp a(@NotNull EnumC0428pw enumC0428pw) {
        this.a = enumC0428pw;
        return this;
    }

    @NotNull
    public EnumC0428pw a() {
        return this.a;
    }

    public boolean a(@NotNull Minecraft minecraft, @NotNull oF<?, ?, ?> oFVar) {
        this.nM++;
        int iA = a(minecraft.font);
        this.kC = this.kB;
        if (this.kB < iA) {
            this.kB = Mth.lerp(0.2f, this.kB, iA);
            if (this.kB > iA) {
                this.kB = iA;
            }
        }
        ObjectListIterator it = this.P.iterator();
        while (it.hasNext()) {
            ((AbstractC0422pq) it.next()).a(minecraft, oFVar, this);
        }
        return this.nM > 240;
    }

    public void a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oF<?, ?, ?> oFVar, boolean z, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        float fE = C0634xm.e(this.kB, this.kC, f);
        int iA = a(font);
        poseStackPose.translate((-iA) + fE, 0.0f, 0.0f);
        b(guiGraphics, iA);
        poseStackPose.pushPose();
        ObjectListIterator it = this.P.iterator();
        while (it.hasNext()) {
            AbstractC0422pq abstractC0422pq = (AbstractC0422pq) it.next();
            int iA2 = abstractC0422pq.a(font);
            if (z) {
                int iBm = abstractC0422pq.bm();
                C0040bk.a(guiGraphics, 0, 0, iA2, 11, iBm, 0.2f);
                C0040bk.a(guiGraphics, 0, 0, iA2, 1, iBm);
            }
            abstractC0422pq.a(poseStackPose, guiGraphics, font, oFVar, this, f);
            poseStackPose.translate(iA2, 0.0f, 0.0f);
        }
        poseStackPose.popPose();
    }

    private void b(@NotNull GuiGraphics guiGraphics, int i) {
        C0040bk.a(guiGraphics, -2, -2, i + 3, 1, -14606047);
        C0040bk.a(guiGraphics, -3, -1, i + 5, 13, -14606047);
        C0040bk.a(guiGraphics, -2, 12, i + 3, 1, -14606047);
        int outlineColorTop = this.a.getOutlineColorTop();
        int outlineColorBottom = this.a.getOutlineColorBottom();
        C0040bk.a(guiGraphics, -2, -1, i + 3, 1, outlineColorTop);
        C0040bk.a(guiGraphics, -2, 11, i + 3, 1, outlineColorBottom);
        C0040bk.a(guiGraphics, -2, 0, 1, 11, outlineColorTop, outlineColorBottom);
        C0040bk.a(guiGraphics, i, 0, 1, 11, outlineColorTop, outlineColorBottom);
    }

    public int a(@NotNull Font font) {
        int iA = 0;
        ObjectListIterator it = this.P.iterator();
        while (it.hasNext()) {
            iA += ((AbstractC0422pq) it.next()).a(font);
        }
        return iA;
    }

    public void a(@NotNull AbstractC0422pq abstractC0422pq) {
        this.P.add(abstractC0422pq);
    }

    public void b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.w = registryFriendlyByteBuf.readBoolean() ? registryFriendlyByteBuf.readUUID() : null;
        this.x = registryFriendlyByteBuf.readBoolean() ? registryFriendlyByteBuf.readUUID() : null;
        int i = registryFriendlyByteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            c(registryFriendlyByteBuf);
        }
    }

    public void m(@NotNull Minecraft minecraft) {
        ObjectListIterator it = this.P.iterator();
        while (it.hasNext()) {
            ((AbstractC0422pq) it.next()).a(minecraft, minecraft.font);
        }
    }

    private void c(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        Class<?> clsA = C0426pu.a(registryFriendlyByteBuf.readByte());
        if (clsA == null) {
            return;
        }
        try {
            AbstractC0422pq abstractC0422pq = (AbstractC0422pq) clsA.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            abstractC0422pq.d(registryFriendlyByteBuf);
            this.P.add(abstractC0422pq);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            C0263jt.a("Error while reading kill-feed data.", e, new Object[0]);
        }
    }

    public void a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeBoolean(this.w != null);
        if (this.w != null) {
            registryFriendlyByteBuf.writeUUID(this.w);
        }
        registryFriendlyByteBuf.writeBoolean(this.x != null);
        if (this.x != null) {
            registryFriendlyByteBuf.writeUUID(this.x);
        }
        registryFriendlyByteBuf.writeInt(this.P.size());
        ObjectListIterator it = this.P.iterator();
        while (it.hasNext()) {
            AbstractC0422pq abstractC0422pq = (AbstractC0422pq) it.next();
            registryFriendlyByteBuf.writeByte(C0426pu.a(abstractC0422pq.getClass()));
            abstractC0422pq.e(registryFriendlyByteBuf);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static C0421pp m875a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        C0421pp c0421pp = new C0421pp();
        c0421pp.b(registryFriendlyByteBuf);
        return c0421pp;
    }

    public void D(Minecraft minecraft) {
        UUID profileId = minecraft.getUser().getProfileId();
        if (profileId.equals(this.x)) {
            this.a = EnumC0428pw.SELF;
        } else if (profileId.equals(this.w)) {
            this.a = EnumC0428pw.SELF_DEATH;
        }
    }

    public void k(@NotNull UUID uuid) {
        this.w = uuid;
    }

    public void l(@NotNull UUID uuid) {
        this.x = uuid;
    }
}
