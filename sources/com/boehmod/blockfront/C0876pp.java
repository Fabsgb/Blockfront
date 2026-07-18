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

/* JADX INFO: renamed from: com.boehmod.blockfront.pp */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/pp.class */
public class C0876pp {

    /* JADX INFO: renamed from: nN */
    public static final int f4594nN = 240;

    /* JADX INFO: renamed from: kB */
    private float f4595kB;

    /* JADX INFO: renamed from: w */
    @Nullable
    private UUID f4597w;

    /* JADX INFO: renamed from: x */
    @Nullable
    private UUID f4598x;

    /* JADX INFO: renamed from: P */
    @NotNull
    private final ObjectList<AbstractC0877pq> f4591P = new ObjectArrayList();

    /* JADX INFO: renamed from: nM */
    public int f4592nM = 0;

    /* JADX INFO: renamed from: a */
    @NotNull
    private EnumC0883pw f4593a = EnumC0883pw.DEFAULT;

    /* JADX INFO: renamed from: kC */
    private float f4596kC = 0.0f;

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0876pp m4420a(@NotNull EnumC0883pw enumC0883pw) {
        this.f4593a = enumC0883pw;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0883pw m4421a() {
        return this.f4593a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4422a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        this.f4592nM++;
        int iM4425a = m4425a(minecraft.font);
        this.f4596kC = this.f4595kB;
        if (this.f4595kB < iM4425a) {
            this.f4595kB = Mth.lerp(0.2f, this.f4595kB, iM4425a);
            if (this.f4595kB > iM4425a) {
                this.f4595kB = iM4425a;
            }
        }
        ObjectListIterator it = this.f4591P.iterator();
        while (it.hasNext()) {
            ((AbstractC0877pq) it.next()).mo4436a(minecraft, abstractC0787oF, this);
        }
        return this.f4592nM > 240;
    }

    /* JADX INFO: renamed from: a */
    public void m4423a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, boolean z, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        float fM7843e = C1290xm.m7843e(this.f4595kB, this.f4596kC, f);
        int iM4425a = m4425a(font);
        poseStackPose.translate((-iM4425a) + fM7843e, 0.0f, 0.0f);
        m4424b(guiGraphics, iM4425a);
        poseStackPose.pushPose();
        ObjectListIterator it = this.f4591P.iterator();
        while (it.hasNext()) {
            AbstractC0877pq abstractC0877pq = (AbstractC0877pq) it.next();
            int iMo4438a = abstractC0877pq.mo4438a(font);
            if (z) {
                int iMo4439bm = abstractC0877pq.mo4439bm();
                C0119bk.m417a(guiGraphics, 0, 0, iMo4438a, 11, iMo4439bm, 0.2f);
                C0119bk.m415a(guiGraphics, 0, 0, iMo4438a, 1, iMo4439bm);
            }
            abstractC0877pq.mo4437a(poseStackPose, guiGraphics, font, abstractC0787oF, this, f);
            poseStackPose.translate(iMo4438a, 0.0f, 0.0f);
        }
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: b */
    private void m4424b(@NotNull GuiGraphics guiGraphics, int i) {
        C0119bk.m415a(guiGraphics, -2, -2, i + 3, 1, -14606047);
        C0119bk.m415a(guiGraphics, -3, -1, i + 5, 13, -14606047);
        C0119bk.m415a(guiGraphics, -2, 12, i + 3, 1, -14606047);
        int outlineColorTop = this.f4593a.getOutlineColorTop();
        int outlineColorBottom = this.f4593a.getOutlineColorBottom();
        C0119bk.m415a(guiGraphics, -2, -1, i + 3, 1, outlineColorTop);
        C0119bk.m415a(guiGraphics, -2, 11, i + 3, 1, outlineColorBottom);
        C0119bk.m423a(guiGraphics, -2, 0, 1, 11, outlineColorTop, outlineColorBottom);
        C0119bk.m423a(guiGraphics, i, 0, 1, 11, outlineColorTop, outlineColorBottom);
    }

    /* JADX INFO: renamed from: a */
    public int m4425a(@NotNull Font font) {
        int iMo4438a = 0;
        ObjectListIterator it = this.f4591P.iterator();
        while (it.hasNext()) {
            iMo4438a += ((AbstractC0877pq) it.next()).mo4438a(font);
        }
        return iMo4438a;
    }

    /* JADX INFO: renamed from: a */
    public void m4426a(@NotNull AbstractC0877pq abstractC0877pq) {
        this.f4591P.add(abstractC0877pq);
    }

    /* JADX INFO: renamed from: b */
    public void m4427b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f4597w = registryFriendlyByteBuf.readBoolean() ? registryFriendlyByteBuf.readUUID() : null;
        this.f4598x = registryFriendlyByteBuf.readBoolean() ? registryFriendlyByteBuf.readUUID() : null;
        int i = registryFriendlyByteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            m4429c(registryFriendlyByteBuf);
        }
    }

    /* JADX INFO: renamed from: m */
    public void m4428m(@NotNull Minecraft minecraft) {
        ObjectListIterator it = this.f4591P.iterator();
        while (it.hasNext()) {
            ((AbstractC0877pq) it.next()).mo4435a(minecraft, minecraft.font);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m4429c(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        Class<?> clsM4443a = C0881pu.m4443a(registryFriendlyByteBuf.readByte());
        if (clsM4443a == null) {
            return;
        }
        try {
            AbstractC0877pq abstractC0877pq = (AbstractC0877pq) clsM4443a.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            abstractC0877pq.mo4440d(registryFriendlyByteBuf);
            this.f4591P.add(abstractC0877pq);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            C0562jt.m2516a("Error while reading kill-feed data.", e, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4430a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeBoolean(this.f4597w != null);
        if (this.f4597w != null) {
            registryFriendlyByteBuf.writeUUID(this.f4597w);
        }
        registryFriendlyByteBuf.writeBoolean(this.f4598x != null);
        if (this.f4598x != null) {
            registryFriendlyByteBuf.writeUUID(this.f4598x);
        }
        registryFriendlyByteBuf.writeInt(this.f4591P.size());
        ObjectListIterator it = this.f4591P.iterator();
        while (it.hasNext()) {
            AbstractC0877pq abstractC0877pq = (AbstractC0877pq) it.next();
            registryFriendlyByteBuf.writeByte(C0881pu.m4444a(abstractC0877pq.getClass()));
            abstractC0877pq.mo4441e(registryFriendlyByteBuf);
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0876pp m4431a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        C0876pp c0876pp = new C0876pp();
        c0876pp.m4427b(registryFriendlyByteBuf);
        return c0876pp;
    }

    /* JADX INFO: renamed from: D */
    public void m4432D(Minecraft minecraft) {
        UUID profileId = minecraft.getUser().getProfileId();
        if (profileId.equals(this.f4598x)) {
            this.f4593a = EnumC0883pw.SELF;
        } else if (profileId.equals(this.f4597w)) {
            this.f4593a = EnumC0883pw.SELF_DEATH;
        }
    }

    /* JADX INFO: renamed from: k */
    public void m4433k(@NotNull UUID uuid) {
        this.f4597w = uuid;
    }

    /* JADX INFO: renamed from: l */
    public void m4434l(@NotNull UUID uuid) {
        this.f4598x = uuid;
    }
}
