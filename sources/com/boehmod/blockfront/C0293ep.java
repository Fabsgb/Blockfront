package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p000mm.MatchParty;
import com.boehmod.bflib.cloud.packet.common.p001mm.PacketMMSearchHostCanceled;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0127bs;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Locale;
import java.util.Optional;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ep */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ep.class */
public final class C0293ep extends AbstractC0288ek {

    /* JADX INFO: renamed from: hw */
    @NotNull
    private static final Component f2220hw = Component.translatable("bf.message.bootcamp.description");

    /* JADX INFO: renamed from: hx */
    @NotNull
    private static final Component f2221hx = Component.translatable("bf.menu.lobby.search.start").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: hy */
    @NotNull
    private static final Component f2222hy = Component.translatable("bf.menu.lobby.search.cancel").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: hz */
    @NotNull
    private static final Component f2223hz = Component.translatable("bf.menu.lobby.cancel").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: hA */
    @NotNull
    private static final Component f2224hA = Component.translatable("bf.menu.lobby.search.bootcamp").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: cl */
    @NotNull
    private static final ResourceLocation f2225cl = C0564jv.m2555d("textures/gui/menu/button_green.png");

    /* JADX INFO: renamed from: cm */
    @NotNull
    private static final ResourceLocation f2226cm = C0564jv.m2555d("textures/gui/menu/button_green_hover.png");

    /* JADX INFO: renamed from: cn */
    @NotNull
    private static final ResourceLocation f2227cn = C0564jv.m2555d("textures/gui/menu/button_yellow.png");

    /* JADX INFO: renamed from: co */
    @NotNull
    private static final ResourceLocation f2228co = C0564jv.m2555d("textures/gui/menu/button_yellow_hover.png");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0126br f2229a;

    public C0293ep(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, Component.empty());
        this.f2229a = new C0126br(Component.empty(), ((getX() + this.width) - 100) + 5, getY() + 7, 100, 24, button -> {
            m1548at();
        });
        this.f2229a.m649a(0.0f, -1.0f);
        this.f2229a.m653a(C0127bs.a.SHADOW);
        this.f2229a.m635b(ColorReferences.COLOR_WHITE);
        this.f2229a.m643a((DeferredHolder<SoundEvent, SoundEvent>) null);
        this.f2229a.m639a(C0127bs.c.SHADOW);
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null) {
            m1545b(minecraft, c0622lM2667b, (C0326fV) c0622lM2667b.m2670a());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0126br m1544a() {
        return this.f2229a;
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    public void mo1519a(float f) {
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return;
        }
        m1545b(minecraft, c0622lM2667b, (C0326fV) c0622lM2667b.m2670a());
    }

    /* JADX INFO: renamed from: b */
    private void m1545b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV) {
        C0482iS c0482iSM1676a = c0326fV.m1676a(minecraft);
        m1547w(true);
        Optional<MatchParty> party = c0482iSM1676a.getParty();
        if (party.isPresent() && !party.get().isHost(minecraft.getUser().getProfileId())) {
            m1547w(false);
        }
        boolean zM2597c = c0622l.m2699a().m2597c();
        boolean z = (minecraft.screen instanceof C0236dl) || zM2597c;
        Component component = zM2597c ? f2222hy : f2223hz;
        if (c0482iSM1676a.hasCompletedBootcamp()) {
            Component componentWithStyle = Component.literal((z ? component : f2221hx).getString().toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.BOLD);
            this.f2229a.m639a(C0127bs.c.SHADOW);
            this.f2229a.setHeight(24);
            this.f2229a.setMessage(componentWithStyle);
            this.f2229a.m653a(C0127bs.a.NONE);
            this.f2229a.m656a(f2225cl, f2226cm);
            this.f2229a.m635b(ColorReferences.COLOR_TEAM_ALLIES_SOLID);
        } else {
            Component componentWithStyle2 = Component.literal((z ? component : f2224hA).getString().toUpperCase(Locale.ROOT)).withColor(0).withStyle(ChatFormatting.BOLD);
            this.f2229a.m639a(C0127bs.c.DEFAULT);
            this.f2229a.setHeight(16);
            this.f2229a.setMessage(componentWithStyle2);
            this.f2229a.m653a(C0127bs.a.NONE);
            this.f2229a.m656a(f2227cn, f2228co);
            this.f2229a.m635b(ColorReferences.COLOR_THEME_YELLOW_SOLID);
        }
        if (!((C0357g) c0622l.m2667b()).m1716a().isConnected()) {
            m1547w(false);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0288ek
    /* JADX INFO: renamed from: a */
    protected void mo1521a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        if (!c0622l.m2684a().m2558ad() && ((C0357g) c0622l.m2667b()).m1716a().isConnected() && !c0482iS.hasCompletedBootcamp()) {
            m1546a(guiGraphics.pose(), guiGraphics, minecraft.font);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1546a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        int x = this.f2229a.getX() + (this.f2229a.getWidth() / 2);
        ObjectList<String> objectListM2131a = C0471iH.m2131a(font, f2220hw.getString(), (this.width - 10) * 2);
        Style styleWithColor = Style.EMPTY.withColor(ColorReferences.COLOR_THEME_YELLOW);
        int i = 0;
        ObjectListIterator it = objectListM2131a.iterator();
        while (it.hasNext()) {
            C0119bk.m391b(poseStack, font, guiGraphics, (Component) Component.literal((String) it.next()).withStyle(styleWithColor), x, getY() + 27 + (i * 5), 0.5f);
            i++;
        }
    }

    /* JADX INFO: renamed from: w */
    private void m1547w(boolean z) {
        this.f2229a.active = z;
        this.f2229a.visible = z;
    }

    /* JADX INFO: renamed from: at */
    private void m1548at() {
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null) {
            return;
        }
        C0482iS c0482iSM1676a = ((C0326fV) c0622lM2667b.m2670a()).m1676a(minecraft);
        C0569k c0569kM2699a = c0622lM2667b.m2699a();
        Optional<MatchParty> party = c0482iSM1676a.getParty();
        SoundManager soundManager = minecraft.getSoundManager();
        C0357g c0357g = (C0357g) c0622lM2667b.m2667b();
        if (c0569kM2699a.m2597c() || (party.isPresent() && party.get().isSearching())) {
            C0562jt.log("Attempting to cancel search for game...", new Object[0]);
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7551pi.get(), 1.0f));
            c0357g.sendPacket(new PacketMMSearchHostCanceled());
            c0569kM2699a.m2598a(false);
            return;
        }
        if (!c0482iSM1676a.hasCompletedBootcamp()) {
            minecraft.setScreen(new C0237dm(minecraft.screen).m1182a(true));
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 1.0f));
            return;
        }
        boolean z = minecraft.screen instanceof C0236dl;
        if (z) {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7551pi.get(), 1.0f));
        } else {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7558pp.get(), 1.0f));
        }
        minecraft.setScreen(z ? new C0235dk() : new C0236dl(minecraft.screen));
    }
}
