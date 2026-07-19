package com.boehmod.blockfront;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/wN.class */
public class wN {
    public static void b(@NotNull EntityRenderersEvent.RegisterLayerDefinitions registerLayerDefinitions) {
        registerLayerDefinitions.registerLayerDefinition(C0203hm.a, () -> {
            return LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.01f), 64, 64);
        });
        registerLayerDefinitions.registerLayerDefinition(C0203hm.b, () -> {
            return LayerDefinition.create(C0135ez.a(CubeDeformation.NONE, false, 0.015f), 64, 64);
        });
        registerLayerDefinitions.registerLayerDefinition(C0203hm.c, () -> {
            return LayerDefinition.create(C0135ez.a(CubeDeformation.NONE, true, 0.015f), 64, 64);
        });
        registerLayerDefinitions.registerLayerDefinition(C0203hm.d, () -> {
            return LayerDefinition.create(C0134ey.a(CubeDeformation.NONE), 64, 64);
        });
        registerLayerDefinitions.registerLayerDefinition(C0204hn.e, () -> {
            return LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.01f), 64, 64);
        });
    }
}
