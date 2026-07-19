package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.lN;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: renamed from: com.boehmod.blockfront.gt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gt.class */
public class C0183gt<T extends lN & GeoAnimatable> extends AbstractC0182gs<T> {

    @NotNull
    private static final IntegerProperty a = lD.k;

    @NotNull
    private static final IntegerProperty b = lD.l;
    private static final int iZ = 256;
    private static final int ja = 512;
    private int jb;

    public C0183gt(@NotNull BlockEntityRendererProvider.Context context) {
        this(new eJ());
    }

    public C0183gt(@NotNull GeoModel<T> geoModel) {
        super(geoModel);
        this.jb = 5;
    }

    @NotNull
    public C0183gt<T> a(int i) {
        this.jb = i;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0182gs
    public boolean R() {
        Minecraft minecraft = Minecraft.getInstance();
        return minecraft.player != null && minecraft.player.isCreative();
    }

    @Override // com.boehmod.blockfront.AbstractC0182gs
    public boolean a(@NotNull lN lNVar) {
        return !lNVar.am();
    }

    @NotNull
    public static String a(@NotNull String str, @NotNull String str2) {
        return str.substring(5, str.length() - str2.length());
    }

    public void a(@NotNull GeoBone geoBone, @NotNull nE<?> nEVar, @NotNull AbstractC0376ny abstractC0376ny, float f) {
        int iA = InterfaceC0638xq.a(geoBone);
        a(geoBone, nEVar, iA, f);
        a(geoBone, abstractC0376ny, iA, f);
        a(geoBone, nEVar, f);
        geoBone.getChildBones().forEach(geoBone2 -> {
            a(geoBone2, (nE<?>) nEVar, abstractC0376ny, f);
        });
    }

    private void a(@NotNull GeoBone geoBone, @NotNull AbstractC0376ny abstractC0376ny, int i, float f) {
        if ((i & InterfaceC0638xq.tX) == 0) {
            return;
        }
        Object objM717a = abstractC0376ny.m741b().m717a(a(geoBone.getName(), "_barrel_main"));
        if (objM717a instanceof nL) {
            geoBone.setPosZ(((nL) objM717a).x(f));
        }
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
    private void a(@NotNull GeoBone geoBone, @NotNull nE<?> nEVar, int i, float f) {
        AbstractC0375nx<V> abstractC0375nx;
        if ((i & InterfaceC0638xq.uc) == 0 || (abstractC0375nx = nEVar.a) == 0) {
            return;
        }
        boolean z = (i & InterfaceC0638xq.ud) != 0;
        if ((i & InterfaceC0638xq.ue) != 0) {
            geoBone.setRotX(abstractC0375nx.r(f));
            if (z) {
                geoBone.setRotY((-abstractC0375nx.t(f)) * 0.2f);
                return;
            }
            return;
        }
        if ((i & InterfaceC0638xq.uf) != 0) {
            geoBone.setRotX(-abstractC0375nx.s(f));
            if (z) {
                geoBone.setRotY((-abstractC0375nx.u(f)) * 0.2f);
            }
        }
    }

    private void a(@NotNull GeoBone geoBone, @NotNull nE<?> nEVar, float f) {
        String name = geoBone.getName();
        Iterator it = nEVar.ak.iterator();
        while (it.hasNext()) {
            nN nNVar = (nN) it.next();
            if (name.equals("part_" + nNVar.bD)) {
                geoBone.setRotY((-nNVar.w(f)) * 0.017453292f);
                for (GeoBone geoBone2 : geoBone.getChildBones()) {
                    if ((InterfaceC0638xq.a(geoBone2) & InterfaceC0638xq.ug) != 0 && nNVar.b() != null) {
                        geoBone2.setRotX((-Mth.clamp(nNVar.b().getViewXRot(f), -15.0f, 10.0f)) * 0.017453292f);
                    }
                }
            }
        }
    }

    public void a(@NotNull GeoBone geoBone, float f, float f2) {
        int iA = InterfaceC0638xq.a(geoBone);
        float f3 = 0.0f;
        if ((iA & InterfaceC0638xq.tZ) != 0) {
            f3 = f2;
        }
        if ((iA & 1572864) != 0) {
            f3 = f;
        }
        if (f3 != 0.0f) {
            geoBone.setRotY((-f3) * 0.017453292f);
        }
        geoBone.getChildBones().forEach(geoBone2 -> {
            a(geoBone2, f, f2);
        });
    }

    private boolean a(@NotNull T t, @Nullable AbstractC0376ny abstractC0376ny, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull MultiBufferSource multiBufferSource, int i, float f) {
        if ((InterfaceC0638xq.a(geoBone) & InterfaceC0638xq.tY) == 0) {
            return false;
        }
        String strA = a(geoBone.getName(), "_muzzleflash");
        float fAg = t.ag();
        if (abstractC0376ny != null) {
            Object objM717a = abstractC0376ny.m741b().m717a(strA);
            if (objM717a instanceof nL) {
                fAg = ((nL) objM717a).aP();
            }
        }
        if (fAg > 0.0f) {
            a(poseStack, geoBone, t, multiBufferSource, f, i);
            return true;
        }
        return true;
    }

    private void a(@NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull T t, @NotNull MultiBufferSource multiBufferSource, float f, int i) {
        RenderType renderTypeBeaconBeam = RenderType.beaconBeam((ResourceLocation) C0198hh.O.getFirst(), true);
        super.renderRecursively(poseStack, t, geoBone, renderTypeBeaconBeam, multiBufferSource, multiBufferSource.getBuffer(renderTypeBeaconBeam), false, f, 15728880, i, ColorReferences.COLOR_WHITE_SOLID);
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void renderRecursively(PoseStack poseStack, T t, GeoBone geoBone, RenderType renderType, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        if (a(t, t.a(), poseStack, geoBone, multiBufferSource, i2, f)) {
            return;
        }
        if ((InterfaceC0638xq.a(geoBone) & InterfaceC0638xq.uh) != 0) {
            i = 15728880;
        }
        super.renderRecursively(poseStack, t, geoBone, renderType, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
    }

    public int getViewDistance() {
        return 256;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean shouldRender(@NotNull lN lNVar, @NotNull Vec3 vec3) {
        return Vec3.atCenterOf(lNVar.getBlockPos()).closerThan(vec3, 256.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public AABB getRenderBoundingBox(@NotNull T t) {
        return super.getRenderBoundingBox(t).inflate(t.an() ? 512 : this.jb);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean shouldRenderOffScreen(@NotNull lN lNVar) {
        return false;
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public long getInstanceId(@NotNull T t) {
        return t.a() != null ? t.a().getId() : t.getBlockState().getBlock().hashCode();
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void preRender(PoseStack poseStack, T t, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        super.preRender(poseStack, t, bakedGeoModel, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        List<GeoBone> list = bakedGeoModel.topLevelBones();
        AbstractC0376ny abstractC0376nyA = t.a();
        if (abstractC0376nyA != null) {
            nE<AbstractC0376ny> nEVarM741b = abstractC0376nyA.m741b();
            Iterator<GeoBone> it = list.iterator();
            while (it.hasNext()) {
                Iterator<GeoBone> it2 = it.next().getChildBones().iterator();
                while (it2.hasNext()) {
                    a(it2.next(), nEVarM741b, abstractC0376nyA, f);
                }
            }
        }
        BlockState blockState = t.getBlockState();
        float fIntValue = 45.0f * ((Integer) blockState.getValue(b)).intValue();
        float fIntValue2 = 45.0f * ((Integer) blockState.getValue(a)).intValue();
        Iterator<GeoBone> it3 = list.iterator();
        while (it3.hasNext()) {
            Iterator<GeoBone> it4 = it3.next().getChildBones().iterator();
            while (it4.hasNext()) {
                a(it4.next(), fIntValue, fIntValue2);
            }
        }
    }
}
