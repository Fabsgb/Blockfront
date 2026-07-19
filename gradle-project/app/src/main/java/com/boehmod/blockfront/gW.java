package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.common.item.CloudItem;
import com.boehmod.bflib.cloud.common.item.CloudResourceLocation;
import com.boehmod.bflib.cloud.common.item.pattern.SkinPatternUtils;
import com.boehmod.blockfront.tO;
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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gW.class */
public class gW<T extends tO<T>> extends GeoItemRenderer<T> {

    @NotNull
    private static final ResourceLocation[] a;

    @NotNull
    private static final ResourceLocation cN;

    @NotNull
    private static final ResourceLocation[] b;

    @NotNull
    private static final ResourceLocation cO;
    private static final int je = 40;
    private static final String ac = "left";
    private static final String ad = "right";
    private static final String ae = "aimpos";
    private static final float fy = 0.0625f;
    private static final float fz = 0.03125f;
    private static final float fA = 0.25f;
    private static final String af = "aimpos_mag_type_";

    @Nonnull
    private static final String ag = "PatternOffset";

    @Nonnull
    private static final String ah = "HasPattern";

    @Nonnull
    private static final String ai = "IsGui";

    @Nonnull
    private static final String aj = "Silhouette";
    public static int jf;

    @NotNull
    private final Vector3f f;

    @NotNull
    private final Map<String, Vector3f> i;

    @NotNull
    private final Quaternionf e;

    @NotNull
    private final Matrix4f c;

    @NotNull
    private final Vector3f g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final Vector4f f134a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    private GuiGraphics f135b;
    private float fB;
    private float fC;
    private float fD;
    private float fE;
    private float fF;
    private float fG;

    @NotNull
    public final List<AbstractC0201hk<T>> L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private GeoBone f136a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    private GeoBone f137b;

    @NotNull
    private final Vector3f h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final ObjectArrayList<GeoBone> f138a;

    @Nullable
    private ShaderInstance d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    private AbstractUniform f139a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    private AbstractUniform f140b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    private AbstractUniform f141c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @Nullable
    private AbstractUniform f142d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    private final Float2ObjectMap<ResourceLocation> f143a;

    @NotNull
    private final Map<String, ResourceLocation> j;

    @NotNull
    private final Map<String, ResourceLocation> k;

    @Nullable
    private ResourceLocation cP;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    private Minecraft f144c;
    private int jg;
    static final /* synthetic */ boolean cw;

    static {
        cw = !gW.class.desiredAssertionStatus();
        a = new ResourceLocation[]{C0265jv.d("textures/models/items/blood0.png"), C0265jv.d("textures/models/items/blood1.png"), C0265jv.d("textures/models/items/blood2.png"), C0265jv.d("textures/models/items/blood3.png")};
        cN = a[0];
        b = new ResourceLocation[]{C0265jv.d("textures/models/items/mud0.png"), C0265jv.d("textures/models/items/mud1.png"), C0265jv.d("textures/models/items/mud2.png"), C0265jv.d("textures/models/items/mud3.png")};
        cO = b[0];
        jf = 0;
    }

