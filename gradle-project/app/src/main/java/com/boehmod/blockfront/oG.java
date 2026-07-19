package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.oF;
import com.boehmod.blockfront.oI;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.Object2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Camera;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.client.gui.components.DebugScreenOverlay;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import org.apache.commons.lang3.function.TriFunction;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oG.class */
public abstract class oG<G extends oF<G, P, ?>, P extends oI<G>> {
    private static final int mx = 200;

    @NotNull
    private static final ResourceLocation dF;

    @NotNull
    private static final ResourceLocation dG;

    @NotNull
    private static final ResourceLocation dH;

    @NotNull
    private static final ResourceLocation dI;
    private static final int my = 8;

    @NotNull
    private static final Component iF;
    private static final int mz = 3;
    private static final int mA = 350;
    private static final int mB = 25;
    protected static final float kh = 32.0f;
    protected static final float ki = 35.0f;

    @NotNull
    private static final Component iG;

    @NotNull
    private static final Component iH;

    @NotNull
    private static final Component iI;

    @NotNull
    private static final Component iJ;

    @NotNull
    protected final G f;
    private static final int mC = 220;
    private static final int mD = 20;
    private static final int mF = 40;
    private static final String bG = "match_status";
    public float kk;
    public float km;
    private float ko;

    @NotNull
    protected final fV b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final C0530tq f275a;
    static final /* synthetic */ boolean gb;
    private boolean fX = true;
    private int mE = mC;

    @NotNull
    private final List<Component> am = v();
    private boolean fY = false;
    private float kj = 0.0f;
    private boolean fZ = false;

    @NotNull
    private final List<C0421pp> an = new ObjectArrayList();

    @NotNull
    private final Map<UUID, sS> K = new Object2ObjectLinkedOpenHashMap();

    @NotNull
    private final List<C0407pb> ap = new ObjectArrayList();

    @NotNull
    private final List<C0407pb> aq = new ObjectArrayList();
    private int[] o = new int[8];

    @NotNull
    private final List<sQ> ar = new ObjectArrayList();

    @NotNull
    private final List<C0045bp> as = new ObjectArrayList();

    @NotNull
    private final List<C0413ph> at = new ObjectArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final oP f272a = new oP();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final C0518te f273a = new C0518te();
    public int mG = 0;
    private int mH = 0;
    private int mI = 0;
    public float kl = 0.0f;
    public float kn = 0.0f;
    private int mJ = 0;
    protected int mK = 0;
    private int mL = 0;
    private int mM = 0;

    @Nullable
    private Component iK = null;
    private int mN = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private sR f274a = null;
    private float kp = 20.0f;
    private boolean ga = false;

    @NotNull
    private final a a = mo770a();

    @NotNull
    private final List<AbstractC0063cg<G, P>> ao = w();

    @NotNull
    protected abstract List<Component> u();

    @NotNull
    protected abstract List<AbstractC0063cg<G, P>> w();

    public abstract boolean a(@NotNull AbstractClientPlayer abstractClientPlayer);

    public abstract void b(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull fT fTVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2);

    public abstract boolean g(@NotNull Player player);

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract a mo770a();

    public abstract boolean bh();

