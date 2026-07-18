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

/* JADX INFO: renamed from: com.boehmod.blockfront.qy */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qy.class */
public class C0938qy extends AbstractC0835pA {

    /* JADX INFO: renamed from: eC */
    @NotNull
    private static final ResourceLocation f4992eC = C0564jv.m2555d("textures/misc/debug/mapeffect/surrender_paper.png");

    /* JADX INFO: renamed from: K */
    @NotNull
    public static final MapCodec<C0938qy> f4993K = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(C0836pB.f4470C.listOf().fieldOf("positions").forGetter(c0938qy -> {
            return c0938qy.f4995V;
        })).apply(instance, list -> {
            return new C0938qy(new ObjectArrayList(list));
        });
    });

    /* JADX INFO: renamed from: eD */
    @NotNull
    private static final ResourceLocation f4994eD = C0564jv.m2555d("textures/gui/menu/icons/arrow_down.png");

    /* JADX INFO: renamed from: V */
    @NotNull
    private final ObjectList<Vec3> f4995V;

    /* JADX INFO: renamed from: oP */
    private int f4996oP;

    public C0938qy() {
        this(new ObjectArrayList());
    }

    public C0938qy(@NotNull ObjectList<Vec3> objectList) {
        this.f4996oP = 0;
        this.f4995V = objectList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4217a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0563ju<?, ?, ?> abstractC0563ju, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4220a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull RandomSource randomSource, @NotNull AbstractC0787oF<?, ?, ?> abstractC0787oF, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.f4996oP;
        this.f4996oP = i + 1;
        if (i >= 20) {
            this.f4996oP = 0;
            ObjectListIterator it = this.f4995V.iterator();
            while (it.hasNext()) {
                Vec3 vec3 = (Vec3) it.next();
                C0470iG.m2126a(minecraft, c0622l, clientLevel, (SimpleParticleType) C1232wZ.f7296nx.get(), vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
            }
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4221a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.mo4221a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        ObjectListIterator it = this.f4995V.iterator();
        while (it.hasNext()) {
            C0119bk.m505a(poseStack, camera, guiGraphics, f4994eD, (Vec3) it.next(), 64, false);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: H */
    public List<AbstractC0851pQ<?>> mo4227H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.mo4227H());
        for (int i = 0; i < this.f4995V.size(); i++) {
            int i2 = i;
            objectArrayList.add(new C0859pY(Component.literal("Position " + i2), () -> {
                return (Vec3) this.f4995V.get(i2);
            }, vec3 -> {
                this.f4995V.set(i2, vec3);
            }));
            objectArrayList.add(new C0847pM(Component.literal("Remove Position " + i2), () -> {
                this.f4995V.remove(i2);
            }));
        }
        objectArrayList.add(new C0847pM(Component.literal("Add Position"), () -> {
            this.f4995V.add(Vec3.ZERO);
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: a */
    public void mo4222a(@NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.mo4222a(minecraft, c0622l, localPlayer, clientLevel, list);
        list.add(Component.literal("Surrender Paper: " + this.f4995V.size() + " spawn points, timer " + this.f4996oP + "/20"));
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @NotNull
    /* JADX INFO: renamed from: x */
    public ResourceLocation mo4216x() {
        return f4992eC;
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    /* JADX INFO: renamed from: cA */
    public void mo4224cA() {
        super.mo4224cA();
    }

    @Override // com.boehmod.blockfront.AbstractC0835pA
    @OnlyIn(Dist.CLIENT)
    /* JADX INFO: renamed from: a */
    public void mo4225a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.mo4225a(minecraft, randomSource);
        this.f4996oP = 0;
    }
}
