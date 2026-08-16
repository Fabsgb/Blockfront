package com.boehmod.blockfront;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.event.RegisterRenderBuffersEvent;
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.GeckoLibServices;

/* JADX INFO: renamed from: com.boehmod.blockfront.c */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/c.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0136c {
    @Nullable
    /* JADX INFO: renamed from: a */
    public static C0623l m740a() {
        return (C0623l) C0030a.m175a().m179a();
    }

    /* JADX INFO: renamed from: a */
    public static void m741a(@NotNull C0030a c0030a, @NotNull FMLClientSetupEvent fMLClientSetupEvent) {
        Thread threadCurrentThread = Thread.currentThread();
        ClassLoader contextClassLoader = threadCurrentThread.getContextClassLoader();
        threadCurrentThread.setContextClassLoader(GeckoLibServices.class.getClassLoader());
        try {
            Objects.requireNonNull(GeckoLibServices.Client.EVENTS);
            threadCurrentThread.setContextClassLoader(contextClassLoader);
            C0623l c0623l = new C0623l(Minecraft.getInstance());
            c0030a.m180a(c0623l);
            fMLClientSetupEvent.enqueueWork(() -> {
                m746a(c0623l);
            });
        } catch (Throwable th) {
            threadCurrentThread.setContextClassLoader(contextClassLoader);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m742a(@Nonnull RegisterClientExtensionsEvent registerClientExtensionsEvent) {
        registerClientExtensionsEvent.registerItem(new C1067tS.a(), new Holder[]{C1308xv.f7693y});
    }

    /* JADX INFO: renamed from: a */
    public static void m743a(@NotNull RegisterDimensionSpecialEffectsEvent registerDimensionSpecialEffectsEvent) {
        C0530jM.log("Registering dimension special effects...", new Object[0]);
        registerDimensionSpecialEffectsEvent.register(BuiltinDimensionTypes.OVERWORLD_EFFECTS, new C0061ae());
        C0530jM.log("Dimension special effects registration complete!", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m744a(@NotNull RegisterColorHandlersEvent.Block block) {
        block.register((blockState, blockAndTintGetter, blockPos, i) -> {
            if (blockAndTintGetter != null && blockPos != null) {
                return BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos);
            }
            return FoliageColor.getDefaultColor();
        }, (Block[]) ((Set) C0709mg.f3937T.stream().filter(c0709mg -> {
            return c0709mg.f3938en;
        }).map(c0709mg2 -> {
            return (Block) ((DeferredHolder) Objects.requireNonNull(c0709mg2.f3949X)).get();
        }).collect(Collectors.toSet())).toArray(new Block[0]));
    }

    /* JADX INFO: renamed from: a */
    public static void m745a(@NotNull RegisterColorHandlersEvent.Item item) {
        item.register((itemStack, i) -> {
            return FoliageColor.getDefaultColor();
        }, (ItemLike[]) ((Set) C0709mg.f3937T.stream().filter(c0709mg -> {
            return c0709mg.f3938en;
        }).map(c0709mg2 -> {
            return (Block) ((DeferredHolder) Objects.requireNonNull(c0709mg2.f3949X)).get();
        }).collect(Collectors.toSet())).toArray(new Block[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static void m746a(@NotNull C0623l c0623l) {
        C0530jM.log("Entering client setup procedure...", new Object[0]);
        C1290xd.m7322dM();
        C0498ih.m2239f(c0623l);
        C0498ih.m2238e(c0623l);
        C1298xl.m7872dP();
        C0530jM.log("Client setup procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m747a(@NotNull EntityRenderersEvent.RegisterRenderers registerRenderers) {
        C0530jM.log("Entering client renderer registry procedure...", new Object[0]);
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7605kJ.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7606kK.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7607kL.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7608kM.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7609kN.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7610kO.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7611kP.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7612kQ.get(), context -> {
            return new C0410gz(context, itemRenderer, C1308xv.f7684p);
        });
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7613kR.get(), context2 -> {
            return new C0371gM(context2, itemRenderer, C1308xv.f7685q);
        });
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7614kS.get(), context3 -> {
            return new C0373gO(context3, itemRenderer, C1308xv.f7688t);
        });
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7616kU.get(), C0444hg::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7617kV.get(), C0445hh::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7619kX.get(), C0444hg::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7620kY.get(), C0444hg::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7621kZ.get(), C0444hg::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7618kW.get(), C0443hf::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7622la.get(), C0444hg::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7595kC.get(), context4 -> {
            return new C0372gN(context4, itemRenderer);
        });
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7594kB.get(), C0382gX::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7615kT.get(), context5 -> {
            return new C0442he(context5, itemRenderer);
        });
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7624lb.get(), C0375gQ::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7600kF.get(), C0374gP::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7625lc.get(), C0377gS::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7596kD.get(), C0379gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7626ld.get(), C0376gR::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7627le.get(), C0377gS::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7628lf.get(), C0377gS::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7597kE.get(), C0380gV::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7601kG.get(), C0440hc::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7602kH.get(), C0440hc::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7603kI.get(), C0378gT::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7644lt.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7637lm.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7638ln.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7641lq.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7642lr.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7631lg.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7633li.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7634lj.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7635lk.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7636ll.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7643ls.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7645lu.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7632lh.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7639lo.get(), C0448hk::new);
        registerRenderers.registerEntityRenderer((EntityType) C1307xu.f7640lp.get(), C0448hk::new);
        Iterator<DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends C0714ml>>> it = C1293xg.f6931as.values().iterator();
        while (it.hasNext()) {
            registerRenderers.registerBlockEntityRenderer((BlockEntityType) it.next().get(), C0362gD::new);
        }
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6932bI.get(), C0361gC::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6933bJ.get(), C0360gB::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6934bK.get(), C0364gF::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6944bU.get(), C0359gA::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6977cB.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6978cC.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6979cD.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6980cE.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6948bY.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6950ca.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6951cb.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6952cc.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6953cd.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6954ce.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6956cg.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6957ch.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6958ci.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6959cj.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6962cm.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6963cn.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6964co.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6965cp.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6966cq.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6967cr.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6968cs.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6969ct.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6970cu.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6971cv.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6972cw.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6973cx.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6976cA.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6960ck.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6961cl.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6981cF.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6982cG.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6949bZ.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6955cf.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6974cy.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6975cz.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6984cI.get(), context6 -> {
            return new C0368gJ(context6).m1763a(15);
        });
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6983cH.get(), C0359gA::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6935bL.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6936bM.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6937bN.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6938bO.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6939bP.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6940bQ.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6941bR.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6942bS.get(), C0368gJ::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1293xg.f6943bT.get(), C0368gJ::new);
        C0530jM.log("Client renderer registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m748a(@NotNull RegisterRenderBuffersEvent registerRenderBuffersEvent) {
        for (ResourceLocation resourceLocation : C0414hC.f2675c) {
            registerRenderBuffersEvent.registerRenderBuffer(RenderType.entityCutoutNoCull(resourceLocation));
        }
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m749a(@NotNull EntityRenderersEvent.RegisterLayerDefinitions registerLayerDefinitions) {
        C0530jM.log("Entering client renderer layers registry procedure...", new Object[0]);
        C1297xk.m7866b(registerLayerDefinitions);
        C0530jM.log("Client renderer layers registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m750a(@NotNull RegisterGuiLayersEvent registerGuiLayersEvent) {
        C0530jM.log("Entering overlays registry procedure...", new Object[0]);
        registerGuiLayersEvent.registerBelowAll(C0532jO.m2378d("mod_weather_overlay"), new C0198cz());
        registerGuiLayersEvent.registerBelowAll(C0532jO.m2378d("mod_health_effects"), new C0194cv());
        registerGuiLayersEvent.registerBelowAll(C0532jO.m2378d("mod_vehicle"), new C0197cy());
        registerGuiLayersEvent.registerBelowAll(C0532jO.m2378d("mod_equipment"), new C0193cu());
        registerGuiLayersEvent.registerAboveAll(C0532jO.m2378d("mod_crosshair"), new C0192ct());
        registerGuiLayersEvent.registerAboveAll(C0532jO.m2378d("mod_client_game"), new C0191cs());
        registerGuiLayersEvent.registerAboveAll(C0532jO.m2378d("mod_vanilla_ammo"), new C0196cx());
        C0530jM.log("Client overlays registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m751a(@NotNull RegisterClientReloadListenersEvent registerClientReloadListenersEvent) {
        C0530jM.log("Entering reload listener registry procedure...", new Object[0]);
        C1299xm.m7873b(registerClientReloadListenersEvent);
        C0530jM.log("Reload listener registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m752a(@NotNull RegisterKeyMappingsEvent registerKeyMappingsEvent) {
        C0530jM.log("Entering key mappings registry procedure...", new Object[0]);
        C1296xj.m7848b(registerKeyMappingsEvent);
        C0530jM.log("Client key mappings registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m753a(@NotNull RegisterParticleProvidersEvent registerParticleProvidersEvent) {
        C0530jM.log("Entering particle providers registry procedure...", new Object[0]);
        C1300xn.m7877b(registerParticleProvidersEvent);
        C0530jM.log("Client particle providers registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m754a(@NotNull RegisterShadersEvent registerShadersEvent) throws IOException {
        C0530jM.log("Entering shaders registry procedure...", new Object[0]);
        C1311xy.m8228c(registerShadersEvent);
        C0530jM.log("Client shaders registry procedure complete!", new Object[0]);
    }
}
