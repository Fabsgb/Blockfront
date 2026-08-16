package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.RequestType;
import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0863pb;
import com.boehmod.blockfront.AbstractC0866pe;
import com.boehmod.blockfront.common.player.AbstractC0183b;
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
import java.util.Optional;
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
import net.minecraft.client.renderer.culling.Frustum;
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
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.neoforge.client.event.RenderNameTagEvent;
import org.apache.commons.lang3.function.TriFunction;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.pc */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pc.class */
public abstract class AbstractC0864pc<G extends AbstractC0863pb<G, P, ?>, P extends AbstractC0866pe<G>> {

    /* JADX INFO: renamed from: ov */
    private static final int f4649ov = 200;

    /* JADX INFO: renamed from: dD */
    @NotNull
    private static final ResourceLocation f4650dD;

    /* JADX INFO: renamed from: dE */
    @NotNull
    private static final ResourceLocation f4651dE;

    /* JADX INFO: renamed from: dF */
    @NotNull
    private static final ResourceLocation f4652dF;

    /* JADX INFO: renamed from: dG */
    @NotNull
    private static final ResourceLocation f4653dG;

    /* JADX INFO: renamed from: ow */
    private static final int f4654ow = 8;

    /* JADX INFO: renamed from: iR */
    @NotNull
    private static final Component f4655iR;

    /* JADX INFO: renamed from: ox */
    private static final int f4656ox = 3;

    /* JADX INFO: renamed from: oy */
    private static final int f4657oy = 350;

    /* JADX INFO: renamed from: oz */
    private static final int f4658oz = 25;

    /* JADX INFO: renamed from: la */
    protected static final float f4659la = 32.0f;

    /* JADX INFO: renamed from: lb */
    protected static final float f4660lb = 35.0f;

    /* JADX INFO: renamed from: iS */
    @NotNull
    private static final Component f4662iS;

    /* JADX INFO: renamed from: iT */
    @NotNull
    private static final Component f4663iT;

    /* JADX INFO: renamed from: iU */
    @NotNull
    private static final Component f4664iU;

    /* JADX INFO: renamed from: iV */
    @NotNull
    private static final Component f4665iV;

    /* JADX INFO: renamed from: f */
    @NotNull
    protected final G f4666f;

    /* JADX INFO: renamed from: oA */
    private static final int f4667oA = 220;

    /* JADX INFO: renamed from: oB */
    private static final int f4668oB = 20;

    /* JADX INFO: renamed from: oD */
    private static final int f4679oD = 40;

    /* JADX INFO: renamed from: bP */
    private static final String f4680bP = "match_status";

    /* JADX INFO: renamed from: ld */
    public float f4691ld;

    /* JADX INFO: renamed from: lf */
    public float f4693lf;

    /* JADX INFO: renamed from: lh */
    private float f4702lh;

    /* JADX INFO: renamed from: b */
    @NotNull
    protected final C0396gl f4705b;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1063tO f4706a;

    /* JADX INFO: renamed from: gv */
    static final /* synthetic */ boolean f4707gv;

    /* JADX INFO: renamed from: gr */
    private boolean f4661gr = true;

    /* JADX INFO: renamed from: oC */
    private int f4669oC = f4667oA;

    /* JADX INFO: renamed from: at */
    @NotNull
    private final List<Component> f4670at = m4103x();

    /* JADX INFO: renamed from: gs */
    private boolean f4671gs = false;

    /* JADX INFO: renamed from: lc */
    private float f4672lc = 0.0f;

    /* JADX INFO: renamed from: gt */
    private boolean f4673gt = false;

    /* JADX INFO: renamed from: au */
    @NotNull
    private final List<C0847pL> f4674au = new ObjectArrayList();

    /* JADX INFO: renamed from: K */
    @NotNull
    private final Map<UUID, AbstractC1090tp> f4675K = new Object2ObjectLinkedOpenHashMap();

    /* JADX INFO: renamed from: aw */
    @NotNull
    private final List<C0885px> f4677aw = new ObjectArrayList();

    /* JADX INFO: renamed from: ax */
    @NotNull
    private final List<C0885px> f4678ax = new ObjectArrayList();

    /* JADX INFO: renamed from: q */
    private int[] f4681q = new int[8];

    /* JADX INFO: renamed from: ay */
    @NotNull
    private final List<C1088tn> f4682ay = new ObjectArrayList();

    /* JADX INFO: renamed from: az */
    @NotNull
    private final List<C0134by> f4683az = new ObjectArrayList();

    /* JADX INFO: renamed from: aA */
    @NotNull
    private final List<C0839pD> f4685aA = new ObjectArrayList();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C0873pl f4686a = new C0873pl();

    /* JADX INFO: renamed from: a */
    @NotNull
    private final C1050tB f4687a = new C1050tB();

    /* JADX INFO: renamed from: oE */
    public int f4688oE = 0;

    /* JADX INFO: renamed from: oF */
    private int f4689oF = 0;

    /* JADX INFO: renamed from: oG */
    private int f4690oG = 0;

    /* JADX INFO: renamed from: le */
    public float f4692le = 0.0f;

    /* JADX INFO: renamed from: lg */
    public float f4694lg = 0.0f;

    /* JADX INFO: renamed from: oH */
    private int f4695oH = 0;

    /* JADX INFO: renamed from: oI */
    protected int f4696oI = 0;

    /* JADX INFO: renamed from: oJ */
    private int f4697oJ = 0;

    /* JADX INFO: renamed from: oK */
    private int f4698oK = 0;

    /* JADX INFO: renamed from: iW */
    @Nullable
    private Component f4699iW = null;

    /* JADX INFO: renamed from: oL */
    private int f4700oL = 0;

    /* JADX INFO: renamed from: a */
    @Nullable
    private C1089to f4701a = null;

    /* JADX INFO: renamed from: li */
    private float f4703li = 20.0f;

    /* JADX INFO: renamed from: gu */
    private boolean f4704gu = false;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final a f4684a = mo4147a();

    /* JADX INFO: renamed from: av */
    @NotNull
    private final List<AbstractC0188cp<G, P>> f4676av = mo4106y();

    @NotNull
    /* JADX INFO: renamed from: w */
    protected abstract List<Component> mo4102w();

