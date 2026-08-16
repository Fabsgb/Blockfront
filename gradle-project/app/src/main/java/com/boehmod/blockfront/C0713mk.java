package com.boehmod.blockfront;

import com.boehmod.blockfront.mixin.AnimationControllerAccessor;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.SectionPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

/* JADX INFO: renamed from: com.boehmod.blockfront.mk */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mk.class */
public class C0713mk extends C0712mj {

    /* JADX INFO: renamed from: bA */
    @NotNull
    public static final String f3973bA = "animation.sherman_tank.idle";

    /* JADX INFO: renamed from: iq */
    public static final float f3975iq = 0.0f;

    /* JADX INFO: renamed from: er */
    public static final boolean f3976er = false;

    /* JADX INFO: renamed from: bB */
    private static final String f3977bB = "ConfigurableModel";

    /* JADX INFO: renamed from: bC */
    private static final String f3978bC = "ConfigurableAnimation";

    /* JADX INFO: renamed from: bD */
    private static final String f3979bD = "ConfigurableAnimationName";

    /* JADX INFO: renamed from: bE */
    private static final String f3980bE = "ConfigurableTexture";

    /* JADX INFO: renamed from: bF */
    private static final String f3981bF = "ConfigurableRotation";

    /* JADX INFO: renamed from: bG */
    private static final String f3982bG = "ConfigurableRealtime";

    /* JADX INFO: renamed from: cw */
    @NotNull
    private ResourceLocation f3983cw;

    /* JADX INFO: renamed from: cv */
    @NotNull
    private ResourceLocation f3984cv;

    /* JADX INFO: renamed from: bH */
    @NotNull
    private String f3985bH;

    /* JADX INFO: renamed from: do */
    @NotNull
    private ResourceLocation f3986do;

    /* JADX INFO: renamed from: cU */
    private float f3987cU;

    /* JADX INFO: renamed from: bc */
    private boolean f3988bc;

    /* JADX INFO: renamed from: dl */
    @NotNull
    public static final ResourceLocation f3971dl = C0532jO.m2378d("geo/block/sherman_tank.geo.json");

    /* JADX INFO: renamed from: dm */
    @NotNull
    public static final ResourceLocation f3972dm = C0532jO.m2378d("animations/block/sherman_tank.animation.json");

    /* JADX INFO: renamed from: dn */
    @NotNull
    public static final ResourceLocation f3974dn = C0532jO.m2378d("block/entity/sherman_tank0");

    public C0713mk(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.f3983cw = f3971dl;
        this.f3984cv = f3972dm;
        this.f3985bH = f3973bA;
        this.f3986do = f3974dn;
        this.f3987cU = 0.0f;
        this.f3988bc = false;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public ResourceLocation m3252p() {
        return this.f3983cw;
    }

    @NotNull
    /* JADX INFO: renamed from: q */
    public ResourceLocation m3253q() {
        return this.f3984cv;
    }

    @NotNull
    /* JADX INFO: renamed from: K */
    public String m3254K() {
        return this.f3985bH;
    }

    @NotNull
    /* JADX INFO: renamed from: r */
    public ResourceLocation m3255r() {
        return this.f3986do;
    }

    /* JADX INFO: renamed from: p */
    public float m3256p() {
        return this.f3987cU;
    }

    /* JADX INFO: renamed from: ay */
    public boolean m3257ay() {
        return this.f3988bc;
    }

    @Override // com.boehmod.blockfront.C0712mj
    /* JADX INFO: renamed from: al */
    public float mo3246al() {
        return this.f3987cU;
    }

    /* JADX INFO: renamed from: a */
    public void m3258a(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull String str, @NotNull ResourceLocation resourceLocation3, float f, boolean z) {
        this.f3983cw = resourceLocation;
        this.f3984cv = resourceLocation2;
        this.f3985bH = str.isEmpty() ? f3973bA : str;
        this.f3986do = resourceLocation3;
        this.f3987cU = Mth.wrapDegrees(f);
        if (this.f3987cU < 0.0f) {
            this.f3987cU += 360.0f;
        }
        this.f3988bc = z;
    }

    @Override // com.boehmod.blockfront.C0712mj
    /* JADX INFO: renamed from: aw */
    public boolean mo3235aw() {
        return this.f3988bc || super.mo3235aw();
    }

    public void saveAdditional(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putString(f3977bB, this.f3983cw.toString());
        compoundTag.putString(f3978bC, this.f3984cv.toString());
        compoundTag.putString(f3979bD, this.f3985bH);
        compoundTag.putString(f3980bE, this.f3986do.toString());
        compoundTag.putFloat(f3981bF, this.f3987cU);
        compoundTag.putBoolean(f3982bG, this.f3988bc);
    }

    public void loadAdditional(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.f3983cw = m3259a(compoundTag.getString(f3977bB), f3971dl);
        this.f3984cv = m3259a(compoundTag.getString(f3978bC), f3972dm);
        String string = compoundTag.getString(f3979bD);
        this.f3985bH = string.isEmpty() ? f3973bA : string;
        this.f3986do = m3259a(compoundTag.getString(f3980bE), f3974dn);
        this.f3987cU = compoundTag.contains(f3981bF) ? compoundTag.getFloat(f3981bF) : 0.0f;
        this.f3988bc = compoundTag.contains(f3982bG) ? compoundTag.getBoolean(f3982bG) : false;
    }

    @NotNull
    public CompoundTag getUpdateTag(@NotNull HolderLookup.Provider provider) {
        CompoundTag updateTag = super.getUpdateTag(provider);
        saveAdditional(updateTag, provider);
        return updateTag;
    }

    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void onDataPacket(@NotNull Connection connection, @NotNull ClientboundBlockEntityDataPacket clientboundBlockEntityDataPacket, @NotNull HolderLookup.Provider provider) {
        CompoundTag tag = clientboundBlockEntityDataPacket.getTag();
        if (tag != null) {
            handleUpdateTag(tag, provider);
            if (this.level != null && this.level.isClientSide()) {
                a.m3260a(this.worldPosition);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.C0712mj
    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a */
    public <E extends BlockEntity & GeoAnimatable> PlayState mo3250a(@NotNull AnimationState<E> animationState) {
        AnimationController<T> controller = animationState.getController();
        RawAnimation rawAnimationThenLoop = RawAnimation.begin().thenLoop(this.f3985bH);
        if (!rawAnimationThenLoop.equals(controller.getCurrentRawAnimation())) {
            ((AnimationControllerAccessor) controller).setCurrentAnimation(null);
            controller.setAnimation(rawAnimationThenLoop);
        }
        return PlayState.CONTINUE;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ResourceLocation m3259a(@NotNull String str, @NotNull ResourceLocation resourceLocation) {
        ResourceLocation resourceLocationTryParse;
        if (!str.isEmpty() && (resourceLocationTryParse = ResourceLocation.tryParse(str)) != null) {
            return resourceLocationTryParse;
        }
        return resourceLocation;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.mk$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mk$a.class */
    @OnlyIn(Dist.CLIENT)
    private static final class a {
        private a() {
        }

        /* JADX INFO: renamed from: a */
        static void m3260a(@NotNull BlockPos blockPos) {
            Minecraft.getInstance().levelRenderer.setSectionDirtyWithNeighbors(SectionPos.blockToSectionCoord(blockPos.getX()), SectionPos.blockToSectionCoord(blockPos.getY()), SectionPos.blockToSectionCoord(blockPos.getZ()));
        }
    }
}
