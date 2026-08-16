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

/* JADX INFO: renamed from: com.boehmod.blockfront.aR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aR.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0048aR {

    /* JADX INFO: renamed from: i */
    @NotNull
    private static final List<AbstractC0053aW> f365i;

    /* JADX INFO: renamed from: ah */
    static final /* synthetic */ boolean f366ah;

    static {
        f366ah = !C0048aR.class.desiredAssertionStatus();
        f365i = (List) Util.make(new ObjectArrayList(), objectArrayList -> {
            objectArrayList.add(new C0113bd());
            objectArrayList.add(new C0119bj());
            objectArrayList.add(new C0120bk());
            objectArrayList.add(new C0055aY());
            objectArrayList.add(new C0110ba());
            objectArrayList.add(new C0116bg());
            objectArrayList.add(new C0121bl());
            objectArrayList.add(new C0115bf());
            objectArrayList.add(new C0112bc());
            objectArrayList.add(new C0117bh());
            objectArrayList.add(new C0114be());
            objectArrayList.add(new C0118bi());
            objectArrayList.add(new C0056aZ());
            objectArrayList.add(new C0111bb());
            objectArrayList.add(new C0122bm());
        });
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m235a(@NotNull ClientTickEvent.Pre pre) {
        Minecraft minecraft = Minecraft.getInstance();
        m237b(minecraft, minecraft.player);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: b */
    public static void m236b(@NotNull ClientTickEvent.Post post) {
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        float fM466g = C0129bt.m466g();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f366ah && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        C0394gj c0394gjM1885a = c0396gl.m1885a(minecraft);
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        m237b(minecraft, localPlayer);
        boolean zM2286a = c0623lM2852b.m2869a().m2286a(clientLevel, localPlayer);
        Camera mainCamera = minecraft.gameRenderer.getMainCamera();
        Vec3 position = mainCamera.getPosition();
        BlockPos blockPosition = mainCamera.getBlockPosition();
        C0555jl c0555jlM1886a = c0396gl.m1886a(minecraft);
        boolean z = (clientLevel == null || localPlayer == null) ? false : true;
        Iterator<AbstractC0053aW> it = f365i.iterator();
        while (it.hasNext()) {
            it.next().mo246a(post, threadLocalRandomCurrent, minecraft, c0396gl, c0623lM2852b, localPlayer, clientLevel, c0394gjM1885a, c0555jlM1886a, position, blockPosition, abstractC0863pbM2874a, zM2286a, fM466g);
        }
        C1154v.m6582a(minecraft, localPlayer);
        C0262eJ.m1494f(localPlayer);
        C0191cs.m1189a(minecraft, abstractC0863pbM2874a, localPlayer, c0394gjM1885a);
        c0623lM2852b.m2894b(minecraft);
    }

    /* JADX INFO: renamed from: b */
    private static void m237b(@NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer) {
        if (localPlayer != null && (localPlayer.getVehicle() instanceof AbstractC0750nU)) {
            minecraft.options.hideGui = false;
        }
    }
}
