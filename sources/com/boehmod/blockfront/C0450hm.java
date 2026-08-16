package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import com.boehmod.bflib.cloud.common.item.pattern.SkinPatternUtils;
import com.boehmod.blockfront.AbstractC1140um;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.hm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hm.class */
public class C0450hm<T extends AbstractC1140um<T>> extends GeoItemRenderer<T> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final ResourceLocation[] f2805a;

    /* JADX INFO: renamed from: cN */
    @NotNull
    private static final ResourceLocation f2806cN;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final ResourceLocation[] f2807b;

    /* JADX INFO: renamed from: cO */
    @NotNull
    private static final ResourceLocation f2808cO;

    /* JADX INFO: renamed from: kz */
    private static final int f2809kz = 40;

    /* JADX INFO: renamed from: aj */
    private static final String f2810aj = "left";

    /* JADX INFO: renamed from: ak */
    private static final String f2811ak = "right";

    /* JADX INFO: renamed from: al */
    private static final String f2812al = "aimpos";

    /* JADX INFO: renamed from: fI */
    private static final float f2813fI = 0.0625f;

    /* JADX INFO: renamed from: fJ */
    private static final float f2814fJ = 0.03125f;

    /* JADX INFO: renamed from: fK */
    private static final float f2815fK = 0.25f;

    /* JADX INFO: renamed from: am */
    private static final String f2816am = "aimpos_mag_type_";

    /* JADX INFO: renamed from: an */
    @Nonnull
    private static final String f2817an = "PatternOffset";

    /* JADX INFO: renamed from: ao */
    @Nonnull
    private static final String f2818ao = "HasPattern";

    /* JADX INFO: renamed from: ap */
    @Nonnull
    private static final String f2819ap = "IsGui";

    /* JADX INFO: renamed from: aq */
    @Nonnull
    private static final String f2820aq = "Silhouette";

    /* JADX INFO: renamed from: kA */
    public static int f2821kA;

    /* JADX INFO: renamed from: f */
    @NotNull
    private final Vector3f f2822f;

    /* JADX INFO: renamed from: i */
    @NotNull
    private final Map<String, Vector3f> f2823i;

    /* JADX INFO: renamed from: e */
    @NotNull
    private final Quaternionf f2824e;

    /* JADX INFO: renamed from: d */
    @NotNull
    private final Matrix4f f2825d;

    /* JADX INFO: renamed from: g */
    @NotNull
    private final Vector3f f2826g;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Vector4f f2827a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private GuiGraphics f2828b;

    /* JADX INFO: renamed from: fL */
    private float f2829fL;

    /* JADX INFO: renamed from: fM */
    private float f2830fM;

    /* JADX INFO: renamed from: fN */
    private float f2831fN;

    /* JADX INFO: renamed from: fO */
    private float f2832fO;

    /* JADX INFO: renamed from: fP */
    private float f2833fP;

    /* JADX INFO: renamed from: fQ */
    private float f2834fQ;

    /* JADX INFO: renamed from: O */
    @NotNull
    public final List<AbstractC0412hA<T>> f2835O;

    /* JADX INFO: renamed from: a */
    @Nullable
    private GeoBone f2836a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private GeoBone f2837b;

    /* JADX INFO: renamed from: h */
    @NotNull
    private final Vector3f f2838h;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final ObjectArrayList<GeoBone> f2839a;

    /* JADX INFO: renamed from: d */
    @Nullable
    private ShaderInstance f2840d;

    /* JADX INFO: renamed from: a */
    @Nullable
    private AbstractUniform f2841a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private AbstractUniform f2842b;

    /* JADX INFO: renamed from: c */
    @Nullable
    private AbstractUniform f2843c;

    /* JADX INFO: renamed from: d */
    @Nullable
    private AbstractUniform f2844d;

    /* JADX INFO: renamed from: a */
    @NotNull
    private final Float2ObjectMap<ResourceLocation> f2845a;

    /* JADX INFO: renamed from: j */
    @NotNull
    private final Map<String, ResourceLocation> f2846j;

    /* JADX INFO: renamed from: k */
    @NotNull
    private final Map<String, ResourceLocation> f2847k;

    /* JADX INFO: renamed from: cP */
    @Nullable
    private ResourceLocation f2848cP;

    /* JADX INFO: renamed from: b */
    @Nullable
    private Minecraft f2849b;

    /* JADX INFO: renamed from: kB */
    private int f2850kB;

    /* JADX INFO: renamed from: cF */
    static final /* synthetic */ boolean f2851cF;

    static {
        f2851cF = !C0450hm.class.desiredAssertionStatus();
        f2805a = new ResourceLocation[]{C0532jO.m2378d("textures/models/items/blood0.png"), C0532jO.m2378d("textures/models/items/blood1.png"), C0532jO.m2378d("textures/models/items/blood2.png"), C0532jO.m2378d("textures/models/items/blood3.png")};
        f2806cN = f2805a[0];
        f2807b = new ResourceLocation[]{C0532jO.m2378d("textures/models/items/mud0.png"), C0532jO.m2378d("textures/models/items/mud1.png"), C0532jO.m2378d("textures/models/items/mud2.png"), C0532jO.m2378d("textures/models/items/mud3.png")};
        f2808cO = f2807b[0];
        f2821kA = 0;
    }

    public C0450hm() {
        this(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), new C0272eT());
    }

    public C0450hm(@NotNull BlockEntityRenderDispatcher blockEntityRenderDispatcher, @NotNull EntityModelSet entityModelSet, @NotNull C0272eT<T> c0272eT) {
        super(blockEntityRenderDispatcher, entityModelSet, c0272eT);
        this.f2822f = new Vector3f();
        this.f2823i = new Object2ObjectOpenHashMap();
        this.f2824e = new Quaternionf();
        this.f2825d = new Matrix4f();
        this.f2826g = new Vector3f();
        this.f2827a = new Vector4f();
        this.f2828b = null;
        this.f2829fL = 0.0f;
        this.f2830fM = 0.0f;
        this.f2831fN = 0.0f;
        this.f2832fO = 0.0f;
        this.f2833fP = 0.0f;
        this.f2834fQ = 0.0f;
        this.f2835O = new ObjectArrayList();
        this.f2836a = null;
        this.f2837b = null;
        this.f2838h = new Vector3f();
        this.f2839a = new ObjectArrayList<>();
        this.f2840d = null;
        this.f2845a = new Float2ObjectOpenHashMap();
        this.f2846j = new Object2ObjectOpenHashMap();
        this.f2847k = new Object2ObjectOpenHashMap();
        this.f2850kB = -1;
        this.f2835O.add(new C0453hp(this));
        this.f2835O.add(new C0454hq(this));
        this.f2835O.add(new C0463hz(this));
        this.f2835O.add(new C0457ht(this));
        this.f2835O.add(new C0462hy(this));
        this.f2835O.add(new C0461hx(this));
        this.f2835O.add(new C0456hs(this));
        this.f2835O.add(new C0413hB(this));
        this.f2835O.add(new C0460hw(this));
        this.f2835O.add(new C0459hv(this));
        this.f2835O.add(new C0455hr(this));
        this.f2835O.add(new C0458hu(this));
    }

    /* JADX INFO: renamed from: a */
    private void m2065a(@NotNull PoseStack poseStack, float f, boolean z, @NotNull Vector3f vector3f) {
        float fMin = Math.min(C1270xJ.m7170f(C0115bf.f780bU, C0115bf.f781bV, f), 1.0f);
        float f2 = 1.0f - fMin;
        poseStack.translate(vector3f.x * fMin, vector3f.y * fMin, vector3f.z * fMin);
        poseStack.translate(0.05f * f2, (-0.05f) * f2, 0.0f);
        this.f2824e.identity().rotateZ((float) Math.toRadians((z ? 10.0f : -10.0f) * f2 * (1.0f - C1270xJ.m7170f(C0112bc.f744bB, C0112bc.f745bC, f))));
        poseStack.mulPose(this.f2824e);
        poseStack.translate(0.0f, 0.0f, 0.02f * C1270xJ.m7170f(C1117uP.f6061nX, C1117uP.f6062nY, f));
    }

    /* JADX INFO: renamed from: a */
    private boolean m2066a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull C0396gl c0396gl, @NotNull T t, float f, @NotNull MutableInt mutableInt) {
        if (this.renderPerspective.firstPerson()) {
            float fM7170f = C1270xJ.m7170f(C0120bk.f810cr, C0120bk.f811cs, f);
            float fM7170f2 = C1270xJ.m7170f(C0120bk.f808cp, C0120bk.f809cq, f);
            poseStack.translate(0.0f, 0.0f, fM7170f);
            this.f2824e.identity().rotateX((float) Math.toRadians(fM7170f2));
            poseStack.mulPose(this.f2824e);
        }
        return m2067a(minecraft, poseStack, c0396gl, t, mutableInt);
    }

    /* JADX INFO: renamed from: a */
    private boolean m2067a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull C0396gl c0396gl, @NotNull T t, @NotNull MutableInt mutableInt) {
        C0394gj c0394gjM1885a = c0396gl.m1885a(minecraft);
        C1188vh c1188vhM6296a = t instanceof C1117uP ? ((C1117uP) t).m6296a(this.currentItemStack) : null;
        Iterator<AbstractC0412hA<T>> it = this.f2835O.iterator();
        while (it.hasNext()) {
            if (it.next().mo1956a(minecraft, poseStack, this.currentItemStack, mutableInt, c1188vhM6296a, this.renderPerspective, c0394gjM1885a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private void m2068a(@NotNull Minecraft minecraft, @NotNull BakedGeoModel bakedGeoModel) {
        if (this.f2850kB == f2821kA) {
            return;
        }
        this.f2850kB = f2821kA;
        bakedGeoModel.getBone(f2810aj).ifPresent(geoBone -> {
            this.f2836a = geoBone;
        });
        bakedGeoModel.getBone(f2811ak).ifPresent(geoBone2 -> {
            this.f2837b = geoBone2;
        });
        Vector3f vector3f = minecraft.getItemRenderer().getModel(this.currentItemStack, minecraft.level, (LivingEntity) null, 0).getTransforms().getTransform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).translation;
        GeoBone geoBoneOrElse = bakedGeoModel.getBone(f2812al).orElse(null);
        if (geoBoneOrElse != null) {
            m2069a(geoBoneOrElse, vector3f, this.f2822f);
        } else {
            this.f2822f.set(0.0f, 0.0f, 0.0f);
        }
        this.f2823i.clear();
        m2070a(bakedGeoModel.topLevelBones(), vector3f);
    }

    /* JADX INFO: renamed from: a */
    private void m2069a(@NotNull GeoBone geoBone, @NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        vector3f2.set((-vector3f.x) - 0.559f, (-vector3f.y) + 0.507f, (-vector3f.z) + 0.66f).add((-geoBone.getPivotX()) * f2813fI, (-geoBone.getPivotY()) * f2813fI, (-geoBone.getPivotZ()) * f2813fI);
    }

    /* JADX INFO: renamed from: a */
    private void m2070a(@NotNull List<GeoBone> list, @NotNull Vector3f vector3f) {
        for (GeoBone geoBone : list) {
            String name = geoBone.getName();
            if (name.startsWith(f2816am)) {
                String strSubstring = name.substring(f2816am.length());
                Vector3f vector3f2 = new Vector3f();
                m2069a(geoBone, vector3f, vector3f2);
                this.f2823i.put(strSubstring, vector3f2);
            }
            List<GeoBone> childBones = geoBone.getChildBones();
            if (!childBones.isEmpty()) {
                m2070a(childBones, vector3f);
            }
        }
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private Vector3f m2071a(@NotNull T t) {
        Vector3f vector3f;
        return (this.f2823i.isEmpty() || !(t instanceof C1117uP) || this.currentItemStack == null || (vector3f = this.f2823i.get(C1117uP.m6257b(this.currentItemStack))) == null) ? this.f2822f : vector3f;
    }

    /* JADX INFO: renamed from: a */
    public void m2072a(@NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull RenderType renderType, @NotNull MultiBufferSource multiBufferSource, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        try {
            super.renderRecursively(poseStack, (AbstractC1140um) this.animatable, geoBone, renderType, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        } catch (IllegalStateException e) {
            C0530jM.log("Error rendering bone: " + geoBone.getName(), new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2073a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, float f) {
        this.f2829fL += 40.0f;
        int iM7246a = InterfaceC1274xN.m7246a(geoBone);
        if ((iM7246a & 1) != 0) {
            float f2 = this.f2830fM;
            if ((iM7246a & 2) != 0) {
                f2 *= 1.0f - this.f2833fP;
            }
            geoBone.setRotZ(f2);
        }
        Iterator<AbstractC0412hA<T>> it = this.f2835O.iterator();
        while (it.hasNext()) {
            it.next().mo1953a(minecraft, poseStack, geoBone, itemStack, this.renderPerspective, (AbstractC1140um) this.animatable, this.f2833fP, this.f2834fQ, this.f2831fN, f);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2074a(@NotNull Minecraft minecraft, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @Nullable AbstractC0864pc<?, ?> abstractC0864pc, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, boolean z) {
        if (this.f2836a == null && this.f2837b == null) {
            return;
        }
        C0623l c0623lM2852b = C0623l.m2852b();
        if (c0623lM2852b == null || !c0623lM2852b.m2876e()) {
            C0441hd renderer = minecraft.getEntityRenderDispatcher().getRenderer(localPlayer);
            if (renderer instanceof C0441hd) {
                C0441hd c0441hd = renderer;
                boolean z2 = !localPlayer.getMainHandItem().isEmpty();
                boolean z3 = !localPlayer.getOffhandItem().isEmpty();
                if (this.f2836a != null && (!z ? !z2 : !z3)) {
                    m2075a(abstractC0863pb, abstractC0864pc, localPlayer, poseStack, multiBufferSource, i, this.f2836a, c0441hd, z);
                }
                if (this.f2837b != null) {
                    m2075a(abstractC0863pb, abstractC0864pc, localPlayer, poseStack, multiBufferSource, i, this.f2837b, c0441hd, !z);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2075a(@Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, @Nullable AbstractC0864pc<?, ?> abstractC0864pc, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull GeoBone geoBone, @NotNull C0441hd c0441hd, boolean z) {
        poseStack.pushPose();
        m2076a(poseStack, geoBone);
        C0270eR model = c0441hd.getModel();
        boolean z2 = (model instanceof C0270eR) && model.m1509M();
        m2077a(geoBone, this.f2838h);
        float f = z2 ? f2814fJ : f2813fI;
        poseStack.translate(this.f2838h.x - (z ? -f : f), this.f2838h.y - 0.25f, this.f2838h.z);
        this.f2824e.identity().rotateY(3.1415927f);
        poseStack.mulPose(this.f2824e);
        c0441hd.m2029a(abstractC0863pb, abstractC0864pc, (AbstractClientPlayer) localPlayer, poseStack, multiBufferSource, i, z);
        poseStack.popPose();
    }

    /* JADX INFO: renamed from: a */
    private void m2076a(@NotNull PoseStack poseStack, @NotNull GeoBone geoBone) {
        this.f2839a.clear();
        GeoBone parent = geoBone;
        while (true) {
            GeoBone geoBone2 = parent;
            if (geoBone2 == null) {
                break;
            }
            this.f2839a.add(geoBone2);
            parent = geoBone2.getParent();
        }
        for (int size = this.f2839a.size() - 1; size >= 0; size--) {
            RenderUtil.prepMatrixForBone(poseStack, (GeoBone) this.f2839a.get(size));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2077a(@NotNull GeoBone geoBone, @NotNull Vector3f vector3f) {
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
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void defaultRender(PoseStack poseStack, T t, MultiBufferSource multiBufferSource, @Nullable RenderType renderType, @Nullable VertexConsumer vertexConsumer, float f, float f2, int i) {
        Minecraft minecraft = Minecraft.getInstance();
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2851cF && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        C0396gl c0396gl = (C0396gl) c0623lM2852b.m2855a();
        MutableInt mutableInt = new MutableInt(i);
        if (m2066a(minecraft, poseStack, c0396gl, t, f2, mutableInt)) {
            return;
        }
        super.defaultRender(poseStack, t, multiBufferSource, renderType, vertexConsumer, f, f2, mutableInt.intValue());
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void actuallyRender(PoseStack poseStack, T t, BakedGeoModel bakedGeoModel, @Nullable RenderType renderType, MultiBufferSource multiBufferSource, @Nullable VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        float f2;
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2851cF && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        AbstractC0864pc<?, ?> abstractC0864pcM2878a = c0623lM2852b.m2878a();
        boolean zFirstPerson = this.renderPerspective.firstPerson();
        m2068a(minecraft, bakedGeoModel);
        poseStack.pushPose();
        if ((minecraft.screen instanceof C0249dx) && this.renderPerspective == ItemDisplayContext.GUI) {
            this.f2824e.identity().rotateZ((float) Math.toRadians(C0249dx.f2046dT));
            poseStack.mulPose(this.f2824e);
            this.f2824e.identity().rotateY((float) Math.toRadians(C0249dx.f2047dU));
            poseStack.mulPose(this.f2824e);
        }
        boolean z2 = this.renderPerspective == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND;
        if (zFirstPerson) {
            m2065a(poseStack, f, z2, m2071a((AbstractC1140um) t));
        }
        if (this.f2828b == null) {
            this.f2828b = new GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource());
        }
        PoseStack poseStackPose = this.f2828b.pose();
        poseStackPose.pushPose();
        poseStackPose.mulPose(poseStack.last().pose());
        float fClamp = Mth.clamp(C1270xJ.m7170f(t.f6252ny, t.f6253nz, f), 0.0f, 1.0f);
        this.f2829fL = C0129bt.m466g();
        if (zFirstPerson) {
            f2 = C1117uP.f6063il ? 0.1f : 0.85f;
        } else {
            f2 = 1.0f;
        }
        this.f2832fO = f2;
        this.f2833fP = C1270xJ.m7170f(C0112bc.f744bB, C0112bc.f745bC, f);
        this.f2834fQ = 1.0f - this.f2833fP;
        this.f2831fN = zFirstPerson ? Mth.sin(this.f2829fL / 3.0f) * fClamp : 0.0f;
        this.f2830fM = zFirstPerson ? this.f2831fN * ((AbstractC1140um) this.animatable).m6575by() : 0.0f;
        boolean zBooleanValue = ((Boolean) this.currentItemStack.getOrDefault(C1305xs.f7545Z, false)).booleanValue();
        boolean z3 = !zBooleanValue && ((Boolean) this.currentItemStack.getOrDefault(C1305xs.f7541V, false)).booleanValue();
        if (zBooleanValue) {
            RenderSystem.setShaderTexture(3, f2806cN);
            RenderSystem.setShaderTexture(4, f2808cO);
        } else {
            int iIntValue = C0495ie.f3043w.m2230U() ? ((Integer) this.currentItemStack.getOrDefault(C1305xs.f7538S, 0)).intValue() : 0;
            int iIntValue2 = ((Integer) this.currentItemStack.getOrDefault(C1305xs.f7539T, 0)).intValue();
            RenderSystem.setShaderTexture(3, f2805a[iIntValue]);
            RenderSystem.setShaderTexture(4, f2807b[iIntValue2]);
        }
        ShaderInstance shaderInstanceM1981a = C0431hT.m1981a();
        if (shaderInstanceM1981a != this.f2840d) {
            this.f2840d = shaderInstanceM1981a;
            if (shaderInstanceM1981a != null) {
                this.f2841a = shaderInstanceM1981a.safeGetUniform(f2818ao);
                this.f2842b = shaderInstanceM1981a.safeGetUniform(f2819ap);
                this.f2843c = shaderInstanceM1981a.safeGetUniform(f2820aq);
                this.f2844d = shaderInstanceM1981a.safeGetUniform(f2817an);
            } else {
                this.f2841a = null;
                this.f2842b = null;
                this.f2843c = null;
                this.f2844d = null;
            }
        }
        if (shaderInstanceM1981a != null) {
            boolean z4 = C0495ie.f3037q.m2230U() && ((Boolean) this.currentItemStack.getOrDefault(C1305xs.f7524E.get(), false)).booleanValue();
            this.f2842b.set(this.renderPerspective == ItemDisplayContext.GUI ? 1 : 0);
            this.f2843c.set(z4 ? 1 : 0);
            this.f2841a.set(z3 ? 1 : 0);
        }
        if (z3) {
            Point pointDecodeUV = SkinPatternUtils.decodeUV(((Double) this.currentItemStack.getOrDefault(C1305xs.f7540U, Double.valueOf(0.0d))).doubleValue(), ((Integer) this.currentItemStack.getOrDefault(C1305xs.f7542W, 1)).intValue(), ((Integer) this.currentItemStack.getOrDefault(C1305xs.f7543X, 1)).intValue());
            String lowerCase = ((String) this.currentItemStack.getOrDefault(C1305xs.f7544Y, "default")).toLowerCase(Locale.ROOT);
            ResourceLocation key = BuiltInRegistries.ITEM.getKey(t);
            RenderSystem.setShaderTexture(5, this.f2846j.computeIfAbsent(lowerCase, str -> {
                return C0532jO.m2378d("textures/item/patterns/" + str + ".png");
            }));
            RenderSystem.setShaderTexture(6, this.f2847k.computeIfAbsent(key.getPath(), str2 -> {
                return C0532jO.m2378d("textures/item/" + str2 + "_template.png");
            }));
            if (this.f2844d != null) {
                this.f2844d.set(pointDecodeUV.x, pointDecodeUV.y);
            }
        }
        this.f2848cP = getTextureLocation(t);
        this.f2849b = minecraft;
        super.actuallyRender(poseStack, t, bakedGeoModel, renderType, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        if (zFirstPerson && localPlayer != null) {
            m2074a(minecraft, abstractC0863pbM2874a, abstractC0864pcM2878a, localPlayer, poseStack, multiBufferSource, i, z2);
        }
        poseStackPose.popPose();
        poseStack.popPose();
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void renderRecursively(PoseStack poseStack, T t, GeoBone geoBone, RenderType renderType, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        if (!f2851cF && this.f2828b == null) {
            throw new AssertionError("Shared gui graphics is null!");
        }
        Minecraft minecraft = this.f2849b;
        ResourceLocation resourceLocation = this.f2848cP;
        PoseStack poseStackPose = this.f2828b.pose();
        poseStackPose.pushPose();
        boolean zIsEmpty = geoBone.getCubes().isEmpty();
        boolean z2 = false;
        Iterator<AbstractC0412hA<T>> it = this.f2835O.iterator();
        while (it.hasNext()) {
            if (it.next().mo1954a(minecraft, poseStackPose, this.f2828b, geoBone, this.currentItemStack, this.renderPerspective, t, zIsEmpty, i, i2, i3, this.f2832fO, this.f2829fL, f)) {
                z2 = true;
            }
        }
        if (!z2) {
            m2073a(minecraft, poseStackPose, geoBone, this.currentItemStack, f);
            vertexConsumer = multiBufferSource.getBuffer(renderType);
            m2072a(poseStackPose, geoBone, renderType, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        }
        Iterator<AbstractC0412hA<T>> it2 = this.f2835O.iterator();
        while (it2.hasNext()) {
            if (it2.next().mo1955a(minecraft, poseStackPose, multiBufferSource, geoBone, t, this.currentItemStack, resourceLocation, this.renderPerspective, vertexConsumer, zIsEmpty, f, i, i2, i3)) {
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
        Matrix4f matrix4f = this.f2825d.set(poseStack.last().pose());
        for (GeoQuad geoQuad : geoCube.quads()) {
            if (geoQuad != null) {
                Vector3f vector3fTransform = matrix3fNormal.transform(this.f2826g.set(geoQuad.normal()));
                RenderUtil.fixInvertedFlatCube(geoCube, vector3fTransform);
                createVerticesOfQuad(geoQuad, matrix4f, vector3fTransform, vertexConsumer, i, i2, i3);
            }
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void createVerticesOfQuad(GeoQuad geoQuad, Matrix4f matrix4f, Vector3f vector3f, VertexConsumer vertexConsumer, int i, int i2, int i3) {
        for (GeoVertex geoVertex : geoQuad.vertices()) {
            Vector3f vector3fPosition = geoVertex.position();
            Vector4f vector4fTransform = matrix4f.transform(this.f2827a.set(vector3fPosition.x(), vector3fPosition.y(), vector3fPosition.z(), 1.0f));
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
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void updateAnimatedTextureFrame(T t) {
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getInstanceId(T t) {
        if (this.renderPerspective == null || !this.renderPerspective.firstPerson()) {
            return -1L;
        }
        return t.hashCode();
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RenderType getRenderType(T t, ResourceLocation resourceLocation, @Nullable MultiBufferSource multiBufferSource, float f) {
        return C0431hT.f2711e.apply(resourceLocation);
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull T t) {
        if (this.currentItemStack == null) {
            return super.getTextureLocation(t);
        }
        if (((Boolean) this.currentItemStack.getOrDefault(C1305xs.f7545Z, false)).booleanValue()) {
            return super.getTextureLocation(t);
        }
        float fFloatValue = ((Float) this.currentItemStack.getOrDefault(C1305xs.f7522C, Float.valueOf(0.0f))).floatValue();
        if (fFloatValue <= 0.0f) {
            return super.getTextureLocation(t);
        }
        if (((Boolean) this.currentItemStack.getOrDefault(C1305xs.f7541V, false)).booleanValue()) {
            return super.getTextureLocation(t);
        }
        ResourceLocation resourceLocation = (ResourceLocation) this.f2845a.get(fFloatValue);
        if (resourceLocation != null) {
            return resourceLocation;
        }
        CloudResourceLocation cloudResourceLocationM2380a = C0532jO.m2380a(BuiltInRegistries.ITEM.getKey(t));
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f2851cF && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        CloudItem<?> itemFromSkinId = CloudItem.getItemFromSkinId(c0623lM2852b.m2855a(), cloudResourceLocationM2380a, fFloatValue);
        if (itemFromSkinId == null) {
            return super.getTextureLocation(t);
        }
        ResourceLocation resourceLocationM2378d = C0532jO.m2378d(("textures/item/" + itemFromSkinId.getMinecraftItem().path() + "_" + itemFromSkinId.getSuffixForDisplay().replace(".", "").replace("-", "") + ".png").toLowerCase(Locale.ROOT));
        this.f2845a.put(fFloatValue, resourceLocationM2378d);
        return resourceLocationM2378d;
    }
}
