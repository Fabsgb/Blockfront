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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lO.class */
public class lO extends lN {

    @NotNull
    public static final String br = "animation.sherman_tank.idle";
    public static final float hy = 0.0f;
    public static final boolean dY = false;
    private static final String bs = "ConfigurableModel";
    private static final String bt = "ConfigurableAnimation";
    private static final String bu = "ConfigurableAnimationName";
    private static final String bv = "ConfigurableTexture";
    private static final String bw = "ConfigurableRotation";
    private static final String bx = "ConfigurableRealtime";

    @NotNull
    private ResourceLocation cx;

    @NotNull
    private ResourceLocation cw;

    @NotNull
    private String by;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    @NotNull
    private ResourceLocation f232do;
    private float cO;
    private boolean aY;

    @NotNull
    public static final ResourceLocation dl = C0265jv.d("geo/block/sherman_tank.geo.json");

    @NotNull
    public static final ResourceLocation dm = C0265jv.d("animations/block/sherman_tank.animation.json");

    @NotNull
    public static final ResourceLocation dn = C0265jv.d("block/entity/sherman_tank0");

    public lO(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.cx = dl;
        this.cw = dm;
        this.by = br;
        this.f232do = dn;
        this.cO = 0.0f;
        this.aY = false;
    }

    @NotNull
    public ResourceLocation o() {
        return this.cx;
    }

    @NotNull
    public ResourceLocation p() {
        return this.cw;
    }

    @NotNull
    public String D() {
        return this.by;
    }

    @NotNull
    public ResourceLocation q() {
        return this.f232do;
    }

    /* JADX INFO: renamed from: p, reason: collision with other method in class */
    public float m625p() {
        return this.cO;
    }

    public boolean ao() {
        return this.aY;
    }

    @Override // com.boehmod.blockfront.lN
    public float af() {
        return this.cO;
    }

    public void a(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull String str, @NotNull ResourceLocation resourceLocation3, float f, boolean z) {
        this.cx = resourceLocation;
        this.cw = resourceLocation2;
        this.by = str.isEmpty() ? br : str;
        this.f232do = resourceLocation3;
        this.cO = Mth.wrapDegrees(f);
        if (this.cO < 0.0f) {
            this.cO += 360.0f;
        }
        this.aY = z;
    }

    @Override // com.boehmod.blockfront.lN
    public boolean am() {
        return this.aY || super.am();
    }

    public void saveAdditional(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putString(bs, this.cx.toString());
        compoundTag.putString(bt, this.cw.toString());
        compoundTag.putString(bu, this.by);
        compoundTag.putString(bv, this.f232do.toString());
        compoundTag.putFloat(bw, this.cO);
        compoundTag.putBoolean(bx, this.aY);
    }

    public void loadAdditional(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.cx = a(compoundTag.getString(bs), dl);
        this.cw = a(compoundTag.getString(bt), dm);
        String string = compoundTag.getString(bu);
        this.by = string.isEmpty() ? br : string;
        this.f232do = a(compoundTag.getString(bv), dn);
        this.cO = compoundTag.contains(bw) ? compoundTag.getFloat(bw) : 0.0f;
        this.aY = compoundTag.contains(bx) ? compoundTag.getBoolean(bx) : false;
    }

    @NotNull
    public CompoundTag getUpdateTag(@NotNull HolderLookup.Provider provider) {
        CompoundTag updateTag = super.getUpdateTag(provider);
        saveAdditional(updateTag, provider);
        return updateTag;
    }

    public void handleUpdateTag(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        super.handleUpdateTag(compoundTag, provider);
        if (this.level != null && this.level.isClientSide()) {
            a.a(this.worldPosition);
        }
    }

    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void onDataPacket(@NotNull Connection connection, @NotNull ClientboundBlockEntityDataPacket clientboundBlockEntityDataPacket, @NotNull HolderLookup.Provider provider) {
        CompoundTag tag = clientboundBlockEntityDataPacket.getTag();
        if (tag != null) {
            handleUpdateTag(tag, provider);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.boehmod.blockfront.lN
    @OnlyIn(Dist.CLIENT)
    @NotNull
    public <E extends BlockEntity & GeoAnimatable> PlayState a(@NotNull AnimationState<E> animationState) {
        AnimationController<T> controller = animationState.getController();
        RawAnimation rawAnimationThenLoop = RawAnimation.begin().thenLoop(this.by);
        if (!rawAnimationThenLoop.equals(controller.getCurrentRawAnimation())) {
            ((AnimationControllerAccessor) controller).setCurrentAnimation(null);
            controller.setAnimation(rawAnimationThenLoop);
        }
        return PlayState.CONTINUE;
    }

    @NotNull
    private static ResourceLocation a(@NotNull String str, @NotNull ResourceLocation resourceLocation) {
        ResourceLocation resourceLocationTryParse;
        if (!str.isEmpty() && (resourceLocationTryParse = ResourceLocation.tryParse(str)) != null) {
            return resourceLocationTryParse;
        }
        return resourceLocation;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lO$a.class */
    @OnlyIn(Dist.CLIENT)
    private static final class a {
        private a() {
        }

        static void a(@NotNull BlockPos blockPos) {
            Minecraft.getInstance().levelRenderer.setSectionDirtyWithNeighbors(SectionPos.blockToSectionCoord(blockPos.getX()), SectionPos.blockToSectionCoord(blockPos.getY()), SectionPos.blockToSectionCoord(blockPos.getZ()));
        }
    }
}
