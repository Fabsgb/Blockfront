package foundry.veil.api.client.render.shader;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/shader/ShaderPreDefinitions.class */
public class ShaderPreDefinitions {
    private final Set<Consumer<String>> definitionCallbacks = new HashSet();
    private final Map<String, String> definitions = new HashMap();
    private final Map<String, String> definitionsView = Collections.unmodifiableMap(this.definitions);
    private final Map<String, String> staticDefinitions = new HashMap();
    private final Map<String, String> staticDefinitionsView = Collections.unmodifiableMap(this.staticDefinitions);

    public void addListener(Consumer<String> definitionCallback) {
        this.definitionCallbacks.add(definitionCallback);
    }

    public void set(String name) {
        set(name, null);
    }

    public void set(String name, String value) {
        String previous = this.definitions.put(name, value != null ? value : "");
        if (!Objects.equals(previous, value)) {
            this.definitionCallbacks.forEach(callback -> {
                callback.accept(name);
            });
        }
    }

    public void setStatic(String name) {
        setStatic(name, null);
    }

    public void setStatic(String name, @Nullable String value) {
        this.staticDefinitions.put(name, value != null ? value : "");
    }

    public void remove(String name) {
        if (this.definitions.remove(name) != null) {
            this.definitionCallbacks.forEach(callback -> {
                callback.accept(name);
            });
        }
    }

    @Nullable
    public String getDefinition(String name) {
        return this.definitions.get(name);
    }

    public Map<String, String> getDefinitions() {
        return this.definitionsView;
    }

    public Map<String, String> getStaticDefinitions() {
        return this.staticDefinitionsView;
    }
}
