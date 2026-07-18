package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tV.class */
public class C1069tV extends C1058tK implements InterfaceC1048tA, InterfaceC1070tW {
    public C1069tV(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.InterfaceC1048tA
    /* JADX INFO: renamed from: a */
    public void mo5828a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull C0324fT c0324fT, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
        float fSin = (Mth.sin(f / 15.0f) * Mth.sin(f / 12.0f)) / 6.0f;
        ModelPart modelPart = playerModel.rightArm;
        ModelPart modelPart2 = playerModel.rightSleeve;
        float f3 = (-1.6f) + playerModel.head.xRot + fSin;
        modelPart2.xRot = f3;
        modelPart.xRot = f3;
        ModelPart modelPart3 = playerModel.rightArm;
        ModelPart modelPart4 = playerModel.rightSleeve;
        float f4 = (-0.2f) + playerModel.head.yRot;
        modelPart4.yRot = f4;
        modelPart3.yRot = f4;
        ModelPart modelPart5 = playerModel.rightArm;
        ModelPart modelPart6 = playerModel.rightSleeve;
        float f5 = playerModel.head.zRot + fSin;
        modelPart6.zRot = f5;
        modelPart5.zRot = f5;
        ModelPart modelPart7 = playerModel.leftArm;
        ModelPart modelPart8 = playerModel.leftSleeve;
        float f6 = (-1.6f) + playerModel.head.xRot + fSin;
        modelPart8.xRot = f6;
        modelPart7.xRot = f6;
        ModelPart modelPart9 = playerModel.leftArm;
        ModelPart modelPart10 = playerModel.leftSleeve;
        float f7 = 0.8f + playerModel.head.yRot;
        modelPart10.yRot = f7;
        modelPart9.yRot = f7;
        ModelPart modelPart11 = playerModel.leftArm;
        ModelPart modelPart12 = playerModel.leftSleeve;
        float f8 = playerModel.head.zRot + fSin;
        modelPart12.zRot = f8;
        modelPart11.zRot = f8;
    }
}
