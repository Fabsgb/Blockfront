package com.boehmod.blockfront;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.lQ */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lQ.class */
public class C0639lQ extends BlockEntity {

    /* JADX INFO: renamed from: bz */
    private static final String f3521bz = "itemStack";

    /* JADX INFO: renamed from: c */
    @NotNull
    public ItemStack f3522c;

    public C0639lQ(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.f3522c = ItemStack.EMPTY;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public ItemStack m2832a() {
        return this.f3522c;
    }

    /* JADX INFO: renamed from: c */
    public void m2833c(@NotNull ItemStack itemStack) {
        this.f3522c = itemStack.copy();
        setChanged();
        Level level = this.level;
        if (level != null && !level.isClientSide()) {
            BlockState blockState = getBlockState();
            level.sendBlockUpdated(this.worldPosition, blockState, blockState, 2);
        }
    }

    public void saveAdditional(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        if (this.f3522c.isEmpty()) {
            return;
        }
        compoundTag.put(f3521bz, this.f3522c.save(provider, new CompoundTag()));
    }

    public void loadAdditional(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        ItemStack optional;
        super.loadAdditional(compoundTag, provider);
        if (compoundTag.contains(f3521bz)) {
            optional = ItemStack.parseOptional(provider, compoundTag.getCompound(f3521bz));
        } else {
            optional = ItemStack.EMPTY;
        }
        this.f3522c = optional;
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
            loadWithComponents(tag, provider);
        }
    }
}
