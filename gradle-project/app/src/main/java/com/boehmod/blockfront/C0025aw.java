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

/* JADX INFO: renamed from: com.boehmod.blockfront.aw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aw.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0025aw {

    @NotNull
    public static final ResourceLocation o;

    @NotNull
    public static final ResourceLocation p;

    @NotNull
    public static final ResourceLocation q;

    @NotNull
    private static final List<AbstractC0215hy> f;

    @Nullable
    public static GuiGraphics a;
    public static float S;
    public static float T;
    public static float U;
    public static float V;
    public static float W;
    public static float X;

    /* JADX INFO: renamed from: T, reason: collision with other field name */
    static final /* synthetic */ boolean f52T;

    static {
        f52T = !C0025aw.class.desiredAssertionStatus();
        o = C0265jv.d("textures/misc/bfalliesicon.png");
        p = C0265jv.d("textures/misc/bfaxisicon.png");
        q = C0265jv.d("textures/misc/bfneutralicon.png");
        f = (List) Util.make(new ObjectArrayList(), objectArrayList -> {
            objectArrayList.add(new hA());
            objectArrayList.add(new C0216hz());
            objectArrayList.add(new hB());
        });
        T = 0.0f;
        V = 0.0f;
        X = 0.0f;
    }

    @SubscribeEvent
    public static void a(RenderFrameEvent.Pre pre) {
        Minecraft minecraft = Minecraft.getInstance();
        a = new GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource());
        C0297l c0297lB = C0297l.b();
        if (!f52T && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oG<?, ?> oGVarM593a = c0297lB.m593a();
        if (oGVarM593a != null && minecraft.player != null) {
            oGVarM593a.e(minecraft, minecraft.player);
        }
    }

    @SubscribeEvent
    public static void a(RenderFrameEvent.Post post) {
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        C0297l c0297lB = C0297l.b();
        if (!f52T && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        fV fVVar = (fV) c0297lB.a();
        GuiGraphics guiGraphics = new GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource());
        PoseStack poseStackPose = guiGraphics.pose();
        float gameTimeDeltaPartialTick = post.getPartialTick().getGameTimeDeltaPartialTick(false);
        float fG = C0040bk.g();
        poseStackPose.pushPose();
        poseStackPose.setIdentity();
        poseStackPose.translate(0.0f, 0.0f, 10000.0f - ClientHooks.getGuiFarPlane());
        RenderSystem.applyModelViewMatrix();
        Lighting.setupFor3DItems();
        boolean z = (clientLevel == null || localPlayer == null) ? false : true;
        iS iSVarM404a = fVVar.m404a(minecraft);
        fT fTVarA = fVVar.a(minecraft);
        Window window = minecraft.getWindow();
        int iGuiWidth = guiGraphics.guiWidth();
        int iGuiHeight = guiGraphics.guiHeight();
        C0136f.a(c0297lB, window);
        if (z) {
            c0297lB.m602a().a(minecraft, poseStackPose, guiGraphics, font, iGuiWidth, iGuiHeight, gameTimeDeltaPartialTick);
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        Iterator<AbstractC0215hy> it = f.iterator();
        while (it.hasNext()) {
            it.next().a(post, minecraft, localPlayer, clientLevel, guiGraphics.pose(), font, guiGraphics, c0297lB, iSVarM404a, fTVarA, oFVarM591a, iGuiWidth, iGuiHeight, z, fG, gameTimeDeltaPartialTick);
        }
        guiGraphics.flush();
        poseStackPose.popPose();
        RenderSystem.applyModelViewMatrix();
    }
}
