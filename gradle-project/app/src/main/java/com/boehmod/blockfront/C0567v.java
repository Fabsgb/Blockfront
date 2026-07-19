package com.boehmod.blockfront;

import com.boehmod.blockfront.C0459r;
import java.nio.file.Path;
import net.minecraft.client.Minecraft;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLPaths;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/v.class */
public final class C0567v implements InterfaceC0641z<C0459r> {
    public static final int x = 1;

    @Override // com.boehmod.blockfront.InterfaceC0641z
    public boolean a(@NotNull Minecraft minecraft, @NotNull C0459r c0459r) {
        Path pathNormalize = minecraft.gameDirectory.toPath().resolve(FMLPaths.MODSDIR.relative()).toAbsolutePath().normalize();
        if (((int) ModList.get().getMods().stream().map(iModInfo -> {
            return iModInfo.getOwningFile().getFile().getFilePath();
        }).filter(path -> {
            return path.startsWith(pathNormalize);
        }).count()) > 1) {
            return true;
        }
        return false;
    }

    @Override // com.boehmod.blockfront.InterfaceC0641z
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0459r.a mo1294a() {
        return C0459r.a.STARTUP;
    }
}
