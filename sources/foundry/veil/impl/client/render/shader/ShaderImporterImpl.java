package foundry.veil.impl.client.render.shader;

import foundry.veil.Veil;
import foundry.veil.api.client.render.shader.ShaderManager;
import foundry.veil.api.client.render.shader.processor.ShaderImporter;
import foundry.veil.api.client.render.shader.processor.ShaderPreProcessor;
import io.github.ocelot.glslprocessor.api.node.GlslTree;
import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectSets;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/ShaderImporterImpl.class */
public class ShaderImporterImpl implements ShaderImporter {
    private static final String DEPRECATED_MARKER = "#veil:deprecated";
    private final ResourceProvider resourceProvider;
    private final ObjectSet<ResourceLocation> failedImports = new ObjectArraySet();
    private final ObjectSet<ResourceLocation> addedImports = new ObjectArraySet();
    private final ObjectSet<ResourceLocation> addedImportsView = ObjectSets.unmodifiable(this.addedImports);
    private final Map<ResourceLocation, String> imports = new HashMap();

    public ShaderImporterImpl(ResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
    }

    public void reset() {
        this.addedImports.clear();
    }

    @Override // foundry.veil.api.client.render.shader.processor.ShaderImporter
    public GlslTree loadImport(ShaderPreProcessor.Context context, ResourceLocation name, boolean force) throws IOException {
        if (this.failedImports.contains(name)) {
            throw new IOException("Import previously failed to load");
        }
        if (this.addedImports.contains(name) && !force) {
            return new GlslTree();
        }
        try {
            if (!this.imports.containsKey(name)) {
                Reader reader = this.resourceProvider.openAsReader(ShaderManager.INCLUDE_LISTER.idToFile(name));
                try {
                    this.imports.put(name, IOUtils.toString(reader));
                    if (reader != null) {
                        reader.close();
                    }
                } finally {
                }
            }
            GlslTree tree = context.modifyInclude(name, this.imports.get(name));
            Iterator<String> iterator = tree.getDirectives().iterator();
            while (iterator.hasNext()) {
                String directive = iterator.next();
                if (directive.startsWith(DEPRECATED_MARKER)) {
                    iterator.remove();
                    String message = directive.substring(DEPRECATED_MARKER.length()).trim();
                    if (message.isEmpty()) {
                        Veil.LOGGER.error("Program '{}' uses deprecated import in {} shader '{}'", new Object[]{context.name(), ShaderManager.getTypeName(context.type()), name});
                    } else {
                        Veil.LOGGER.error("Program '{}' uses deprecated import in {} shader '{}': {}", new Object[]{context.name(), ShaderManager.getTypeName(context.type()), name, message});
                    }
                }
            }
            return tree;
        } catch (Throwable t) {
            this.failedImports.add(name);
            throw new IOException("Failed to add import: " + String.valueOf(name), t);
        }
    }

    @Override // foundry.veil.api.client.render.shader.processor.ShaderImporter
    public Set<ResourceLocation> addedImports() {
        return this.addedImportsView;
    }
}
