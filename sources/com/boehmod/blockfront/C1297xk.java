package com.boehmod.blockfront;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.xk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/xk.class */
public class C1297xk {
    /* JADX INFO: renamed from: b */
    public static void m7866b(@NotNull EntityRenderersEvent.RegisterLayerDefinitions registerLayerDefinitions) {
        registerLayerDefinitions.registerLayerDefinition(C0414hC.f2666a, () -> {
            return LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.01f), 64, 64);
        });
        registerLayerDefinitions.registerLayerDefinition(C0414hC.f2667b, () -> {
            return LayerDefinition.create(C0265eM.m1501a(CubeDeformation.NONE, false, 0.015f), 64, 64);
        });
        registerLayerDefinitions.registerLayerDefinition(C0414hC.f2668c, () -> {
            return LayerDefinition.create(C0265eM.m1501a(CubeDeformation.NONE, true, 0.015f), 64, 64);
        });
        registerLayerDefinitions.registerLayerDefinition(C0414hC.f2669d, () -> {
            return LayerDefinition.create(C0264eL.m1496a(CubeDeformation.NONE), 64, 64);
        });
        registerLayerDefinitions.registerLayerDefinition(C0415hD.f2681e, () -> {
            return LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.01f), 64, 64);
        });
    }
}
