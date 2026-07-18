package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0636lN;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.gt */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/gt.class */
public class C0403gt<T extends C0636lN & GeoAnimatable> extends AbstractC0402gs<T> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final IntegerProperty f2607a = C0626lD.f3399k;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final IntegerProperty f2608b = C0626lD.f3400l;

    /* JADX INFO: renamed from: iZ */
    private static final int f2609iZ = 256;

    /* JADX INFO: renamed from: ja */
    private static final int f2610ja = 512;

    /* JADX INFO: renamed from: jb */
    private int f2611jb;

    public C0403gt(@NotNull BlockEntityRendererProvider.Context context) {
        this(new C0261eJ());
    }

    public C0403gt(@NotNull GeoModel<T> geoModel) {
        super(geoModel);
        this.f2611jb = 5;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0403gt<T> m1906a(int i) {
        this.f2611jb = i;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0402gs
    /* JADX INFO: renamed from: R */
    public boolean mo1890R() {
        Minecraft minecraft = Minecraft.getInstance();
        return minecraft.player != null && minecraft.player.isCreative();
    }

    @Override // com.boehmod.blockfront.AbstractC0402gs
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean mo1889a(@NotNull C0636lN c0636lN) {
        return !c0636lN.mo2804am();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m1908a(@NotNull String str, @NotNull String str2) {
        return str.substring(5, str.length() - str2.length());
    }

    /* JADX INFO: renamed from: a */
    public void m1909a(@NotNull GeoBone geoBone, @NotNull C0733nE<?> c0733nE, @NotNull AbstractC0779ny abstractC0779ny, float f) {
        int iM7919a = InterfaceC1294xq.m7919a(geoBone);
        m1911a(geoBone, c0733nE, iM7919a, f);
        m1910a(geoBone, abstractC0779ny, iM7919a, f);
        m1912a(geoBone, c0733nE, f);
        geoBone.getChildBones().forEach(geoBone2 -> {
            m1909a(geoBone2, (C0733nE<?>) c0733nE, abstractC0779ny, f);
        });
    }

    /* JADX INFO: renamed from: a */
    private void m1910a(@NotNull GeoBone geoBone, @NotNull AbstractC0779ny abstractC0779ny, int i, float f) {
        if ((i & InterfaceC1294xq.f8662tX) == 0) {
            return;
        }
        Object objM3354a = abstractC0779ny.m3499b().m3354a(m1908a(geoBone.getName(), "_barrel_main"));
        if (objM3354a instanceof C0740nL) {
            geoBone.setPosZ(((C0740nL) objM3354a).m3400x(f));
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
    /* JADX INFO: renamed from: a */
    private void m1911a(@NotNull GeoBone geoBone, @NotNull C0733nE<?> c0733nE, int i, float f) {
        AbstractC0778nx<V> abstractC0778nx;
        if ((i & InterfaceC1294xq.f8667uc) == 0 || (abstractC0778nx = c0733nE.f3942a) == 0) {
            return;
        }
        boolean z = (i & InterfaceC1294xq.f8668ud) != 0;
        if ((i & InterfaceC1294xq.f8669ue) != 0) {
            geoBone.setRotX(abstractC0778nx.m3486r(f));
            if (z) {
                geoBone.setRotY((-abstractC0778nx.m3488t(f)) * 0.2f);
                return;
            }
            return;
        }
        if ((i & InterfaceC1294xq.f8670uf) != 0) {
            geoBone.setRotX(-abstractC0778nx.m3487s(f));
            if (z) {
                geoBone.setRotY((-abstractC0778nx.m3489u(f)) * 0.2f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1912a(@NotNull GeoBone geoBone, @NotNull C0733nE<?> c0733nE, float f) {
        String name = geoBone.getName();
        Iterator it = c0733nE.f3945ak.iterator();
        while (it.hasNext()) {
            AbstractC0742nN abstractC0742nN = (AbstractC0742nN) it.next();
            if (name.equals("part_" + abstractC0742nN.f4006bD)) {
                geoBone.setRotY((-abstractC0742nN.mo3398w(f)) * 0.017453292f);
                for (GeoBone geoBone2 : geoBone.getChildBones()) {
                    if ((InterfaceC1294xq.m7919a(geoBone2) & InterfaceC1294xq.f8671ug) != 0 && abstractC0742nN.m3410b() != null) {
                        geoBone2.setRotX((-Mth.clamp(abstractC0742nN.m3410b().getViewXRot(f), -15.0f, 10.0f)) * 0.017453292f);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1913a(@NotNull GeoBone geoBone, float f, float f2) {
        int iM7919a = InterfaceC1294xq.m7919a(geoBone);
        float f3 = 0.0f;
        if ((iM7919a & InterfaceC1294xq.f8664tZ) != 0) {
            f3 = f2;
        }
        if ((iM7919a & 1572864) != 0) {
            f3 = f;
        }
        if (f3 != 0.0f) {
            geoBone.setRotY((-f3) * 0.017453292f);
        }
        geoBone.getChildBones().forEach(geoBone2 -> {
            m1913a(geoBone2, f, f2);
        });
    }

    /* JADX INFO: renamed from: a */
    private boolean m1914a(@NotNull T t, @Nullable AbstractC0779ny abstractC0779ny, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull MultiBufferSource multiBufferSource, int i, float f) {
        if ((InterfaceC1294xq.m7919a(geoBone) & InterfaceC1294xq.f8663tY) == 0) {
            return false;
        }
        String strM1908a = m1908a(geoBone.getName(), "_muzzleflash");
        float fM2818ag = t.m2818ag();
        if (abstractC0779ny != null) {
            Object objM3354a = abstractC0779ny.m3499b().m3354a(strM1908a);
            if (objM3354a instanceof C0740nL) {
                fM2818ag = ((C0740nL) objM3354a).m3393aP();
            }
        }
        if (fM2818ag > 0.0f) {
            m1915a(poseStack, geoBone, t, multiBufferSource, f, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m1915a(@NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull T t, @NotNull MultiBufferSource multiBufferSource, float f, int i) {
        RenderType renderTypeBeaconBeam = RenderType.beaconBeam((ResourceLocation) C0444hh.f2828O.getFirst(), true);
        super.renderRecursively(poseStack, t, geoBone, renderTypeBeaconBeam, multiBufferSource, multiBufferSource.getBuffer(renderTypeBeaconBeam), false, f, 15728880, i, ColorReferences.COLOR_WHITE_SOLID);
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void renderRecursively(PoseStack poseStack, T t, GeoBone geoBone, RenderType renderType, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        if (m1914a(t, t.m2808a(), poseStack, geoBone, multiBufferSource, i2, f)) {
            return;
        }
        if ((InterfaceC1294xq.m7919a(geoBone) & InterfaceC1294xq.f8672uh) != 0) {
            i = 15728880;
        }
        super.renderRecursively(poseStack, t, geoBone, renderType, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
    }

    public int getViewDistance() {
        return 256;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean shouldRender(@NotNull C0636lN c0636lN, @NotNull Vec3 vec3) {
        return Vec3.atCenterOf(c0636lN.getBlockPos()).closerThan(vec3, 256.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AABB getRenderBoundingBox(@NotNull T t) {
        return super.getRenderBoundingBox(t).inflate(t.m2807an() ? 512 : this.f2611jb);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean shouldRenderOffScreen(@NotNull C0636lN c0636lN) {
        return false;
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getInstanceId(@NotNull T t) {
        return t.m2808a() != null ? t.m2808a().getId() : t.getBlockState().getBlock().hashCode();
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void preRender(PoseStack poseStack, T t, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        super.preRender(poseStack, t, bakedGeoModel, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        List<GeoBone> list = bakedGeoModel.topLevelBones();
        AbstractC0779ny abstractC0779nyM2808a = t.m2808a();
        if (abstractC0779nyM2808a != null) {
            C0733nE<AbstractC0779ny> c0733nEM3499b = abstractC0779nyM2808a.m3499b();
            Iterator<GeoBone> it = list.iterator();
            while (it.hasNext()) {
                Iterator<GeoBone> it2 = it.next().getChildBones().iterator();
                while (it2.hasNext()) {
                    m1909a(it2.next(), c0733nEM3499b, abstractC0779nyM2808a, f);
                }
            }
        }
        BlockState blockState = t.getBlockState();
        float fIntValue = 45.0f * ((Integer) blockState.getValue(f2608b)).intValue();
        float fIntValue2 = 45.0f * ((Integer) blockState.getValue(f2607a)).intValue();
        Iterator<GeoBone> it3 = list.iterator();
        while (it3.hasNext()) {
            Iterator<GeoBone> it4 = it3.next().getChildBones().iterator();
            while (it4.hasNext()) {
                m1913a(it4.next(), fIntValue, fIntValue2);
            }
        }
    }
}
