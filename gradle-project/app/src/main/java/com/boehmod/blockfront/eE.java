package com.boehmod.blockfront;

import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/eE.class */
public class eE<T extends AbstractClientPlayer> extends PlayerModel<T> {
    private final boolean ch;
    static final /* synthetic */ boolean ci;

    static {
        ci = !eE.class.desiredAssertionStatus();
    }

    public eE(@NotNull ModelPart modelPart, boolean z) {
        super(modelPart, z);
        this.ch = z;
    }

    public boolean L() {
        return this.ch;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setupAnim(@NotNull T t, float f, float f2, float f3, float f4, float f5) {
        ItemStack mainHandItem = t.getMainHandItem();
        if (!mainHandItem.isEmpty() && (mainHandItem.getItem() instanceof C0558ur)) {
            ((AbstractClientPlayer) t).swinging = false;
        }
        this.head.zRot = 0.0f;
        super.setupAnim(t, f, f2, f3, f4, f5);
        Minecraft minecraft = Minecraft.getInstance();
        float fG = C0040bk.g() + t.getId();
        C0297l c0297lB = C0297l.b();
        if (!ci && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        UUID uuid = t.getUUID();
        fT fTVar = (fT) ((fV) c0297lB.a()).a((Player) t);
        if (!mainHandItem.isEmpty()) {
            tA item = mainHandItem.getItem();
            if (item instanceof tA) {
                item.a(minecraft, uuid.equals(minecraft.getUser().getProfileId()), this, fTVar, t, fG, C0634xm.a(minecraft));
            }
        }
        this.leftSleeve.copyFrom(this.leftArm);
        this.rightSleeve.copyFrom(this.rightArm);
        this.leftPants.copyFrom(this.leftLeg);
        this.rightPants.copyFrom(this.rightLeg);
        this.hat.copyFrom(this.head);
        setAllVisible(true);
        if (c0297lB.m593a() != null || (t instanceof bQ)) {
            this.hat.xScale = 0.92f;
            this.hat.yScale = 0.92f;
            this.hat.zScale = 0.92f;
            this.jacket.visible = false;
            this.leftSleeve.visible = false;
            this.rightSleeve.visible = false;
            this.leftPants.visible = false;
            this.rightPants.visible = false;
        }
    }
}
