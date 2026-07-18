package com.boehmod.blockfront;

import com.boehmod.blockfront.C1094tu;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.c */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/c.class */
@EventBusSubscriber(modid = "bf", value = {Dist.CLIENT})
public class C0135c {
    @Nullable
    /* JADX INFO: renamed from: a */
    public static C0622l m716a() {
        return (C0622l) C0029a.m164a().m168a();
    }

    /* JADX INFO: renamed from: a */
    public static void m717a(@NotNull C0029a c0029a, @NotNull FMLClientSetupEvent fMLClientSetupEvent) {
        C0622l c0622l = new C0622l(Minecraft.getInstance());
        c0029a.m169a(c0622l);
        fMLClientSetupEvent.enqueueWork(() -> {
            m722a(c0622l);
        });
    }

    /* JADX INFO: renamed from: a */
    public static void m718a(@Nonnull RegisterClientExtensionsEvent registerClientExtensionsEvent) {
        registerClientExtensionsEvent.registerItem(new C1094tu.a(), new Holder[]{C1231wY.f7128y});
    }

    /* JADX INFO: renamed from: a */
    public static void m719a(@NotNull RegisterDimensionSpecialEffectsEvent registerDimensionSpecialEffectsEvent) {
        C0562jt.log("Registering dimension special effects...", new Object[0]);
        registerDimensionSpecialEffectsEvent.register(BuiltinDimensionTypes.OVERWORLD_EFFECTS, new C0027Y());
        C0562jt.log("Dimension special effects registration complete!", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m720a(@NotNull RegisterColorHandlersEvent.Block block) {
        block.register((blockState, blockAndTintGetter, blockPos, i) -> {
            if (blockAndTintGetter != null && blockPos != null) {
                return BiomeColors.getAverageFoliageColor(blockAndTintGetter, blockPos);
            }
            return FoliageColor.getDefaultColor();
        }, (Block[]) ((Set) C0633lK.f3463K.stream().filter(c0633lK -> {
            return c0633lK.f3464dU;
        }).map(c0633lK2 -> {
            return (Block) ((DeferredHolder) Objects.requireNonNull(c0633lK2.f3475X)).get();
        }).collect(Collectors.toSet())).toArray(new Block[0]));
    }

    /* JADX INFO: renamed from: a */
    public static void m721a(@NotNull RegisterColorHandlersEvent.Item item) {
        item.register((itemStack, i) -> {
            return FoliageColor.getDefaultColor();
        }, (ItemLike[]) ((Set) C0633lK.f3463K.stream().filter(c0633lK -> {
            return c0633lK.f3464dU;
        }).map(c0633lK2 -> {
            return (Block) ((DeferredHolder) Objects.requireNonNull(c0633lK2.f3475X)).get();
        }).collect(Collectors.toSet())).toArray(new Block[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public static void m722a(@NotNull C0622l c0622l) {
        C0562jt.log("Entering client setup procedure...", new Object[0]);
        C1213wG.m6734dC();
        C0427hQ.m2005e(c0622l);
        C0427hQ.m2004d(c0622l);
        C1221wO.m7285dF();
        C0562jt.log("Client setup procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m723a(@NotNull EntityRenderersEvent.RegisterRenderers registerRenderers) {
        C0562jt.log("Entering client renderer registry procedure...", new Object[0]);
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7040kJ.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7041kK.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7042kL.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7043kM.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7044kN.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7045kO.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7046kP.get(), ThrownItemRenderer::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7047kQ.get(), context -> {
            return new C0393gj(context, itemRenderer, C1231wY.f7119p);
        });
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7048kR.get(), context2 -> {
            return new C0406gw(context2, itemRenderer, C1231wY.f7120q);
        });
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7049kS.get(), context3 -> {
            return new C0408gy(context3, itemRenderer, C1231wY.f7123t);
        });
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7051kU.get(), C0374gQ::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7052kV.get(), C0375gR::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7054kX.get(), C0374gQ::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7055kY.get(), C0374gQ::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7056kZ.get(), C0374gQ::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7053kW.get(), C0373gP::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7057la.get(), C0374gQ::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7030kC.get(), context4 -> {
            return new C0407gx(context4, itemRenderer);
        });
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7029kB.get(), C0365gH::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7050kT.get(), context5 -> {
            return new C0372gO(context5, itemRenderer);
        });
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7059lb.get(), C0358gA::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7035kF.get(), C0409gz::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7060lc.get(), C0360gC::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7031kD.get(), C0362gE::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7061ld.get(), C0359gB::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7062le.get(), C0360gC::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7063lf.get(), C0360gC::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7032kE.get(), C0363gF::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7036kG.get(), C0370gM::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7037kH.get(), C0370gM::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7038kI.get(), C0361gD::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7079lt.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7072lm.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7073ln.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7076lq.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7077lr.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7066lg.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7068li.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7069lj.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7070lk.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7071ll.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7078ls.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7080lu.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7067lh.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7074lo.get(), C0378gU::new);
        registerRenderers.registerEntityRenderer((EntityType) C1230wX.f7075lp.get(), C0378gU::new);
        Iterator<DeferredHolder<BlockEntityType<?>, BlockEntityType<? extends C0638lP>>> it = C1216wJ.f6368as.values().iterator();
        while (it.hasNext()) {
            registerRenderers.registerBlockEntityRenderer((BlockEntityType) it.next().get(), C0397gn::new);
        }
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6369bI.get(), C0396gm::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6370bJ.get(), C0395gl::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6371bK.get(), C0399gp::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6381bU.get(), C0394gk::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6414cB.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6415cC.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6416cD.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6417cE.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6385bY.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6387ca.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6388cb.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6389cc.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6390cd.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6391ce.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6393cg.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6394ch.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6395ci.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6396cj.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6399cm.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6400cn.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6401co.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6402cp.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6403cq.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6404cr.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6405cs.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6406ct.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6407cu.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6408cv.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6409cw.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6410cx.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6413cA.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6397ck.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6398cl.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6418cF.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6419cG.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6386bZ.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6392cf.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6411cy.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6412cz.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6421cI.get(), context6 -> {
            return new C0403gt(context6).m1906a(15);
        });
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6420cH.get(), C0394gk::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6372bL.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6373bM.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6374bN.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6375bO.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6376bP.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6377bQ.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6378bR.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6379bS.get(), C0403gt::new);
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) C1216wJ.f6380bT.get(), C0403gt::new);
        C0562jt.log("Client renderer registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m724a(@NotNull EntityRenderersEvent.RegisterLayerDefinitions registerLayerDefinitions) {
        C0562jt.log("Entering client renderer layers registry procedure...", new Object[0]);
        C1220wN.m7279b(registerLayerDefinitions);
        C0562jt.log("Client renderer layers registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m725a(@NotNull RegisterGuiLayersEvent registerGuiLayersEvent) {
        C0562jt.log("Entering overlays registry procedure...", new Object[0]);
        registerGuiLayersEvent.registerBelowAll(C0564jv.m2555d("mod_weather_overlay"), new C0188cq());
        registerGuiLayersEvent.registerBelowAll(C0564jv.m2555d("mod_health_effects"), new C0178cm());
        registerGuiLayersEvent.registerBelowAll(C0564jv.m2555d("mod_vehicle"), new C0187cp());
        registerGuiLayersEvent.registerBelowAll(C0564jv.m2555d("mod_equipment"), new C0173cl());
        registerGuiLayersEvent.registerAboveAll(C0564jv.m2555d("mod_crosshair"), new C0172ck());
        registerGuiLayersEvent.registerAboveAll(C0564jv.m2555d("mod_client_game"), new C0171cj());
        registerGuiLayersEvent.registerAboveAll(C0564jv.m2555d("mod_vanilla_ammo"), new C0180co());
        C0562jt.log("Client overlays registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m726a(@NotNull RegisterClientReloadListenersEvent registerClientReloadListenersEvent) {
        C0562jt.log("Entering reload listener registry procedure...", new Object[0]);
        C1222wP.m7286b(registerClientReloadListenersEvent);
        C0562jt.log("Reload listener registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m727a(@NotNull RegisterKeyMappingsEvent registerKeyMappingsEvent) {
        C0562jt.log("Entering key mappings registry procedure...", new Object[0]);
        C1219wM.m7260b(registerKeyMappingsEvent);
        C0562jt.log("Client key mappings registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m728a(@NotNull RegisterParticleProvidersEvent registerParticleProvidersEvent) {
        C0562jt.log("Entering particle providers registry procedure...", new Object[0]);
        C1223wQ.m7288b(registerParticleProvidersEvent);
        C0562jt.log("Client particle providers registry procedure complete!", new Object[0]);
    }

    @SubscribeEvent
    /* JADX INFO: renamed from: a */
    public static void m729a(@NotNull RegisterShadersEvent registerShadersEvent) throws IOException {
        C0562jt.log("Entering shaders registry procedure...", new Object[0]);
        C1279xb.m7796c(registerShadersEvent);
        C0562jt.log("Client shaders registry procedure complete!", new Object[0]);
    }
}
