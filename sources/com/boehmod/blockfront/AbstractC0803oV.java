package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0790oI;
import com.boehmod.blockfront.common.player.AbstractC0182b;
import com.boehmod.blockfront.common.player.AbstractC0183c;
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

/* JADX INFO: renamed from: com.boehmod.blockfront.oV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/oV.class */
public abstract class AbstractC0803oV<P extends AbstractC0790oI<?>> extends C0805oX {

    /* JADX INFO: renamed from: nj */
    public static final int f4392nj = 12;

    /* JADX INFO: renamed from: bO */
    public static final String f4393bO = "capture.point";

    /* JADX INFO: renamed from: dN */
    @Nonnull
    private static final ResourceLocation f4394dN = C0564jv.m2555d("textures/misc/bfneutralicon.png");

    /* JADX INFO: renamed from: ks */
    private static final float f4395ks = 5.0f;

    /* JADX INFO: renamed from: nk */
    private static final int f4396nk = 3;

    /* JADX INFO: renamed from: nl */
    private static final int f4397nl = 320;

    /* JADX INFO: renamed from: kt */
    private final float f4398kt;

    /* JADX INFO: renamed from: bP */
    public String f4399bP;

    /* JADX INFO: renamed from: gA */
    private Component f4400gA;

    /* JADX INFO: renamed from: iR */
    private Component f4401iR;

    /* JADX INFO: renamed from: d */
    @Nullable
    public C0796oO f4402d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public C0796oO f4403e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public C0796oO f4404f;

    /* JADX INFO: renamed from: nm */
    public int f4405nm;

    @Nullable
    public ResourceLocation icon;

    /* JADX INFO: renamed from: dO */
    @Nullable
    public ResourceLocation f4406dO;

    /* JADX INFO: renamed from: nn */
    public int f4407nn;

    /* JADX INFO: renamed from: g */
    @Nullable
    public AABB f4408g;

    /* JADX INFO: renamed from: gh */
    public boolean f4409gh;

    /* JADX INFO: renamed from: dc */
    public int f4410dc;

    /* JADX INFO: renamed from: ku */
    public float f4411ku;

    /* JADX INFO: renamed from: kv */
    public float f4412kv;

    /* JADX INFO: renamed from: e */
    @NotNull
    protected Object2IntMap<String> f4413e;

    /* JADX INFO: renamed from: no */
    private int f4414no;

    /* JADX INFO: renamed from: c */
    @NotNull
    private AABB f4415c;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final P f4416b;

    /* JADX INFO: renamed from: c */
    protected abstract boolean mo4102c(@NotNull LivingEntity livingEntity);

