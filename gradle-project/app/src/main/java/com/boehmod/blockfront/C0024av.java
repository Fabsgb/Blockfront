package com.boehmod.blockfront;

import com.boehmod.blockfront.C0040bk;
import com.boehmod.blockfront.common.player.f;
import com.boehmod.blockfront.tN;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.av, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/av.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0024av {
    private static final float L = 0.15f;
    private static final float M = 1.0f;
    private static final float N = 1.5f;
    private static final double u = 1.0d;
    private static final float O = 0.3f;
    private static final float P = 0.5f;
    private static final float Q = 0.35f;
    private static final float R = 0.15f;
    private static final double v = 2.0d;
    private static final double w = 10.0d;

    @NotNull
    private static final C0040bk.d a = C0040bk.d.a().a(1.0d).a(0.3f);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private static oY f50a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private static com.boehmod.blockfront.common.player.f f51a = null;
    private static int aR = 0;

    private C0024av() {
    }

    private static boolean b(@NotNull Player player) {
        Item item = (Item) wY.C.get();
        return player.getMainHandItem().getItem() == item || player.getOffhandItem().getItem() == item;
    }

    @SubscribeEvent
    public static void a(@NotNull InputEvent.InteractionKeyMappingTriggered interactionKeyMappingTriggered) {
        LocalPlayer localPlayer;
        if (interactionKeyMappingTriggered.isAttack() && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative() && b(localPlayer)) {
            tN.a.g(localPlayer);
            interactionKeyMappingTriggered.setSwingHand(false);
            interactionKeyMappingTriggered.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void a(@NotNull InputEvent.MouseButton.Pre pre) {
        LocalPlayer localPlayer;
        if (pre.getButton() == 2 && pre.getAction() == 1 && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative() && b(localPlayer)) {
            tN.a.h(localPlayer);
            pre.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void a(@NotNull ClientTickEvent.Post post) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        tN.a.a((Player) localPlayer, b(localPlayer));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @SubscribeEvent
    public static void a(@NotNull RenderLevelStageEvent renderLevelStageEvent) throws MatchException {
        Minecraft minecraft;
        LocalPlayer localPlayer;
        com.boehmod.blockfront.common.player.f fVarA;
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES && (localPlayer = (minecraft = Minecraft.getInstance()).player) != null && localPlayer.isCreative() && b(localPlayer) && (fVarA = tN.a.a((Player) localPlayer)) != null) {
            Camera mainCamera = minecraft.gameRenderer.getMainCamera();
            PoseStack poseStack = new PoseStack();
            poseStack.mulPose(renderLevelStageEvent.getPoseStack().last().pose());
            C0040bk.a(mainCamera, poseStack);
            int iDisplayColor = fVarA.a().displayColor();
            tN.a.b bVarA = tN.a.a();
            com.boehmod.blockfront.common.player.f fVar = fVarA;
            if (bVarA != null) {
                Vec3 vec3A = tN.a.a((Player) localPlayer, bVarA);
                com.boehmod.blockfront.common.player.f fVar2 = new com.boehmod.blockfront.common.player.f();
                fVar2.b(fVarA);
                bVarA.a(fVar2, vec3A);
                fVar = fVar2;
                Vec3 vec3A2 = bVarA.a(fVarA);
                if (vec3A2 != null) {
                    a(minecraft, poseStack, vec3A2, iDisplayColor, 0.5f);
                    C0040bk.a(mainCamera, poseStack, vec3A2, vec3A, 1.5f, iDisplayColor, iDisplayColor, 0.5f);
                }
            }
            if (fVarA.a() == f.a.AABB) {
                a(minecraft, mainCamera, poseStack, (Player) localPlayer, fVar, iDisplayColor, bVarA);
            } else {
                a(minecraft, mainCamera, poseStack, (Player) localPlayer, fVar, iDisplayColor, bVarA != null);
            }
        }
    }

    private static void a(@NotNull Minecraft minecraft, @NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Player player, @NotNull com.boehmod.blockfront.common.player.f fVar, int i, @Nullable tN.a.b bVar) {
        AABB aabb;
        float f;
        tN.a.b bVarM1147b;
        Vec3 vec3F = fVar.F();
        Vec3 vec3G = fVar.G();
        if (vec3F != null) {
            a(minecraft, poseStack, vec3F, i, 1.0f);
        }
        if (vec3G != null) {
            a(minecraft, poseStack, vec3G, i, 1.0f);
        }
        if (vec3F != null && vec3G != null) {
            aabb = new AABB(vec3F, vec3G);
            f = 1.0f;
        } else if (vec3F != null || vec3G != null) {
            aabb = new AABB(vec3F != null ? vec3F : vec3G, tN.a.b(player));
            f = 0.5f;
        } else {
            return;
        }
        C0040bk.a(camera, poseStack, aabb, a.a(i, 0.15f).a(i, 1.0f, 1.5f).b(f));
        if (bVar != null && bVar.m1148a() != null) {
            a(poseStack, aabb, bVar.m1148a(), i, 0.35f);
        } else if (vec3F != null && vec3G != null && (bVarM1147b = tN.a.m1147b(player, fVar)) != null && bVarM1147b.m1148a() != null) {
            a(poseStack, aabb, bVarM1147b.m1148a(), i, 0.15f);
        }
    }

    private static void a(@NotNull Minecraft minecraft, @NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Player player, @NotNull com.boehmod.blockfront.common.player.f fVar, int i, boolean z) {
        ObjectList<Vec3> objectListH = fVar.h();
        if (objectListH.isEmpty()) {
            return;
        }
        double dMin = Double.MAX_VALUE;
        double dMax = -1.7976931348623157E308d;
        ObjectListIterator it = objectListH.iterator();
        while (it.hasNext()) {
            Vec3 vec3 = (Vec3) it.next();
            a(minecraft, poseStack, vec3, i, 1.0f);
            dMin = Math.min(dMin, vec3.y);
            dMax = Math.max(dMax, vec3.y);
        }
        if (objectListH.size() >= 2) {
            C0040bk.a(camera, poseStack, a(fVar, z), dMin - 2.0d, dMax + w, a.a(i, 0.15f).a(i, 1.0f, 1.5f).b(1.0f));
        }
        Vec3 vec3H = fVar.H();
        if (vec3H != null && !z) {
            Vec3 vec3B = tN.a.b(player);
            C0040bk.a(camera, poseStack, vec3H, vec3B, 1.5f, i, i, 0.5f);
            Vec3 vec32 = (Vec3) objectListH.getFirst();
            if (objectListH.size() >= 2) {
                C0040bk.a(camera, poseStack, vec3B, vec32, 1.5f, i, i, 0.5f);
            }
        }
    }

    private static void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, int i, float f) {
        LevelRenderer.renderLineBox(poseStack, minecraft.renderBuffers().bufferSource().getBuffer(RenderType.lines()), new AABB(vec3.x - 0.2d, vec3.y - 0.2d, vec3.z - 0.2d, vec3.x + 0.2d, vec3.y + 0.2d, vec3.z + 0.2d), FastColor.ARGB32.red(i) / 255.0f, FastColor.ARGB32.green(i) / 255.0f, FastColor.ARGB32.blue(i) / 255.0f, f);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.av$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/av$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] c = new int[Direction.values().length];

        static {
            try {
                c[Direction.WEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                c[Direction.EAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                c[Direction.DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                c[Direction.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                c[Direction.NORTH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                c[Direction.SOUTH.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static void a(@NotNull PoseStack poseStack, @NotNull AABB aabb, @NotNull Direction direction, int i, float f) {
        switch (AnonymousClass1.c[direction.ordinal()]) {
            case 1:
                C0040bk.a(poseStack, aabb.minX, aabb.minY, aabb.minZ, aabb.minX, aabb.maxY, aabb.minZ, aabb.minX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.minY, aabb.maxZ, i, f);
                break;
            case 2:
                C0040bk.a(poseStack, aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ, aabb.maxX, aabb.minY, aabb.maxZ, i, f);
                break;
            case 3:
                C0040bk.a(poseStack, aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.maxZ, aabb.minX, aabb.minY, aabb.maxZ, i, f);
                break;
            case 4:
                C0040bk.a(poseStack, aabb.minX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.maxZ, i, f);
                break;
            case 5:
                C0040bk.a(poseStack, aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ, aabb.minX, aabb.maxY, aabb.minZ, i, f);
                break;
            case 6:
                C0040bk.a(poseStack, aabb.minX, aabb.minY, aabb.maxZ, aabb.maxX, aabb.minY, aabb.maxZ, aabb.maxX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.maxZ, i, f);
                break;
        }
    }

    @NotNull
    private static oY a(@NotNull com.boehmod.blockfront.common.player.f fVar, boolean z) {
        if (z || f50a == null || f51a != fVar || aR != fVar.cx()) {
            oY oYVar = new oY();
            ObjectListIterator it = fVar.h().iterator();
            while (it.hasNext()) {
                Vec3 vec3 = (Vec3) it.next();
                oYVar.a(new Vec2((float) vec3.x, (float) vec3.z));
            }
            f50a = oYVar;
            f51a = fVar;
            aR = fVar.cx();
        }
        return f50a;
    }

    @SubscribeEvent
    public static void a(@NotNull RenderGuiEvent.Post post) {
        com.boehmod.blockfront.common.player.f fVarA;
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || !localPlayer.isCreative() || !b(localPlayer) || (fVarA = tN.a.a((Player) localPlayer)) == null) {
            return;
        }
        f.a aVarA = fVarA.a();
        StringBuilder sbAppend = new StringBuilder("Mode: ").append(aVarA.displayName());
        if (aVarA == f.a.BOUNDARY) {
            sbAppend.append(" (").append(fVarA.h().size()).append(" points)");
        }
        tN.a.b bVarA = tN.a.a();
        if (bVarA != null) {
            sbAppend.append(bVarA.a() == tN.a.b.EnumC0001a.FACE ? " - moving face" : " - moving point");
        }
        GuiGraphics guiGraphics = post.getGuiGraphics();
        guiGraphics.drawCenteredString(minecraft.font, Component.literal(sbAppend.toString()), guiGraphics.guiWidth() / 2, (guiGraphics.guiHeight() / 2) + 12, aVarA.displayColor());
    }
}
