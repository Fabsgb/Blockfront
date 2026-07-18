package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import com.boehmod.bflib.cloud.common.item.pattern.SkinPatternUtils;
import com.boehmod.blockfront.AbstractC1062tO;
import com.mojang.blaze3d.shaders.AbstractUniform;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.floats.Float2ObjectMap;
import it.unimi.dsi.fastutil.floats.Float2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector4f;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.object.GeoCube;
import software.bernie.geckolib.cache.object.GeoQuad;
import software.bernie.geckolib.cache.object.GeoVertex;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: renamed from: com.boehmod.blockfront.gW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gW.class */
public class C0380gW<T extends AbstractC1062tO<T>> extends GeoItemRenderer<T> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final ResourceLocation[] f2467a;

    /* JADX INFO: renamed from: cN */
    @NotNull
    private static final ResourceLocation f2468cN;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final ResourceLocation[] f2469b;

    /* JADX INFO: renamed from: cO */
    @NotNull
    private static final ResourceLocation f2470cO;

    /* JADX INFO: renamed from: je */
    private static final int f2471je = 40;

    /* JADX INFO: renamed from: ac */
    private static final String f2472ac = "left";

    /* JADX INFO: renamed from: ad */
    private static final String f2473ad = "right";

    /* JADX INFO: renamed from: ae */
    private static final String f2474ae = "aimpos";

    /* JADX INFO: renamed from: fy */
    private static final float f2475fy = 0.0625f;

    /* JADX INFO: renamed from: fz */
    private static final float f2476fz = 0.03125f;

    /* JADX INFO: renamed from: fA */
    private static final float f2477fA = 0.25f;

    /* JADX INFO: renamed from: af */
    private static final String f2478af = "aimpos_mag_type_";

    /* JADX INFO: renamed from: ag */
    @Nonnull
    private static final String f2479ag = "PatternOffset";

    /* JADX INFO: renamed from: ah */
    @Nonnull
    private static final String f2480ah = "HasPattern";

    /* JADX INFO: renamed from: ai */
    @Nonnull
    private static final String f2481ai = "IsGui";

    /* JADX INFO: renamed from: aj */
    @Nonnull
    private static final String f2482aj = "Silhouette";

    /* JADX INFO: renamed from: jf */
    public static int f2483jf;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final Vector3f f2484f;

    /* JADX INFO: renamed from: i */
    @NotNull
    private final Map<String, Vector3f> f2485i;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final Quaternionf f2486e;

    /* JADX INFO: renamed from: c */
    @NotNull
    private final Matrix4f f2487c;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final Vector3f f2488g;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Vector4f f2489a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private GuiGraphics f2490b;

    /* JADX INFO: renamed from: fB */
    private float f2491fB;

    /* JADX INFO: renamed from: fC */
    private float f2492fC;

    /* JADX INFO: renamed from: fD */
    private float f2493fD;

    /* JADX INFO: renamed from: fE */
    private float f2494fE;

    /* JADX INFO: renamed from: fF */
    private float f2495fF;

    /* JADX INFO: renamed from: fG */
    private float f2496fG;

    /* JADX INFO: renamed from: L */
    @NotNull
    public final List<AbstractC0447hk<T>> f2497L;

    /* JADX INFO: renamed from: a */
    @Nullable
    private GeoBone f2498a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private GeoBone f2499b;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final Vector3f f2500h;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ObjectArrayList<GeoBone> f2501a;

    /* JADX INFO: renamed from: d */
    @Nullable
    private ShaderInstance f2502d;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractUniform f2503a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private AbstractUniform f2504b;

    /* JADX INFO: renamed from: c */
    @Nullable
    private AbstractUniform f2505c;

    /* JADX INFO: renamed from: d */
    @Nullable
    private AbstractUniform f2506d;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Float2ObjectMap<ResourceLocation> f2507a;

    /* JADX INFO: renamed from: j */
    @NotNull
    private final Map<String, ResourceLocation> f2508j;

    /* JADX INFO: renamed from: k */
    @NotNull
    private final Map<String, ResourceLocation> f2509k;

    /* JADX INFO: renamed from: cP */
    @Nullable
    private ResourceLocation f2510cP;

    /* JADX INFO: renamed from: c */
    @Nullable
    private Minecraft f2511c;

    /* JADX INFO: renamed from: jg */
    private int f2512jg;

    /* JADX INFO: renamed from: cw */
    static final /* synthetic */ boolean f2513cw;

    static {
        f2513cw = !C0380gW.class.desiredAssertionStatus();
        f2467a = new ResourceLocation[]{C0564jv.m2555d("textures/models/items/blood0.png"), C0564jv.m2555d("textures/models/items/blood1.png"), C0564jv.m2555d("textures/models/items/blood2.png"), C0564jv.m2555d("textures/models/items/blood3.png")};
        f2468cN = f2467a[0];
        f2469b = new ResourceLocation[]{C0564jv.m2555d("textures/models/items/mud0.png"), C0564jv.m2555d("textures/models/items/mud1.png"), C0564jv.m2555d("textures/models/items/mud2.png"), C0564jv.m2555d("textures/models/items/mud3.png")};
        f2470cO = f2469b[0];
        f2483jf = 0;
    }

    public C0380gW() {
        this(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), new C0258eG());
    }

    public C0380gW(@NotNull BlockEntityRenderDispatcher blockEntityRenderDispatcher, @NotNull EntityModelSet entityModelSet, @NotNull C0258eG<T> c0258eG) {
        super(blockEntityRenderDispatcher, entityModelSet, c0258eG);
        this.f2484f = new Vector3f();
        this.f2485i = new Object2ObjectOpenHashMap();
        this.f2486e = new Quaternionf();
        this.f2487c = new Matrix4f();
        this.f2488g = new Vector3f();
        this.f2489a = new Vector4f();
        this.f2490b = null;
        this.f2491fB = 0.0f;
        this.f2492fC = 0.0f;
        this.f2493fD = 0.0f;
        this.f2494fE = 0.0f;
        this.f2495fF = 0.0f;
        this.f2496fG = 0.0f;
        this.f2497L = new ObjectArrayList();
        this.f2498a = null;
        this.f2499b = null;
        this.f2500h = new Vector3f();
        this.f2501a = new ObjectArrayList<>();
        this.f2502d = null;
        this.f2507a = new Float2ObjectOpenHashMap();
        this.f2508j = new Object2ObjectOpenHashMap();
        this.f2509k = new Object2ObjectOpenHashMap();
        this.f2512jg = -1;
        this.f2497L.add(new C0383gZ(this));
        this.f2497L.add(new C0437ha(this));
        this.f2497L.add(new C0446hj(this));
        this.f2497L.add(new C0440hd(this));
        this.f2497L.add(new C0445hi(this));
        this.f2497L.add(new C0444hh(this));
        this.f2497L.add(new C0439hc(this));
        this.f2497L.add(new C0448hl(this));
        this.f2497L.add(new C0443hg(this));
        this.f2497L.add(new C0442hf(this));
        this.f2497L.add(new C0438hb(this));
        this.f2497L.add(new C0441he(this));
    }

    /* JADX INFO: renamed from: a */
    private void m1809a(@NotNull PoseStack poseStack, float f, boolean z, @NotNull Vector3f vector3f) {
        float fMin = Math.min(C1290xm.m7843e(C0053aX.f366bO, C0053aX.f367bP, f), 1.0f);
        float f2 = 1.0f - fMin;
        poseStack.translate(vector3f.x * fMin, vector3f.y * fMin, vector3f.z * fMin);
        poseStack.translate(0.05f * f2, (-0.05f) * f2, 0.0f);
        this.f2486e.identity().rotateZ((float) Math.toRadians((z ? 10.0f : -10.0f) * f2 * (1.0f - C1290xm.m7843e(C0050aU.f330bv, C0050aU.f331bw, f))));
        poseStack.mulPose(this.f2486e);
        poseStack.translate(0.0f, 0.0f, 0.02f * C1290xm.m7843e(C1144ur.f5992mY, C1144ur.f5993mZ, f));
    }

    /* JADX INFO: renamed from: a */
    private boolean m1810a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull C0326fV c0326fV, @NotNull T t, float f, @NotNull MutableInt mutableInt) {
        if (this.renderPerspective.firstPerson()) {
            float fM7843e = C1290xm.m7843e(C0111bc.f679cl, C0111bc.f680cm, f);
            float fM7843e2 = C1290xm.m7843e(C0111bc.f677cj, C0111bc.f678ck, f);
            poseStack.translate(0.0f, 0.0f, fM7843e);
            this.f2486e.identity().rotateX((float) Math.toRadians(fM7843e2));
            poseStack.mulPose(this.f2486e);
        }
        return m1811a(minecraft, poseStack, c0326fV, t, mutableInt);
    }

    /* JADX INFO: renamed from: a */
    private boolean m1811a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull C0326fV c0326fV, @NotNull T t, @NotNull MutableInt mutableInt) {
        C0324fT c0324fTM1675a = c0326fV.m1675a(minecraft);
        C1108uH c1108uHM6329a = t instanceof C1144ur ? ((C1144ur) t).m6329a(this.currentItemStack) : null;
        Iterator<AbstractC0447hk<T>> it = this.f2497L.iterator();
        while (it.hasNext()) {
            if (it.next().mo1841a(minecraft, poseStack, this.currentItemStack, mutableInt, c1108uHM6329a, this.renderPerspective, c0324fTM1675a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private void m1812a(@NotNull Minecraft minecraft, @NotNull BakedGeoModel bakedGeoModel) {
        if (this.f2512jg == f2483jf) {
            return;
        }
        this.f2512jg = f2483jf;
        bakedGeoModel.getBone(f2472ac).ifPresent(geoBone -> {
            this.f2498a = geoBone;
        });
        bakedGeoModel.getBone(f2473ad).ifPresent(geoBone2 -> {
            this.f2499b = geoBone2;
        });
        Vector3f vector3f = minecraft.getItemRenderer().getModel(this.currentItemStack, minecraft.level, (LivingEntity) null, 0).getTransforms().getTransform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).translation;
        GeoBone geoBoneOrElse = bakedGeoModel.getBone(f2474ae).orElse(null);
        if (geoBoneOrElse != null) {
            m1813a(geoBoneOrElse, vector3f, this.f2484f);
        } else {
            this.f2484f.set(0.0f, 0.0f, 0.0f);
        }
        this.f2485i.clear();
        m1814a(bakedGeoModel.topLevelBones(), vector3f);
    }

    /* JADX INFO: renamed from: a */
    private void m1813a(@NotNull GeoBone geoBone, @NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        vector3f2.set((-vector3f.x) - 0.559f, (-vector3f.y) + 0.507f, (-vector3f.z) + 0.66f).add((-geoBone.getPivotX()) * f2475fy, (-geoBone.getPivotY()) * f2475fy, (-geoBone.getPivotZ()) * f2475fy);
    }

    /* JADX INFO: renamed from: a */
    private void m1814a(@NotNull List<GeoBone> list, @NotNull Vector3f vector3f) {
        for (GeoBone geoBone : list) {
            String name = geoBone.getName();
            if (name.startsWith(f2478af)) {
                String strSubstring = name.substring(f2478af.length());
                Vector3f vector3f2 = new Vector3f();
                m1813a(geoBone, vector3f, vector3f2);
                this.f2485i.put(strSubstring, vector3f2);
            }
            List<GeoBone> childBones = geoBone.getChildBones();
            if (!childBones.isEmpty()) {
                m1814a(childBones, vector3f);
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private Vector3f m1815a(@NotNull T t) {
        Vector3f vector3f;
        return (this.f2485i.isEmpty() || !(t instanceof C1144ur) || this.currentItemStack == null || (vector3f = this.f2485i.get(C1144ur.m6293b(this.currentItemStack))) == null) ? this.f2484f : vector3f;
    }

    /* JADX INFO: renamed from: a */
    public void m1816a(@NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull RenderType renderType, @NotNull MultiBufferSource multiBufferSource, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        try {
            super.renderRecursively(poseStack, (AbstractC1062tO) this.animatable, geoBone, renderType, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        } catch (IllegalStateException e) {
            C0562jt.log("Error rendering bone: " + geoBone.getName(), new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1817a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, float f) {
        this.f2491fB += 40.0f;
        int iM7919a = InterfaceC1294xq.m7919a(geoBone);
        if ((iM7919a & 1) != 0) {
            float f2 = this.f2492fC;
            if ((iM7919a & 2) != 0) {
                f2 *= 1.0f - this.f2495fF;
            }
            geoBone.setRotZ(f2);
        }
        Iterator<AbstractC0447hk<T>> it = this.f2497L.iterator();
        while (it.hasNext()) {
            it.next().mo1838a(minecraft, poseStack, geoBone, itemStack, this.renderPerspective, (AbstractC1062tO) this.animatable, this.f2495fF, this.f2496fG, this.f2493fD, f);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1818a(@NotNull Minecraft minecraft, @Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, @Nullable AbstractC0788oG<?, ?> abstractC0788oG, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, boolean z) {
        if (this.f2498a == null && this.f2499b == null) {
            return;
        }
        C0622l c0622lM2667b = C0622l.m2667b();
        if (c0622lM2667b == null || !c0622lM2667b.m2690e()) {
            C0371gN renderer = minecraft.getEntityRenderDispatcher().getRenderer(localPlayer);
            if (renderer instanceof C0371gN) {
                C0371gN c0371gN = renderer;
                boolean z2 = !localPlayer.getMainHandItem().isEmpty();
                boolean z3 = !localPlayer.getOffhandItem().isEmpty();
                if (this.f2498a != null && (!z ? !z2 : !z3)) {
                    m1819a(abstractC0787oF, abstractC0788oG, localPlayer, poseStack, multiBufferSource, i, this.f2498a, c0371gN, z);
                }
                if (this.f2499b != null) {
                    m1819a(abstractC0787oF, abstractC0788oG, localPlayer, poseStack, multiBufferSource, i, this.f2499b, c0371gN, !z);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1819a(@Nullable AbstractC0787oF<?, ?, ?> abstractC0787oF, @Nullable AbstractC0788oG<?, ?> abstractC0788oG, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull GeoBone geoBone, @NotNull C0371gN c0371gN, boolean z) {
        poseStack.pushPose();
        m1820a(poseStack, geoBone);
        C0256eE model = c0371gN.getModel();
        boolean z2 = (model instanceof C0256eE) && model.m1430L();
        m1821a(geoBone, this.f2500h);
        float f = z2 ? f2476fz : f2475fy;
        poseStack.translate(this.f2500h.x - (z ? -f : f), this.f2500h.y - 0.25f, this.f2500h.z);
        this.f2486e.identity().rotateY(3.1415927f);
        poseStack.mulPose(this.f2486e);
        c0371gN.m1773a(abstractC0787oF, abstractC0788oG, (AbstractClientPlayer) localPlayer, poseStack, multiBufferSource, i, z);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    private void m1820a(@NotNull PoseStack poseStack, @NotNull GeoBone geoBone) {
        this.f2501a.clear();
        GeoBone parent = geoBone;
        while (true) {
            GeoBone geoBone2 = parent;
            if (geoBone2 == null) {
                break;
            }
            this.f2501a.add(geoBone2);
            parent = geoBone2.getParent();
        }
        for (int size = this.f2501a.size() - 1; size >= 0; size--) {
            RenderUtil.prepMatrixForBone(poseStack, (GeoBone) this.f2501a.get(size));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1821a(@NotNull GeoBone geoBone, @NotNull Vector3f vector3f) {
        List<GeoCube> cubes = geoBone.getCubes();
        if (cubes.isEmpty()) {
            vector3f.set(geoBone.getPivotX() / 16.0f, geoBone.getPivotY() / 16.0f, geoBone.getPivotZ() / 16.0f);
            return;
        }
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        float fMin3 = Float.MAX_VALUE;
        float fMax = -3.4028235E38f;
        float fMax2 = -3.4028235E38f;
        float fMax3 = -3.4028235E38f;
        Iterator<GeoCube> it = cubes.iterator();
        while (it.hasNext()) {
            for (GeoQuad geoQuad : it.next().quads()) {
                if (geoQuad != null) {
                    for (GeoVertex geoVertex : geoQuad.vertices()) {
                        Vector3f vector3fPosition = geoVertex.position();
                        fMin = Math.min(fMin, vector3fPosition.x);
                        fMin2 = Math.min(fMin2, vector3fPosition.y);
                        fMin3 = Math.min(fMin3, vector3fPosition.z);
                        fMax = Math.max(fMax, vector3fPosition.x);
                        fMax2 = Math.max(fMax2, vector3fPosition.y);
                        fMax3 = Math.max(fMax3, vector3fPosition.z);
                    }
                }
            }
        }
        vector3f.set((fMin + fMax) * 0.5f, (fMin2 + fMax2) * 0.5f, (fMin3 + fMax3) * 0.5f);
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a */
    public void defaultRender(PoseStack poseStack, T t, MultiBufferSource multiBufferSource, @Nullable RenderType renderType, @Nullable VertexConsumer vertexConsumer, float f, float f2, int i) {
        Minecraft minecraft = Minecraft.getInstance();
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2513cw && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0326fV c0326fV = (C0326fV) c0622lM2667b.m2670a();
        MutableInt mutableInt = new MutableInt(i);
        if (m1810a(minecraft, poseStack, c0326fV, t, f2, mutableInt)) {
            return;
        }
        super.defaultRender(poseStack, t, multiBufferSource, renderType, vertexConsumer, f, f2, mutableInt.intValue());
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a */
    public void actuallyRender(PoseStack poseStack, T t, BakedGeoModel bakedGeoModel, @Nullable RenderType renderType, MultiBufferSource multiBufferSource, @Nullable VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2513cw && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        AbstractC0788oG<?, ?> abstractC0788oGM2692a = c0622lM2667b.m2692a();
        boolean zFirstPerson = this.renderPerspective.firstPerson();
        m1812a(minecraft, bakedGeoModel);
        poseStack.pushPose();
        if ((minecraft.screen instanceof C0239do) && this.renderPerspective == ItemDisplayContext.GUI) {
            this.f2486e.identity().rotateZ((float) Math.toRadians(C0239do.f1982dQ));
            poseStack.mulPose(this.f2486e);
            this.f2486e.identity().rotateY((float) Math.toRadians(C0239do.f1983dR));
            poseStack.mulPose(this.f2486e);
        }
        boolean z2 = this.renderPerspective == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND;
        if (zFirstPerson) {
            m1809a(poseStack, f, z2, m1815a((AbstractC1062tO) t));
        }
        if (this.f2490b == null) {
            this.f2490b = new GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource());
        }
        PoseStack poseStackPose = this.f2490b.pose();
        poseStackPose.pushPose();
        poseStackPose.mulPose(poseStack.last().pose());
        float fClamp = Mth.clamp(C1290xm.m7843e(t.f5613mz, t.f5614mA, f), 0.0f, 1.0f);
        this.f2491fB = C0119bk.m366g();
        this.f2494fE = zFirstPerson ? C1144ur.f5994hR ? 0.1f : 0.85f : 1.0f;
        this.f2495fF = C1290xm.m7843e(C0050aU.f330bv, C0050aU.f331bw, f);
        this.f2496fG = 1.0f - this.f2495fF;
        this.f2493fD = zFirstPerson ? Mth.sin(this.f2491fB / 3.0f) * fClamp : 0.0f;
        this.f2492fC = zFirstPerson ? this.f2493fD * ((AbstractC1062tO) this.animatable).m5946bs() : 0.0f;
        boolean zBooleanValue = ((Boolean) this.currentItemStack.getOrDefault(C1228wV.f6980X, false)).booleanValue();
        boolean z3 = !zBooleanValue && ((Boolean) this.currentItemStack.getOrDefault(C1228wV.f6976T, false)).booleanValue();
        if (zBooleanValue) {
            RenderSystem.setShaderTexture(3, f2468cN);
            RenderSystem.setShaderTexture(4, f2470cO);
        } else {
            int iIntValue = C0424hN.f2742w.m1996T() ? ((Integer) this.currentItemStack.getOrDefault(C1228wV.f6973Q, 0)).intValue() : 0;
            int iIntValue2 = ((Integer) this.currentItemStack.getOrDefault(C1228wV.f6974R, 0)).intValue();
            RenderSystem.setShaderTexture(3, f2467a[iIntValue]);
            RenderSystem.setShaderTexture(4, f2469b[iIntValue2]);
        }
        ShaderInstance shaderInstanceM1955a = C0414hD.m1955a();
        if (shaderInstanceM1955a != this.f2502d) {
            this.f2502d = shaderInstanceM1955a;
            if (shaderInstanceM1955a != null) {
                this.f2503a = shaderInstanceM1955a.safeGetUniform(f2480ah);
                this.f2504b = shaderInstanceM1955a.safeGetUniform(f2481ai);
                this.f2505c = shaderInstanceM1955a.safeGetUniform(f2482aj);
                this.f2506d = shaderInstanceM1955a.safeGetUniform(f2479ag);
            } else {
                this.f2503a = null;
                this.f2504b = null;
                this.f2505c = null;
                this.f2506d = null;
            }
        }
        if (shaderInstanceM1955a != null) {
            boolean z4 = C0424hN.f2736q.m1996T() && ((Boolean) this.currentItemStack.getOrDefault(C1228wV.f6961E.get(), false)).booleanValue();
            this.f2504b.set(this.renderPerspective == ItemDisplayContext.GUI ? 1 : 0);
            this.f2505c.set(z4 ? 1 : 0);
            this.f2503a.set(z3 ? 1 : 0);
        }
        if (z3) {
            Point pointDecodeUV = SkinPatternUtils.decodeUV(((Double) this.currentItemStack.getOrDefault(C1228wV.f6975S, Double.valueOf(0.0d))).doubleValue(), ((Integer) this.currentItemStack.getOrDefault(C1228wV.f6977U, 1)).intValue(), ((Integer) this.currentItemStack.getOrDefault(C1228wV.f6978V, 1)).intValue());
            String lowerCase = ((String) this.currentItemStack.getOrDefault(C1228wV.f6979W, "default")).toLowerCase(Locale.ROOT);
            ResourceLocation key = BuiltInRegistries.ITEM.getKey(t);
            RenderSystem.setShaderTexture(5, this.f2508j.computeIfAbsent(lowerCase, str -> {
                return C0564jv.m2555d("textures/item/patterns/" + str + ".png");
            }));
            RenderSystem.setShaderTexture(6, this.f2509k.computeIfAbsent(key.getPath(), str2 -> {
                return C0564jv.m2555d("textures/item/" + str2 + "_template.png");
            }));
            if (this.f2506d != null) {
                this.f2506d.set(pointDecodeUV.x, pointDecodeUV.y);
            }
        }
        this.f2510cP = getTextureLocation(t);
        this.f2511c = minecraft;
        super.actuallyRender(poseStack, t, bakedGeoModel, renderType, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        if (zFirstPerson && localPlayer != null) {
            m1818a(minecraft, abstractC0787oFM2688a, abstractC0788oGM2692a, localPlayer, poseStack, multiBufferSource, i, z2);
        }
        poseStackPose.popPose();
        poseStack.popPose();
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a */
    public void renderRecursively(PoseStack poseStack, T t, GeoBone geoBone, RenderType renderType, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        if (!f2513cw && this.f2490b == null) {
            throw new AssertionError("Shared gui graphics is null!");
        }
        Minecraft minecraft = this.f2511c;
        ResourceLocation resourceLocation = this.f2510cP;
        PoseStack poseStackPose = this.f2490b.pose();
        poseStackPose.pushPose();
        boolean zIsEmpty = geoBone.getCubes().isEmpty();
        boolean z2 = false;
        Iterator<AbstractC0447hk<T>> it = this.f2497L.iterator();
        while (it.hasNext()) {
            if (it.next().mo1839a(minecraft, poseStackPose, this.f2490b, geoBone, this.currentItemStack, this.renderPerspective, t, zIsEmpty, i, i2, i3, this.f2494fE, this.f2491fB, f)) {
                z2 = true;
            }
        }
        if (!z2) {
            m1817a(minecraft, poseStackPose, geoBone, this.currentItemStack, f);
            vertexConsumer = multiBufferSource.getBuffer(renderType);
            m1816a(poseStackPose, geoBone, renderType, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        }
        Iterator<AbstractC0447hk<T>> it2 = this.f2497L.iterator();
        while (it2.hasNext()) {
            if (it2.next().mo1840a(minecraft, poseStackPose, multiBufferSource, geoBone, t, this.currentItemStack, resourceLocation, this.renderPerspective, vertexConsumer, zIsEmpty, f, i, i2, i3)) {
                poseStackPose.popPose();
                return;
            }
        }
        poseStackPose.popPose();
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void renderCube(PoseStack poseStack, GeoCube geoCube, VertexConsumer vertexConsumer, int i, int i2, int i3) {
        RenderUtil.translateToPivotPoint(poseStack, geoCube);
        RenderUtil.rotateMatrixAroundCube(poseStack, geoCube);
        RenderUtil.translateAwayFromPivotPoint(poseStack, geoCube);
        Matrix3f matrix3fNormal = poseStack.last().normal();
        Matrix4f matrix4f = this.f2487c.set(poseStack.last().pose());
        for (GeoQuad geoQuad : geoCube.quads()) {
            if (geoQuad != null) {
                Vector3f vector3fTransform = matrix3fNormal.transform(this.f2488g.set(geoQuad.normal()));
                RenderUtil.fixInvertedFlatCube(geoCube, vector3fTransform);
                createVerticesOfQuad(geoQuad, matrix4f, vector3fTransform, vertexConsumer, i, i2, i3);
            }
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void createVerticesOfQuad(GeoQuad geoQuad, Matrix4f matrix4f, Vector3f vector3f, VertexConsumer vertexConsumer, int i, int i2, int i3) {
        for (GeoVertex geoVertex : geoQuad.vertices()) {
            Vector3f vector3fPosition = geoVertex.position();
            Vector4f vector4fTransform = matrix4f.transform(this.f2489a.set(vector3fPosition.x(), vector3fPosition.y(), vector3fPosition.z(), 1.0f));
            vertexConsumer.addVertex(vector4fTransform.x(), vector4fTransform.y(), vector4fTransform.z(), i3, geoVertex.texU(), geoVertex.texV(), i2, i, vector3f.x(), vector3f.y(), vector3f.z());
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    public void fireCompileRenderLayersEvent() {
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    public boolean firePreRenderEvent(PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i) {
        return true;
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    public void firePostRenderEvent(PoseStack poseStack, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, float f, int i) {
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a */
    public void updateAnimatedTextureFrame(T t) {
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a */
    public long getInstanceId(T t) {
        if (this.renderPerspective == null || !this.renderPerspective.firstPerson()) {
            return -1L;
        }
        return t.hashCode();
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a */
    public RenderType getRenderType(T t, ResourceLocation resourceLocation, @Nullable MultiBufferSource multiBufferSource, float f) {
        return C0414hD.f2633e.apply(resourceLocation);
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: d */
    public ResourceLocation getTextureLocation(@NotNull T t) {
        if (this.currentItemStack == null) {
            return super.getTextureLocation(t);
        }
        if (((Boolean) this.currentItemStack.getOrDefault(C1228wV.f6980X, false)).booleanValue()) {
            return super.getTextureLocation(t);
        }
        float fFloatValue = ((Float) this.currentItemStack.getOrDefault(C1228wV.f6959C, Float.valueOf(0.0f))).floatValue();
        if (fFloatValue <= 0.0f) {
            return super.getTextureLocation(t);
        }
        if (((Boolean) this.currentItemStack.getOrDefault(C1228wV.f6976T, false)).booleanValue()) {
            return super.getTextureLocation(t);
        }
        ResourceLocation resourceLocation = (ResourceLocation) this.f2507a.get(fFloatValue);
        if (resourceLocation != null) {
            return resourceLocation;
        }
        CloudResourceLocation cloudResourceLocationM2557a = C0564jv.m2557a(BuiltInRegistries.ITEM.getKey(t));
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f2513cw && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        CloudItem<?> itemFromSkinId = CloudItem.getItemFromSkinId(c0622lM2667b.m2670a(), cloudResourceLocationM2557a, fFloatValue);
        if (itemFromSkinId == null) {
            return super.getTextureLocation(t);
        }
        ResourceLocation resourceLocationM2555d = C0564jv.m2555d(("textures/item/" + itemFromSkinId.getMinecraftItem().path() + "_" + itemFromSkinId.getSuffixForDisplay().replace(".", "").replace("-", "") + ".png").toLowerCase(Locale.ROOT));
        this.f2507a.put(fFloatValue, resourceLocationM2555d);
        return resourceLocationM2555d;
    }
}
