package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.challenge.GunType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0557uq;
import com.boehmod.blockfront.oB;
import com.boehmod.blockfront.uH;
import it.unimi.dsi.fastutil.floats.FloatFloatPair;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent;
import software.bernie.geckolib.animation.keyframe.event.SoundKeyframeEvent;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: com.boehmod.blockfront.ur, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ur.class */
public final class C0558ur extends tO<C0558ur> implements tA, tB, InterfaceC0538ty, InterfaceC0539tz {

    @NotNull
    private static final Component jF;

    @NotNull
    private static final Component jG;

    @NotNull
    public static final String dl = "gun_controller";
    public static final int rT = 5;

    @NotNull
    public static final List<C0558ur> bX;

    @NotNull
    private static final Map<String, DeferredHolder<SoundEvent, SoundEvent>> af;

    @NotNull
    private static final Vec3 aq;
    private static final float mT = 0.001f;
    private static final float mU = 0.0025f;
    private static final float mV = 0.005f;
    private static final float mW = 0.005f;
    private static final float mX = 3.0f;
    public static int rU;
    public static int rV;
    public static int rW;
    public static float mY;
    public static float mZ;
    public static boolean hR;
    public float na;
    public float nb;
    public float nc;
    private float nd;

    @NotNull
    private EnumC0561uu a;
    private int rX;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private DeferredItem<? extends C0560ut> f309a;
    public static int rY;
    public static boolean hS;
    public static boolean hT;
    public static boolean hU;
    public static boolean hV;
    public static boolean hW;

    @NotNull
    private final Map<String, C0559us> ag;

    @NotNull
    private final Map<String, C0554un> ah;

    @NotNull
    private final AnimatableInstanceCache d;

    @NotNull
    private final List<String> bY;

    @NotNull
    private final Map<uH.a, uH> ai;
    private int rZ;

    @NotNull
    private ResourceLocation gj;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private uK f310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private uM f311a;

    @NotNull
    private C0536tw n;
    private int sa;
    private boolean hX;
    private boolean hY;
    private boolean hZ;
    private boolean ia;
    private boolean ib;
    private boolean ic;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private uS[] f312a;
    private int sb;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private uS f313a;
    private boolean id;
    private boolean ie;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private uR f314a;
    private int sc;
    private float ne;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    private boolean f315if;

    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> aW;
    private boolean ig;
    private boolean ih;
    private boolean ii;
    private float nf;

    @NotNull
    private Vector3f m;
    private int sd;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private GunType f316a;

    @NotNull
    private Vec3 ar;

    @NotNull
    private Vec3 as;
    private float ng;
    private int mp;
    private int se;
    private int sf;
    private float nh;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private uO f317a;
    private boolean ij;

    @NotNull
    private hG shakeNodeData;

    @Nullable
    private hG N;

    @NotNull
    private String dm;
    private int sg;
    private boolean ik;
    private boolean fz;
    private boolean fA;
    private boolean il;

    @NotNull
    private String dn;

    @NotNull
    private C0557uq.a c;
    private boolean im;
    static final /* synthetic */ boolean in;

    static {
        in = !C0558ur.class.desiredAssertionStatus();
        jF = Component.translatable("bf.item.gun.scoped");
        jG = Component.translatable("bf.item.gun.reloading");
        bX = new ObjectArrayList();
        af = new Object2ObjectOpenHashMap();
        aq = new Vec3(-15.0d, 20.0d, 10.0d);
        rU = 0;
        rV = 5;
        rW = 0;
        mZ = 0.0f;
        hR = false;
        rY = 0;
        hS = false;
        hT = false;
        hU = false;
        hV = false;
        hW = false;
        af.put("reload_pump", C0624xc.xt);
        af.put("reload_pump_back", C0624xc.xu);
        af.put("reload_pump_forward", C0624xc.xv);
        af.put("reload_bolt_back", C0624xc.xw);
        af.put("reload_bolt_forward", C0624xc.xx);
        af.put("reload_shell", C0624xc.xr);
        af.put("reload_bullet_rifle", C0624xc.xs);
        af.put("reload_winchester_lever", C0624xc.xy);
    }

