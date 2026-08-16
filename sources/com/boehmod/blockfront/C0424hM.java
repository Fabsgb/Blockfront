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

/* JADX INFO: renamed from: com.boehmod.blockfront.hM */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/hM.class */
public class C0424hM implements InterfaceC0420hI {

    /* JADX INFO: renamed from: db */
    @Nonnull
    private static final ResourceLocation f2694db = C0532jO.m2378d("textures/misc/debug/vehicle_seat.png");

    /* JADX INFO: renamed from: kG */
    private static final int f2695kG = 3;

    /* JADX INFO: renamed from: i */
    @NotNull
    private final Vector3f f2696i = new Vector3f();

    @Override // com.boehmod.blockfront.InterfaceC0420hI
    /* JADX INFO: renamed from: a */
    public void mo1970a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0623l c0623l, @NotNull ClientLevel clientLevel, @NotNull C0396gl c0396gl, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, MultiBufferSource.BufferSource bufferSource, @NotNull Font font, @NotNull Camera camera, @NotNull Iterable<Entity> iterable, @NotNull Random random, float f) {
        if (minecraft.getDebugOverlay().showDebugScreen()) {
            for (C0057aa c0057aa : C0111bb.f718j) {
                C0129bt.m575a(camera, poseStack, c0057aa.m261a(), c0057aa.m262b(), 3.0f, c0057aa.getColor(), c0057aa.m260b());
            }
            for (Entity entity : iterable) {
                if (entity instanceof AbstractC0750nU) {
                    AbstractC0750nU abstractC0750nU = (AbstractC0750nU) entity;
                    float yRot = abstractC0750nU.getYRot();
                    Vec3 vec3Position = abstractC0750nU.position();
                    C0809oa<AbstractC0750nU> c0809oaM3436b = abstractC0750nU.m3436b();
                    float f2 = (-yRot) * 0.017453292f;
                    for (C0755nZ c0755nZ : c0809oaM3436b.f4372aq) {
                        this.f2696i.set(c0755nZ.f4180m).rotateY(f2);
                        double d = vec3Position.x + ((double) this.f2696i.x);
                        double d2 = vec3Position.y + ((double) this.f2696i.y);
                        double d3 = vec3Position.z + ((double) this.f2696i.z);
                        this.f2696i.set(c0755nZ.f4179e).rotateY(f2);
                        C0129bt.m610a(poseStack, camera, guiGraphics, f2694db, d + ((double) this.f2696i.x), d2 + ((double) this.f2696i.y), d3 + ((double) this.f2696i.z), 16, 16, 1.0f, false);
                    }
                    Iterator it = c0809oaM3436b.f4373ar.iterator();
                    while (it.hasNext()) {
                        AbstractC0818oj abstractC0818oj = (AbstractC0818oj) it.next();
                        this.f2696i.set(abstractC0818oj.f4437e).rotateY(f2);
                        C0129bt.m610a(poseStack, camera, guiGraphics, abstractC0818oj.mo3769y(), vec3Position.x + ((double) this.f2696i.x), vec3Position.y + ((double) this.f2696i.y), vec3Position.z + ((double) this.f2696i.z), 16, 16, 1.0f, false);
                    }
                    Iterator it2 = c0809oaM3436b.f4375as.iterator();
                    while (it2.hasNext()) {
                        AbstractC0814of abstractC0814of = (AbstractC0814of) it2.next();
                        float f3 = (-(yRot + 90.0f)) * 0.017453292f;
                        float fCos = Mth.cos(f3);
                        float fSin = Mth.sin(f3);
                        Vec3 vec3 = abstractC0814of.f4404r;
                        C0129bt.m610a(poseStack, camera, guiGraphics, abstractC0814of.mo3746y(), vec3Position.x + (vec3.x * ((double) fCos)) + (vec3.z * ((double) fSin)), vec3Position.y + vec3.y, vec3Position.z + ((vec3.z * ((double) fCos)) - (vec3.x * ((double) fSin))), 16, 16, 1.0f, false);
                    }
                }
            }
        }
    }
}
