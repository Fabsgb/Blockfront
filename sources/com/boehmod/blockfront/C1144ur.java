package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.challenge.GunType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0783oB;
import com.boehmod.blockfront.C1108uH;
import com.boehmod.blockfront.C1143uq;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.ur */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ur.class */
public final class C1144ur extends AbstractC1062tO<C1144ur> implements InterfaceC1048tA, InterfaceC1049tB, InterfaceC1098ty, InterfaceC1099tz {

    /* JADX INFO: renamed from: jF */
    @NotNull
    private static final Component f5977jF;

    /* JADX INFO: renamed from: jG */
    @NotNull
    private static final Component f5978jG;

    /* JADX INFO: renamed from: dl */
    @NotNull
    public static final String f5979dl = "gun_controller";

    /* JADX INFO: renamed from: rT */
    public static final int f5980rT = 5;

    /* JADX INFO: renamed from: bX */
    @NotNull
    public static final List<C1144ur> f5981bX;

    /* JADX INFO: renamed from: af */
    @NotNull
    private static final Map<String, DeferredHolder<SoundEvent, SoundEvent>> f5982af;

    /* JADX INFO: renamed from: aq */
    @NotNull
    private static final Vec3 f5983aq;

    /* JADX INFO: renamed from: mT */
    private static final float f5984mT = 0.001f;

    /* JADX INFO: renamed from: mU */
    private static final float f5985mU = 0.0025f;

    /* JADX INFO: renamed from: mV */
    private static final float f5986mV = 0.005f;

    /* JADX INFO: renamed from: mW */
    private static final float f5987mW = 0.005f;

    /* JADX INFO: renamed from: mX */
    private static final float f5988mX = 3.0f;

    /* JADX INFO: renamed from: rU */
    public static int f5989rU;

    /* JADX INFO: renamed from: rV */
    public static int f5990rV;

    /* JADX INFO: renamed from: rW */
    public static int f5991rW;

    /* JADX INFO: renamed from: mY */
    public static float f5992mY;

    /* JADX INFO: renamed from: mZ */
    public static float f5993mZ;

    /* JADX INFO: renamed from: hR */
    public static boolean f5994hR;

    /* JADX INFO: renamed from: na */
    public float f5995na;

    /* JADX INFO: renamed from: nb */
    public float f5996nb;

    /* JADX INFO: renamed from: nc */
    public float f5997nc;

    /* JADX INFO: renamed from: nd */
    private float f5998nd;

    /* JADX INFO: renamed from: a */
    @NotNull
    private EnumC1147uu f5999a;

    /* JADX INFO: renamed from: rX */
    private int f6000rX;

    /* JADX INFO: renamed from: a */
    @Nullable
    private DeferredItem<? extends C1146ut> f6001a;

    /* JADX INFO: renamed from: rY */
    public static int f6002rY;

    /* JADX INFO: renamed from: hS */
    public static boolean f6003hS;

    /* JADX INFO: renamed from: hT */
    public static boolean f6004hT;

    /* JADX INFO: renamed from: hU */
    public static boolean f6005hU;

    /* JADX INFO: renamed from: hV */
    public static boolean f6006hV;

    /* JADX INFO: renamed from: hW */
    public static boolean f6007hW;

    /* JADX INFO: renamed from: ag */
    @NotNull
    private final Map<String, C1145us> f6008ag;

    /* JADX INFO: renamed from: ah */
    @NotNull
    private final Map<String, C1140un> f6009ah;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final AnimatableInstanceCache f6010d;

    /* JADX INFO: renamed from: bY */
    @NotNull
    private final List<String> f6011bY;

    /* JADX INFO: renamed from: ai */
    @NotNull
    private final Map<C1108uH.a, C1108uH> f6012ai;

    /* JADX INFO: renamed from: rZ */
    private int f6013rZ;

    /* JADX INFO: renamed from: gj */
    @NotNull
    private ResourceLocation f6014gj;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1111uK f6015a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1113uM f6016a;

    /* JADX INFO: renamed from: n */
    @NotNull
    private C1096tw f6017n;

    /* JADX INFO: renamed from: sa */
    private int f6018sa;

    /* JADX INFO: renamed from: hX */
    private boolean f6019hX;

    /* JADX INFO: renamed from: hY */
    private boolean f6020hY;

    /* JADX INFO: renamed from: hZ */
    private boolean f6021hZ;

    /* JADX INFO: renamed from: ia */
    private boolean f6022ia;

    /* JADX INFO: renamed from: ib */
    private boolean f6023ib;

    /* JADX INFO: renamed from: ic */
    private boolean f6024ic;

    /* JADX INFO: renamed from: a */
    private C1119uS[] f6025a;

    /* JADX INFO: renamed from: sb */
    private int f6026sb;

    /* JADX INFO: renamed from: a */
    private C1119uS f6027a;

    /* JADX INFO: renamed from: id */
    private boolean f6028id;

    /* JADX INFO: renamed from: ie */
    private boolean f6029ie;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1118uR f6030a;

    /* JADX INFO: renamed from: sc */
    private int f6031sc;

    /* JADX INFO: renamed from: ne */
    private float f6032ne;

    /* JADX INFO: renamed from: if */
    private boolean f6033if;

    /* JADX INFO: renamed from: aW */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6034aW;

    /* JADX INFO: renamed from: ig */
    private boolean f6035ig;

    /* JADX INFO: renamed from: ih */
    private boolean f6036ih;

    /* JADX INFO: renamed from: ii */
    private boolean f6037ii;

    /* JADX INFO: renamed from: nf */
    private float f6038nf;

    /* JADX INFO: renamed from: m */
    @NotNull
    private Vector3f f6039m;

    /* JADX INFO: renamed from: sd */
    private int f6040sd;

    /* JADX INFO: renamed from: a */
    @Nullable
    private GunType f6041a;

    /* JADX INFO: renamed from: ar */
    @NotNull
    private Vec3 f6042ar;

    /* JADX INFO: renamed from: as */
    @NotNull
    private Vec3 f6043as;

    /* JADX INFO: renamed from: ng */
    private float f6044ng;

    /* JADX INFO: renamed from: mp */
    private int f6045mp;

    /* JADX INFO: renamed from: se */
    private int f6046se;

    /* JADX INFO: renamed from: sf */
    private int f6047sf;

    /* JADX INFO: renamed from: nh */
    private float f6048nh;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC1115uO f6049a;

    /* JADX INFO: renamed from: ij */
    private boolean f6050ij;

    @NotNull
    private C0417hG shakeNodeData;

    /* JADX INFO: renamed from: N */
    @Nullable
    private C0417hG f6051N;

    /* JADX INFO: renamed from: dm */
    @NotNull
    private String f6052dm;

    /* JADX INFO: renamed from: sg */
    private int f6053sg;

    /* JADX INFO: renamed from: ik */
    private boolean f6054ik;

    /* JADX INFO: renamed from: fz */
    private boolean f6055fz;

    /* JADX INFO: renamed from: fA */
    private boolean f6056fA;

    /* JADX INFO: renamed from: il */
    private boolean f6057il;

    /* JADX INFO: renamed from: dn */
    @NotNull
    private String f6058dn;

    /* JADX INFO: renamed from: c */
    @NotNull
    private C1143uq.a f6059c;

    /* JADX INFO: renamed from: im */
    private boolean f6060im;

