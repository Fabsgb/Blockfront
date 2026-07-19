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

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/Y.class */
public class Y extends DimensionSpecialEffects.OverworldEffects implements IDimensionSpecialEffectsExtension {
    static final /* synthetic */ boolean M;

    static {
        M = !Y.class.desiredAssertionStatus();
    }

    public boolean renderClouds(@NotNull ClientLevel clientLevel, int i, float f, @NotNull PoseStack poseStack, double d, double d2, double d3, @NotNull Matrix4f matrix4f, @NotNull Matrix4f matrix4f2) {
        C0297l c0297lB = C0297l.b();
        if (!M && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a != null) {
            return oFVarM591a.m767a().cc();
        }
        return false;
    }

    public boolean renderSky(@NotNull ClientLevel clientLevel, int i, float f, @NotNull Matrix4f matrix4f, @NotNull Camera camera, @NotNull Matrix4f matrix4f2, boolean z, @NotNull Runnable runnable) {
        C0297l c0297lB = C0297l.b();
        if (!M && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a != null) {
            return oFVarM591a.m767a().ce();
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
        C0297l c0297lB = C0297l.b();
        if (!M && c0297lB == null) {
            throw new AssertionError("Client mod manager is null!");
        }
        oF<?, ?, ?> oFVarM591a = c0297lB.m591a();
        if (oFVarM591a != null) {
            sY sYVarM767a = oFVarM591a.m767a();
            float fAX = sYVarM767a.aX();
            if (fAX > 0.0f) {
                int iBR = sYVarM767a.bR();
                vector3f.add((fAX * ((iBR >> 16) & 255)) / 255.0f, (fAX * ((iBR >> 8) & 255)) / 255.0f, (fAX * (iBR & 255)) / 255.0f);
            }
        }
    }
}
