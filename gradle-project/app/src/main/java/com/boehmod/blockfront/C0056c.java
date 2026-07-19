package com.boehmod.blockfront;

import com.boehmod.blockfront.C0534tu;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.Holder;
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
import net.neoforged.neoforge.client.event.RegisterShadersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/c.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0056c {
    @Nullable
    public static C0297l a() {
        return (C0297l) C0002a.a().m166a();
    }

    public static void a(@NotNull C0002a c0002a, @NotNull FMLClientSetupEvent fMLClientSetupEvent) {
        C0297l c0297l = new C0297l(Minecraft.getInstance());
        c0002a.a(c0297l);
        fMLClientSetupEvent.enqueueWork(() -> {
            a(c0297l);
        });
    }

    public static void a(@Nonnull RegisterClientExtensionsEvent registerClientExtensionsEvent) {
        registerClientExtensionsEvent.registerItem(new C0534tu.a(), new Holder[]{wY.y});
    }

    public static void a(@NotNull RegisterDimensionSpecialEffectsEvent registerDimensionSpecialEffectsEvent) {
        C0263jt.log("Registering dimension special effects...", new Object[0]);
        registerDimensionSpecialEffectsEvent.register(BuiltinDimensionTypes.OVERWORLD_EFFECTS, new Y());
        C0263jt.log("Dimension special effects registration complete!", new Object[0]);
    }

    public static void a(@NotNull RegisterColorHandlersEvent.Block block) {
        block.register((blockState, blockAndTintGetter, blockPos, i) -> {
            if (blockAndTintGetter != null && blockPos != null) {
                return BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos);
            }
            return FoliageColor.getDefaultColor();
        }, (Block[]) ((Set) lK.K.stream().filter(lKVar -> {
            return lKVar.dU;
        }).map(lKVar2 -> {
            return (Block) ((DeferredHolder) Objects.requireNonNull(lKVar2.X)).get();
        }).collect(Collectors.toSet())).toArray(new Block[0]));
    }

    public static void a(@NotNull RegisterColorHandlersEvent.Item item) {
        item.register((itemStack, i) -> {
            return FoliageColor.getDefaultColor();
        }, (ItemLike[]) ((Set) lK.K.stream().filter(lKVar -> {
            return lKVar.dU;
        }).map(lKVar2 -> {
            return (Block) ((DeferredHolder) Objects.requireNonNull(lKVar2.X)).get();
        }).collect(Collectors.toSet())).toArray(new Block[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NotNull C0297l c0297l) {
        C0263jt.log("Entering client setup procedure...", new Object[0]);
        wG.dC();
        hQ.e(c0297l);
        hQ.d(c0297l);
        wO.dF();
        C0263jt.log("Client setup procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    public static void a(@NotNull EntityRenderersEvent.RegisterRenderers registerRenderers) {
        C0263jt.log("Entering client renderer registry procedure...", new Object[0]);
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        registerRenderers.registerEntityRenderer((EntityType) wX.kJ.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kK.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kL.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kM.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kN.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kO.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kP.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kQ.get(), context -> {
            return new C0173gj(context, itemRenderer, wY.p);
        });
        registerRenderers.registerEntityRenderer((EntityType) wX.kR.get(), context2 -> {
            return new C0186gw(context2, itemRenderer, wY.q);
        });
        registerRenderers.registerEntityRenderer((EntityType) wX.kS.get(), context3 -> {
            return new C0188gy(context3, itemRenderer, wY.t);
        });
        registerRenderers.registerEntityRenderer((EntityType) wX.kU.get(), gQ::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kV.get(), gR::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kX.get(), gQ::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kY.get(), gQ::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kZ.get(), gQ::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kW.get(), gP::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.la.get(), gQ::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kC.get(), context4 -> {
            return new C0187gx(context4, itemRenderer);
        });
        registerRenderers.registerEntityRenderer((EntityType) wX.kB.get(), gH::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kT.get(), context5 -> {
            return new gO(context5, itemRenderer);
        });
        registerRenderers.registerEntityRenderer((EntityType) wX.lb.get(), gA::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kF.get(), C0189gz::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lc.get(), gC::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kD.get(), gE::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.ld.get(), gB::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.le.get(), gC::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lf.get(), gC::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kE.get(), gF::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kG.get(), gM::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kH.get(), gM::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.kI.get(), gD::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lt.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lm.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.ln.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lq.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lr.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lg.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.li.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lj.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lk.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.ll.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.ls.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lu.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lh.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lo.get(), gU::new);
        registerRenderers.registerEntityRenderer((EntityType) wX.lp.get(), gU::new);
        Iterator<DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends lP>>> it = wJ.as.values().iterator();
        while (it.hasNext()) {
            registerRenderers.registerBlockEntityRenderer((BlockEntityType) it.next().get(), C0177gn::new);
        }
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bI.get(), C0176gm::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bJ.get(), C0175gl::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bK.get(), C0179gp::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bU.get(), C0174gk::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cB.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cC.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cD.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cE.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bY.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.ca.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cb.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cc.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cd.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.ce.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cg.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.ch.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.ci.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cj.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cm.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cn.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.co.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cp.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cq.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cr.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cs.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.ct.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cu.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cv.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cw.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cx.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cA.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.ck.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cl.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cF.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cG.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bZ.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cf.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cy.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cz.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cI.get(), context6 -> {
            return new C0183gt(context6).a(15);
        });
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.cH.get(), C0174gk::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bL.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bM.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bN.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bO.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bP.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bQ.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bR.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bS.get(), C0183gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) wJ.bT.get(), C0183gt::new);
        C0263jt.log("Client renderer registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    public static void a(@NotNull EntityRenderersEvent.RegisterLayerDefinitions registerLayerDefinitions) {
        C0263jt.log("Entering client renderer layers registry procedure...", new Object[0]);
        wN.b(registerLayerDefinitions);
        C0263jt.log("Client renderer layers registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    public static void a(@NotNull RegisterGuiLayersEvent registerGuiLayersEvent) {
        C0263jt.log("Entering overlays registry procedure...", new Object[0]);
        registerGuiLayersEvent.registerBelowAll(C0265jv.d("mod_weather_overlay"), new C0073cq());
        registerGuiLayersEvent.registerBelowAll(C0265jv.d("mod_health_effects"), new C0069cm());
        registerGuiLayersEvent.registerBelowAll(C0265jv.d("mod_vehicle"), new C0072cp());
        registerGuiLayersEvent.registerBelowAll(C0265jv.d("mod_equipment"), new C0068cl());
        registerGuiLayersEvent.registerAboveAll(C0265jv.d("mod_crosshair"), new C0067ck());
        registerGuiLayersEvent.registerAboveAll(C0265jv.d("mod_client_game"), new C0066cj());
        registerGuiLayersEvent.registerAboveAll(C0265jv.d("mod_vanilla_ammo"), new C0071co());
        C0263jt.log("Client overlays registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    public static void a(@NotNull RegisterClientReloadListenersEvent registerClientReloadListenersEvent) {
        C0263jt.log("Entering reload listener registry procedure...", new Object[0]);
        wP.b(registerClientReloadListenersEvent);
        C0263jt.log("Reload listener registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    public static void a(@NotNull RegisterKeyMappingsEvent registerKeyMappingsEvent) {
        C0263jt.log("Entering key mappings registry procedure...", new Object[0]);
        wM.b(registerKeyMappingsEvent);
        C0263jt.log("Client key mappings registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    public static void a(@NotNull RegisterParticleProvidersEvent registerParticleProvidersEvent) {
        C0263jt.log("Entering particle providers registry procedure...", new Object[0]);
        wQ.b(registerParticleProvidersEvent);
        C0263jt.log("Client particle providers registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    public static void a(@NotNull RegisterShadersEvent registerShadersEvent) throws IOException {
        C0263jt.log("Entering shaders registry procedure...", new Object[0]);
        C0623xb.c(registerShadersEvent);
        C0263jt.log("Client shaders registry procedure complete!", new Object[0]);
    }
}
