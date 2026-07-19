package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Iterator;
import java.util.Random;
import javax.annotation.Nonnull;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.hw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hw.class */
public class C0213hw implements InterfaceC0209hs {

    @Nonnull
    private static final ResourceLocation db = C0265jv.d("textures/misc/debug/vehicle_seat.png");
    private static final int jl = 3;

    @NotNull
    private final Vector3f i = new Vector3f();

    @Override // com.boehmod.blockfront.InterfaceC0209hs
    public void a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0297l c0297l, @NotNull ClientLevel clientLevel, @NotNull fV fVVar, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, MultiBufferSource.BufferSource bufferSource, @NotNull Font font, @NotNull Camera camera, @NotNull Iterable<Entity> iterable, @NotNull Random random, float f) {
        if (minecraft.getDebugOverlay().showDebugScreen()) {
            for (U u : aT.i) {
                C0040bk.a(camera, poseStack, u.a(), u.m163b(), 3.0f, u.getColor(), u.b());
            }
            for (Entity entity : iterable) {
                if (entity instanceof AbstractC0376ny) {
                    AbstractC0376ny abstractC0376ny = (AbstractC0376ny) entity;
                    float yRot = abstractC0376ny.getYRot();
                    Vec3 vec3Position = abstractC0376ny.position();
                    nE<AbstractC0376ny> nEVarM741b = abstractC0376ny.m741b();
                    float f2 = (-yRot) * 0.017453292f;
                    for (nD nDVar : nEVarM741b.aj) {
                        this.i.set(nDVar.k).rotateY(f2);
                        double d = vec3Position.x + ((double) this.i.x);
                        double d2 = vec3Position.y + ((double) this.i.y);
                        double d3 = vec3Position.z + ((double) this.i.z);
                        this.i.set(nDVar.e).rotateY(f2);
                        C0040bk.a(poseStack, camera, guiGraphics, db, d + ((double) this.i.x), d2 + ((double) this.i.y), d3 + ((double) this.i.z), 16, 16, 1.0f, false);
                    }
                    Iterator it = nEVarM741b.ak.iterator();
                    while (it.hasNext()) {
                        nN nNVar = (nN) it.next();
                        this.i.set(nNVar.e).rotateY(f2);
                        C0040bk.a(poseStack, camera, guiGraphics, nNVar.x(), vec3Position.x + ((double) this.i.x), vec3Position.y + ((double) this.i.y), vec3Position.z + ((double) this.i.z), 16, 16, 1.0f, false);
                    }
                    Iterator it2 = nEVarM741b.al.iterator();
                    while (it2.hasNext()) {
                        nJ nJVar = (nJ) it2.next();
                        float f3 = (-(yRot + 90.0f)) * 0.017453292f;
                        float fCos = Mth.cos(f3);
                        float fSin = Mth.sin(f3);
                        Vec3 vec3 = nJVar.r;
                        C0040bk.a(poseStack, camera, guiGraphics, nJVar.x(), vec3Position.x + (vec3.x * ((double) fCos)) + (vec3.z * ((double) fSin)), vec3Position.y + vec3.y, vec3Position.z + ((vec3.z * ((double) fCos)) - (vec3.x * ((double) fSin))), 16, 16, 1.0f, false);
                    }
                }
            }
        }
    }
}
