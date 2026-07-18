package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0787oF;
import com.boehmod.blockfront.AbstractC0790oI;
import com.boehmod.blockfront.common.player.AbstractC0182b;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oG */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oG.class */
public abstract class AbstractC0788oG<G extends AbstractC0787oF<G, P, ?>, P extends AbstractC0790oI<G>> {

    /* JADX INFO: renamed from: mx */
    private static final int f4255mx = 200;

    /* JADX INFO: renamed from: dF */
    @NotNull
    private static final ResourceLocation f4256dF;

    /* JADX INFO: renamed from: dG */
    @NotNull
    private static final ResourceLocation f4257dG;

    /* JADX INFO: renamed from: dH */
    @NotNull
    private static final ResourceLocation f4258dH;

    /* JADX INFO: renamed from: dI */
    @NotNull
    private static final ResourceLocation f4259dI;

    /* JADX INFO: renamed from: my */
    private static final int f4260my = 8;

    /* JADX INFO: renamed from: iF */
    @NotNull
    private static final Component f4261iF;

    /* JADX INFO: renamed from: mz */
    private static final int f4262mz = 3;

    /* JADX INFO: renamed from: mA */
    private static final int f4263mA = 350;

    /* JADX INFO: renamed from: mB */
    private static final int f4264mB = 25;

    /* JADX INFO: renamed from: kh */
    protected static final float f4265kh = 32.0f;

    /* JADX INFO: renamed from: ki */
    protected static final float f4266ki = 35.0f;

    /* JADX INFO: renamed from: iG */
    @NotNull
    private static final Component f4268iG;

    /* JADX INFO: renamed from: iH */
    @NotNull
    private static final Component f4269iH;

    /* JADX INFO: renamed from: iI */
    @NotNull
    private static final Component f4270iI;

    /* JADX INFO: renamed from: iJ */
    @NotNull
    private static final Component f4271iJ;

    /* JADX INFO: renamed from: f */
    @NotNull
    protected final G f4272f;

    /* JADX INFO: renamed from: mC */
    private static final int f4273mC = 220;

    /* JADX INFO: renamed from: mD */
    private static final int f4274mD = 20;

    /* JADX INFO: renamed from: mF */
    private static final int f4285mF = 40;

    /* JADX INFO: renamed from: bG */
    private static final String f4286bG = "match_status";

    /* JADX INFO: renamed from: kk */
    public float f4297kk;

    /* JADX INFO: renamed from: km */
    public float f4299km;

    /* JADX INFO: renamed from: ko */
    private float f4308ko;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final C0326fV f4311b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1090tq f4312a;

    /* JADX INFO: renamed from: gb */
    static final /* synthetic */ boolean f4313gb;

    /* JADX INFO: renamed from: fX */
    private boolean f4267fX = true;

    /* JADX INFO: renamed from: mE */
    private int f4275mE = f4273mC;

    /* JADX INFO: renamed from: am */
    @NotNull
    private final List<Component> f4276am = m3667v();

    /* JADX INFO: renamed from: fY */
    private boolean f4277fY = false;

    /* JADX INFO: renamed from: kj */
    private float f4278kj = 0.0f;

    /* JADX INFO: renamed from: fZ */
    private boolean f4279fZ = false;

    /* JADX INFO: renamed from: an */
    @NotNull
    private final List<C0876pp> f4280an = new ObjectArrayList();

    /* JADX INFO: renamed from: K */
    @NotNull
    private final Map<UUID, AbstractC1012sS> f4281K = new Object2ObjectLinkedOpenHashMap();

    /* JADX INFO: renamed from: ap */
    @NotNull
    private final List<C0862pb> f4283ap = new ObjectArrayList();

    /* JADX INFO: renamed from: aq */
    @NotNull
    private final List<C0862pb> f4284aq = new ObjectArrayList();

    /* JADX INFO: renamed from: o */
    private int[] f4287o = new int[8];

    /* JADX INFO: renamed from: ar */
    @NotNull
    private final List<C1010sQ> f4288ar = new ObjectArrayList();

    /* JADX INFO: renamed from: as */
    @NotNull
    private final List<C0124bp> f4289as = new ObjectArrayList();

    /* JADX INFO: renamed from: at */
    @NotNull
    private final List<C0868ph> f4291at = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0797oP f4292a = new C0797oP();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1078te f4293a = new C1078te();

    /* JADX INFO: renamed from: mG */
    public int f4294mG = 0;

    /* JADX INFO: renamed from: mH */
    private int f4295mH = 0;

    /* JADX INFO: renamed from: mI */
    private int f4296mI = 0;

    /* JADX INFO: renamed from: kl */
    public float f4298kl = 0.0f;

    /* JADX INFO: renamed from: kn */
    public float f4300kn = 0.0f;

    /* JADX INFO: renamed from: mJ */
    private int f4301mJ = 0;

    /* JADX INFO: renamed from: mK */
    protected int f4302mK = 0;

    /* JADX INFO: renamed from: mL */
    private int f4303mL = 0;

    /* JADX INFO: renamed from: mM */
    private int f4304mM = 0;

    /* JADX INFO: renamed from: iK */
    @Nullable
    private Component f4305iK = null;

    /* JADX INFO: renamed from: mN */
    private int f4306mN = 0;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1011sR f4307a = null;

    /* JADX INFO: renamed from: kp */
    private float f4309kp = 20.0f;

    /* JADX INFO: renamed from: ga */
    private boolean f4310ga = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final a f4290a = mo3711a();

    /* JADX INFO: renamed from: ao */
    @NotNull
    private final List<AbstractC0168cg<G, P>> f4282ao = mo3670w();

    @NotNull
    /* JADX INFO: renamed from: u */
    protected abstract List<Component> mo3666u();

    @NotNull
    /* JADX INFO: renamed from: w */
    protected abstract List<AbstractC0168cg<G, P>> mo3670w();

    /* JADX INFO: renamed from: a */
    public abstract boolean mo3676a(@NotNull AbstractClientPlayer abstractClientPlayer);

