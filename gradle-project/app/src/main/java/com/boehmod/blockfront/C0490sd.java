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

/* JADX INFO: renamed from: com.boehmod.blockfront.sd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sd.class */
public class C0490sd {

    @NotNull
    public static final Codec<C0490sd> aa = RecordCodecBuilder.create(instance -> {
        return instance.group(BlockPos.CODEC.fieldOf("position").forGetter(c0490sd -> {
            return c0490sd.d;
        }), Codec.STRING.fieldOf("id").forGetter(c0490sd2 -> {
            return c0490sd2.id;
        }), Codec.STRING.listOf().fieldOf("zones").forGetter(c0490sd3 -> {
            return List.copyOf(c0490sd3.W);
        }), Codec.INT.fieldOf("cost").forGetter(c0490sd4 -> {
            return Integer.valueOf(c0490sd4.ns);
        })).apply(instance, (blockPos, str, list, num) -> {
            return new C0490sd(blockPos, str, new ObjectArrayList(list), num.intValue());
        });
    });
    private String id;
    private ObjectList<String> W;
    private BlockPos d;
    private int ns;
    private boolean gY;

    public C0490sd() {
        this(new BlockPos(0, 0, 0), "unknown", ObjectList.of(), 0);
    }

    public C0490sd(@NotNull BlockPos blockPos, @NotNull String str, @NotNull ObjectList<String> objectList, int i) {
        this.gY = false;
        this.d = blockPos;
        this.id = str;
        this.W = objectList;
        this.ns = i;
    }

    public void cM() {
        this.gY = false;
    }

    public void a(@NotNull Level level, boolean z) {
        BlockState blockState = level.getBlockState(this.d);
        DoorBlock block = blockState.getBlock();
        if (block instanceof DoorBlock) {
            block.setOpen((Entity) null, level, blockState, this.d, z);
        }
        if (z) {
            level.playSound((Player) null, this.d, SoundEvents.ENDER_CHEST_OPEN, SoundSource.AMBIENT, 1.0f, 0.5f);
        }
        this.gY = z;
    }

    @NotNull
    public List<String> at() {
        return this.W;
    }

    @NotNull
    public String getId() {
        return this.id;
    }

    @NotNull
    public BlockPos e() {
        return this.d;
    }

    public boolean bL() {
        return this.gY;
    }

    public int bk() {
        return this.ns;
    }

    public boolean a(@NotNull BlockPos blockPos) {
        return this.d.equals(blockPos) || this.d.offset(0, 1, 0).equals(blockPos) || this.d.subtract(new Vec3i(0, 1, 0)).equals(blockPos);
    }

    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        this.d = new BlockPos(byteBuf.readInt(), byteBuf.readInt(), byteBuf.readInt());
        this.id = IPacket.readString(byteBuf);
        this.W = IPacket.readStringList(byteBuf);
        this.gY = IPacket.readBoolean(byteBuf);
        this.ns = byteBuf.readInt();
    }

    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        byteBuf.writeInt(this.d.getX());
        byteBuf.writeInt(this.d.getY());
        byteBuf.writeInt(this.d.getZ());
        IPacket.writeString(byteBuf, this.id);
        IPacket.writeStringList(byteBuf, this.W);
        IPacket.writeBoolean(byteBuf, this.gY);
        byteBuf.writeInt(this.ns);
    }
}