    public AbstractC0803oV(@NotNull P p) {
        this.f4398kt = (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()));
        this.f4400gA = Component.empty();
        this.f4401iR = Component.empty();
        this.f4402d = null;
        this.f4403e = null;
        this.f4404f = null;
        this.f4405nm = 0;
        this.icon = null;
        this.f4406dO = null;
        this.f4407nn = ColorReferences.COLOR_WHITE;
        this.f4408g = null;
        this.f4409gh = false;
        this.f4410dc = 0;
        this.f4411ku = 0.0f;
        this.f4412kv = 0.0f;
        this.f4413e = new Object2IntOpenHashMap();
        this.f4414no = 0;
        this.f4415c = m4096c();
        this.f4416b = p;
    }

    public AbstractC0803oV(@NotNull P p, @NotNull ByteBuf byteBuf) throws IOException {
        this(p);
        mo4110b(byteBuf);
    }

    public AbstractC0803oV(@NotNull P p, @NotNull Player player, @NotNull String str) {
        super(player);
        this.f4398kt = (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()));
        this.f4400gA = Component.empty();
        this.f4401iR = Component.empty();
        this.f4402d = null;
        this.f4403e = null;
        this.f4404f = null;
        this.f4405nm = 0;
        this.icon = null;
        this.f4406dO = null;
        this.f4407nn = ColorReferences.COLOR_WHITE;
        this.f4408g = null;
        this.f4409gh = false;
        this.f4410dc = 0;
        this.f4411ku = 0.0f;
        this.f4412kv = 0.0f;
        this.f4413e = new Object2IntOpenHashMap();
        this.f4414no = 0;
        this.f4416b = p;
        this.f4399bP = str;
        this.f4415c = m4096c();
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    AABB m4096c() {
        return new AABB(this.f4424c, this.f4424c).inflate(0.550000011920929d, 1.100000023841858d, 0.550000011920929d).move(0.0d, 2.4000000953674316d, 0.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public AABB m4097d() {
        return this.f4415c;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AABB m4098a(int i) {
        return this.f4408g != null ? this.f4408g : m4146b(i);
    }

    /* JADX INFO: renamed from: a */
    public boolean m4099a(@NotNull Entity entity, int i) {
        if (this.f4408g != null) {
            return this.f4408g.intersects(entity.getBoundingBox());
        }
        return m4139b(entity, i);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    protected P m4100b() {
        return this.f4416b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public void m4101a(@NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0183c<?> abstractC0183c, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        C0796oO c0796oOM3046a;
        int iMo4666a = 3;
        if (abstractC0787oF instanceof InterfaceC0901qN) {
            iMo4666a = ((InterfaceC0901qN) abstractC0787oF).mo4666a(this);
        }
        AbstractC0790oI abstractC0790oIM3582b = abstractC0787oF.m3582b();
        AABB aabbM4098a = m4098a(iMo4666a);
        List<ServerPlayer> listA = m4135a(serverLevel, aabbM4098a, set);
        List<C0680mE> listA2 = m4138a(abstractC0787oF, serverLevel, aabbM4098a);
        this.f4409gh = false;
        this.f4413e.clear();
        if (listA.isEmpty() && listA2.isEmpty()) {
            if (!mo4104bt()) {
                this.f4405nm = 0;
            }
            this.f4403e = null;
            this.f4404f = null;
            return;
        }
        if (!listA.isEmpty()) {
            for (ServerPlayer serverPlayer : listA) {
                if (mo4102c((LivingEntity) serverPlayer)) {
                    UUID uuid = serverPlayer.getUUID();
                    AbstractC0182b abstractC0182bM1136a = abstractC0183c.m1136a((Player) serverPlayer);
                    C0796oO c0796oOM3793a = abstractC0790oIM3582b.m3793a(uuid);
                    if (c0796oOM3793a != null && serverPlayer.tickCount > 20 && !C0799oR.m4052a((Player) serverPlayer, (AbstractC0182b<?, ?, ?, ?>) abstractC0182bM1136a)) {
                        String name = c0796oOM3793a.getName();
                        this.f4413e.put(name, this.f4413e.getOrDefault(name, 0) + 1);
                    }
                }
            }
        }
        if (!listA2.isEmpty()) {
            for (C0680mE c0680mE : listA2) {
                if (mo4102c((LivingEntity) c0680mE) && (c0796oOM3046a = c0680mE.m3046a()) != null && c0680mE.tickCount > 20 && c0680mE.isAlive()) {
                    String name2 = c0796oOM3046a.getName();
                    this.f4413e.put(name2, this.f4413e.getOrDefault(name2, 0) + 1);
                }
            }
        }
        String str = null;
        int i = 0;
        int i2 = 0;
        ObjectIterator it = this.f4413e.object2IntEntrySet().iterator();
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
        C0796oO c0796oOM3806a = null;
        if (str != null && i > i2) {
            c0796oOM3806a = abstractC0790oIM3582b.m3806a(str);
        }
        if (c0796oOM3806a != null && !c0796oOM3806a.equals(this.f4402d) && mo4103a(c0796oOM3806a, abstractC0787oF)) {
            int iMo4106j = mo4106j(i - i2);
            int iMo4107bd = mo4107bd();
            int i3 = 0;
            while (true) {
                if (i3 >= iMo4106j) {
                    break;
                }
                if (this.f4405nm < iMo4107bd) {
                    this.f4403e = c0796oOM3806a;
                    this.f4409gh = true;
                    this.f4405nm++;
                }
                if (this.f4405nm < iMo4107bd) {
                    i3++;
                } else {
                    C0796oO c0796oO = this.f4402d;
                    this.f4402d = c0796oOM3806a;
                    this.f4405nm = 0;
                    this.f4403e = null;
                    this.f4409gh = false;
                    if (abstractC0787oF instanceof InterfaceC0901qN) {
                        ((InterfaceC0901qN) abstractC0787oF).mo4667a(abstractC0563ju, serverLevel, this, c0796oOM3806a.getName(), c0796oO != null ? c0796oO.getName() : "", set);
                    }
                }
            }
        } else {
            if (!mo4104bt()) {
                this.f4405nm = 0;
            }
            this.f4403e = null;
        }
        if (this.f4405nm > 2 && this.f4403e != null) {
            if (!this.f4403e.equals(this.f4404f)) {
                if (this.f4402d != null) {
                    C0799oR.m3993a((AbstractC0790oI<?>) this.f4416b, this.f4402d, (Component) Component.translatable("bf.message.gamemode.notification.point.losing.msg", new Object[]{Component.literal(this.f4399bP != null ? this.f4399bP : "Unknown").withStyle(ChatFormatting.GRAY)}).withColor(ColorReferences.COLOR_WHITE), 80, f4393bO, this.f4424c, this.f4403e.getColor(), ColorReferences.COLOR_WHITE);
                }
                this.f4404f = this.f4403e;
                return;
            }
            return;
        }
        this.f4404f = null;
    }

    /* JADX INFO: renamed from: a */
    protected boolean mo4103a(@NotNull C0796oO c0796oO, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        return true;
    }

    /* JADX INFO: renamed from: bt */
    protected boolean mo4104bt() {
        return false;
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C0796oO mo4105c() {
        return this.f4403e;
    }

    /* JADX INFO: renamed from: j */
    protected int mo4106j(int i) {
        return i;
    }

    /* JADX INFO: renamed from: bd */
    public int mo4107bd() {
        return 12;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m4108a(@NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF) {
        this.f4415c = m4096c();
        this.f4401iR = Component.literal(String.format("%.02f", Double.valueOf(Mth.sqrt((float) localPlayer.distanceToSqr(this.f4424c.x, this.f4424c.y, this.f4424c.z))))).withStyle(this.f4402d != null ? this.f4402d.m3876a() : Style.EMPTY.withColor(ChatFormatting.WHITE)).append(Component.literal("m").withColor(ColorReferences.COLOR_WHITE));
        if (abstractC0787oF.m3587a() != EnumC0795oN.GAME) {
            return;
        }
        m4112cx();
        m4113cy();
        this.f4412kv = this.f4411ku;
        this.f4411ku = Mth.lerp(0.4f, this.f4411ku, this.f4405nm);
        if (this.f4414no > 0) {
            this.f4414no--;
        }
        if (this.f4409gh) {
            int i = this.f4410dc;
            this.f4410dc = i + 1;
            if (i > 40) {
                this.f4410dc = 0;
            } else if (this.f4410dc > 0 && this.f4410dc % 5 == 0) {
                clientLevel.playLocalSound(this.f4424c.x, this.f4424c.y, this.f4424c.z, (SoundEvent) C1280xc.f7584pP.get(), SoundSource.PLAYERS, 1.0f, 1.0f, false);
            }
            if (this.f4414no == 0 && C0424hN.f2752G.m1996T()) {
                this.f4414no = (int) (320.0d - (5.0d * Math.random()));
                clientLevel.playLocalSound(this.f4424c.x, this.f4424c.y, this.f4424c.z, (SoundEvent) C1280xc.f7583pO.get(), SoundSource.AMBIENT, 15.0f, this.f4398kt, false);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m4109a(@NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, float f) {
        if (C0424hN.f2730k.m1996T() && frustum.isVisible(this.f4415c)) {
            PoseStack poseStackPose = guiGraphics.pose();
            float fMax = Math.max(this.f4409gh ? 0.5f * Mth.sin(f / 5.0f) : 0.5f, 0.01f) * C1290xm.m7863i((float) camera.getPosition().distanceTo(this.f4424c), 5.0f, 0.0f);
            int color = getColor();
            ResourceLocation icon = getIcon();
            poseStackPose.pushPose();
            C0119bk.m512a(poseStackPose, camera, guiGraphics, f4394dN, this.f4424c.x, this.f4424c.y + 2.299999952316284d, this.f4424c.z, 50, 50, fMax, color, false);
            if (icon != null) {
                C0119bk.m510a(poseStackPose, camera, guiGraphics, icon, this.f4424c.x, this.f4424c.y + 2.299999952316284d, this.f4424c.z, 50, 50, fMax, false);
            }
            ResourceLocation resourceLocation = this.f4406dO;
            if (resourceLocation != null) {
                int iMo4107bd = mo4107bd();
                float fClamp = iMo4107bd <= 0 ? 0.0f : Mth.clamp(this.f4411ku / iMo4107bd, 0.0f, 1.0f);
                if (fClamp > 0.0f) {
                    C0119bk.m513a(poseStackPose, camera, guiGraphics, f4394dN, this.f4424c.x, this.f4424c.y + 2.299999952316284d, this.f4424c.z, 50, 50, fMax, this.f4407nn, false, fClamp);
                    C0119bk.m513a(poseStackPose, camera, guiGraphics, resourceLocation, this.f4424c.x, this.f4424c.y + 2.299999952316284d, this.f4424c.z, 50, 50, fMax, ColorReferences.COLOR_WHITE, false, fClamp);
                }
            }
            C0119bk.m518a(poseStackPose, font, camera, guiGraphics, this.f4401iR, this.f4424c.x, this.f4424c.y + 1.600000023841858d, this.f4424c.z);
            C0119bk.m520a(poseStackPose, font, camera, guiGraphics, this.f4400gA, this.f4424c.x, this.f4424c.y + 3.5d, this.f4424c.z, 2.0f);
            poseStackPose.popPose();
        }
    }

    @Override // com.boehmod.blockfront.C0805oX
    /* JADX INFO: renamed from: b */
    public void mo4110b(@NotNull ByteBuf byteBuf) throws IOException {
        AABB aabb;
        super.mo4110b(byteBuf);
        this.f4415c = m4096c();
        this.f4399bP = IPacket.readString(byteBuf);
        String string = IPacket.readString(byteBuf);
        this.f4405nm = byteBuf.readInt();
        this.f4409gh = IPacket.readBoolean(byteBuf);
        String string2 = IPacket.readString(byteBuf);
        if (IPacket.readBoolean(byteBuf)) {
            aabb = new AABB(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble());
        } else {
            aabb = null;
        }
        this.f4408g = aabb;
        this.f4402d = string.isEmpty() ? null : this.f4416b.m3806a(string);
        this.f4403e = string2.isEmpty() ? null : this.f4416b.m3806a(string2);
        this.f4404f = null;
        this.f4400gA = Component.literal(this.f4399bP.toUpperCase(Locale.ROOT)).withStyle(C0565jw.f3201b);
    }

    @Override // com.boehmod.blockfront.C0805oX
    /* JADX INFO: renamed from: c */
    public void mo4111c(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo4111c(byteBuf);
        IPacket.writeString(byteBuf, this.f4399bP);
        IPacket.writeString(byteBuf, this.f4402d != null ? this.f4402d.getName() : "");
        byteBuf.writeInt(this.f4405nm);
        IPacket.writeBoolean(byteBuf, this.f4409gh);
        IPacket.writeString(byteBuf, this.f4403e != null ? this.f4403e.getName() : "");
        IPacket.writeBoolean(byteBuf, this.f4408g != null);
        if (this.f4408g != null) {
            byteBuf.writeDouble(this.f4408g.minX);
            byteBuf.writeDouble(this.f4408g.minY);
            byteBuf.writeDouble(this.f4408g.minZ);
            byteBuf.writeDouble(this.f4408g.maxX);
            byteBuf.writeDouble(this.f4408g.maxY);
            byteBuf.writeDouble(this.f4408g.maxZ);
        }
    }

    @Nullable
    public ResourceLocation getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: cx */
    private void m4112cx() {
        if (this.f4402d == null) {
            this.icon = null;
        } else {
            this.icon = C0564jv.m2555d("textures/gui/game/capturepoint/" + this.f4402d.getName().toLowerCase(Locale.ROOT) + ".png");
        }
    }

    /* JADX INFO: renamed from: cy */
    private void m4113cy() {
        C0796oO c0796oOMo4105c = mo4105c();
        if (c0796oOMo4105c == null) {
            this.f4406dO = null;
            this.f4407nn = ColorReferences.COLOR_WHITE;
        } else {
            this.f4406dO = C0564jv.m2555d("textures/gui/game/capturepoint/" + c0796oOMo4105c.getName().toLowerCase(Locale.ROOT) + ".png");
            TextColor color = c0796oOMo4105c.m3876a().getColor();
            this.f4407nn = color != null ? color.getValue() : ColorReferences.COLOR_WHITE;
        }
    }

    public int getColor() {
        if (this.f4402d != null) {
            return ((TextColor) Objects.requireNonNull(this.f4402d.m3876a().getColor())).getValue();
        }
        return ColorReferences.COLOR_WHITE;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0796oO m4114d() {
        return this.f4402d;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public C0796oO m4115e() {
        return this.f4403e;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4116a(@Nullable C0796oO c0796oO) {
        if (c0796oO == null || this.f4402d == null) {
            return false;
        }
        return this.f4402d.equals(c0796oO);
    }

    /* JADX INFO: renamed from: b */
    public boolean m4117b(@Nullable C0796oO c0796oO) {
        if (c0796oO == null || this.f4403e == null) {
            return false;
        }
        return this.f4403e.equals(c0796oO);
    }

    /* JADX INFO: renamed from: bf */
    public void m4118bf() {
        this.f4403e = null;
        this.f4404f = null;
        this.f4402d = null;
        this.f4405nm = 0;
        this.f4409gh = false;
        this.f4413e.clear();
    }

    /* JADX INFO: renamed from: b */
    public int m4119b(@NotNull String str) {
        return this.f4413e.getOrDefault(str, 0);
    }

    /* JADX INFO: renamed from: a */
    public int m4120a(@Nullable C0796oO c0796oO) {
        if (c0796oO == null) {
            return 0;
        }
        return this.f4413e.getOrDefault(c0796oO.getName(), 0);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Object2IntMap<String> m4121b() {
        return new Object2IntOpenHashMap(this.f4413e);
    }
}
