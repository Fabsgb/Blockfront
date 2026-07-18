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

/* JADX INFO: renamed from: com.boehmod.blockfront.Y */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/Y.class */
public class C0027Y extends DimensionSpecialEffects.OverworldEffects implements IDimensionSpecialEffectsExtension {

    /* JADX INFO: renamed from: M */
    static final /* synthetic */ boolean f242M;

    static {
        f242M = !C0027Y.class.desiredAssertionStatus();
    }

    public boolean renderClouds(@NotNull ClientLevel clientLevel, int i, float f, @NotNull PoseStack poseStack, double d, double d2, double d3, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f242M && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a != null) {
            return abstractC0787oFM2688a.m3653a().m5645cc();
        }
        return false;
    }

    public boolean renderSky(@NotNull ClientLevel clientLevel, int i, float f, @NotNull Matrix4f matrix4f, @NotNull Camera camera, @NotNull Matrix4f matrix4f2, boolean z, @NotNull Runnable runnable) {
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f242M && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a != null) {
            return abstractC0787oFM2688a.m3653a().m5653ce();
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
        C0622l c0622lM2667b = C0622l.m2667b();
        if (!f242M && c0622lM2667b == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        AbstractC0787oF<?, ?, ?> abstractC0787oFM2688a = c0622lM2667b.m2688a();
        if (abstractC0787oFM2688a != null) {
            C1018sY c1018sYM3653a = abstractC0787oFM2688a.m3653a();
            float fM5639aX = c1018sYM3653a.m5639aX();
            if (fM5639aX > 0.0f) {
                int iM5638bR = c1018sYM3653a.m5638bR();
                vector3f.add((fM5639aX * ((iM5638bR >> 16) & 255)) / 255.0f, (fM5639aX * ((iM5638bR >> 8) & 255)) / 255.0f, (fM5639aX * (iM5638bR & 255)) / 255.0f);
            }
        }
    }
}
