package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.player.challenge.GunType;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.uP */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uP.class */
public final class C1117uP extends AbstractC1140um<C1117uP> implements InterfaceC1071tW, InterfaceC1072tX, InterfaceC1073tY, InterfaceC1074tZ {

    /* JADX INFO: renamed from: jS */
    @NotNull
    private static final Component f6043jS;

    /* JADX INFO: renamed from: jT */
    @NotNull
    private static final Component f6044jT;

    /* JADX INFO: renamed from: dw */
    @NotNull
    public static final String f6045dw = "gun_controller";

    /* JADX INFO: renamed from: tW */
    public static final int f6046tW = 5;

    /* JADX INFO: renamed from: ce */
    @NotNull
    public static final List<C1117uP> f6047ce;

    /* JADX INFO: renamed from: af */
    @NotNull
    private static final Map<String, DeferredHolder<SoundEvent, SoundEvent>> f6048af;

    /* JADX INFO: renamed from: ar */
    @NotNull
    private static final Vec3 f6049ar;

    /* JADX INFO: renamed from: nS */
    private static final float f6050nS = 0.001f;

    /* JADX INFO: renamed from: nT */
    private static final float f6051nT = 0.0025f;

    /* JADX INFO: renamed from: nU */
    private static final float f6052nU = 0.005f;

    /* JADX INFO: renamed from: nV */
    private static final float f6053nV = 0.005f;

    /* JADX INFO: renamed from: nW */
    private static final float f6054nW = 3.0f;

    /* JADX INFO: renamed from: tX */
    private static final int f6055tX = 3;

    /* JADX INFO: renamed from: tY */
    public static final int f6056tY = 5;

    /* JADX INFO: renamed from: tZ */
    private static final int f6057tZ = 10;

    /* JADX INFO: renamed from: ua */
    public static int f6058ua;

    /* JADX INFO: renamed from: ub */
    public static int f6059ub;

    /* JADX INFO: renamed from: uc */
    public static int f6060uc;

    /* JADX INFO: renamed from: nX */
    public static float f6061nX;

    /* JADX INFO: renamed from: nY */
    public static float f6062nY;

    /* JADX INFO: renamed from: il */
    public static boolean f6063il;

    /* JADX INFO: renamed from: nZ */
    public float f6064nZ;

    /* JADX INFO: renamed from: oa */
    public float f6065oa;

    /* JADX INFO: renamed from: ob */
    public float f6066ob;

    /* JADX INFO: renamed from: oc */
    private float f6067oc;

    /* JADX INFO: renamed from: a */
    @NotNull
    private EnumC1122uU f6068a;

    /* JADX INFO: renamed from: ud */
    private int f6069ud;

    /* JADX INFO: renamed from: a */
    @Nullable
    private DeferredItem<? extends C1119uR> f6070a;

    /* JADX INFO: renamed from: ue */
    public static int f6071ue;

    /* JADX INFO: renamed from: im */
    public static boolean f6072im;

    /* JADX INFO: renamed from: in */
    public static boolean f6073in;

    /* JADX INFO: renamed from: io */
    public static boolean f6074io;

    /* JADX INFO: renamed from: ip */
    public static boolean f6075ip;

    /* JADX INFO: renamed from: iq */
    public static boolean f6076iq;

    /* JADX INFO: renamed from: ag */
    @NotNull
    private final Map<String, C1118uQ> f6077ag;

    /* JADX INFO: renamed from: ah */
    @NotNull
    private final Map<String, C1113uL> f6078ah;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final AnimatableInstanceCache f6079d;

    /* JADX INFO: renamed from: cf */
    @NotNull
    private final List<String> f6080cf;

    /* JADX INFO: renamed from: ai */
    @NotNull
    private final Map<C1188vh.a, C1188vh> f6081ai;

    /* JADX INFO: renamed from: uf */
    private int f6082uf;

    /* JADX INFO: renamed from: gi */
    @NotNull
    private ResourceLocation f6083gi;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1191vk f6084a;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1193vm f6085a;

    /* JADX INFO: renamed from: n */
    @NotNull
    private C1069tU f6086n;

    /* JADX INFO: renamed from: ug */
    private int f6087ug;

    /* JADX INFO: renamed from: ir */
    private boolean f6088ir;

    /* JADX INFO: renamed from: is */
    private boolean f6089is;

    /* JADX INFO: renamed from: it */
    private boolean f6090it;

    /* JADX INFO: renamed from: iu */
    private boolean f6091iu;

    /* JADX INFO: renamed from: iv */
    private boolean f6092iv;

    /* JADX INFO: renamed from: iw */
    private boolean f6093iw;

    /* JADX INFO: renamed from: a */
    private C1199vs[] f6094a;

    /* JADX INFO: renamed from: ix */
    private boolean f6095ix;

    /* JADX INFO: renamed from: iy */
    private boolean f6096iy;

    /* JADX INFO: renamed from: a */
    @NotNull
    private C1198vr f6097a;

    /* JADX INFO: renamed from: uh */
    private int f6098uh;

    /* JADX INFO: renamed from: od */
    private float f6099od;

    /* JADX INFO: renamed from: iz */
    private boolean f6100iz;

    /* JADX INFO: renamed from: aW */
    @Nullable
    private DeferredHolder<SoundEvent, SoundEvent> f6101aW;

    /* JADX INFO: renamed from: iA */
    private boolean f6102iA;

    /* JADX INFO: renamed from: iB */
    private boolean f6103iB;

    /* JADX INFO: renamed from: iC */
    private boolean f6104iC;

    /* JADX INFO: renamed from: oe */
    private float f6105oe;

    /* JADX INFO: renamed from: o */
    @NotNull
    private Vector3f f6106o;

    /* JADX INFO: renamed from: ui */
    private int f6107ui;

    /* JADX INFO: renamed from: a */
    @Nullable
    private GunType f6108a;

    /* JADX INFO: renamed from: as */
    @NotNull
    private Vec3 f6109as;

    /* JADX INFO: renamed from: at */
    @NotNull
    private Vec3 f6110at;

    /* JADX INFO: renamed from: of */
    private float f6111of;

    /* JADX INFO: renamed from: on */
    private int f6112on;

    /* JADX INFO: renamed from: uj */
    private int f6113uj;

    /* JADX INFO: renamed from: uk */
    private int f6114uk;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractC1195vo f6115a;

    /* JADX INFO: renamed from: iD */
    private boolean f6116iD;

    @NotNull
    private C0434hW shakeNodeData;

    /* JADX INFO: renamed from: O */
    @Nullable
    private C0434hW f6117O;

    /* JADX INFO: renamed from: dx */
    @NotNull
    private String f6118dx;

    /* JADX INFO: renamed from: ul */
    private int f6119ul;

    /* JADX INFO: renamed from: iE */
    private boolean f6120iE;

    /* JADX INFO: renamed from: fT */
    private boolean f6121fT;

    /* JADX INFO: renamed from: fU */
    private boolean f6122fU;

    /* JADX INFO: renamed from: iF */
    private boolean f6123iF;

    /* JADX INFO: renamed from: dy */
    @NotNull
    private String f6124dy;

    /* JADX INFO: renamed from: c */
    @NotNull
    private C1116uO.a f6125c;

    /* JADX INFO: renamed from: iG */
    private boolean f6126iG;

    /* JADX INFO: renamed from: iH */
    static final /* synthetic */ boolean f6127iH;

