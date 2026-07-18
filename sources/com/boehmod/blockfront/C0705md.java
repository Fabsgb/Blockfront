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

/* JADX INFO: renamed from: com.boehmod.blockfront.md */
/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:com/boehmod/blockfront/md.class */
public class C0705md extends BlockTagsProvider {
    public C0705md(@NotNull PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, @NotNull ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, "bf", existingFileHelper);
    }

    protected void addTags(@NotNull HolderLookup.Provider provider) {
        ObjectListIterator it = C0628lF.f3407G.iterator();
        while (it.hasNext()) {
            tag(BlockTags.WALLS).add((Block) ((C0628lF) it.next()).f3415r.get());
        }
        ObjectListIterator it2 = C0674lz.f3597E.iterator();
        while (it2.hasNext()) {
            tag(BlockTags.WALLS).add((Block) ((C0674lz) it2.next()).f3601m.get());
        }
        ObjectListIterator it3 = C0633lK.f3463K.iterator();
        while (it3.hasNext()) {
            C0633lK c0633lK = (C0633lK) it3.next();
            tag(BlockTags.FENCES).add((Block) c0633lK.f3469R.get());
            tag(BlockTags.FENCE_GATES).add((Block) c0633lK.f3470S.get());
        }
        tag(BlockTags.CLIMBABLE).add((Block) C1218wL.f6486dB.get());
    }
}
