package foundry.veil.forge.impl;

import com.electronwill.nightconfig.core.UnmodifiableConfig;
import com.electronwill.nightconfig.core.concurrent.ConcurrentConfig;
import com.electronwill.nightconfig.core.file.FileConfig;
import com.electronwill.nightconfig.toml.TomlFormat;
import com.mojang.datafixers.util.Pair;
import cpw.mods.niofs.union.UnionFileSystem;
import foundry.veil.Veil;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.List;
import net.neoforged.fml.loading.moddiscovery.NightConfigWrapper;
import net.neoforged.neoforgespi.language.IConfigurable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/forge/impl/ForgePackHooks.class */
@ApiStatus.Internal
public final class ForgePackHooks {
    private ForgePackHooks() {
    }

    @Nullable
    public static Pair<String, Boolean> getIcon(Path path) {
        if (!(path.getFileSystem() instanceof UnionFileSystem)) {
            return null;
        }
        Path file = path.resolve("META-INF").resolve("neoforge.mods.toml");
        if (!Files.isRegularFile(file, new LinkOption[0])) {
            return null;
        }
        try {
            FileConfig fileConfig = FileConfig.builder(file).build();
            fileConfig.load();
            fileConfig.close();
            NightConfigWrapper config = new NightConfigWrapper(copyConfig(fileConfig));
            List<? extends IConfigurable> mods = config.getConfigList(new String[]{"mods"});
            if (mods.isEmpty()) {
                return null;
            }
            IConfigurable mod = (IConfigurable) mods.getFirst();
            String logoFile = (String) mod.getConfigElement(new String[]{"logoFile"}).orElse(null);
            boolean logoBlur = ((Boolean) mod.getConfigElement(new String[]{"logoBlur"}).orElse(true)).booleanValue();
            if (logoFile != null) {
                return Pair.of(logoFile, Boolean.valueOf(logoBlur));
            }
            return null;
        } catch (Throwable t) {
            Veil.LOGGER.error("Failed to load mod icon", t);
            return null;
        }
    }

    private static UnmodifiableConfig copyConfig(ConcurrentConfig config) {
        TomlFormat format = TomlFormat.instance();
        return format.createParser().parse(format.createWriter().writeToString(config)).unmodifiable();
    }
}