    static {
        f6127iH = !C1117uP.class.desiredAssertionStatus();
        f6043jS = Component.translatable("bf.item.gun.scoped");
        f6044jT = Component.translatable("bf.item.gun.reloading");
        f6047ce = new ObjectArrayList();
        f6048af = new Object2ObjectOpenHashMap();
        f6049ar = new Vec3(-15.0d, 20.0d, 10.0d);
        f6058ua = 0;
        f6059ub = 5;
        f6060uc = 0;
        f6062nY = 0.0f;
        f6063il = false;
        f6071ue = 0;
        f6072im = false;
        f6073in = false;
        f6074io = false;
        f6075ip = false;
        f6076iq = false;
        f6048af.put("reload_pump", C1312xz.f8391xw);
        f6048af.put("reload_pump_back", C1312xz.f8392xx);
        f6048af.put("reload_pump_forward", C1312xz.f8393xy);
        f6048af.put("reload_bolt_back", C1312xz.f8394xz);
        f6048af.put("reload_bolt_forward", C1312xz.f8395xA);
        f6048af.put("reload_shell", C1312xz.f8389xu);
        f6048af.put("reload_bullet_rifle", C1312xz.f8390xv);
        f6048af.put("reload_winchester_lever", C1312xz.f8396xB);
    }

