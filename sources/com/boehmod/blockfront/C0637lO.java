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

/* JADX INFO: renamed from: com.boehmod.blockfront.lO */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lO.class */
public class C0637lO extends C0636lN {

    /* JADX INFO: renamed from: br */
    @NotNull
    public static final String f3499br = "animation.sherman_tank.idle";

    /* JADX INFO: renamed from: hy */
    public static final float f3501hy = 0.0f;

    /* JADX INFO: renamed from: dY */
    public static final boolean f3502dY = false;

    /* JADX INFO: renamed from: bs */
    private static final String f3503bs = "ConfigurableModel";

    /* JADX INFO: renamed from: bt */
    private static final String f3504bt = "ConfigurableAnimation";

    /* JADX INFO: renamed from: bu */
    private static final String f3505bu = "ConfigurableAnimationName";

    /* JADX INFO: renamed from: bv */
    private static final String f3506bv = "ConfigurableTexture";

    /* JADX INFO: renamed from: bw */
    private static final String f3507bw = "ConfigurableRotation";

    /* JADX INFO: renamed from: bx */
    private static final String f3508bx = "ConfigurableRealtime";

    /* JADX INFO: renamed from: cx */
    @NotNull
    private ResourceLocation f3509cx;

    /* JADX INFO: renamed from: cw */
    @NotNull
    private ResourceLocation f3510cw;

    /* JADX INFO: renamed from: by */
    @NotNull
    private String f3511by;

    /* JADX INFO: renamed from: do */
    @NotNull
    private ResourceLocation f3512do;

    /* JADX INFO: renamed from: cO */
    private float f3513cO;

    /* JADX INFO: renamed from: aY */
    private boolean f3514aY;

    /* JADX INFO: renamed from: dl */
    @NotNull
    public static final ResourceLocation f3497dl = C0564jv.m2555d("geo/block/sherman_tank.geo.json");

    /* JADX INFO: renamed from: dm */
    @NotNull
    public static final ResourceLocation f3498dm = C0564jv.m2555d("animations/block/sherman_tank.animation.json");

    /* JADX INFO: renamed from: dn */
    @NotNull
    public static final ResourceLocation f3500dn = C0564jv.m2555d("block/entity/sherman_tank0");

    public C0637lO(@NotNull BlockEntityType<?> blockEntityType, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.f3509cx = f3497dl;
        this.f3510cw = f3498dm;
        this.f3511by = f3499br;
        this.f3512do = f3500dn;
        this.f3513cO = 0.0f;
        this.f3514aY = false;
    }

    @NotNull
    /* JADX INFO: renamed from: o */
    public ResourceLocation m2821o() {
        return this.f3509cx;
    }

    @NotNull
    /* JADX INFO: renamed from: p */
    public ResourceLocation m2822p() {
        return this.f3510cw;
    }

    @NotNull
    /* JADX INFO: renamed from: D */
    public String m2823D() {
        return this.f3511by;
    }

    @NotNull
    /* JADX INFO: renamed from: q */
    public ResourceLocation m2824q() {
        return this.f3512do;
    }

    /* JADX INFO: renamed from: p */
    public float m2825p() {
        return this.f3513cO;
    }

    /* JADX INFO: renamed from: ao */
    public boolean m2826ao() {
        return this.f3514aY;
    }

    @Override // com.boehmod.blockfront.C0636lN
    /* JADX INFO: renamed from: af */
    public float mo2815af() {
        return this.f3513cO;
    }

    /* JADX INFO: renamed from: a */
    public void m2827a(@NotNull ResourceLocation resourceLocation, @NotNull ResourceLocation resourceLocation2, @NotNull String str, @NotNull ResourceLocation resourceLocation3, float f, boolean z) {
        this.f3509cx = resourceLocation;
        this.f3510cw = resourceLocation2;
        this.f3511by = str.isEmpty() ? f3499br : str;
        this.f3512do = resourceLocation3;
        this.f3513cO = Mth.wrapDegrees(f);
        if (this.f3513cO < 0.0f) {
            this.f3513cO += 360.0f;
        }
        this.f3514aY = z;
    }

    @Override // com.boehmod.blockfront.C0636lN
    /* JADX INFO: renamed from: am */
    public boolean mo2804am() {
        return this.f3514aY || super.mo2804am();
    }

    public void saveAdditional(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        compoundTag.putString(f3503bs, this.f3509cx.toString());
        compoundTag.putString(f3504bt, this.f3510cw.toString());
        compoundTag.putString(f3505bu, this.f3511by);
        compoundTag.putString(f3506bv, this.f3512do.toString());
        compoundTag.putFloat(f3507bw, this.f3513cO);
        compoundTag.putBoolean(f3508bx, this.f3514aY);
    }

    public void loadAdditional(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.f3509cx = m2828a(compoundTag.getString(f3503bs), f3497dl);
        this.f3510cw = m2828a(compoundTag.getString(f3504bt), f3498dm);
        String string = compoundTag.getString(f3505bu);
        this.f3511by = string.isEmpty() ? f3499br : string;
        this.f3512do = m2828a(compoundTag.getString(f3506bv), f3500dn);
        this.f3513cO = compoundTag.contains(f3507bw) ? compoundTag.getFloat(f3507bw) : 0.0f;
        this.f3514aY = compoundTag.contains(f3508bx) ? compoundTag.getBoolean(f3508bx) : false;
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
            a.m2829a(this.worldPosition);
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
    @Override // com.boehmod.blockfront.C0636lN
    @OnlyIn(Dist.CLIENT)
    @NotNull
    /* JADX INFO: renamed from: a */
    public <E extends BlockEntity & GeoAnimatable> PlayState mo2819a(@NotNull AnimationState<E> animationState) {
        AnimationController<T> controller = animationState.getController();
        RawAnimation rawAnimationThenLoop = RawAnimation.begin().thenLoop(this.f3511by);
        if (!rawAnimationThenLoop.equals(controller.getCurrentRawAnimation())) {
            ((AnimationControllerAccessor) controller).setCurrentAnimation(null);
            controller.setAnimation(rawAnimationThenLoop);
        }
        return PlayState.CONTINUE;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    private static ResourceLocation m2828a(@NotNull String str, @NotNull ResourceLocation resourceLocation) {
        ResourceLocation resourceLocationTryParse;
        if (!str.isEmpty() && (resourceLocationTryParse = ResourceLocation.tryParse(str)) != null) {
            return resourceLocationTryParse;
        }
        return resourceLocation;
    }

    /* JADX INFO: renamed from: com.boehmod.blockfront.lO$a */
    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lO$a.class */
    @OnlyIn(Dist.CLIENT)
    private static final class a {
        private a() {
        }

        /* JADX INFO: renamed from: a */
        static void m2829a(@NotNull BlockPos blockPos) {
            Minecraft.getInstance().levelRenderer.setSectionDirtyWithNeighbors(SectionPos.blockToSectionCoord(blockPos.getX()), SectionPos.blockToSectionCoord(blockPos.getY()), SectionPos.blockToSectionCoord(blockPos.getZ()));
        }
    }
}
