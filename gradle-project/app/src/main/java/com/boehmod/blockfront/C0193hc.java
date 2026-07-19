package com.boehmod.blockfront;

import com.boehmod.blockfront.tO;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.mutable.MutableInt;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2f;
import org.joml.Vector3f;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.object.GeoCube;

/* JADX INFO: renamed from: com.boehmod.blockfront.hc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hc.class */
public class C0193hc<T extends tO<T>> extends AbstractC0201hk<T> {

    @NotNull
    private static final List<gY> M = new ObjectArrayList();

    @NotNull
    private static final List<gX> N = new ObjectArrayList();

    public C0193hc(@NotNull gW<T> gWVar) {
        super(gWVar);
    }

    public static void aO() {
        M.removeIf((v0) -> {
            return v0.S();
        });
        N.removeIf((v0) -> {
            return v0.S();
        });
    }

    public static void a(@NotNull Random random, @NotNull String str, boolean z) {
        gY gYVar = new gY(new Vector2f(1.0f, (-1.0f) + ((-0.2f) * random.nextFloat())), str, z);
        gYVar.S();
        M.add(gYVar);
        if (hN.O.T()) {
            gX gXVar = new gX(random, z);
            gXVar.S();
            N.add(gXVar);
        }
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public void a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, float f, float f2, float f3, float f4) {
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull GuiGraphics guiGraphics, @NotNull GeoBone geoBone, @NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull T t, boolean z, int i, int i2, int i3, float f, float f2, float f3) {
        if (!itemDisplayContext.firstPerson() || (InterfaceC0638xq.a(geoBone) & 32) == 0 || z) {
            return false;
        }
        Vector3f vector3fPosition = ((GeoCube) geoBone.getCubes().getFirst()).quads()[0].vertices()[0].position();
        poseStack.pushPose();
        poseStack.translate(vector3fPosition.x, vector3fPosition.y, vector3fPosition.z);
        poseStack.mulPose(Axis.XP.rotationDegrees(180.0f));
        Iterator<gY> it = M.iterator();
        while (it.hasNext()) {
            it.next().c(poseStack, guiGraphics, f3);
        }
        Iterator<gX> it2 = N.iterator();
        while (it2.hasNext()) {
            it2.next().a(poseStack, guiGraphics, f, f3);
        }
        poseStack.popPose();
        return true;
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, @NotNull GeoBone geoBone, @NotNull T t, @NotNull ItemStack itemStack, @NotNull ResourceLocation resourceLocation, @NotNull ItemDisplayContext itemDisplayContext, @NotNull VertexConsumer vertexConsumer, boolean z, float f, int i, int i2, int i3) {
        return false;
    }

    @Override // com.boehmod.blockfront.AbstractC0201hk
    public boolean a(@NotNull Minecraft minecraft, @NotNull PoseStack poseStack, @NotNull ItemStack itemStack, @NotNull MutableInt mutableInt, @Nullable uH uHVar, @NotNull ItemDisplayContext itemDisplayContext, @NotNull fT fTVar) {
        return false;
    }
}
