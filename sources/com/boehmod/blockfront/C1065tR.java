package com.boehmod.blockfront;

import com.boehmod.blockfront.C1136uj;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.tR */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/tR.class */
public final class C1065tR extends C1136uj implements InterfaceC1048tA {
    public C1065tR(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.C1136uj
    /* JADX INFO: renamed from: ck */
    public boolean mo5957ck() {
        return false;
    }

    @Override // com.boehmod.blockfront.C1136uj
    /* JADX INFO: renamed from: a */
    protected AbstractC0676mA mo5958a(@NotNull Level level) {
        return ((EntityType) C1230wX.f7048kR.get()).create(level);
    }

    @Override // com.boehmod.blockfront.C1136uj
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1136uj.a mo5959a() {
        return C1136uj.a.AMMO_BOX;
    }

    @Override // com.boehmod.blockfront.C1136uj
    /* JADX INFO: renamed from: cl */
    public boolean mo5960cl() {
        return false;
    }

    @Override // com.boehmod.blockfront.C1136uj, com.boehmod.blockfront.InterfaceC1048tA
    /* JADX INFO: renamed from: a */
    public void mo5828a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull C0324fT c0324fT, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
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
