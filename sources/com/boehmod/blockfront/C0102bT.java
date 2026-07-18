package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import com.boehmod.blockfront.AbstractC0803oV;
import com.boehmod.blockfront.InterfaceC0901qN;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.bT */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bT.class */
public class C0102bT<C extends AbstractC0803oV<P>, G extends AbstractC0787oF<G, P, ?> & InterfaceC0901qN<P, C>, P extends AbstractC0790oI<G>> extends AbstractC0168cg<G, P> {

    /* JADX INFO: renamed from: ac */
    @NotNull
    private static final ResourceLocation f650ac;

    /* JADX INFO: renamed from: ad */
    @NotNull
    private static final ResourceLocation f651ad;

    /* JADX INFO: renamed from: ae */
    @NotNull
    private static final ResourceLocation f652ae;

    /* JADX INFO: renamed from: af */
    @NotNull
    private static final ResourceLocation f653af;

    /* JADX INFO: renamed from: da */
    private static final int f654da = 11;

    /* JADX INFO: renamed from: db */
    private static final int f655db = 2;

    /* JADX INFO: renamed from: n */
    @NotNull
    private final ObjectList<a> f656n;

    /* JADX INFO: renamed from: dc */
    private int f657dc;

    /* JADX INFO: renamed from: aN */
    private boolean f658aN;

    /* JADX INFO: renamed from: aO */
    static final /* synthetic */ boolean f659aO;

    static {
        f659aO = !C0102bT.class.desiredAssertionStatus();
        f650ac = C0564jv.m2555d("textures/text/cp_allies.png");
        f651ad = C0564jv.m2555d("textures/text/cp_axis.png");
        f652ae = C0564jv.m2555d("textures/text/cp_neutral.png");
        f653af = C0564jv.m2555d("textures/text/cp_flicker.png");
    }

    public C0102bT() {
        super(1);
        this.f656n = new ObjectArrayList();
        this.f657dc = 0;
        this.f658aN = false;
    }

