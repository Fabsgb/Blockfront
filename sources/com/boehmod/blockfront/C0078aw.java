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

/* JADX INFO: renamed from: com.boehmod.blockfront.aw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aw.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0078aw {

    /* JADX INFO: renamed from: o */
    @NotNull
    public static final ResourceLocation f469o;

    /* JADX INFO: renamed from: p */
    @NotNull
    public static final ResourceLocation f470p;

    /* JADX INFO: renamed from: q */
    @NotNull
    public static final ResourceLocation f471q;

    /* JADX INFO: renamed from: f */
    @NotNull
    private static final List<AbstractC0461hy> f472f;

    /* JADX INFO: renamed from: a */
    @Nullable
    public static GuiGraphics f473a;

    /* JADX INFO: renamed from: S */
    public static float f474S;

    /* JADX INFO: renamed from: T */
    public static float f475T;

    /* JADX INFO: renamed from: U */
    public static float f476U;

    /* JADX INFO: renamed from: V */
    public static float f477V;

    /* JADX INFO: renamed from: W */
    public static float f478W;

    /* JADX INFO: renamed from: X */
    public static float f479X;

    /* JADX INFO: renamed from: T */
    static final /* synthetic */ boolean f480T;

    static {
        f480T = !C0078aw.class.desiredAssertionStatus();
        f469o = C0564jv.m2555d("textures/misc/bfalliesicon.png");
        f470p = C0564jv.m2555d("textures/misc/bfaxisicon.png");
        f471q = C0564jv.m2555d("textures/misc/bfneutralicon.png");
        f472f = (List) Util.make(new ObjectArrayList(), objectArrayList -> {
            objectArrayList.add(new C0411hA());
            objectArrayList.add(new C0462hz());
            objectArrayList.add(new C0412hB());
        });
        f475T = 0.0f;
        f477V = 0.0f;
        f479X = 0.0f;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m269a(RenderFrameEvent.Pre pre) {
        Minecraft minecraft = Minecraft.getInstance();
        f473a = new GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource());
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f480T && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
        if (abstractC0788oGM2692a != null && minecraft.player != null) {
            abstractC0788oGM2692a.m3706e(minecraft, minecraft.player);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m270a(RenderFrameEvent.Post post) {
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f480T && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        GuiGraphics guiGraphics = new GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource());
        PoseStack poseStackPose = guiGraphics.pose();
        float gameTimeDeltaPartialTick = post.getPartialTick().getGameTimeDeltaPartialTick(false);
        float fM366g = C0119bk.m366g();
        poseStackPose.pushPose();
        poseStackPose.setIdentity();
        poseStackPose.translate(0.0f, 0.0f, 10000.0f - ClientHooks.getGuiFarPlane());
        RenderSystem.applyModelViewMatrix();
        Lighting.setupFor3DItems();
        boolean z = (clientLevel == null || localPlayer == null) ? false : true;
        C0482iS c0482iSM1676a = c0326fV.m1676a(minecraft);
        C0324fT c0324fTM1675a = c0326fV.m1675a(minecraft);
        Window window = minecraft.getWindow();
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        C0304f.m1599a(c0622lM2667b, window);
        if (z) {
            c0622lM2667b.m2709a().m3231a(minecraft, poseStackPose, guiGraphics, font, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        Iterator<AbstractC0461hy> it = f472f.iterator();
        while (it.hasNext()) {
            it.next().mo1948a(post, minecraft, localPlayer, clientLevel, guiGraphics.pose(), font, guiGraphics, c0622lM2667b, c0482iSM1676a, c0324fTM1675a, abstractC0787oFM2688a, iGuiWidth, iGuiHeight, z, fM366g, gameTimeDeltaPartialTick);
        }
        guiGraphics.flush();
        poseStackPose.popPose();
        RenderSystem.applyModelViewMatrix();
    }
}
