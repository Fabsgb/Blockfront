package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.io.IOException;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sA */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sA.class */
public class C0995sA {

    /* JADX INFO: renamed from: aa */
    @NotNull
    public static final Codec<C0995sA> f5478aa = RecordCodecBuilder.create(instance -> {
        return instance.group(BlockPos.CODEC.fieldOf("position").forGetter(c0995sA -> {
            return c0995sA.f5481d;
        }), Codec.STRING.fieldOf("id").forGetter(c0995sA2 -> {
            return c0995sA2.f5479id;
        }), Codec.STRING.listOf().fieldOf("zones").forGetter(c0995sA3 -> {
            return List.copyOf(c0995sA3.f5480af);
        }), Codec.INT.fieldOf("cost").forGetter(c0995sA4 -> {
            return Integer.valueOf(c0995sA4.f5482pr);
        })).apply(instance, (blockPos, str, list, num) -> {
            return new C0995sA(blockPos, str, new ObjectArrayList(list), num.intValue());
        });
    });

    /* JADX INFO: renamed from: id */
    private String f5479id;

    /* JADX INFO: renamed from: af */
    private ObjectList<String> f5480af;

    /* JADX INFO: renamed from: d */
    private BlockPos f5481d;

    /* JADX INFO: renamed from: pr */
    private int f5482pr;

    /* JADX INFO: renamed from: hs */
    private boolean f5483hs;

    public C0995sA() {
        this(new BlockPos(0, 0, 0), "unknown", ObjectList.of(), 0);
    }

    public C0995sA(@NotNull BlockPos blockPos, @NotNull String str, @NotNull ObjectList<String> objectList, int i) {
        this.f5483hs = false;
        this.f5481d = blockPos;
        this.f5479id = str;
        this.f5480af = objectList;
        this.f5482pr = i;
    }

    /* JADX INFO: renamed from: cY */
    public void m5585cY() {
        this.f5483hs = false;
    }

    /* JADX INFO: renamed from: a */
    public void m5586a(@NotNull Level level, boolean z) {
        BlockState blockState = level.getBlockState(this.f5481d);
        DoorBlock block = blockState.getBlock();
        if (block instanceof DoorBlock) {
            block.setOpen((Entity) null, level, blockState, this.f5481d, z);
        }
        if (z) {
            level.playSound((Player) null, this.f5481d, SoundEvents.ENDER_CHEST_OPEN, SoundSource.AMBIENT, 1.0f, 0.5f);
        }
        this.f5483hs = z;
    }

    @NotNull
    /* JADX INFO: renamed from: av */
    public List<String> m5587av() {
        return this.f5480af;
    }

    @NotNull
    public String getId() {
        return this.f5479id;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public BlockPos m5588e() {
        return this.f5481d;
    }

    /* JADX INFO: renamed from: bV */
    public boolean m5589bV() {
        return this.f5483hs;
    }

    /* JADX INFO: renamed from: bz */
    public int m5590bz() {
        return this.f5482pr;
    }

    /* JADX INFO: renamed from: a */
    public boolean m5591a(@NotNull BlockPos blockPos) {
        return this.f5481d.equals(blockPos) || this.f5481d.offset(0, 1, 0).equals(blockPos) || this.f5481d.subtract(new Vec3i(0, 1, 0)).equals(blockPos);
    }

    /* JADX INFO: renamed from: b */
    public void m5592b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f5481d = new BlockPos(byteBuf.readInt(), byteBuf.readInt(), byteBuf.readInt());
        this.f5479id = IPacket.readString(byteBuf);
        this.f5480af = IPacket.readStringList(byteBuf);
        this.f5483hs = IPacket.readBoolean(byteBuf);
        this.f5482pr = byteBuf.readInt();
    }

    /* JADX INFO: renamed from: c */
    public void m5593c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f5481d.getX());
        byteBuf.writeInt(this.f5481d.getY());
        byteBuf.writeInt(this.f5481d.getZ());
        IPacket.writeString(byteBuf, this.f5479id);
        IPacket.writeStringList(byteBuf, this.f5480af);
        IPacket.writeBoolean(byteBuf, this.f5483hs);
        byteBuf.writeInt(this.f5482pr);
    }
}
