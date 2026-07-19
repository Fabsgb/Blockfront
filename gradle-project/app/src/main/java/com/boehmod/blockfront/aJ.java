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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/aJ.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class aJ {

    @NotNull
    private static final List<aO> h;
    static final /* synthetic */ boolean ac;

    static {
        ac = !aJ.class.desiredAssertionStatus();
        h = (List) Util.make(new ObjectArrayList(), objectArrayList -> {
            objectArrayList.add(new aV());
            objectArrayList.add(new C0031bb());
            objectArrayList.add(new C0032bc());
            objectArrayList.add(new aQ());
            objectArrayList.add(new aS());
            objectArrayList.add(new aY());
            objectArrayList.add(new C0033bd());
            objectArrayList.add(new aX());
            objectArrayList.add(new aU());
            objectArrayList.add(new aZ());
            objectArrayList.add(new aW());
            objectArrayList.add(new C0030ba());
            objectArrayList.add(new aR());
            objectArrayList.add(new aT());
            objectArrayList.add(new C0034be());
        });
    }

    @SubscribeEvent
    public static void a(@NotNull ClientTickEvent.Pre pre) {
        Minecraft minecraft = Minecraft.getInstance();
        a(minecraft, minecraft.player);
    }

    @SubscribeEvent
    public static void b(@NotNull ClientTickEvent.Post post) {
        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        float fG = C0040bk.g();
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        C0297l c0297lB = C0297l.b();
        if (!ac && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        fV fVVar = (fV) c0297lB.a();
        fT fTVarA = fVVar.a(minecraft);
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        a(minecraft, localPlayer);
        boolean zA = c0297lB.m587a().a(clientLevel, localPlayer);
        Camera mainCamera = minecraft.gameRenderer.getMainCamera();
        Vec3 position = mainCamera.getPosition();
        BlockPos blockPosition = mainCamera.getBlockPosition();
        iS iSVarM404a = fVVar.m404a(minecraft);
        boolean z = (clientLevel == null || localPlayer == null) ? false : true;
        Iterator<aO> it = h.iterator();
        while (it.hasNext()) {
            it.next().a(post, threadLocalRandomCurrent, minecraft, fVVar, c0297lB, localPlayer, clientLevel, fTVarA, iSVarM404a, position, blockPosition, oFVarM591a, zA, fG);
        }
        C0132ew.f(localPlayer);
        C0066cj.a(minecraft, oFVarM591a, localPlayer, fTVarA);
        c0297lB.b(minecraft);
    }

    private static void a(@NotNull Minecraft minecraft, @Nullable LocalPlayer localPlayer) {
        if (localPlayer != null && (localPlayer.getVehicle() instanceof AbstractC0376ny)) {
            minecraft.options.hideGui = false;
        }
    }
}
