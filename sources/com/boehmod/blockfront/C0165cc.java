package com.boehmod.blockfront;

import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.boehmod.blockfront.AbstractC0879pr;
import com.boehmod.blockfront.InterfaceC0978rk;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.cc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cc.class */
public class C0165cc<C extends AbstractC0879pr<P>, G extends AbstractC0863pb<G, P, ?> & InterfaceC0978rk<P, C>, P extends AbstractC0866pe<G>> extends AbstractC0188cp<G, P> {

    /* JADX INFO: renamed from: ac */
    @NotNull
    private static final ResourceLocation f1329ac;

    /* JADX INFO: renamed from: ad */
    @NotNull
    private static final ResourceLocation f1330ad;

    /* JADX INFO: renamed from: ae */
    @NotNull
    private static final ResourceLocation f1331ae;

    /* JADX INFO: renamed from: af */
    @NotNull
    private static final ResourceLocation f1332af;

    /* JADX INFO: renamed from: dS */
    private static final int f1333dS = 11;

    /* JADX INFO: renamed from: dT */
    private static final int f1334dT = 2;

    /* JADX INFO: renamed from: w */
    @NotNull
    private final ObjectList<a> f1335w;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Object2ObjectOpenHashMap<String, FormattedCharSequence> f1336a;

    /* JADX INFO: renamed from: dU */
    private int f1337dU;

    /* JADX INFO: renamed from: aS */
    private boolean f1338aS;

    /* JADX INFO: renamed from: aT */
    static final /* synthetic */ boolean f1339aT;

    static {
        f1339aT = !C0165cc.class.desiredAssertionStatus();
        f1329ac = C0532jO.m2378d("textures/text/cp_allies.png");
        f1330ad = C0532jO.m2378d("textures/text/cp_axis.png");
        f1331ae = C0532jO.m2378d("textures/text/cp_neutral.png");
        f1332af = C0532jO.m2378d("textures/text/cp_flicker.png");
    }

    public C0165cc() {
        super(1);
        this.f1335w = new ObjectArrayList();
        this.f1336a = new Object2ObjectOpenHashMap<>();
        this.f1337dU = 0;
        this.f1338aS = false;
    }

