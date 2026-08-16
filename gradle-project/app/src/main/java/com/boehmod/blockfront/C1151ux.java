package com.boehmod.blockfront;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.ux */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ux.class */
public final class C1151ux extends C1109uH implements InterfaceC1073tY {
    public C1151ux(@NotNull String str, Item.Properties properties) {
        super(str, properties);
    }

    @Override // com.boehmod.blockfront.C1109uH
    /* JADX INFO: renamed from: cu */
    public boolean mo6228cu() {
        return false;
    }

    @Override // com.boehmod.blockfront.C1109uH
    /* JADX INFO: renamed from: a */
    protected AbstractC0699mW mo6209a(@NotNull Level level) {
        return ((EntityType) C1307xu.f7612kQ.get()).create(level);
    }

    @Override // com.boehmod.blockfront.C1109uH
    @NotNull
    /* JADX INFO: renamed from: a */
    public C1109uH.a mo6211a() {
        return C1109uH.a.MEDICAL_BAG;
    }

    @Override // com.boehmod.blockfront.C1109uH
    /* JADX INFO: renamed from: cv */
    public boolean mo6232cv() {
        return false;
    }

    @Override // com.boehmod.blockfront.C1109uH, com.boehmod.blockfront.InterfaceC1073tY
    /* JADX INFO: renamed from: a */
    public void mo5942a(@NotNull Minecraft minecraft, boolean z, @NotNull PlayerModel<?> playerModel, @NotNull C0394gj c0394gj, @NotNull AbstractClientPlayer abstractClientPlayer, float f, float f2) {
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
