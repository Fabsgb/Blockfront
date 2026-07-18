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

/* JADX INFO: renamed from: com.boehmod.blockfront.hw */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/hw.class */
public class C0459hw implements InterfaceC0455hs {

    /* JADX INFO: renamed from: db */
    @Nonnull
    private static final ResourceLocation f2864db = C0564jv.m2555d("textures/misc/debug/vehicle_seat.png");

    /* JADX INFO: renamed from: jl */
    private static final int f2865jl = 3;

    /* JADX INFO: renamed from: i */
    @NotNull
    private final Vector3f f2866i = new Vector3f();

    @Override // com.boehmod.blockfront.InterfaceC0455hs
    /* JADX INFO: renamed from: a */
    public void mo2068a(@NotNull RenderLevelStageEvent renderLevelStageEvent, @NotNull Minecraft minecraft, @NotNull C0622l c0622l, @NotNull ClientLevel clientLevel, @NotNull C0326fV c0326fV, @NotNull PoseStack poseStack, @NotNull Frustum frustum, @NotNull GuiGraphics guiGraphics, MultiBufferSource.BufferSource bufferSource, @NotNull Font font, @NotNull Camera camera, @NotNull Iterable<Entity> iterable, @NotNull Random random, float f) {
        if (minecraft.getDebugOverlay().showDebugScreen()) {
            for (C0023U c0023u : C0049aT.f304i) {
                C0119bk.m475a(camera, poseStack, c0023u.m147a(), c0023u.m148b(), 3.0f, c0023u.getColor(), c0023u.m146b());
            }
            for (Entity entity : iterable) {
                if (entity instanceof AbstractC0779ny) {
                    AbstractC0779ny abstractC0779ny = (AbstractC0779ny) entity;
                    float yRot = abstractC0779ny.getYRot();
                    Vec3 vec3Position = abstractC0779ny.position();
                    C0733nE<AbstractC0779ny> c0733nEM3499b = abstractC0779ny.m3499b();
                    float f2 = (-yRot) * 0.017453292f;
                    for (C0732nD c0732nD : c0733nEM3499b.f3944aj) {
                        this.f2866i.set(c0732nD.f3932k).rotateY(f2);
                        double d = vec3Position.x + ((double) this.f2866i.x);
                        double d2 = vec3Position.y + ((double) this.f2866i.y);
                        double d3 = vec3Position.z + ((double) this.f2866i.z);
                        this.f2866i.set(c0732nD.f3931e).rotateY(f2);
                        C0119bk.m510a(poseStack, camera, guiGraphics, f2864db, d + ((double) this.f2866i.x), d2 + ((double) this.f2866i.y), d3 + ((double) this.f2866i.z), 16, 16, 1.0f, false);
                    }
                    Iterator it = c0733nEM3499b.f3945ak.iterator();
                    while (it.hasNext()) {
                        AbstractC0742nN abstractC0742nN = (AbstractC0742nN) it.next();
                        this.f2866i.set(abstractC0742nN.f4009e).rotateY(f2);
                        C0119bk.m510a(poseStack, camera, guiGraphics, abstractC0742nN.mo3397x(), vec3Position.x + ((double) this.f2866i.x), vec3Position.y + ((double) this.f2866i.y), vec3Position.z + ((double) this.f2866i.z), 16, 16, 1.0f, false);
                    }
                    Iterator it2 = c0733nEM3499b.f3947al.iterator();
                    while (it2.hasNext()) {
                        AbstractC0738nJ abstractC0738nJ = (AbstractC0738nJ) it2.next();
                        float f3 = (-(yRot + 90.0f)) * 0.017453292f;
                        float fCos = Mth.cos(f3);
                        float fSin = Mth.sin(f3);
                        Vec3 vec3 = abstractC0738nJ.f3976r;
                        C0119bk.m510a(poseStack, camera, guiGraphics, abstractC0738nJ.mo3374x(), vec3Position.x + (vec3.x * ((double) fCos)) + (vec3.z * ((double) fSin)), vec3Position.y + vec3.y, vec3Position.z + ((vec3.z * ((double) fCos)) - (vec3.x * ((double) fSin))), 16, 16, 1.0f, false);
                    }
                }
            }
        }
    }
}
