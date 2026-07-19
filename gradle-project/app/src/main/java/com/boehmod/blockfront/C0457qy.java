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

/* JADX INFO: renamed from: com.boehmod.blockfront.qy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/qy.class */
public class C0457qy extends pA {

    @NotNull
    private static final ResourceLocation eC = C0265jv.d("textures/misc/debug/mapeffect/surrender_paper.png");

    @NotNull
    public static final MapCodec<C0457qy> K = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(pB.C.listOf().fieldOf("positions").forGetter(c0457qy -> {
            return c0457qy.V;
        })).apply(instance, list -> {
            return new C0457qy(new ObjectArrayList(list));
        });
    });

    @NotNull
    private static final ResourceLocation eD = C0265jv.d("textures/gui/menu/icons/arrow_down.png");

    @NotNull
    private final ObjectList<Vec3> V;
    private int oP;

    public C0457qy() {
        this(new ObjectArrayList());
    }

    public C0457qy(@NotNull ObjectList<Vec3> objectList) {
        this.oP = 0;
        this.V = objectList;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull ServerLevel serverLevel, @NotNull AbstractC0264ju<?, ?, ?> abstractC0264ju, @NotNull oF<?, ?, ?> oFVar, @NotNull RandomSource randomSource, @NotNull Set<UUID> set) {
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull RandomSource randomSource, @NotNull oF<?, ?, ?> oFVar, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, float f) {
        int i = this.oP;
        this.oP = i + 1;
        if (i >= 20) {
            this.oP = 0;
            ObjectListIterator it = this.V.iterator();
            while (it.hasNext()) {
                Vec3 vec3 = (Vec3) it.next();
                iG.a(minecraft, c0297l, clientLevel, (SimpleParticleType) wZ.nx.get(), vec3.x, vec3.y, vec3.z, 0.0d, 0.0d, 0.0d);
            }
        }
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull RenderLevelStageEvent renderLevelStageEvent, MultiBufferSource.BufferSource bufferSource, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull Camera camera, boolean z) {
        super.a(minecraft, renderLevelStageEvent, bufferSource, poseStack, guiGraphics, font, camera, z);
        ObjectListIterator it = this.V.iterator();
        while (it.hasNext()) {
            C0040bk.a(poseStack, camera, guiGraphics, eD, (Vec3) it.next(), 64, false);
        }
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public List<pQ<?>> H() {
        ObjectArrayList objectArrayList = new ObjectArrayList(super.H());
        for (int i = 0; i < this.V.size(); i++) {
            int i2 = i;
            objectArrayList.add(new pY(Component.literal("Position " + i2), () -> {
                return (Vec3) this.V.get(i2);
            }, vec3 -> {
                this.V.set(i2, vec3);
            }));
            objectArrayList.add(new pM(Component.literal("Remove Position " + i2), () -> {
                this.V.remove(i2);
            }));
        }
        objectArrayList.add(new pM(Component.literal("Add Position"), () -> {
            this.V.add(Vec3.ZERO);
        }));
        return objectArrayList;
    }

    @Override // com.boehmod.blockfront.pA
    public void a(@NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull LocalPlayer localPlayer, @NotNull ClientLevel clientLevel, @NotNull List<Component> list) {
        super.a(minecraft, c0297l, localPlayer, clientLevel, list);
        list.add(Component.literal("Surrender Paper: " + this.V.size() + " spawn points, timer " + this.oP + "/20"));
    }

    @Override // com.boehmod.blockfront.pA
    @NotNull
    public ResourceLocation x() {
        return eC;
    }

    @Override // com.boehmod.blockfront.pA
    public void cA() {
        super.cA();
    }

    @Override // com.boehmod.blockfront.pA
    @OnlyIn(Dist.CLIENT)
    public void a(@NotNull Minecraft minecraft, @NotNull RandomSource randomSource) {
        super.a(minecraft, randomSource);
        this.oP = 0;
    }
}
