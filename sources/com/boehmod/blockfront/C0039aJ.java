package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nullable;
import net.minecraft.Util;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.aJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aJ.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0039aJ {

    /* JADX INFO: renamed from: h */
    @NotNull
    private static final List<AbstractC0044aO> f265h;

    /* JADX INFO: renamed from: ac */
    static final /* synthetic */ boolean f266ac;

    static {
        f266ac = !C0039aJ.class.desiredAssertionStatus();
        f265h = (List) Util.make(new ObjectArrayList(), objectArrayList -> {
            objectArrayList.add(new C0051aV());
            objectArrayList.add(new C0110bb());
            objectArrayList.add(new C0111bc());
            objectArrayList.add(new C0046aQ());
            objectArrayList.add(new C0048aS());
            objectArrayList.add(new C0054aY());
            objectArrayList.add(new C0112bd());
            objectArrayList.add(new C0053aX());
            objectArrayList.add(new C0050aU());
            objectArrayList.add(new C0055aZ());
            objectArrayList.add(new C0052aW());
            objectArrayList.add(new C0109ba());
            objectArrayList.add(new C0047aR());
            objectArrayList.add(new C0049aT());
            objectArrayList.add(new C0113be());
        });
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m193a(@NotNull ClientTickEvent.Pre pre) {
        Minecraft minecraft = Minecraft.getInstance();
        m195a(minecraft, minecraft.player);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m194b(@NotNull ClientTickEvent.Post post) {
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        float fM366g = C0119bk.m366g();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f266ac && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        C0324fT c0324fTM1675a = c0326fV.m1675a(minecraft);
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        m195a(minecraft, localPlayer);
        boolean zM2231a = c0622lM2667b.m2683a().m2231a(clientLevel, localPlayer);
        Camera mainCamera = minecraft.gameRenderer.getMainCamera();
        Vec3 position = mainCamera.getPosition();
        BlockPos blockPosition = mainCamera.getBlockPosition();
        C0482iS c0482iSM1676a = c0326fV.m1676a(minecraft);
        boolean z = (clientLevel == null || localPlayer == null) ? false : true;
        Iterator<AbstractC0044aO> it = f265h.iterator();
        while (it.hasNext()) {
            it.next().mo204a(post, threadLocalRandomCurrent, minecraft, c0326fV, c0622lM2667b, localPlayer, clientLevel, c0324fTM1675a, c0482iSM1676a, position, blockPosition, abstractC0787oFM2688a, zM2231a, fM366g);
        }
        C0300ew.m1590f(localPlayer);
        C0171cj.m1002a(minecraft, abstractC0787oFM2688a, localPlayer, c0324fTM1675a);
        c0622lM2667b.m2708b(minecraft);
    }

    /* JADX INFO: renamed from: a */
    private static void m195a(@NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer) {
        if (localPlayer != null && (localPlayer.getVehicle() instanceof AbstractC0779ny)) {
            minecraft.options.hideGui = false;
        }
    }
}
