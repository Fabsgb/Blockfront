package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.sW */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/sW.class */
public class C1017sW extends C0881pt {

    /* JADX INFO: renamed from: cO */
    private String f5583cO;

    /* JADX INFO: renamed from: d */
    private UUID f5584d;

    /* JADX INFO: renamed from: cP */
    private String f5585cP;

    /* JADX INFO: renamed from: hA */
    private boolean f5586hA;

    public C1017sW() {
        this.f5586hA = false;
    }

    public C1017sW(@NotNull String str, @NotNull UUID uuid, @NotNull String str2, double d, double d2, double d3, float f, float f2) {
        super(d, d2, d3, f, f2);
        this.f5586hA = false;
        this.f5583cO = str;
        this.f5584d = uuid;
        this.f5585cP = str2;
    }

    @Override // com.boehmod.blockfront.C0881pt
    /* JADX INFO: renamed from: b */
    public void mo3869b(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo3869b(byteBuf);
        this.f5583cO = IPacket.readString(byteBuf);
        this.f5584d = IPacket.readUUID(byteBuf);
        this.f5585cP = IPacket.readString(byteBuf);
        this.f5586hA = IPacket.readBoolean(byteBuf);
    }

    @Override // com.boehmod.blockfront.C0881pt
    /* JADX INFO: renamed from: c */
    public void mo3870c(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo3870c(byteBuf);
        IPacket.writeString(byteBuf, this.f5583cO);
        IPacket.writeUUID(byteBuf, this.f5584d);
        IPacket.writeString(byteBuf, this.f5585cP);
        IPacket.writeBoolean(byteBuf, this.f5586hA);
    }

    public String getUsername() {
        return this.f5583cO;
    }

    /* JADX INFO: renamed from: aq */
    public String m5708aq() {
        return this.f5585cP;
    }

    /* JADX INFO: renamed from: ca */
    public boolean m5709ca() {
        return this.f5586hA;
    }

    /* JADX INFO: renamed from: a */
    public void m5710a(@NotNull C1018sX c1018sX, @NotNull Player player) {
        c1018sX.m4018b().m4245h();
        EnumC1082th enumC1082thM5718a = c1018sX.m5718a(this.f5584d);
        this.f5586hA = true;
        MutableComponent mutableComponentWithColor = Component.literal(player.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE);
        MutableComponent mutableComponentWithColor2 = Component.literal(this.f5583cO).withColor(ColorReferences.COLOR_WHITE);
        MutableComponent mutableComponentWithColor3 = Component.literal(enumC1082thM5718a.getKey()).withColor(TextColor.fromRgb(enumC1082thM5718a.getColor()).getValue());
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.ttt.murderinfo.discovered", new Object[]{mutableComponentWithColor, mutableComponentWithColor2}).withStyle(ChatFormatting.GRAY);
        MutableComponent mutableComponentWithStyle2 = Component.translatable("bf.message.gamemode.ttt.murderinfo.discovered.role", new Object[]{mutableComponentWithColor2, mutableComponentWithColor3}).withStyle(ChatFormatting.GRAY);
        C0875pn.m4437a(c1018sX, (List<Component>) List.of(mutableComponentWithStyle, mutableComponentWithStyle2), C0358g.f2490g, "ttt.murderinfo");
        C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) c1018sX, (Component) mutableComponentWithStyle);
        C0875pn.m4417a((AbstractC0863pb<?, ?, ?>) c1018sX, (Component) mutableComponentWithStyle2);
    }

    public UUID getUUID() {
        return this.f5584d;
    }
}
