package com.boehmod.blockfront;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.wN */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wN.class */
public class C1220wN {
    /* JADX INFO: renamed from: b */
    public static void m7279b(@NotNull EntityRenderersEvent.RegisterLayerDefinitions registerLayerDefinitions) {
        registerLayerDefinitions.registerLayerDefinition(C0449hm.f2837a, () -> {
            return LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.01f), 64, 64);
        });
        registerLayerDefinitions.registerLayerDefinition(C0449hm.f2838b, () -> {
            return LayerDefinition.create(C0303ez.m1597a(CubeDeformation.NONE, false, 0.015f), 64, 64);
        });
        registerLayerDefinitions.registerLayerDefinition(C0449hm.f2839c, () -> {
            return LayerDefinition.create(C0303ez.m1597a(CubeDeformation.NONE, true, 0.015f), 64, 64);
        });
        registerLayerDefinitions.registerLayerDefinition(C0449hm.f2840d, () -> {
            return LayerDefinition.create(C0302ey.m1592a(CubeDeformation.NONE), 64, 64);
        });
        registerLayerDefinitions.registerLayerDefinition(C0450hn.f2851e, () -> {
            return LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.01f), 64, 64);
        });
    }
}