    public abstract boolean a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel);

    public abstract boolean bk();

    @NotNull
    public abstract List<C0045bp> b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel);

    public abstract void a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel);

    @NotNull
    public abstract Collection<? extends cU> a(boolean z);

    static {
        gb = !oG.class.desiredAssertionStatus();
        dF = C0265jv.d("textures/gui/stopwatch.png");
        dG = C0265jv.d("textures/gui/menu/icons/player.png");
        dH = C0265jv.d("textures/gui/menu/icons/friends.png");
        dI = C0265jv.d("textures/misc/bfneutralicon.png");
        iF = Component.translatable("bf.message.match.title.waiting");
        iG = Component.translatable("bf.message.debug.hitbox").withStyle(ChatFormatting.RED);
        iH = Component.translatable("bf.message.debug.overlay").withStyle(ChatFormatting.RED);
        iI = Component.translatable("bf.message.right.hand").withStyle(ChatFormatting.RED);
        iJ = Component.translatable("bf.message.shader").withStyle(ChatFormatting.RED);
    }

    @NotNull
    private List<Component> v() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (Component component : u()) {
            String strA = a(component);
            if (strA == null || !hN.f160a.f(strA)) {
                objectArrayList.add(component);
            }
        }
        return objectArrayList;
    }

    @Nullable
    private static String a(@NotNull Component component) {
        TranslatableContents contents = component.getContents();
        if (contents instanceof TranslatableContents) {
            return contents.getKey();
        }
        return null;
    }

    public oG(@NotNull C0297l c0297l, @NotNull G g, @NotNull fV fVVar) {
        this.f = g;
        this.b = fVVar;
        this.f275a = new C0530tq(c0297l, this);
    }

    private static float a(@NotNull LocalPlayer localPlayer) {
        return localPlayer.isShiftKeyDown() ? 0.4f : 0.3f;
    }

    @OverridingMethodsMustInvokeSuper
    protected void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull List<C0407pb> list) {
        MutableComponent mutableComponentAppend;
        switch (this.f.m750a()) {
            case PRE_GAME:
                mutableComponentAppend = iF.copy().append(" ").append(Component.literal(String.format("(%d/%d)", Integer.valueOf(this.f.f268a.h().size()), Integer.valueOf(this.f.aW()))).withStyle(ChatFormatting.GRAY));
                break;
            default:
                mutableComponentAppend = null;
                break;
        }
        MutableComponent mutableComponent = mutableComponentAppend;
        if (mutableComponent != null) {
            a(list, bG, (Component) mutableComponent);
        }
    }

    protected void a(@NotNull List<C0407pb> list, @NotNull String str, @NotNull Component component) {
        list.add(new C0407pb(component, 40, true, str));
    }

    protected void a(@NotNull List<C0407pb> list, @NotNull String str, @NotNull Component component, @Nullable Vec3 vec3, int i, int i2) {
        list.add(new C0407pb(component, 40, true, str).a(vec3, i, i2));
    }

    private void co() {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (!gb && localPlayer == null) {
            throw new AssertionError();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        a(minecraft, localPlayer, (List<C0407pb>) objectArrayList);
        for (C0407pb c0407pb : this.aq) {
            if (a((List<C0407pb>) objectArrayList, c0407pb.getKey()) == null) {
                c0407pb.aS();
            }
        }
        for (C0407pb c0407pb2 : objectArrayList) {
            C0407pb c0407pbA = a(this.aq, c0407pb2.getKey());
            if (c0407pbA != null) {
                c0407pbA.b(c0407pb2.E(), c0407pb2.bj());
                c0407pbA.a(c0407pb2.c(), c0407pb2.bi(), c0407pb2.s());
            } else {
                this.aq.add(c0407pb2);
            }
        }
    }

    @Nullable
    private static C0407pb a(@NotNull List<C0407pb> list, @Nullable String str) {
        if (str == null) {
            return null;
        }
        for (C0407pb c0407pb : list) {
            if (str.equals(c0407pb.getKey())) {
                return c0407pb;
            }
        }
        return null;
    }

    public float aH() {
        return this.ko;
    }

    @NotNull
    public oP a() {
        return this.f272a;
    }

    public float y(float f) {
        return C0634xm.e(this.ko, this.kp, f);
    }

    public void l(float f) {
        this.ko -= f;
        if (this.ko < 0.0f) {
            this.ko = 0.0f;
        }
    }

    @NotNull
    public Collection<C0045bp> d() {
        return Collections.unmodifiableList(this.as);
    }

    @OverridingMethodsMustInvokeSuper
    public void a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0297l c0297l, @NotNull fT fTVar, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        if (a(minecraft, clientLevel, c0297l, fTVar)) {
            return;
        }
        if (!RenderSystem.isOnRenderThread()) {
            RenderSystem.recordRenderCall(() -> {
                c0297l.a((oF<?, ?, ?>) this.f);
            });
        } else {
            c0297l.a((oF<?, ?, ?>) this.f);
        }
        d(minecraft, localPlayer);
        a(minecraft, c0297l, localPlayer);
        this.f273a.onUpdate();
        C(minecraft);
        c(minecraft, localPlayer);
        A(minecraft);
        this.kn = this.km;
        boolean z = fTVar.dk() && fTVar.cs() <= 20;
        this.km = C0634xm.d(this.km, z ? 1.0f : 0.0f, z ? 0.05f : 0.15f);
        if (!c0297l.m602a().ay()) {
            B(minecraft);
        }
        l(localPlayer);
        m(localPlayer);
        if (this.f274a != null) {
            this.f274a.onUpdate();
        }
        this.ap.removeIf((v0) -> {
            return v0.k();
        });
        this.aq.removeIf((v0) -> {
            return v0.k();
        });
        this.ar.removeIf((v0) -> {
            return v0.k();
        });
        this.an.removeIf(c0421pp -> {
            return c0421pp.a(minecraft, this.f);
        });
        this.K.values().removeIf(sSVar -> {
            return !sSVar.a(minecraft, c0297l, this);
        });
        a(minecraft, localPlayer, clientLevel, set);
        n(localPlayer);
        this.at.removeIf(c0413ph -> {
            return c0413ph.e(localPlayer);
        });
        a(minecraft, localPlayer, clientLevel, c0297l, randomSource, f);
        a(c0297l, set);
    }

    private void A(@NotNull Minecraft minecraft) {
        if (hN.u.T()) {
            int i = this.mM;
            this.mM = i - 1;
            if (i <= 0) {
                this.mM = 20;
                this.iK = Component.literal("FPS: ").withStyle(ChatFormatting.WHITE).append(Component.literal(C0637xp.a(minecraft.getFps())).withStyle(ChatFormatting.GRAY));
                this.mN = minecraft.font.width(this.iK);
            }
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer) {
        if (this.f.f263a == oN.POST_GAME) {
            return;
        }
        int i = this.mE;
        this.mE = i - 1;
        if (i > 0) {
            return;
        }
        this.mE = mC;
        if (this.am.isEmpty()) {
            return;
        }
        Component component = (Component) this.am.removeFirst();
        if (this.f.f268a.a(localPlayer.getUUID()) != null) {
            MutableComponent mutableComponentWithColor = Component.literal("\ue013").withColor(ColorReferences.COLOR_WHITE);
            MutableComponent mutableComponentWithStyle = Component.literal(" Tip: ").withStyle(ChatFormatting.DARK_GRAY);
            MutableComponent mutableComponentWithStyle2 = component.copy().withStyle(ChatFormatting.GRAY);
            ChatComponent chat = minecraft.gui.getChat();
            chat.addMessage(Component.empty());
            chat.addMessage(mutableComponentWithColor.append(mutableComponentWithStyle).append(mutableComponentWithStyle2));
            chat.addMessage(Component.empty());
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C0624xc.pI.get(), 1.0f));
            String strA = a(component);
            if (strA != null && hN.f160a.g(strA)) {
                hQ.d(c0297l);
            }
        }
    }

    private void l(@NotNull LocalPlayer localPlayer) {
        this.kl = this.kk;
        this.mI--;
        if (hN.l.T()) {
            this.kk = 0.0f;
        } else if (this.mI <= 0) {
            this.kk = Math.min(this.kk + 0.3f, 1.0f);
        } else {
            this.kk = Math.max(this.kk - 0.2f, 0.0f);
        }
        Inventory inventory = localPlayer.getInventory();
        if (this.mH != inventory.selected) {
            this.mH = inventory.selected;
            this.mI = 30;
        }
    }

    private void a(@NotNull C0297l c0297l, @NotNull Set<UUID> set) {
        int i = this.mK;
        this.mK = i + 1;
        if (i >= 200) {
            this.mK = 0;
            iO iOVarA = ((C0163g) c0297l.b()).a();
            set.forEach(uuid -> {
                iOVarA.b(RequestType.PLAYER_DATA, uuid);
                iOVarA.b(RequestType.INVENTORY_MINIMAL, uuid);
            });
        }
    }

    private void B(@NotNull Minecraft minecraft) {
        UUID profileId = minecraft.getUser().getProfileId();
        G g = this.f;
        if ((g instanceof qO) && ((qO) g).bB()) {
            oO oOVarA = this.f.f268a.a((UUID) Objects.requireNonNull(profileId));
            boolean z = this.f.a(profileId).a(C0529tp.i.getKey(), -1) != -1;
            if (this.mG > 0) {
                this.mG--;
            }
            if (oOVarA != null && minecraft.screen == null && !z && this.mG <= 0) {
                minecraft.setScreen(a(oOVarA));
                this.mG = 5;
            }
        }
    }

    private void C(@NotNull Minecraft minecraft) {
        if (this.f275a.cg()) {
            this.f275a.n(minecraft);
        }
    }

    private void c(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        Iterator<AbstractC0063cg<G, P>> it = this.ao.iterator();
        while (it.hasNext()) {
            it.next().a(minecraft, this.f, this.f.f268a, this, localPlayer);
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, float f) {
        this.f.m767a().a(minecraft, c0297l, this.f, localPlayer, clientLevel, randomSource, f);
    }

    private void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull Set<UUID> set) {
        int i = this.mL;
        this.mL = i - 1;
        if (i > 0) {
            return;
        }
        this.mL = 20;
        this.as.clear();
        this.as.addAll(a(minecraft, set, localPlayer, clientLevel));
    }

    private boolean a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull C0297l c0297l, @NotNull fT fTVar) {
        if (bm() && ((C0459r) c0297l.b()).i()) {
            c0297l.a(minecraft, fTVar, this.b, clientLevel);
            clientLevel.disconnect();
            minecraft.disconnect(new C0094dk());
            return true;
        }
        return false;
    }

    private void d(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        Options options = minecraft.options;
        if (!options.getCameraType().isFirstPerson() && !g((Player) localPlayer) && !localPlayer.isCreative()) {
            options.setCameraType(CameraType.FIRST_PERSON);
        }
    }

    @NotNull
    protected Screen a(@NotNull oO oOVar) {
        return new cI(null, oOVar, this.f, this);
    }

    private void m(@NotNull LocalPlayer localPlayer) {
        this.kp = this.ko;
        if (fT.b(localPlayer) && this.f.e(localPlayer)) {
            if (this.ko <= 0.0f) {
                localPlayer.setSprinting(false);
                localPlayer.getFoodData().setFoodLevel(1);
            } else if (this.ko > 5.0f) {
                localPlayer.getFoodData().setFoodLevel(20);
            }
            if (localPlayer.isSprinting()) {
                if (this.ko > 0.0f) {
                    this.ko -= aI();
                    return;
                }
                return;
            } else if (this.ko < 20.0d) {
                this.ko += a(localPlayer);
                return;
            } else {
                if (this.ko > 20.0d) {
                    this.ko = 20.0f;
                    return;
                }
                return;
            }
        }
        this.ko = 20.0f;
        localPlayer.getFoodData().setFoodLevel(20);
    }

    protected float aI() {
        return 0.1f;
    }

    private void n(@NotNull LocalPlayer localPlayer) {
        Inventory inventory = localPlayer.getInventory();
        int i = inventory.selected;
        if (oR.h(localPlayer) || !bk()) {
            return;
        }
        boolean zIsEmpty = inventory.getItem(i).isEmpty();
        if (this.mJ != i || zIsEmpty) {
            if (zIsEmpty) {
                int iA = oR.a(inventory, i, this.mJ > i || (this.mJ == 0 && i == 8) ? -1 : 1);
                if (!inventory.getItem(iA).isEmpty()) {
                    inventory.selected = iA;
                }
            }
            if (!localPlayer.getMainHandItem().isEmpty() && !inventory.getItem(this.mJ).isEmpty()) {
                C0558ur.hR = false;
            }
        }
        this.mJ = inventory.selected;
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull fT fTVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        C0332mh c0332mhB;
        C0333mi c0333miM602a = c0297l.m602a();
        c0333miM602a.c(minecraft, poseStack, guiGraphics, font, i, i2, f2);
        if (c0333miM602a.ay() && (c0332mhB = c0333miM602a.b()) != null && !c0332mhB.at()) {
            return;
        }
        Camera mainCamera = minecraft.gameRenderer.getMainCamera();
        Iterator<sS> it = this.K.values().iterator();
        while (it.hasNext()) {
            it.next().a(this, poseStack, guiGraphics, mainCamera, i, i2, f2);
        }
        b(minecraft, c0297l, localPlayer, clientLevel, fTVar, guiGraphics, font, poseStack, multiBufferSource, set, i, i2, i3, i4, f, f2);
        a(guiGraphics, font, poseStack, i, f2);
        b(guiGraphics, font, poseStack, i3, f2);
        b(poseStack, guiGraphics, font);
        a(minecraft, c0297l, localPlayer, clientLevel, guiGraphics, poseStack, font, i3, i4);
    }

    private void b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        if (!hN.u.T() || this.iK == null) {
            return;
        }
        int iP = C0040bk.p();
        int i = this.mN + 6;
        C0040bk.a(guiGraphics, 5, 4, i - 2, 1, iP);
        C0040bk.a(guiGraphics, 4, 5, i, 13, iP);
        C0040bk.a(guiGraphics, 5, 18, i - 2, 1, iP);
        C0040bk.a(poseStack, font, guiGraphics, this.iK, 4 + (i / 2), 8);
    }

    private void a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, int i, float f) {
        int height = 0;
        for (C0407pb c0407pb : this.aq) {
            c0407pb.b(poseStack, guiGraphics, font, height, i, f);
            height += c0407pb.getHeight() + 2;
        }
        for (C0407pb c0407pb2 : this.ap) {
            c0407pb2.b(poseStack, guiGraphics, font, height, i, f);
            height += c0407pb2.getHeight() + 2;
        }
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2) {
        if (!localPlayer.isCreative()) {
            return;
        }
        this.f.m767a().a(minecraft, c0297l, localPlayer, clientLevel, guiGraphics, poseStack, font, i, i2);
    }

    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, fT fTVar, float f, float f2, int i) {
        ResourceLocation resourceLocationK = fTVar.k();
        if (resourceLocationK != null) {
            poseStack.pushPose();
            poseStack.translate(f, f2, 0.0f);
            guiGraphics.blit(resourceLocationK, 0, 0, i, i, 8.0f, 8.0f, 8, 8, 64, 64);
            guiGraphics.blit(resourceLocationK, 0, 0, i, i, 40.0f, 8.0f, 8, 8, 64, 64);
            poseStack.popPose();
        }
    }

    private void b(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, int i, float f) {
        int size = this.ao.size();
        if (size == 0) {
            return;
        }
        if (this.o.length < size) {
            this.o = new int[size];
        }
        int[] iArr = this.o;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            AbstractC0063cg<G, P> abstractC0063cg = this.ao.get(i4);
            if (!abstractC0063cg.s()) {
                iArr[i4] = -1;
            } else {
                int iA = abstractC0063cg.a(font);
                iArr[i4] = iA;
                i2 += iA;
                i3++;
            }
        }
        if (i3 == 0) {
            return;
        }
        int i5 = i - ((i2 + (3 * (i3 - 1))) / 2);
        for (int i6 = 0; i6 < size; i6++) {
            int i7 = iArr[i6];
            if (i7 >= 0) {
                this.ao.get(i6).a(guiGraphics, poseStack, font, i5, 4, f);
                i5 += i7 + 3;
            }
        }
    }

    @Nullable
    public Component a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull fT fTVar) {
        return null;
    }

    public void e(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        DebugScreenOverlay debugOverlay = minecraft.getDebugOverlay();
        if (debugOverlay.showDebugScreen() && !localPlayer.isCreative()) {
            iC.c(minecraft, iH);
            debugOverlay.toggleOverlay();
        }
        if (!minecraft.gameRenderer.effectActive) {
            minecraft.gameRenderer.effectActive = true;
            if (this.fX) {
                this.fX = false;
            } else {
                iC.c(minecraft, iJ);
            }
        }
        EntityRenderDispatcher entityRenderDispatcher = minecraft.getEntityRenderDispatcher();
        if (entityRenderDispatcher.shouldRenderHitBoxes() && !localPlayer.isCreative()) {
            iC.c(minecraft, iG);
            entityRenderDispatcher.setRenderHitBoxes(false);
        }
        OptionInstance optionInstanceMainHand = minecraft.options.mainHand();
        if (optionInstanceMainHand.get() != HumanoidArm.RIGHT) {
            optionInstanceMainHand.set(HumanoidArm.RIGHT);
            minecraft.options.broadcastOptions();
            iC.c(minecraft, iI);
        }
    }

    @NotNull
    public List<C0413ph> x() {
        return Collections.unmodifiableList(this.at);
    }

    public void cp() {
        this.at.removeIf(c0413ph -> {
            return c0413ph.a().isWaypoint();
        });
    }

    public void a(@NotNull C0413ph c0413ph) {
        this.at.add(c0413ph);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull iS iSVar, int i, int i2, float f) {
        UUID uuidQ;
        int i3 = i2 / 2;
        if (hN.s.T()) {
            C0040bk.k(minecraft);
        }
        P p = this.f.f268a;
        oO oOVarA = p.a(localPlayer.getUUID());
        if (oOVarA != null || c0297l.e()) {
            oO oOVarA2 = oOVarA;
            if (oOVarA2 == null && (uuidQ = ((fV) c0297l.a()).a(minecraft).q()) != null) {
                oOVarA2 = p.a(uuidQ);
            }
            int color = oOVarA2 != null ? oOVarA2.getColor() : ColorReferences.COLOR_WHITE_SOLID;
            int iAY = oOVarA2 != null ? oOVarA2.aY() : ColorReferences.COLOR_WHITE;
            if (hN.r.T()) {
                C0040bk.a(guiGraphics, 0, i3, i, i3, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
                C0040bk.a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID, 0.25f);
                C0040bk.a(guiGraphics, 0, 0, i, i2, color, 0.15f);
            }
            C0040bk.b(poseStack, guiGraphics, dF, (i - 10) - 16, 25, 16, 16, 0.0f, 1.0f, iAY);
            MutableComponent mutableComponentWithColor = Component.literal(this.f272a.d().getString()).withColor(iAY);
            C0040bk.a(poseStack, font, guiGraphics, (Component) mutableComponentWithColor, (((i - 10) - 16) - (font.width(mutableComponentWithColor) * 2)) - 10, 18, 2.0f);
            C0040bk.a(guiGraphics, 0, 49, i, 1, 301989887);
            C0040bk.a(guiGraphics, 0, 50, i, 8, ColorReferences.COLOR_BLACK_SOLID - (-872415232), ColorReferences.COLOR_BLACK_TRANSPARENT);
            this.f273a.a(poseStack, font, guiGraphics, this.f, 0, 0, i, 49, color, iAY, f);
            List<oO> listA = p.A();
            int size = listA.size();
            if (size == 0) {
                return;
            }
            Set<UUID> setI = p.i();
            boolean z = !setI.isEmpty();
            int i4 = size + (z ? 1 : 0);
            int i5 = (i - mA) / 2;
            int i6 = ((((i2 - 50) - 13) - 2) - ((i4 + 1) * 5)) / i4;
            int i7 = 68;
            C0040bk.a(poseStack, minecraft, c0297l, this.b, iSVar, guiGraphics, font, this.f, this, null, Style.EMPTY, this.a.g(), i5, 51.0f, 350.0f, 13.0f, 3);
            float fSin = (Mth.sin(C0040bk.g() / 120.0f) + 1.0f) / 2.0f;
            int i8 = (i - mA) / 2;
            for (oO oOVar : listA) {
                SortedSet<UUID> sortedSetA = oR.a((oF<?, ?, ?>) this.f, oOVar.h(), this.f.m762a());
                int i9 = 0;
                if (sortedSetA.size() * 11 > i6) {
                    i9 = (int) (fSin * (r0 - i6));
                }
                int i10 = i7 + 15;
                int iAY2 = oOVar.aY();
                C0514ta c0514taA = oOVar.a((oF<?, ?, ?>) this.f);
                C0040bk.b(poseStack, guiGraphics, c0514taA.m1156a().N(), i8 / 2, i10, 25);
                int i11 = (i10 + 25) - 5;
                ObjectListIterator it = iH.a(font, c0514taA.m1156a().getName(), i8).iterator();
                while (it.hasNext()) {
                    String strTrim = ((String) it.next()).trim();
                    if (!strTrim.isEmpty()) {
                        C0040bk.c(font, guiGraphics, (Component) Component.literal(strTrim).withColor(iAY2), i8 / 2, i11);
                        i11 += 10;
                    }
                }
                poseStack.pushPose();
                C0040bk.a(guiGraphics, i5, i7, mA, i6);
                a(poseStack, minecraft, c0297l, localPlayer, this.b, iSVar, guiGraphics, font, oOVar, i5, i7 - i9, sortedSetA);
                guiGraphics.disableScissor();
                poseStack.popPose();
                i7 += i6 + 5;
            }
            if (z) {
                int i12 = 0;
                if (setI.size() * 11 > i6) {
                    i12 = (int) (fSin * (r0 - i6));
                }
                int i13 = i7 + 15;
                C0040bk.b(poseStack, guiGraphics, dI, i8 / 2, i13, 25);
                int i14 = (i13 + 25) - 5;
                ObjectListIterator it2 = iH.a(font, Component.translatable("bf.scoreboard.spectators.title").getString(), i8).iterator();
                while (it2.hasNext()) {
                    String strTrim2 = ((String) it2.next()).trim();
                    if (!strTrim2.isEmpty()) {
                        C0040bk.c(font, guiGraphics, (Component) Component.literal(strTrim2).withStyle(ChatFormatting.GRAY), i8 / 2, i14);
                        i14 += 10;
                    }
                }
                poseStack.pushPose();
                C0040bk.a(guiGraphics, i5, i7, mA, i6);
                a(poseStack, minecraft, c0297l, this.b, iSVar, guiGraphics, font, setI, i5, i7 - i12);
                guiGraphics.disableScissor();
                poseStack.popPose();
            }
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull fV fVVar, @NotNull iS iSVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull oO oOVar, int i, int i2, @NotNull Set<UUID> set) {
        ClientPacketListener clientPacketListener = localPlayer.connection;
        Style styleA = oOVar.a();
        int i3 = 0;
        for (UUID uuid : set) {
            oM oMVarA = this.f.a(uuid);
            fT fTVarB = fVVar.b(uuid);
            PlayerInfo playerInfo = clientPacketListener.getPlayerInfo(uuid);
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator<TriFunction<fT, PlayerInfo, oM, String>> it = this.a.L.values().iterator();
            while (it.hasNext()) {
                objectArrayList.add((String) it.next().apply(fTVarB, playerInfo, oMVarA));
            }
            C0040bk.a(poseStack, minecraft, c0297l, fVVar, iSVar, guiGraphics, font, this.f, this, uuid, styleA, objectArrayList, i, i2 + i3, 350.0f, 10.0f, 1);
            i3 += 11;
        }
    }

    private void a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull iS iSVar, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Set<UUID> set, int i, int i2) {
        int i3 = 0;
        Iterator<UUID> it = set.iterator();
        while (it.hasNext()) {
            C0040bk.a(poseStack, minecraft, c0297l, fVVar, iSVar, guiGraphics, font, this.f, this, it.next(), Style.EMPTY, List.of(), i, i2 + i3, 350.0f, 10.0f, 1);
            i3 += 11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0056 A[SYNTHETIC] */
    @javax.annotation.OverridingMethodsMustInvokeSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(@org.jetbrains.annotations.NotNull com.boehmod.blockfront.oI<?> r17, @org.jetbrains.annotations.NotNull net.minecraft.client.Minecraft r18, @org.jetbrains.annotations.NotNull net.minecraft.client.multiplayer.ClientLevel r19, @org.jetbrains.annotations.NotNull net.minecraft.client.player.LocalPlayer r20, @org.jetbrains.annotations.NotNull net.neoforged.neoforge.client.event.RenderLevelStageEvent r21, @org.jetbrains.annotations.NotNull net.minecraft.client.renderer.MultiBufferSource.BufferSource r22, @org.jetbrains.annotations.NotNull com.mojang.blaze3d.vertex.PoseStack r23, @org.jetbrains.annotations.NotNull net.minecraft.client.renderer.culling.Frustum r24, @org.jetbrains.annotations.NotNull net.minecraft.client.gui.Font r25, @org.jetbrains.annotations.NotNull net.minecraft.client.gui.GuiGraphics r26, @org.jetbrains.annotations.NotNull net.minecraft.client.Camera r27, boolean r28, float r29, float r30) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.oG.a(com.boehmod.blockfront.oI, net.minecraft.client.Minecraft, net.minecraft.client.multiplayer.ClientLevel, net.minecraft.client.player.LocalPlayer, net.neoforged.neoforge.client.event.RenderLevelStageEvent, net.minecraft.client.renderer.MultiBufferSource$BufferSource, com.mojang.blaze3d.vertex.PoseStack, net.minecraft.client.renderer.culling.Frustum, net.minecraft.client.gui.Font, net.minecraft.client.gui.GuiGraphics, net.minecraft.client.Camera, boolean, float, float):void");
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera) {
        P p = this.f.f268a;
        if (p.e != null) {
            C0040bk.a(poseStack, font, camera, guiGraphics, (Component) Component.literal("LOBBY SPAWN").withStyle(ChatFormatting.YELLOW), p.e.c.x, p.e.c.y + 0.5d, p.e.c.z);
            C0040bk.a(poseStack, camera, guiGraphics, dH, p.e.c.x, p.e.c.y + 1.25d, p.e.c.z, 64);
        }
        MutableComponent mutableComponentLiteral = Component.literal("SPAWN POINT");
        for (oO oOVar : p.A()) {
            MutableComponent mutableComponentAppend = Component.literal("Team: ").append(Component.literal(oOVar.getName()).withStyle(oOVar.a()));
            for (oX oXVar : oOVar.B()) {
                C0040bk.a(poseStack, font, camera, guiGraphics, (Component) mutableComponentLiteral, oXVar.c.x, oXVar.c.y + 1.2000000476837158d, oXVar.c.z);
                C0040bk.a(poseStack, font, camera, guiGraphics, (Component) mutableComponentAppend, oXVar.c.x, oXVar.c.y + 0.800000011920929d, oXVar.c.z);
                C0040bk.a(poseStack, camera, guiGraphics, dG, oXVar.c.x, oXVar.c.y + 1.75d, oXVar.c.z, 64);
            }
        }
    }

    public boolean bi() {
        return true;
    }

    public boolean bj() {
        return true;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public G m771a() {
        return this.f;
    }

    public boolean bl() {
        return this.fY;
    }

    public void N(boolean z) {
        this.fY = z;
    }

    public float aJ() {
        return this.kj;
    }

    public void m(float f) {
        this.kj = f;
    }

    public void O(boolean z) {
        if (z && !this.fZ) {
            this.fY = false;
            this.kj = 0.0f;
        }
        this.fZ = z;
    }

    protected static float z(float f) {
        return C0634xm.i(f, kh, ki);
    }

    @NotNull
    public List<C0045bp> a(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.addAll(b(minecraft, set, localPlayer, clientLevel));
        return objectArrayList;
    }

    @Nullable
    public ResourceLocation a(@NotNull UUID uuid, @Nullable String str, @NotNull Set<UUID> set) {
        C0514ta c0514taM755a;
        C0514ta c0514taM756b;
        if (!set.contains(uuid)) {
            return null;
        }
        ResourceLocation resourceLocationD = null;
        oO oOVarA = this.f.f268a.a(uuid);
        if (oOVarA != null) {
            c0514taM755a = this.f.m755a();
            c0514taM756b = this.f.m756b();
            switch (oOVarA.getName()) {
                case "Allies":
                    resourceLocationD = C0265jv.d("textures/skins/game/nations/" + c0514taM755a.m1156a().ao() + "/" + c0514taM755a.getSkin() + "/" + str + ".png");
                    break;
                case "Axis":
                    resourceLocationD = C0265jv.d("textures/skins/game/nations/" + c0514taM756b.m1156a().ao() + "/" + c0514taM756b.getSkin() + "/" + str + ".png");
                    break;
            }
        }
        return resourceLocationD;
    }

    public void f(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        UUID uuid = localPlayer.getUUID();
        fT fTVar = (fT) this.b.a((Player) localPlayer);
        G g = this.f;
        if (g instanceof qT) {
            qT qTVar = (qT) g;
            if (oR.a((Player) localPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) fTVar)) {
                return;
            }
            if (!qTVar.mo1079a(uuid).isEmpty()) {
                minecraft.setScreen(new cZ(qTVar));
            }
        }
        if (this.f instanceof qO) {
            oO oOVarA = this.f.f268a.a(uuid);
            if (!(minecraft.screen instanceof cH) && oOVarA != null) {
                minecraft.setScreen(a(oOVarA));
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<sV, ObjectList<C0411pf>> m772a(@NotNull oO oOVar) {
        return oOVar.a((oF<?, ?, ?>) this.f).r();
    }

    public void a(@NotNull Minecraft minecraft, @NotNull C0421pp c0421pp) {
        c0421pp.D(minecraft);
        c0421pp.m(minecraft);
        this.an.add(c0421pp);
        if (this.an.size() > 5) {
            this.an.removeFirst();
        }
    }

    public void a(@NotNull sQ sQVar) {
        this.ar.add(sQVar);
        while (this.ar.size() > 8) {
            this.ar.removeFirst();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public sR m773a() {
        return this.f274a;
    }

    public void a(@NotNull sR sRVar) {
        this.f274a = sRVar;
    }

    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        if (IPacket.readBoolean(byteBuf)) {
            this.f272a.b(byteBuf);
        }
        this.ga = IPacket.readBoolean(byteBuf);
        co();
    }

    public boolean bm() {
        return this.ga;
    }

    @NotNull
    public List<C0421pp> y() {
        return Collections.unmodifiableList(this.an);
    }

    @NotNull
    public List<sQ> z() {
        return Collections.unmodifiableList(this.ar);
    }

    @NotNull
    protected Collection<? extends cU> a(G g, boolean z) {
        if (z) {
            return List.of(new cS(g));
        }
        C0297l c0297lB = C0297l.b();
        if (c0297lB != null && c0297lB.m592d()) {
            return List.of(new cX(g, b()), new cS(g));
        }
        return List.of(new cV(g.m757e(), this), new cX(g, b()), new cS(g));
    }

    @NotNull
    protected C0528to b() {
        return C0529tp.l;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0530tq m774a() {
        return this.f275a;
    }

    public void stop() {
    }

    public void a(@NotNull sS sSVar) {
        UUID uuidH = sSVar.h();
        this.K.values().removeIf(sSVar2 -> {
            return (sSVar2 instanceof sT) && sSVar2.h().equals(uuidH);
        });
        if (this.K.containsKey(sSVar.i())) {
            return;
        }
        this.K.put(sSVar.i(), sSVar);
    }

    @Nullable
    public sS a(@NotNull UUID uuid) {
        return this.K.get(uuid);
    }

    @Nullable
    public sS a(@NotNull Vec3 vec3, double d) {
        sS sSVar = null;
        double d2 = d * d;
        for (sS sSVar2 : this.K.values()) {
            double dDistanceToSqr = sSVar2.c().distanceToSqr(vec3);
            if (dDistanceToSqr < d2) {
                d2 = dDistanceToSqr;
                sSVar = sSVar2;
            }
        }
        return sSVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        if (this instanceof qJ) {
            qJ qJVar = (qJ) this;
            sS sSVar = this.K.get(uuid);
            if (sSVar != null && !sSVar.bR() && qJVar.a(sSVar, uuid2, vec3)) {
                sSVar.o(vec3);
                sSVar.cT();
            }
        }
    }

    public void a(@NotNull Component component, int i) {
        a(List.of(component), i, (String) null);
    }

    public void a(@NotNull Component component, int i, @Nullable String str) {
        a(List.of(component), i, str);
    }

    public void a(@NotNull List<Component> list, int i) {
        a(list, i, (String) null);
    }

    public void a(@NotNull List<Component> list, int i, @Nullable String str) {
        a(list, i, str, (Vec3) null, ColorReferences.COLOR_WHITE, ColorReferences.COLOR_WHITE);
    }

    public void a(@NotNull List<Component> list, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        C0407pb c0407pbA = new C0407pb(list, i, true, str).a(vec3, i2, i3);
        if (str != null) {
            for (int i4 = 0; i4 < this.ap.size(); i4++) {
                if (str.equals(this.ap.get(i4).getKey())) {
                    this.ap.set(i4, c0407pbA);
                    return;
                }
            }
        }
        this.ap.add(c0407pbA);
        while (this.ap.size() > 3) {
            this.ap.removeFirst();
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oG$a.class */
    public static class a {

        @NotNull
        private final Map<String, TriFunction<fT, PlayerInfo, oM, String>> L = new Object2ObjectLinkedOpenHashMap();

        @NotNull
        public a a(@NotNull String str, @NotNull TriFunction<fT, PlayerInfo, oM, String> triFunction) {
            this.L.put(str, triFunction);
            return this;
        }

        @NotNull
        public Set<String> g() {
            return this.L.keySet();
        }
    }
}