    public C1117uP(@NotNull String str, @NotNull Item.Properties properties) {
        super(str, properties.stacksTo(1));
        this.f6065oa = 0.0f;
        this.f6066ob = 0.0f;
        this.f6067oc = 0.0f;
        this.f6068a = EnumC1122uU.ANY;
        this.f6069ud = 8;
        this.f6077ag = new Object2ObjectOpenHashMap();
        this.f6078ah = new Object2ObjectOpenHashMap();
        this.f6079d = GeckoLibUtil.createInstanceCache(this);
        this.f6080cf = new ObjectArrayList();
        this.f6081ai = new Object2ObjectOpenHashMap();
        this.f6082uf = 0;
        this.f6083gi = C1190vj.f6472gp;
        this.f6084a = C1192vl.f6490b;
        this.f6085a = C1194vn.f6499b;
        this.f6086n = new C1069tU(0.2f, 5.0f, 4.0f, 0.05f, 0.1f, 0.15f, 0.25f, 0.05f, 0.3f);
        this.f6087ug = 256;
        this.f6088ir = true;
        this.f6089is = false;
        this.f6090it = true;
        this.f6091iu = false;
        this.f6092iv = true;
        this.f6093iw = true;
        this.f6095ix = true;
        this.f6096iy = false;
        this.f6097a = new C1198vr();
        this.f6098uh = ColorReferences.COLOR_BULLET_TRACER;
        this.f6099od = 1.0f;
        this.f6100iz = false;
        this.f6101aW = null;
        this.f6102iA = false;
        this.f6103iB = false;
        this.f6104iC = false;
        this.f6105oe = 1.0f;
        this.f6106o = new Vector3f();
        this.f6107ui = 2;
        this.f6109as = new Vec3(1.0d, -0.10000000149011612d, 0.30000001192092896d);
        this.f6110at = new Vec3(0.0d, -0.25d, 0.0d);
        this.f6111of = 0.0f;
        this.f6113uj = 0;
        this.f6114uk = 0;
        this.f6115a = null;
        this.f6116iD = false;
        this.shakeNodeData = C0435hX.f2755e;
        this.f6117O = null;
        this.f6118dx = "rifle";
        this.f6119ul = 1;
        this.f6120iE = true;
        this.f6121fT = false;
        this.f6122fU = true;
        this.f6123iF = false;
        this.f6124dy = "default";
        this.f6125c = C1116uO.f6041b;
        this.f6126iG = false;
        f6047ce.add(this);
        this.f6078ah.put("default", C1113uL.f6024a);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static String m6257b(@NotNull ItemStack itemStack) {
        return (String) itemStack.getOrDefault(C1305xs.f7525F, "default");
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public static String m6258c(@NotNull ItemStack itemStack) {
        return (String) itemStack.getOrDefault(C1305xs.f7526G, "default");
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ItemStack m6259a(@NotNull ItemStack itemStack, @NotNull String str) {
        itemStack.set(C1305xs.f7525F, str);
        return itemStack;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public static ItemStack m6260b(@NotNull ItemStack itemStack, @NotNull String str) {
        itemStack.set(C1305xs.f7526G, str);
        return itemStack;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m6261d(@NotNull ItemStack itemStack) {
        return ((Boolean) itemStack.getOrDefault(C1305xs.f7535P, false)).booleanValue();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static ItemStack m6262a(@NotNull ItemStack itemStack, boolean z) {
        itemStack.set(C1305xs.f7535P, Boolean.valueOf(z));
        return itemStack;
    }

    /* JADX INFO: renamed from: a */
    public static float m6263a(@NotNull ItemStack itemStack, @NotNull Level level) {
        float fFloatValue = ((Float) itemStack.getOrDefault(C1305xs.f7534O, Float.valueOf(0.0f))).floatValue();
        if (fFloatValue <= 0.0f) {
            return 0.0f;
        }
        return Math.max(0.0f, fFloatValue - (f6050nS * Math.max(0L, level.getGameTime() - ((Long) itemStack.getOrDefault(C1305xs.f7531L, 0L)).longValue())));
    }

    /* JADX INFO: renamed from: a */
    public static void m6264a(@NotNull ItemStack itemStack, @NotNull Level level, float f) {
        itemStack.set(C1305xs.f7534O, Float.valueOf(f));
        itemStack.set(C1305xs.f7531L, Long.valueOf(level.getGameTime()));
    }

    /* JADX INFO: renamed from: c */
    public static int m6265c(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(C1305xs.f7528I, 0)).intValue();
    }

    /* JADX INFO: renamed from: b */
    public static void m6266b(@NotNull ItemStack itemStack, int i) {
        itemStack.set(C1305xs.f7528I, Integer.valueOf(Math.max(0, i)));
    }

    /* JADX INFO: renamed from: e */
    public static boolean m6267e(@NotNull ItemStack itemStack) {
        return m6265c(itemStack) > 0;
    }

    /* JADX INFO: renamed from: d */
    public static int m6268d(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(C1305xs.f7527H, 0)).intValue();
    }

    /* JADX INFO: renamed from: c */
    public static void m6269c(@NotNull ItemStack itemStack, int i) {
        itemStack.set(C1305xs.f7527H, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: f */
    public static void m6270f(@NotNull ItemStack itemStack) {
        m6269c(itemStack, m6271e(itemStack));
    }

    /* JADX INFO: renamed from: e */
    public static int m6271e(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(C1305xs.f7529J, 0)).intValue();
    }

    /* JADX INFO: renamed from: d */
    public static void m6272d(@NotNull ItemStack itemStack, int i) {
        itemStack.set(C1305xs.f7529J, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: g */
    public static void m6273g(@NotNull ItemStack itemStack) {
        itemStack.set(C1305xs.f7530K, 0L);
    }

    /* JADX INFO: renamed from: a */
    public static void m6274a(@NotNull ItemStack itemStack, long j) {
        itemStack.set(C1305xs.f7530K, Long.valueOf(j));
    }

    /* JADX INFO: renamed from: f */
    public static boolean m6275f(@NotNull ItemStack itemStack) {
        return m6276b(itemStack) != 0;
    }

    /* JADX INFO: renamed from: b */
    public static long m6276b(@NotNull ItemStack itemStack) {
        return ((Long) itemStack.getOrDefault(C1305xs.f7530K, 0L)).longValue();
    }

    /* JADX INFO: renamed from: a */
    public static long m6277a(@NotNull ItemStack itemStack, @NotNull Level level) {
        long jM6276b = m6276b(itemStack);
        if (jM6276b == 0) {
            return 0L;
        }
        return Math.max(0L, jM6276b - level.getGameTime());
    }

    /* JADX INFO: renamed from: g */
    public static boolean m6278g(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(C1305xs.f7533N, 0)).intValue() > 0;
    }

    /* JADX INFO: renamed from: h */
    public static void m6279h(@NotNull ItemStack itemStack) {
        itemStack.set(C1305xs.f7533N, Integer.valueOf(((Integer) itemStack.getOrDefault(C1305xs.f7533N, 0)).intValue() - 1));
    }

    /* JADX INFO: renamed from: e */
    public static void m6280e(@NotNull ItemStack itemStack, int i) {
        itemStack.set(C1305xs.f7533N, Integer.valueOf(i));
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private static void m6281a(@NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        if (Math.random() >= f) {
            return;
        }
        Vec3 vec3Add = localPlayer.getEyePosition(0.0f).add(new Vec3(1.25d, 0.0d, f6063il ? 0.0f : 0.3f).zRot(((localPlayer.getXRot() + 90.0f) * 0.017453292f) - 1.5707964f).yRot(((-localPlayer.getYRot()) * 0.017453292f) - 1.5707964f));
        clientLevel.addParticle(ParticleTypes.SMOKE, true, vec3Add.x, vec3Add.y, vec3Add.z, 0.0d, 0.0d, 0.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1113uL m6282a(@NotNull ItemStack itemStack) {
        return this.f6078ah.getOrDefault(m6258c(itemStack), C1113uL.f6024a);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1118uQ m6283a(@NotNull ItemStack itemStack) {
        return this.f6077ag.getOrDefault(m6257b(itemStack), C1118uQ.f6135a);
    }

    /* JADX INFO: renamed from: f */
    public int m6284f(@NotNull ItemStack itemStack) {
        return m6285a(itemStack, m6265c(itemStack), m6268d(itemStack));
    }

    /* JADX INFO: renamed from: a */
    public int m6285a(@NotNull ItemStack itemStack, int i, int i2) {
        float fMo6797a = 0.0f;
        if (this.f6115a != null) {
            fMo6797a = this.f6115a.mo6797a(this, itemStack, i, i2);
        }
        return (int) fMo6797a;
    }

    /* JADX INFO: renamed from: a */
    public C1117uP m6286a(@NotNull Vec3 vec3, @NotNull Vec3 vec4) {
        this.f6109as = vec3;
        this.f6110at = vec4;
        return this;
    }

    /* JADX INFO: renamed from: B */
    public Vec3 m6287B() {
        return this.f6109as;
    }

    /* JADX INFO: renamed from: C */
    public Vec3 m6288C() {
        return this.f6110at;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1117uP m6289d(int i) {
        this.f6069ud = i;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP mo6290a(float f) {
        this.f6067oc = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6291a(EnumC1122uU enumC1122uU) {
        this.f6068a = enumC1122uU;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6292a(@NotNull AbstractC1195vo abstractC1195vo) {
        this.f6115a = abstractC1195vo;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C1117uP m6293a(@NotNull DeferredItem<? extends C1119uR> deferredItem) {
        this.f6070a = deferredItem;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public DeferredItem<? extends C1119uR> m6294a() {
        return this.f6070a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6295a(@NotNull C1188vh.a aVar, @NotNull C1188vh c1188vh) {
        this.f6081ai.put(aVar, c1188vh);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1188vh m6296a(@NotNull ItemStack itemStack) {
        C1188vh.a aVar;
        Map<C1188vh.a, C1188vh> map = this.f6081ai;
        if (m6261d(itemStack)) {
            aVar = C1188vh.a.SCOPE;
        } else {
            aVar = C1188vh.a.DEFAULT;
        }
        return map.getOrDefault(aVar, C1188vh.f6453a);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6297a(@NotNull C0434hW c0434hW) {
        this.shakeNodeData = c0434hW;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1117uP m6298b(@Nullable C0434hW c0434hW) {
        this.f6117O = c0434hW;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6299a(boolean z) {
        this.f6116iD = z;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1116uO.a m6300a() {
        return this.f6125c;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6301a(@NotNull C1116uO.a aVar) {
        this.f6125c = aVar;
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1117uP m6302b(boolean z) {
        this.f6095ix = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6303a(String str) {
        this.f6124dy = str;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C1117uP m6304c(boolean z) {
        this.f6092iv = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1117uP m6305d(boolean z) {
        this.f6093iw = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C1117uP m6306e(boolean z) {
        this.f6088ir = z;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C1117uP m6307c() {
        this.f6120iE = false;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6308a(int i, float f) {
        this.f6098uh = i;
        this.f6099od = f;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1117uP m6309d() {
        this.f6123iF = true;
        return this;
    }

    /* JADX INFO: renamed from: cB */
    public boolean m6310cB() {
        return this.f6123iF;
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP mo6311a(@NotNull ResourceLocation resourceLocation) {
        this.f6083gi = resourceLocation;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6312a(@NotNull C1198vr c1198vr) {
        this.f6097a = c1198vr;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C1117uP m6313e() {
        this.f6090it = false;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public C1117uP m6314f() {
        this.f6091iu = true;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1199vs m6315a(@NotNull ItemStack itemStack) {
        return m6318a(m6319g(itemStack));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1199vs m6316a() {
        return this.f6094a[0];
    }

    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: b */
    public C1199vs m6317b() {
        return m6318a(C0486iV.m2183ay());
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private C1199vs m6318a(int i) {
        return this.f6094a[(i < 0 || i >= this.f6094a.length) ? 0 : i];
    }

    /* JADX INFO: renamed from: g */
    public static int m6319g(@NotNull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(C1305xs.f7532M, 0)).intValue();
    }

    /* JADX INFO: renamed from: f */
    public static void m6320f(@NotNull ItemStack itemStack, int i) {
        itemStack.set(C1305xs.f7532M, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: cm */
    public int m6321cm() {
        if (this.f6094a == null || this.f6094a.length == 0) {
            return 1;
        }
        int iMin = Integer.MAX_VALUE;
        for (C1199vs c1199vs : this.f6094a) {
            iMin = Math.min(iMin, c1199vs.m6875cw());
        }
        return Math.max(1, iMin);
    }

    /* JADX INFO: renamed from: a */
    public int m6322a(@NotNull C1199vs c1199vs, @NotNull C1198vr c1198vr) {
        if (c1199vs.m6874a() != EnumC1200vt.SEMI || c1198vr.m6816w() == null || c1198vr.m6868cV()) {
            return 0;
        }
        return c1198vr.m6871cv();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6323a(@NotNull C1199vs[] c1199vsArr) {
        this.f6094a = c1199vsArr;
        return this;
    }

    /* JADX INFO: renamed from: cC */
    public boolean m6324cC() {
        return this.f6095ix;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6325a(int i, int i2) {
        return m6326a("default", new C1118uQ(true, C1118uQ.f6134jV, i, i2));
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6326a(String str, C1118uQ c1118uQ) {
        this.f6077ag.put(str, c1118uQ);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6327a(@NotNull String str, @NotNull C1113uL c1113uL) {
        this.f6078ah.put(str, c1113uL);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public C1117uP m6328g() {
        this.f6126iG = true;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public C1117uP m6329e(int i) {
        this.f6087ug = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: f */
    public C1117uP m6330f(int i) {
        this.f6107ui = i;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @NotNull
    /* JADX INFO: renamed from: b */
    public C1117uP mo6331b(float f) {
        float f2;
        if (f > 1.0f) {
            f2 = 1.0f;
        } else {
            f2 = f < 0.0f ? 0.0f : f;
        }
        this.f6111of = f2;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: h */
    public C1117uP m6332h() {
        this.f6089is = true;
        return this;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6333a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull ItemStack itemStack, @NotNull C0394gj c0394gj) throws MatchException {
        boolean z;
        boolean z2 = localPlayer.getMainHandItem() == itemStack;
        boolean zM2182aa = C0486iV.m2182aa();
        C1188vh c1188vhM6296a = m6296a(itemStack);
        boolean z3 = f6074io;
        boolean z4 = f6075ip;
        f6074io = false;
        f6075ip = false;
        this.f6113uj = this.f6112on;
        this.f6065oa = this.f6064nZ;
        int iM2179aw = C0486iV.m2179aw();
        if (iM2179aw > this.f6082uf) {
            this.f6102iA = false;
        }
        this.f6082uf = iM2179aw;
        if (this.f6112on > 0) {
            this.f6112on--;
        }
        if (this.f6114uk > 0) {
            this.f6114uk--;
        }
        if (zM2182aa) {
            this.f6252ny += 0.01f;
        }
        float fM6263a = m6263a(itemStack, (Level) clientLevel);
        if (fM6263a > 0.0f && !zM2182aa) {
            m6281a(localPlayer, clientLevel, fM6263a);
        }
        if (zM2182aa) {
            f6063il = false;
            f6076iq = false;
            return;
        }
        Entity vehicle = localPlayer.getVehicle();
        if ((vehicle instanceof AbstractC0750nU) && ((AbstractC0750nU) vehicle).m3451l(localPlayer)) {
            f6063il = false;
            return;
        }
        boolean z5 = minecraft.screen != null;
        boolean z6 = f6072im && !z5;
        boolean z7 = f6073in && !z5;
        boolean z8 = m6317b().m6874a() == EnumC1200vt.AUTO;
        boolean z9 = this.f6112on <= 0 && f6071ue <= 0;
        if (z8) {
            z = z6;
        } else if (z3 && !z5) {
            if (z9) {
                z = true;
            } else {
                f6076iq = true;
                z = false;
            }
        } else {
            z = f6076iq && z6;
        }
        C1198vr c1198vrM6384a = m6384a(itemStack);
        if (f6071ue <= 0) {
            boolean z10 = (c1198vrM6384a.m6816w() == null || this.f6122fU) ? false : true;
            if (!this.f6091iu || C0115bf.f780bU >= 1.0f || z10) {
                if ((z || (c1198vrM6384a.m6816w() != null && !this.f6122fU)) && !c0394gj.m1110dv() && !c0394gj.m1104dt() && !localPlayer.isEyeInFluidType((FluidType) NeoForgeMod.WATER_TYPE.value())) {
                    if (m6339g(localPlayer)) {
                        m6344a(minecraft, c0623l, c0396gl, itemStack, localPlayer, clientLevel);
                    }
                } else {
                    this.f6121fT = false;
                    this.f6122fU = true;
                }
            }
            m6337a(minecraft, localPlayer, clientLevel, c1188vhM6296a, itemStack, z7, z4, z2, zM2182aa);
            if (z3 && iM2179aw <= 0 && this.f6114uk <= 0 && !zM2182aa && C0112bc.f737bv < 0.15f && C0112bc.f746bD < 0.15f && !c0394gj.m1110dv() && !c0394gj.m1104dt() && localPlayer.getHealth() > 0.0f && !localPlayer.isSprinting() && !localPlayer.isEyeInFluidType((FluidType) NeoForgeMod.WATER_TYPE.value())) {
                m6345b(minecraft, itemStack);
                this.f6114uk = 3;
            }
        }
        if (!z6 || iM2179aw <= 0) {
            m6336e((LivingEntity) localPlayer);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: dC */
    public void m6334dC() {
        this.f6121fT = false;
        this.f6122fU = true;
        this.f6112on = 0;
        this.f6114uk = 0;
        this.f6096iy = false;
        f6076iq = false;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: cD */
    public boolean m6335cD() {
        return this.f6121fT && !this.f6122fU;
    }

    @Override // com.boehmod.blockfront.InterfaceC1074tZ
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public boolean mo5943a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        f6072im = true;
        f6074io = true;
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC1074tZ
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    public boolean mo5944b(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        f6072im = false;
        f6076iq = false;
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC1074tZ
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: c */
    public boolean mo5945c(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        f6073in = true;
        f6075ip = true;
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC1074tZ
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: d */
    public boolean mo5946d(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ItemStack itemStack) {
        f6073in = false;
        return false;
    }

    /* JADX INFO: renamed from: e */
    private void m6336e(@NotNull LivingEntity livingEntity) {
        if (this.f6096iy) {
            if (this.f6097a.m6817x() != null) {
                livingEntity.playSound((SoundEvent) this.f6097a.m6817x().get(), 1.0f, 1.0f);
            }
            this.f6096iy = false;
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m6337a(@NotNull Minecraft minecraft, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull C1188vh c1188vh, @NotNull ItemStack itemStack, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        BlockHitResult blockHitResult = minecraft.hitResult;
        if (blockHitResult instanceof BlockHitResult) {
            Block block = clientLevel.getBlockState(blockHitResult.getBlockPos()).getBlock();
            if ((block instanceof DoorBlock) || (block instanceof LeverBlock) || (block instanceof ButtonBlock) || (block instanceof FenceGateBlock) || (block instanceof C0590kT) || (block instanceof ChestBlock) || (block instanceof C0660lk)) {
                z5 = true;
            }
        }
        if (!C0495ie.f3055I.m2230U()) {
            boolean z6 = f6063il;
            if (c1188vh.f6458iS && z3 && !z4 && !localPlayer.isSprinting()) {
                if (z) {
                    if (!z5) {
                        f6063il = true;
                    }
                } else {
                    f6063il = false;
                }
                if (z5) {
                    f6063il = false;
                }
            }
            if (f6063il != z6) {
                m6338a(minecraft, itemStack);
                if (this.f6088ir) {
                    C0432hU.m1986a(C0435hX.f2784H);
                    return;
                }
                return;
            }
            return;
        }
        if (z2 && c1188vh.f6458iS && z3 && !z5 && !z4 && !localPlayer.isSprinting()) {
            f6063il = !f6063il;
            if (this.f6088ir) {
                C0432hU.m1986a(C0435hX.f2784H);
            }
            m6338a(minecraft, itemStack);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    private void m6338a(@NotNull Minecraft minecraft, @NotNull ItemStack itemStack) {
        C1198vr c1198vrM6384a = m6384a(itemStack);
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6857S = f6063il ? c1198vrM6384a.m6857S() : c1198vrM6384a.m6859T();
        if (deferredHolderM6857S != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6857S.get(), 1.0f, 1.0f));
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: g */
    private boolean m6339g(@NotNull LocalPlayer localPlayer) {
        AbstractC0864pc<?, ?> abstractC0864pcM2878a;
        Entity vehicle = localPlayer.getVehicle();
        if (vehicle instanceof AbstractC0750nU) {
            AbstractC0750nU abstractC0750nU = (AbstractC0750nU) vehicle;
            C0809oa<AbstractC0750nU> c0809oaM3436b = abstractC0750nU.m3436b();
            List passengers = abstractC0750nU.getPassengers();
            if (passengers.contains(localPlayer)) {
                return !c0809oaM3436b.m3731a(passengers.indexOf(localPlayer)).f4186fL;
            }
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        return c0623lM2852b == null || (abstractC0864pcM2878a = c0623lM2852b.m2878a()) == null || abstractC0864pcM2878a.mo4156bt();
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6340a(@NotNull Minecraft minecraft, @NotNull ItemStack itemStack, int i, int i2) {
        SoundEvent soundEventM6358a = m6358a(itemStack, i);
        if (soundEventM6358a != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(soundEventM6358a, 1.0f, 1.0f));
        }
        if (this.f6115a != null) {
            this.f6115a.mo6796a(this, itemStack, i, i2, this.f6080cf);
        }
        if (!minecraft.options.getCameraType().isFirstPerson()) {
            this.f6080cf.clear();
        }
    }

    /* JADX INFO: renamed from: q */
    public void m6341q(@NotNull String str) {
        this.f6080cf.add(str);
    }

    /* JADX INFO: renamed from: a */
    public boolean m6342a(@NotNull LivingEntity livingEntity, @NotNull Level level, @NotNull ItemStack itemStack, long j) {
        SoundEvent soundEventM6357a;
        int iM6402cq = m6283a(itemStack).m6402cq();
        if (level.isClientSide() || m6268d(itemStack) <= 0 || m6275f(itemStack) || m6265c(itemStack) >= iM6402cq) {
            return false;
        }
        int iM6284f = m6284f(itemStack);
        if (livingEntity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) livingEntity;
            if (!serverPlayer.isShiftKeyDown() && (soundEventM6357a = m6357a(itemStack)) != null) {
                level.playSound(serverPlayer, livingEntity.blockPosition(), soundEventM6357a, SoundSource.PLAYERS, 0.25f, 1.0f);
            }
        }
        long gameTime = level.getGameTime();
        m6274a(itemStack, Math.max(gameTime + 1, Mth.clamp(j, gameTime - 10, gameTime) + ((long) iM6284f)));
        return true;
    }

    /* JADX INFO: renamed from: i */
    public void m6343i(@NotNull ItemStack itemStack) {
        int iM6268d = m6268d(itemStack);
        int iM6402cq = m6283a(itemStack).m6402cq();
        if (iM6268d <= 0) {
            return;
        }
        int iM6265c = iM6268d + m6265c(itemStack);
        if (iM6265c <= iM6402cq) {
            m6266b(itemStack, iM6265c);
            m6269c(itemStack, 0);
        } else {
            m6266b(itemStack, iM6402cq);
            m6269c(itemStack, iM6265c - iM6402cq);
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6344a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull C0396gl c0396gl, @NotNull ItemStack itemStack, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel) {
        if (localPlayer.isSpectator() || localPlayer.noPhysics || C0112bc.f737bv >= 0.15f || C0112bc.f746bD >= 0.15f) {
            return;
        }
        boolean z = localPlayer.isSprinting() && !(this.f6121fT && !this.f6122fU);
        if (C0486iV.m2180Z() && localPlayer.getHealth() > 0.0f && this.f6112on <= 0 && !C0486iV.m2182aa() && !z) {
            f6076iq = false;
            C1198vr c1198vrM6384a = m6384a(itemStack);
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6816w = c1198vrM6384a.m6816w();
            if (deferredHolderM6816w != null && !this.f6121fT) {
                this.f6121fT = true;
                this.f6122fU = false;
                this.f6112on = c1198vrM6384a.m6871cv();
                minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6816w.get(), 1.0f, 5.0f));
                return;
            }
            C0112bc.f754bL = 0.0f;
            int iM6263a = (int) (5.0f * m6263a(itemStack, (Level) clientLevel));
            C1199vs c1199vsM6317b = m6317b();
            this.f6112on = c1199vsM6317b.m6875cw() - m6322a(c1199vsM6317b, c1198vrM6384a);
            int iM3698bg = ((C0806oX.a) NeoForge.EVENT_BUS.post(new C0806oX.a(this, itemStack, this.f6112on))).m3698bg() + iM6263a;
            this.f6113uj = iM3698bg;
            this.f6112on = iM3698bg;
            if (minecraft.options.getCameraType().isFirstPerson()) {
                this.f6080cf.add("fire");
            }
            float f = (f6063il || C0112bc.f744bB > 0.0f) ? 0.5f : 1.0f;
            if (this.f6088ir) {
                C0432hU.m1987a(this.shakeNodeData, f);
            }
            C1113uL c1113uLM6282a = m6282a(itemStack);
            if (this.f6092iv && c1113uLM6282a.m6238cx()) {
                f6058ua = this.f6107ui;
            }
            this.f6252ny += 0.1f;
            this.f6064nZ += this.f6066ob;
            C0487iW.m2195a(minecraft, ThreadLocalRandom.current(), c0623l, c0396gl, this, localPlayer, clientLevel, itemStack);
            this.f6096iy = true;
            if (deferredHolderM6816w != null) {
                if (!c1198vrM6384a.m6868cV()) {
                    this.f6121fT = false;
                }
                this.f6122fU = true;
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    private void m6345b(@NotNull Minecraft minecraft, @NotNull ItemStack itemStack) throws MatchException {
        if (this.f6116iD && minecraft.options.getCameraType().isFirstPerson()) {
            this.f6080cf.add("dryfire");
        }
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6348a = m6348a(itemStack);
        C0434hW c0434hWM6347a = this.f6117O;
        if (c0434hWM6347a == null) {
            c0434hWM6347a = m6347a(this.f6108a);
        }
        if (deferredHolderM6348a == null && c0434hWM6347a == null) {
            return;
        }
        if (deferredHolderM6348a != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolderM6348a.get(), 1.0f, 1.0f));
            C1169vO.m6648c(new C1232wY());
        }
        f6060uc = 40;
        if (c0434hWM6347a != null && this.f6088ir) {
            C0432hU.m1987a(c0434hWM6347a, (f6063il || C0112bc.f744bB > 0.0f) ? 0.5f : 1.0f);
        }
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.uP$1, reason: invalid class name */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/uP$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: y */
        static final /* synthetic */ int[] f6128y = new int[GunType.values().length];

        static {
            try {
                f6128y[GunType.PISTOL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6128y[GunType.SMG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6128y[GunType.RIFLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6128y[GunType.CARBINE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6128y[GunType.SHOTGUN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6128y[GunType.MG.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f6128y[GunType.LMG.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f6128y[GunType.AT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f6128y[GunType.ROCKET.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f6128y[GunType.FLAMETHROWER.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Nullable
    /* JADX INFO: renamed from: a */
    private static DeferredHolder<SoundEvent, SoundEvent> m6346a(@Nullable GunType gunType) throws MatchException {
        if (gunType == null) {
            return null;
        }
        switch (AnonymousClass1.f6128y[gunType.ordinal()]) {
            case 1:
                return C1312xz.f8296vF;
            case 2:
                return C1312xz.f8298vH;
            case 3:
                return C1312xz.f8299vI;
            case 4:
                return C1312xz.f8300vJ;
            case 5:
                return C1312xz.f8301vK;
            case 6:
                return C1312xz.f8302vL;
            case C0994s.f5462C /* 7 */:
                return C1312xz.f8303vM;
            case 8:
                return C1312xz.f8304vN;
            case 9:
            case 10:
                return null;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Nullable
    /* JADX INFO: renamed from: a */
    private static C0434hW m6347a(@Nullable GunType gunType) throws MatchException {
        if (gunType == null) {
            return null;
        }
        switch (AnonymousClass1.f6128y[gunType.ordinal()]) {
            case 1:
            case 2:
            case 4:
                return C0435hX.f2760j;
            case 3:
            case 5:
                return C0435hX.f2761k;
            case 6:
            case C0994s.f5462C /* 7 */:
            case 8:
                return C0435hX.f2762l;
            case 9:
            case 10:
                return null;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public DeferredHolder<SoundEvent, SoundEvent> m6348a(@NotNull ItemStack itemStack) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6814v = m6384a(itemStack).m6814v();
        return deferredHolderM6814v != null ? deferredHolderM6814v : m6346a(this.f6108a);
    }

    /* JADX INFO: renamed from: a */
    public ItemStack m6349a(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        if (level.isClientSide()) {
            return itemStack;
        }
        m6266b(itemStack, m6265c(itemStack) - m6350cn());
        Vec3 eyePosition = livingEntity.getEyePosition();
        int id = livingEntity.getId();
        C1287xa c1287xa = new C1287xa(itemStack, eyePosition, id, m6265c(itemStack) <= 0);
        for (ServerPlayer serverPlayer : level.players()) {
            if (serverPlayer.getId() != id) {
                C1169vO.m6643a(c1287xa, serverPlayer);
            }
        }
        NeoForge.EVENT_BUS.post(new C0806oX.b(this, itemStack, livingEntity));
        m6264a(itemStack, level, m6263a(itemStack, level) + 0.005f);
        return itemStack;
    }

    /* JADX INFO: renamed from: cn */
    public int m6350cn() {
        return this.f6119ul;
    }

    @NotNull
    /* JADX INFO: renamed from: g */
    public C1117uP m6351g(int i) {
        this.f6119ul = i;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public C1117uP m6352c(float f) {
        this.f6066ob = f;
        return this;
    }

    /* JADX INFO: renamed from: G */
    public float m6353G(float f) {
        return ((C1270xJ.m7170f(this.f6064nZ, this.f6065oa, f) % 360.0f) + 360.0f) % 360.0f;
    }

    /* JADX INFO: renamed from: dD */
    public void m6354dD() {
        this.f6064nZ = 0.0f;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m6355a(@NotNull C1198vr c1198vr, @NotNull Minecraft minecraft, @NotNull ClientLevel clientLevel, @NotNull Vec3 vec3, float f) {
        if (this.f6120iE) {
            Vec3 vec3Add = Vec3.ZERO.add(1.0d, 0.0d, 1.0d).yRot(((-f) * 0.017453292f) - 1.5707964f).add(vec3);
            BlockHitResult blockHitResultClip = clientLevel.clip(new ClipContext(vec3Add, vec3Add.add(0.0d, -16.0d, 0.0d), ClipContext.Block.VISUAL, ClipContext.Fluid.ANY, CollisionContext.empty()));
            Vec3 location = blockHitResultClip.getLocation();
            BlockPos blockPos = blockHitResultClip.getBlockPos();
            BlockState blockState = clientLevel.getBlockState(blockPos);
            DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6850a = c1198vr.m6850a(clientLevel, blockPos, blockState, blockState.getSoundType(clientLevel, blockPos, (Entity) null));
            if (deferredHolderM6850a == null) {
                return;
            }
            minecraft.getSoundManager().playDelayed(new SimpleSoundInstance((SoundEvent) deferredHolderM6850a.get(), SoundSource.PLAYERS, 1.0f, 0.9f + (0.1f * ThreadLocalRandom.current().nextInt(2)), RandomSource.create(), location.x, location.y, location.z), (int) (3.0d * location.distanceTo(vec3)));
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6356a(@NotNull Vector3f vector3f, boolean z) {
        this.f6104iC = true;
        this.f6106o = vector3f;
        this.f6103iB = z;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public SoundEvent m6357a(@NotNull ItemStack itemStack) {
        return m6358a(itemStack, m6265c(itemStack));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public SoundEvent m6358a(@NotNull ItemStack itemStack, int i) {
        C1198vr c1198vrM6384a = m6384a(itemStack);
        DeferredHolder<SoundEvent, SoundEvent> deferredHolderM6810t = i <= 0 ? c1198vrM6384a.m6810t() : c1198vrM6384a.m6808s();
        if (deferredHolderM6810t != null) {
            return (SoundEvent) deferredHolderM6810t.get();
        }
        return null;
    }

    /* JADX INFO: renamed from: bB */
    public float m6359bB() {
        return this.f6105oe;
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public C1117uP m6360d(float f) {
        this.f6105oe = f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6361a(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        if (m6275f(itemStack)) {
            if (m6277a(itemStack, level) > 5) {
                return false;
            }
            m6273g(itemStack);
            m6343i(itemStack);
        }
        if (m6267e(itemStack) && livingEntity.isAlive() && livingEntity.getHealth() > 0.0f) {
            ItemStack itemStackM6349a = m6349a(itemStack, level, livingEntity);
            if (livingEntity instanceof Player) {
                Player player = (Player) livingEntity;
                player.getInventory().setItem(player.getInventory().selected, itemStackM6349a);
            } else {
                livingEntity.setItemInHand(InteractionHand.MAIN_HAND, itemStackM6349a);
            }
            C1113uL c1113uLM6282a = m6282a(itemStack);
            if (this.f6092iv && c1113uLM6282a.m6238cx()) {
                m6280e(itemStackM6349a, 1);
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m6362a(@NotNull AbstractC0184c<?> abstractC0184c, @NotNull Level level, @NotNull Player player, @NotNull ItemStack itemStack) {
        EntityType<? extends InterfaceC0695mS> entityType;
        C1199vs c1199vsM6315a = m6315a(itemStack);
        Supplier<EntityType<? extends InterfaceC0695mS>> supplierM6876b = c1199vsM6315a.m6876b();
        if (supplierM6876b == null) {
            return;
        }
        AbstractC0183b abstractC0183bM1153a = abstractC0184c.m1153a(player);
        if (abstractC0183bM1153a.m1110dv() || C0875pn.m4488a(player, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1153a) || (entityType = supplierM6876b.get()) == null) {
            return;
        }
        int iM6878cx = c1199vsM6315a.m6878cx();
        for (int i = 0; i < iM6878cx; i++) {
            InterfaceC0695mS interfaceC0695mSCreate = entityType.create(level);
            if (interfaceC0695mSCreate != null) {
                interfaceC0695mSCreate.mo3118a(player, 3.0f, itemStack.copy(), 0.0f, 0.0f);
                level.addFreshEntity(interfaceC0695mSCreate);
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public C1117uP m6363b(@NotNull String str) {
        this.f6118dx = str;
        return this;
    }

    /* JADX INFO: renamed from: cE */
    public boolean m6364cE() {
        return this.f6090it;
    }

    /* JADX INFO: renamed from: a */
    public C1199vs[] m6365a() {
        return this.f6094a;
    }

    /* JADX INFO: renamed from: cF */
    public boolean m6366cF() {
        return this.f6089is;
    }

    /* JADX INFO: renamed from: co */
    public int m6367co() {
        return this.f6087ug;
    }

    @NotNull
    /* JADX INFO: renamed from: S */
    public ResourceLocation m6368S() {
        return this.f6083gi;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1189vi m6369a() {
        C1189vi c1189viM6765a = C1189vi.m6765a(this.f6083gi);
        return c1189viM6765a != null ? c1189viM6765a : C1189vi.f6464d;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6370a(@NotNull C1191vk c1191vk) {
        this.f6084a = c1191vk;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1191vk m6371a() {
        return this.f6084a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6372a(@NotNull C1193vm c1193vm) {
        this.f6085a = c1193vm;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1193vm m6373a() {
        return this.f6085a;
    }

    /* JADX INFO: renamed from: cp */
    public int m6374cp() {
        return this.f6098uh;
    }

    /* JADX INFO: renamed from: bC */
    public float m6375bC() {
        return this.f6099od;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public Vector3f m6376a() {
        return this.f6106o;
    }

    /* JADX INFO: renamed from: cG */
    public boolean m6377cG() {
        return this.f6104iC;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6378a(@NotNull Vector3f vector3f) {
        return m6356a(vector3f, false);
    }

    /* JADX INFO: renamed from: cH */
    public boolean m6379cH() {
        return this.f6103iB;
    }

    /* JADX INFO: renamed from: cI */
    public boolean m6380cI() {
        return this.f6102iA;
    }

    public boolean shouldCauseReequipAnimation(@NotNull ItemStack itemStack, @NotNull ItemStack itemStack2, boolean z) {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @OnlyIn(Dist.CLIENT)
    @NotNull
    public Component getName(ItemStack itemStack) {
        Component name = super.getName(itemStack);
        if (m6261d(itemStack)) {
            name = name.copy().append(" ").append(f6043jS);
        }
        C1118uQ c1118uQM6283a = m6283a(itemStack);
        if (c1118uQM6283a != C1118uQ.f6135a && !c1118uQM6283a.m6400bP()) {
            name = name.copy().append(Component.translatable("bf.item.gun.mag", new Object[]{c1118uQM6283a.m6401m()}));
        }
        C1113uL c1113uLM6282a = m6282a(itemStack);
        if (c1113uLM6282a != C1113uL.f6024a) {
            name = name.copy().append(Component.translatable("bf.item.gun.barrel", new Object[]{c1113uLM6282a.getDisplayName()}));
        }
        if (m6275f(itemStack)) {
            name = name.copy().append(" ").append(f6044jT);
        }
        return name;
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        if (Minecraft.getInstance().options.advancedItemTooltips) {
            C1113uL c1113uLM6282a = m6282a(itemStack);
            C1118uQ c1118uQM6283a = m6283a(itemStack);
            int iM6402cq = c1118uQM6283a.m6402cq();
            int iM6403cr = c1118uQM6283a.m6403cr();
            int iM6268d = m6268d(itemStack);
            C1199vs c1199vsM6315a = m6315a(itemStack);
            int iM6875cw = c1199vsM6315a.m6875cw();
            C1189vi c1189viM6369a = m6369a();
            list.add(Component.empty());
            list.add(Component.literal("Damage Config Entries:"));
            list.add(Component.empty());
            for (Map.Entry<Float, FloatFloatPair> entry : c1189viM6369a.m6770s().entrySet()) {
                FloatFloatPair value = entry.getValue();
                list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Distance >= " + String.valueOf(ChatFormatting.DARK_GRAY) + String.valueOf(entry.getKey()) + String.valueOf(ChatFormatting.GRAY) + " Blocks"));
                list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Body: " + String.valueOf(ChatFormatting.DARK_GRAY) + value.leftFloat()));
                list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Headshot: " + String.valueOf(ChatFormatting.DARK_GRAY) + value.rightFloat()));
                list.add(Component.empty());
            }
            list.add(Component.literal("Mag Type"));
            list.add(Component.literal(String.valueOf(m6265c(itemStack)) + String.valueOf(ChatFormatting.GRAY) + " / " + String.valueOf(ChatFormatting.WHITE) + iM6402cq + String.valueOf(ChatFormatting.GRAY) + " - " + String.valueOf(ChatFormatting.WHITE) + iM6268d));
            list.add(c1118uQM6283a.m6401m().copy().withStyle(ChatFormatting.GRAY));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Capacity: " + String.valueOf(ChatFormatting.DARK_GRAY) + iM6402cq));
            list.add(Component.empty());
            list.add(Component.literal("Barrel Type"));
            list.add(c1113uLM6282a.getDisplayName().copy().withStyle(ChatFormatting.GRAY));
            list.add(Component.empty());
            list.add(Component.literal("Other Info"));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Max Hit Dist: " + String.valueOf(ChatFormatting.DARK_GRAY) + this.f6087ug + " Blocks"));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Fire-rate: " + String.valueOf(ChatFormatting.DARK_GRAY) + iM6875cw + " (" + (iM6875cw / 2) + " ticks)"));
            C1198vr c1198vrM6384a = m6384a(itemStack);
            if (c1198vrM6384a.m6816w() != null) {
                int iM6871cv = c1198vrM6384a.m6871cv();
                boolean zM6868cV = c1198vrM6384a.m6868cV();
                int iM6322a = zM6868cV ? iM6875cw : (iM6871cv + iM6875cw) - m6322a(c1199vsM6315a, c1198vrM6384a);
                list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Pre-fire delay: " + String.valueOf(ChatFormatting.DARK_GRAY) + iM6871cv + " (" + (iM6871cv / 2) + " ticks)" + (zM6868cV ? " (once)" : "")));
                if (iM6322a != iM6875cw) {
                    list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Effective fire-rate: " + String.valueOf(ChatFormatting.DARK_GRAY) + iM6322a + " (" + (iM6322a / 2) + " ticks)"));
                }
            }
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Max Ammo Count: " + String.valueOf(ChatFormatting.DARK_GRAY) + iM6403cr));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Clip Capacity: " + String.valueOf(ChatFormatting.DARK_GRAY) + iM6402cq));
            list.add(Component.literal(String.valueOf(ChatFormatting.GRAY) + "Weight: " + String.valueOf(ChatFormatting.DARK_GRAY) + this.f6111of));
            list.add(Component.empty());
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @NotNull
    /* JADX INFO: renamed from: y */
    public Vec3 mo6195y() {
        return f6049ar;
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    /* JADX INFO: renamed from: a */
    protected void mo6381a(@NotNull ItemStack itemStack, @NotNull Entity entity) {
        super.mo6381a(itemStack, entity);
        C1118uQ c1118uQM6283a = m6283a(itemStack);
        int iM6402cq = c1118uQM6283a.m6402cq();
        m6269c(itemStack, c1118uQM6283a.m6403cr());
        m6272d(itemStack, c1118uQM6283a.m6403cr());
        m6266b(itemStack, iM6402cq);
        ServerLevel serverLevelLevel = entity.level();
        if (serverLevelLevel instanceof ServerLevel) {
            GeoItem.getOrAssignId(itemStack, serverLevelLevel);
        }
        m6273g(itemStack);
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    public void inventoryTick(ItemStack itemStack, @NotNull Level level, @NotNull Entity entity, int i, boolean z) {
        super.inventoryTick(itemStack, level, entity, i, z);
        if (entity instanceof Player) {
            Player player = (Player) entity;
            if (z) {
                player.swinging = false;
            }
        }
        if (m6278g(itemStack)) {
            m6279h(itemStack);
        }
        if (!level.isClientSide() && entity.isInWaterOrRain()) {
            float fM6263a = m6263a(itemStack, level);
            if (fM6263a > 0.0f) {
                m6264a(itemStack, level, Math.max(0.0f, fM6263a - ((entity.isInWater() ? 0.005f : f6051nT) - f6050nS)));
            }
        }
        if (level.isClientSide()) {
            return;
        }
        long jM6276b = m6276b(itemStack);
        if (jM6276b != 0) {
            if (!z) {
                m6273g(itemStack);
            } else if (level.getGameTime() >= jM6276b) {
                m6273g(itemStack);
                m6343i(itemStack);
            }
        }
    }

    /* JADX INFO: renamed from: H */
    public float m6382H(float f) {
        return C1270xJ.m7170f(this.f6112on, this.f6113uj, f);
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        return new InteractionResultHolder<>(InteractionResult.FAIL, player.getItemInHand(interactionHand));
    }

    public boolean onDroppedByPlayer(@NotNull ItemStack itemStack, @NotNull Player player) {
        m6273g(itemStack);
        return super.onDroppedByPlayer(itemStack, player);
    }

    @Override // com.boehmod.blockfront.InterfaceC1072tX
    /* JADX INFO: renamed from: b */
    public boolean mo5940b(@NotNull Player player, @NotNull ItemStack itemStack) {
        return !player.isCreative();
    }

    @Override // com.boehmod.blockfront.InterfaceC1072tX
    /* JADX INFO: renamed from: a */
    public float mo5941a(@NotNull ItemStack itemStack) {
        return this.f6111of;
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

    @Override // com.boehmod.blockfront.InterfaceC1073tY
    /* JADX INFO: renamed from: a */
    public void mo5942a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull C0394gj c0394gj, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
        boolean zAR;
        ItemStack mainHandItem = abstractClientPlayer.getMainHandItem();
        if ((mainHandItem.getItem() instanceof C1117uP) && m6275f(mainHandItem)) {
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
            zAR = c0394gj.m1128aR();
            abstractClientPlayer.swinging = false;
            abstractClientPlayer.attackAnim = 0.0f;
        } else {
            zAR = f6063il || f6060uc > 0;
        }
        playerModel.rightArm.xRot = zAR ? (-1.55f) + playerModel.head.xRot : -0.5f;
        playerModel.rightArm.yRot = zAR ? playerModel.head.yRot : -1.2f;
        playerModel.rightArm.zRot = zAR ? 0.0f : -0.4f;
        float f5 = zAR ? -0.4f : 0.0f;
        if (m6364cE()) {
            playerModel.leftArm.xRot = zAR ? (-1.6f) + playerModel.head.xRot : -0.2f;
            playerModel.leftArm.yRot = zAR ? 0.9f + playerModel.head.yRot : -0.5f;
            playerModel.leftArm.zRot = zAR ? playerModel.head.zRot : -0.4f;
            playerModel.head.zRot = f5;
        } else if (!zAR || !m6310cB()) {
            playerModel.leftArm.xRot = zAR ? (-1.6f) + playerModel.head.xRot : -0.4f;
            playerModel.leftArm.yRot = zAR ? 0.9f + playerModel.head.yRot : -0.5f;
            playerModel.leftArm.zRot = zAR ? playerModel.head.zRot : 0.6f;
            playerModel.head.zRot = f5;
        }
        if (Minecraft.useFancyGraphics() && zAR) {
            float fM7170f = 1.5f * C1270xJ.m7170f(c0394gj.f1414pg, c0394gj.f1415ph, f2);
            playerModel.rightArm.z += fM7170f;
            playerModel.rightSleeve.z += fM7170f;
            if (!m6310cB()) {
                playerModel.leftArm.z += fM7170f;
                playerModel.leftSleeve.z += fM7170f;
            }
            float fSin5 = Mth.sin(f) * fM7170f;
            float fSin6 = Mth.sin(f * 1.2f) * fM7170f;
            float f6 = 0.01f * fSin5;
            float f7 = 0.01f * fSin6;
            playerModel.rightArm.xRot += f6;
            playerModel.rightSleeve.xRot += f6;
            playerModel.rightArm.zRot += f7;
            playerModel.rightSleeve.zRot += f7;
            if (!m6310cB()) {
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
        controllerRegistrar.add(new AnimationController(this, f6045dw, 0, this::mo6383a).setSoundKeyframeHandler(this::mo6387a).setCustomInstructionKeyframeHandler(this::mo6388b));
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f6079d;
    }

    @Override // software.bernie.geckolib.animatable.GeoAnimatable
    public boolean shouldPlayAnimsWhileGamePaused() {
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected PlayState mo6383a(@NotNull AnimationState<C1117uP> animationState) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) {
            return PlayState.STOP;
        }
        ItemDisplayContext itemDisplayContext = (ItemDisplayContext) animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE);
        if (itemDisplayContext == null || !itemDisplayContext.firstPerson()) {
            return PlayState.STOP;
        }
        String strAA = ((C1117uP) animationState.getAnimatable()).m6574aA();
        ItemStack itemStack = (ItemStack) animationState.getData(DataTickets.ITEMSTACK);
        if (itemStack == null) {
            return PlayState.STOP;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f6127iH && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        boolean z = this.f6115a != null && this.f6115a.mo6798cT() && m6265c(itemStack) <= 0;
        boolean zDt = c0396gl.m1885a(minecraft).m1104dt();
        String str = "animation." + strAA + ".";
        AnimationController<T> controller = animationState.getController();
        if (!this.f6080cf.isEmpty()) {
            controller.forceAnimationReset();
            RawAnimation rawAnimationBegin = RawAnimation.begin();
            boolean z2 = false;
            for (String str2 : this.f6080cf) {
                if (!str2.contains("fire") || str2.equals("dryfire") || !z) {
                    rawAnimationBegin.then(str + str2, Animation.LoopType.PLAY_ONCE);
                    if (str2.contains("reload")) {
                        z2 = true;
                    }
                }
            }
            this.f6080cf.clear();
            String str3 = (!z2 && z) ? "idle_empty" : "idle";
            rawAnimationBegin.thenPlayAndHold(str + str3);
            animationState.resetCurrentAnimation();
            animationState.setAnimation(rawAnimationBegin);
        } else if (controller.getAnimationState() == AnimationController.State.STOPPED || zDt) {
            animationState.resetCurrentAnimation();
            animationState.setAnimation(RawAnimation.begin().thenPlayAndHold(str + (z ? "idle_empty" : "idle")));
        }
        return PlayState.CONTINUE;
    }

    /* JADX INFO: renamed from: a */
    public C1198vr m6384a(@NotNull ItemStack itemStack) {
        C1198vr c1198vrM6240a = m6282a(itemStack).m6240a();
        if (c1198vrM6240a != null) {
            return c1198vrM6240a;
        }
        return this.f6097a;
    }

    /* JADX INFO: renamed from: a */
    public C1117uP m6385a(@Nullable DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        this.f6100iz = true;
        this.f6101aW = deferredHolder;
        return this;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: j */
    public void m6386j(@NotNull ItemStack itemStack) {
        if (this.f6100iz && !C0486iV.m2182aa()) {
            m6341q("equip");
        }
        m6341q(this.f6115a != null && this.f6115a.mo6798cT() && m6265c(itemStack) <= 0 ? "idle_empty" : "idle");
        if (this.f6101aW != null) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) this.f6101aW.get(), 0.9f + (0.2f * ThreadLocalRandom.current().nextFloat()), 1.0f));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    protected void mo6387a(@NotNull SoundKeyframeEvent<C1117uP> soundKeyframeEvent) {
        DeferredHolder<SoundEvent, SoundEvent> deferredHolder = f6048af.get(soundKeyframeEvent.getKeyframeData().getSound());
        if (deferredHolder != null) {
            Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI((SoundEvent) deferredHolder.get(), 0.95f + (0.1f * ThreadLocalRandom.current().nextFloat()), 0.5f));
        }
    }

    @Override // com.boehmod.blockfront.AbstractC1140um
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    protected void mo6388b(@NotNull CustomInstructionKeyframeEvent<C1117uP> customInstructionKeyframeEvent) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        ClientLevel clientLevel = minecraft.level;
        if (localPlayer == null || clientLevel == null) {
            return;
        }
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        String instructions = customInstructionKeyframeEvent.getKeyframeData().getInstructions();
        Vec3 eyePosition = localPlayer.getEyePosition();
        float yRot = localPlayer.getYRot();
        C1198vr c1198vrM6384a = m6384a(localPlayer.getMainHandItem());
        switch (instructions) {
            case "eject_bullet;":
                C0456hs.m2095a(threadLocalRandomCurrent, this.f6118dx, false);
                m6355a(c1198vrM6384a, minecraft, clientLevel, eyePosition, yRot);
                break;
            case "eject_bullet_flipped;":
                C0456hs.m2095a(threadLocalRandomCurrent, this.f6118dx, true);
                m6355a(c1198vrM6384a, minecraft, clientLevel, eyePosition, yRot - 90.0f);
                break;
            case "eject_bullet_audio;":
                m6355a(c1198vrM6384a, minecraft, clientLevel, eyePosition, yRot);
                break;
            case "eject_bullet_audio_flipped;":
                m6355a(c1198vrM6384a, minecraft, clientLevel, eyePosition, yRot - 90.0f);
                break;
            case "disable_dynamic_bullets;":
                this.f6102iA = true;
                break;
            case "reset_mag_rotation;":
                m6354dD();
                break;
            default:
                if (instructions.startsWith("shake(") && instructions.endsWith(");")) {
                    C0432hU.m1984f(instructions);
                    break;
                }
                break;
        }
    }

    /* JADX INFO: renamed from: cJ */
    public boolean m6389cJ() {
        return this.f6126iG;
    }

    /* JADX INFO: renamed from: cK */
    public boolean m6390cK() {
        return this.f6093iw;
    }

    @NotNull
    /* JADX INFO: renamed from: aB */
    public String m6391aB() {
        return this.f6124dy;
    }

    @NotNull
    public C0434hW getShakeNodeData() {
        return this.shakeNodeData;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public C0434hW m6392b() {
        return this.f6117O;
    }

    /* JADX INFO: renamed from: bD */
    public float m6393bD() {
        return this.f6067oc;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public EnumC1122uU m6394a() {
        return this.f6068a;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1069tU m6395a() {
        return this.f6086n;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6396a(@NotNull C1069tU c1069tU) {
        this.f6086n = c1069tU;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C1117uP m6397a(@NotNull GunType gunType) {
        this.f6108a = gunType;
        return this;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public GunType m6398a() {
        return this.f6108a;
    }

    /* JADX INFO: renamed from: b */
    public int m6399b(@NotNull RandomSource randomSource) {
        int i = this.f6069ud / 2;
        return i + randomSource.nextInt(this.f6069ud - i);
    }
}
