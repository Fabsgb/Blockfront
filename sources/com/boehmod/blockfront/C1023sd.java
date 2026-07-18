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

/* JADX INFO: renamed from: com.boehmod.blockfront.sd */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sd.class */
public class C1023sd {

    /* JADX INFO: renamed from: aa */
    @NotNull
    public static final Codec<C1023sd> f5430aa = RecordCodecBuilder.create(instance -> {
        return instance.group(BlockPos.CODEC.fieldOf("position").forGetter(c1023sd -> {
            return c1023sd.f5433d;
        }), Codec.STRING.fieldOf("id").forGetter(c1023sd2 -> {
            return c1023sd2.f5431id;
        }), Codec.STRING.listOf().fieldOf("zones").forGetter(c1023sd3 -> {
            return List.copyOf(c1023sd3.f5432W);
        }), Codec.INT.fieldOf("cost").forGetter(c1023sd4 -> {
            return Integer.valueOf(c1023sd4.f5434ns);
        })).apply(instance, (blockPos, str, list, num) -> {
            return new C1023sd(blockPos, str, new ObjectArrayList(list), num.intValue());
        });
    });

    /* JADX INFO: renamed from: id */
    private String f5431id;

    /* JADX INFO: renamed from: W */
    private ObjectList<String> f5432W;

    /* JADX INFO: renamed from: d */
    private BlockPos f5433d;

    /* JADX INFO: renamed from: ns */
    private int f5434ns;

    /* JADX INFO: renamed from: gY */
    private boolean f5435gY;

    public C1023sd() {
        this(new BlockPos(0, 0, 0), "unknown", ObjectList.of(), 0);
    }

    public C1023sd(@NotNull BlockPos blockPos, @NotNull String str, @NotNull ObjectList<String> objectList, int i) {
        this.f5435gY = false;
        this.f5433d = blockPos;
        this.f5431id = str;
        this.f5432W = objectList;
        this.f5434ns = i;
    }

    /* JADX INFO: renamed from: cM */
    public void m5700cM() {
        this.f5435gY = false;
    }

    /* JADX INFO: renamed from: a */
    public void m5701a(@NotNull Level level, boolean z) {
        BlockState blockState = level.getBlockState(this.f5433d);
        DoorBlock block = blockState.getBlock();
        if (block instanceof DoorBlock) {
            block.setOpen((Entity) null, level, blockState, this.f5433d, z);
        }
        if (z) {
            level.playSound((Player) null, this.f5433d, SoundEvents.ENDER_CHEST_OPEN, SoundSource.AMBIENT, 1.0f, 0.5f);
        }
        this.f5435gY = z;
    }

    @NotNull
    /* JADX INFO: renamed from: at */
    public List<String> m5702at() {
        return this.f5432W;
    }

    @NotNull
    public String getId() {
        return this.f5431id;
    }

    @NotNull
    /* JADX INFO: renamed from: e */
    public BlockPos m5703e() {
        return this.f5433d;
    }

    /* JADX INFO: renamed from: bL */
    public boolean m5704bL() {
        return this.f5435gY;
    }

    /* JADX INFO: renamed from: bk */
    public int m5705bk() {
        return this.f5434ns;
    }

    /* JADX INFO: renamed from: a */
    public boolean m5706a(@NotNull BlockPos blockPos) {
        return this.f5433d.equals(blockPos) || this.f5433d.offset(0, 1, 0).equals(blockPos) || this.f5433d.subtract(new Vec3i(0, 1, 0)).equals(blockPos);
    }

    /* JADX INFO: renamed from: b */
    public void m5707b(@NotNull ByteBuf byteBuf) throws IOException {
        this.f5433d = new BlockPos(byteBuf.readInt(), byteBuf.readInt(), byteBuf.readInt());
        this.f5431id = IPacket.readString(byteBuf);
        this.f5432W = IPacket.readStringList(byteBuf);
        this.f5435gY = IPacket.readBoolean(byteBuf);
        this.f5434ns = byteBuf.readInt();
    }

    /* JADX INFO: renamed from: c */
    public void m5708c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.f5433d.getX());
        byteBuf.writeInt(this.f5433d.getY());
        byteBuf.writeInt(this.f5433d.getZ());
        IPacket.writeString(byteBuf, this.f5431id);
        IPacket.writeStringList(byteBuf, this.f5432W);
        IPacket.writeBoolean(byteBuf, this.f5435gY);
        byteBuf.writeInt(this.f5434ns);
    }
}