    public C0558ur(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties.stacksTo(1));
        this.nb = 0.0f;
        this.nc = 0.0f;
        this.nd = 0.0f;
        this.a = EnumC0561uu.ANY;
        this.rX = 8;
        this.ag = new Object2ObjectOpenHashMap();
        this.ah = new Object2ObjectOpenHashMap();
        this.d = GeckoLibUtil.createInstanceCache(this);
        this.bY = new ObjectArrayList();
        this.ai = new Object2ObjectOpenHashMap();
        this.rZ = 0;
        this.gj = uJ.gp;
        this.f310a = uL.b;
        this.f311a = uN.b;
        this.n = new C0536tw(0.2f, 5.0f, 4.0f, 0.05f, 0.1f, 0.15f, 0.25f, 0.05f, 0.3f);
        this.sa = 256;
        this.hX = true;
        this.hY = false;
        this.hZ = true;
        this.ia = false;
        this.ib = true;
        this.ic = true;
        this.sb = 0;
        this.id = true;
        this.ie = false;
        this.f314a = new uR();
        this.sc = ColorReferences.COLOR_BULLET_TRACER;
        this.ne = 1.0f;
        this.f315if = false;
        this.aW = null;
        this.ig = false;
        this.ih = false;
        this.ii = false;
        this.nf = 1.0f;
        this.m = new Vector3f();
        this.sd = 2;
        this.ar = new Vec3(1.0d, -0.10000000149011612d, 0.30000001192092896d);
        this.as = new Vec3(0.0d, -0.25d, 0.0d);
        this.ng = 0.0f;
        this.se = 0;
        this.sf = 0;
        this.nh = 0.0f;
        this.f317a = null;
        this.ij = false;
        this.shakeNodeData = hH.e;
        this.N = null;
        this.dm = "rifle";
        this.sg = 1;
        this.ik = true;
        this.fz = false;
        this.fA = true;
        this.il = false;
        this.dn = "default";
        this.c = C0557uq.b;
        this.im = false;
        bX.add(this);
        this.ah.put("default", C0554un.a);
    }

    @NotNull
    public static String b(@NotNull ItemStack itemStack) {
        return (String) itemStack.getOrDefault(wV.F, "default");
    }

    @NotNull
    public static String c(@NotNull ItemStack itemStack) {
        return (String) itemStack.getOrDefault(wV.G, "default");
    }

    @NotNull
    public static ItemStack a(@NotNull ItemStack itemStack, @NotNull String str) {
        itemStack.set(wV.F, str);
        return itemStack;
    }

    @NotNull
    public static ItemStack b(@NotNull ItemStack itemStack, @NotNull String str) {
        itemStack.set(wV.G, str);
        return itemStack;
    }

    public static boolean d(@NotNull ItemStack itemStack) {
        return ((Boolean) itemStack.getOrDefault(wV.N, false)).booleanValue();
    }

    @NotNull
    public static ItemStack a(@NotNull ItemStack itemStack, boolean z) {
        itemStack.set(wV.N, Boolean.valueOf(z));
        return itemStack;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public static float m1199c(@NotNull ItemStack itemStack) {
        return ((Float) itemStack.getOrDefault(wV.M, Float.valueOf(0.0f))).floatValue();
    }

    public static void b(@NotNull ItemStack itemStack, float f) {
        itemStack.set(wV.M, Float.valueOf(f));
    }

    public static int a(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(wV.I, 0)).intValue();
    }

    public static void b(@NotNull ItemStack itemStack, int i) {
        itemStack.set(wV.I, Integer.valueOf(Math.max(0, i)));
    }

    public static boolean e(@NotNull ItemStack itemStack) {
        return a(itemStack) > 0;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static int m1200b(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(wV.H, 0)).intValue();
    }

    public static void c(@NotNull ItemStack itemStack, int i) {
        itemStack.set(wV.H, Integer.valueOf(i));
    }

    public static void f(@NotNull ItemStack itemStack) {
        c(itemStack, m1201c(itemStack));
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public static int m1201c(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(wV.J, 0)).intValue();
    }

    public static void d(@NotNull ItemStack itemStack, int i) {
        itemStack.set(wV.J, Integer.valueOf(i));
    }

    public static void g(@NotNull ItemStack itemStack) {
        e(itemStack, 0);
    }

    public static void e(@NotNull ItemStack itemStack, int i) {
        itemStack.set(wV.K, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    public static boolean m1202f(@NotNull ItemStack itemStack) {
        return m1203d(itemStack) > 0;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public static int m1203d(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(wV.K, 0)).intValue();
    }

    /* JADX INFO: renamed from: g, reason: collision with other method in class */
    public static boolean m1204g(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(wV.L, 0)).intValue() > 0;
    }

    public static void h(@NotNull ItemStack itemStack) {
        itemStack.set(wV.L, Integer.valueOf(((Integer) itemStack.getOrDefault(wV.L, 0)).intValue() - 1));
    }

    public static void f(@NotNull ItemStack itemStack, int i) {
        itemStack.set(wV.L, Integer.valueOf(i));
    }

    @OnlyIn(Dist.CLIENT)
    private static void a(@NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (Math.random() >= f) {
            return;
        }
        Vec3 vec3Add = localPlayer.getEyePosition(0.0f).add(new Vec3(1.25d, 0.0d, hR ? 0.0f : 0.3f).zRot(((localPlayer.getXRot() + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-localPlayer.getYRot()) * 0.017453292f) - 1.5707964f));
        clientLevel.addParticle(ParticleTypes.SMOKE, true, vec3Add.x, vec3Add.y, vec3Add.z, 0.0d, 0.0d, 0.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0554un m1205a(@NotNull ItemStack itemStack) {
        return this.ah.getOrDefault(c(itemStack), C0554un.a);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0559us m1206a(@NotNull ItemStack itemStack) {
        return this.ag.getOrDefault(b(itemStack), C0559us.a);
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public int m1207e(@NotNull ItemStack itemStack) {
        float fMo1175a = 0.0f;
        if (this.f317a != null) {
            fMo1175a = this.f317a.mo1175a(this, itemStack);
        }
        return (int) fMo1175a;
    }

    public C0558ur a(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        this.ar = vec3;
        this.as = vec32;
        return this;
    }

    public Vec3 A() {
        return this.ar;
    }

    public Vec3 B() {
        return this.as;
    }

    @NotNull
    public C0558ur d(int i) {
        this.rX = i;
        return this;
    }

    @Override // com.boehmod.blockfront.tO
    @NotNull
    public C0558ur a(float f) {
        this.nd = f;
        return this;
    }

    @NotNull
    public C0558ur a(EnumC0561uu enumC0561uu) {
        this.a = enumC0561uu;
        return this;
    }

    @NotNull
    public C0558ur a(@NotNull uO uOVar) {
        this.f317a = uOVar;
        return this;
    }

    public C0558ur a(@NotNull DeferredItem<? extends C0560ut> deferredItem) {
        this.f309a = deferredItem;
        return this;
    }

    @Nullable
    public DeferredItem<? extends C0560ut> a() {
        return this.f309a;
    }

    @NotNull
    public C0558ur a(@NotNull uH.a aVar, @NotNull uH uHVar) {
        this.ai.put(aVar, uHVar);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public uH m1208a(@NotNull ItemStack itemStack) {
        uH.a aVar;
        Map<uH.a, uH> map = this.ai;
        if (d(itemStack)) {
            aVar = uH.a.SCOPE;
        } else {
            aVar = uH.a.DEFAULT;
        }
        return map.getOrDefault(aVar, uH.a);
    }

    @NotNull
    public C0558ur a(@NotNull hG hGVar) {
        this.shakeNodeData = hGVar;
        return this;
    }

    @NotNull
    public C0558ur b(@Nullable hG hGVar) {
        this.N = hGVar;
        return this;
    }

    @NotNull
    public C0558ur a(boolean z) {
        this.ij = z;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0557uq.a m1209a() {
        return this.c;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull C0557uq.a aVar) {
        this.c = aVar;
    }

    @NotNull
    public C0558ur b(boolean z) {
        this.id = z;
        return this;
    }

    @NotNull
    public C0558ur a(String str) {
        this.dn = str;
        return this;
    }

    @NotNull
    public C0558ur c(boolean z) {
        this.ib = z;
        return this;
    }

    @NotNull
    public C0558ur d(boolean z) {
        this.ic = z;
        return this;
    }

    @NotNull
    public C0558ur e(boolean z) {
        this.hX = z;
        return this;
    }

    @NotNull
    public C0558ur b() {
        this.ik = false;
        return this;
    }

    @NotNull
    public C0558ur a(int i, float f) {
        this.sc = i;
        this.ne = f;
        return this;
    }

    @NotNull
    public C0558ur c() {
        this.il = true;
        return this;
    }

    public boolean cs() {
        return this.il;
    }

    @Override // com.boehmod.blockfront.tO
    @NotNull
    public C0558ur a(@NotNull ResourceLocation resourceLocation) {
        this.gj = resourceLocation;
        return this;
    }

    @NotNull
    public C0558ur a(@NotNull uR uRVar) {
        this.f314a = uRVar;
        return this;
    }

    @NotNull
    public C0558ur d() {
        this.hZ = false;
        return this;
    }

    @NotNull
    public C0558ur e() {
        this.ia = true;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public uS m1210a() {
        return this.f313a;
    }

    public int bX() {
        if (this.f312a == null || this.f312a.length == 0) {
            return 1;
        }
        int iMin = Integer.MAX_VALUE;
        for (uS uSVar : this.f312a) {
            iMin = Math.min(iMin, uSVar.cg());
        }
        return Math.max(1, iMin);
    }

    @NotNull
    public C0558ur a(@NotNull uS[] uSVarArr) {
        this.f312a = uSVarArr;
        this.sb = 0;
        this.f313a = uSVarArr[0];
        return this;
    }

    public boolean ct() {
        return this.id;
    }

    public void dq() {
        this.sb = this.sb >= this.f312a.length - 1 ? 0 : this.sb + 1;
        this.f313a = this.f312a[this.sb];
    }

    @NotNull
    public C0558ur a(int i, int i2) {
        return a("default", new C0559us(true, C0559us.jI, i, i2));
    }

    @NotNull
    public C0558ur a(String str, C0559us c0559us) {
        this.ag.put(str, c0559us);
        return this;
    }

    @NotNull
    public C0558ur a(@NotNull String str, @NotNull C0554un c0554un) {
        this.ah.put(str, c0554un);
        return this;
    }

    @NotNull
    public C0558ur f() {
        this.im = true;
        return this;
    }

    @NotNull
    public C0558ur e(int i) {
        this.sa = i;
        return this;
    }

    @NotNull
    public C0558ur f(int i) {
        this.sd = i;
        return this;
    }

    @Override // com.boehmod.blockfront.tO
    @NotNull
    public C0558ur b(float f) {
        this.ng = f > 1.0f ? 1.0f : f < 0.0f ? 0.0f : f;
        return this;
    }

    @NotNull
    public C0558ur g() {
        this.hY = true;
        return this;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull ItemStack itemStack, @NotNull fT fTVar) throws MatchException {
        boolean z;
        boolean z2 = localPlayer.getMainHandItem() == itemStack;
        boolean zM1202f = m1202f(itemStack);
        uH uHVarM1208a = m1208a(itemStack);
        boolean z3 = hU;
        boolean z4 = hV;
        hU = false;
        hV = false;
        float fM1203d = m1203d(itemStack);
        this.se = this.mp;
        this.nh = fM1203d;
        this.nb = this.na;
        int iA = a(itemStack);
        if (iA > this.rZ) {
            this.ig = false;
        }
        this.rZ = iA;
        if (this.mp > 0) {
            this.mp--;
        }
        if (this.sf > 0) {
            this.sf--;
        }
        if (zM1202f) {
            this.mz += 0.01f;
        }
        float fM1199c = m1199c(itemStack);
        if (fM1199c > 0.0f && !zM1202f) {
            a(localPlayer, clientLevel, fM1199c);
        }
        if (fM1203d > 0.0f) {
            hR = false;
            hW = false;
            return;
        }
        Entity vehicle = localPlayer.getVehicle();
        if ((vehicle instanceof AbstractC0376ny) && ((AbstractC0376ny) vehicle).l(localPlayer)) {
            hR = false;
            return;
        }
        boolean z5 = minecraft.screen != null;
        boolean z6 = hS && !z5;
        boolean z7 = hT && !z5;
        boolean z8 = this.f313a.a() == uT.AUTO;
        boolean z9 = this.mp <= 0 && rY <= 0;
        if (z8) {
            z = z6;
        } else if (z3 && !z5) {
            if (z9) {
                z = true;
            } else {
                hW = true;
                z = false;
            }
        } else {
            z = hW && z6;
        }
        uR uRVarM1221a = m1221a(itemStack);
        if (rY <= 0) {
            boolean z10 = (uRVarM1221a.w() == null || this.fA) ? false : true;
            if (!this.ia || aX.bO >= 1.0f || z10) {
                if ((z || (uRVarM1221a.w() != null && !this.fA)) && !fTVar.dm() && !fTVar.dk() && !localPlayer.isEyeInFluidType((FluidType) NeoForgeMod.WATER_TYPE.value())) {
                    if (g(localPlayer)) {
                        a(minecraft, c0297l, fVVar, itemStack, localPlayer, clientLevel);
                    }
                } else {
                    this.fz = false;
                    this.fA = true;
                }
            }
            a(minecraft, localPlayer, clientLevel, uHVarM1208a, itemStack, z7, z4, z2, zM1202f);
            if (z3 && iA <= 0 && this.sf <= 0 && !zM1202f && aU.bp < 0.15f && aU.bx < 0.15f && !fTVar.dm() && !fTVar.dk() && localPlayer.getHealth() > 0.0f && !localPlayer.isSprinting() && !localPlayer.isEyeInFluidType((FluidType) NeoForgeMod.WATER_TYPE.value())) {
                c(minecraft, itemStack);
                this.sf = this.f313a.cg();
            }
        }
        if (!z6 || iA <= 0) {
            e((LivingEntity) localPlayer);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void dr() {
        this.fz = false;
        this.fA = true;
        this.mp = 0;
        this.sf = 0;
        this.ie = false;
        hW = false;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean cu() {
        return this.fz && !this.fA;
    }

    @Override // com.boehmod.blockfront.tB
    @OnlyIn(Dist.CLIENT)
    public boolean a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        hS = true;
        hU = true;
        return false;
    }

    @Override // com.boehmod.blockfront.tB
    @OnlyIn(Dist.CLIENT)
    public boolean b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        hS = false;
        hW = false;
        return false;
    }

    @Override // com.boehmod.blockfront.tB
    @OnlyIn(Dist.CLIENT)
    public boolean c(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        hT = true;
        hV = true;
        return false;
    }

    @Override // com.boehmod.blockfront.tB
    @OnlyIn(Dist.CLIENT)
    public boolean d(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        hT = false;
        return false;
    }

    private void e(@NotNull LivingEntity livingEntity) {
        if (this.ie) {
            if (this.f314a.x() != null) {
                livingEntity.playSound((SoundEvent) this.f314a.x().get(), 1.0f, 1.0f);
            }
            this.ie = false;
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull uH uHVar, @NotNull ItemStack itemStack, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        BlockHitResult blockHitResult = minecraft.hitResult;
        if (blockHitResult instanceof BlockHitResult) {
            Block block = clientLevel.getBlockState(blockHitResult.getBlockPos()).getBlock();
            if ((block instanceof DoorBlock) || (block instanceof LeverBlock) || (block instanceof ButtonBlock) || (block instanceof FenceGateBlock) || (block instanceof C0294kx) || (block instanceof ChestBlock) || (block instanceof kO)) {
                z5 = true;
            }
        }
        if (!hN.I.T()) {
            boolean z6 = hR;
            if (uHVar.iy && z3 && !z4 && !localPlayer.isSprinting()) {
                if (z) {
                    if (!z5) {
                        hR = true;
                    }
                } else {
                    hR = false;
                }
                if (z5) {
                    hR = false;
                }
            }
            if (hR != z6) {
                a(minecraft, itemStack);
                if (this.hX) {
                    hE.a(hH.H);
                    return;
                }
                return;
            }
            return;
        }
        if (z2 && uHVar.iy && z3 && !z5 && !z4 && !localPlayer.isSprinting()) {
            hR = !hR;
            if (this.hX) {
                hE.a(hH.H);
            }
            a(minecraft, itemStack);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void a(@NotNull Minecraft minecraft, @NotNull ItemStack itemStack) {
        uR uRVarM1221a = m1221a(itemStack);
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderS = hR ? uRVarM1221a.S() : uRVarM1221a.T();
        if (deferredHolderS != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderS.get(), 1.0f, 1.0f));
        }
    }

    @OnlyIn(Dist.CLIENT)
    private boolean g(@NotNull LocalPlayer localPlayer) {
        oG<?, ?> oGVarM593a;
        Entity vehicle = localPlayer.getVehicle();
        if (vehicle instanceof AbstractC0376ny) {
            AbstractC0376ny abstractC0376ny = (AbstractC0376ny) vehicle;
            nE<AbstractC0376ny> nEVarM741b = abstractC0376ny.m741b();
            List passengers = abstractC0376ny.getPassengers();
            if (passengers.contains(localPlayer)) {
                return !nEVarM741b.m716a(passengers.indexOf(localPlayer)).fr;
            }
        }
        C0297l c0297lB = C0297l.b();
        return c0297lB == null || (oGVarM593a = c0297lB.m593a()) == null || oGVarM593a.bj();
    }

    @OnlyIn(Dist.CLIENT)
    public void b(@NotNull Minecraft minecraft, @NotNull ItemStack itemStack) {
        SoundEvent soundEventM1213a = m1213a(itemStack);
        if (soundEventM1213a != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(soundEventM1213a, 1.0f, 1.0f));
        }
        if (this.f317a != null) {
            this.f317a.a(this, itemStack, this.bY);
        }
        if (!minecraft.options.getCameraType().isFirstPerson()) {
            this.bY.clear();
        }
    }

    public void q(@NotNull String str) {
        this.bY.add(str);
    }

    public boolean a(@NotNull LivingEntity livingEntity, @NotNull Level level, @NotNull ItemStack itemStack, boolean z) {
        SoundEvent soundEventM1213a;
        int iCb = m1206a(itemStack).cb();
        if (level.isClientSide() || m1200b(itemStack) <= 0 || m1202f(itemStack) || a(itemStack) >= iCb || this.mp > 0) {
            return false;
        }
        int iM1207e = m1207e(itemStack);
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            if (!serverPlayer.isShiftKeyDown() && (soundEventM1213a = m1213a(itemStack)) != null) {
                level.playSound(serverPlayer, livingEntity.blockPosition(), soundEventM1213a, SoundSource.PLAYERS, 0.25f, 1.0f);
            }
            C0582vo.a(new wC(z), serverPlayer);
        }
        e(itemStack, iM1207e);
        return true;
    }

    public void i(@NotNull ItemStack itemStack) {
        int iM1200b = m1200b(itemStack);
        int iCb = m1206a(itemStack).cb();
        if (iM1200b <= 0) {
            return;
        }
        int iA = iM1200b + a(itemStack);
        if (iA <= iCb) {
            b(itemStack, iA);
            c(itemStack, 0);
        } else {
            b(itemStack, iCb);
            c(itemStack, iA - iCb);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull fV fVVar, @NotNull ItemStack itemStack, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (localPlayer.isSpectator() || localPlayer.noPhysics || aU.bp >= 0.15f || aU.bx >= 0.15f) {
            return;
        }
        boolean z = localPlayer.isSprinting() && !(this.fz && !this.fA);
        if (e(itemStack) && localPlayer.getHealth() > 0.0f && this.mp <= 0 && !m1202f(itemStack) && !z) {
            hW = false;
            uR uRVarM1221a = m1221a(itemStack);
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderW = uRVarM1221a.w();
            if (deferredHolderW != null && !this.fz) {
                this.fz = true;
                this.fA = false;
                this.mp = uRVarM1221a.cf();
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderW.get(), 1.0f, 5.0f));
                return;
            }
            aU.bF = 0.0f;
            int iM1199c = (int) (5.0f * m1199c(itemStack));
            this.mp = this.f313a.cg() - ((this.f313a.a() != uT.SEMI || deferredHolderW == null) ? 0 : uRVarM1221a.cf());
            int iAR = ((oB.a) NeoForge.EVENT_BUS.post(new oB.a(this, itemStack, this.mp))).aR() + iM1199c;
            this.se = iAR;
            this.mp = iAR;
            if (minecraft.options.getCameraType().isFirstPerson()) {
                this.bY.add("fire");
            }
            if (this.hX) {
                hE.a(this.shakeNodeData, (hR || aU.bv > 0.0f) ? 0.5f : 1.0f);
            }
            C0554un c0554unM1205a = m1205a(itemStack);
            if (this.ib && c0554unM1205a.cn()) {
                rU = this.sd;
            }
            this.mz += 0.1f;
            this.na += this.nc;
            iD.a(minecraft, ThreadLocalRandom.current(), c0297l, fVVar, this, localPlayer, clientLevel, itemStack);
            this.ie = true;
            C0582vo.c(new wF());
            if (deferredHolderW != null) {
                if (!uRVarM1221a.cM()) {
                    this.fz = false;
                }
                this.fA = true;
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @OnlyIn(Dist.CLIENT)
    private void c(@NotNull Minecraft minecraft, @NotNull ItemStack itemStack) throws MatchException {
        if (this.ij && minecraft.options.getCameraType().isFirstPerson()) {
            this.bY.add("dryfire");
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM1212a = m1212a(itemStack);
        hG hGVarM1211a = this.N;
        if (hGVarM1211a == null) {
            hGVarM1211a = m1211a(this.f316a);
        }
        if (deferredHolderM1212a == null && hGVarM1211a == null) {
            return;
        }
        if (deferredHolderM1212a != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM1212a.get(), 1.0f, 1.0f));
            C0582vo.c(new wA());
        }
        rW = 40;
        if (hGVarM1211a != null && this.hX) {
            hE.a(hGVarM1211a, (hR || aU.bv > 0.0f) ? 0.5f : 1.0f);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ur$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ur$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] w = new int[GunType.values().length];

        static {
            try {
                w[GunType.PISTOL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                w[GunType.SMG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                w[GunType.RIFLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                w[GunType.CARBINE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                w[GunType.SHOTGUN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                w[GunType.MG.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                w[GunType.LMG.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                w[GunType.AT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                w[GunType.ROCKET.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                w[GunType.FLAMETHROWER.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Nullable
    private static DeferredHolder<SoundEvent, SoundEvent> a(@Nullable GunType gunType) throws MatchException {
        if (gunType == null) {
            return null;
        }
        switch (AnonymousClass1.w[gunType.ordinal()]) {
            case 1:
                return C0624xc.vC;
            case 2:
                return C0624xc.vE;
            case 3:
                return C0624xc.vF;
            case 4:
                return C0624xc.vG;
            case 5:
                return C0624xc.vH;
            case 6:
                return C0624xc.vI;
            case 7:
                return C0624xc.vJ;
            case 8:
                return C0624xc.vK;
            case C0407pb.nv /* 9 */:
            case 10:
                return null;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static hG m1211a(@Nullable GunType gunType) throws MatchException {
        if (gunType == null) {
            return null;
        }
        switch (AnonymousClass1.w[gunType.ordinal()]) {
            case 1:
            case 2:
            case 4:
                return hH.j;
            case 3:
            case 5:
                return hH.k;
            case 6:
            case 7:
            case 8:
                return hH.l;
            case C0407pb.nv /* 9 */:
            case 10:
                return null;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public DeferredHolder<SoundEvent, SoundEvent> m1212a(@NotNull ItemStack itemStack) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderV = m1221a(itemStack).v();
        return deferredHolderV != null ? deferredHolderV : a(this.f316a);
    }

    public ItemStack a(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        if (level.isClientSide()) {
            return itemStack;
        }
        b(itemStack, a(itemStack) - bY());
        Vec3 eyePosition = livingEntity.getEyePosition();
        int id = livingEntity.getId();
        wD wDVar = new wD(itemStack, eyePosition, id, a(itemStack) <= 0);
        for (ServerPlayer serverPlayer : level.players()) {
            if (serverPlayer.getId() != id) {
                C0582vo.a(wDVar, serverPlayer);
            }
        }
        NeoForge.EVENT_BUS.post(new oB.b(this, itemStack, livingEntity));
        b(itemStack, m1199c(itemStack) + 0.005f);
        return itemStack;
    }

    public int bY() {
        return this.sg;
    }

    @NotNull
    public C0558ur g(int i) {
        this.sg = i;
        return this;
    }

    @NotNull
    public C0558ur c(float f) {
        this.nc = f;
        return this;
    }

    public float D(float f) {
        return ((C0634xm.e(this.na, this.nb, f) % 360.0f) + 360.0f) % 360.0f;
    }

    public void ds() {
        this.na = 0.0f;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull uR uRVar, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, float f) {
        if (this.ik) {
            Vec3 vec3Add = Vec3.ZERO.add(1.0d, 0.0d, 1.0d).yRot(((-f) * 0.017453292f) - 1.5707964f).add(vec3);
            BlockHitResult blockHitResultClip = clientLevel.clip(new ClipContext(vec3Add, vec3Add.add(0.0d, -16.0d, 0.0d), ClipContext.Block.VISUAL, ClipContext.Fluid.ANY, CollisionContext.empty()));
            Vec3 location = blockHitResultClip.getLocation();
            BlockPos blockPos = blockHitResultClip.getBlockPos();
            BlockState blockState = clientLevel.getBlockState(blockPos);
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderA = uRVar.a(clientLevel, blockPos, blockState, blockState.getSoundType(clientLevel, blockPos, (Entity) null));
            if (deferredHolderA == null) {
                return;
            }
            minecraft.getSoundManager().playDelayed(new SimpleSoundInstance((SoundEvent) deferredHolderA.get(), SoundSource.PLAYERS, 1.0f, 0.9f + (0.1f * ThreadLocalRandom.current().nextInt(2)), RandomSource.create(), location.x, location.y, location.z), (int) (3.0d * location.distanceTo(vec3)));
        }
    }

    @NotNull
    public C0558ur a(@NotNull Vector3f vector3f, boolean z) {
        this.ii = true;
        this.m = vector3f;
        this.ih = z;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public SoundEvent m1213a(@NotNull ItemStack itemStack) {
        uR uRVarM1221a = m1221a(itemStack);
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderT = a(itemStack) <= 0 ? uRVarM1221a.t() : uRVarM1221a.s();
        if (deferredHolderT != null) {
            return (SoundEvent) deferredHolderT.get();
        }
        return null;
    }

    public float bv() {
        return this.nf;
    }

    @NotNull
    public C0558ur d(float f) {
        this.nf = f;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m1214a(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        if (e(itemStack) && livingEntity.isAlive() && livingEntity.getHealth() > 0.0f) {
            ItemStack itemStackA = a(itemStack, level, livingEntity);
            if (livingEntity instanceof Player) {
                Player player = (Player) livingEntity;
                player.getInventory().setItem(player.getInventory().selected, itemStackA);
            } else {
                livingEntity.setItemInHand(InteractionHand.MAIN_HAND, itemStackA);
            }
            C0554un c0554unM1205a = m1205a(itemStack);
            if (this.ib && c0554unM1205a.cn()) {
                f(itemStackA, 1);
                return true;
            }
            return true;
        }
        return false;
    }

    public void a(@NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull Level level, @NotNull Player player, @NotNull ItemStack itemStack) {
        EntityType<? extends InterfaceC0347mw> entityType;
        Supplier<EntityType<? extends InterfaceC0347mw>> supplierB = this.f313a.b();
        if (supplierB == null) {
            return;
        }
        com.boehmod.blockfront.common.player.b bVarM305a = cVar.m305a(player);
        if (bVarM305a.dm() || oR.a(player, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) bVarM305a) || (entityType = supplierB.get()) == null) {
            return;
        }
        int iCh = this.f313a.ch();
        for (int i = 0; i < iCh; i++) {
            InterfaceC0347mw interfaceC0347mwCreate = entityType.create(level);
            if (interfaceC0347mwCreate != null) {
                interfaceC0347mwCreate.a(player, 3.0f, itemStack.copy(), 0.0f, 0.0f);
                level.addFreshEntity(interfaceC0347mwCreate);
            }
        }
    }

    @NotNull
    public C0558ur b(@NotNull String str) {
        this.dm = str;
        return this;
    }

    public boolean cv() {
        return this.hZ;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public uS[] m1215a() {
        return this.f312a;
    }

    public boolean cw() {
        return this.hY;
    }

    public int bZ() {
        return this.sa;
    }

    @NotNull
    public ResourceLocation R() {
        return this.gj;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public uI m1216a() {
        uI uIVarA = uI.a(this.gj);
        return uIVarA != null ? uIVarA : uI.d;
    }

    @NotNull
    public C0558ur a(@NotNull uK uKVar) {
        this.f310a = uKVar;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public uK m1217a() {
        return this.f310a;
    }

    @NotNull
    public C0558ur a(@NotNull uM uMVar) {
        this.f311a = uMVar;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public uM m1218a() {
        return this.f311a;
    }

    public int ca() {
        return this.sc;
    }

    public float bw() {
        return this.ne;
    }

    @NotNull
    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public Vector3f m1219c() {
        return this.m;
    }

    public boolean cx() {
        return this.ii;
    }

    @NotNull
    public C0558ur a(@NotNull Vector3f vector3f) {
        return a(vector3f, false);
    }

    public boolean cy() {
        return this.ih;
    }

    public boolean cz() {
        return this.ig;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        return true;
    }

    @Override // com.boehmod.blockfront.tO
    @OnlyIn(Dist.CLIENT)
    @NotNull
    public Component getName(ItemStack itemStack) {
        Component name = super.getName(itemStack);
        if (d(itemStack)) {
            name = name.copy().append(" ").append(jF);
        }
        C0559us c0559usM1206a = m1206a(itemStack);
        if (c0559usM1206a != C0559us.a && !c0559usM1206a.bF()) {
            name = name.copy().append(Component.translatable("bf.item.gun.mag", new Object[]{c0559usM1206a.m()}));
        }
        C0554un c0554unM1205a = m1205a(itemStack);
        if (c0554unM1205a != C0554un.a) {
            name = name.copy().append(Component.translatable("bf.item.gun.barrel", new Object[]{c0554unM1205a.getDisplayName()}));
        }
        if (m1202f(itemStack)) {
            name = name.copy().append(" ").append(jG);
        }
        return name;
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        if (Minecraft.getInstance().options.advancedItemTooltips) {
            C0554un c0554unM1205a = m1205a(itemStack);
            C0559us c0559usM1206a = m1206a(itemStack);
            int iCb = c0559usM1206a.cb();
            int iCc = c0559usM1206a.cc();
            int iM1200b = m1200b(itemStack);
            int iCg = this.f313a.cg();
            uI uIVarM1216a = m1216a();
            list.add(Component.empty());
            list.add(Component.literal("Damage Config Entries:"));
            list.add(Component.empty());
            for (Map.Entry<Float, FloatFloatPair> entry : uIVarM1216a.s().entrySet()) {
                FloatFloatPair value = entry.getValue();
                list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Distance >= " + String.valueOf(ChatFormatting.DARK_GRAY) + String.valueOf(entry.getKey()) + String.valueOf(ChatFormatting.GRAY) + " Blocks"));
                list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Body: " + String.valueOf(ChatFormatting.DARK_GRAY) + value.leftFloat()));
                list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Headshot: " + String.valueOf(ChatFormatting.DARK_GRAY) + value.rightFloat()));
                list.add(Component.empty());
            }
            list.add(Component.literal("Mag Type"));
            list.add(Component.literal(String.valueOf(a(itemStack)) + String.valueOf(ChatFormatting.GRAY) + " / " + String.valueOf(ChatFormatting.WHITE) + iCb + String.valueOf(ChatFormatting.GRAY) + " - " + String.valueOf(ChatFormatting.WHITE) + iM1200b));
            list.add(c0559usM1206a.m().copy().withStyle(ChatFormatting.GRAY));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Capacity: " + String.valueOf(ChatFormatting.DARK_GRAY) + iCb));
            list.add(Component.empty());
            list.add(Component.literal("Barrel Type"));
            list.add(c0554unM1205a.getDisplayName().copy().withStyle(ChatFormatting.GRAY));
            list.add(Component.empty());
            list.add(Component.literal("Other Info"));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Max Hit Dist: " + String.valueOf(ChatFormatting.DARK_GRAY) + this.sa + " Blocks"));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Fire-rate: " + String.valueOf(ChatFormatting.DARK_GRAY) + iCg + " (" + (iCg / 2) + " ticks)"));
            uR uRVarM1221a = m1221a(itemStack);
            if (uRVarM1221a.w() != null) {
                int iCf = uRVarM1221a.cf();
                boolean zCM = uRVarM1221a.cM();
                int i = zCM ? iCg : (iCf + iCg) - (this.f313a.a() == uT.SEMI ? iCf : 0);
                list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Pre-fire delay: " + String.valueOf(ChatFormatting.DARK_GRAY) + iCf + " (" + (iCf / 2) + " ticks)" + (zCM ? " (once)" : "")));
                if (i != iCg) {
                    list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Effective fire-rate: " + String.valueOf(ChatFormatting.DARK_GRAY) + i + " (" + (i / 2) + " ticks)"));
                }
            }
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Max Ammo Count: " + String.valueOf(ChatFormatting.DARK_GRAY) + iCc));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Clip Capacity: " + String.valueOf(ChatFormatting.DARK_GRAY) + iCb));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Weight: " + String.valueOf(ChatFormatting.DARK_GRAY) + this.ng));
            list.add(Component.empty());
        }
    }

    @Override // com.boehmod.blockfront.tO
    @NotNull
    public Vec3 x() {
        return aq;
    }

    @Override // com.boehmod.blockfront.tO
    protected void a(@NotNull ItemStack itemStack, @NotNull Entity entity) {
        super.a(itemStack, entity);
        C0559us c0559usM1206a = m1206a(itemStack);
        int iCb = c0559usM1206a.cb();
        c(itemStack, c0559usM1206a.cc());
        d(itemStack, c0559usM1206a.cc());
        b(itemStack, iCb);
        ServerLevel serverLevelLevel = entity.level();
        if (serverLevelLevel instanceof ServerLevel) {
            GeoItem.getOrAssignId(itemStack, serverLevelLevel);
        }
        g(itemStack);
    }

    @Override // com.boehmod.blockfront.tO
    public void inventoryTick(ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        int iM1203d;
        super.inventoryTick(itemStack, level, entity, i, z);
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (z) {
                player.swinging = false;
            }
        }
        if (m1204g(itemStack)) {
            h(itemStack);
        }
        if (!level.isClientSide()) {
            float f = 0.001f;
            float fM1199c = m1199c(itemStack);
            if (entity.isInWaterOrRain()) {
                f = 0.0025f;
            }
            if (entity.isInWater()) {
                f = 0.005f;
            }
            if (fM1199c > 0.0f) {
                fM1199c -= f;
                if (fM1199c < 0.0f) {
                    fM1199c = 0.0f;
                }
            }
            b(itemStack, fM1199c);
        }
        if (z && !level.isClientSide() && (iM1203d = m1203d(itemStack)) > 0) {
            e(itemStack, iM1203d - 1);
            if (m1203d(itemStack) <= 0) {
                i(itemStack);
            }
        }
    }

    public float E(float f) {
        return C0634xm.e(this.mp, this.se, f);
    }

    public float a(@NotNull ItemStack itemStack, float f) {
        return C0634xm.e(m1203d(itemStack), this.nh, f);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        return new InteractionResultHolder<>(InteractionResult.FAIL, player.getItemInHand(interactionHand));
    }

    @Override // com.boehmod.blockfront.InterfaceC0539tz
    public boolean b(@NotNull Player player, @NotNull ItemStack itemStack) {
        return !player.isCreative();
    }

    @Override // com.boehmod.blockfront.InterfaceC0539tz
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public float mo1220a(@NotNull ItemStack itemStack) {
        return this.ng;
    }

    public boolean hurtEnemy(@NotNull ItemStack itemStack, @NotNull LivingEntity livingEntity, @NotNull LivingEntity livingEntity2) {
        return false;
    }

    public boolean onLeftClickEntity(@NotNull ItemStack itemStack, @NotNull Player player, @NotNull Entity entity) {
        return false;
    }

    public boolean canAttackBlock(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player) {
        return false;
    }

    @Override // com.boehmod.blockfront.tA
    public void a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull fT fTVar, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
        boolean zAG;
        ItemStack mainHandItem = abstractClientPlayer.getMainHandItem();
        if ((mainHandItem.getItem() instanceof C0558ur) && m1202f(mainHandItem)) {
            float fSin = Mth.sin(f / 30.0f);
            float fSin2 = Mth.sin(f / 25.0f);
            float fSin3 = Mth.sin(f / 5.0f);
            float fSin4 = Mth.sin(f / 15.0f);
            float f3 = fSin * fSin4;
            float f4 = fSin2 * fSin3 * fSin4;
            playerModel.head.xRot = 0.9f;
            playerModel.head.yRot = 0.2f * f3;
            playerModel.rightArm.xRot = (0.2f * f4) - 0.5f;
            playerModel.rightArm.yRot = -0.4f;
            playerModel.rightArm.zRot = 0.0f;
            playerModel.leftArm.xRot = -0.6f;
            playerModel.leftArm.yRot = 0.6f + (0.2f * f4);
            playerModel.leftArm.zRot = 0.6f;
            return;
        }
        if (!z) {
            zAG = fTVar.aG();
            abstractClientPlayer.swinging = false;
            abstractClientPlayer.attackAnim = 0.0f;
        } else {
            zAG = hR || rW > 0;
        }
        playerModel.rightArm.xRot = zAG ? (-1.55f) + playerModel.head.xRot : -0.5f;
        playerModel.rightArm.yRot = zAG ? playerModel.head.yRot : -1.2f;
        playerModel.rightArm.zRot = zAG ? 0.0f : -0.4f;
        float f5 = zAG ? -0.4f : 0.0f;
        if (cv()) {
            playerModel.leftArm.xRot = zAG ? (-1.6f) + playerModel.head.xRot : -0.2f;
            playerModel.leftArm.yRot = zAG ? 0.9f + playerModel.head.yRot : -0.5f;
            playerModel.leftArm.zRot = zAG ? playerModel.head.zRot : -0.4f;
            playerModel.head.zRot = f5;
        } else if (!zAG || !cs()) {
            playerModel.leftArm.xRot = zAG ? (-1.6f) + playerModel.head.xRot : -0.4f;
            playerModel.leftArm.yRot = zAG ? 0.9f + playerModel.head.yRot : -0.5f;
            playerModel.leftArm.zRot = zAG ? playerModel.head.zRot : 0.6f;
            playerModel.head.zRot = f5;
        }
        if (Minecraft.useFancyGraphics() && zAG) {
            float fE = 1.5f * C0634xm.e(fTVar.oi, fTVar.oj, f2);
            playerModel.rightArm.z += fE;
            playerModel.rightSleeve.z += fE;
            if (!cs()) {
                playerModel.leftArm.z += fE;
                playerModel.leftSleeve.z += fE;
            }
            float fSin5 = Mth.sin(f) * fE;
            float fSin6 = Mth.sin(f * 1.2f) * fE;
            float f6 = 0.01f * fSin5;
            float f7 = 0.01f * fSin6;
            playerModel.rightArm.xRot += f6;
            playerModel.rightSleeve.xRot += f6;
            playerModel.rightArm.zRot += f7;
            playerModel.rightSleeve.zRot += f7;
            if (!cs()) {
                playerModel.leftArm.xRot += f6;
                playerModel.leftArm.xRot += f6;
                playerModel.leftArm.zRot += f7;
                playerModel.leftArm.zRot += f7;
            }
        }
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    @OnlyIn(Dist.CLIENT)
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, dl, 0, this::a).setSoundKeyframeHandler(this::a).setCustomInstructionKeyframeHandler(this::b));
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.d;
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public boolean shouldPlayAnimsWhileGamePaused() {
        return true;
    }

    @Override // com.boehmod.blockfront.tO
    @OnlyIn(Dist.CLIENT)
    protected PlayState a(@NotNull AnimationState<C0558ur> animationState) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) {
            return PlayState.STOP;
        }
        ItemDisplayContext itemDisplayContext = (ItemDisplayContext) animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
        if (itemDisplayContext == null || !itemDisplayContext.firstPerson()) {
            return PlayState.STOP;
        }
        String strAt = ((C0558ur) animationState.getAnimatable()).at();
        ItemStack itemStack = (ItemStack) animationState.getData(DataTickets.ITEMSTACK);
        if (itemStack == null) {
            return PlayState.STOP;
        }
        C0297l c0297lB = C0297l.b();
        if (!in && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        fV fVVar = (fV) c0297lB.a();
        boolean z = this.f317a != null && this.f317a.cK() && a(itemStack) <= 0;
        boolean zDk = fVVar.a(minecraft).dk();
        String str = "animation." + strAt + ".";
        AnimationController<T> controller = animationState.getController();
        if (!this.bY.isEmpty()) {
            controller.forceAnimationReset();
            RawAnimation rawAnimationBegin = RawAnimation.begin();
            boolean z2 = false;
            for (String str2 : this.bY) {
                if (!str2.contains("fire") || str2.equals("dryfire") || !z) {
                    rawAnimationBegin.then(str + str2, Animation.LoopType.PLAY_ONCE);
                    if (str2.contains("reload")) {
                        z2 = true;
                    }
                }
            }
            this.bY.clear();
            String str3 = (!z2 && z) ? "idle_empty" : "idle";
            rawAnimationBegin.thenPlayAndHold(str + str3);
            animationState.resetCurrentAnimation();
            animationState.setAnimation(rawAnimationBegin);
        } else if (controller.getAnimationState() == AnimationController.State.STOPPED || zDk) {
            animationState.resetCurrentAnimation();
            animationState.setAnimation(RawAnimation.begin().thenPlayAndHold(str + (z ? "idle_empty" : "idle")));
        }
        return PlayState.CONTINUE;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public uR m1221a(@NotNull ItemStack itemStack) {
        uR uRVarA = m1205a(itemStack).a();
        if (uRVarA != null) {
            return uRVarA;
        }
        return this.f314a;
    }

    public C0558ur a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f315if = true;
        this.aW = deferredHolder;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    public void j(@NotNull ItemStack itemStack) {
        if (this.f315if && !m1202f(itemStack)) {
            q("equip");
        }
        q(this.f317a != null && this.f317a.cK() && a(itemStack) <= 0 ? "idle_empty" : "idle");
        if (this.aW != null) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) this.aW.get(), 0.9f + (0.2f * ThreadLocalRandom.current().nextFloat()), 1.0f));
        }
    }

    @Override // com.boehmod.blockfront.tO
    @OnlyIn(Dist.CLIENT)
    protected void a(@NotNull SoundKeyframeEvent<C0558ur> soundKeyframeEvent) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = af.get(soundKeyframeEvent.getKeyframeData().getSound());
        if (deferredHolder != null) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolder.get(), 0.95f + (0.1f * ThreadLocalRandom.current().nextFloat()), 0.5f));
        }
    }

    @Override // com.boehmod.blockfront.tO
    @OnlyIn(Dist.CLIENT)
    protected void b(@NotNull CustomInstructionKeyframeEvent<C0558ur> customInstructionKeyframeEvent) {
        ThreadLocalRandom threadLocalRandomCurrent;
        String instructions;
        Vec3 eyePosition;
        float yRot;
        uR uRVarM1221a;
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        threadLocalRandomCurrent = ThreadLocalRandom.current();
        instructions = customInstructionKeyframeEvent.getKeyframeData().getInstructions();
        eyePosition = localPlayer.getEyePosition();
        yRot = localPlayer.getYRot();
        uRVarM1221a = m1221a(localPlayer.getMainHandItem());
        switch (instructions) {
            case "eject_bullet;":
                C0193hc.a(threadLocalRandomCurrent, this.dm, false);
                a(uRVarM1221a, minecraft, clientLevel, eyePosition, yRot);
                break;
            case "eject_bullet_flipped;":
                C0193hc.a(threadLocalRandomCurrent, this.dm, true);
                a(uRVarM1221a, minecraft, clientLevel, eyePosition, yRot - 90.0f);
                break;
            case "eject_bullet_audio;":
                a(uRVarM1221a, minecraft, clientLevel, eyePosition, yRot);
                break;
            case "eject_bullet_audio_flipped;":
                a(uRVarM1221a, minecraft, clientLevel, eyePosition, yRot - 90.0f);
                break;
            case "disable_dynamic_bullets;":
                this.ig = true;
                break;
            case "reset_mag_rotation;":
                ds();
                break;
            default:
                if (instructions.startsWith("shake(") && instructions.endsWith(");")) {
                    hE.f(instructions);
                    break;
                }
                break;
        }
    }

    public boolean cA() {
        return this.im;
    }

    public boolean cB() {
        return this.ic;
    }

    @NotNull
    public String au() {
        return this.dn;
    }

    @NotNull
    public hG getShakeNodeData() {
        return this.shakeNodeData;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hG m1222a() {
        return this.N;
    }

    public float bx() {
        return this.nd;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public EnumC0561uu m1223a() {
        return this.a;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0536tw m1224a() {
        return this.n;
    }

    @NotNull
    public C0558ur a(@NotNull C0536tw c0536tw) {
        this.n = c0536tw;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public C0558ur m1225a(@NotNull GunType gunType) {
        this.f316a = gunType;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public GunType m1226a() {
        return this.f316a;
    }

    public int b(@NotNull RandomSource randomSource) {
        int i = this.rX / 2;
        return i + randomSource.nextInt(this.rX - i);
    }
}
