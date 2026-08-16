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

/* JADX INFO: renamed from: com.boehmod.blockfront.mm */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/mm.class */
public class C0715mm extends BlockEntity {

    /* JADX INFO: renamed from: bI */
    private static final String f3995bI = "itemStack";

    /* JADX INFO: renamed from: c */
    @NotNull
    public ItemStack f3996c;

    public C0715mm(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.f3996c = ItemStack.EMPTY;
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    public ItemStack m3263c() {
        return this.f3996c;
    }

    /* JADX INFO: renamed from: c */
    public void m3264c(@NotNull ItemStack itemStack) {
        this.f3996c = itemStack.copy();
        setChanged();
        Level level = this.level;
        if (level != null && !level.isClientSide()) {
            BlockState blockState = getBlockState();
            level.sendBlockUpdated(this.worldPosition, blockState, blockState, 2);
        }
    }

    public void saveAdditional(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        if (this.f3996c.isEmpty()) {
            return;
        }
        compoundTag.put(f3995bI, this.f3996c.save(provider, new CompoundTag()));
    }

    public void loadAdditional(@NotNull CompoundTag compoundTag, @NotNull HolderLookup.Provider provider) {
        ItemStack optional;
        super.loadAdditional(compoundTag, provider);
        if (compoundTag.contains(f3995bI)) {
            optional = ItemStack.parseOptional(provider, compoundTag.getCompound(f3995bI));
        } else {
            optional = ItemStack.EMPTY;
        }
        this.f3996c = optional;
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