    /* JADX INFO: renamed from: in */
    static final /* synthetic */ boolean f6061in;

    static {
        f6061in = !C1144ur.class.desiredAssertionStatus();
        f5977jF = Component.translatable("bf.item.gun.scoped");
        f5978jG = Component.translatable("bf.item.gun.reloading");
        f5981bX = new ObjectArrayList();
        f5982af = new Object2ObjectOpenHashMap();
        f5983aq = new Vec3(-15.0d, 20.0d, 10.0d);
        f5989rU = 0;
        f5990rV = 5;
        f5991rW = 0;
        f5993mZ = 0.0f;
        f5994hR = false;
        f6002rY = 0;
        f6003hS = false;
        f6004hT = false;
        f6005hU = false;
        f6006hV = false;
        f6007hW = false;
        f5982af.put("reload_pump", C1280xc.f7978xt);
        f5982af.put("reload_pump_back", C1280xc.f7979xu);
        f5982af.put("reload_pump_forward", C1280xc.f7980xv);
        f5982af.put("reload_bolt_back", C1280xc.f7981xw);
        f5982af.put("reload_bolt_forward", C1280xc.f7982xx);
        f5982af.put("reload_shell", C1280xc.f7976xr);
        f5982af.put("reload_bullet_rifle", C1280xc.f7977xs);
        f5982af.put("reload_winchester_lever", C1280xc.f7983xy);
    }

