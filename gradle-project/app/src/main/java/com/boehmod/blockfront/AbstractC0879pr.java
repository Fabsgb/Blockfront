package com.boehmod.blockfront;

import com.boehmod.bflib.cloud.packet.IPacket;
import com.boehmod.bflib.common.ColorReferences;
import com.boehmod.blockfront.AbstractC0866pe;
import com.boehmod.blockfront.common.player.AbstractC0183b;
import com.boehmod.blockfront.common.player.AbstractC0184c;
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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.boehmod.blockfront.pr */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/pr.class */
public abstract class AbstractC0879pr<P extends AbstractC0866pe<?>> extends C0881pt {

    /* JADX INFO: renamed from: pi */
    public static final int f4789pi = 12;

    /* JADX INFO: renamed from: bY */
    public static final String f4790bY = "capture.point";

    /* JADX INFO: renamed from: dL */
    @Nonnull
    private static final ResourceLocation f4791dL = C0532jO.m2378d("textures/misc/bfneutralicon.png");

    /* JADX INFO: renamed from: ll */
    private static final float f4792ll = 5.0f;

    /* JADX INFO: renamed from: pj */
    private static final int f4793pj = 3;

    /* JADX INFO: renamed from: pk */
    private static final int f4794pk = 320;

    /* JADX INFO: renamed from: lm */
    private final float f4795lm;

    /* JADX INFO: renamed from: bZ */
    public String f4796bZ;

    /* JADX INFO: renamed from: gG */
    private Component f4797gG;

    /* JADX INFO: renamed from: z */
    @Nullable
    private FormattedCharSequence f4798z;

    /* JADX INFO: renamed from: ln */
    private float f4799ln;

    /* JADX INFO: renamed from: je */
    @Nullable
    private Component f4800je;

    /* JADX INFO: renamed from: A */
    @Nullable
    private FormattedCharSequence f4801A;

    /* JADX INFO: renamed from: lo */
    private float f4802lo;

    /* JADX INFO: renamed from: d */
    @Nullable
    public C0872pk f4803d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public C0872pk f4804e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public C0872pk f4805f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public C0872pk f4806g;

    /* JADX INFO: renamed from: pl */
    public int f4807pl;

    @Nullable
    public ResourceLocation icon;

    /* JADX INFO: renamed from: dM */
    @Nullable
    public ResourceLocation f4808dM;

    /* JADX INFO: renamed from: pm */
    public int f4809pm;

    /* JADX INFO: renamed from: g */
    @Nullable
    public AABB f4810g;

    /* JADX INFO: renamed from: gB */
    public boolean f4811gB;

    /* JADX INFO: renamed from: dU */
    public int f4812dU;

    /* JADX INFO: renamed from: lp */
    public float f4813lp;

    /* JADX INFO: renamed from: lq */
    public float f4814lq;

    /* JADX INFO: renamed from: h */
    @Nullable
    private C0872pk f4815h;

    /* JADX INFO: renamed from: e */
    @NotNull
    protected Object2IntMap<String> f4816e;

    /* JADX INFO: renamed from: pn */
    private int f4817pn;

    /* JADX INFO: renamed from: c */
    @NotNull
    private AABB f4818c;

    /* JADX INFO: renamed from: b */
    @NotNull
    private final P f4819b;

    /* JADX INFO: renamed from: c */
    protected abstract boolean mo4538c(@NotNull LivingEntity livingEntity);

