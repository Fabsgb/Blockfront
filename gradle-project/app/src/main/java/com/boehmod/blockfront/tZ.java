package com.boehmod.blockfront;

import com.boehmod.blockfront.C0550uj;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tZ.class */
public final class tZ extends C0550uj implements tA {
    public tZ(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.C0550uj
    public boolean ck() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0550uj
    protected mA a(@NotNull Level level) {
        return ((EntityType) wX.kQ.get()).create(level);
    }

    @Override // com.boehmod.blockfront.C0550uj
    @NotNull
    public C0550uj.a a() {
        return C0550uj.a.MEDICAL_BAG;
    }

    @Override // com.boehmod.blockfront.C0550uj
    public boolean cl() {
        return false;
    }

    @Override // com.boehmod.blockfront.C0550uj, com.boehmod.blockfront.tA
    public void a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull fT fTVar, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
        ModelPart modelPart = playerModel.leftArm;
        playerModel.leftSleeve.xRot = -0.75f;
        modelPart.xRot = -0.75f;
        ModelPart modelPart2 = playerModel.rightArm;
        playerModel.rightSleeve.xRot = -0.75f;
        modelPart2.xRot = -0.75f;
        ModelPart modelPart3 = playerModel.leftArm;
        playerModel.leftSleeve.yRot = 0.0f;
        modelPart3.yRot = 0.0f;
        ModelPart modelPart4 = playerModel.rightArm;
        playerModel.rightSleeve.yRot = 0.0f;
        modelPart4.yRot = 0.0f;
        ModelPart modelPart5 = playerModel.leftArm;
        playerModel.leftSleeve.zRot = 0.0f;
        modelPart5.zRot = 0.0f;
        ModelPart modelPart6 = playerModel.rightArm;
        playerModel.rightSleeve.zRot = 0.0f;
        modelPart6.zRot = 0.0f;
    }
}