    @NotNull
    /* JADX INFO: renamed from: y */
    protected abstract List<AbstractC0188cp<G, P>> mo4106y();

    /* JADX INFO: renamed from: a */
    public abstract boolean mo4112a(@NotNull AbstractClientPlayer abstractClientPlayer);

    /* JADX INFO: renamed from: b */
    public abstract void mo4140b(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2);

    /* JADX INFO: renamed from: g */
    public abstract boolean mo4146g(@NotNull Player player);

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract a mo4147a();

    /* JADX INFO: renamed from: br */
    public abstract boolean mo4153br();

    /* JADX INFO: renamed from: a */
    public abstract boolean mo4154a(@NotNull Minecraft minecraft, @NotNull LivingEntity livingEntity, @NotNull Player player, @NotNull ClientLevel clientLevel);

    /* JADX INFO: renamed from: bu */
    public abstract boolean mo4157bu();

    @NotNull
    /* JADX INFO: renamed from: b */
    public abstract List<C0134by> mo4166b(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel);

    /* JADX INFO: renamed from: a */
    public abstract void mo4167a(@NotNull Minecraft minecraft, @NotNull RenderNameTagEvent renderNameTagEvent, @NotNull Player player, @NotNull ClientLevel clientLevel);

    @NotNull
    /* JADX INFO: renamed from: a */
    public abstract Collection<? extends AbstractC0229dd> mo4179a(boolean z);

    static {
        f4707gv = !AbstractC0864pc.class.desiredAssertionStatus();
        f4650dD = C0532jO.m2378d("textures/gui/stopwatch.png");
        f4651dE = C0532jO.m2378d("textures/gui/menu/icons/player.png");
        f4652dF = C0532jO.m2378d("textures/gui/menu/icons/friends.png");
        f4653dG = C0532jO.m2378d("textures/misc/bfneutralicon.png");
        f4655iR = Component.translatable("bf.message.match.title.waiting");
        f4662iS = Component.translatable("bf.message.debug.hitbox").withStyle(ChatFormatting.RED);
        f4663iT = Component.translatable("bf.message.debug.overlay").withStyle(ChatFormatting.RED);
        f4664iU = Component.translatable("bf.message.right.hand").withStyle(ChatFormatting.RED);
        f4665iV = Component.translatable("bf.message.shader").withStyle(ChatFormatting.RED);
    }

    @NotNull
    /* JADX INFO: renamed from: x */
    private List<Component> m4103x() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (Component component : mo4102w()) {
            String strM4104a = m4104a(component);
            if (strM4104a == null || !C0495ie.f3072a.m2244h(strM4104a)) {
                objectArrayList.add(component);
            }
        }
        return objectArrayList;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static String m4104a(@NotNull Component component) {
        TranslatableContents contents = component.getContents();
        if (contents instanceof TranslatableContents) {
            return contents.getKey();
        }
        return null;
    }

    public AbstractC0864pc(@NotNull C0623l c0623l, @NotNull G g, @NotNull C0396gl c0396gl) {
        this.f4666f = g;
        this.f4705b = c0396gl;
        this.f4706a = new C1063tO(c0623l, this);
    }