    public gW() {
        this(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), new eG());
    }

    public gW(@NotNull BlockEntityRenderDispatcher blockEntityRenderDispatcher, @NotNull EntityModelSet entityModelSet, @NotNull eG<T> eGVar) {
        super(blockEntityRenderDispatcher, entityModelSet, eGVar);
        this.f = new Vector3f();
        this.i = new Object2ObjectOpenHashMap();
        this.e = new Quaternionf();
        this.c = new Matrix4f();
        this.g = new Vector3f();
        this.f134a = new Vector4f();
        this.f135b = null;
        this.fB = 0.0f;
        this.fC = 0.0f;
        this.fD = 0.0f;
        this.fE = 0.0f;
        this.fF = 0.0f;
        this.fG = 0.0f;
        this.L = new ObjectArrayList();
        this.f136a = null;
        this.f137b = null;
        this.h = new Vector3f();
        this.f138a = new ObjectArrayList<>();
        this.d = null;
        this.f143a = new Float2ObjectOpenHashMap();
        this.j = new Object2ObjectOpenHashMap();
        this.k = new Object2ObjectOpenHashMap();
        this.jg = -1;
        this.L.add(new gZ(this));
        this.L.add(new C0191ha(this));
        this.L.add(new C0200hj(this));
        this.L.add(new C0194hd(this));
        this.L.add(new C0199hi(this));
        this.L.add(new C0198hh(this));
        this.L.add(new C0193hc(this));
        this.L.add(new C0202hl(this));
        this.L.add(new C0197hg(this));
        this.L.add(new C0196hf(this));
        this.L.add(new C0192hb(this));
        this.L.add(new C0195he(this));
    }

    private void a(@NotNull PoseStack poseStack, float f, boolean z, @NotNull Vector3f vector3f) {
        float fMin = Math.min(C0634xm.e(aX.bO, aX.bP, f), 1.0f);
        float f2 = 1.0f - fMin;
        poseStack.translate(vector3f.x * fMin, vector3f.y * fMin, vector3f.z * fMin);
        poseStack.translate(0.05f * f2, (-0.05f) * f2, 0.0f);
        this.e.identity().rotateZ((float) Math.toRadians((z ? 10.0f : -10.0f) * f2 * (1.0f - C0634xm.e(aU.bv, aU.bw, f))));
        poseStack.mulPose(this.e);
        poseStack.translate(0.0f, 0.0f, 0.02f * C0634xm.e(C0558ur.mY, C0558ur.mZ, f));
    }

    private boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull fV fVVar, @NotNull T t, float f, @NotNull MutableInt mutableInt) {
        if (this.renderPerspective.firstPerson()) {
            float fE = C0634xm.e(C0032bc.cl, C0032bc.cm, f);
            float fE2 = C0634xm.e(C0032bc.cj, C0032bc.ck, f);
            poseStack.translate(0.0f, 0.0f, fE);
            this.e.identity().rotateX((float) Math.toRadians(fE2));
            poseStack.mulPose(this.e);
        }
        return a(minecraft, poseStack, fVVar, t, mutableInt);
    }

    private boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull fV fVVar, @NotNull T t, @NotNull MutableInt mutableInt) {
        fT fTVarA = fVVar.a(minecraft);
        uH uHVarM1208a = t instanceof C0558ur ? ((C0558ur) t).m1208a(this.currentItemStack) : null;
        Iterator<AbstractC0201hk<T>> it = this.L.iterator();
        while (it.hasNext()) {
            if (it.next().a(minecraft, poseStack, this.currentItemStack, mutableInt, uHVarM1208a, this.renderPerspective, fTVarA)) {
                return true;
            }
        }
        return false;
    }

    private void a(@NotNull Minecraft minecraft, @NotNull BakedGeoModel bakedGeoModel) {
        if (this.jg == jf) {
            return;
        }
        this.jg = jf;
        bakedGeoModel.getBone(ac).ifPresent(geoBone -> {
            this.f136a = geoBone;
        });
        bakedGeoModel.getBone(ad).ifPresent(geoBone2 -> {
            this.f137b = geoBone2;
        });
        Vector3f vector3f = minecraft.getItemRenderer().getModel(this.currentItemStack, minecraft.level, (LivingEntity) null, 0).getTransforms().getTransform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).translation;
        GeoBone geoBoneOrElse = bakedGeoModel.getBone(ae).orElse(null);
        if (geoBoneOrElse != null) {
            a(geoBoneOrElse, vector3f, this.f);
        } else {
            this.f.set(0.0f, 0.0f, 0.0f);
        }
        this.i.clear();
        a(bakedGeoModel.topLevelBones(), vector3f);
    }

    private void a(@NotNull GeoBone geoBone, @NotNull Vector3f vector3f, @NotNull Vector3f vector3f2) {
        vector3f2.set((-vector3f.x) - 0.559f, (-vector3f.y) + 0.507f, (-vector3f.z) + 0.66f).add((-geoBone.getPivotX()) * fy, (-geoBone.getPivotY()) * fy, (-geoBone.getPivotZ()) * fy);
    }

    private void a(@NotNull List<GeoBone> list, @NotNull Vector3f vector3f) {
        for (GeoBone geoBone : list) {
            String name = geoBone.getName();
            if (name.startsWith(af)) {
                String strSubstring = name.substring(af.length());
                Vector3f vector3f2 = new Vector3f();
                a(geoBone, vector3f, vector3f2);
                this.i.put(strSubstring, vector3f2);
            }
            List<GeoBone> childBones = geoBone.getChildBones();
            if (!childBones.isEmpty()) {
                a(childBones, vector3f);
            }
        }
    }

    @NotNull
    private Vector3f a(@NotNull T t) {
        Vector3f vector3f;
        return (this.i.isEmpty() || !(t instanceof C0558ur) || this.currentItemStack == null || (vector3f = this.i.get(C0558ur.b(this.currentItemStack))) == null) ? this.f : vector3f;
    }

    public void a(@NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull RenderType renderType, @NotNull MultiBufferSource multiBufferSource, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        try {
            super.renderRecursively(poseStack, (tO) this.animatable, geoBone, renderType, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        } catch (IllegalStateException e) {
            C0263jt.log("Error rendering bone: " + geoBone.getName(), new Object[0]);
        }
    }

    private void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, float f) {
        this.fB += 40.0f;
        int iA = InterfaceC0638xq.a(geoBone);
        if ((iA & 1) != 0) {
            float f2 = this.fC;
            if ((iA & 2) != 0) {
                f2 *= 1.0f - this.fF;
            }
            geoBone.setRotZ(f2);
        }
        Iterator<AbstractC0201hk<T>> it = this.L.iterator();
        while (it.hasNext()) {
            it.next().a(minecraft, poseStack, geoBone, itemStack, this.renderPerspective, (tO) this.animatable, this.fF, this.fG, this.fD, f);
        }
    }

    public void a(@NotNull Minecraft minecraft, @Nullable oF<?, ?, ?> oFVar, @Nullable oG<?, ?> oGVar, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, boolean z) {
        if (this.f136a == null && this.f137b == null) {
            return;
        }
        C0297l c0297lB = C0297l.b();
        if (c0297lB == null || !c0297lB.e()) {
            gN renderer = minecraft.getEntityRenderDispatcher().getRenderer(localPlayer);
            if (renderer instanceof gN) {
                gN gNVar = renderer;
                boolean z2 = !localPlayer.getMainHandItem().isEmpty();
                boolean z3 = !localPlayer.getOffhandItem().isEmpty();
                if (this.f136a != null && (!z ? !z2 : !z3)) {
                    a(oFVar, oGVar, localPlayer, poseStack, multiBufferSource, i, this.f136a, gNVar, z);
                }
                if (this.f137b != null) {
                    a(oFVar, oGVar, localPlayer, poseStack, multiBufferSource, i, this.f137b, gNVar, !z);
                }
            }
        }
    }

    private void a(@Nullable oF<?, ?, ?> oFVar, @Nullable oG<?, ?> oGVar, @NotNull LocalPlayer localPlayer, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, @NotNull GeoBone geoBone, @NotNull gN gNVar, boolean z) {
        poseStack.pushPose();
        a(poseStack, geoBone);
        eE model = gNVar.getModel();
        boolean z2 = (model instanceof eE) && model.L();
        a(geoBone, this.h);
        float f = z2 ? fz : fy;
        poseStack.translate(this.h.x - (z ? -f : f), this.h.y - 0.25f, this.h.z);
        this.e.identity().rotateY(3.1415927f);
        poseStack.mulPose(this.e);
        gNVar.a(oFVar, oGVar, (AbstractClientPlayer) localPlayer, poseStack, multiBufferSource, i, z);
        poseStack.popPose();
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GeoBone geoBone) {
        this.f138a.clear();
        GeoBone parent = geoBone;
        while (true) {
            GeoBone geoBone2 = parent;
            if (geoBone2 == null) {
                break;
            }
            this.f138a.add(geoBone2);
            parent = geoBone2.getParent();
        }
        for (int size = this.f138a.size() - 1; size >= 0; size--) {
            RenderUtil.prepMatrixForBone(poseStack, (GeoBone) this.f138a.get(size));
        }
    }

    private void a(@NotNull GeoBone geoBone, @NotNull Vector3f vector3f) {
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
        C0297l c0297lB = C0297l.b();
        if (!cw && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        fV fVVar = (fV) c0297lB.a();
        MutableInt mutableInt = new MutableInt(i);
        if (a(minecraft, poseStack, fVVar, t, f2, mutableInt)) {
            return;
        }
        super.defaultRender(poseStack, t, multiBufferSource, renderType, vertexConsumer, f, f2, mutableInt.intValue());
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void actuallyRender(PoseStack poseStack, T t, BakedGeoModel bakedGeoModel, @Nullable RenderType renderType, MultiBufferSource multiBufferSource, @Nullable VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer localPlayer = minecraft.player;
        C0297l c0297lB = C0297l.b();
        if (!cw && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        oG<?, ?> oGVarM593a = c0297lB.m593a();
        boolean zFirstPerson = this.renderPerspective.firstPerson();
        a(minecraft, bakedGeoModel);
        poseStack.pushPose();
        if ((minecraft.screen instanceof Cdo) && this.renderPerspective == ItemDisplayContext.GUI) {
            this.e.identity().rotateZ((float) Math.toRadians(Cdo.dQ));
            poseStack.mulPose(this.e);
            this.e.identity().rotateY((float) Math.toRadians(Cdo.dR));
            poseStack.mulPose(this.e);
        }
        boolean z2 = this.renderPerspective == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND;
        if (zFirstPerson) {
            a(poseStack, f, z2, a((tO) t));
        }
        if (this.f135b == null) {
            this.f135b = new GuiGraphics(minecraft, minecraft.renderBuffers().bufferSource());
        }
        PoseStack poseStackPose = this.f135b.pose();
        poseStackPose.pushPose();
        poseStackPose.mulPose(poseStack.last().pose());
        float fClamp = Mth.clamp(C0634xm.e(t.mz, t.mA, f), 0.0f, 1.0f);
        this.fB = C0040bk.g();
        this.fE = zFirstPerson ? C0558ur.hR ? 0.1f : 0.85f : 1.0f;
        this.fF = C0634xm.e(aU.bv, aU.bw, f);
        this.fG = 1.0f - this.fF;
        this.fD = zFirstPerson ? Mth.sin(this.fB / 3.0f) * fClamp : 0.0f;
        this.fC = zFirstPerson ? this.fD * ((tO) this.animatable).bs() : 0.0f;
        boolean zBooleanValue = ((Boolean) this.currentItemStack.getOrDefault(wV.X, false)).booleanValue();
        boolean z3 = !zBooleanValue && ((Boolean) this.currentItemStack.getOrDefault(wV.T, false)).booleanValue();
        if (zBooleanValue) {
            RenderSystem.setShaderTexture(3, cN);
            RenderSystem.setShaderTexture(4, cO);
        } else {
            int iIntValue = hN.w.T() ? ((Integer) this.currentItemStack.getOrDefault(wV.Q, 0)).intValue() : 0;
            int iIntValue2 = ((Integer) this.currentItemStack.getOrDefault(wV.R, 0)).intValue();
            RenderSystem.setShaderTexture(3, a[iIntValue]);
            RenderSystem.setShaderTexture(4, b[iIntValue2]);
        }
        ShaderInstance shaderInstanceA = hD.a();
        if (shaderInstanceA != this.d) {
            this.d = shaderInstanceA;
            if (shaderInstanceA != null) {
                this.f139a = shaderInstanceA.safeGetUniform(ah);
                this.f140b = shaderInstanceA.safeGetUniform(ai);
                this.f141c = shaderInstanceA.safeGetUniform(aj);
                this.f142d = shaderInstanceA.safeGetUniform(ag);
            } else {
                this.f139a = null;
                this.f140b = null;
                this.f141c = null;
                this.f142d = null;
            }
        }
        if (shaderInstanceA != null) {
            boolean z4 = hN.q.T() && ((Boolean) this.currentItemStack.getOrDefault(wV.E.get(), false)).booleanValue();
            this.f140b.set(this.renderPerspective == ItemDisplayContext.GUI ? 1 : 0);
            this.f141c.set(z4 ? 1 : 0);
            this.f139a.set(z3 ? 1 : 0);
        }
        if (z3) {
            Point pointDecodeUV = SkinPatternUtils.decodeUV(((Double) this.currentItemStack.getOrDefault(wV.S, Double.valueOf(0.0d))).doubleValue(), ((Integer) this.currentItemStack.getOrDefault(wV.U, 1)).intValue(), ((Integer) this.currentItemStack.getOrDefault(wV.V, 1)).intValue());
            String lowerCase = ((String) this.currentItemStack.getOrDefault(wV.W, "default")).toLowerCase(Locale.ROOT);
            ResourceLocation key = BuiltInRegistries.ITEM.getKey(t);
            RenderSystem.setShaderTexture(5, this.j.computeIfAbsent(lowerCase, str -> {
                return C0265jv.d("textures/item/patterns/" + str + ".png");
            }));
            RenderSystem.setShaderTexture(6, this.k.computeIfAbsent(key.getPath(), str2 -> {
                return C0265jv.d("textures/item/" + str2 + "_template.png");
            }));
            if (this.f142d != null) {
                this.f142d.set(pointDecodeUV.x, pointDecodeUV.y);
            }
        }
        this.cP = getTextureLocation(t);
        this.f144c = minecraft;
        super.actuallyRender(poseStack, t, bakedGeoModel, renderType, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        if (zFirstPerson && localPlayer != null) {
            a(minecraft, oFVarM591a, oGVarM593a, localPlayer, poseStack, multiBufferSource, i, z2);
        }
        poseStackPose.popPose();
        poseStack.popPose();
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void renderRecursively(PoseStack poseStack, T t, GeoBone geoBone, RenderType renderType, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        if (!cw && this.f135b == null) {
            throw new AssertionError("Shared gui graphics is null!");
        }
        Minecraft minecraft = this.f144c;
        ResourceLocation resourceLocation = this.cP;
        PoseStack poseStackPose = this.f135b.pose();
        poseStackPose.pushPose();
        boolean zIsEmpty = geoBone.getCubes().isEmpty();
        boolean z2 = false;
        Iterator<AbstractC0201hk<T>> it = this.L.iterator();
        while (it.hasNext()) {
            if (it.next().a(minecraft, poseStackPose, this.f135b, geoBone, this.currentItemStack, this.renderPerspective, t, zIsEmpty, i, i2, i3, this.fE, this.fB, f)) {
                z2 = true;
            }
        }
        if (!z2) {
            a(minecraft, poseStackPose, geoBone, this.currentItemStack, f);
            vertexConsumer = multiBufferSource.getBuffer(renderType);
            a(poseStackPose, geoBone, renderType, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        }
        Iterator<AbstractC0201hk<T>> it2 = this.L.iterator();
        while (it2.hasNext()) {
            if (it2.next().a(minecraft, poseStackPose, multiBufferSource, geoBone, t, this.currentItemStack, resourceLocation, this.renderPerspective, vertexConsumer, zIsEmpty, f, i, i2, i3)) {
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
        Matrix4f matrix4f = this.c.set(poseStack.last().pose());
        for (GeoQuad geoQuad : geoCube.quads()) {
            if (geoQuad != null) {
                Vector3f vector3fTransform = matrix3fNormal.transform(this.g.set(geoQuad.normal()));
                RenderUtil.fixInvertedFlatCube(geoCube, vector3fTransform);
                createVerticesOfQuad(geoQuad, matrix4f, vector3fTransform, vertexConsumer, i, i2, i3);
            }
        }
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    public void createVerticesOfQuad(GeoQuad geoQuad, Matrix4f matrix4f, Vector3f vector3f, VertexConsumer vertexConsumer, int i, int i2, int i3) {
        for (GeoVertex geoVertex : geoQuad.vertices()) {
            Vector3f vector3fPosition = geoVertex.position();
            Vector4f vector4fTransform = matrix4f.transform(this.f134a.set(vector3fPosition.x(), vector3fPosition.y(), vector3fPosition.z(), 1.0f));
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
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public void updateAnimatedTextureFrame(T t) {
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public long getInstanceId(T t) {
        if (this.renderPerspective == null || !this.renderPerspective.firstPerson()) {
            return -1L;
        }
        return t.hashCode();
    }

    @Override // software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RenderType getRenderType(T t, ResourceLocation resourceLocation, @Nullable MultiBufferSource multiBufferSource, float f) {
        return hD.e.apply(resourceLocation);
    }

    @Override // software.bernie.geckolib.renderer.GeoItemRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureLocation(@NotNull T t) {
        if (this.currentItemStack == null) {
            return super.getTextureLocation(t);
        }
        if (((Boolean) this.currentItemStack.getOrDefault(wV.X, false)).booleanValue()) {
            return super.getTextureLocation(t);
        }
        float fFloatValue = ((Float) this.currentItemStack.getOrDefault(wV.C, Float.valueOf(0.0f))).floatValue();
        if (fFloatValue <= 0.0f) {
            return super.getTextureLocation(t);
        }
        if (((Boolean) this.currentItemStack.getOrDefault(wV.T, false)).booleanValue()) {
            return super.getTextureLocation(t);
        }
        ResourceLocation resourceLocation = (ResourceLocation) this.f143a.get(fFloatValue);
        if (resourceLocation != null) {
            return resourceLocation;
        }
        CloudResourceLocation cloudResourceLocationA = C0265jv.a(BuiltInRegistries.ITEM.getKey(t));
        C0297l c0297lB = C0297l.b();
        if (!cw && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        CloudItem<?> itemFromSkinId = CloudItem.getItemFromSkinId(c0297lB.a(), cloudResourceLocationA, fFloatValue);
        if (itemFromSkinId == null) {
            return super.getTextureLocation(t);
        }
        ResourceLocation resourceLocationD = C0265jv.d(("textures/item/" + itemFromSkinId.getMinecraftItem().path() + "_" + itemFromSkinId.getSuffixForDisplay().replace(".", "").replace("-", "") + ".png").toLowerCase(Locale.ROOT));
        this.f143a.put(fFloatValue, resourceLocationD);
        return resourceLocationD;
    }
}