    public AbstractC0879pr(@NotNull P p) {
        this.f4795lm = (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()));
        this.f4797gG = Component.empty();
        this.f4798z = null;
        this.f4800je = null;
        this.f4801A = null;
        this.f4803d = null;
        this.f4804e = null;
        this.f4805f = null;
        this.f4806g = null;
        this.f4807pl = 0;
        this.icon = null;
        this.f4808dM = null;
        this.f4809pm = ColorReferences.COLOR_WHITE;
        this.f4810g = null;
        this.f4811gB = false;
        this.f4812dU = 0;
        this.f4813lp = 0.0f;
        this.f4814lq = 0.0f;
        this.f4815h = null;
        this.f4816e = new Object2IntOpenHashMap();
        this.f4817pn = 0;
        this.f4818c = m4532c();
        this.f4819b = p;
    }

    public AbstractC0879pr(@NotNull P p, @NotNull ByteBuf byteBuf) throws IOException {
        this(p);
        mo3869b(byteBuf);
    }

    public AbstractC0879pr(@NotNull P p, @NotNull Player player, @NotNull String str) {
        super(player);
        this.f4795lm = (float) (0.8999999761581421d + (0.20000000298023224d * Math.random()));
        this.f4797gG = Component.empty();
        this.f4798z = null;
        this.f4800je = null;
        this.f4801A = null;
        this.f4803d = null;
        this.f4804e = null;
        this.f4805f = null;
        this.f4806g = null;
        this.f4807pl = 0;
        this.icon = null;
        this.f4808dM = null;
        this.f4809pm = ColorReferences.COLOR_WHITE;
        this.f4810g = null;
        this.f4811gB = false;
        this.f4812dU = 0;
        this.f4813lp = 0.0f;
        this.f4814lq = 0.0f;
        this.f4815h = null;
        this.f4816e = new Object2IntOpenHashMap();
        this.f4817pn = 0;
        this.f4819b = p;
        this.f4796bZ = str;
        this.f4818c = m4532c();
    }

    @NotNull
    /* JADX INFO: renamed from: c */
    private AABB m4532c() {
        return new AABB(this.f4827c, this.f4827c).inflate(0.550000011920929d, 1.100000023841858d, 0.550000011920929d).move(0.0d, 2.4000000953674316d, 0.0d);
    }

    @NotNull
    /* JADX INFO: renamed from: d */
    public AABB m4533d() {
        return this.f4818c;
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public AABB m4534a(int i) {
        return this.f4810g != null ? this.f4810g : m4583b(i);
    }

    /* JADX INFO: renamed from: a */
    public boolean m4535a(@NotNull Entity entity, int i) {
        if (this.f4810g != null) {
            return this.f4810g.intersects(entity.getBoundingBox());
        }
        return m4576b(entity, i);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    protected P m4536b() {
        return this.f4819b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public void m4537a(@NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0184c<?> abstractC0184c, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull ServerLevel serverLevel, @NotNull Set<UUID> set) {
        C0872pk c0872pkM3553a;
        int iMo5358a = 3;
        if (abstractC0863pb instanceof InterfaceC0978rk) {
            iMo5358a = ((InterfaceC0978rk) abstractC0863pb).mo5358a(this);
        }
        AbstractC0866pe abstractC0866peM4018b = abstractC0863pb.m4018b();
        AABB aabbM4534a = m4534a(iMo5358a);
        List<ServerPlayer> listA = m4572a(serverLevel, aabbM4534a, set);
        List<C0756na> listA2 = m4575a(abstractC0863pb, serverLevel, aabbM4534a);
        this.f4811gB = false;
        this.f4816e.clear();
        if (listA.isEmpty() && listA2.isEmpty()) {
            mo4541c((C0872pk) null);
            this.f4804e = null;
            this.f4805f = null;
            if (this.f4807pl <= 0) {
                this.f4806g = null;
                return;
            }
            return;
        }
        if (!listA.isEmpty()) {
            for (ServerPlayer serverPlayer : listA) {
                if (mo4538c((LivingEntity) serverPlayer)) {
                    UUID uuid = serverPlayer.getUUID();
                    AbstractC0183b abstractC0183bM1153a = abstractC0184c.m1153a((Player) serverPlayer);
                    C0872pk c0872pkM4229a = abstractC0866peM4018b.m4229a(uuid);
                    if (c0872pkM4229a != null && serverPlayer.tickCount > 20 && !C0875pn.m4488a((Player) serverPlayer, (AbstractC0183b<?, ?, ?, ?>) abstractC0183bM1153a)) {
                        String name = c0872pkM4229a.getName();
                        this.f4816e.put(name, this.f4816e.getOrDefault(name, 0) + 1);
                    }
                }
            }
        }
        if (!listA2.isEmpty()) {
            for (C0756na c0756na : listA2) {
                if (mo4538c((LivingEntity) c0756na) && (c0872pkM3553a = c0756na.m3553a()) != null && c0756na.tickCount > 20 && c0756na.isAlive()) {
                    String name2 = c0872pkM3553a.getName();
                    this.f4816e.put(name2, this.f4816e.getOrDefault(name2, 0) + 1);
                }
            }
        }
        String str = null;
        int i = 0;
        int i2 = 0;
        ObjectIterator it = this.f4816e.object2IntEntrySet().iterator();
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
        C0872pk c0872pkM4242a = null;
        if (str != null && i > i2) {
            c0872pkM4242a = abstractC0866peM4018b.m4242a(str);
        }
        if (c0872pkM4242a != null && !c0872pkM4242a.equals(this.f4803d) && mo4539a(c0872pkM4242a, abstractC0863pb)) {
            int iMo4543j = mo4543j(i - i2);
            int iMo4544bs = mo4544bs();
            if (this.f4806g != null && !this.f4806g.equals(c0872pkM4242a)) {
                this.f4807pl = 0;
            }
            for (int i3 = 0; i3 < iMo4543j; i3++) {
                if (this.f4807pl < iMo4544bs) {
                    this.f4804e = c0872pkM4242a;
                    this.f4806g = c0872pkM4242a;
                    this.f4811gB = true;
                    this.f4807pl++;
                }
                if (this.f4807pl >= iMo4544bs) {
                    C0872pk c0872pk = this.f4803d;
                    this.f4803d = c0872pkM4242a;
                    this.f4807pl = 0;
                    this.f4806g = null;
                    this.f4804e = null;
                    this.f4811gB = false;
                    if (!(abstractC0863pb instanceof InterfaceC0978rk)) {
                        break;
                    }
                    ((InterfaceC0978rk) abstractC0863pb).mo5357a(abstractC0531jN, serverLevel, this, c0872pkM4242a.getName(), c0872pk != null ? c0872pk.getName() : "", set);
                    break;
                }
            }
        } else {
            mo4541c(c0872pkM4242a);
            this.f4804e = null;
            if (this.f4807pl <= 0) {
                this.f4806g = null;
            }
        }
        if (this.f4807pl > 2 && this.f4804e != null) {
            if (!this.f4804e.equals(this.f4805f)) {
                if (this.f4803d != null) {
                    C0875pn.m4429a((AbstractC0866pe<?>) this.f4819b, this.f4803d, (Component) Component.translatable("bf.message.gamemode.notification.point.losing.msg", new Object[]{Component.literal(this.f4796bZ != null ? this.f4796bZ : "Unknown").withStyle(ChatFormatting.GRAY)}).withColor(ColorReferences.COLOR_WHITE), 80, f4790bY, this.f4827c, this.f4804e.getColor(), ColorReferences.COLOR_WHITE);
                }
                this.f4805f = this.f4804e;
                return;
            }
            return;
        }
        this.f4805f = null;
    }

    /* JADX INFO: renamed from: a */
    protected boolean mo4539a(@NotNull C0872pk c0872pk, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        return true;
    }

    /* JADX INFO: renamed from: bD */
    protected boolean mo4540bD() {
        return false;
    }

    /* JADX INFO: renamed from: c */
    protected void mo4541c(@Nullable C0872pk c0872pk) {
        if (!mo4540bD()) {
            this.f4807pl = 0;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public C0872pk mo4542c() {
        return this.f4804e;
    }

    /* JADX INFO: renamed from: j */
    protected int mo4543j(int i) {
        return i;
    }

    /* JADX INFO: renamed from: bs */
    public int mo4544bs() {
        return 12;
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m4545a(@NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb) {
        this.f4818c = m4532c();
        MutableComponent mutableComponentAppend = Component.literal(String.format("%.02f", Double.valueOf(Mth.sqrt((float) localPlayer.distanceToSqr(this.f4827c.x, this.f4827c.y, this.f4827c.z))))).withStyle(this.f4803d != null ? this.f4803d.m4312a() : Style.EMPTY.withColor(ChatFormatting.WHITE)).append(Component.literal("m").withColor(ColorReferences.COLOR_WHITE));
        Font font = Minecraft.getInstance().font;
        this.f4801A = mutableComponentAppend.getVisualOrderText();
        this.f4802lo = font.width(this.f4801A);
        if (this.f4800je != this.f4797gG) {
            this.f4800je = this.f4797gG;
            this.f4798z = this.f4797gG.getVisualOrderText();
            this.f4799ln = font.width(this.f4798z);
        }
        if (abstractC0863pb.m4023a() != EnumC0871pj.GAME) {
            return;
        }
        m4550cJ();
        m4551cK();
        C0872pk c0872pkMo4542c = mo4542c();
        if (this.f4815h != null && !this.f4815h.equals(c0872pkMo4542c)) {
            this.f4813lp = this.f4807pl;
            this.f4814lq = this.f4807pl;
        }
        this.f4815h = c0872pkMo4542c;
        this.f4814lq = this.f4813lp;
        this.f4813lp = Mth.lerp(0.4f, this.f4813lp, this.f4807pl);
        if (this.f4817pn > 0) {
            this.f4817pn--;
        }
        if (this.f4811gB) {
            int i = this.f4812dU;
            this.f4812dU = i + 1;
            if (i > 40) {
                this.f4812dU = 0;
            } else if (this.f4812dU > 0 && this.f4812dU % 5 == 0) {
                clientLevel.playLocalSound(this.f4827c.x, this.f4827c.y, this.f4827c.z, (SoundEvent) C1312xz.f7996pR.get(), SoundSource.PLAYERS, 1.0f, 1.0f, false);
            }
            if (this.f4817pn == 0 && C0495ie.f3053G.m2230U()) {
                this.f4817pn = (int) (320.0d - (5.0d * Math.random()));
                clientLevel.playLocalSound(this.f4827c.x, this.f4827c.y, this.f4827c.z, (SoundEvent) C1312xz.f7995pQ.get(), SoundSource.AMBIENT, 15.0f, this.f4795lm, false);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m4546a(@NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, @NotNull Camera camera, float f) {
        if (m4549b(frustum)) {
            PoseStack poseStackPose = guiGraphics.pose();
            float fMax = Math.max(this.f4811gB ? 0.5f * Mth.sin(f / 5.0f) : 0.5f, 0.01f) * C1270xJ.m7190j((float) camera.getPosition().distanceTo(this.f4827c), 5.0f, 0.0f);
            int color = getColor();
            ResourceLocation icon = getIcon();
            poseStackPose.pushPose();
            ResourceLocation resourceLocation = this.f4808dM;
            int iMo4544bs = mo4544bs();
            float fClamp = (resourceLocation == null || iMo4544bs <= 0) ? 0.0f : Mth.clamp(this.f4813lp / iMo4544bs, 0.0f, 1.0f);
            if (fClamp > 0.0f) {
                C0129bt.m614a(poseStackPose, camera, guiGraphics, f4791dL, this.f4827c.x, this.f4827c.y + 2.299999952316284d, this.f4827c.z, 50, 50, fMax, color, false, fClamp, true);
                if (icon != null) {
                    C0129bt.m614a(poseStackPose, camera, guiGraphics, icon, this.f4827c.x, this.f4827c.y + 2.299999952316284d, this.f4827c.z, 50, 50, fMax, ColorReferences.COLOR_WHITE, false, fClamp, true);
                }
                C0129bt.m614a(poseStackPose, camera, guiGraphics, f4791dL, this.f4827c.x, this.f4827c.y + 2.299999952316284d, this.f4827c.z, 50, 50, fMax, this.f4809pm, false, fClamp, false);
                C0129bt.m614a(poseStackPose, camera, guiGraphics, resourceLocation, this.f4827c.x, this.f4827c.y + 2.299999952316284d, this.f4827c.z, 50, 50, fMax, ColorReferences.COLOR_WHITE, false, fClamp, false);
            } else {
                C0129bt.m612a(poseStackPose, camera, guiGraphics, f4791dL, this.f4827c.x, this.f4827c.y + 2.299999952316284d, this.f4827c.z, 50, 50, fMax, color, false);
                if (icon != null) {
                    C0129bt.m610a(poseStackPose, camera, guiGraphics, icon, this.f4827c.x, this.f4827c.y + 2.299999952316284d, this.f4827c.z, 50, 50, fMax, false);
                }
            }
            poseStackPose.popPose();
        }
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void m4547a(@NotNull Frustum frustum, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull MultiBufferSource.BufferSource bufferSource) {
        FormattedCharSequence formattedCharSequence = this.f4801A;
        if (formattedCharSequence == null || !m4549b(frustum)) {
            return;
        }
        C0129bt.m624a(poseStack, font, camera, (MultiBufferSource) bufferSource, formattedCharSequence, this.f4802lo, this.f4827c.x, this.f4827c.y + 1.600000023841858d, this.f4827c.z, 1.0f, ColorReferences.COLOR_WHITE, true);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    public void m4548b(@NotNull Frustum frustum, @NotNull PoseStack poseStack, @NotNull Font font, @NotNull Camera camera, @NotNull MultiBufferSource.BufferSource bufferSource) {
        FormattedCharSequence formattedCharSequence = this.f4798z;
        if (formattedCharSequence == null || !m4549b(frustum)) {
            return;
        }
        C0129bt.m624a(poseStack, font, camera, (MultiBufferSource) bufferSource, formattedCharSequence, this.f4799ln, this.f4827c.x, this.f4827c.y + 3.5d, this.f4827c.z, 2.0f, ColorReferences.COLOR_WHITE, true);
    }

    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: b */
    private boolean m4549b(@NotNull Frustum frustum) {
        return C0495ie.f3031k.m2230U() && frustum.isVisible(this.f4818c);
    }

    @Override // com.boehmod.blockfront.C0881pt
    /* JADX INFO: renamed from: b */
    public void mo3869b(@NotNull ByteBuf byteBuf) throws IOException {
        AABB aabb;
        super.mo3869b(byteBuf);
        this.f4818c = m4532c();
        this.f4796bZ = IPacket.readString(byteBuf);
        String string = IPacket.readString(byteBuf);
        this.f4807pl = byteBuf.readInt();
        this.f4811gB = IPacket.readBoolean(byteBuf);
        String string2 = IPacket.readString(byteBuf);
        String string3 = IPacket.readString(byteBuf);
        if (IPacket.readBoolean(byteBuf)) {
            aabb = new AABB(byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble(), byteBuf.readDouble());
        } else {
            aabb = null;
        }
        this.f4810g = aabb;
        this.f4803d = string.isEmpty() ? null : this.f4819b.m4242a(string);
        this.f4804e = string2.isEmpty() ? null : this.f4819b.m4242a(string2);
        this.f4806g = string3.isEmpty() ? null : this.f4819b.m4242a(string3);
        this.f4805f = null;
        this.f4797gG = Component.literal(this.f4796bZ.toUpperCase(Locale.ROOT)).withStyle(C0533jP.f3185b);
    }

    @Override // com.boehmod.blockfront.C0881pt
    /* JADX INFO: renamed from: c */
    public void mo3870c(@NotNull ByteBuf byteBuf) throws IOException {
        super.mo3870c(byteBuf);
        IPacket.writeString(byteBuf, this.f4796bZ);
        IPacket.writeString(byteBuf, this.f4803d != null ? this.f4803d.getName() : "");
        byteBuf.writeInt(this.f4807pl);
        IPacket.writeBoolean(byteBuf, this.f4811gB);
        IPacket.writeString(byteBuf, this.f4804e != null ? this.f4804e.getName() : "");
        IPacket.writeString(byteBuf, this.f4806g != null ? this.f4806g.getName() : "");
        IPacket.writeBoolean(byteBuf, this.f4810g != null);
        if (this.f4810g != null) {
            byteBuf.writeDouble(this.f4810g.minX);
            byteBuf.writeDouble(this.f4810g.minY);
            byteBuf.writeDouble(this.f4810g.minZ);
            byteBuf.writeDouble(this.f4810g.maxX);
            byteBuf.writeDouble(this.f4810g.maxY);
            byteBuf.writeDouble(this.f4810g.maxZ);
        }
    }

    @Nullable
    public ResourceLocation getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: cJ */
    private void m4550cJ() {
        if (this.f4803d == null) {
            this.icon = null;
        } else {
            this.icon = C0532jO.m2378d("textures/gui/game/capturepoint/" + this.f4803d.getName().toLowerCase(Locale.ROOT) + ".png");
        }
    }

    /* JADX INFO: renamed from: cK */
    private void m4551cK() {
        C0872pk c0872pkMo4542c = mo4542c();
        if (c0872pkMo4542c == null) {
            this.f4808dM = null;
            this.f4809pm = ColorReferences.COLOR_WHITE;
        } else {
            this.f4808dM = C0532jO.m2378d("textures/gui/game/capturepoint/" + c0872pkMo4542c.getName().toLowerCase(Locale.ROOT) + ".png");
            TextColor color = c0872pkMo4542c.m4312a().getColor();
            this.f4809pm = color != null ? color.getValue() : ColorReferences.COLOR_WHITE;
        }
    }

    public int getColor() {
        if (this.f4803d != null) {
            return ((TextColor) Objects.requireNonNull(this.f4803d.m4312a().getColor())).getValue();
        }
        return ColorReferences.COLOR_WHITE;
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public C0872pk m4552d() {
        return this.f4803d;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public C0872pk m4553e() {
        return this.f4804e;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4554a(@Nullable C0872pk c0872pk) {
        if (c0872pk == null || this.f4803d == null) {
            return false;
        }
        return this.f4803d.equals(c0872pk);
    }

    /* JADX INFO: renamed from: b */
    public boolean m4555b(@Nullable C0872pk c0872pk) {
        if (c0872pk == null || this.f4804e == null) {
            return false;
        }
        return this.f4804e.equals(c0872pk);
    }

    /* JADX INFO: renamed from: bd */
    public void m4556bd() {
        this.f4804e = null;
        this.f4805f = null;
        this.f4806g = null;
        this.f4803d = null;
        this.f4807pl = 0;
        this.f4811gB = false;
        this.f4816e.clear();
    }

    /* JADX INFO: renamed from: b */
    public int m4557b(@NotNull String str) {
        return this.f4816e.getOrDefault(str, 0);
    }

    /* JADX INFO: renamed from: a */
    public int m4558a(@Nullable C0872pk c0872pk) {
        if (c0872pk == null) {
            return 0;
        }
        return this.f4816e.getOrDefault(c0872pk.getName(), 0);
    }

    @NotNull
    /* JADX INFO: renamed from: b */
    public Object2IntMap<String> m4559b() {
        return new Object2IntOpenHashMap(this.f4816e);
    }
}
