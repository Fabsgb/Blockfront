package com.boehmod.blockfront;

import com.boehmod.blockfront.C0119bk;
import com.boehmod.blockfront.C1061tN;
import com.boehmod.blockfront.common.player.C0186f;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.av */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/av.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0077av {

    /* JADX INFO: renamed from: L */
    private static final float f454L = 0.15f;

    /* JADX INFO: renamed from: M */
    private static final float f455M = 1.0f;

    /* JADX INFO: renamed from: N */
    private static final float f456N = 1.5f;

    /* JADX INFO: renamed from: u */
    private static final double f457u = 1.0d;

    /* JADX INFO: renamed from: O */
    private static final float f458O = 0.3f;

    /* JADX INFO: renamed from: P */
    private static final float f459P = 0.5f;

    /* JADX INFO: renamed from: Q */
    private static final float f460Q = 0.35f;

    /* JADX INFO: renamed from: R */
    private static final float f461R = 0.15f;

    /* JADX INFO: renamed from: v */
    private static final double f462v = 2.0d;

    /* JADX INFO: renamed from: w */
    private static final double f463w = 10.0d;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final C0119bk.d f464a = C0119bk.d.m570a().m574a(1.0d).m578a(0.3f);

    /* JADX INFO: renamed from: a */
    @Nullable
    private static C0806oY f465a = null;

    /* JADX INFO: renamed from: a */
    @Nullable
    private static C0186f f466a = null;

    /* JADX INFO: renamed from: aR */
    private static int f467aR = 0;

    private C0077av() {
    }

    /* JADX INFO: renamed from: b */
    private static boolean m258b(@NotNull Player player) {
        Item item = (Item) C1231wY.f7132C.get();
        return player.getMainHandItem().getItem() == item || player.getOffhandItem().getItem() == item;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m259a(@NotNull InputEvent.InteractionKeyMappingTriggered interactionKeyMappingTriggered) {
        LocalPlayer localPlayer;
        if (interactionKeyMappingTriggered.isAttack() && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative() && m258b(localPlayer)) {
            C1061tN.a.m5903g(localPlayer);
            interactionKeyMappingTriggered.setSwingHand(false);
            interactionKeyMappingTriggered.setCanceled(true);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m260a(@NotNull InputEvent.MouseButton.Pre pre) {
        LocalPlayer localPlayer;
        if (pre.getButton() == 2 && pre.getAction() == 1 && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative() && m258b(localPlayer)) {
            C1061tN.a.m5904h(localPlayer);
            pre.setCanceled(true);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m261a(@NotNull ClientTickEvent.Post post) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        C1061tN.a.m5906a((Player) localPlayer, m258b(localPlayer));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m262a(@NotNull RenderLevelStageEvent renderLevelStageEvent) throws MatchException {
        Minecraft minecraft;
        LocalPlayer localPlayer;
        C0186f c0186fM5900a;
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES && (localPlayer = (minecraft = Minecraft.getInstance()).player) != null && localPlayer.isCreative() && m258b(localPlayer) && (c0186fM5900a = C1061tN.a.m5900a((Player) localPlayer)) != null) {
            Camera mainCamera = minecraft.gameRenderer.getMainCamera();
            PoseStack poseStack = new PoseStack();
            poseStack.mulPose(renderLevelStageEvent.getPoseStack().last().pose());
            C0119bk.m530a(mainCamera, poseStack);
            int iDisplayColor = c0186fM5900a.m1148a().displayColor();
            C1061tN.a.b bVarM5901a = C1061tN.a.m5901a();
            C0186f c0186f = c0186fM5900a;
            if (bVarM5901a != null) {
                Vec3 vec3M5908a = C1061tN.a.m5908a((Player) localPlayer, bVarM5901a);
                C0186f c0186f2 = new C0186f();
                c0186f2.m1167b(c0186fM5900a);
                bVarM5901a.m5922a(c0186f2, vec3M5908a);
                c0186f = c0186f2;
                Vec3 vec3M5921a = bVarM5901a.m5921a(c0186fM5900a);
                if (vec3M5921a != null) {
                    m265a(minecraft, poseStack, vec3M5921a, iDisplayColor, 0.5f);
                    C0119bk.m479a(mainCamera, poseStack, vec3M5921a, vec3M5908a, 1.5f, iDisplayColor, iDisplayColor, 0.5f);
                }
            }
            if (c0186fM5900a.m1148a() == C0186f.a.AABB) {
                m263a(minecraft, mainCamera, poseStack, (Player) localPlayer, c0186f, iDisplayColor, bVarM5901a);
            } else {
                m264a(minecraft, mainCamera, poseStack, (Player) localPlayer, c0186f, iDisplayColor, bVarM5901a != null);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m263a(@NotNull Minecraft minecraft, @NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Player player, @NotNull C0186f c0186f, int i, @Nullable C1061tN.a.b bVar) {
        AABB aabb;
        float f;
        C1061tN.a.b bVarM5913b;
        Vec3 vec3M1151F = c0186f.m1151F();
        Vec3 vec3M1152G = c0186f.m1152G();
        if (vec3M1151F != null) {
            m265a(minecraft, poseStack, vec3M1151F, i, 1.0f);
        }
        if (vec3M1152G != null) {
            m265a(minecraft, poseStack, vec3M1152G, i, 1.0f);
        }
        if (vec3M1151F != null && vec3M1152G != null) {
            aabb = new AABB(vec3M1151F, vec3M1152G);
            f = 1.0f;
        } else if (vec3M1151F != null || vec3M1152G != null) {
            aabb = new AABB(vec3M1151F != null ? vec3M1151F : vec3M1152G, C1061tN.a.m5916b(player));
            f = 0.5f;
        } else {
            return;
        }
        C0119bk.m483a(camera, poseStack, aabb, f464a.m571a(i, 0.15f).m572a(i, 1.0f, 1.5f).m580b(f));
        if (bVar != null && bVar.m5925a() != null) {
            m266a(poseStack, aabb, bVar.m5925a(), i, 0.35f);
        } else if (vec3M1151F != null && vec3M1152G != null && (bVarM5913b = C1061tN.a.m5913b(player, c0186f)) != null && bVarM5913b.m5925a() != null) {
            m266a(poseStack, aabb, bVarM5913b.m5925a(), i, 0.15f);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m264a(@NotNull Minecraft minecraft, @NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Player player, @NotNull C0186f c0186f, int i, boolean z) {
        ObjectList<Vec3> objectListM1155h = c0186f.m1155h();
        if (objectListM1155h.isEmpty()) {
            return;
        }
        double dMin = Double.MAX_VALUE;
        double dMax = -1.7976931348623157E308d;
        ObjectListIterator it = objectListM1155h.iterator();
        while (it.hasNext()) {
            Vec3 vec3 = (Vec3) it.next();
            m265a(minecraft, poseStack, vec3, i, 1.0f);
            dMin = Math.min(dMin, vec3.y);
            dMax = Math.max(dMax, vec3.y);
        }
        if (objectListM1155h.size() >= 2) {
            C0119bk.m477a(camera, poseStack, m267a(c0186f, z), dMin - 2.0d, dMax + f463w, f464a.m571a(i, 0.15f).m572a(i, 1.0f, 1.5f).m580b(1.0f));
        }
        Vec3 vec3M1160H = c0186f.m1160H();
        if (vec3M1160H != null && !z) {
            Vec3 vec3M5916b = C1061tN.a.m5916b(player);
            C0119bk.m479a(camera, poseStack, vec3M1160H, vec3M5916b, 1.5f, i, i, 0.5f);
            Vec3 vec32 = (Vec3) objectListM1155h.getFirst();
            if (objectListM1155h.size() >= 2) {
                C0119bk.m479a(camera, poseStack, vec3M5916b, vec32, 1.5f, i, i, 0.5f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m265a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, int i, float f) {
        LevelRenderer.renderLineBox(poseStack, minecraft.renderBuffers().bufferSource().getBuffer(RenderType.lines()), new AABB(vec3.x - 0.2d, vec3.y - 0.2d, vec3.z - 0.2d, vec3.x + 0.2d, vec3.y + 0.2d, vec3.z + 0.2d), FastColor.ARGB32.red(i) / 255.0f, FastColor.ARGB32.green(i) / 255.0f, FastColor.ARGB32.blue(i) / 255.0f, f);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.av$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/av$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: c */
        static final /* synthetic */ int[] f468c = new int[Direction.values().length];

        static {
            try {
                f468c[Direction.WEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f468c[Direction.EAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f468c[Direction.DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f468c[Direction.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f468c[Direction.NORTH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f468c[Direction.SOUTH.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m266a(@NotNull PoseStack poseStack, @NotNull AABB aabb, @NotNull Direction direction, int i, float f) {
        switch (AnonymousClass1.f468c[direction.ordinal()]) {
            case 1:
                C0119bk.m482a(poseStack, aabb.minX, aabb.minY, aabb.minZ, aabb.minX, aabb.maxY, aabb.minZ, aabb.minX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.minY, aabb.maxZ, i, f);
                break;
            case 2:
                C0119bk.m482a(poseStack, aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ, aabb.maxX, aabb.minY, aabb.maxZ, i, f);
                break;
            case 3:
                C0119bk.m482a(poseStack, aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.maxZ, aabb.minX, aabb.minY, aabb.maxZ, i, f);
                break;
            case 4:
                C0119bk.m482a(poseStack, aabb.minX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.maxZ, i, f);
                break;
            case 5:
                C0119bk.m482a(poseStack, aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ, aabb.minX, aabb.maxY, aabb.minZ, i, f);
                break;
            case 6:
                C0119bk.m482a(poseStack, aabb.minX, aabb.minY, aabb.maxZ, aabb.maxX, aabb.minY, aabb.maxZ, aabb.maxX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.maxZ, i, f);
                break;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C0806oY m267a(@NotNull C0186f c0186f, boolean z) {
        if (z || f465a == null || f466a != c0186f || f467aR != c0186f.m1150cx()) {
            C0806oY c0806oY = new C0806oY();
            ObjectListIterator it = c0186f.m1155h().iterator();
            while (it.hasNext()) {
                Vec3 vec3 = (Vec3) it.next();
                c0806oY.m4165a(new Vec2((float) vec3.x, (float) vec3.z));
            }
            f465a = c0806oY;
            f466a = c0186f;
            f467aR = c0186f.m1150cx();
        }
        return f465a;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m268a(@NotNull RenderGuiEvent.Post post) {
        C0186f c0186fM5900a;
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || !localPlayer.isCreative() || !m258b(localPlayer) || (c0186fM5900a = C1061tN.a.m5900a((Player) localPlayer)) == null) {
            return;
        }
        C0186f.a aVarM1148a = c0186fM5900a.m1148a();
        StringBuilder sbAppend = new StringBuilder("Mode: ").append(aVarM1148a.displayName());
        if (aVarM1148a == C0186f.a.BOUNDARY) {
            sbAppend.append(" (").append(c0186fM5900a.m1155h().size()).append(" points)");
        }
        C1061tN.a.b bVarM5901a = C1061tN.a.m5901a();
        if (bVarM5901a != null) {
            sbAppend.append(bVarM5901a.m5923a() == C1061tN.a.b.EnumC1480a.FACE ? " - moving face" : " - moving point");
        }
        GuiGraphics guiGraphics = post.getGuiGraphics();
        guiGraphics.drawCenteredString(minecraft.font, Component.literal(sbAppend.toString()), guiGraphics.guiWidth() / 2, (guiGraphics.guiHeight() / 2) + 12, aVarM1148a.displayColor());
    }
}