    /* JADX INFO: renamed from: a */
    private void m318a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, float f) {
        a aVar = (a) this.f656n.get(i3);
        AbstractC0803oV<?> abstractC0803oVM326a = aVar.m326a();
        FormattedCharSequence formattedCharSequenceM323a = aVar.m323a();
        int i4 = i + 2 + (i3 * 13);
        int i5 = i2 + 2;
        C0119bk.m431a(poseStack, guiGraphics, aVar.m324g(), i4, i5, 11, 11);
        ResourceLocation resourceLocationM325h = aVar.m325h();
        if (resourceLocationM325h != null) {
            int iMo4107bd = abstractC0803oVM326a.mo4107bd();
            int iRound = Math.round((iMo4107bd <= 0 ? 0.0f : Mth.clamp(C1290xm.m7843e(abstractC0803oVM326a.f4411ku, abstractC0803oVM326a.f4412kv, f) / iMo4107bd, 0.0f, 1.0f)) * 11.0f);
            if (iRound > 0) {
                C0119bk.m517a(guiGraphics, i4, i5, iRound, 11);
                C0119bk.m431a(poseStack, guiGraphics, resourceLocationM325h, i4, i5, 11, 11);
                guiGraphics.disableScissor();
            }
        }
        if (this.f658aN && abstractC0803oVM326a.f4409gh) {
            C0119bk.m431a(poseStack, guiGraphics, f653af, i4, i5, 11, 11);
        }
        C0119bk.m411a(poseStack, font, guiGraphics, formattedCharSequenceM323a, i4 + 0.3f + 5.5f, i5 + 3, 0.75f);
    }

    /* JADX WARN: Incorrect types in method signature: (Lnet/minecraft/client/Minecraft;TG;TP;Lcom/boehmod/blockfront/oG<TG;TP;>;Lnet/minecraft/client/player/LocalPlayer;)V */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo319a(@NotNull Minecraft minecraft, @NotNull AbstractC0787oF abstractC0787oF, @NotNull AbstractC0790oI abstractC0790oI, @NotNull AbstractC0788oG abstractC0788oG, @NotNull LocalPlayer localPlayer) {
        this.f656n.clear();
        this.f657dc++;
        if (this.f657dc >= 10) {
            this.f657dc = 0;
            this.f658aN = !this.f658aN;
        }
        List<C> listMo4668O = ((InterfaceC0901qN) abstractC0787oF).mo4668O();
        C0796oO c0796oOM3806a = abstractC0790oI.m3806a(C1089tp.f5730da);
        C0796oO c0796oOM3806a2 = abstractC0790oI.m3806a(C1089tp.f5729cZ);
        if (!f659aO && c0796oOM3806a == null) {
            throw new AssertionError();
        }
        if (!f659aO && c0796oOM3806a2 == null) {
            throw new AssertionError();
        }
        for (C c : listMo4668O) {
            ResourceLocation resourceLocationM320a = m320a(c.m4114d(), c0796oOM3806a, c0796oOM3806a2);
            C0796oO c0796oOMo4105c = c.mo4105c();
            this.f656n.add(new a(Component.literal(c.f4399bP).withStyle(ChatFormatting.BOLD).getVisualOrderText(), resourceLocationM320a, c0796oOMo4105c != null ? m320a(c0796oOMo4105c, c0796oOM3806a, c0796oOM3806a2) : null, c));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ResourceLocation m320a(@Nullable C0796oO c0796oO, @NotNull C0796oO c0796oO2, @NotNull C0796oO c0796oO3) {
        return c0796oO3.equals(c0796oO) ? f650ac : c0796oO2.equals(c0796oO) ? f651ad : f652ae;
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public void mo321a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.mo321a(guiGraphics, poseStack, font, i, i2, f);
        int size = this.f656n.size();
        for (int i3 = 0; i3 < size; i3++) {
            m318a(guiGraphics, poseStack, font, i, i2, i3, f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0168cg
    /* JADX INFO: renamed from: a */
    public int mo322a(@NotNull Font font) {
        return (this.f656n.size() * 13) + 2;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.bT$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bT$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: a */
        @NotNull
        private final FormattedCharSequence f660a;

        /* JADX INFO: renamed from: ag */
        @NotNull
        private final ResourceLocation f661ag;

        /* JADX INFO: renamed from: ah */
        @Nullable
        private final ResourceLocation f662ah;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final AbstractC0803oV<?> f663a;

        private a(@NotNull FormattedCharSequence formattedCharSequence, @NotNull ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, @NotNull AbstractC0803oV<?> abstractC0803oV) {
            this.f660a = formattedCharSequence;
            this.f661ag = resourceLocation;
            this.f662ah = resourceLocation2;
            this.f663a = abstractC0803oV;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "name;baseTexture;capturingTexture;capturePoint", "FIELD:Lcom/boehmod/blockfront/bT$a;->a:Lnet/minecraft/util/FormattedCharSequence;", "FIELD:Lcom/boehmod/blockfront/bT$a;->ag:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/bT$a;->ah:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/bT$a;->a:Lcom/boehmod/blockfront/oV;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "name;baseTexture;capturingTexture;capturePoint", "FIELD:Lcom/boehmod/blockfront/bT$a;->a:Lnet/minecraft/util/FormattedCharSequence;", "FIELD:Lcom/boehmod/blockfront/bT$a;->ag:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/bT$a;->ah:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/bT$a;->a:Lcom/boehmod/blockfront/oV;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "name;baseTexture;capturingTexture;capturePoint", "FIELD:Lcom/boehmod/blockfront/bT$a;->a:Lnet/minecraft/util/FormattedCharSequence;", "FIELD:Lcom/boehmod/blockfront/bT$a;->ag:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/bT$a;->ah:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/bT$a;->a:Lcom/boehmod/blockfront/oV;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public FormattedCharSequence m323a() {
            return this.f660a;
        }

        @NotNull
        /* JADX INFO: renamed from: g */
        public ResourceLocation m324g() {
            return this.f661ag;
        }

        @Nullable
        /* JADX INFO: renamed from: h */
        public ResourceLocation m325h() {
            return this.f662ah;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public AbstractC0803oV<?> m326a() {
            return this.f663a;
        }
    }
}
