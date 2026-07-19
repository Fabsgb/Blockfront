package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.mm.MatchParty;
import com.boehmod.bflib.cloud.packet.common.mm.PacketMMSearchHostCanceled;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0048bs;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ep, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ep.class */
public final class C0125ep extends AbstractC0120ek {

    @NotNull
    private static final Component hw = Component.translatable("bf.message.bootcamp.description");

    @NotNull
    private static final Component hx = Component.translatable("bf.menu.lobby.search.start").withStyle(ChatFormatting.BOLD);

    @NotNull
    private static final Component hy = Component.translatable("bf.menu.lobby.search.cancel").withStyle(ChatFormatting.BOLD);

    @NotNull
    private static final Component hz = Component.translatable("bf.menu.lobby.cancel").withStyle(ChatFormatting.BOLD);

    @NotNull
    private static final Component hA = Component.translatable("bf.menu.lobby.search.bootcamp").withStyle(ChatFormatting.BOLD);

    @NotNull
    private static final ResourceLocation cl = C0265jv.d("textures/gui/menu/button_green.png");

    @NotNull
    private static final ResourceLocation cm = C0265jv.d("textures/gui/menu/button_green_hover.png");

    @NotNull
    private static final ResourceLocation cn = C0265jv.d("textures/gui/menu/button_yellow.png");

    @NotNull
    private static final ResourceLocation co = C0265jv.d("textures/gui/menu/button_yellow_hover.png");

    @NotNull
    private final C0047br a;

    public C0125ep(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4, Component.empty());
        this.a = new C0047br(Component.empty(), ((getX() + this.width) - 100) + 5, getY() + 7, 100, 24, button -> {
            at();
        });
        this.a.a(0.0f, -1.0f);
        this.a.a(C0048bs.a.SHADOW);
        this.a.b(ColorReferences.COLOR_WHITE);
        this.a.a((DeferredHolder<SoundEvent, SoundEvent>) null);
        this.a.a(C0048bs.c.SHADOW);
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null) {
            b(minecraft, c0297lB, (fV) c0297lB.a());
        }
    }

    @NotNull
    public C0047br a() {
        return this.a;
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    public void a(float f) {
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return;
        }
        b(minecraft, c0297lB, (fV) c0297lB.a());
    }

    private void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar) {
        iS iSVarM404a = fVVar.m404a(minecraft);
        w(true);
        Optional<MatchParty> party = iSVarM404a.getParty();
        if (party.isPresent() && !party.get().isHost(minecraft.getUser().getProfileId())) {
            w(false);
        }
        boolean zM544c = c0297l.m596a().m544c();
        boolean z = (minecraft.screen instanceof C0095dl) || zM544c;
        Component component = zM544c ? hy : hz;
        if (iSVarM404a.hasCompletedBootcamp()) {
            Component componentWithStyle = Component.literal((z ? component : hx).getString().toUpperCase(Locale.ROOT)).withStyle(ChatFormatting.BOLD);
            this.a.a(C0048bs.c.SHADOW);
            this.a.setHeight(24);
            this.a.setMessage(componentWithStyle);
            this.a.a(C0048bs.a.NONE);
            this.a.a(cl, cm);
            this.a.b(ColorReferences.COLOR_TEAM_ALLIES_SOLID);
        } else {
            Component componentWithStyle2 = Component.literal((z ? component : hA).getString().toUpperCase(Locale.ROOT)).withColor(0).withStyle(ChatFormatting.BOLD);
            this.a.a(C0048bs.c.DEFAULT);
            this.a.setHeight(16);
            this.a.setMessage(componentWithStyle2);
            this.a.a(C0048bs.a.NONE);
            this.a.a(cn, co);
            this.a.b(ColorReferences.COLOR_THEME_YELLOW_SOLID);
        }
        if (!((C0163g) c0297l.b()).a().isConnected()) {
            w(false);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0120ek
    protected void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull iS iSVar, @NotNull GuiGraphics guiGraphics, int i, int i2, float f, float f2) {
        if (!c0297l.m588a().ad() && ((C0163g) c0297l.b()).a().isConnected() && !iSVar.hasCompletedBootcamp()) {
            a(guiGraphics.pose(), guiGraphics, minecraft.font);
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        int x = this.a.getX() + (this.a.getWidth() / 2);
        ObjectList<String> objectListA = iH.a(font, hw.getString(), (this.width - 10) * 2);
        Style styleWithColor = Style.EMPTY.withColor(ColorReferences.COLOR_THEME_YELLOW);
        int i = 0;
        ObjectListIterator it = objectListA.iterator();
        while (it.hasNext()) {
            C0040bk.b(poseStack, font, guiGraphics, (Component) Component.literal((String) it.next()).withStyle(styleWithColor), x, getY() + 27 + (i * 5), 0.5f);
            i++;
        }
    }

    private void w(boolean z) {
        this.a.active = z;
        this.a.visible = z;
    }

    private void at() {
        Minecraft minecraft = Minecraft.getInstance();
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null) {
            return;
        }
        iS iSVarM404a = ((fV) c0297lB.a()).m404a(minecraft);
        C0270k c0270kM596a = c0297lB.m596a();
        Optional<MatchParty> party = iSVarM404a.getParty();
        SoundManager soundManager = minecraft.getSoundManager();
        C0163g c0163g = (C0163g) c0297lB.b();
        if (c0270kM596a.m544c() || (party.isPresent() && party.get().isSearching())) {
            C0263jt.log("Attempting to cancel search for game...", new Object[0]);
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pi.get(), 1.0f));
            c0163g.sendPacket(new PacketMMSearchHostCanceled());
            c0270kM596a.a(false);
            return;
        }
        if (!iSVarM404a.hasCompletedBootcamp()) {
            minecraft.setScreen(new C0096dm(minecraft.screen).a(true));
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 1.0f));
            return;
        }
        boolean z = minecraft.screen instanceof C0095dl;
        if (z) {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pi.get(), 1.0f));
        } else {
            soundManager.play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pp.get(), 1.0f));
        }
        minecraft.setScreen(z ? new C0094dk() : new C0095dl(minecraft.screen));
    }
}
