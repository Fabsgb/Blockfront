package foundry.veil.impl.resource.tree;

import foundry.veil.api.resource.VeilResource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/resource/tree/VeilResourceFolder.class */
public class VeilResourceFolder {
    private final String name;
    private final Map<String, VeilResourceFolder> subFolders = new TreeMap();
    private final Map<String, VeilResource<?>> resources = new TreeMap();
    private final ArrayList<VeilResource<?>> renderResources = new ArrayList<>();
    private final List<VeilResource<?>> renderResourcesView = Collections.unmodifiableList(this.renderResources);
    private boolean dirty;

    public VeilResourceFolder(String name) {
        this.name = name;
    }

    public void addResource(String path, VeilResource<?> resource) {
        if (path.contains("/")) {
            String[] parts = path.split("/", 2);
            VeilResourceFolder folder = this.subFolders.computeIfAbsent(parts[0], VeilResourceFolder::new);
            folder.addResource(parts[1], resource);
        } else {
            this.resources.put(path, resource);
            this.dirty = true;
        }
    }

    public void addFolder(VeilResourceFolder folder) {
        this.subFolders.put(folder.name, folder);
    }

    public Collection<VeilResourceFolder> getSubFolders() {
        return this.subFolders.values();
    }

    public Collection<VeilResource<?>> getResources() {
        return this.resources.values();
    }

    public List<VeilResource<?>> getRenderResources() {
        if (this.dirty) {
            Collection<VeilResource<?>> values = this.resources.values();
            this.renderResources.clear();
            this.renderResources.ensureCapacity(values.size());
            for (VeilResource<?> resource : values) {
                if (!resource.resourceInfo().hidden()) {
                    this.renderResources.add(resource);
                }
            }
            this.renderResources.trimToSize();
        }
        return this.renderResourcesView;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public VeilResourceFolder getFolder(String path) {
        VeilResourceFolder folder = this;
        String[] parts = path.split("/");
        for (int i = 0; i < parts.length - 1; i++) {
            folder = folder.subFolders.get(parts[i]);
            if (folder == null) {
                return null;
            }
        }
        return folder.subFolders.get(path);
    }

    @Nullable
    public VeilResource<?> getResource(String path) {
        VeilResourceFolder folder = this;
        String[] parts = path.split("/");
        for (int i = 0; i < parts.length - 1; i++) {
            folder = folder.subFolders.get(parts[i]);
            if (folder == null) {
                return null;
            }
        }
        return folder.resources.get(parts[parts.length - 1]);
    }
}