    /* JADX INFO: renamed from: b */
    public abstract void mo3704b(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2);

    /* JADX INFO: renamed from: g */
    public abstract boolean mo3710g(@NotNull Player player);

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract a mo3711a();

    /* JADX INFO: renamed from: bh */
    public abstract boolean mo3717bh();

    /* JADX INFO: renamed from: a */
    public abstract boolean mo3718a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel);

    /* JADX INFO: renamed from: bk */
    public abstract boolean mo3721bk();

    @NotNull
    /* JADX INFO: renamed from: b */
    public abstract List<C0124bp> mo3730b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel);

    /* JADX INFO: renamed from: a */
    public abstract void mo3731a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel);

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract Collection<? extends AbstractC0156cU> mo3743a(boolean z);

    static {
        f4313gb = !AbstractC0788oG.class.desiredAssertionStatus();
        f4256dF = C0564jv.m2555d("textures/gui/stopwatch.png");
        f4257dG = C0564jv.m2555d("textures/gui/menu/icons/player.png");
        f4258dH = C0564jv.m2555d("textures/gui/menu/icons/friends.png");
        f4259dI = C0564jv.m2555d("textures/misc/bfneutralicon.png");
        f4261iF = Component.translatable("bf.message.match.title.waiting");
        f4268iG = Component.translatable("bf.message.debug.hitbox").withStyle(ChatFormatting.RED);
        f4269iH = Component.translatable("bf.message.debug.overlay").withStyle(ChatFormatting.RED);
        f4270iI = Component.translatable("bf.message.right.hand").withStyle(ChatFormatting.RED);
        f4271iJ = Component.translatable("bf.message.shader").withStyle(ChatFormatting.RED);
    }

    @NotNull
    /* JADX INFO: renamed from: v */
    private List<Component> m3667v() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (Component component : mo3666u()) {
            String strM3668a = m3668a(component);
            if (strM3668a == null || !C0424hN.f2771a.m2010f(strM3668a)) {
                objectArrayList.add(component);
            }
        }
        return objectArrayList;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static String m3668a(@NotNull Component component) {
        TranslatableContents contents = component.getContents();
        if (contents instanceof TranslatableContents) {
            return contents.getKey();
        }
        return null;
    }

    public AbstractC0788oG(@NotNull C0622l c0622l, @NotNull G g, @NotNull C0326fV c0326fV) {
        this.f4272f = g;
        this.f4311b = c0326fV;
        this.f4312a = new C1090tq(c0622l, this);
    }

    /* JADX INFO: renamed from: a */
    private static float m3669a(@NotNull LocalPlayer localPlayer) {
        return localPlayer.isShiftKeyDown() ? 0.4f : 0.3f;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    protected void mo3671a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull List<C0862pb> list) {
        MutableComponent mutableComponentAppend;
        switch (this.f4272f.m3587a()) {
            case PRE_GAME:
                mutableComponentAppend = f4261iF.copy().append(" ").append(Component.literal(String.format("(%d/%d)", Integer.valueOf(this.f4272f.f4248a.m3809h().size()), Integer.valueOf(this.f4272f.mo3617aW()))).withStyle(ChatFormatting.GRAY));
                break;
            default:
                mutableComponentAppend = null;
                break;
        }
        MutableComponent mutableComponent = mutableComponentAppend;
        if (mutableComponent != null) {
            m3672a(list, f4286bG, (Component) mutableComponent);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m3672a(@NotNull List<C0862pb> list, @NotNull String str, @NotNull Component component) {
        list.add(new C0862pb(component, 40, true, str));
    }

    /* JADX INFO: renamed from: a */
    protected void m3673a(@NotNull List<C0862pb> list, @NotNull String str, @NotNull Component component, @Nullable Vec3 vec3, int i, int i2) {
        list.add(new C0862pb(component, 40, true, str).m4295a(vec3, i, i2));
    }

    /* JADX INFO: renamed from: co */
    private void m3674co() {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (!f4313gb && localPlayer == null) {
            throw new AssertionError();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        mo3671a(minecraft, localPlayer, (List<C0862pb>) objectArrayList);
        for (C0862pb c0862pb : this.f4284aq) {
            if (m3675a((List<C0862pb>) objectArrayList, c0862pb.getKey()) == null) {
                c0862pb.m4307aS();
            }
        }
        for (C0862pb c0862pb2 : objectArrayList) {
            C0862pb c0862pbM3675a = m3675a(this.f4284aq, c0862pb2.getKey());
            if (c0862pbM3675a != null) {
                c0862pbM3675a.m4306b(c0862pb2.m4309E(), c0862pb2.m4308bj());
                c0862pbM3675a.m4295a(c0862pb2.m4296c(), c0862pb2.m4297bi(), c0862pb2.m4298s());
            } else {
                this.f4284aq.add(c0862pb2);
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static C0862pb m3675a(@NotNull List<C0862pb> list, @Nullable String str) {
        if (str == null) {
            return null;
        }
        for (C0862pb c0862pb : list) {
            if (str.equals(c0862pb.getKey())) {
                return c0862pb;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: aH */
    public float m3677aH() {
        return this.f4308ko;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0797oP m3678a() {
        return this.f4292a;
    }

    /* JADX INFO: renamed from: y */
    public float m3679y(float f) {
        return C1290xm.m7843e(this.f4308ko, this.f4309kp, f);
    }

    /* JADX INFO: renamed from: l */
    public void m3680l(float f) {
        this.f4308ko -= f;
        if (this.f4308ko < 0.0f) {
            this.f4308ko = 0.0f;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Collection<C0124bp> m3681d() {
        return Collections.unmodifiableList(this.f4289as);
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo3682a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0622l c0622l, @NotNull C0324fT c0324fT, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        if (m3692a(minecraft, clientLevel, c0622l, c0324fT)) {
            return;
        }
        if (!RenderSystem.isOnRenderThread()) {
            RenderSystem.recordRenderCall(() -> {
                c0622l.m2695a((AbstractC0787oF<?, ?, ?>) this.f4272f);
            });
        } else {
            c0622l.m2695a((AbstractC0787oF<?, ?, ?>) this.f4272f);
        }
        m3693d(minecraft, localPlayer);
        m3684a(minecraft, c0622l, localPlayer);
        this.f4293a.onUpdate();
        m3688C(minecraft);
        m3689c(minecraft, localPlayer);
        m3683A(minecraft);
        this.f4300kn = this.f4299km;
        boolean z = c0324fT.m1087dk() && c0324fT.m1095cs() <= 20;
        this.f4299km = C1290xm.m7835d(this.f4299km, z ? 1.0f : 0.0f, z ? 0.05f : 0.15f);
        if (!c0622l.m2709a().m3241ay()) {
            m3687B(minecraft);
        }
        m3685l(localPlayer);
        m3695m(localPlayer);
        if (this.f4307a != null) {
            this.f4307a.onUpdate();
        }
        this.f4283ap.removeIf((v0) -> {
            return v0.m4304k();
        });
        this.f4284aq.removeIf((v0) -> {
            return v0.m4304k();
        });
        this.f4288ar.removeIf((v0) -> {
            return v0.m5475k();
        });
        this.f4280an.removeIf(c0876pp -> {
            return c0876pp.m4422a(minecraft, this.f4272f);
        });
        this.f4281K.values().removeIf(abstractC1012sS -> {
            return !abstractC1012sS.mo5485a(minecraft, c0622l, this);
        });
        m3691a(minecraft, localPlayer, clientLevel, set);
        m3697n(localPlayer);
        this.f4291at.removeIf(c0868ph -> {
            return c0868ph.m4358e(localPlayer);
        });
        m3690a(minecraft, localPlayer, clientLevel, c0622l, randomSource, f);
        m3686a(c0622l, set);
    }

    /* JADX INFO: renamed from: A */
    private void m3683A(@NotNull Minecraft minecraft) {
        if (C0424hN.f2740u.m1996T()) {
            int i = this.f4304mM;
            this.f4304mM = i - 1;
            if (i <= 0) {
                this.f4304mM = 20;
                this.f4305iK = Component.literal("FPS: ").withStyle(ChatFormatting.WHITE).append(Component.literal(C1293xp.m7912a(minecraft.getFps())).withStyle(ChatFormatting.GRAY));
                this.f4306mN = minecraft.font.width(this.f4305iK);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3684a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer) {
        if (this.f4272f.f4235a == EnumC0795oN.POST_GAME) {
            return;
        }
        int i = this.f4275mE;
        this.f4275mE = i - 1;
        if (i > 0) {
            return;
        }
        this.f4275mE = f4273mC;
        if (this.f4276am.isEmpty()) {
            return;
        }
        Component component = (Component) this.f4276am.removeFirst();
        if (this.f4272f.f4248a.m3793a(localPlayer.getUUID()) != null) {
            MutableComponent mutableComponentWithColor = Component.literal("\ue013").withColor(ColorReferences.COLOR_WHITE);
            MutableComponent mutableComponentWithStyle = Component.literal(" Tip: ").withStyle(ChatFormatting.DARK_GRAY);
            MutableComponent mutableComponentWithStyle2 = component.copy().withStyle(ChatFormatting.GRAY);
            ChatComponent chat = minecraft.gui.getChat();
            chat.addMessage(Component.empty());
            chat.addMessage(mutableComponentWithColor.append(mutableComponentWithStyle).append(mutableComponentWithStyle2));
            chat.addMessage(Component.empty());
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1280xc.f7577pI.get(), 1.0f));
            String strM3668a = m3668a(component);
            if (strM3668a != null && C0424hN.f2771a.m2011g(strM3668a)) {
                C0427hQ.m2004d(c0622l);
            }
        }
    }

    /* JADX INFO: renamed from: l */
    private void m3685l(@NotNull LocalPlayer localPlayer) {
        this.f4298kl = this.f4297kk;
        this.f4296mI--;
        if (C0424hN.f2731l.m1996T()) {
            this.f4297kk = 0.0f;
        } else if (this.f4296mI <= 0) {
            this.f4297kk = Math.min(this.f4297kk + 0.3f, 1.0f);
        } else {
            this.f4297kk = Math.max(this.f4297kk - 0.2f, 0.0f);
        }
        Inventory inventory = localPlayer.getInventory();
        if (this.f4295mH != inventory.selected) {
            this.f4295mH = inventory.selected;
            this.f4296mI = 30;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3686a(@NotNull C0622l c0622l, @NotNull Set<UUID> set) {
        int i = this.f4302mK;
        this.f4302mK = i + 1;
        if (i >= 200) {
            this.f4302mK = 0;
            C0478iO c0478iOA = ((C0357g) c0622l.m2667b()).m1716a();
            set.forEach(uuid -> {
                c0478iOA.m2165b(RequestType.PLAYER_DATA, uuid);
                c0478iOA.m2165b(RequestType.INVENTORY_MINIMAL, uuid);
            });
        }
    }

    /* JADX INFO: renamed from: B */
    private void m3687B(@NotNull Minecraft minecraft) {
        UUID profileId = minecraft.getUser().getProfileId();
        G g = this.f4272f;
        if ((g instanceof InterfaceC0902qO) && ((InterfaceC0902qO) g).mo4672bB()) {
            C0796oO c0796oOM3793a = this.f4272f.f4248a.m3793a((UUID) Objects.requireNonNull(profileId));
            boolean z = this.f4272f.m3598a(profileId).m3854a(C1089tp.f5692i.getKey(), -1) != -1;
            if (this.f4294mG > 0) {
                this.f4294mG--;
            }
            if (c0796oOM3793a != null && minecraft.screen == null && !z && this.f4294mG <= 0) {
                minecraft.setScreen(m3694a(c0796oOM3793a));
                this.f4294mG = 5;
            }
        }
    }

    /* JADX INFO: renamed from: C */
    private void m3688C(@NotNull Minecraft minecraft) {
        if (this.f4312a.m6017cg()) {
            this.f4312a.m6016n(minecraft);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m3689c(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        Iterator<AbstractC0168cg<G, P>> it = this.f4282ao.iterator();
        while (it.hasNext()) {
            it.next().mo319a(minecraft, this.f4272f, this.f4272f.f4248a, this, localPlayer);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3690a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, float f) {
        this.f4272f.m3653a().m5601a(minecraft, c0622l, this.f4272f, localPlayer, clientLevel, randomSource, f);
    }

    /* JADX INFO: renamed from: a */
    private void m3691a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull Set<UUID> set) {
        int i = this.f4303mL;
        this.f4303mL = i - 1;
        if (i > 0) {
            return;
        }
        this.f4303mL = 20;
        this.f4289as.clear();
        this.f4289as.addAll(m3729a(minecraft, set, localPlayer, clientLevel));
    }

    /* JADX INFO: renamed from: a */
    private boolean m3692a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull C0622l c0622l, @NotNull C0324fT c0324fT) {
        if (m3740bm() && ((C0940r) c0622l.m2667b()).m5133i()) {
            c0622l.m2696a(minecraft, c0324fT, this.f4311b, clientLevel);
            clientLevel.disconnect();
            minecraft.disconnect(new C0235dk());
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    private void m3693d(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        Options options = minecraft.options;
        if (!options.getCameraType().isFirstPerson() && !mo3710g((Player) localPlayer) && !localPlayer.isCreative()) {
            options.setCameraType(CameraType.FIRST_PERSON);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected Screen m3694a(@NotNull C0796oO c0796oO) {
        return new C0144cI(null, c0796oO, this.f4272f, this);
    }

    /* JADX INFO: renamed from: m */
    private void m3695m(@NotNull LocalPlayer localPlayer) {
        this.f4309kp = this.f4308ko;
        if (C0324fT.m1673b(localPlayer) && this.f4272f.mo3608e(localPlayer)) {
            if (this.f4308ko <= 0.0f) {
                localPlayer.setSprinting(false);
                localPlayer.getFoodData().setFoodLevel(1);
            } else if (this.f4308ko > 5.0f) {
                localPlayer.getFoodData().setFoodLevel(20);
            }
            if (localPlayer.isSprinting()) {
                if (this.f4308ko > 0.0f) {
                    this.f4308ko -= m3696aI();
                    return;
                }
                return;
            } else if (this.f4308ko < 20.0d) {
                this.f4308ko += m3669a(localPlayer);
                return;
            } else {
                if (this.f4308ko > 20.0d) {
                    this.f4308ko = 20.0f;
                    return;
                }
                return;
            }
        }
        this.f4308ko = 20.0f;
        localPlayer.getFoodData().setFoodLevel(20);
    }

    /* JADX INFO: renamed from: aI */
    protected float m3696aI() {
        return 0.1f;
    }

    /* JADX INFO: renamed from: n */
    private void m3697n(@NotNull LocalPlayer localPlayer) {
        Inventory inventory = localPlayer.getInventory();
        int i = inventory.selected;
        if (C0799oR.m4033h(localPlayer) || !mo3721bk()) {
            return;
        }
        boolean zIsEmpty = inventory.getItem(i).isEmpty();
        if (this.f4301mJ != i || zIsEmpty) {
            if (zIsEmpty) {
                int iM4034a = C0799oR.m4034a(inventory, i, this.f4301mJ > i || (this.f4301mJ == 0 && i == 8) ? -1 : 1);
                if (!inventory.getItem(iM4034a).isEmpty()) {
                    inventory.selected = iM4034a;
                }
            }
            if (!localPlayer.getMainHandItem().isEmpty() && !inventory.getItem(this.f4301mJ).isEmpty()) {
                C1144ur.f5994hR = false;
            }
        }
        this.f4301mJ = inventory.selected;
    }

    /* JADX INFO: renamed from: a */
    public void m3698a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0324fT c0324fT, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        C0709mh c0709mhM3220b;
        C0710mi c0710miM2709a = c0622l.m2709a();
        c0710miM2709a.m3233c(minecraft, poseStack, guiGraphics, font, i, i2, f2);
        if (c0710miM2709a.m3241ay() && (c0709mhM3220b = c0710miM2709a.m3220b()) != null && !c0709mhM3220b.m3201at()) {
            return;
        }
        Camera mainCamera = minecraft.gameRenderer.getMainCamera();
        Iterator<AbstractC1012sS> it = this.f4281K.values().iterator();
        while (it.hasNext()) {
            it.next().m5487a(this, poseStack, guiGraphics, mainCamera, i, i2, f2);
        }
        mo3704b(minecraft, c0622l, localPlayer, clientLevel, c0324fT, guiGraphics, font, poseStack, multiBufferSource, set, i, i2, i3, i4, f, f2);
        m3700a(guiGraphics, font, poseStack, i, f2);
        m3703b(guiGraphics, font, poseStack, i3, f2);
        m3699b(poseStack, guiGraphics, font);
        m3701a(minecraft, c0622l, localPlayer, clientLevel, guiGraphics, poseStack, font, i3, i4);
    }

    /* JADX INFO: renamed from: b */
    private void m3699b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        if (!C0424hN.f2740u.m1996T() || this.f4305iK == null) {
            return;
        }
        int iM365p = C0119bk.m365p();
        int i = this.f4306mN + 6;
        C0119bk.m415a(guiGraphics, 5, 4, i - 2, 1, iM365p);
        C0119bk.m415a(guiGraphics, 4, 5, i, 13, iM365p);
        C0119bk.m415a(guiGraphics, 5, 18, i - 2, 1, iM365p);
        C0119bk.m399a(poseStack, font, guiGraphics, this.f4305iK, 4 + (i / 2), 8);
    }

    /* JADX INFO: renamed from: a */
    private void m3700a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, int i, float f) {
        int height = 0;
        for (C0862pb c0862pb : this.f4284aq) {
            c0862pb.m4301b(poseStack, guiGraphics, font, height, i, f);
            height += c0862pb.getHeight() + 2;
        }
        for (C0862pb c0862pb2 : this.f4283ap) {
            c0862pb2.m4301b(poseStack, guiGraphics, font, height, i, f);
            height += c0862pb2.getHeight() + 2;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3701a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2) {
        if (!localPlayer.isCreative()) {
            return;
        }
        this.f4272f.m3653a().m5604a(minecraft, c0622l, localPlayer, clientLevel, guiGraphics, poseStack, font, i, i2);
    }

    /* JADX INFO: renamed from: a */
    public void m3702a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, C0324fT c0324fT, float f, float f2, int i) {
        ResourceLocation resourceLocationM1662k = c0324fT.m1662k();
        if (resourceLocationM1662k != null) {
            poseStack.pushPose();
            poseStack.translate(f, f2, 0.0f);
            guiGraphics.blit(resourceLocationM1662k, 0, 0, i, i, 8.0f, 8.0f, 8, 8, 64, 64);
            guiGraphics.blit(resourceLocationM1662k, 0, 0, i, i, 40.0f, 8.0f, 8, 8, 64, 64);
            poseStack.popPose();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m3703b(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, int i, float f) {
        int size = this.f4282ao.size();
        if (size == 0) {
            return;
        }
        if (this.f4287o.length < size) {
            this.f4287o = new int[size];
        }
        int[] iArr = this.f4287o;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            AbstractC0168cg<G, P> abstractC0168cg = this.f4282ao.get(i4);
            if (!abstractC0168cg.mo334s()) {
                iArr[i4] = -1;
            } else {
                int iMo322a = abstractC0168cg.mo322a(font);
                iArr[i4] = iMo322a;
                i2 += iMo322a;
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
                this.f4282ao.get(i6).mo321a(guiGraphics, poseStack, font, i5, 4, f);
                i5 += i7 + 3;
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Component mo3705a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull C0324fT c0324fT) {
        return null;
    }

    /* JADX INFO: renamed from: e */
    public void m3706e(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        DebugScreenOverlay debugOverlay = minecraft.getDebugOverlay();
        if (debugOverlay.showDebugScreen() && !localPlayer.isCreative()) {
            C0466iC.m2099c(minecraft, f4269iH);
            debugOverlay.toggleOverlay();
        }
        if (!minecraft.gameRenderer.effectActive) {
            minecraft.gameRenderer.effectActive = true;
            if (this.f4267fX) {
                this.f4267fX = false;
            } else {
                C0466iC.m2099c(minecraft, f4271iJ);
            }
        }
        EntityRenderDispatcher entityRenderDispatcher = minecraft.getEntityRenderDispatcher();
        if (entityRenderDispatcher.shouldRenderHitBoxes() && !localPlayer.isCreative()) {
            C0466iC.m2099c(minecraft, f4268iG);
            entityRenderDispatcher.setRenderHitBoxes(false);
        }
        OptionInstance optionInstanceMainHand = minecraft.options.mainHand();
        if (optionInstanceMainHand.get() != HumanoidArm.RIGHT) {
            optionInstanceMainHand.set(HumanoidArm.RIGHT);
            minecraft.options.broadcastOptions();
            C0466iC.m2099c(minecraft, f4270iI);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: x */
    public List<C0868ph> m3707x() {
        return Collections.unmodifiableList(this.f4291at);
    }

    /* JADX INFO: renamed from: cp */
    public void m3708cp() {
        this.f4291at.removeIf(c0868ph -> {
            return c0868ph.m4360a().isWaypoint();
        });
    }

    /* JADX INFO: renamed from: a */
    public void m3709a(@NotNull C0868ph c0868ph) {
        this.f4291at.add(c0868ph);
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
    /* JADX INFO: renamed from: a */
    public void m3712a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull C0482iS c0482iS, int i, int i2, float f) {
        UUID uuidQ;
        int i3 = i2 / 2;
        if (C0424hN.f2738s.m1996T()) {
            C0119bk.m525k(minecraft);
        }
        P p = this.f4272f.f4248a;
        C0796oO c0796oOM3793a = p.m3793a(localPlayer.getUUID());
        if (c0796oOM3793a != null || c0622l.m2690e()) {
            C0796oO c0796oOM3793a2 = c0796oOM3793a;
            if (c0796oOM3793a2 == null && (uuidQ = ((C0326fV) c0622l.m2670a()).m1675a(minecraft).m1099q()) != null) {
                c0796oOM3793a2 = p.m3793a(uuidQ);
            }
            int color = c0796oOM3793a2 != null ? c0796oOM3793a2.getColor() : ColorReferences.COLOR_WHITE_SOLID;
            int iM3878aY = c0796oOM3793a2 != null ? c0796oOM3793a2.m3878aY() : ColorReferences.COLOR_WHITE;
            if (C0424hN.f2737r.m1996T()) {
                C0119bk.m423a(guiGraphics, 0, i3, i, i3, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
                C0119bk.m417a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID, 0.25f);
                C0119bk.m417a(guiGraphics, 0, 0, i, i2, color, 0.15f);
            }
            C0119bk.m447b(poseStack, guiGraphics, f4256dF, (i - 10) - 16, 25, 16, 16, 0.0f, 1.0f, iM3878aY);
            MutableComponent mutableComponentWithColor = Component.literal(this.f4292a.m3894d().getString()).withColor(iM3878aY);
            C0119bk.m387a(poseStack, font, guiGraphics, (Component) mutableComponentWithColor, (((i - 10) - 16) - (font.width(mutableComponentWithColor) * 2)) - 10, 18, 2.0f);
            C0119bk.m415a(guiGraphics, 0, 49, i, 1, 301989887);
            C0119bk.m423a(guiGraphics, 0, 50, i, 8, ColorReferences.COLOR_BLACK_SOLID - (-872415232), ColorReferences.COLOR_BLACK_TRANSPARENT);
            this.f4293a.m5987a(poseStack, font, guiGraphics, this.f4272f, 0, 0, i, 49, color, iM3878aY, f);
            List<C0796oO> listM3808A = p.m3808A();
            int size = listM3808A.size();
            if (size == 0) {
                return;
            }
            Set<UUID> setM3810i = p.m3810i();
            boolean z = !setM3810i.isEmpty();
            int i4 = size + (z ? 1 : 0);
            int i5 = (i - f4263mA) / 2;
            int i6 = ((((i2 - 50) - 13) - 2) - ((i4 + 1) * 5)) / i4;
            int i7 = 68;
            C0119bk.m499a(poseStack, minecraft, c0622l, this.f4311b, c0482iS, guiGraphics, font, this.f4272f, this, null, Style.EMPTY, this.f4290a.m3766g(), i5, 51.0f, 350.0f, 13.0f, 3);
            float fSin = (Mth.sin(C0119bk.m366g() / 120.0f) + 1.0f) / 2.0f;
            int i8 = (i - f4263mA) / 2;
            for (C0796oO c0796oO : listM3808A) {
                SortedSet<UUID> sortedSetM3950a = C0799oR.m3950a((AbstractC0787oF<?, ?, ?>) this.f4272f, c0796oO.m3872h(), this.f4272f.m3644a());
                int i9 = 0;
                if (sortedSetM3950a.size() * 11 > i6) {
                    i9 = (int) (fSin * (r0 - i6));
                }
                int i10 = i7 + 15;
                int iM3878aY2 = c0796oO.m3878aY();
                C1074ta c1074taM3860a = c0796oO.m3860a((AbstractC0787oF<?, ?, ?>) this.f4272f);
                C0119bk.m439b(poseStack, guiGraphics, c1074taM3860a.m5976a().m5670N(), i8 / 2, i10, 25);
                int i11 = (i10 + 25) - 5;
                ObjectListIterator it = C0471iH.m2131a(font, c1074taM3860a.m5976a().getName(), i8).iterator();
                while (it.hasNext()) {
                    String strTrim = ((String) it.next()).trim();
                    if (!strTrim.isEmpty()) {
                        C0119bk.m383c(font, guiGraphics, (Component) Component.literal(strTrim).withColor(iM3878aY2), i8 / 2, i11);
                        i11 += 10;
                    }
                }
                poseStack.pushPose();
                C0119bk.m517a(guiGraphics, i5, i7, f4263mA, i6);
                m3713a(poseStack, minecraft, c0622l, localPlayer, this.f4311b, c0482iS, guiGraphics, font, c0796oO, i5, i7 - i9, sortedSetM3950a);
                guiGraphics.disableScissor();
                poseStack.popPose();
                i7 += i6 + 5;
            }
            if (z) {
                int i12 = 0;
                if (setM3810i.size() * 11 > i6) {
                    i12 = (int) (fSin * (r0 - i6));
                }
                int i13 = i7 + 15;
                C0119bk.m439b(poseStack, guiGraphics, f4259dI, i8 / 2, i13, 25);
                int i14 = (i13 + 25) - 5;
                ObjectListIterator it2 = C0471iH.m2131a(font, Component.translatable("bf.scoreboard.spectators.title").getString(), i8).iterator();
                while (it2.hasNext()) {
                    String strTrim2 = ((String) it2.next()).trim();
                    if (!strTrim2.isEmpty()) {
                        C0119bk.m383c(font, guiGraphics, (Component) Component.literal(strTrim2).withStyle(ChatFormatting.GRAY), i8 / 2, i14);
                        i14 += 10;
                    }
                }
                poseStack.pushPose();
                C0119bk.m517a(guiGraphics, i5, i7, f4263mA, i6);
                m3714a(poseStack, minecraft, c0622l, this.f4311b, c0482iS, guiGraphics, font, setM3810i, i5, i7 - i12);
                guiGraphics.disableScissor();
                poseStack.popPose();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3713a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C0796oO c0796oO, int i, int i2, @NotNull Set<UUID> set) {
        ClientPacketListener clientPacketListener = localPlayer.connection;
        Style styleM3876a = c0796oO.m3876a();
        int i3 = 0;
        for (UUID uuid : set) {
            C0794oM c0794oMM3598a = this.f4272f.m3598a(uuid);
            C0324fT c0324fTB = c0326fV.m1135b(uuid);
            PlayerInfo playerInfo = clientPacketListener.getPlayerInfo(uuid);
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator<TriFunction<C0324fT, PlayerInfo, C0794oM, String>> it = this.f4290a.f4315L.values().iterator();
            while (it.hasNext()) {
                objectArrayList.add((String) it.next().apply(c0324fTB, playerInfo, c0794oMM3598a));
            }
            C0119bk.m499a(poseStack, minecraft, c0622l, c0326fV, c0482iS, guiGraphics, font, this.f4272f, this, uuid, styleM3876a, objectArrayList, i, i2 + i3, 350.0f, 10.0f, 1);
            i3 += 11;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3714a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull C0482iS c0482iS, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Set<UUID> set, int i, int i2) {
        int i3 = 0;
        Iterator<UUID> it = set.iterator();
        while (it.hasNext()) {
            C0119bk.m499a(poseStack, minecraft, c0622l, c0326fV, c0482iS, guiGraphics, font, this.f4272f, this, it.next(), Style.EMPTY, List.of(), i, i2 + i3, 350.0f, 10.0f, 1);
            i3 += 11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0056 A[SYNTHETIC] */
    @javax.annotation.OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo3715a(@org.jetbrains.annotations.NotNull com.boehmod.blockfront.AbstractC0790oI<?> r17, @org.jetbrains.annotations.NotNull net.minecraft.client.Minecraft r18, @org.jetbrains.annotations.NotNull net.minecraft.client.multiplayer.ClientLevel r19, @org.jetbrains.annotations.NotNull net.minecraft.client.player.LocalPlayer r20, @org.jetbrains.annotations.NotNull net.neoforged.neoforge.client.event.RenderLevelStageEvent r21, @org.jetbrains.annotations.NotNull net.minecraft.client.renderer.MultiBufferSource.BufferSource r22, @org.jetbrains.annotations.NotNull com.mojang.blaze3d.vertex.PoseStack r23, @org.jetbrains.annotations.NotNull net.minecraft.client.renderer.culling.Frustum r24, @org.jetbrains.annotations.NotNull net.minecraft.client.gui.Font r25, @org.jetbrains.annotations.NotNull net.minecraft.client.gui.GuiGraphics r26, @org.jetbrains.annotations.NotNull net.minecraft.client.Camera r27, boolean r28, float r29, float r30) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.boehmod.blockfront.AbstractC0788oG.mo3715a(com.boehmod.blockfront.oI, net.minecraft.client.Minecraft, net.minecraft.client.multiplayer.ClientLevel, net.minecraft.client.player.LocalPlayer, net.neoforged.neoforge.client.event.RenderLevelStageEvent, net.minecraft.client.renderer.MultiBufferSource$BufferSource, com.mojang.blaze3d.vertex.PoseStack, net.minecraft.client.renderer.culling.Frustum, net.minecraft.client.gui.Font, net.minecraft.client.gui.GuiGraphics, net.minecraft.client.Camera, boolean, float, float):void");
    }

    /* JADX INFO: renamed from: a */
    private void m3716a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera) {
        P p = this.f4272f.f4248a;
        if (p.f4341e != null) {
            C0119bk.m518a(poseStack, font, camera, guiGraphics, (Component) Component.literal("LOBBY SPAWN").withStyle(ChatFormatting.YELLOW), p.f4341e.f4424c.x, p.f4341e.f4424c.y + 0.5d, p.f4341e.f4424c.z);
            C0119bk.m503a(poseStack, camera, guiGraphics, f4258dH, p.f4341e.f4424c.x, p.f4341e.f4424c.y + 1.25d, p.f4341e.f4424c.z, 64);
        }
        MutableComponent mutableComponentLiteral = Component.literal("SPAWN POINT");
        for (C0796oO c0796oO : p.m3808A()) {
            MutableComponent mutableComponentAppend = Component.literal("Team: ").append(Component.literal(c0796oO.getName()).withStyle(c0796oO.m3876a()));
            for (C0805oX c0805oX : c0796oO.m3873B()) {
                C0119bk.m518a(poseStack, font, camera, guiGraphics, (Component) mutableComponentLiteral, c0805oX.f4424c.x, c0805oX.f4424c.y + 1.2000000476837158d, c0805oX.f4424c.z);
                C0119bk.m518a(poseStack, font, camera, guiGraphics, (Component) mutableComponentAppend, c0805oX.f4424c.x, c0805oX.f4424c.y + 0.800000011920929d, c0805oX.f4424c.z);
                C0119bk.m503a(poseStack, camera, guiGraphics, f4257dG, c0805oX.f4424c.x, c0805oX.f4424c.y + 1.75d, c0805oX.f4424c.z, 64);
            }
        }
    }

    /* JADX INFO: renamed from: bi */
    public boolean mo3719bi() {
        return true;
    }

    /* JADX INFO: renamed from: bj */
    public boolean mo3720bj() {
        return true;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public G m3722a() {
        return this.f4272f;
    }

    /* JADX INFO: renamed from: bl */
    public boolean m3723bl() {
        return this.f4277fY;
    }

    /* JADX INFO: renamed from: N */
    public void m3724N(boolean z) {
        this.f4277fY = z;
    }

    /* JADX INFO: renamed from: aJ */
    public float m3725aJ() {
        return this.f4278kj;
    }

    /* JADX INFO: renamed from: m */
    public void m3726m(float f) {
        this.f4278kj = f;
    }

    /* JADX INFO: renamed from: O */
    public void m3727O(boolean z) {
        if (z && !this.f4279fZ) {
            this.f4277fY = false;
            this.f4278kj = 0.0f;
        }
        this.f4279fZ = z;
    }

    /* JADX INFO: renamed from: z */
    protected static float m3728z(float f) {
        return C1290xm.m7863i(f, f4265kh, f4266ki);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C0124bp> m3729a(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.addAll(mo3730b(minecraft, set, localPlayer, clientLevel));
        return objectArrayList;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo3732a(@NotNull UUID uuid, @Nullable String str, @NotNull Set<UUID> set) {
        C1074ta c1074taM3623a;
        C1074ta c1074taM3624b;
        if (!set.contains(uuid)) {
            return null;
        }
        ResourceLocation resourceLocationM2555d = null;
        C0796oO c0796oOM3793a = this.f4272f.f4248a.m3793a(uuid);
        if (c0796oOM3793a != null) {
            c1074taM3623a = this.f4272f.m3623a();
            c1074taM3624b = this.f4272f.m3624b();
            switch (c0796oOM3793a.getName()) {
                case "Allies":
                    resourceLocationM2555d = C0564jv.m2555d("textures/skins/game/nations/" + c1074taM3623a.m5976a().m5669ao() + "/" + c1074taM3623a.getSkin() + "/" + str + ".png");
                    break;
                case "Axis":
                    resourceLocationM2555d = C0564jv.m2555d("textures/skins/game/nations/" + c1074taM3624b.m5976a().m5669ao() + "/" + c1074taM3624b.getSkin() + "/" + str + ".png");
                    break;
            }
        }
        return resourceLocationM2555d;
    }

    /* JADX INFO: renamed from: f */
    public void m3733f(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        UUID uuid = localPlayer.getUUID();
        C0324fT c0324fT = (C0324fT) this.f4311b.m1133a((Player) localPlayer);
        G g = this.f4272f;
        if (g instanceof InterfaceC0907qT) {
            InterfaceC0907qT interfaceC0907qT = (InterfaceC0907qT) g;
            if (C0799oR.m4052a((Player) localPlayer, (AbstractC0182b<?, ?, ?, ?>) c0324fT)) {
                return;
            }
            if (!interfaceC0907qT.mo4680a(uuid).isEmpty()) {
                minecraft.setScreen(new C0161cZ(interfaceC0907qT));
            }
        }
        if (this.f4272f instanceof InterfaceC0902qO) {
            C0796oO c0796oOM3793a = this.f4272f.f4248a.m3793a(uuid);
            if (!(minecraft.screen instanceof AbstractC0143cH) && c0796oOM3793a != null) {
                minecraft.setScreen(m3694a(c0796oOM3793a));
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Map<C1015sV, ObjectList<C0866pf>> m3734a(@NotNull C0796oO c0796oO) {
        return c0796oO.m3860a((AbstractC0787oF<?, ?, ?>) this.f4272f).m5977r();
    }

    /* JADX INFO: renamed from: a */
    public void m3735a(@NotNull Minecraft minecraft, @NotNull C0876pp c0876pp) {
        c0876pp.m4432D(minecraft);
        c0876pp.m4428m(minecraft);
        this.f4280an.add(c0876pp);
        if (this.f4280an.size() > 5) {
            this.f4280an.removeFirst();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3736a(@NotNull C1010sQ c1010sQ) {
        this.f4288ar.add(c1010sQ);
        while (this.f4288ar.size() > 8) {
            this.f4288ar.removeFirst();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1011sR m3737a() {
        return this.f4307a;
    }

    /* JADX INFO: renamed from: a */
    public void m3738a(@NotNull C1011sR c1011sR) {
        this.f4307a = c1011sR;
    }

    /* JADX INFO: renamed from: b */
    public void m3739b(@NotNull ByteBuf byteBuf) throws IOException {
        if (IPacket.readBoolean(byteBuf)) {
            this.f4292a.m3901b(byteBuf);
        }
        this.f4310ga = IPacket.readBoolean(byteBuf);
        m3674co();
    }

    /* JADX INFO: renamed from: bm */
    public boolean m3740bm() {
        return this.f4310ga;
    }

    @NotNull
    /* JADX INFO: renamed from: y */
    public List<C0876pp> m3741y() {
        return Collections.unmodifiableList(this.f4280an);
    }

    @NotNull
    /* JADX INFO: renamed from: z */
    public List<C1010sQ> m3742z() {
        return Collections.unmodifiableList(this.f4288ar);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected Collection<? extends AbstractC0156cU> m3744a(G g, boolean z) {
        if (z) {
            return List.of(new C0154cS(g));
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b != null && c0622lM2667b.m2689d()) {
            return List.of(new C0159cX(g, m3745b()), new C0154cS(g));
        }
        return List.of(new C0157cV(g.m3628e(), this), new C0159cX(g, m3745b()), new C0154cS(g));
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    protected C1088to m3745b() {
        return C1089tp.f5695l;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1090tq m3746a() {
        return this.f4312a;
    }

    public void stop() {
    }

    /* JADX INFO: renamed from: a */
    public void m3747a(@NotNull AbstractC1012sS abstractC1012sS) {
        UUID uuidM5481h = abstractC1012sS.m5481h();
        this.f4281K.values().removeIf(abstractC1012sS2 -> {
            return (abstractC1012sS2 instanceof C1013sT) && abstractC1012sS2.m5481h().equals(uuidM5481h);
        });
        if (this.f4281K.containsKey(abstractC1012sS.m5482i())) {
            return;
        }
        this.f4281K.put(abstractC1012sS.m5482i(), abstractC1012sS);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC1012sS m3748a(@NotNull UUID uuid) {
        return this.f4281K.get(uuid);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC1012sS m3749a(@NotNull Vec3 vec3, double d) {
        AbstractC1012sS abstractC1012sS = null;
        double d2 = d * d;
        for (AbstractC1012sS abstractC1012sS2 : this.f4281K.values()) {
            double dDistanceToSqr = abstractC1012sS2.m5484c().distanceToSqr(vec3);
            if (dDistanceToSqr < d2) {
                d2 = dDistanceToSqr;
                abstractC1012sS = abstractC1012sS2;
            }
        }
        return abstractC1012sS;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public void m3750a(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        if (this instanceof InterfaceC0897qJ) {
            InterfaceC0897qJ interfaceC0897qJ = (InterfaceC0897qJ) this;
            AbstractC1012sS abstractC1012sS = this.f4281K.get(uuid);
            if (abstractC1012sS != null && !abstractC1012sS.m5493bR() && interfaceC0897qJ.mo4649a(abstractC1012sS, uuid2, vec3)) {
                abstractC1012sS.m5483o(vec3);
                abstractC1012sS.m5491cT();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3751a(@NotNull Component component, int i) {
        m3754a(List.of(component), i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public void m3752a(@NotNull Component component, int i, @Nullable String str) {
        m3754a(List.of(component), i, str);
    }

    /* JADX INFO: renamed from: a */
    public void m3753a(@NotNull List<Component> list, int i) {
        m3754a(list, i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public void m3754a(@NotNull List<Component> list, int i, @Nullable String str) {
        m3755a(list, i, str, (Vec3) null, ColorReferences.COLOR_WHITE, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    public void m3755a(@NotNull List<Component> list, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        C0862pb c0862pbM4295a = new C0862pb(list, i, true, str).m4295a(vec3, i2, i3);
        if (str != null) {
            for (int i4 = 0; i4 < this.f4283ap.size(); i4++) {
                if (str.equals(this.f4283ap.get(i4).getKey())) {
                    this.f4283ap.set(i4, c0862pbM4295a);
                    return;
                }
            }
        }
        this.f4283ap.add(c0862pbM4295a);
        while (this.f4283ap.size() > 3) {
            this.f4283ap.removeFirst();
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.oG$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oG$a.class */
    public static class a {

        /* JADX INFO: renamed from: L */
        @NotNull
        private final Map<String, TriFunction<C0324fT, PlayerInfo, C0794oM, String>> f4315L = new Object2ObjectLinkedOpenHashMap();

        @NotNull
        /* JADX INFO: renamed from: a */
        public a m3765a(@NotNull String str, @NotNull TriFunction<C0324fT, PlayerInfo, C0794oM, String> triFunction) {
            this.f4315L.put(str, triFunction);
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: g */
        public Set<String> m3766g() {
            return this.f4315L.keySet();
        }
    }
}
