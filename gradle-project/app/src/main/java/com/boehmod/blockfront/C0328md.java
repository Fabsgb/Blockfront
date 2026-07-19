package com.boehmod.blockfront;

import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.boehmod.blockfront.md, reason: case insensitive filesystem */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/md.class */
public class C0328md extends BlockTagsProvider {
    public C0328md(@NotNull PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, @NotNull ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, "bf", existingFileHelper);
    }

    protected void addTags(@NotNull HolderLookup.Provider provider) {
        ObjectListIterator it = lF.G.iterator();
        while (it.hasNext()) {
            tag(BlockTags.WALLS).add((Block) ((lF) it.next()).r.get());
        }
        ObjectListIterator it2 = C0323lz.E.iterator();
        while (it2.hasNext()) {
            tag(BlockTags.WALLS).add((Block) ((C0323lz) it2.next()).m.get());
        }
        ObjectListIterator it3 = lK.K.iterator();
        while (it3.hasNext()) {
            lK lKVar = (lK) it3.next();
            tag(BlockTags.FENCES).add((Block) lKVar.R.get());
            tag(BlockTags.FENCE_GATES).add((Block) lKVar.S.get());
        }
        tag(BlockTags.CLIMBABLE).add((Block) wL.dB.get());
    }
}
