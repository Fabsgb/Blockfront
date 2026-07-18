package com.boehmod.blockfront;

import com.boehmod.blockfront.C0940r;
import java.nio.file.Path;
import net.minecraft.client.Minecraft;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLPaths;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.v */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/v.class */
public final class C1153v implements InterfaceC1305z<C0940r> {

    /* JADX INFO: renamed from: x */
    public static final int f6112x = 1;

    @Override // com.boehmod.blockfront.InterfaceC1305z
    /* JADX INFO: renamed from: a */
    public boolean mo6058a(@NotNull Minecraft minecraft, @NotNull C0940r c0940r) {
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

    @Override // com.boehmod.blockfront.InterfaceC1305z
    @NotNull
    /* JADX INFO: renamed from: a */
    public C0940r.a mo6057a() {
        return C0940r.a.STARTUP;
    }
}
