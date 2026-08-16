package com.boehmod.blockfront;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.platform.Window;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.ClientHooks;
import net.neoforged.neoforge.client.event.RenderFrameEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aD */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aD.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0034aD {

    /* JADX INFO: renamed from: o */
    @NotNull
    public static final ResourceLocation f291o;

    /* JADX INFO: renamed from: p */
    @NotNull
    public static final ResourceLocation f292p;

    /* JADX INFO: renamed from: q */
    @NotNull
    public static final ResourceLocation f293q;

    /* JADX INFO: renamed from: g */
    @NotNull
    private static final List<AbstractC0426hO> f294g;

    /* JADX INFO: renamed from: a */
    @Nullable
    public static GuiGraphics f295a;

    /* JADX INFO: renamed from: X */
    public static float f296X;

    /* JADX INFO: renamed from: Y */
    public static float f297Y;

    /* JADX INFO: renamed from: Z */
    public static float f298Z;

    /* JADX INFO: renamed from: aa */
    public static float f299aa;

    /* JADX INFO: renamed from: ab */
    public static float f300ab;

    /* JADX INFO: renamed from: ac */
    public static float f301ac;

    /* JADX INFO: renamed from: Y */
    static final /* synthetic */ boolean f302Y;

    static {
        f302Y = !C0034aD.class.desiredAssertionStatus();
        f291o = C0532jO.m2378d("textures/misc/bfalliesicon.png");
        f292p = C0532jO.m2378d("textures/misc/bfaxisicon.png");
        f293q = C0532jO.m2378d("textures/misc/bfneutralicon.png");
        f294g = (List) Util.make(new ObjectArrayList(), objectArrayList -> {
            objectArrayList.add(new C0428hQ());
            objectArrayList.add(new C0427hP());
            objectArrayList.add(new C0429hR());
        });
        f297Y = 0.0f;
        f299aa = 0.0f;
        f301ac = 0.0f;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m196a(RenderFrameEvent.Pre pre) {
        Minecraft minecraft = Minecraft.getInstance();
        f295a = new GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource());
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f302Y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
        if (abstractC0864pcM2878a != null && minecraft.player != null) {
            abstractC0864pcM2878a.m4142f(minecraft, minecraft.player);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m197a(RenderFrameEvent.Post post) {
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f302Y && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        GuiGraphics guiGraphics = new GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource());
        PoseStack poseStackPose = guiGraphics.pose();
        float gameTimeDeltaPartialTick = post.getPartialTick().getGameTimeDeltaPartialTick(false);
        float fM466g = C0129bt.m466g();
        poseStackPose.pushPose();
        poseStackPose.setIdentity();
        poseStackPose.translate(0.0f, 0.0f, 10000.0f - ClientHooks.getGuiFarPlane());
        RenderSystem.applyModelViewMatrix();
        Lighting.setupFor3DItems();
        boolean z = (clientLevel == null || localPlayer == null) ? false : true;
        C0555jl c0555jlM1886a = c0396gl.m1886a(minecraft);
        C0394gj c0394gjM1885a = c0396gl.m1885a(minecraft);
        Window window = minecraft.getWindow();
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        C0305f.m1652a(c0623lM2852b, window);
        if (z) {
            c0623lM2852b.m2895a().m3062a(minecraft, poseStackPose, guiGraphics, font, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        Iterator<AbstractC0426hO> it = f294g.iterator();
        while (it.hasNext()) {
            it.next().mo1973a(post, minecraft, localPlayer, clientLevel, guiGraphics.pose(), font, guiGraphics, c0623lM2852b, c0555jlM1886a, c0394gjM1885a, abstractC0863pbM2874a, iGuiWidth, iGuiHeight, z, fM466g, gameTimeDeltaPartialTick);
        }
        guiGraphics.flush();
        poseStackPose.popPose();
        RenderSystem.applyModelViewMatrix();
    }
}
