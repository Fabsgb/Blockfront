package com.boehmod.blockfront;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.bg */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/bg.class */
public final class C0116bg extends AbstractC0053aW {

    /* JADX INFO: renamed from: ca */
    private static final float f789ca = 0.8f;

    /* JADX INFO: renamed from: cb */
    private static final float f790cb = 0.005f;

    /* JADX INFO: renamed from: cc */
    private static final float f791cc = 0.1f;

    /* JADX INFO: renamed from: cd */
    public static float f792cd;

    /* JADX INFO: renamed from: cf */
    public static float f794cf;

    /* JADX INFO: renamed from: ch */
    public static float f796ch;

    /* JADX INFO: renamed from: ce */
    public static float f793ce = 0.0f;

    /* JADX INFO: renamed from: cg */
    public static float f795cg = 0.0f;

    /* JADX INFO: renamed from: ci */
    public static float f797ci = 0.0f;

    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        if (localPlayer == null) {
            C0194cv.f1564y.clear();
            C0194cv.f1565z.clear();
            return;
        }
        f795cg = f794cf;
        if (f793ce > f792cd) {
            f794cf += 0.1f * (f793ce - f792cd);
        }
        f793ce = f792cd;
        f792cd = localPlayer.getHealth();
        if (f794cf > f789ca) {
            f794cf = f789ca;
        } else if (f794cf > 0.0f) {
            f794cf -= f790cb;
            if (f794cf < 0.0f) {
                f794cf = 0.0f;
            }
        }
        f797ci = f796ch;
        f796ch = Mth.lerp(0.05f, f796ch, 0.0f);
        C0194cv.f1564y.removeIf((v0) -> {
            return v0.m1221l();
        });
        C0194cv.f1565z.removeIf((v0) -> {
            return v0.m1229l();
        });
    }
}
