package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.qV */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/qV.class */
public class C0910qV extends AbstractC0858pW {

    /* JADX INFO: renamed from: eB */
    @NotNull
    private static final ResourceLocation f5088eB = C0532jO.m2378d("textures/misc/debug/mapeffect/surrender_paper.png");

    /* JADX INFO: renamed from: L */
    @NotNull
    public static final MapCodec<C0910qV> f5089L = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0859pX.f4599C.listOf().fieldOf("positions").forGetter(c0910qV -> {
            return c0910qV.f5091ae;
        })).apply(instance, list -> {
            return new C0910qV(new ObjectArrayList(list));
        });
    });

    /* JADX INFO: renamed from: eC */
    @NotNull
    private static final ResourceLocation f5090eC = C0532jO.m2378d("textures/gui/menu/icons/arrow_down.png");

    /* JADX INFO: renamed from: ae */
    @NotNull
    private final ObjectList<Vec3> f5091ae;

    /* JADX INFO: renamed from: qO */
    private int f5092qO;

    public C0910qV() {
        this(new ObjectArrayList());
    }

    public C0910qV(@NotNull ObjectList<Vec3> objectList) {
        this.f5092qO = 0;
        this.f5091ae = objectList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3952a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0531jN<?, ?, ?> abstractC0531jN, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3933a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull RandomSource randomSource, @NotNull AbstractC0863pb<?, ?, ?> abstractC0863pb, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f5092qO;
        this.f5092qO = i + 1;
        if (i >= 20) {
            this.f5092qO = 0;
            ObjectListIterator it = this.f5091ae.iterator();
            while (it.hasNext()) {
                Vec3 vec3 = (Vec3) it.next();
                C0490iZ.m2218a(minecraft, c0623l, clientLevel, (SimpleParticleType) C1309xw.f7861nx.get(), vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3944a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo3944a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        ObjectListIterator it = this.f5091ae.iterator();
        while (it.hasNext()) {
            C0129bt.m605a(poseStack, camera, guiGraphics, f5090eC, (Vec3) it.next(), 64, false);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: J */
    public List<AbstractC0927qm<?>> mo3946J() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo3946J());
        for (int i = 0; i < this.f5091ae.size(); i++) {
            int i2 = i;
            objectArrayList.add(new C0935qu(Component.literal("Position " + i2), () -> {
                return (Vec3) this.f5091ae.get(i2);
            }, vec3 -> {
                this.f5091ae.set(i2, vec3);
            }));
            objectArrayList.add(new C0923qi(Component.literal("Remove Position " + i2), () -> {
                this.f5091ae.remove(i2);
            }));
        }
        objectArrayList.add(new C0923qi(Component.literal("Add Position"), () -> {
            this.f5091ae.add(Vec3.ZERO);
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: a */
    public void mo3938a(@NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo3938a(minecraft, c0623l, localPlayer, clientLevel, list);
        list.add(Component.literal("Surrender Paper: " + this.f5091ae.size() + " spawn points, timer " + this.f5092qO + "/20"));
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @NotNull
    /* JADX INFO: renamed from: y */
    public ResourceLocation mo3951y() {
        return f5088eB;
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    /* JADX INFO: renamed from: cM */
    public void mo3956cM() {
        super.mo3956cM();
    }

    @Override // com.boehmod.blockfront.AbstractC0858pW
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo3939a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo3939a(minecraft, randomSource);
        this.f5092qO = 0;
    }
}
