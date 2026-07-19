package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.oI;
import com.mojang.blaze3d.vertex.PoseStack;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import javax.annotation.Nonnull;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Camera;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oV.class */
public abstract class oV<P extends oI<?>> extends oX {
    public static final int nj = 12;
    public static final String bO = "capture.point";

    @Nonnull
    private static final ResourceLocation dN = C0265jv.d("textures/misc/bfneutralicon.png");
    private static final float ks = 5.0f;
    private static final int nk = 3;
    private static final int nl = 320;
    private final float kt;
    public String bP;
    private Component gA;
    private Component iR;

    @Nullable
    public oO d;

    @Nullable
    public oO e;

    @Nullable
    public oO f;
    public int nm;

    @Nullable
    public ResourceLocation icon;

    @Nullable
    public ResourceLocation dO;
    public int nn;

    @Nullable
    public AABB g;
    public boolean gh;
    public int dc;
    public float ku;
    public float kv;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NotNull
    protected Object2IntMap<String> f277e;
    private int no;

    @NotNull
    private AABB c;

    @NotNull
    private final P b;

    protected abstract boolean c(@NotNull LivingEntity livingEntity);

    public oV(@NotNull P p) {
        this.kt = (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()));
        this.gA = Component.empty();
        this.iR = Component.empty();
        this.d = null;
        this.e = null;
        this.f = null;
        this.nm = 0;
        this.icon = null;
        this.dO = null;
        this.nn = ColorReferences.COLOR_WHITE;
        this.g = null;
        this.gh = false;
        this.dc = 0;
        this.ku = 0.0f;
        this.kv = 0.0f;
        this.f277e = new Object2IntOpenHashMap();
        this.no = 0;
        this.c = c();
        this.b = p;
    }

    public oV(@NotNull P p, @NotNull ByteBuf byteBuf) throws IOException {
        this(p);
        b(byteBuf);
    }

    public oV(@NotNull P p, @NotNull Player player, @NotNull String str) {
        super(player);
        this.kt = (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()));
        this.gA = Component.empty();
        this.iR = Component.empty();
        this.d = null;
        this.e = null;
        this.f = null;
        this.nm = 0;
        this.icon = null;
        this.dO = null;
        this.nn = ColorReferences.COLOR_WHITE;
        this.g = null;
        this.gh = false;
        this.dc = 0;
        this.ku = 0.0f;
        this.kv = 0.0f;
        this.f277e = new Object2IntOpenHashMap();
        this.no = 0;
        this.b = p;
        this.bP = str;
        this.c = c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    AABB c() {
        return new AABB(this.c, this.c).inflate(0.550000011920929d, 1.100000023841858d, 0.550000011920929d).move(0.0d, 2.4000000953674316d, 0.0d);
    }

    @NotNull
    public AABB d() {
        return this.c;
    }

    @NotNull
    public AABB a(int i) {
        return this.g != null ? this.g : b(i);
    }

    public boolean a(@NotNull Entity entity, int i) {
        if (this.g != null) {
            return this.g.intersects(entity.getBoundingBox());
        }
        return b(entity, i);
    }

    @NotNull
    protected P b() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(@NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull com.boehmod.blockfront.common.player.c<?> cVar, @NotNull oF<?, ?, ?> oFVar, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        oO oOVarM671a;
        int iA = 3;
        if (oFVar instanceof qN) {
            iA = ((qN) oFVar).a(this);
        }
        oI oIVarB = oFVar.b();
        AABB aabbA = a(iA);
        List<ServerPlayer> listA = a(serverLevel, aabbA, set);
        List<mE> listA2 = a(oFVar, serverLevel, aabbA);
        this.gh = false;
        this.f277e.clear();
        if (listA.isEmpty() && listA2.isEmpty()) {
            if (!bt()) {
                this.nm = 0;
            }
            this.e = null;
            this.f = null;
            return;
        }
        if (!listA.isEmpty()) {
            for (ServerPlayer serverPlayer : listA) {
                if (c((LivingEntity) serverPlayer)) {
                    UUID uuid = serverPlayer.getUUID();
                    com.boehmod.blockfront.common.player.b bVarM305a = cVar.m305a((Player) serverPlayer);
                    oO oOVarA = oIVarB.a(uuid);
                    if (oOVarA != null && serverPlayer.tickCount > 20 && !oR.a((Player) serverPlayer, (com.boehmod.blockfront.common.player.b<?, ?, ?, ?>) bVarM305a)) {
                        String name = oOVarA.getName();
                        this.f277e.put(name, this.f277e.getOrDefault(name, 0) + 1);
                    }
                }
            }
        }
        if (!listA2.isEmpty()) {
            for (mE mEVar : listA2) {
                if (c((LivingEntity) mEVar) && (oOVarM671a = mEVar.m671a()) != null && mEVar.tickCount > 20 && mEVar.isAlive()) {
                    String name2 = oOVarM671a.getName();
                    this.f277e.put(name2, this.f277e.getOrDefault(name2, 0) + 1);
                }
            }
        }
        String str = null;
        int i = 0;
        int i2 = 0;
        ObjectIterator it = this.f277e.object2IntEntrySet().iterator();
        while (it.hasNext()) {
            Object2IntMap.Entry entry = (Object2IntMap.Entry) it.next();
            int intValue = entry.getIntValue();
            if (intValue > i) {
                if (str != null) {
                    i2 += i;
                }
                str = (String) entry.getKey();
                i = intValue;
            } else {
                i2 += intValue;
            }
        }
        oO oOVarA2 = null;
        if (str != null && i > i2) {
            oOVarA2 = oIVarB.a(str);
        }
        if (oOVarA2 != null && !oOVarA2.equals(this.d) && a(oOVarA2, oFVar)) {
            int iJ = j(i - i2);
            int iBd = bd();
            int i3 = 0;
            while (true) {
                if (i3 >= iJ) {
                    break;
                }
                if (this.nm < iBd) {
                    this.e = oOVarA2;
                    this.gh = true;
                    this.nm++;
                }
                if (this.nm < iBd) {
                    i3++;
                } else {
                    oO oOVar = this.d;
                    this.d = oOVarA2;
                    this.nm = 0;
                    this.e = null;
                    this.gh = false;
                    if (oFVar instanceof qN) {
                        ((qN) oFVar).a(abstractC0264ju, serverLevel, this, oOVarA2.getName(), oOVar != null ? oOVar.getName() : "", set);
                    }
                }
            }
        } else {
            if (!bt()) {
                this.nm = 0;
            }
            this.e = null;
        }
        if (this.nm > 2 && this.e != null) {
            if (!this.e.equals(this.f)) {
                if (this.d != null) {
                    oR.a((oI<?>) this.b, this.d, (Component) Component.translatable("bf.message.gamemode.notification.point.losing.msg", new Object[]{Component.literal(this.bP != null ? this.bP : "Unknown").withStyle(ChatFormatting.GRAY)}).withColor(ColorReferences.COLOR_WHITE), 80, bO, this.c, this.e.getColor(), ColorReferences.COLOR_WHITE);
                }
                this.f = this.e;
                return;
            }
            return;
        }
        this.f = null;
    }

    protected boolean a(@NotNull oO oOVar, @NotNull oF<?, ?, ?> oFVar) {
        return true;
    }

    protected boolean bt() {
        return false;
    }

    @Nullable
    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public oO mo800c() {
        return this.e;
    }

    protected int j(int i) {
        return i;
    }

    public int bd() {
        return 12;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull oF<?, ?, ?> oFVar) {
        this.c = c();
        this.iR = Component.literal(String.format("%.02f", Double.valueOf(Mth.sqrt((float) localPlayer.distanceToSqr(this.c.x, this.c.y, this.c.z))))).withStyle(this.d != null ? this.d.a() : Style.EMPTY.withColor(ChatFormatting.WHITE)).append(Component.literal("m").withColor(ColorReferences.COLOR_WHITE));
        if (oFVar.m750a() != oN.GAME) {
            return;
        }
        cx();
        cy();
        this.kv = this.ku;
        this.ku = Mth.lerp(0.4f, this.ku, this.nm);
        if (this.no > 0) {
            this.no--;
        }
        if (this.gh) {
            int i = this.dc;
            this.dc = i + 1;
            if (i > 40) {
                this.dc = 0;
            } else if (this.dc > 0 && this.dc % 5 == 0) {
                clientLevel.playLocalSound(this.c.x, this.c.y, this.c.z, (SoundEvent) C0624xc.pP.get(), SoundSource.PLAYERS, 1.0f, 1.0f, false);
            }
            if (this.no == 0 && hN.G.T()) {
                this.no = (int) (320.0d - (5.0d * Math.random()));
                clientLevel.playLocalSound(this.c.x, this.c.y, this.c.z, (SoundEvent) C0624xc.pO.get(), SoundSource.AMBIENT, 15.0f, this.kt, false);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, float f) {
        if (hN.k.T() && frustum.isVisible(this.c)) {
            PoseStack poseStackPose = guiGraphics.pose();
            float fMax = Math.max(this.gh ? 0.5f * Mth.sin(f / 5.0f) : 0.5f, 0.01f) * C0634xm.i((float) camera.getPosition().distanceTo(this.c), 5.0f, 0.0f);
            int color = getColor();
            ResourceLocation icon = getIcon();
            poseStackPose.pushPose();
            C0040bk.a(poseStackPose, camera, guiGraphics, dN, this.c.x, this.c.y + 2.299999952316284d, this.c.z, 50, 50, fMax, color, false);
            if (icon != null) {
                C0040bk.a(poseStackPose, camera, guiGraphics, icon, this.c.x, this.c.y + 2.299999952316284d, this.c.z, 50, 50, fMax, false);
            }
            ResourceLocation resourceLocation = this.dO;
            if (resourceLocation != null) {
                int iBd = bd();
                float fClamp = iBd <= 0 ? 0.0f : Mth.clamp(this.ku / iBd, 0.0f, 1.0f);
                if (fClamp > 0.0f) {
                    C0040bk.a(poseStackPose, camera, guiGraphics, dN, this.c.x, this.c.y + 2.299999952316284d, this.c.z, 50, 50, fMax, this.nn, false, fClamp);
                    C0040bk.a(poseStackPose, camera, guiGraphics, resourceLocation, this.c.x, this.c.y + 2.299999952316284d, this.c.z, 50, 50, fMax, ColorReferences.COLOR_WHITE, false, fClamp);
                }
            }
            C0040bk.a(poseStackPose, font, camera, guiGraphics, this.iR, this.c.x, this.c.y + 1.600000023841858d, this.c.z);
            C0040bk.a(poseStackPose, font, camera, guiGraphics, this.gA, this.c.x, this.c.y + 3.5d, this.c.z, 2.0f);
            poseStackPose.popPose();
        }
    }

    @Override // com.boehmod.blockfront.oX
    public void b(@NotNull ByteBuf byteBuf) throws IOException {
        AABB aabb;
        super.b(byteBuf);
        this.c = c();
        this.bP = IPacket.readString(byteBuf);
        String string = IPacket.readString(byteBuf);
        this.nm = byteBuf.readInt();
        this.gh = IPacket.readBoolean(byteBuf);
        String string2 = IPacket.readString(byteBuf);
        if (IPacket.readBoolean(byteBuf)) {
            aabb = new AABB(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble());
        } else {
            aabb = null;
        }
        this.g = aabb;
        this.d = string.isEmpty() ? null : this.b.a(string);
        this.e = string2.isEmpty() ? null : this.b.a(string2);
        this.f = null;
        this.gA = Component.literal(this.bP.toUpperCase(Locale.ROOT)).withStyle(C0266jw.b);
    }

    @Override // com.boehmod.blockfront.oX
    public void c(@NotNull ByteBuf byteBuf) throws IOException {
        super.c(byteBuf);
        IPacket.writeString(byteBuf, this.bP);
        IPacket.writeString(byteBuf, this.d != null ? this.d.getName() : "");
        byteBuf.writeInt(this.nm);
        IPacket.writeBoolean(byteBuf, this.gh);
        IPacket.writeString(byteBuf, this.e != null ? this.e.getName() : "");
        IPacket.writeBoolean(byteBuf, this.g != null);
        if (this.g != null) {
            byteBuf.writeDouble(this.g.minX);
            byteBuf.writeDouble(this.g.minY);
            byteBuf.writeDouble(this.g.minZ);
            byteBuf.writeDouble(this.g.maxX);
            byteBuf.writeDouble(this.g.maxY);
            byteBuf.writeDouble(this.g.maxZ);
        }
    }

    @Nullable
    public ResourceLocation getIcon() {
        return this.icon;
    }

    private void cx() {
        if (this.d == null) {
            this.icon = null;
        } else {
            this.icon = C0265jv.d("textures/gui/game/capturepoint/" + this.d.getName().toLowerCase(Locale.ROOT) + ".png");
        }
    }

    private void cy() {
        oO oOVarMo800c = mo800c();
        if (oOVarMo800c == null) {
            this.dO = null;
            this.nn = ColorReferences.COLOR_WHITE;
        } else {
            this.dO = C0265jv.d("textures/gui/game/capturepoint/" + oOVarMo800c.getName().toLowerCase(Locale.ROOT) + ".png");
            TextColor color = oOVarMo800c.a().getColor();
            this.nn = color != null ? color.getValue() : ColorReferences.COLOR_WHITE;
        }
    }

    public int getColor() {
        if (this.d != null) {
            return ((TextColor) Objects.requireNonNull(this.d.a().getColor())).getValue();
        }
        return ColorReferences.COLOR_WHITE;
    }

    @Nullable
    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public oO m801d() {
        return this.d;
    }

    @Nullable
    public oO e() {
        return this.e;
    }

    public boolean a(@Nullable oO oOVar) {
        if (oOVar == null || this.d == null) {
            return false;
        }
        return this.d.equals(oOVar);
    }

    public boolean b(@Nullable oO oOVar) {
        if (oOVar == null || this.e == null) {
            return false;
        }
        return this.e.equals(oOVar);
    }

    public void bf() {
        this.e = null;
        this.f = null;
        this.d = null;
        this.nm = 0;
        this.gh = false;
        this.f277e.clear();
    }

    public int b(@NotNull String str) {
        return this.f277e.getOrDefault(str, 0);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m802a(@Nullable oO oOVar) {
        if (oOVar == null) {
            return 0;
        }
        return this.f277e.getOrDefault(oOVar.getName(), 0);
    }

    @NotNull
    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public Object2IntMap<String> m803b() {
        return new Object2IntOpenHashMap(this.f277e);
    }
}
