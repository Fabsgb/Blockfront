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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/lQ.class */
public class lQ extends BlockEntity {
    private static final String bz = "itemStack";

    @NotNull
    public ItemStack c;

    public lQ(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.c = ItemStack.EMPTY;
    }

    @NotNull
    public ItemStack a() {
        return this.c;
    }

    public void c(@NotNull ItemStack itemStack) {
        this.c = itemStack.copy();
        setChanged();
        Level level = this.level;
        if (level != null && !level.isClientSide()) {
            BlockState blockState = getBlockState();
            level.sendBlockUpdated(this.worldPosition, blockState, blockState, 2);
        }
    }

    public void saveAdditional(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        if (this.c.isEmpty()) {
            return;
        }
        compoundTag.put(bz, this.c.save(provider, new CompoundTag()));
    }

    public void loadAdditional(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        ItemStack optional;
        super.loadAdditional(compoundTag, provider);
        if (compoundTag.contains(bz)) {
            optional = ItemStack.parseOptional(provider, compoundTag.getCompound(bz));
        } else {
            optional = ItemStack.EMPTY;
        }
        this.c = optional;
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
