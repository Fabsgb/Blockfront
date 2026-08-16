package com.boehmod.blockfront;

import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.C0712mj;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.gJ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/gJ.class */
public class C0368gJ<T extends C0712mj & GeoAnimatable> extends AbstractC0367gI<T> {

    /* JADX INFO: renamed from: a */
    @NotNull
    private static final IntegerProperty f2508a = C0649lZ.f3653k;

    /* JADX INFO: renamed from: b */
    @NotNull
    private static final IntegerProperty f2509b = C0649lZ.f3654l;

    /* JADX INFO: renamed from: ku */
    private static final int f2510ku = 256;

    /* JADX INFO: renamed from: kv */
    private static final int f2511kv = 512;

    /* JADX INFO: renamed from: kw */
    private int f2512kw;

    public C0368gJ(@NotNull BlockEntityRendererProvider.Context context) {
        this(new C0275eW());
    }

    public C0368gJ(@NotNull GeoModel<T> geoModel) {
        super(geoModel);
        this.f2512kw = 5;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public C0368gJ<T> m1763a(int i) {
        this.f2512kw = i;
        return this;
    }

    @Override // com.boehmod.blockfront.AbstractC0367gI
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean mo1744a(@NotNull C0712mj c0712mj) {
        return !c0712mj.mo3235aw();
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public static String m1765a(@NotNull String str, @NotNull String str2) {
        return str.substring(5, str.length() - str2.length());
    }

    /* JADX INFO: renamed from: a */
    public void m1766a(@NotNull GeoBone geoBone, @NotNull C0809oa<?> c0809oa, @NotNull AbstractC0750nU abstractC0750nU, float f) {
        int iM7246a = InterfaceC1274xN.m7246a(geoBone);
        m1768a(geoBone, c0809oa, iM7246a, f);
        m1767a(geoBone, abstractC0750nU, iM7246a, f);
        m1769a(geoBone, c0809oa, f);
        geoBone.getChildBones().forEach(geoBone2 -> {
            m1766a(geoBone2, (C0809oa<?>) c0809oa, abstractC0750nU, f);
        });
    }

    /* JADX INFO: renamed from: a */
    private void m1767a(@NotNull GeoBone geoBone, @NotNull AbstractC0750nU abstractC0750nU, int i, float f) {
        if ((i & InterfaceC1274xN.f6859wb) == 0) {
            return;
        }
        Object objM3732a = abstractC0750nU.m3436b().m3732a(m1765a(geoBone.getName(), "_barrel_main"));
        if (objM3732a instanceof C0816oh) {
            geoBone.setPosZ(((C0816oh) objM3732a).m3772A(f));
        }
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
    private void m1768a(@NotNull GeoBone geoBone, @NotNull C0809oa<?> c0809oa, int i, float f) {
        AbstractC0749nT<V> abstractC0749nT;
        if ((i & InterfaceC1274xN.f6864wg) == 0 || (abstractC0749nT = c0809oa.f4370a) == 0) {
            return;
        }
        boolean z = (i & InterfaceC1274xN.f6865wh) != 0;
        if ((i & InterfaceC1274xN.f6866wi) != 0) {
            geoBone.setRotX(abstractC0749nT.m3413u(f));
            if (z) {
                geoBone.setRotY((-abstractC0749nT.m3415w(f)) * 0.2f);
                return;
            }
            return;
        }
        if ((i & InterfaceC1274xN.f6867wj) != 0) {
            geoBone.setRotX(-abstractC0749nT.m3414v(f));
            if (z) {
                geoBone.setRotY((-abstractC0749nT.m3416x(f)) * 0.2f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1769a(@NotNull GeoBone geoBone, @NotNull C0809oa<?> c0809oa, float f) {
        String name = geoBone.getName();
        Iterator it = c0809oa.f4373ar.iterator();
        while (it.hasNext()) {
            AbstractC0818oj abstractC0818oj = (AbstractC0818oj) it.next();
            if (name.equals("part_" + abstractC0818oj.f4434bM)) {
                geoBone.setRotY((-abstractC0818oj.mo3770z(f)) * 0.017453292f);
                for (GeoBone geoBone2 : geoBone.getChildBones()) {
                    if ((InterfaceC1274xN.m7246a(geoBone2) & InterfaceC1274xN.f6868wk) != 0 && abstractC0818oj.m3782b() != null) {
                        geoBone2.setRotX((-Mth.clamp(abstractC0818oj.m3782b().getViewXRot(f), -15.0f, 10.0f)) * 0.017453292f);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1770a(@NotNull GeoBone geoBone, float f, float f2) {
        int iM7246a = InterfaceC1274xN.m7246a(geoBone);
        float f3 = 0.0f;
        if ((iM7246a & InterfaceC1274xN.f6861wd) != 0) {
            f3 = f2;
        }
        if ((iM7246a & 1572864) != 0) {
            f3 = f;
        }
        if (f3 != 0.0f) {
            geoBone.setRotY((-f3) * 0.017453292f);
        }
        geoBone.getChildBones().forEach(geoBone2 -> {
            m1770a(geoBone2, f, f2);
        });
    }

    /* JADX INFO: renamed from: a */
    private boolean m1771a(@NotNull T t, @Nullable AbstractC0750nU abstractC0750nU, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull MultiBufferSource multiBufferSource, int i, float f) {
        if ((InterfaceC1274xN.m7246a(geoBone) & InterfaceC1274xN.f6860wc) == 0) {
            return false;
        }
        String strM1765a = m1765a(geoBone.getName(), "_muzzleflash");
        float fM3249am = t.m3249am();
        if (abstractC0750nU != null) {
            Object objM3732a = abstractC0750nU.m3436b().m3732a(strM1765a);
            if (objM3732a instanceof C0816oh) {
                fM3249am = ((C0816oh) objM3732a).m3765be();
            }
        }
        if (fM3249am > 0.0f) {
            m1772a(poseStack, geoBone, t, multiBufferSource, f, i);
            return true;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m1772a(@NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull T t, @NotNull MultiBufferSource multiBufferSource, float f, int i) {
        RenderType renderTypeBeaconBeam = RenderType.beaconBeam((ResourceLocation) C0461hx.f2880R.getFirst(), true);
        super.renderRecursively(poseStack, t, geoBone, renderTypeBeaconBeam, multiBufferSource, multiBufferSource.getBuffer(renderTypeBeaconBeam), false, f, 15728880, i, ColorReferences.COLOR_WHITE_SOLID);
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void renderRecursively(PoseStack poseStack, T t, GeoBone geoBone, RenderType renderType, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        if (m1771a(t, t.m3239a(), poseStack, geoBone, multiBufferSource, i2, f)) {
            return;
        }
        if ((InterfaceC1274xN.m7246a(geoBone) & InterfaceC1274xN.f6869wl) != 0) {
            i = 15728880;
        }
        super.renderRecursively(poseStack, t, geoBone, renderType, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
    }

    public int getViewDistance() {
        return 256;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean shouldRender(@NotNull C0712mj c0712mj, @NotNull Vec3 vec3) {
        return Vec3.atCenterOf(c0712mj.getBlockPos()).closerThan(vec3, 256.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public AABB getRenderBoundingBox(@NotNull T t) {
        return super.getRenderBoundingBox(t).inflate(t.m3238ax() ? 512 : this.f2512kw);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean shouldRenderOffScreen(@NotNull C0712mj c0712mj) {
        return false;
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public long getInstanceId(@NotNull T t) {
        return t.m3239a() != null ? t.m3239a().getId() : t.getBlockState().getBlock().hashCode();
    }

    @Override // software.bernie.geckolib.renderer.GeoBlockRenderer, software.bernie.geckolib.renderer.GeoRenderer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void preRender(PoseStack poseStack, T t, BakedGeoModel bakedGeoModel, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        super.preRender(poseStack, t, bakedGeoModel, multiBufferSource, vertexConsumer, z, f, i, i2, i3);
        List<GeoBone> list = bakedGeoModel.topLevelBones();
        AbstractC0750nU abstractC0750nUM3239a = t.m3239a();
        if (abstractC0750nUM3239a != null) {
            C0809oa<AbstractC0750nU> c0809oaM3436b = abstractC0750nUM3239a.m3436b();
            Iterator<GeoBone> it = list.iterator();
            while (it.hasNext()) {
                Iterator<GeoBone> it2 = it.next().getChildBones().iterator();
                while (it2.hasNext()) {
                    m1766a(it2.next(), c0809oaM3436b, abstractC0750nUM3239a, f);
                }
            }
        }
        BlockState blockState = t.getBlockState();
        float fIntValue = 45.0f * ((Integer) blockState.getValue(f2509b)).intValue();
        float fIntValue2 = 45.0f * ((Integer) blockState.getValue(f2508a)).intValue();
        Iterator<GeoBone> it3 = list.iterator();
        while (it3.hasNext()) {
            Iterator<GeoBone> it4 = it3.next().getChildBones().iterator();
            while (it4.hasNext()) {
                m1770a(it4.next(), fIntValue, fIntValue2);
            }
        }
    }
}
