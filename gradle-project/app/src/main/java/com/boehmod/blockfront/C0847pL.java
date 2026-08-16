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

/* JADX INFO: renamed from: com.boehmod.blockfront.pL */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pL.class */
public class C0847pL {

    /* JADX INFO: renamed from: pM */
    public static final int f4563pM = 240;

    /* JADX INFO: renamed from: lw */
    private float f4564lw;

    /* JADX INFO: renamed from: w */
    @Nullable
    private UUID f4566w;

    /* JADX INFO: renamed from: x */
    @Nullable
    private UUID f4567x;

    /* JADX INFO: renamed from: Y */
    @NotNull
    private final ObjectList<AbstractC0848pM> f4560Y = new ObjectArrayList();

    /* JADX INFO: renamed from: pL */
    public int f4561pL = 0;

    /* JADX INFO: renamed from: a */
    @NotNull
    private EnumC0854pS f4562a = EnumC0854pS.DEFAULT;

    /* JADX INFO: renamed from: lx */
    private float f4565lx = 0.0f;

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0847pL m3908a(@NotNull EnumC0854pS enumC0854pS) {
        this.f4562a = enumC0854pS;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC0854pS m3909a() {
        return this.f4562a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3910a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        this.f4561pL++;
        int iM3913a = m3913a(minecraft.font);
        this.f4565lx = this.f4564lw;
        if (this.f4564lw < iM3913a) {
            this.f4564lw = Mth.lerp(0.2f, this.f4564lw, iM3913a);
            if (this.f4564lw > iM3913a) {
                this.f4564lw = iM3913a;
            }
        }
        ObjectListIterator it = this.f4560Y.iterator();
        while (it.hasNext()) {
            ((AbstractC0848pM) it.next()).mo3924a(minecraft, abstractC0863pb, this);
        }
        return this.f4561pL > 240;
    }

    /* JADX INFO: renamed from: a */
    public void m3911a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        float fM7170f = C1270xJ.m7170f(this.f4564lw, this.f4565lx, f);
        int iM3913a = m3913a(font);
        poseStackPose.translate((-iM3913a) + fM7170f, 0.0f, 0.0f);
        m3912b(guiGraphics, iM3913a);
        poseStackPose.pushPose();
        ObjectListIterator it = this.f4560Y.iterator();
        while (it.hasNext()) {
            AbstractC0848pM abstractC0848pM = (AbstractC0848pM) it.next();
            int iMo3926a = abstractC0848pM.mo3926a(font);
            if (z) {
                int iMo3927bB = abstractC0848pM.mo3927bB();
                C0129bt.m517a(guiGraphics, 0, 0, iMo3926a, 11, iMo3927bB, 0.2f);
                C0129bt.m515a(guiGraphics, 0, 0, iMo3926a, 1, iMo3927bB);
            }
            abstractC0848pM.mo3925a(poseStackPose, guiGraphics, font, abstractC0863pb, this, f);
            poseStackPose.translate(iMo3926a, 0.0f, 0.0f);
        }
        poseStackPose.popPose();
    }

    /* JADX INFO: renamed from: b */
    private void m3912b(@NotNull GuiGraphics guiGraphics, int i) {
        C0129bt.m518b(guiGraphics, -3, -2, i + 5, 15, -14606047);
        int outlineColorTop = this.f4562a.getOutlineColorTop();
        int outlineColorBottom = this.f4562a.getOutlineColorBottom();
        C0129bt.m515a(guiGraphics, -2, -1, i + 3, 1, outlineColorTop);
        C0129bt.m515a(guiGraphics, -2, 11, i + 3, 1, outlineColorBottom);
        C0129bt.m523a(guiGraphics, -2, 0, 1, 11, outlineColorTop, outlineColorBottom);
        C0129bt.m523a(guiGraphics, i, 0, 1, 11, outlineColorTop, outlineColorBottom);
    }

    /* JADX INFO: renamed from: a */
    public int m3913a(@NotNull Font font) {
        int iMo3926a = 0;
        ObjectListIterator it = this.f4560Y.iterator();
        while (it.hasNext()) {
            iMo3926a += ((AbstractC0848pM) it.next()).mo3926a(font);
        }
        return iMo3926a;
    }

    /* JADX INFO: renamed from: a */
    public void m3914a(@NotNull AbstractC0848pM abstractC0848pM) {
        this.f4560Y.add(abstractC0848pM);
    }

    /* JADX INFO: renamed from: b */
    public void m3915b(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f4566w = registryFriendlyByteBuf.readBoolean() ? registryFriendlyByteBuf.readUUID() : null;
        this.f4567x = registryFriendlyByteBuf.readBoolean() ? registryFriendlyByteBuf.readUUID() : null;
        int i = registryFriendlyByteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            m3917c(registryFriendlyByteBuf);
        }
    }

    /* JADX INFO: renamed from: n */
    public void m3916n(@NotNull Minecraft minecraft) {
        ObjectListIterator it = this.f4560Y.iterator();
        while (it.hasNext()) {
            ((AbstractC0848pM) it.next()).mo3923a(minecraft, minecraft.font);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m3917c(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        Class<?> clsM3931a = C0852pQ.m3931a(registryFriendlyByteBuf.readByte());
        if (clsM3931a == null) {
            return;
        }
        try {
            AbstractC0848pM abstractC0848pM = (AbstractC0848pM) clsM3931a.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            abstractC0848pM.mo3928d(registryFriendlyByteBuf);
            this.f4560Y.add(abstractC0848pM);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            C0530jM.m2338a("Error while reading kill-feed data.", e, new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3918a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeBoolean(this.f4566w != null);
        if (this.f4566w != null) {
            registryFriendlyByteBuf.writeUUID(this.f4566w);
        }
        registryFriendlyByteBuf.writeBoolean(this.f4567x != null);
        if (this.f4567x != null) {
            registryFriendlyByteBuf.writeUUID(this.f4567x);
        }
        registryFriendlyByteBuf.writeInt(this.f4560Y.size());
        ObjectListIterator it = this.f4560Y.iterator();
        while (it.hasNext()) {
            AbstractC0848pM abstractC0848pM = (AbstractC0848pM) it.next();
            registryFriendlyByteBuf.writeByte(C0852pQ.m3932a(abstractC0848pM.getClass()));
            abstractC0848pM.mo3929e(registryFriendlyByteBuf);
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0847pL m3919a(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        C0847pL c0847pL = new C0847pL();
        c0847pL.m3915b(registryFriendlyByteBuf);
        return c0847pL;
    }

    /* JADX INFO: renamed from: F */
    public void m3920F(Minecraft minecraft) {
        UUID profileId = minecraft.getUser().getProfileId();
        if (profileId.equals(this.f4567x)) {
            this.f4562a = EnumC0854pS.SELF;
        } else if (profileId.equals(this.f4566w)) {
            this.f4562a = EnumC0854pS.SELF_DEATH;
        }
    }

    /* JADX INFO: renamed from: k */
    public void m3921k(@NotNull UUID uuid) {
        this.f4566w = uuid;
    }

    /* JADX INFO: renamed from: l */
    public void m3922l(@NotNull UUID uuid) {
        this.f4567x = uuid;
    }
}
