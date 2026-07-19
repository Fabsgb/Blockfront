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

/* JADX INFO: renamed from: com.boehmod.blockfront.sz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sz.class */
public class C0512sz extends oX {
    private String cE;
    private UUID d;
    private String cF;
    private boolean hg;

    public C0512sz() {
        this.hg = false;
    }

    public C0512sz(@NotNull String str, @NotNull UUID uuid, @NotNull String str2, double d, double d2, double d3, float f, float f2) {
        super(d, d2, d3, f, f2);
        this.hg = false;
        this.cE = str;
        this.d = uuid;
        this.cF = str2;
    }

    @Override // com.boehmod.blockfront.oX
    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        super.b(byteBuf);
        this.cE = IPacket.readString(byteBuf);
        this.d = IPacket.readUUID(byteBuf);
        this.cF = IPacket.readString(byteBuf);
        this.hg = IPacket.readBoolean(byteBuf);
    }

    @Override // com.boehmod.blockfront.oX
    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        super.c(byteBuf);
        IPacket.writeString(byteBuf, this.cE);
        IPacket.writeUUID(byteBuf, this.d);
        IPacket.writeString(byteBuf, this.cF);
        IPacket.writeBoolean(byteBuf, this.hg);
    }

    public String getUsername() {
        return this.cE;
    }

    public String aj() {
        return this.cF;
    }

    public boolean bQ() {
        return this.hg;
    }

    public void a(@NotNull sA sAVar, @NotNull Player player) {
        sAVar.b().h();
        sK sKVarA = sAVar.a(this.d);
        this.hg = true;
        MutableComponent mutableComponentWithColor = Component.literal(player.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE);
        MutableComponent mutableComponentWithColor2 = Component.literal(this.cE).withColor(ColorReferences.COLOR_WHITE);
        MutableComponent mutableComponentWithColor3 = Component.literal(sKVarA.getKey()).withColor(TextColor.fromRgb(sKVarA.getColor()).getValue());
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.ttt.murderinfo.discovered", new Object[]{mutableComponentWithColor, mutableComponentWithColor2}).withStyle(ChatFormatting.GRAY);
        MutableComponent mutableComponentWithStyle2 = Component.translatable("bf.message.gamemode.ttt.murderinfo.discovered.role", new Object[]{mutableComponentWithColor2, mutableComponentWithColor3}).withStyle(ChatFormatting.GRAY);
        oR.a(sAVar, (List<Component>) List.of(mutableComponentWithStyle, mutableComponentWithStyle2), C0163g.g, "ttt.murderinfo");
        oR.a((oF<?, ?, ?>) sAVar, (Component) mutableComponentWithStyle);
        oR.a((oF<?, ?, ?>) sAVar, (Component) mutableComponentWithStyle2);
    }

    public UUID getUUID() {
        return this.d;
    }
}
