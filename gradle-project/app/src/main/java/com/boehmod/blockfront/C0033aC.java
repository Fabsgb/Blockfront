package com.boehmod.blockfront;

import com.boehmod.blockfront.common.player.C0187f;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.aC */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aC.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public final class C0033aC {

    /* JADX INFO: renamed from: Q */
    private static final float f276Q = 0.15f;

    /* JADX INFO: renamed from: R */
    private static final float f277R = 1.0f;

    /* JADX INFO: renamed from: S */
    private static final float f278S = 1.5f;

    /* JADX INFO: renamed from: B */
    private static final double f279B = 1.0d;

    /* JADX INFO: renamed from: T */
    private static final float f280T = 0.3f;

    /* JADX INFO: renamed from: U */
    private static final float f281U = 0.5f;

    /* JADX INFO: renamed from: V */
    private static final float f282V = 0.35f;

    /* JADX INFO: renamed from: W */
    private static final float f283W = 0.15f;

    /* JADX INFO: renamed from: C */
    private static final double f284C = 2.0d;

    /* JADX INFO: renamed from: D */
    private static final double f285D = 10.0d;

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final C0129bt.d f286a = C0129bt.d.m675a().m679a(1.0d).m683a(0.3f);

    /* JADX INFO: renamed from: a */
    @Nullable
    private static C0882pu f287a = null;

    /* JADX INFO: renamed from: a */
    @Nullable
    private static C0187f f288a = null;

    /* JADX INFO: renamed from: bF */
    private static int f289bF = 0;

    private C0033aC() {
    }

    /* JADX INFO: renamed from: b */
    private static boolean m185b(@NotNull Player player) {
        Item item = (Item) C1308xv.f7697C.get();
        return player.getMainHandItem().getItem() == item || player.getOffhandItem().getItem() == item;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m186a(@NotNull InputEvent.InteractionKeyMappingTriggered interactionKeyMappingTriggered) {
        LocalPlayer localPlayer;
        if (interactionKeyMappingTriggered.isAttack() && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative() && m185b(localPlayer)) {
            C1139ul.a.m6538g(localPlayer);
            interactionKeyMappingTriggered.setSwingHand(false);
            interactionKeyMappingTriggered.setCanceled(true);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m187a(@NotNull InputEvent.MouseButton.Pre pre) {
        LocalPlayer localPlayer;
        if (pre.getButton() == 2 && pre.getAction() == 1 && (localPlayer = Minecraft.getInstance().player) != null && localPlayer.isCreative() && m185b(localPlayer)) {
            C1139ul.a.m6539h(localPlayer);
            pre.setCanceled(true);
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m188a(@NotNull ClientTickEvent.Post post) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        C1139ul.a.m6541a((Player) localPlayer, m185b(localPlayer));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m189a(@NotNull RenderLevelStageEvent renderLevelStageEvent) throws MatchException {
        Minecraft minecraft;
        LocalPlayer localPlayer;
        C0187f c0187fM6535a;
        if (renderLevelStageEvent.getStage() == RenderLevelStageEvent.Stage.AFTER_PARTICLES && (localPlayer = (minecraft = Minecraft.getInstance()).player) != null && localPlayer.isCreative() && m185b(localPlayer) && (c0187fM6535a = C1139ul.a.m6535a((Player) localPlayer)) != null) {
            Camera mainCamera = minecraft.gameRenderer.getMainCamera();
            PoseStack poseStack = new PoseStack();
            poseStack.mulPose(renderLevelStageEvent.getPoseStack().last().pose());
            C0129bt.m632a(mainCamera, poseStack);
            int iDisplayColor = c0187fM6535a.m1165a().displayColor();
            C1139ul.a.b bVarM6536a = C1139ul.a.m6536a();
            C0187f c0187f = c0187fM6535a;
            if (bVarM6536a != null) {
                Vec3 vec3M6543a = C1139ul.a.m6543a((Player) localPlayer, bVarM6536a);
                C0187f c0187f2 = new C0187f();
                c0187f2.m1184b(c0187fM6535a);
                bVarM6536a.m6557a(c0187f2, vec3M6543a);
                c0187f = c0187f2;
                Vec3 vec3M6556a = bVarM6536a.m6556a(c0187fM6535a);
                if (vec3M6556a != null) {
                    m192a(minecraft, poseStack, vec3M6556a, iDisplayColor, 0.5f);
                    C0129bt.m579a(mainCamera, poseStack, vec3M6556a, vec3M6543a, 1.5f, iDisplayColor, iDisplayColor, 0.5f);
                }
            }
            if (c0187fM6535a.m1165a() == C0187f.a.AABB) {
                m190a(minecraft, mainCamera, poseStack, (Player) localPlayer, c0187f, iDisplayColor, bVarM6536a);
            } else {
                m191a(minecraft, mainCamera, poseStack, (Player) localPlayer, c0187f, iDisplayColor, bVarM6536a != null);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m190a(@NotNull Minecraft minecraft, @NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Player player, @NotNull C0187f c0187f, int i, @Nullable C1139ul.a.b bVar) {
        AABB aabb;
        float f;
        C1139ul.a.b bVarM6548b;
        Vec3 vec3M1168G = c0187f.m1168G();
        Vec3 vec3M1169H = c0187f.m1169H();
        if (vec3M1168G != null) {
            m192a(minecraft, poseStack, vec3M1168G, i, 1.0f);
        }
        if (vec3M1169H != null) {
            m192a(minecraft, poseStack, vec3M1169H, i, 1.0f);
        }
        if (vec3M1168G != null && vec3M1169H != null) {
            aabb = new AABB(vec3M1168G, vec3M1169H);
            f = 1.0f;
        } else if (vec3M1168G != null || vec3M1169H != null) {
            aabb = new AABB(vec3M1168G != null ? vec3M1168G : vec3M1169H, C1139ul.a.m6551b(player));
            f = 0.5f;
        } else {
            return;
        }
        C0129bt.m583a(camera, poseStack, aabb, f286a.m676a(i, 0.15f).m677a(i, 1.0f, 1.5f).m685b(f));
        if (bVar != null && bVar.m6560a() != null) {
            m193a(poseStack, aabb, bVar.m6560a(), i, 0.35f);
        } else if (vec3M1168G != null && vec3M1169H != null && (bVarM6548b = C1139ul.a.m6548b(player, c0187f)) != null && bVarM6548b.m6560a() != null) {
            m193a(poseStack, aabb, bVarM6548b.m6560a(), i, 0.15f);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m191a(@NotNull Minecraft minecraft, @NotNull Camera camera, @NotNull PoseStack poseStack, @NotNull Player player, @NotNull C0187f c0187f, int i, boolean z) {
        ObjectList<Vec3> objectListM1172l = c0187f.m1172l();
        if (objectListM1172l.isEmpty()) {
            return;
        }
        double dMin = Double.MAX_VALUE;
        double dMax = -1.7976931348623157E308d;
        ObjectListIterator it = objectListM1172l.iterator();
        while (it.hasNext()) {
            Vec3 vec3 = (Vec3) it.next();
            m192a(minecraft, poseStack, vec3, i, 1.0f);
            dMin = Math.min(dMin, vec3.y);
            dMax = Math.max(dMax, vec3.y);
        }
        if (objectListM1172l.size() >= 2) {
            C0129bt.m577a(camera, poseStack, m194a(c0187f, z), dMin - 2.0d, dMax + f285D, f286a.m676a(i, 0.15f).m677a(i, 1.0f, 1.5f).m685b(1.0f));
        }
        Vec3 vec3M1177I = c0187f.m1177I();
        if (vec3M1177I != null && !z) {
            Vec3 vec3M6551b = C1139ul.a.m6551b(player);
            C0129bt.m579a(camera, poseStack, vec3M1177I, vec3M6551b, 1.5f, i, i, 0.5f);
            Vec3 vec4 = (Vec3) objectListM1172l.getFirst();
            if (objectListM1172l.size() >= 2) {
                C0129bt.m579a(camera, poseStack, vec3M6551b, vec4, 1.5f, i, i, 0.5f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m192a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull Vec3 vec3, int i, float f) {
        LevelRenderer.renderLineBox(poseStack, minecraft.renderBuffers().bufferSource().getBuffer(RenderType.lines()), new AABB(vec3.x - 0.2d, vec3.y - 0.2d, vec3.z - 0.2d, vec3.x + 0.2d, vec3.y + 0.2d, vec3.z + 0.2d), FastColor.ARGB32.red(i) / 255.0f, FastColor.ARGB32.green(i) / 255.0f, FastColor.ARGB32.blue(i) / 255.0f, f);
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.aC$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/aC$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: e */
        static final /* synthetic */ int[] f290e = new int[Direction.values().length];

        static {
            try {
                f290e[Direction.WEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f290e[Direction.EAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f290e[Direction.DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f290e[Direction.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f290e[Direction.NORTH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f290e[Direction.SOUTH.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m193a(@NotNull PoseStack poseStack, @NotNull AABB aabb, @NotNull Direction direction, int i, float f) {
        switch (AnonymousClass1.f290e[direction.ordinal()]) {
            case 1:
                C0129bt.m582a(poseStack, aabb.minX, aabb.minY, aabb.minZ, aabb.minX, aabb.maxY, aabb.minZ, aabb.minX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.minY, aabb.maxZ, i, f);
                break;
            case 2:
                C0129bt.m582a(poseStack, aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ, aabb.maxX, aabb.minY, aabb.maxZ, i, f);
                break;
            case 3:
                C0129bt.m582a(poseStack, aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.maxZ, aabb.minX, aabb.minY, aabb.maxZ, i, f);
                break;
            case 4:
                C0129bt.m582a(poseStack, aabb.minX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.maxZ, i, f);
                break;
            case 5:
                C0129bt.m582a(poseStack, aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.minZ, aabb.minX, aabb.maxY, aabb.minZ, i, f);
                break;
            case 6:
                C0129bt.m582a(poseStack, aabb.minX, aabb.minY, aabb.maxZ, aabb.maxX, aabb.minY, aabb.maxZ, aabb.maxX, aabb.maxY, aabb.maxZ, aabb.minX, aabb.maxY, aabb.maxZ, i, f);
                break;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static C0882pu m194a(@NotNull C0187f c0187f, boolean z) {
        if (z || f287a == null || f288a != c0187f || f289bF != c0187f.m1167cN()) {
            C0882pu c0882pu = new C0882pu();
            ObjectListIterator it = c0187f.m1172l().iterator();
            while (it.hasNext()) {
                Vec3 vec3 = (Vec3) it.next();
                c0882pu.m4602a(new Vec2((float) vec3.x, (float) vec3.z));
            }
            f287a = c0882pu;
            f288a = c0187f;
            f289bF = c0187f.m1167cN();
        }
        return f287a;
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m195a(@NotNull RenderGuiEvent.Post post) {
        C0187f c0187fM6535a;
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (localPlayer == null || !localPlayer.isCreative() || !m185b(localPlayer) || (c0187fM6535a = C1139ul.a.m6535a((Player) localPlayer)) == null) {
            return;
        }
        C0187f.a aVarM1165a = c0187fM6535a.m1165a();
        StringBuilder sbAppend = new StringBuilder("Mode: ").append(aVarM1165a.displayName());
        if (aVarM1165a == C0187f.a.BOUNDARY) {
            sbAppend.append(" (").append(c0187fM6535a.m1172l().size()).append(" points)");
        }
        C1139ul.a.b bVarM6536a = C1139ul.a.m6536a();
        if (bVarM6536a != null) {
            sbAppend.append(bVarM6536a.m6558a() == C1139ul.a.b.EnumC1508a.FACE ? " - moving face" : " - moving point");
        }
        GuiGraphics guiGraphics = post.getGuiGraphics();
        guiGraphics.drawCenteredString(minecraft.font, Component.literal(sbAppend.toString()), guiGraphics.guiWidth() / 2, (guiGraphics.guiHeight() / 2) + 12, aVarM1165a.displayColor());
    }
}