    public C1144ur(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties.stacksTo(1));
        this.f5996nb = 0.0f;
        this.f5997nc = 0.0f;
        this.f5998nd = 0.0f;
        this.f5999a = EnumC1147uu.ANY;
        this.f6000rX = 8;
        this.f6008ag = new Object2ObjectOpenHashMap();
        this.f6009ah = new Object2ObjectOpenHashMap();
        this.f6010d = GeckoLibUtil.createInstanceCache(this);
        this.f6011bY = new ObjectArrayList();
        this.f6012ai = new Object2ObjectOpenHashMap();
        this.f6013rZ = 0;
        this.f6014gj = C1110uJ.f5833gp;
        this.f6015a = C1112uL.f5851b;
        this.f6016a = C1114uN.f5860b;
        this.f6017n = new C1096tw(0.2f, 5.0f, 4.0f, 0.05f, 0.1f, 0.15f, 0.25f, 0.05f, 0.3f);
        this.f6018sa = 256;
        this.f6019hX = true;
        this.f6020hY = false;
        this.f6021hZ = true;
        this.f6022ia = false;
        this.f6023ib = true;
        this.f6024ic = true;
        this.f6026sb = 0;
        this.f6028id = true;
        this.f6029ie = false;
        this.f6030a = new C1118uR();
        this.f6031sc = ColorReferences.COLOR_BULLET_TRACER;
        this.f6032ne = 1.0f;
        this.f6033if = false;
        this.f6034aW = null;
        this.f6035ig = false;
        this.f6036ih = false;
        this.f6037ii = false;
        this.f6038nf = 1.0f;
        this.f6039m = new Vector3f();
        this.f6040sd = 2;
        this.f6042ar = new Vec3(1.0d, -0.10000000149011612d, 0.30000001192092896d);
        this.f6043as = new Vec3(0.0d, -0.25d, 0.0d);
        this.f6044ng = 0.0f;
        this.f6046se = 0;
        this.f6047sf = 0;
        this.f6048nh = 0.0f;
        this.f6049a = null;
        this.f6050ij = false;
        this.shakeNodeData = C0418hH.f2662e;
        this.f6051N = null;
        this.f6052dm = "rifle";
        this.f6053sg = 1;
        this.f6054ik = true;
        this.f6055fz = false;
        this.f6056fA = true;
        this.f6057il = false;
        this.f6058dn = "default";
        this.f6059c = C1143uq.f5975b;
        this.f6060im = false;
        f5981bX.add(this);
        this.f6009ah.put("default", C1140un.f5958a);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static String m6293b(@NotNull ItemStack itemStack) {
        return (String) itemStack.getOrDefault(C1228wV.f6962F, "default");
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public static String m6294c(@NotNull ItemStack itemStack) {
        return (String) itemStack.getOrDefault(C1228wV.f6963G, "default");
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ItemStack m6295a(@NotNull ItemStack itemStack, @NotNull String str) {
        itemStack.set(C1228wV.f6962F, str);
        return itemStack;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static ItemStack m6296b(@NotNull ItemStack itemStack, @NotNull String str) {
        itemStack.set(C1228wV.f6963G, str);
        return itemStack;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m6297d(@NotNull ItemStack itemStack) {
        return ((Boolean) itemStack.getOrDefault(C1228wV.f6970N, false)).booleanValue();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ItemStack m6298a(@NotNull ItemStack itemStack, boolean z) {
        itemStack.set(C1228wV.f6970N, Boolean.valueOf(z));
        return itemStack;
    }

    /* JADX INFO: renamed from: c */
    public static float m6299c(@NotNull ItemStack itemStack) {
        return ((Float) itemStack.getOrDefault(C1228wV.f6969M, Float.valueOf(0.0f))).floatValue();
    }

    /* JADX INFO: renamed from: b */
    public static void m6300b(@NotNull ItemStack itemStack, float f) {
        itemStack.set(C1228wV.f6969M, Float.valueOf(f));
    }

    /* JADX INFO: renamed from: a */
    public static int m6301a(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(C1228wV.f6965I, 0)).intValue();
    }

    /* JADX INFO: renamed from: b */
    public static void m6302b(@NotNull ItemStack itemStack, int i) {
        itemStack.set(C1228wV.f6965I, Integer.valueOf(Math.max(0, i)));
    }

    /* JADX INFO: renamed from: e */
    public static boolean m6303e(@NotNull ItemStack itemStack) {
        return m6301a(itemStack) > 0;
    }

    /* JADX INFO: renamed from: b */
    public static int m6304b(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(C1228wV.f6964H, 0)).intValue();
    }

    /* JADX INFO: renamed from: c */
    public static void m6305c(@NotNull ItemStack itemStack, int i) {
        itemStack.set(C1228wV.f6964H, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: f */
    public static void m6306f(@NotNull ItemStack itemStack) {
        m6305c(itemStack, m6307c(itemStack));
    }

    /* JADX INFO: renamed from: c */
    public static int m6307c(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(C1228wV.f6966J, 0)).intValue();
    }

    /* JADX INFO: renamed from: d */
    public static void m6308d(@NotNull ItemStack itemStack, int i) {
        itemStack.set(C1228wV.f6966J, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: g */
    public static void m6309g(@NotNull ItemStack itemStack) {
        m6310e(itemStack, 0);
    }

    /* JADX INFO: renamed from: e */
    public static void m6310e(@NotNull ItemStack itemStack, int i) {
        itemStack.set(C1228wV.f6967K, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: f */
    public static boolean m6311f(@NotNull ItemStack itemStack) {
        return m6312d(itemStack) > 0;
    }

    /* JADX INFO: renamed from: d */
    public static int m6312d(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(C1228wV.f6967K, 0)).intValue();
    }

    /* JADX INFO: renamed from: g */
    public static boolean m6313g(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(C1228wV.f6968L, 0)).intValue() > 0;
    }

    /* JADX INFO: renamed from: h */
    public static void m6314h(@NotNull ItemStack itemStack) {
        itemStack.set(C1228wV.f6968L, Integer.valueOf(((Integer) itemStack.getOrDefault(C1228wV.f6968L, 0)).intValue() - 1));
    }

    /* JADX INFO: renamed from: f */
    public static void m6315f(@NotNull ItemStack itemStack, int i) {
        itemStack.set(C1228wV.f6968L, Integer.valueOf(i));
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m6316a(@NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (Math.random() >= f) {
            return;
        }
        Vec3 vec3Add = localPlayer.getEyePosition(0.0f).add(new Vec3(1.25d, 0.0d, f5994hR ? 0.0f : 0.3f).zRot(((localPlayer.getXRot() + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-localPlayer.getYRot()) * 0.017453292f) - 1.5707964f));
        clientLevel.addParticle(ParticleTypes.SMOKE, true, vec3Add.x, vec3Add.y, vec3Add.z, 0.0d, 0.0d, 0.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1140un m6317a(@NotNull ItemStack itemStack) {
        return this.f6009ah.getOrDefault(m6294c(itemStack), C1140un.f5958a);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1145us m6318a(@NotNull ItemStack itemStack) {
        return this.f6008ag.getOrDefault(m6293b(itemStack), C1145us.f6069a);
    }

    /* JADX INFO: renamed from: e */
    public int m6319e(@NotNull ItemStack itemStack) {
        float fMo6144a = 0.0f;
        if (this.f6049a != null) {
            fMo6144a = this.f6049a.mo6144a(this, itemStack);
        }
        return (int) fMo6144a;
    }

    /* JADX INFO: renamed from: a */
    public C1144ur m6320a(@NotNull Vec3 vec3, @NotNull Vec3 vec32) {
        this.f6042ar = vec3;
        this.f6043as = vec32;
        return this;
    }

    /* JADX INFO: renamed from: A */
    public Vec3 m6321A() {
        return this.f6042ar;
    }

    /* JADX INFO: renamed from: B */
    public Vec3 m6322B() {
        return this.f6043as;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1144ur m6323d(int i) {
        this.f6000rX = i;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur mo5947a(float f) {
        this.f5998nd = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6324a(EnumC1147uu enumC1147uu) {
        this.f5999a = enumC1147uu;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6325a(@NotNull AbstractC1115uO abstractC1115uO) {
        this.f6049a = abstractC1115uO;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C1144ur m6326a(@NotNull DeferredItem<? extends C1146ut> deferredItem) {
        this.f6001a = deferredItem;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public DeferredItem<? extends C1146ut> m6327a() {
        return this.f6001a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6328a(@NotNull C1108uH.a aVar, @NotNull C1108uH c1108uH) {
        this.f6012ai.put(aVar, c1108uH);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1108uH m6329a(@NotNull ItemStack itemStack) {
        C1108uH.a aVar;
        Map<C1108uH.a, C1108uH> map = this.f6012ai;
        if (m6297d(itemStack)) {
            aVar = C1108uH.a.SCOPE;
        } else {
            aVar = C1108uH.a.DEFAULT;
        }
        return map.getOrDefault(aVar, C1108uH.f5814a);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6330a(@NotNull C0417hG c0417hG) {
        this.shakeNodeData = c0417hG;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1144ur m6331b(@Nullable C0417hG c0417hG) {
        this.f6051N = c0417hG;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6332a(boolean z) {
        this.f6050ij = z;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1143uq.a m6333a() {
        return this.f6059c;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6334a(@NotNull C1143uq.a aVar) {
        this.f6059c = aVar;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1144ur m6335b(boolean z) {
        this.f6028id = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6336a(String str) {
        this.f6058dn = str;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C1144ur m6337c(boolean z) {
        this.f6023ib = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1144ur m6338d(boolean z) {
        this.f6024ic = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C1144ur m6339e(boolean z) {
        this.f6019hX = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1144ur m6340b() {
        this.f6054ik = false;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6341a(int i, float f) {
        this.f6031sc = i;
        this.f6032ne = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C1144ur m6342c() {
        this.f6057il = true;
        return this;
    }

    /* JADX INFO: renamed from: cs */
    public boolean m6343cs() {
        return this.f6057il;
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur mo5934a(@NotNull ResourceLocation resourceLocation) {
        this.f6014gj = resourceLocation;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6344a(@NotNull C1118uR c1118uR) {
        this.f6030a = c1118uR;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1144ur m6345d() {
        this.f6021hZ = false;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C1144ur m6346e() {
        this.f6022ia = true;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1119uS m6347a() {
        return this.f6027a;
    }

    /* JADX INFO: renamed from: bX */
    public int m6348bX() {
        if (this.f6025a == null || this.f6025a.length == 0) {
            return 1;
        }
        int iMin = Integer.MAX_VALUE;
        for (C1119uS c1119uS : this.f6025a) {
            iMin = Math.min(iMin, c1119uS.m6222cg());
        }
        return Math.max(1, iMin);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6349a(@NotNull C1119uS[] c1119uSArr) {
        this.f6025a = c1119uSArr;
        this.f6026sb = 0;
        this.f6027a = c1119uSArr[0];
        return this;
    }

    /* JADX INFO: renamed from: ct */
    public boolean m6350ct() {
        return this.f6028id;
    }

    /* JADX INFO: renamed from: dq */
    public void m6351dq() {
        this.f6026sb = this.f6026sb >= this.f6025a.length - 1 ? 0 : this.f6026sb + 1;
        this.f6027a = this.f6025a[this.f6026sb];
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6352a(int i, int i2) {
        return m6353a("default", new C1145us(true, C1145us.f6068jI, i, i2));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6353a(String str, C1145us c1145us) {
        this.f6008ag.put(str, c1145us);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6354a(@NotNull String str, @NotNull C1140un c1140un) {
        this.f6009ah.put(str, c1140un);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public C1144ur m6355f() {
        this.f6060im = true;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C1144ur m6356e(int i) {
        this.f6018sa = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public C1144ur m6357f(int i) {
        this.f6040sd = i;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @NotNull
    /* JADX INFO: renamed from: b */
    public C1144ur mo5948b(float f) {
        this.f6044ng = f > 1.0f ? 1.0f : f < 0.0f ? 0.0f : f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public C1144ur m6358g() {
        this.f6020hY = true;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6359a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull ItemStack itemStack, @NotNull C0324fT c0324fT) throws MatchException {
        boolean z;
        boolean z2 = localPlayer.getMainHandItem() == itemStack;
        boolean zM6311f = m6311f(itemStack);
        C1108uH c1108uHM6329a = m6329a(itemStack);
        boolean z3 = f6005hU;
        boolean z4 = f6006hV;
        f6005hU = false;
        f6006hV = false;
        float fM6312d = m6312d(itemStack);
        this.f6046se = this.f6045mp;
        this.f6048nh = fM6312d;
        this.f5996nb = this.f5995na;
        int iM6301a = m6301a(itemStack);
        if (iM6301a > this.f6013rZ) {
            this.f6035ig = false;
        }
        this.f6013rZ = iM6301a;
        if (this.f6045mp > 0) {
            this.f6045mp--;
        }
        if (this.f6047sf > 0) {
            this.f6047sf--;
        }
        if (zM6311f) {
            this.f5613mz += 0.01f;
        }
        float fM6299c = m6299c(itemStack);
        if (fM6299c > 0.0f && !zM6311f) {
            m6316a(localPlayer, clientLevel, fM6299c);
        }
        if (fM6312d > 0.0f) {
            f5994hR = false;
            f6007hW = false;
            return;
        }
        Entity vehicle = localPlayer.getVehicle();
        if ((vehicle instanceof AbstractC0779ny) && ((AbstractC0779ny) vehicle).m3514l(localPlayer)) {
            f5994hR = false;
            return;
        }
        boolean z5 = minecraft.screen != null;
        boolean z6 = f6003hS && !z5;
        boolean z7 = f6004hT && !z5;
        boolean z8 = this.f6027a.m6221a() == EnumC1120uT.AUTO;
        boolean z9 = this.f6045mp <= 0 && f6002rY <= 0;
        if (z8) {
            z = z6;
        } else if (z3 && !z5) {
            if (z9) {
                z = true;
            } else {
                f6007hW = true;
                z = false;
            }
        } else {
            z = f6007hW && z6;
        }
        C1118uR c1118uRM6408a = m6408a(itemStack);
        if (f6002rY <= 0) {
            boolean z10 = (c1118uRM6408a.m6163w() == null || this.f6056fA) ? false : true;
            if (!this.f6022ia || C0053aX.f366bO >= 1.0f || z10) {
                if ((z || (c1118uRM6408a.m6163w() != null && !this.f6056fA)) && !c0324fT.m1093dm() && !c0324fT.m1087dk() && !localPlayer.isEyeInFluidType((FluidType) NeoForgeMod.WATER_TYPE.value())) {
                    if (m6365g(localPlayer)) {
                        m6370a(minecraft, c0622l, c0326fV, itemStack, localPlayer, clientLevel);
                    }
                } else {
                    this.f6055fz = false;
                    this.f6056fA = true;
                }
            }
            m6363a(minecraft, localPlayer, clientLevel, c1108uHM6329a, itemStack, z7, z4, z2, zM6311f);
            if (z3 && iM6301a <= 0 && this.f6047sf <= 0 && !zM6311f && C0050aU.f323bp < 0.15f && C0050aU.f332bx < 0.15f && !c0324fT.m1093dm() && !c0324fT.m1087dk() && localPlayer.getHealth() > 0.0f && !localPlayer.isSprinting() && !localPlayer.isEyeInFluidType((FluidType) NeoForgeMod.WATER_TYPE.value())) {
                m6371c(minecraft, itemStack);
                this.f6047sf = this.f6027a.m6222cg();
            }
        }
        if (!z6 || iM6301a <= 0) {
            m6362e((LivingEntity) localPlayer);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: dr */
    public void m6360dr() {
        this.f6055fz = false;
        this.f6056fA = true;
        this.f6045mp = 0;
        this.f6047sf = 0;
        this.f6029ie = false;
        f6007hW = false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: cu */
    public boolean m6361cu() {
        return this.f6055fz && !this.f6056fA;
    }

    @Override // com.boehmod.blockfront.InterfaceC1049tB
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public boolean mo5829a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        f6003hS = true;
        f6005hU = true;
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC1049tB
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    public boolean mo5830b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        f6003hS = false;
        f6007hW = false;
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC1049tB
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: c */
    public boolean mo5831c(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        f6004hT = true;
        f6006hV = true;
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC1049tB
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: d */
    public boolean mo5832d(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        f6004hT = false;
        return false;
    }

    /* JADX INFO: renamed from: e */
    private void m6362e(@NotNull LivingEntity livingEntity) {
        if (this.f6029ie) {
            if (this.f6030a.m6164x() != null) {
                livingEntity.playSound((SoundEvent) this.f6030a.m6164x().get(), 1.0f, 1.0f);
            }
            this.f6029ie = false;
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m6363a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C1108uH c1108uH, @NotNull ItemStack itemStack, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        BlockHitResult blockHitResult = minecraft.hitResult;
        if (blockHitResult instanceof BlockHitResult) {
            Block block = clientLevel.getBlockState(blockHitResult.getBlockPos()).getBlock();
            if ((block instanceof DoorBlock) || (block instanceof LeverBlock) || (block instanceof ButtonBlock) || (block instanceof FenceGateBlock) || (block instanceof C0619kx) || (block instanceof ChestBlock) || (block instanceof C0584kO)) {
                z5 = true;
            }
        }
        if (!C0424hN.f2754I.m1996T()) {
            boolean z6 = f5994hR;
            if (c1108uH.f5819iy && z3 && !z4 && !localPlayer.isSprinting()) {
                if (z) {
                    if (!z5) {
                        f5994hR = true;
                    }
                } else {
                    f5994hR = false;
                }
                if (z5) {
                    f5994hR = false;
                }
            }
            if (f5994hR != z6) {
                m6364a(minecraft, itemStack);
                if (this.f6019hX) {
                    C0415hE.m1960a(C0418hH.f2691H);
                    return;
                }
                return;
            }
            return;
        }
        if (z2 && c1108uH.f5819iy && z3 && !z5 && !z4 && !localPlayer.isSprinting()) {
            f5994hR = !f5994hR;
            if (this.f6019hX) {
                C0415hE.m1960a(C0418hH.f2691H);
            }
            m6364a(minecraft, itemStack);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m6364a(@NotNull Minecraft minecraft, @NotNull ItemStack itemStack) {
        C1118uR c1118uRM6408a = m6408a(itemStack);
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6204S = f5994hR ? c1118uRM6408a.m6204S() : c1118uRM6408a.m6206T();
        if (deferredHolderM6204S != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6204S.get(), 1.0f, 1.0f));
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: g */
    private boolean m6365g(@NotNull LocalPlayer localPlayer) {
        AbstractC0788oG<?, ?> abstractC0788oGM2692a;
        Entity vehicle = localPlayer.getVehicle();
        if (vehicle instanceof AbstractC0779ny) {
            AbstractC0779ny abstractC0779ny = (AbstractC0779ny) vehicle;
            C0733nE<AbstractC0779ny> c0733nEM3499b = abstractC0779ny.m3499b();
            List passengers = abstractC0779ny.getPassengers();
            if (passengers.contains(localPlayer)) {
                return !c0733nEM3499b.m3353a(passengers.indexOf(localPlayer)).f3938fr;
            }
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        return c0622lM2667b == null || (abstractC0788oGM2692a = c0622lM2667b.m2692a()) == null || abstractC0788oGM2692a.mo3720bj();
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    public void m6366b(@NotNull Minecraft minecraft, @NotNull ItemStack itemStack) {
        SoundEvent soundEventM6383a = m6383a(itemStack);
        if (soundEventM6383a != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(soundEventM6383a, 1.0f, 1.0f));
        }
        if (this.f6049a != null) {
            this.f6049a.mo6143a(this, itemStack, this.f6011bY);
        }
        if (!minecraft.options.getCameraType().isFirstPerson()) {
            this.f6011bY.clear();
        }
    }

    /* JADX INFO: renamed from: q */
    public void m6367q(@NotNull String str) {
        this.f6011bY.add(str);
    }

    /* JADX INFO: renamed from: a */
    public boolean m6368a(@NotNull LivingEntity livingEntity, @NotNull Level level, @NotNull ItemStack itemStack, boolean z) {
        SoundEvent soundEventM6383a;
        int iM6424cb = m6318a(itemStack).m6424cb();
        if (level.isClientSide() || m6304b(itemStack) <= 0 || m6311f(itemStack) || m6301a(itemStack) >= iM6424cb || this.f6045mp > 0) {
            return false;
        }
        int iM6319e = m6319e(itemStack);
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            if (!serverPlayer.isShiftKeyDown() && (soundEventM6383a = m6383a(itemStack)) != null) {
                level.playSound(serverPlayer, livingEntity.blockPosition(), soundEventM6383a, SoundSource.PLAYERS, 0.25f, 1.0f);
            }
            C1194vo.m6648a(new C1209wC(z), serverPlayer);
        }
        m6310e(itemStack, iM6319e);
        return true;
    }

    /* JADX INFO: renamed from: i */
    public void m6369i(@NotNull ItemStack itemStack) {
        int iM6304b = m6304b(itemStack);
        int iM6424cb = m6318a(itemStack).m6424cb();
        if (iM6304b <= 0) {
            return;
        }
        int iM6301a = iM6304b + m6301a(itemStack);
        if (iM6301a <= iM6424cb) {
            m6302b(itemStack, iM6301a);
            m6305c(itemStack, 0);
        } else {
            m6302b(itemStack, iM6424cb);
            m6305c(itemStack, iM6301a - iM6424cb);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6370a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull C0326fV c0326fV, @NotNull ItemStack itemStack, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (localPlayer.isSpectator() || localPlayer.noPhysics || C0050aU.f323bp >= 0.15f || C0050aU.f332bx >= 0.15f) {
            return;
        }
        boolean z = localPlayer.isSprinting() && !(this.f6055fz && !this.f6056fA);
        if (m6303e(itemStack) && localPlayer.getHealth() > 0.0f && this.f6045mp <= 0 && !m6311f(itemStack) && !z) {
            f6007hW = false;
            C1118uR c1118uRM6408a = m6408a(itemStack);
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6163w = c1118uRM6408a.m6163w();
            if (deferredHolderM6163w != null && !this.f6055fz) {
                this.f6055fz = true;
                this.f6056fA = false;
                this.f6045mp = c1118uRM6408a.m6218cf();
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6163w.get(), 1.0f, 5.0f));
                return;
            }
            C0050aU.f340bF = 0.0f;
            int iM6299c = (int) (5.0f * m6299c(itemStack));
            this.f6045mp = this.f6027a.m6222cg() - ((this.f6027a.m6221a() != EnumC1120uT.SEMI || deferredHolderM6163w == null) ? 0 : c1118uRM6408a.m6218cf());
            int iM3550aR = ((C0783oB.a) NeoForge.EVENT_BUS.post(new C0783oB.a(this, itemStack, this.f6045mp))).m3550aR() + iM6299c;
            this.f6046se = iM3550aR;
            this.f6045mp = iM3550aR;
            if (minecraft.options.getCameraType().isFirstPerson()) {
                this.f6011bY.add("fire");
            }
            if (this.f6019hX) {
                C0415hE.m1961a(this.shakeNodeData, (f5994hR || C0050aU.f330bv > 0.0f) ? 0.5f : 1.0f);
            }
            C1140un c1140unM6317a = m6317a(itemStack);
            if (this.f6023ib && c1140unM6317a.m6274cn()) {
                f5989rU = this.f6040sd;
            }
            this.f5613mz += 0.1f;
            this.f5995na += this.f5997nc;
            C0467iD.m2103a(minecraft, ThreadLocalRandom.current(), c0622l, c0326fV, this, localPlayer, clientLevel, itemStack);
            this.f6029ie = true;
            C1194vo.m6653c(new C1212wF());
            if (deferredHolderM6163w != null) {
                if (!c1118uRM6408a.m6215cM()) {
                    this.f6055fz = false;
                }
                this.f6056fA = true;
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: c */
    private void m6371c(@NotNull Minecraft minecraft, @NotNull ItemStack itemStack) throws MatchException {
        if (this.f6050ij && minecraft.options.getCameraType().isFirstPerson()) {
            this.f6011bY.add("dryfire");
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6374a = m6374a(itemStack);
        C0417hG c0417hGM6373a = this.f6051N;
        if (c0417hGM6373a == null) {
            c0417hGM6373a = m6373a(this.f6041a);
        }
        if (deferredHolderM6374a == null && c0417hGM6373a == null) {
            return;
        }
        if (deferredHolderM6374a != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6374a.get(), 1.0f, 1.0f));
            C1194vo.m6653c(new C1207wA());
        }
        f5991rW = 40;
        if (c0417hGM6373a != null && this.f6019hX) {
            C0415hE.m1961a(c0417hGM6373a, (f5994hR || C0050aU.f330bv > 0.0f) ? 0.5f : 1.0f);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.ur$1 */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/ur$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: w */
        static final /* synthetic */ int[] f6062w = new int[GunType.values().length];

        static {
            try {
                f6062w[GunType.PISTOL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6062w[GunType.SMG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6062w[GunType.RIFLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6062w[GunType.CARBINE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6062w[GunType.SHOTGUN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6062w[GunType.MG.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f6062w[GunType.LMG.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f6062w[GunType.AT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f6062w[GunType.ROCKET.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f6062w[GunType.FLAMETHROWER.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static DeferredHolder<SoundEvent, SoundEvent> m6372a(@Nullable GunType gunType) throws MatchException {
        if (gunType == null) {
            return null;
        }
        switch (AnonymousClass1.f6062w[gunType.ordinal()]) {
            case 1:
                return C1280xc.f7883vC;
            case 2:
                return C1280xc.f7885vE;
            case 3:
                return C1280xc.f7886vF;
            case 4:
                return C1280xc.f7887vG;
            case 5:
                return C1280xc.f7888vH;
            case 6:
                return C1280xc.f7889vI;
            case 7:
                return C1280xc.f7890vJ;
            case 8:
                return C1280xc.f7891vK;
            case C0862pb.f4509nv /* 9 */:
            case 10:
                return null;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private static C0417hG m6373a(@Nullable GunType gunType) throws MatchException {
        if (gunType == null) {
            return null;
        }
        switch (AnonymousClass1.f6062w[gunType.ordinal()]) {
            case 1:
            case 2:
            case 4:
                return C0418hH.f2667j;
            case 3:
            case 5:
                return C0418hH.f2668k;
            case 6:
            case 7:
            case 8:
                return C0418hH.f2669l;
            case C0862pb.f4509nv /* 9 */:
            case 10:
                return null;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public DeferredHolder<SoundEvent, SoundEvent> m6374a(@NotNull ItemStack itemStack) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6161v = m6408a(itemStack).m6161v();
        return deferredHolderM6161v != null ? deferredHolderM6161v : m6372a(this.f6041a);
    }

    /* JADX INFO: renamed from: a */
    public ItemStack m6375a(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        if (level.isClientSide()) {
            return itemStack;
        }
        m6302b(itemStack, m6301a(itemStack) - m6376bY());
        Vec3 eyePosition = livingEntity.getEyePosition();
        int id = livingEntity.getId();
        C1210wD c1210wD = new C1210wD(itemStack, eyePosition, id, m6301a(itemStack) <= 0);
        for (ServerPlayer serverPlayer : level.players()) {
            if (serverPlayer.getId() != id) {
                C1194vo.m6648a(c1210wD, serverPlayer);
            }
        }
        NeoForge.EVENT_BUS.post(new C0783oB.b(this, itemStack, livingEntity));
        m6300b(itemStack, m6299c(itemStack) + 0.005f);
        return itemStack;
    }

    /* JADX INFO: renamed from: bY */
    public int m6376bY() {
        return this.f6053sg;
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public C1144ur m6377g(int i) {
        this.f6053sg = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C1144ur m6378c(float f) {
        this.f5997nc = f;
        return this;
    }

    /* JADX INFO: renamed from: D */
    public float m6379D(float f) {
        return ((C1290xm.m7843e(this.f5995na, this.f5996nb, f) % 360.0f) + 360.0f) % 360.0f;
    }

    /* JADX INFO: renamed from: ds */
    public void m6380ds() {
        this.f5995na = 0.0f;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6381a(@NotNull C1118uR c1118uR, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, float f) {
        if (this.f6054ik) {
            Vec3 vec3Add = Vec3.ZERO.add(1.0d, 0.0d, 1.0d).yRot(((-f) * 0.017453292f) - 1.5707964f).add(vec3);
            BlockHitResult blockHitResultClip = clientLevel.clip(new ClipContext(vec3Add, vec3Add.add(0.0d, -16.0d, 0.0d), ClipContext.Block.VISUAL, ClipContext.Fluid.ANY, CollisionContext.empty()));
            Vec3 location = blockHitResultClip.getLocation();
            BlockPos blockPos = blockHitResultClip.getBlockPos();
            BlockState blockState = clientLevel.getBlockState(blockPos);
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6197a = c1118uR.m6197a(clientLevel, blockPos, blockState, blockState.getSoundType(clientLevel, blockPos, (Entity) null));
            if (deferredHolderM6197a == null) {
                return;
            }
            minecraft.getSoundManager().playDelayed(new SimpleSoundInstance((SoundEvent) deferredHolderM6197a.get(), SoundSource.PLAYERS, 1.0f, 0.9f + (0.1f * ThreadLocalRandom.current().nextInt(2)), RandomSource.create(), location.x, location.y, location.z), (int) (3.0d * location.distanceTo(vec3)));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6382a(@NotNull Vector3f vector3f, boolean z) {
        this.f6037ii = true;
        this.f6039m = vector3f;
        this.f6036ih = z;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public SoundEvent m6383a(@NotNull ItemStack itemStack) {
        C1118uR c1118uRM6408a = m6408a(itemStack);
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6157t = m6301a(itemStack) <= 0 ? c1118uRM6408a.m6157t() : c1118uRM6408a.m6155s();
        if (deferredHolderM6157t != null) {
            return (SoundEvent) deferredHolderM6157t.get();
        }
        return null;
    }

    /* JADX INFO: renamed from: bv */
    public float m6384bv() {
        return this.f6038nf;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1144ur m6385d(float f) {
        this.f6038nf = f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6386a(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        if (m6303e(itemStack) && livingEntity.isAlive() && livingEntity.getHealth() > 0.0f) {
            ItemStack itemStackM6375a = m6375a(itemStack, level, livingEntity);
            if (livingEntity instanceof Player) {
                Player player = (Player) livingEntity;
                player.getInventory().setItem(player.getInventory().selected, itemStackM6375a);
            } else {
                livingEntity.setItemInHand(InteractionHand.MAIN_HAND, itemStackM6375a);
            }
            C1140un c1140unM6317a = m6317a(itemStack);
            if (this.f6023ib && c1140unM6317a.m6274cn()) {
                m6315f(itemStackM6375a, 1);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m6387a(@NotNull AbstractC0183c<?> abstractC0183c, @NotNull Level level, @NotNull Player player, @NotNull ItemStack itemStack) {
        EntityType<? extends InterfaceC0724mw> entityType;
        Supplier<EntityType<? extends InterfaceC0724mw>> supplierM6223b = this.f6027a.m6223b();
        if (supplierM6223b == null) {
            return;
        }
        AbstractC0182b abstractC0182bM1136a = abstractC0183c.m1136a(player);
        if (abstractC0182bM1136a.m1093dm() || C0799oR.m4052a(player, (AbstractC0182b<?, ?, ?, ?>) abstractC0182bM1136a) || (entityType = supplierM6223b.get()) == null) {
            return;
        }
        int iM6225ch = this.f6027a.m6225ch();
        for (int i = 0; i < iM6225ch; i++) {
            InterfaceC0724mw interfaceC0724mwCreate = entityType.create(level);
            if (interfaceC0724mwCreate != null) {
                interfaceC0724mwCreate.mo3283a(player, 3.0f, itemStack.copy(), 0.0f, 0.0f);
                level.addFreshEntity(interfaceC0724mwCreate);
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1144ur m6388b(@NotNull String str) {
        this.f6052dm = str;
        return this;
    }

    /* JADX INFO: renamed from: cv */
    public boolean m6389cv() {
        return this.f6021hZ;
    }

    /* JADX INFO: renamed from: a */
    public C1119uS[] m6390a() {
        return this.f6025a;
    }

    /* JADX INFO: renamed from: cw */
    public boolean m6391cw() {
        return this.f6020hY;
    }

    /* JADX INFO: renamed from: bZ */
    public int m6392bZ() {
        return this.f6018sa;
    }

    @NotNull
    /* JADX INFO: renamed from: R */
    public ResourceLocation m6393R() {
        return this.f6014gj;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1109uI m6394a() {
        C1109uI c1109uIM6112a = C1109uI.m6112a(this.f6014gj);
        return c1109uIM6112a != null ? c1109uIM6112a : C1109uI.f5825d;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6395a(@NotNull C1111uK c1111uK) {
        this.f6015a = c1111uK;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1111uK m6396a() {
        return this.f6015a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6397a(@NotNull C1113uM c1113uM) {
        this.f6016a = c1113uM;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1113uM m6398a() {
        return this.f6016a;
    }

    /* JADX INFO: renamed from: ca */
    public int m6399ca() {
        return this.f6031sc;
    }

    /* JADX INFO: renamed from: bw */
    public float m6400bw() {
        return this.f6032ne;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public Vector3f m6401c() {
        return this.f6039m;
    }

    /* JADX INFO: renamed from: cx */
    public boolean m6402cx() {
        return this.f6037ii;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6403a(@NotNull Vector3f vector3f) {
        return m6382a(vector3f, false);
    }

    /* JADX INFO: renamed from: cy */
    public boolean m6404cy() {
        return this.f6036ih;
    }

    /* JADX INFO: renamed from: cz */
    public boolean m6405cz() {
        return this.f6035ig;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @OnlyIn(Dist.CLIENT)
    @NotNull
    public Component getName(ItemStack itemStack) {
        Component name = super.getName(itemStack);
        if (m6297d(itemStack)) {
            name = name.copy().append(" ").append(f5977jF);
        }
        C1145us c1145usM6318a = m6318a(itemStack);
        if (c1145usM6318a != C1145us.f6069a && !c1145usM6318a.m6422bF()) {
            name = name.copy().append(Component.translatable("bf.item.gun.mag", new Object[]{c1145usM6318a.m6423m()}));
        }
        C1140un c1140unM6317a = m6317a(itemStack);
        if (c1140unM6317a != C1140un.f5958a) {
            name = name.copy().append(Component.translatable("bf.item.gun.barrel", new Object[]{c1140unM6317a.getDisplayName()}));
        }
        if (m6311f(itemStack)) {
            name = name.copy().append(" ").append(f5978jG);
        }
        return name;
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        if (Minecraft.getInstance().options.advancedItemTooltips) {
            C1140un c1140unM6317a = m6317a(itemStack);
            C1145us c1145usM6318a = m6318a(itemStack);
            int iM6424cb = c1145usM6318a.m6424cb();
            int iM6425cc = c1145usM6318a.m6425cc();
            int iM6304b = m6304b(itemStack);
            int iM6222cg = this.f6027a.m6222cg();
            C1109uI c1109uIM6394a = m6394a();
            list.add(Component.empty());
            list.add(Component.literal("Damage Config Entries:"));
            list.add(Component.empty());
            for (Map.Entry<Float, FloatFloatPair> entry : c1109uIM6394a.m6117s().entrySet()) {
                FloatFloatPair value = entry.getValue();
                list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Distance >= " + String.valueOf(ChatFormatting.DARK_GRAY) + String.valueOf(entry.getKey()) + String.valueOf(ChatFormatting.GRAY) + " Blocks"));
                list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Body: " + String.valueOf(ChatFormatting.DARK_GRAY) + value.leftFloat()));
                list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Headshot: " + String.valueOf(ChatFormatting.DARK_GRAY) + value.rightFloat()));
                list.add(Component.empty());
            }
            list.add(Component.literal("Mag Type"));
            list.add(Component.literal(String.valueOf(m6301a(itemStack)) + String.valueOf(ChatFormatting.GRAY) + " / " + String.valueOf(ChatFormatting.WHITE) + iM6424cb + String.valueOf(ChatFormatting.GRAY) + " - " + String.valueOf(ChatFormatting.WHITE) + iM6304b));
            list.add(c1145usM6318a.m6423m().copy().withStyle(ChatFormatting.GRAY));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Capacity: " + String.valueOf(ChatFormatting.DARK_GRAY) + iM6424cb));
            list.add(Component.empty());
            list.add(Component.literal("Barrel Type"));
            list.add(c1140unM6317a.getDisplayName().copy().withStyle(ChatFormatting.GRAY));
            list.add(Component.empty());
            list.add(Component.literal("Other Info"));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Max Hit Dist: " + String.valueOf(ChatFormatting.DARK_GRAY) + this.f6018sa + " Blocks"));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Fire-rate: " + String.valueOf(ChatFormatting.DARK_GRAY) + iM6222cg + " (" + (iM6222cg / 2) + " ticks)"));
            C1118uR c1118uRM6408a = m6408a(itemStack);
            if (c1118uRM6408a.m6163w() != null) {
                int iM6218cf = c1118uRM6408a.m6218cf();
                boolean zM6215cM = c1118uRM6408a.m6215cM();
                int i = zM6215cM ? iM6222cg : (iM6218cf + iM6222cg) - (this.f6027a.m6221a() == EnumC1120uT.SEMI ? iM6218cf : 0);
                list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Pre-fire delay: " + String.valueOf(ChatFormatting.DARK_GRAY) + iM6218cf + " (" + (iM6218cf / 2) + " ticks)" + (zM6215cM ? " (once)" : "")));
                if (i != iM6222cg) {
                    list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Effective fire-rate: " + String.valueOf(ChatFormatting.DARK_GRAY) + i + " (" + (i / 2) + " ticks)"));
                }
            }
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Max Ammo Count: " + String.valueOf(ChatFormatting.DARK_GRAY) + iM6425cc));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Clip Capacity: " + String.valueOf(ChatFormatting.DARK_GRAY) + iM6424cb));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Weight: " + String.valueOf(ChatFormatting.DARK_GRAY) + this.f6044ng));
            list.add(Component.empty());
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @NotNull
    /* JADX INFO: renamed from: x */
    public Vec3 mo5893x() {
        return f5983aq;
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    /* JADX INFO: renamed from: a */
    protected void mo5936a(@NotNull ItemStack itemStack, @NotNull Entity entity) {
        super.mo5936a(itemStack, entity);
        C1145us c1145usM6318a = m6318a(itemStack);
        int iM6424cb = c1145usM6318a.m6424cb();
        m6305c(itemStack, c1145usM6318a.m6425cc());
        m6308d(itemStack, c1145usM6318a.m6425cc());
        m6302b(itemStack, iM6424cb);
        ServerLevel serverLevelLevel = entity.level();
        if (serverLevelLevel instanceof ServerLevel) {
            GeoItem.getOrAssignId(itemStack, serverLevelLevel);
        }
        m6309g(itemStack);
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    public void inventoryTick(ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        int iM6312d;
        super.inventoryTick(itemStack, level, entity, i, z);
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (z) {
                player.swinging = false;
            }
        }
        if (m6313g(itemStack)) {
            m6314h(itemStack);
        }
        if (!level.isClientSide()) {
            float f = 0.001f;
            float fM6299c = m6299c(itemStack);
            if (entity.isInWaterOrRain()) {
                f = 0.0025f;
            }
            if (entity.isInWater()) {
                f = 0.005f;
            }
            if (fM6299c > 0.0f) {
                fM6299c -= f;
                if (fM6299c < 0.0f) {
                    fM6299c = 0.0f;
                }
            }
            m6300b(itemStack, fM6299c);
        }
        if (z && !level.isClientSide() && (iM6312d = m6312d(itemStack)) > 0) {
            m6310e(itemStack, iM6312d - 1);
            if (m6312d(itemStack) <= 0) {
                m6369i(itemStack);
            }
        }
    }

    /* JADX INFO: renamed from: E */
    public float m6406E(float f) {
        return C1290xm.m7843e(this.f6045mp, this.f6046se, f);
    }

    /* JADX INFO: renamed from: a */
    public float m6407a(@NotNull ItemStack itemStack, float f) {
        return C1290xm.m7843e(m6312d(itemStack), this.f6048nh, f);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        return new InteractionResultHolder<>(InteractionResult.FAIL, player.getItemInHand(interactionHand));
    }

    @Override // com.boehmod.blockfront.InterfaceC1099tz
    /* JADX INFO: renamed from: b */
    public boolean mo6054b(@NotNull Player player, @NotNull ItemStack itemStack) {
        return !player.isCreative();
    }

    @Override // com.boehmod.blockfront.InterfaceC1099tz
    /* JADX INFO: renamed from: a */
    public float mo6055a(@NotNull ItemStack itemStack) {
        return this.f6044ng;
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

    @Override // com.boehmod.blockfront.InterfaceC1048tA
    /* JADX INFO: renamed from: a */
    public void mo5828a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull C0324fT c0324fT, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
        boolean zAG;
        ItemStack mainHandItem = abstractClientPlayer.getMainHandItem();
        if ((mainHandItem.getItem() instanceof C1144ur) && m6311f(mainHandItem)) {
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
            zAG = c0324fT.m1111aG();
            abstractClientPlayer.swinging = false;
            abstractClientPlayer.attackAnim = 0.0f;
        } else {
            zAG = f5994hR || f5991rW > 0;
        }
        playerModel.rightArm.xRot = zAG ? (-1.55f) + playerModel.head.xRot : -0.5f;
        playerModel.rightArm.yRot = zAG ? playerModel.head.yRot : -1.2f;
        playerModel.rightArm.zRot = zAG ? 0.0f : -0.4f;
        float f5 = zAG ? -0.4f : 0.0f;
        if (m6389cv()) {
            playerModel.leftArm.xRot = zAG ? (-1.6f) + playerModel.head.xRot : -0.2f;
            playerModel.leftArm.yRot = zAG ? 0.9f + playerModel.head.yRot : -0.5f;
            playerModel.leftArm.zRot = zAG ? playerModel.head.zRot : -0.4f;
            playerModel.head.zRot = f5;
        } else if (!zAG || !m6343cs()) {
            playerModel.leftArm.xRot = zAG ? (-1.6f) + playerModel.head.xRot : -0.4f;
            playerModel.leftArm.yRot = zAG ? 0.9f + playerModel.head.yRot : -0.5f;
            playerModel.leftArm.zRot = zAG ? playerModel.head.zRot : 0.6f;
            playerModel.head.zRot = f5;
        }
        if (Minecraft.useFancyGraphics() && zAG) {
            float fM7843e = 1.5f * C1290xm.m7843e(c0324fT.f1492oi, c0324fT.f1493oj, f2);
            playerModel.rightArm.z += fM7843e;
            playerModel.rightSleeve.z += fM7843e;
            if (!m6343cs()) {
                playerModel.leftArm.z += fM7843e;
                playerModel.leftSleeve.z += fM7843e;
            }
            float fSin5 = Mth.sin(f) * fM7843e;
            float fSin6 = Mth.sin(f * 1.2f) * fM7843e;
            float f6 = 0.01f * fSin5;
            float f7 = 0.01f * fSin6;
            playerModel.rightArm.xRot += f6;
            playerModel.rightSleeve.xRot += f6;
            playerModel.rightArm.zRot += f7;
            playerModel.rightSleeve.zRot += f7;
            if (!m6343cs()) {
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
        controllerRegistrar.add(new AnimationController(this, f5979dl, 0, this::mo5943a).setSoundKeyframeHandler(this::mo5944a).setCustomInstructionKeyframeHandler(this::mo5945b));
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f6010d;
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public boolean shouldPlayAnimsWhileGamePaused() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected PlayState mo5943a(@NotNull AnimationState<C1144ur> animationState) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) {
            return PlayState.STOP;
        }
        ItemDisplayContext itemDisplayContext = (ItemDisplayContext) animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
        if (itemDisplayContext == null || !itemDisplayContext.firstPerson()) {
            return PlayState.STOP;
        }
        String strAt = ((C1144ur) animationState.getAnimatable()).m5942at();
        ItemStack itemStack = (ItemStack) animationState.getData(DataTickets.ITEMSTACK);
        if (itemStack == null) {
            return PlayState.STOP;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f6061in && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        boolean z = this.f6049a != null && this.f6049a.mo6145cK() && m6301a(itemStack) <= 0;
        boolean zDk = c0326fV.m1675a(minecraft).m1087dk();
        String str = "animation." + strAt + ".";
        AnimationController<T> controller = animationState.getController();
        if (!this.f6011bY.isEmpty()) {
            controller.forceAnimationReset();
            RawAnimation rawAnimationBegin = RawAnimation.begin();
            boolean z2 = false;
            for (String str2 : this.f6011bY) {
                if (!str2.contains("fire") || str2.equals("dryfire") || !z) {
                    rawAnimationBegin.then(str + str2, Animation.LoopType.PLAY_ONCE);
                    if (str2.contains("reload")) {
                        z2 = true;
                    }
                }
            }
            this.f6011bY.clear();
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

    /* JADX INFO: renamed from: a */
    public C1118uR m6408a(@NotNull ItemStack itemStack) {
        C1118uR c1118uRM6276a = m6317a(itemStack).m6276a();
        if (c1118uRM6276a != null) {
            return c1118uRM6276a;
        }
        return this.f6030a;
    }

    /* JADX INFO: renamed from: a */
    public C1144ur m6409a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6033if = true;
        this.f6034aW = deferredHolder;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: j */
    public void m6410j(@NotNull ItemStack itemStack) {
        if (this.f6033if && !m6311f(itemStack)) {
            m6367q("equip");
        }
        m6367q(this.f6049a != null && this.f6049a.mo6145cK() && m6301a(itemStack) <= 0 ? "idle_empty" : "idle");
        if (this.f6034aW != null) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) this.f6034aW.get(), 0.9f + (0.2f * ThreadLocalRandom.current().nextFloat()), 1.0f));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo5944a(@NotNull SoundKeyframeEvent<C1144ur> soundKeyframeEvent) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = f5982af.get(soundKeyframeEvent.getKeyframeData().getSound());
        if (deferredHolder != null) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolder.get(), 0.95f + (0.1f * ThreadLocalRandom.current().nextFloat()), 0.5f));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1062tO
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo5945b(@NotNull CustomInstructionKeyframeEvent<C1144ur> customInstructionKeyframeEvent) {
        ThreadLocalRandom threadLocalRandomCurrent;
        String instructions;
        Vec3 eyePosition;
        float yRot;
        C1118uR c1118uRM6408a;
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
        c1118uRM6408a = m6408a(localPlayer.getMainHandItem());
        switch (instructions) {
            case "eject_bullet;":
                C0439hc.m2053a(threadLocalRandomCurrent, this.f6052dm, false);
                m6381a(c1118uRM6408a, minecraft, clientLevel, eyePosition, yRot);
                break;
            case "eject_bullet_flipped;":
                C0439hc.m2053a(threadLocalRandomCurrent, this.f6052dm, true);
                m6381a(c1118uRM6408a, minecraft, clientLevel, eyePosition, yRot - 90.0f);
                break;
            case "eject_bullet_audio;":
                m6381a(c1118uRM6408a, minecraft, clientLevel, eyePosition, yRot);
                break;
            case "eject_bullet_audio_flipped;":
                m6381a(c1118uRM6408a, minecraft, clientLevel, eyePosition, yRot - 90.0f);
                break;
            case "disable_dynamic_bullets;":
                this.f6035ig = true;
                break;
            case "reset_mag_rotation;":
                m6380ds();
                break;
            default:
                if (instructions.startsWith("shake(") && instructions.endsWith(");")) {
                    C0415hE.m1958f(instructions);
                    break;
                }
                break;
        }
    }

    /* JADX INFO: renamed from: cA */
    public boolean m6411cA() {
        return this.f6060im;
    }

    /* JADX INFO: renamed from: cB */
    public boolean m6412cB() {
        return this.f6024ic;
    }

    @NotNull
    /* JADX INFO: renamed from: au */
    public String m6413au() {
        return this.f6058dn;
    }

    @NotNull
    public C0417hG getShakeNodeData() {
        return this.shakeNodeData;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public C0417hG m6414a() {
        return this.f6051N;
    }

    /* JADX INFO: renamed from: bx */
    public float m6415bx() {
        return this.f5998nd;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC1147uu m6416a() {
        return this.f5999a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1096tw m6417a() {
        return this.f6017n;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6418a(@NotNull C1096tw c1096tw) {
        this.f6017n = c1096tw;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1144ur m6419a(@NotNull GunType gunType) {
        this.f6041a = gunType;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public GunType m6420a() {
        return this.f6041a;
    }

    /* JADX INFO: renamed from: b */
    public int m6421b(@NotNull RandomSource randomSource) {
        int i = this.f6000rX / 2;
        return i + randomSource.nextInt(this.f6000rX - i);
    }
}
