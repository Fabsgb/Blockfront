package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.p001mm.MatchParty;
import com.boehmod.bflib.cloud.packet.common.p002mm.PacketMMSearchHostCanceled;
import com.boehmod.bflib.common.ColorReferences;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.eC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/eC.class */
public final class C0255eC extends AbstractC0302ex {

    /* JADX INFO: renamed from: hF */
    @NotNull
    private static final Component f2090hF = Component.translatable("bf.message.bootcamp.description");

    /* JADX INFO: renamed from: hG */
    @NotNull
    private static final Component f2091hG = Component.translatable("bf.menu.lobby.search.start").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: hH */
    @NotNull
    private static final Component f2092hH = Component.translatable("bf.menu.lobby.search.cancel").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: hI */
    @NotNull
    private static final Component f2093hI = Component.translatable("bf.menu.lobby.cancel").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: hJ */
    @NotNull
    private static final Component f2094hJ = Component.translatable("bf.menu.lobby.search.bootcamp").withStyle(ChatFormatting.BOLD);

    /* JADX INFO: renamed from: ck */
    @NotNull
    private static final ResourceLocation f2095ck = C0532jO.m2378d("textures/gui/menu/button_green.png");

    /* JADX INFO: renamed from: cl */
    @NotNull
    private static final ResourceLocation f2096cl = C0532jO.m2378d("textures/gui/menu/button_green_hover.png");

    /* JADX INFO: renamed from: cm */
    @NotNull
    private static final ResourceLocation f2097cm = C0532jO.m2378d("textures/gui/menu/button_yellow.png");

    /* JADX INFO: renamed from: cn */
    @NotNull
    private static final ResourceLocation f2098cn = C0532jO.m2378d("textures/gui/menu/button_yellow_hover.png");

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0084bA f2099a;

    public C0255eC(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, Component.empty());
        this.f2099a = new C0084bA(Component.empty(), ((getX() + this.width) - 100) + 5, getY() + 7, 100, 24, button -> {
            m1450ay();
        });
        this.f2099a.m324a(0.0f, -1.0f);
        this.f2099a.m328a(C0085bB.a.SHADOW);
        this.f2099a.m310b(ColorReferences.COLOR_WHITE);
        this.f2099a.m318a((DeferredHolder<SoundEvent, SoundEvent>) null);
        this.f2099a.m314a(C0085bB.c.SHADOW);
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null) {
            m1447b(minecraft, c0623lM2852b, (C0396gl) c0623lM2852b.m2855a());
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0084bA m1446a() {
        return this.f2099a;
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    public void mo1443a(float f) {
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return;
        }
        m1447b(minecraft, c0623lM2852b, (C0396gl) c0623lM2852b.m2855a());
    }

    /* JADX INFO: renamed from: b */
    private void m1447b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl) {
        C0555jl c0555jlM1886a = c0396gl.m1886a(minecraft);
        m1449w(true);
        Optional<MatchParty> party = c0555jlM1886a.getParty();
        if (party.isPresent() && !party.get().isHost(minecraft.getUser().getProfileId())) {
            m1449w(false);
        }
        boolean zM2586c = c0623l.m2885a().m2586c();
        boolean z = (minecraft.screen instanceof C0246du) || zM2586c;
        Component component = zM2586c ? f2092hH : f2093hI;
        if (c0555jlM1886a.hasCompletedBootcamp()) {
            Component componentWithStyle = Component.literal((z ? component : f2091hG).getString().toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.BOLD);
            this.f2099a.m314a(C0085bB.c.SHADOW);
            this.f2099a.setHeight(24);
            this.f2099a.setMessage(componentWithStyle);
            this.f2099a.m328a(C0085bB.a.NONE);
            this.f2099a.m331a(f2095ck, f2096cl);
            this.f2099a.m310b(ColorReferences.COLOR_TEAM_ALLIES_SOLID);
        } else {
            Component componentWithStyle2 = Component.literal((z ? component : f2094hJ).getString().toUpperCase(Locale.ROOT)).withColor(0).withStyle(ChatFormatting.BOLD);
            this.f2099a.m314a(C0085bB.c.DEFAULT);
            this.f2099a.setHeight(16);
            this.f2099a.setMessage(componentWithStyle2);
            this.f2099a.m328a(C0085bB.a.NONE);
            this.f2099a.m331a(f2097cm, f2098cn);
            this.f2099a.m310b(ColorReferences.COLOR_THEME_YELLOW_SOLID);
        }
        if (!((C0358g) c0623l.m2852b()).m1722a().isConnected()) {
            m1449w(false);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0302ex
    /* JADX INFO: renamed from: a */
    protected void mo1440a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        if (!c0623l.m2870a().m2382ah() && ((C0358g) c0623l.m2852b()).m1722a().isConnected() && !c0555jl.hasCompletedBootcamp()) {
            m1448a(guiGraphics.pose(), guiGraphics, minecraft.font);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1448a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        int x = this.f2099a.getX() + (this.f2099a.getWidth() / 2);
        ObjectList<String> objectListM2458a = C0544ja.m2458a(font, f2090hF.getString(), (this.width - 10) * 2);
        Style styleWithColor = Style.EMPTY.withColor(ColorReferences.COLOR_THEME_YELLOW);
        int i = 0;
        ObjectListIterator it = objectListM2458a.iterator();
        while (it.hasNext()) {
            C0129bt.m491b(poseStack, font, guiGraphics, (Component) Component.literal((String) it.next()).withStyle(styleWithColor), x, getY() + 27 + (i * 5), 0.5f);
            i++;
        }
    }

    /* JADX INFO: renamed from: w */
    private void m1449w(boolean z) {
        this.f2099a.active = z;
        this.f2099a.visible = z;
    }

    /* JADX INFO: renamed from: ay */
    private void m1450ay() {
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null) {
            return;
        }
        C0555jl c0555jlM1886a = ((C0396gl) c0623lM2852b.m2855a()).m1886a(minecraft);
        C0570k c0570kM2885a = c0623lM2852b.m2885a();
        Optional<MatchParty> party = c0555jlM1886a.getParty();
        SoundManager soundManager = minecraft.getSoundManager();
        C0358g c0358g = (C0358g) c0623lM2852b.m2852b();
        if (c0570kM2885a.m2586c() || (party.isPresent() && party.get().isSearching())) {
            C0530jM.log("Attempting to cancel search for game...", new Object[0]);
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7963pk.get(), 1.0f));
            c0358g.sendPacket(new PacketMMSearchHostCanceled());
            c0570kM2885a.m2587a(false);
            return;
        }
        if (!c0555jlM1886a.hasCompletedBootcamp()) {
            minecraft.setScreen(new C0247dv(minecraft.screen).mo783a(true));
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 1.0f));
            return;
        }
        boolean z = minecraft.screen instanceof C0246du;
        if (z) {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7963pk.get(), 1.0f));
        } else {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7970pr.get(), 1.0f));
        }
        minecraft.setScreen(z ? new C0245dt() : new C0246du(minecraft.screen));
    }
}
