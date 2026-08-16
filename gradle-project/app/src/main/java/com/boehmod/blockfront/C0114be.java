package com.boehmod.blockfront;

import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.GraphicsStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.be */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:com/boehmod/blockfront/be.class */
public class C0114be extends AbstractC0053aW {

    /* JADX INFO: renamed from: u */
    private static final Component f769u = Component.translatable("bf.message.fabulous.graphics").withStyle(ChatFormatting.RED);

    @Override // com.boehmod.blockfront.AbstractC0053aW
    /* JADX INFO: renamed from: a */
    public void mo246a(@NotNull ClientTickEvent.Post post, @NotNull Random random, @NotNull Minecraft minecraft, @NotNull C0396gl c0396gl, @NotNull C0623l c0623l, @Nullable LocalPlayer localPlayer, @Nullable ClientLevel clientLevel, @NotNull C0394gj c0394gj, @NotNull C0555jl c0555jl, @NotNull Vec3 vec3, @NotNull BlockPos blockPos, @Nullable AbstractC0863pb<?, ?, ?> abstractC0863pb, boolean z, float f) {
        if (abstractC0863pb == null) {
            return;
        }
        OptionInstance optionInstanceGraphicsMode = minecraft.options.graphicsMode();
        if (optionInstanceGraphicsMode.get() != GraphicsStatus.FABULOUS) {
            return;
        }
        optionInstanceGraphicsMode.set(GraphicsStatus.FAST);
        minecraft.levelRenderer.allChanged();
        minecraft.options.save();
        if (localPlayer != null) {
            C0485iU.m2172c(minecraft, f769u);
        }
    }
}
