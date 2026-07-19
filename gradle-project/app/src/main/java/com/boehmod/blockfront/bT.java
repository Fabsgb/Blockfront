package com.boehmod.blockfront;

import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import com.boehmod.blockfront.oV;
import com.boehmod.blockfront.qN;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bT.class */
public class bT<C extends oV<P>, G extends oF<G, P, ?> & qN<P, C>, P extends oI<G>> extends AbstractC0063cg<G, P> {

    @NotNull
    private static final ResourceLocation ac;

    @NotNull
    private static final ResourceLocation ad;

    @NotNull
    private static final ResourceLocation ae;

    @NotNull
    private static final ResourceLocation af;
    private static final int da = 11;
    private static final int db = 2;

    @NotNull
    private final ObjectList<a> n;
    private int dc;
    private boolean aN;
    static final /* synthetic */ boolean aO;

    static {
        aO = !bT.class.desiredAssertionStatus();
        ac = C0265jv.d("textures/text/cp_allies.png");
        ad = C0265jv.d("textures/text/cp_axis.png");
        ae = C0265jv.d("textures/text/cp_neutral.png");
        af = C0265jv.d("textures/text/cp_flicker.png");
    }

    public bT() {
        super(1);
        this.n = new ObjectArrayList();
        this.dc = 0;
        this.aN = false;
    }

    private void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, int i3, float f) {
        a aVar = (a) this.n.get(i3);
        oV<?> oVVarM217a = aVar.m217a();
        FormattedCharSequence formattedCharSequenceA = aVar.a();
        int i4 = i + 2 + (i3 * 13);
        int i5 = i2 + 2;
        C0040bk.a(poseStack, guiGraphics, aVar.g(), i4, i5, 11, 11);
        ResourceLocation resourceLocationH = aVar.h();
        if (resourceLocationH != null) {
            int iBd = oVVarM217a.bd();
            int iRound = Math.round((iBd <= 0 ? 0.0f : Mth.clamp(C0634xm.e(oVVarM217a.ku, oVVarM217a.kv, f) / iBd, 0.0f, 1.0f)) * 11.0f);
            if (iRound > 0) {
                C0040bk.a(guiGraphics, i4, i5, iRound, 11);
                C0040bk.a(poseStack, guiGraphics, resourceLocationH, i4, i5, 11, 11);
                guiGraphics.disableScissor();
            }
        }
        if (this.aN && oVVarM217a.gh) {
            C0040bk.a(poseStack, guiGraphics, af, i4, i5, 11, 11);
        }
        C0040bk.a(poseStack, font, guiGraphics, formattedCharSequenceA, i4 + 0.3f + 5.5f, i5 + 3, 0.75f);
    }

    /* JADX WARN: Incorrect types in method signature: (Lnet/minecraft/client/Minecraft;TG;TP;Lcom/boehmod/blockfront/oG<TG;TP;>;Lnet/minecraft/client/player/LocalPlayer;)V */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull Minecraft minecraft, @NotNull oF oFVar, @NotNull oI oIVar, @NotNull oG oGVar, @NotNull LocalPlayer localPlayer) {
        this.n.clear();
        this.dc++;
        if (this.dc >= 10) {
            this.dc = 0;
            this.aN = !this.aN;
        }
        List<C> listO = ((qN) oFVar).O();
        oO oOVarA = oIVar.a(C0529tp.da);
        oO oOVarA2 = oIVar.a(C0529tp.cZ);
        if (!aO && oOVarA == null) {
            throw new AssertionError();
        }
        if (!aO && oOVarA2 == null) {
            throw new AssertionError();
        }
        for (C c : listO) {
            ResourceLocation resourceLocationA = a(c.m801d(), oOVarA, oOVarA2);
            oO oOVarMo800c = c.mo800c();
            this.n.add(new a(Component.literal(c.bP).withStyle(ChatFormatting.BOLD).getVisualOrderText(), resourceLocationA, oOVarMo800c != null ? a(oOVarMo800c, oOVarA, oOVarA2) : null, c));
        }
    }

    @NotNull
    private static ResourceLocation a(@Nullable oO oOVar, @NotNull oO oOVar2, @NotNull oO oOVar3) {
        return oOVar3.equals(oOVar) ? ac : oOVar2.equals(oOVar) ? ad : ae;
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public void a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.a(guiGraphics, poseStack, font, i, i2, f);
        int size = this.n.size();
        for (int i3 = 0; i3 < size; i3++) {
            a(guiGraphics, poseStack, font, i, i2, i3, f);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0063cg
    public int a(@NotNull Font font) {
        return (this.n.size() * 13) + 2;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/bT$a.class */
    private static final class a extends Record {

        @NotNull
        private final FormattedCharSequence a;

        @NotNull
        private final ResourceLocation ag;

        @Nullable
        private final ResourceLocation ah;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @NotNull
        private final oV<?> f59a;

        private a(@NotNull FormattedCharSequence formattedCharSequence, @NotNull ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, @NotNull oV<?> oVVar) {
            this.a = formattedCharSequence;
            this.ag = resourceLocation;
            this.ah = resourceLocation2;
            this.f59a = oVVar;
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
        public FormattedCharSequence a() {
            return this.a;
        }

        @NotNull
        public ResourceLocation g() {
            return this.ag;
        }

        @Nullable
        public ResourceLocation h() {
            return this.ah;
        }

        @NotNull
        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public oV<?> m217a() {
            return this.f59a;
        }
    }
}
