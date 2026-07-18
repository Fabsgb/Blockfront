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

/* JADX INFO: renamed from: com.boehmod.blockfront.sz */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/sz.class */
public class C1046sz extends C0805oX {

    /* JADX INFO: renamed from: cE */
    private String f5536cE;

    /* JADX INFO: renamed from: d */
    private UUID f5537d;

    /* JADX INFO: renamed from: cF */
    private String f5538cF;

    /* JADX INFO: renamed from: hg */
    private boolean f5539hg;

    public C1046sz() {
        this.f5539hg = false;
    }

    public C1046sz(@NotNull String str, @NotNull UUID uuid, @NotNull String str2, double d, double d2, double d3, float f, float f2) {
        super(d, d2, d3, f, f2);
        this.f5539hg = false;
        this.f5536cE = str;
        this.f5537d = uuid;
        this.f5538cF = str2;
    }

    @Override // com.boehmod.blockfront.C0805oX
    /* JADX INFO: renamed from: b */
    public void mo4110b(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo4110b(byteBuf);
        this.f5536cE = IPacket.readString(byteBuf);
        this.f5537d = IPacket.readUUID(byteBuf);
        this.f5538cF = IPacket.readString(byteBuf);
        this.f5539hg = IPacket.readBoolean(byteBuf);
    }

    @Override // com.boehmod.blockfront.C0805oX
    /* JADX INFO: renamed from: c */
    public void mo4111c(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo4111c(byteBuf);
        IPacket.writeString(byteBuf, this.f5536cE);
        IPacket.writeUUID(byteBuf, this.f5537d);
        IPacket.writeString(byteBuf, this.f5538cF);
        IPacket.writeBoolean(byteBuf, this.f5539hg);
    }

    public String getUsername() {
        return this.f5536cE;
    }

    /* JADX INFO: renamed from: aj */
    public String m5819aj() {
        return this.f5538cF;
    }

    /* JADX INFO: renamed from: bQ */
    public boolean m5820bQ() {
        return this.f5539hg;
    }

    /* JADX INFO: renamed from: a */
    public void m5821a(@NotNull C0994sA c0994sA, @NotNull Player player) {
        c0994sA.m3582b().m3809h();
        EnumC1004sK enumC1004sKM5440a = c0994sA.m5440a(this.f5537d);
        this.f5539hg = true;
        MutableComponent mutableComponentWithColor = Component.literal(player.getScoreboardName()).withColor(ColorReferences.COLOR_WHITE);
        MutableComponent mutableComponentWithColor2 = Component.literal(this.f5536cE).withColor(ColorReferences.COLOR_WHITE);
        MutableComponent mutableComponentWithColor3 = Component.literal(enumC1004sKM5440a.getKey()).withColor(TextColor.fromRgb(enumC1004sKM5440a.getColor()).getValue());
        MutableComponent mutableComponentWithStyle = Component.translatable("bf.message.gamemode.ttt.murderinfo.discovered", new Object[]{mutableComponentWithColor, mutableComponentWithColor2}).withStyle(ChatFormatting.GRAY);
        MutableComponent mutableComponentWithStyle2 = Component.translatable("bf.message.gamemode.ttt.murderinfo.discovered.role", new Object[]{mutableComponentWithColor2, mutableComponentWithColor3}).withStyle(ChatFormatting.GRAY);
        C0799oR.m4001a(c0994sA, (List<Component>) List.of(mutableComponentWithStyle, mutableComponentWithStyle2), C0357g.f2439g, "ttt.murderinfo");
        C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) c0994sA, (Component) mutableComponentWithStyle);
        C0799oR.m3981a((AbstractC0787oF<?, ?, ?>) c0994sA, (Component) mutableComponentWithStyle2);
    }

    public UUID getUUID() {
        return this.f5537d;
    }
}