    /* JADX INFO: renamed from: a */
    private static float m4105a(@NotNull LocalPlayer localPlayer) {
        return localPlayer.isShiftKeyDown() ? 0.4f : 0.3f;
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    protected void mo4107a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull List<C0885px> list) {
        MutableComponent mutableComponentAppend;
        switch (this.f4666f.m4023a()) {
            case PRE_GAME:
                mutableComponentAppend = f4655iR.copy().append(" ").append(Component.literal(String.format("(%d/%d)", Integer.valueOf(this.f4666f.f4642a.m4245h().size()), Integer.valueOf(this.f4666f.mo4053bl()))).withStyle(ChatFormatting.GRAY));
                break;
            default:
                mutableComponentAppend = null;
                break;
        }
        MutableComponent mutableComponent = mutableComponentAppend;
        if (mutableComponent != null) {
            m4108a(list, f4680bP, (Component) mutableComponent);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m4108a(@NotNull List<C0885px> list, @NotNull String str, @NotNull Component component) {
        list.add(new C0885px(component, 40, true, str));
    }

    /* JADX INFO: renamed from: a */
    protected void m4109a(@NotNull List<C0885px> list, @NotNull String str, @NotNull Component component, @Nullable Vec3 vec3, int i, int i2) {
        list.add(new C0885px(component, 40, true, str).m4620a(vec3, i, i2));
    }

    /* JADX INFO: renamed from: cA */
    private void m4110cA() {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        if (!f4707gv && localPlayer == null) {
            throw new AssertionError();
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        mo4107a(minecraft, localPlayer, (List<C0885px>) objectArrayList);
        for (C0885px c0885px : this.f4678ax) {
            if (m4111a((List<C0885px>) objectArrayList, c0885px.getKey()) == null) {
                c0885px.m4632ba();
            }
        }
        for (C0885px c0885px2 : objectArrayList) {
            C0885px c0885pxM4111a = m4111a(this.f4678ax, c0885px2.getKey());
            if (c0885pxM4111a != null) {
                c0885pxM4111a.m4631b(c0885px2.m4634G(), c0885px2.m4633by());
                c0885pxM4111a.m4620a(c0885px2.m4621c(), c0885px2.m4622bx(), c0885px2.m4623w());
            } else {
                this.f4678ax.add(c0885px2);
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static C0885px m4111a(@NotNull List<C0885px> list, @Nullable String str) {
        if (str == null) {
            return null;
        }
        for (C0885px c0885px : list) {
            if (str.equals(c0885px.getKey())) {
                return c0885px;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: aN */
    public float m4113aN() {
        return this.f4702lh;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0873pl m4114a() {
        return this.f4686a;
    }

    /* JADX INFO: renamed from: B */
    public float m4115B(float f) {
        return C1270xJ.m7170f(this.f4702lh, this.f4703li, f);
    }

    /* JADX INFO: renamed from: k */
    public void m4116k(float f) {
        this.f4702lh -= f;
        if (this.f4702lh < 0.0f) {
            this.f4702lh = 0.0f;
        }
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public Collection<C0134by> m4117d() {
        return Collections.unmodifiableList(this.f4683az);
    }

    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo4118a(@NotNull Minecraft minecraft, @NotNull Random random, @NotNull RandomSource randomSource, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0623l c0623l, @NotNull C0394gj c0394gj, @NotNull Set<UUID> set, float f, @NotNull Vec3 vec3, @NotNull BlockPos blockPos) {
        if (m4128a(minecraft, clientLevel, c0623l, c0394gj)) {
            return;
        }
        if (!RenderSystem.isOnRenderThread()) {
            RenderSystem.recordRenderCall(() -> {
                c0623l.m2881a((AbstractC0863pb<?, ?, ?>) this.f4666f);
            });
        } else {
            c0623l.m2881a((AbstractC0863pb<?, ?, ?>) this.f4666f);
        }
        m4129e(minecraft, localPlayer);
        m4120a(minecraft, c0623l, localPlayer);
        this.f4687a.onUpdate();
        m4124E(minecraft);
        m4125d(minecraft, localPlayer);
        m4119C(minecraft);
        this.f4694lg = this.f4693lf;
        boolean z = c0394gj.m1104dt() && c0394gj.m1112cI() <= 20;
        this.f4693lf = C1270xJ.m7161d(this.f4693lf, z ? 1.0f : 0.0f, z ? 0.05f : 0.15f);
        if (!c0623l.m2895a().m3074aJ()) {
            m4123D(minecraft);
        }
        m4121l(localPlayer);
        m4131m(localPlayer);
        if (this.f4701a != null) {
            this.f4701a.onUpdate();
        }
        this.f4677aw.removeIf((v0) -> {
            return v0.m4629l();
        });
        this.f4678ax.removeIf((v0) -> {
            return v0.m4629l();
        });
        this.f4682ay.removeIf((v0) -> {
            return v0.m5963l();
        });
        this.f4674au.removeIf(c0847pL -> {
            return c0847pL.m3910a(minecraft, this.f4666f);
        });
        this.f4675K.values().removeIf(abstractC1090tp -> {
            return !abstractC1090tp.mo5973a(minecraft, c0623l, this);
        });
        m4127a(minecraft, localPlayer, clientLevel, set);
        m4133n(localPlayer);
        this.f4685aA.removeIf(c0839pD -> {
            return c0839pD.m3843e(localPlayer);
        });
        m4126a(minecraft, localPlayer, clientLevel, c0623l, randomSource, f);
        m4122a(c0623l, set);
    }

    /* JADX INFO: renamed from: C */
    private void m4119C(@NotNull Minecraft minecraft) {
        if (C0495ie.f3041u.m2230U()) {
            int i = this.f4698oK;
            this.f4698oK = i - 1;
            if (i <= 0) {
                this.f4698oK = 20;
                this.f4699iW = Component.literal("FPS: ").withStyle(ChatFormatting.WHITE).append(Component.literal(C1273xM.m7239b(minecraft.getFps())).withStyle(ChatFormatting.GRAY));
                this.f4700oL = minecraft.font.width(this.f4699iW);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4120a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer) {
        if (this.f4666f.f4629a == EnumC0871pj.POST_GAME) {
            return;
        }
        int i = this.f4669oC;
        this.f4669oC = i - 1;
        if (i > 0) {
            return;
        }
        this.f4669oC = f4667oA;
        if (this.f4670at.isEmpty()) {
            return;
        }
        Component component = (Component) this.f4670at.removeFirst();
        if (this.f4666f.f4642a.m4229a(localPlayer.getUUID()) != null) {
            MutableComponent mutableComponentWithColor = Component.literal("\ue013").withColor(ColorReferences.COLOR_WHITE);
            MutableComponent mutableComponentWithStyle = Component.literal(" Tip: ").withStyle(ChatFormatting.DARK_GRAY);
            MutableComponent mutableComponentWithStyle2 = component.copy().withStyle(ChatFormatting.GRAY);
            ChatComponent chat = minecraft.gui.getChat();
            chat.addMessage(Component.empty());
            chat.addMessage(mutableComponentWithColor.append(mutableComponentWithStyle).append(mutableComponentWithStyle2));
            chat.addMessage(Component.empty());
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) C1312xz.f7989pK.get(), 1.0f));
            String strM4104a = m4104a(component);
            if (strM4104a != null && C0495ie.f3072a.m2245i(strM4104a)) {
                C0498ih.m2238e(c0623l);
            }
        }
    }

    /* JADX INFO: renamed from: l */
    private void m4121l(@NotNull LocalPlayer localPlayer) {
        this.f4692le = this.f4691ld;
        this.f4690oG--;
        if (C0495ie.f3032l.m2230U()) {
            this.f4691ld = 0.0f;
        } else if (this.f4690oG <= 0) {
            this.f4691ld = Math.min(this.f4691ld + 0.3f, 1.0f);
        } else {
            this.f4691ld = Math.max(this.f4691ld - 0.2f, 0.0f);
        }
        Inventory inventory = localPlayer.getInventory();
        if (this.f4689oF != inventory.selected) {
            this.f4689oF = inventory.selected;
            this.f4690oG = 30;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4122a(@NotNull C0623l c0623l, @NotNull Set<UUID> set) {
        int i = this.f4696oI;
        this.f4696oI = i + 1;
        if (i >= 200) {
            this.f4696oI = 0;
            C0551jh c0551jhA = ((C0358g) c0623l.m2852b()).m1722a();
            set.forEach(uuid -> {
                c0551jhA.m2492b(RequestType.PLAYER_DATA, uuid);
                c0551jhA.m2492b(RequestType.INVENTORY_MINIMAL, uuid);
            });
        }
    }

    /* JADX INFO: renamed from: D */
    private void m4123D(@NotNull Minecraft minecraft) {
        UUID profileId = minecraft.getUser().getProfileId();
        G g = this.f4666f;
        if ((g instanceof InterfaceC0979rl) && ((InterfaceC0979rl) g).mo5346bL()) {
            C0872pk c0872pkM4229a = this.f4666f.f4642a.m4229a((UUID) Objects.requireNonNull(profileId));
            boolean z = this.f4666f.m4034a(profileId).m4290a(C1062tN.f5745i.getKey(), -1) != -1;
            if (this.f4688oE > 0) {
                this.f4688oE--;
            }
            if (c0872pkM4229a != null && minecraft.screen == null && !z && this.f4688oE <= 0) {
                minecraft.setScreen(m4130a(c0872pkM4229a));
                this.f4688oE = 5;
            }
        }
    }

    /* JADX INFO: renamed from: E */
    private void m4124E(@NotNull Minecraft minecraft) {
        if (this.f4706a.m5903cq()) {
            this.f4706a.m5902o(minecraft);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m4125d(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        Iterator<AbstractC0188cp<G, P>> it = this.f4676av.iterator();
        while (it.hasNext()) {
            it.next().mo1042a(minecraft, this.f4666f, this.f4666f.f4642a, this, localPlayer);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4126a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, float f) {
        this.f4666f.m4089a().m6089a(minecraft, c0623l, this.f4666f, localPlayer, clientLevel, randomSource, f);
    }

    /* JADX INFO: renamed from: a */
    private void m4127a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull Set<UUID> set) {
        int i = this.f4697oJ;
        this.f4697oJ = i - 1;
        if (i > 0) {
            return;
        }
        this.f4697oJ = 20;
        this.f4683az.clear();
        this.f4683az.addAll(m4165a(minecraft, set, localPlayer, clientLevel));
    }

    /* JADX INFO: renamed from: a */
    private boolean m4128a(@NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull C0623l c0623l, @NotNull C0394gj c0394gj) {
        if (m4176bw() && ((C0994s) c0623l.m2852b()).m5570i()) {
            c0623l.m2882a(minecraft, c0394gj, this.f4705b, clientLevel);
            clientLevel.disconnect();
            minecraft.disconnect(new C0245dt());
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: e */
    private void m4129e(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        Options options = minecraft.options;
        if (!options.getCameraType().isFirstPerson() && !mo4146g(localPlayer) && !localPlayer.isCreative()) {
            options.setCameraType(CameraType.FIRST_PERSON);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected Screen m4130a(@NotNull C0872pk c0872pk) {
        return new C0154cR(null, c0872pk, this.f4666f, this);
    }

    /* JADX INFO: renamed from: m */
    private void m4131m(@NotNull LocalPlayer localPlayer) {
        this.f4703li = this.f4702lh;
        if (C0394gj.m1883b(localPlayer) && this.f4666f.mo4044e(localPlayer)) {
            if (this.f4702lh <= 0.0f) {
                localPlayer.setSprinting(false);
                localPlayer.getFoodData().setFoodLevel(1);
            } else if (this.f4702lh > 5.0f) {
                localPlayer.getFoodData().setFoodLevel(20);
            }
            if (localPlayer.isSprinting()) {
                if (this.f4702lh > 0.0f) {
                    this.f4702lh -= m4132aO();
                    return;
                }
                return;
            } else if (this.f4702lh < 20.0d) {
                this.f4702lh += m4105a(localPlayer);
                return;
            } else {
                if (this.f4702lh > 20.0d) {
                    this.f4702lh = 20.0f;
                    return;
                }
                return;
            }
        }
        this.f4702lh = 20.0f;
        localPlayer.getFoodData().setFoodLevel(20);
    }

    /* JADX INFO: renamed from: aO */
    protected float m4132aO() {
        return 0.1f;
    }

    /* JADX INFO: renamed from: n */
    private void m4133n(@NotNull LocalPlayer localPlayer) {
        Inventory inventory = localPlayer.getInventory();
        int i = inventory.selected;
        if (C0875pn.m4469h(localPlayer) || !mo4157bu()) {
            return;
        }
        boolean zIsEmpty = inventory.getItem(i).isEmpty();
        if (this.f4695oH != i || zIsEmpty) {
            if (zIsEmpty) {
                int iM4470a = C0875pn.m4470a(inventory, i, this.f4695oH > i || (this.f4695oH == 0 && i == 8) ? -1 : 1);
                if (!inventory.getItem(iM4470a).isEmpty()) {
                    inventory.selected = iM4470a;
                }
            }
            if (!localPlayer.getMainHandItem().isEmpty() && !inventory.getItem(this.f4695oH).isEmpty()) {
                C1117uP.f6063il = false;
            }
        }
        this.f4695oH = inventory.selected;
    }

    /* JADX INFO: renamed from: a */
    public void m4134a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull Set<UUID> set, int i, int i2, int i3, int i4, float f, float f2) {
        C0680mD c0680mDM3051b;
        C0681mE c0681mEM2895a = c0623l.m2895a();
        c0681mEM2895a.m3064c(minecraft, poseStack, guiGraphics, font, i, i2, f2);
        if (c0681mEM2895a.m3074aJ() && (c0680mDM3051b = c0681mEM2895a.m3051b()) != null && !c0680mDM3051b.m3032aE()) {
            return;
        }
        Camera mainCamera = minecraft.gameRenderer.getMainCamera();
        Iterator<AbstractC1090tp> it = this.f4675K.values().iterator();
        while (it.hasNext()) {
            it.next().m5975a(this, poseStack, guiGraphics, mainCamera, i, i2, f2);
        }
        mo4140b(minecraft, c0623l, localPlayer, clientLevel, c0394gj, guiGraphics, font, poseStack, multiBufferSource, set, i, i2, i3, i4, f, f2);
        m4136a(guiGraphics, font, poseStack, i, f2);
        m4139b(guiGraphics, font, poseStack, i3, f2);
        m4135b(poseStack, guiGraphics, font);
        m4137a(minecraft, c0623l, localPlayer, clientLevel, guiGraphics, poseStack, font, i3, i4);
    }

    /* JADX INFO: renamed from: b */
    private void m4135b(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font) {
        if (!C0495ie.f3041u.m2230U() || this.f4699iW == null) {
            return;
        }
        int iM465t = C0129bt.m465t();
        int i = this.f4700oL + 6;
        C0129bt.m518b(guiGraphics, 4, 4, i, 15, iM465t);
        C0129bt.m499a(poseStack, font, guiGraphics, this.f4699iW, 4 + (i / 2), 8);
    }

    /* JADX INFO: renamed from: a */
    private void m4136a(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, int i, float f) {
        int height = 0;
        for (C0885px c0885px : this.f4678ax) {
            c0885px.m4626b(poseStack, guiGraphics, font, height, i, f);
            height += c0885px.getHeight() + 2;
        }
        for (C0885px c0885px2 : this.f4677aw) {
            c0885px2.m4626b(poseStack, guiGraphics, font, height, i, f);
            height += c0885px2.getHeight() + 2;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4137a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull GuiGraphics guiGraphics, @NotNull PoseStack poseStack, @NotNull Font font, int i, int i2) {
        if (!localPlayer.isCreative()) {
            return;
        }
        this.f4666f.m4089a().m6092a(minecraft, c0623l, localPlayer, clientLevel, guiGraphics, poseStack, font, i, i2);
    }

    /* JADX INFO: renamed from: a */
    public void m4138a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, C0394gj c0394gj, float f, float f2, int i) {
        ResourceLocation resourceLocationM1872l = c0394gj.m1872l();
        if (resourceLocationM1872l != null) {
            poseStack.pushPose();
            poseStack.translate(f, f2, 0.0f);
            guiGraphics.blit(resourceLocationM1872l, 0, 0, i, i, 8.0f, 8.0f, 8, 8, 64, 64);
            guiGraphics.blit(resourceLocationM1872l, 0, 0, i, i, 40.0f, 8.0f, 8, 8, 64, 64);
            poseStack.popPose();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4139b(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull PoseStack poseStack, int i, float f) {
        int size = this.f4676av.size();
        if (size == 0) {
            return;
        }
        if (this.f4681q.length < size) {
            this.f4681q = new int[size];
        }
        int[] iArr = this.f4681q;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            AbstractC0188cp<G, P> abstractC0188cp = this.f4676av.get(i4);
            if (!abstractC0188cp.mo1059t()) {
                iArr[i4] = -1;
            } else {
                int iMo1045a = abstractC0188cp.mo1045a(font);
                iArr[i4] = iMo1045a;
                i2 += iMo1045a;
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
                this.f4676av.get(i6).mo1044a(guiGraphics, poseStack, font, i5, 4, f);
                i5 += i7 + 3;
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public Component mo4141a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull C0394gj c0394gj) {
        return null;
    }

    /* JADX INFO: renamed from: f */
    public void m4142f(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        DebugScreenOverlay debugOverlay = minecraft.getDebugOverlay();
        if (debugOverlay.showDebugScreen() && !localPlayer.isCreative()) {
            C0485iU.m2172c(minecraft, f4663iT);
            debugOverlay.toggleOverlay();
        }
        if (!minecraft.gameRenderer.effectActive) {
            minecraft.gameRenderer.effectActive = true;
            if (this.f4661gr) {
                this.f4661gr = false;
            } else {
                C0485iU.m2172c(minecraft, f4665iV);
            }
        }
        EntityRenderDispatcher entityRenderDispatcher = minecraft.getEntityRenderDispatcher();
        if (entityRenderDispatcher.shouldRenderHitBoxes() && !localPlayer.isCreative()) {
            C0485iU.m2172c(minecraft, f4662iS);
            entityRenderDispatcher.setRenderHitBoxes(false);
        }
        OptionInstance optionInstanceMainHand = minecraft.options.mainHand();
        if (optionInstanceMainHand.get() != HumanoidArm.RIGHT) {
            optionInstanceMainHand.set(HumanoidArm.RIGHT);
            minecraft.options.broadcastOptions();
            C0485iU.m2172c(minecraft, f4664iU);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: z */
    public List<C0839pD> m4143z() {
        return Collections.unmodifiableList(this.f4685aA);
    }

    /* JADX INFO: renamed from: cB */
    public void m4144cB() {
        this.f4685aA.removeIf(c0839pD -> {
            return c0839pD.m3845a().isWaypoint();
        });
    }

    /* JADX INFO: renamed from: a */
    public void m4145a(@NotNull C0839pD c0839pD) {
        this.f4685aA.add(c0839pD);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    public void m4148a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull C0555jl c0555jl, int i, int i2, float f) {
        UUID uuidR;
        int i3 = i2 / 2;
        if (C0495ie.f3039s.m2230U()) {
            C0129bt.m627l(minecraft);
        }
        P p = this.f4666f.f4642a;
        C0872pk c0872pkM4229a = p.m4229a(localPlayer.getUUID());
        if (c0872pkM4229a != null || c0623l.m2876e()) {
            C0872pk c0872pkM4229a2 = c0872pkM4229a;
            if (c0872pkM4229a2 == null && (uuidR = ((C0396gl) c0623l.m2855a()).m1885a(minecraft).m1116r()) != null) {
                c0872pkM4229a2 = p.m4229a(uuidR);
            }
            int color = c0872pkM4229a2 != null ? c0872pkM4229a2.getColor() : ColorReferences.COLOR_WHITE_SOLID;
            int iM4314bn = c0872pkM4229a2 != null ? c0872pkM4229a2.m4314bn() : ColorReferences.COLOR_WHITE;
            if (C0495ie.f3038r.m2230U()) {
                C0129bt.m523a(guiGraphics, 0, i3, i, i3, ColorReferences.COLOR_BLACK_TRANSPARENT, ColorReferences.COLOR_BLACK_SOLID);
                C0129bt.m517a(guiGraphics, 0, 0, i, i2, ColorReferences.COLOR_BLACK_SOLID, 0.25f);
                C0129bt.m517a(guiGraphics, 0, 0, i, i2, color, 0.15f);
            }
            C0129bt.m547b(poseStack, guiGraphics, f4650dD, (i - 10) - 16, 25, 16, 16, 0.0f, 1.0f, iM4314bn);
            MutableComponent mutableComponentWithColor = Component.literal(this.f4686a.m4330d().getString()).withColor(iM4314bn);
            C0129bt.m487a(poseStack, font, guiGraphics, (Component) mutableComponentWithColor, (((i - 10) - 16) - (font.width(mutableComponentWithColor) * 2)) - 10, 18, 2.0f);
            C0129bt.m515a(guiGraphics, 0, 49, i, 1, 301989887);
            C0129bt.m523a(guiGraphics, 0, 50, i, 8, ColorReferences.COLOR_BLACK_SOLID - (-872415232), ColorReferences.COLOR_BLACK_TRANSPARENT);
            this.f4687a.m5867a(poseStack, font, guiGraphics, this.f4666f, 0, 0, i, 49, color, iM4314bn, f);
            List<C0872pk> listM4244C = p.m4244C();
            int size = listM4244C.size();
            if (size == 0) {
                return;
            }
            Set<UUID> setM4246i = p.m4246i();
            boolean z = !setM4246i.isEmpty();
            int i4 = size + (z ? 1 : 0);
            int i5 = (i - f4657oy) / 2;
            int i6 = ((((i2 - 50) - 13) - 2) - ((i4 + 1) * 5)) / i4;
            int i7 = 68;
            C0129bt.m599a(poseStack, minecraft, c0623l, this.f4705b, c0555jl, guiGraphics, font, this.f4666f, this, null, Style.EMPTY, this.f4684a.m4202g(), i5, 51.0f, 350.0f, 13.0f, 3);
            float fSin = (Mth.sin(C0129bt.m466g() / 120.0f) + 1.0f) / 2.0f;
            int i8 = (i - f4657oy) / 2;
            for (C0872pk c0872pk : listM4244C) {
                SortedSet<UUID> sortedSetM4386a = C0875pn.m4386a((AbstractC0863pb<?, ?, ?>) this.f4666f, c0872pk.m4308h(), this.f4666f.m4080a());
                int size2 = sortedSetM4386a.size() * 11;
                int i9 = 0;
                if (size2 > i6) {
                    i9 = (int) (fSin * (size2 - i6));
                }
                int i10 = i7 + 15;
                int iM4314bn2 = c0872pk.m4314bn();
                C1098tx c1098txM4296a = c0872pk.m4296a((AbstractC0863pb<?, ?, ?>) this.f4666f);
                C0129bt.m539b(poseStack, guiGraphics, c1098txM4296a.m6179a().m6158O(), i8 / 2, i10, 25);
                int i11 = (i10 + 25) - 5;
                ObjectListIterator it = C0544ja.m2458a(font, c1098txM4296a.m6179a().getName(), i8).iterator();
                while (it.hasNext()) {
                    String strTrim = ((String) it.next()).trim();
                    if (!strTrim.isEmpty()) {
                        C0129bt.m483c(font, guiGraphics, (Component) Component.literal(strTrim).withColor(iM4314bn2), i8 / 2, i11);
                        i11 += 10;
                    }
                }
                poseStack.pushPose();
                C0129bt.m618a(guiGraphics, i5, i7, f4657oy, i6);
                m4149a(poseStack, minecraft, c0623l, localPlayer, this.f4705b, c0555jl, guiGraphics, font, c0872pk, i5, i7 - i9, sortedSetM4386a);
                guiGraphics.disableScissor();
                poseStack.popPose();
                i7 += i6 + 5;
            }
            if (z) {
                int size3 = setM4246i.size() * 11;
                int i12 = 0;
                if (size3 > i6) {
                    i12 = (int) (fSin * (size3 - i6));
                }
                int i13 = i7 + 15;
                C0129bt.m539b(poseStack, guiGraphics, f4653dG, i8 / 2, i13, 25);
                int i14 = (i13 + 25) - 5;
                ObjectListIterator it2 = C0544ja.m2458a(font, Component.translatable("bf.scoreboard.spectators.title").getString(), i8).iterator();
                while (it2.hasNext()) {
                    String strTrim2 = ((String) it2.next()).trim();
                    if (!strTrim2.isEmpty()) {
                        C0129bt.m483c(font, guiGraphics, (Component) Component.literal(strTrim2).withStyle(ChatFormatting.GRAY), i8 / 2, i14);
                        i14 += 10;
                    }
                }
                poseStack.pushPose();
                C0129bt.m618a(guiGraphics, i5, i7, f4657oy, i6);
                m4150a(poseStack, minecraft, c0623l, this.f4705b, c0555jl, guiGraphics, font, setM4246i, i5, i7 - i12);
                guiGraphics.disableScissor();
                poseStack.popPose();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4149a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull C0872pk c0872pk, int i, int i2, @NotNull Set<UUID> set) {
        ClientPacketListener clientPacketListener = localPlayer.connection;
        Style styleM4312a = c0872pk.m4312a();
        int i3 = 0;
        for (UUID uuid : set) {
            C0870pi c0870piM4034a = this.f4666f.m4034a(uuid);
            C0394gj c0394gjB = c0396gl.m1152b(uuid);
            PlayerInfo playerInfo = clientPacketListener.getPlayerInfo(uuid);
            ObjectArrayList objectArrayList = new ObjectArrayList();
            Iterator<TriFunction<C0394gj, PlayerInfo, C0870pi, String>> it = this.f4684a.f4709L.values().iterator();
            while (it.hasNext()) {
                objectArrayList.add((String) it.next().apply(c0394gjB, playerInfo, c0870piM4034a));
            }
            C0129bt.m599a(poseStack, minecraft, c0623l, c0396gl, c0555jl, guiGraphics, font, this.f4666f, this, uuid, styleM4312a, objectArrayList, i, i2 + i3, 350.0f, 10.0f, 1);
            i3 += 11;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4150a(@NotNull PoseStack poseStack, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull C0555jl c0555jl, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Set<UUID> set, int i, int i2) {
        int i3 = 0;
        Iterator<UUID> it = set.iterator();
        while (it.hasNext()) {
            C0129bt.m599a(poseStack, minecraft, c0623l, c0396gl, c0555jl, guiGraphics, font, this.f4666f, this, it.next(), Style.EMPTY, List.of(), i, i2 + i3, 350.0f, 10.0f, 1);
            i3 += 11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x00ac  */
    /* JADX WARN: Multi-variable type inference failed */
    @OverridingMethodsMustInvokeSuper
    /* JADX INFO: renamed from: a */
    public void mo4151a(@NotNull AbstractC0866pe<?> abstractC0866pe, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull LocalPlayer localPlayer, @NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull Font font, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, boolean z, float f, float f2) {
        boolean z2;
        this.f4675K.values().forEach(abstractC1090tp -> {
            abstractC1090tp.m5974a(this, camera, guiGraphics, poseStack, f2);
        });
        if (z) {
            m4152a(poseStack, guiGraphics, font, camera);
        }
        boolean zMo4155bs = mo4155bs();
        C0872pk c0872pkM4229a = abstractC0866pe.m4229a(localPlayer.getUUID());
        for (AbstractC0736nG abstractC0736nG : clientLevel.getEntitiesOfClass(AbstractC0736nG.class, localPlayer.getBoundingBox().inflate(96.0d))) {
            if (abstractC0736nG instanceof InterfaceC0738nI) {
                InterfaceC0738nI interfaceC0738nI = (InterfaceC0738nI) abstractC0736nG;
                if (!zMo4155bs || c0872pkM4229a == null) {
                    z2 = false;
                } else {
                    Optional<UUID> optionalM3369d = abstractC0736nG.m3369d();
                    Objects.requireNonNull(abstractC0866pe);
                    if (optionalM3369d.map(abstractC0866pe::m4229a).filter(c0872pk -> {
                        return c0872pk.getName().equals(c0872pkM4229a.getName());
                    }).isPresent()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                if (z2 || localPlayer.hasLineOfSight(abstractC0736nG)) {
                    Vec3 position = abstractC0736nG.getPosition(f2);
                    float fM4164C = m4164C((float) position.distanceTo(localPlayer.position()));
                    if (fM4164C > 0.0f) {
                        C0129bt.m612a(poseStack, camera, guiGraphics, interfaceC0738nI.getWaypointTexture(), position.x, position.y + 0.75d, position.z, 16, 16, 0.5f * fM4164C, ColorReferences.COLOR_WHITE_SOLID, false);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4152a(@NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera) {
        P p = this.f4666f.f4642a;
        if (p.f4736e != null) {
            C0129bt.m619a(poseStack, font, camera, guiGraphics, (Component) Component.literal("LOBBY SPAWN").withStyle(ChatFormatting.YELLOW), p.f4736e.f4827c.x, p.f4736e.f4827c.y + 0.5d, p.f4736e.f4827c.z);
            C0129bt.m603a(poseStack, camera, guiGraphics, f4652dF, p.f4736e.f4827c.x, p.f4736e.f4827c.y + 1.25d, p.f4736e.f4827c.z, 64);
        }
        MutableComponent mutableComponentLiteral = Component.literal("SPAWN POINT");
        for (C0872pk c0872pk : p.m4244C()) {
            MutableComponent mutableComponentAppend = Component.literal("Team: ").append(Component.literal(c0872pk.getName()).withStyle(c0872pk.m4312a()));
            for (C0881pt c0881pt : c0872pk.m4309D()) {
                C0129bt.m619a(poseStack, font, camera, guiGraphics, (Component) mutableComponentLiteral, c0881pt.f4827c.x, c0881pt.f4827c.y + 1.2000000476837158d, c0881pt.f4827c.z);
                C0129bt.m619a(poseStack, font, camera, guiGraphics, (Component) mutableComponentAppend, c0881pt.f4827c.x, c0881pt.f4827c.y + 0.800000011920929d, c0881pt.f4827c.z);
                C0129bt.m603a(poseStack, camera, guiGraphics, f4651dE, c0881pt.f4827c.x, c0881pt.f4827c.y + 1.75d, c0881pt.f4827c.z, 64);
            }
        }
    }

    /* JADX INFO: renamed from: bs */
    public boolean mo4155bs() {
        return true;
    }

    /* JADX INFO: renamed from: bt */
    public boolean mo4156bt() {
        return true;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public G m4158a() {
        return this.f4666f;
    }

    /* JADX INFO: renamed from: bv */
    public boolean m4159bv() {
        return this.f4671gs;
    }

    /* JADX INFO: renamed from: O */
    public void m4160O(boolean z) {
        this.f4671gs = z;
    }

    /* JADX INFO: renamed from: aP */
    public float m4161aP() {
        return this.f4672lc;
    }

    /* JADX INFO: renamed from: l */
    public void m4162l(float f) {
        this.f4672lc = f;
    }

    /* JADX INFO: renamed from: P */
    public void m4163P(boolean z) {
        if (z && !this.f4673gt) {
            this.f4671gs = false;
            this.f4672lc = 0.0f;
        }
        this.f4673gt = z;
    }

    /* JADX INFO: renamed from: C */
    protected static float m4164C(float f) {
        return C1270xJ.m7190j(f, f4659la, f4660lb);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public List<C0134by> m4165a(@NotNull Minecraft minecraft, @NotNull Set<UUID> set, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.addAll(mo4166b(minecraft, set, localPlayer, clientLevel));
        return objectArrayList;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public ResourceLocation mo4168a(@NotNull UUID uuid, @Nullable String str, @NotNull Set<UUID> set) {
        if (!set.contains(uuid)) {
            return null;
        }
        ResourceLocation resourceLocationM2378d = null;
        C0872pk c0872pkM4229a = this.f4666f.f4642a.m4229a(uuid);
        if (c0872pkM4229a != null) {
            C1098tx c1098txM4059a = this.f4666f.m4059a();
            C1098tx c1098txM4060b = this.f4666f.m4060b();
            switch (c0872pkM4229a.getName()) {
                case "Allies":
                    resourceLocationM2378d = C0532jO.m2378d("textures/skins/game/nations/" + c1098txM4059a.m6179a().m6157av() + "/" + c1098txM4059a.getSkin() + "/" + str + ".png");
                    break;
                case "Axis":
                    resourceLocationM2378d = C0532jO.m2378d("textures/skins/game/nations/" + c1098txM4060b.m6179a().m6157av() + "/" + c1098txM4060b.getSkin() + "/" + str + ".png");
                    break;
            }
        }
        return resourceLocationM2378d;
    }

    /* JADX INFO: renamed from: g */
    public void m4169g(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer) {
        UUID uuid = localPlayer.getUUID();
        C0394gj c0394gj = (C0394gj) this.f4705b.m1150a((Player) localPlayer);
        G g = this.f4666f;
        if (g instanceof InterfaceC0984rq) {
            InterfaceC0984rq interfaceC0984rq = (InterfaceC0984rq) g;
            if (C0875pn.m4488a((Player) localPlayer, (AbstractC0183b<?, ?, ?, ?>) c0394gj)) {
                return;
            }
            if (!interfaceC0984rq.mo5554a(uuid).isEmpty()) {
                minecraft.setScreen(new C0234di(interfaceC0984rq));
            }
        }
        if (this.f4666f instanceof InterfaceC0979rl) {
            C0872pk c0872pkM4229a = this.f4666f.f4642a.m4229a(uuid);
            if (!(minecraft.screen instanceof AbstractC0153cQ) && c0872pkM4229a != null) {
                minecraft.setScreen(m4130a(c0872pkM4229a));
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Map<C1093ts, ObjectList<C0837pB>> m4170a(@NotNull C0872pk c0872pk) {
        return c0872pk.m4296a((AbstractC0863pb<?, ?, ?>) this.f4666f).m6180r();
    }

    /* JADX INFO: renamed from: a */
    public void m4171a(@NotNull Minecraft minecraft, @NotNull C0847pL c0847pL) {
        c0847pL.m3920F(minecraft);
        c0847pL.m3916n(minecraft);
        this.f4674au.add(c0847pL);
        if (this.f4674au.size() > 5) {
            this.f4674au.removeFirst();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4172a(@NotNull C1088tn c1088tn) {
        this.f4682ay.add(c1088tn);
        while (this.f4682ay.size() > 8) {
            this.f4682ay.removeFirst();
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C1089to m4173a() {
        return this.f4701a;
    }

    /* JADX INFO: renamed from: a */
    public void m4174a(@NotNull C1089to c1089to) {
        this.f4701a = c1089to;
    }

    /* JADX INFO: renamed from: b */
    public void m4175b(@NotNull ByteBuf byteBuf) throws IOException {
        if (IPacket.readBoolean(byteBuf)) {
            this.f4686a.m4337b(byteBuf);
        }
        this.f4704gu = IPacket.readBoolean(byteBuf);
        m4110cA();
    }

    /* JADX INFO: renamed from: bw */
    public boolean m4176bw() {
        return this.f4704gu;
    }

    @NotNull
    /* JADX INFO: renamed from: A */
    public List<C0847pL> m4177A() {
        return Collections.unmodifiableList(this.f4674au);
    }

    @NotNull
    /* JADX INFO: renamed from: B */
    public List<C1088tn> m4178B() {
        return Collections.unmodifiableList(this.f4682ay);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    protected Collection<? extends AbstractC0229dd> m4180a(G g, boolean z) {
        if (z) {
            return List.of(new C0227db(g));
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b != null && c0623lM2852b.m2875d()) {
            return List.of(new C0232dg(g, m4181b()), new C0227db(g));
        }
        return List.of(new C0230de(g.m4064e(), this), new C0232dg(g, m4181b()), new C0227db(g));
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    protected C1060tL m4181b() {
        return C1062tN.f5748l;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1063tO m4182a() {
        return this.f4706a;
    }

    public void stop() {
    }

    /* JADX INFO: renamed from: a */
    public void m4183a(@NotNull AbstractC1090tp abstractC1090tp) {
        UUID uuidM5969h = abstractC1090tp.m5969h();
        this.f4675K.values().removeIf(abstractC1090tp2 -> {
            return (abstractC1090tp2 instanceof C1091tq) && abstractC1090tp2.m5969h().equals(uuidM5969h);
        });
        if (this.f4675K.containsKey(abstractC1090tp.m5970i())) {
            return;
        }
        this.f4675K.put(abstractC1090tp.m5970i(), abstractC1090tp);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC1090tp m4184a(@NotNull UUID uuid) {
        return this.f4675K.get(uuid);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC1090tp m4185a(@NotNull Vec3 vec3, double d) {
        AbstractC1090tp abstractC1090tp = null;
        double d2 = d * d;
        for (AbstractC1090tp abstractC1090tp2 : this.f4675K.values()) {
            double dDistanceToSqr = abstractC1090tp2.m5972c().distanceToSqr(vec3);
            if (dDistanceToSqr < d2) {
                d2 = dDistanceToSqr;
                abstractC1090tp = abstractC1090tp2;
            }
        }
        return abstractC1090tp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public void m4186a(@NotNull UUID uuid, @NotNull UUID uuid2, @NotNull Vec3 vec3) {
        if (this instanceof InterfaceC0974rg) {
            InterfaceC0974rg interfaceC0974rg = (InterfaceC0974rg) this;
            AbstractC1090tp abstractC1090tp = this.f4675K.get(uuid);
            if (abstractC1090tp != null && !abstractC1090tp.m5981cb() && interfaceC0974rg.mo5544a(abstractC1090tp, uuid2, vec3)) {
                abstractC1090tp.m5971o(vec3);
                abstractC1090tp.m5979df();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4187a(@NotNull Component component, int i) {
        m4190a(List.of(component), i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public void m4188a(@NotNull Component component, int i, @Nullable String str) {
        m4190a(List.of(component), i, str);
    }

    /* JADX INFO: renamed from: a */
    public void m4189a(@NotNull List<Component> list, int i) {
        m4190a(list, i, (String) null);
    }

    /* JADX INFO: renamed from: a */
    public void m4190a(@NotNull List<Component> list, int i, @Nullable String str) {
        m4191a(list, i, str, (Vec3) null, ColorReferences.COLOR_WHITE, ColorReferences.COLOR_WHITE);
    }

    /* JADX INFO: renamed from: a */
    public void m4191a(@NotNull List<Component> list, int i, @Nullable String str, @Nullable Vec3 vec3, int i2, int i3) {
        C0885px c0885pxM4620a = new C0885px(list, i, true, str).m4620a(vec3, i2, i3);
        if (str != null) {
            for (int i4 = 0; i4 < this.f4677aw.size(); i4++) {
                if (str.equals(this.f4677aw.get(i4).getKey())) {
                    this.f4677aw.set(i4, c0885pxM4620a);
                    return;
                }
            }
        }
        this.f4677aw.add(c0885pxM4620a);
        while (this.f4677aw.size() > 3) {
            this.f4677aw.removeFirst();
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.pc$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pc$a.class */
    public static class a {

        /* JADX INFO: renamed from: L */
        @NotNull
        private final Map<String, TriFunction<C0394gj, PlayerInfo, C0870pi, String>> f4709L = new Object2ObjectLinkedOpenHashMap();

        @NotNull
        /* JADX INFO: renamed from: a */
        public a m4201a(@NotNull String str, @NotNull TriFunction<C0394gj, PlayerInfo, C0870pi, String> triFunction) {
            this.f4709L.put(str, triFunction);
            return this;
        }

        @NotNull
        /* JADX INFO: renamed from: g */
        public Set<String> m4202g() {
            return this.f4709L.keySet();
        }
    }
}