    /* JADX INFO: renamed from: a */
    private void m1041a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, int i, int i2, int i3, float f) {
        a aVar = (a) this.f1335w.get(i3);
        AbstractC0879pr<?> abstractC0879prM1051a = aVar.m1051a();
        int i4 = i + 2 + (i3 * 13);
        int i5 = i2 + 2;
        C0129bt.m531a(poseStack, guiGraphics, aVar.m1049g(), i4, i5, 11, 11);
        ResourceLocation resourceLocationM1050h = aVar.m1050h();
        if (resourceLocationM1050h != null) {
            int iMo4544bs = abstractC0879prM1051a.mo4544bs();
            int iRound = Math.round((iMo4544bs <= 0 ? 0.0f : Mth.clamp(C1270xJ.m7170f(abstractC0879prM1051a.f4813lp, abstractC0879prM1051a.f4814lq, f) / iMo4544bs, 0.0f, 1.0f)) * 11.0f);
            if (iRound > 0) {
                C0129bt.m618a(guiGraphics, i4, i5, iRound, 11);
                C0129bt.m531a(poseStack, guiGraphics, resourceLocationM1050h, i4, i5, 11, 11);
                guiGraphics.disableScissor();
            }
        }
        if (this.f1338aS && abstractC0879prM1051a.f4811gB) {
            C0129bt.m531a(poseStack, guiGraphics, f1332af, i4, i5, 11, 11);
        }
    }

    /* JADX WARN: Incorrect types in method signature: (Lnet/minecraft/client/Minecraft;TG;TP;Lcom/boehmod/blockfront/pc<TG;TP;>;Lnet/minecraft/client/player/LocalPlayer;)V */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1042a(@NotNull Minecraft minecraft, @NotNull AbstractC0863pb abstractC0863pb, @NotNull AbstractC0866pe abstractC0866pe, @NotNull AbstractC0864pc abstractC0864pc, @NotNull LocalPlayer localPlayer) {
        this.f1335w.clear();
        this.f1337dU++;
        if (this.f1337dU >= 10) {
            this.f1337dU = 0;
            this.f1338aS = !this.f1338aS;
        }
        List<C> listMo5353Q = ((InterfaceC0978rk) abstractC0863pb).mo5353Q();
        C0872pk c0872pkM4242a = abstractC0866pe.m4242a(C1062tN.f5783dl);
        C0872pk c0872pkM4242a2 = abstractC0866pe.m4242a(C1062tN.f5782dk);
        if (!f1339aT && c0872pkM4242a == null) {
            throw new AssertionError();
        }
        if (!f1339aT && c0872pkM4242a2 == null) {
            throw new AssertionError();
        }
        for (C c : listMo5353Q) {
            ResourceLocation resourceLocationM1043a = m1043a(c.m4552d(), c0872pkM4242a, c0872pkM4242a2);
            C0872pk c0872pkMo4542c = c.mo4542c();
            this.f1335w.add(new a((FormattedCharSequence) this.f1336a.computeIfAbsent(c.f4796bZ, str -> {
                return Component.literal(str).withStyle(ChatFormatting.BOLD).getVisualOrderText();
            }), resourceLocationM1043a, c0872pkMo4542c != null ? m1043a(c0872pkMo4542c, c0872pkM4242a, c0872pkM4242a2) : null, c));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ResourceLocation m1043a(@Nullable C0872pk c0872pk, @NotNull C0872pk c0872pk2, @NotNull C0872pk c0872pk3) {
        if (c0872pk3.equals(c0872pk)) {
            return f1329ac;
        }
        return c0872pk2.equals(c0872pk) ? f1330ad : f1331ae;
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public void mo1044a(@NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2, float f) {
        super.mo1044a(guiGraphics, poseStack, font, i, i2, f);
        int size = this.f1335w.size();
        for (int i3 = 0; i3 < size; i3++) {
            m1041a(guiGraphics, poseStack, i, i2, i3, f);
        }
        guiGraphics.drawManaged(() -> {
            for (int i4 = 0; i4 < size; i4++) {
                C0129bt.m511a(poseStack, font, guiGraphics, ((a) this.f1335w.get(i4)).m1048a(), i + 2 + (i4 * 13) + 0.3f + 5.5f, i2 + 5, 0.75f);
            }
        });
    }

    @Override // com.boehmod.blockfront.AbstractC0188cp
    /* JADX INFO: renamed from: a */
    public int mo1045a(@NotNull Font font) {
        return (this.f1335w.size() * 13) + 2;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.cc$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/cc$a.class */
    private static final class a extends Record {

        /* JADX INFO: renamed from: a */
        @NotNull
        private final FormattedCharSequence f1340a;

        /* JADX INFO: renamed from: ag */
        @NotNull
        private final ResourceLocation f1341ag;

        /* JADX INFO: renamed from: ah */
        @Nullable
        private final ResourceLocation f1342ah;

        /* JADX INFO: renamed from: a */
        @NotNull
        private final AbstractC0879pr<?> f1343a;

        private a(@NotNull FormattedCharSequence formattedCharSequence, @NotNull ResourceLocation resourceLocation, @Nullable ResourceLocation resourceLocation2, @NotNull AbstractC0879pr<?> abstractC0879pr) {
            this.f1340a = formattedCharSequence;
            this.f1341ag = resourceLocation;
            this.f1342ah = resourceLocation2;
            this.f1343a = abstractC0879pr;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "name;baseTexture;capturingTexture;capturePoint", "FIELD:Lcom/boehmod/blockfront/cc$a;->a:Lnet/minecraft/util/FormattedCharSequence;", "FIELD:Lcom/boehmod/blockfront/cc$a;->ag:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/cc$a;->ah:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/cc$a;->a:Lcom/boehmod/blockfront/pr;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "name;baseTexture;capturingTexture;capturePoint", "FIELD:Lcom/boehmod/blockfront/cc$a;->a:Lnet/minecraft/util/FormattedCharSequence;", "FIELD:Lcom/boehmod/blockfront/cc$a;->ag:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/cc$a;->ah:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/cc$a;->a:Lcom/boehmod/blockfront/pr;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "name;baseTexture;capturingTexture;capturePoint", "FIELD:Lcom/boehmod/blockfront/cc$a;->a:Lnet/minecraft/util/FormattedCharSequence;", "FIELD:Lcom/boehmod/blockfront/cc$a;->ag:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/cc$a;->ah:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lcom/boehmod/blockfront/cc$a;->a:Lcom/boehmod/blockfront/pr;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public FormattedCharSequence m1048a() {
            return this.f1340a;
        }

        @NotNull
        /* JADX INFO: renamed from: g */
        public ResourceLocation m1049g() {
            return this.f1341ag;
        }

        @Nullable
        /* JADX INFO: renamed from: h */
        public ResourceLocation m1050h() {
            return this.f1342ah;
        }

        @NotNull
        /* JADX INFO: renamed from: a */
        public AbstractC0879pr<?> m1051a() {
            return this.f1343a;
        }
    }
}
