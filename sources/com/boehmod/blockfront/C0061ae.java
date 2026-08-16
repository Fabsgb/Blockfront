package com.boehmod.blockfront;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.LightTexture;
import net.neoforged.neoforge.client.extensions.IDimensionSpecialEffectsExtension;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3f;

/* JADX INFO: renamed from: com.boehmod.blockfront.ae */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/ae.class */
public class C0061ae extends DimensionSpecialEffects.OverworldEffects implements IDimensionSpecialEffectsExtension {

    /* JADX INFO: renamed from: R */
    static final /* synthetic */ boolean f426R;

    static {
        f426R = !C0061ae.class.desiredAssertionStatus();
    }

    public boolean renderClouds(@NotNull ClientLevel clientLevel, int i, float f, @NotNull PoseStack poseStack, double d, double d2, double d3, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f426R && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a != null) {
            return abstractC0863pbM2874a.m4089a().m6133cm();
        }
        return false;
    }

    public boolean renderSky(@NotNull ClientLevel clientLevel, int i, float f, @NotNull Matrix4f matrix4f, @NotNull Camera camera, @NotNull Matrix4f matrix4f2, boolean z, @NotNull Runnable runnable) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f426R && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a != null) {
            return abstractC0863pbM2874a.m4089a().m6141co();
        }
        return false;
    }

    public boolean renderSnowAndRain(@NotNull ClientLevel clientLevel, int i, float f, @NotNull LightTexture lightTexture, double d, double d2, double d3) {
        return false;
    }

    public boolean tickRain(@NotNull ClientLevel clientLevel, int i, @NotNull Camera camera) {
        return false;
    }

    public void adjustLightmapColors(@NotNull ClientLevel clientLevel, float f, float f2, float f3, float f4, int i, int i2, @NotNull Vector3f vector3f) {
        C0623l c0623lM2852b = C0623l.m2852b();
        if (!f426R && c0623lM2852b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0863pb<?, ?, ?> abstractC0863pbM2874a = c0623lM2852b.m2874a();
        if (abstractC0863pbM2874a != null) {
            C1096tv c1096tvM4089a = abstractC0863pbM2874a.m4089a();
            float fM6127bd = c1096tvM4089a.m6127bd();
            if (fM6127bd > 0.0f) {
                int iM6126cg = c1096tvM4089a.m6126cg();
                vector3f.add((fM6127bd * ((iM6126cg >> 16) & 255)) / 255.0f, (fM6127bd * ((iM6126cg >> 8) & 255)) / 255.0f, (fM6127bd * (iM6126cg & 255)) / 255.0f);
            }
        }
    }
}
