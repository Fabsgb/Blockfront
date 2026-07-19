package foundry.veil.api.client.editor;

import foundry.imgui.api.ImGuiMC;
import foundry.veil.Veil;
import foundry.veil.VeilClient;
import foundry.veil.api.event.VeilRegisterInspectorsEvent;
import foundry.veil.api.resource.VeilEditorEnvironment;
import foundry.veil.api.resource.VeilResource;
import foundry.veil.api.resource.VeilResourceManager;
import foundry.veil.api.resource.editor.ResourceFileEditor;
import foundry.veil.api.util.CompositeReloadListener;
import imgui.ImFont;
import imgui.ImGui;
import imgui.type.ImBoolean;
import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Predicate;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import net.minecraft.server.packs.resources.ReloadableResourceManager;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.InactiveProfiler;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/editor/EditorManager.class */
public class EditorManager implements VeilEditorEnvironment, PreparableReloadListener {
    public static final ResourceLocation DEFAULT_FONT = Veil.veilPath("jetbrains_mono");
    private final Map<Inspector, ImBoolean> editors = new TreeMap(Comparator.comparing(inspector -> {
        return inspector.getClass().getSimpleName();
    }));
    private final Map<ResourceLocation, ResourceFileEditor<?>> resourceFileEditors = new Object2ObjectArrayMap();
    private boolean enabled = false;
    private boolean registered = false;

    @ApiStatus.Internal
    public EditorManager(ReloadableResourceManager resourceManager) {
        resourceManager.registerReloadListener(this);
    }

    @ApiStatus.Internal
    public void render() {
        if (!this.enabled) {
            return;
        }
        if (!this.registered) {
            this.registered = true;
            VeilClient.clientPlatform().onRegisterInspectors(new EditorRegistry(this));
            reload(CompletableFuture::completedFuture, Minecraft.getInstance().getResourceManager(), InactiveProfiler.INSTANCE, InactiveProfiler.INSTANCE, Util.backgroundExecutor(), Minecraft.getInstance());
        }
        ImGui.pushFont(ImGuiMC.getFont(DEFAULT_FONT, false, false));
        if (ImGui.beginMainMenuBar()) {
            ImFont font = ImGui.getFont();
            float dingleWidth = font.calcTextSizeAX(ImGui.getFontSize(), Float.MAX_VALUE, 0.0f, " Veil ") + 1.0f;
            float dingleHeight = ImGui.getTextLineHeightWithSpacing() + 6.0f;
            ImGui.getWindowDrawList().addRectFilled(0.0f, 0.0f, dingleWidth, dingleHeight, ImGui.getColorU32(8));
            ImGui.text("Veil ");
            for (Map.Entry<Inspector, ImBoolean> entry : this.editors.entrySet()) {
                Inspector inspector = entry.getKey();
                Component group = inspector.getGroup();
                if (group == null) {
                    if (Veil.platform().isDevelopmentEnvironment()) {
                        Veil.LOGGER.error("Editor '{}' should return Editor#DEFAULT_GROUP instead of null", inspector.getClass());
                    }
                    group = Inspector.DEFAULT_GROUP;
                }
                if (ImGui.beginMenu(group.getString())) {
                    ImBoolean enabled = entry.getValue();
                    ImGui.beginDisabled(!inspector.isEnabled());
                    if (ImGui.menuItem(inspector.getDisplayName().getString(), (String) null, enabled.get())) {
                        if (!enabled.get()) {
                            show(inspector);
                        } else {
                            hide(inspector);
                        }
                    }
                    ImGui.endDisabled();
                    ImGui.endMenu();
                }
            }
            for (Map.Entry<Inspector, ImBoolean> entry2 : this.editors.entrySet()) {
                Inspector inspector2 = entry2.getKey();
                if (entry2.getValue().get() && inspector2.isMenuBarEnabled()) {
                    ImGui.separator();
                    ImGui.textColored(-5592406, inspector2.getDisplayName().getString());
                    inspector2.renderMenuBar();
                }
            }
            ImGui.endMainMenuBar();
        }
        for (Map.Entry<Inspector, ImBoolean> entry3 : this.editors.entrySet()) {
            Inspector inspector3 = entry3.getKey();
            ImBoolean enabled2 = entry3.getValue();
            if (!inspector3.isEnabled()) {
                enabled2.set(false);
            }
            if (enabled2.get()) {
                inspector3.render();
            }
        }
        Iterator<ResourceFileEditor<?>> iterator = this.resourceFileEditors.values().iterator();
        while (iterator.hasNext()) {
            ResourceFileEditor<?> next = iterator.next();
            if (next.isClosed()) {
                next.close();
                iterator.remove();
            } else {
                next.render();
            }
        }
        ImGui.popFont();
    }

    @ApiStatus.Internal
    public void renderLast() {
        if (!this.enabled) {
            return;
        }
        ImGui.pushFont(ImGuiMC.getFont(DEFAULT_FONT, false, false));
        for (Map.Entry<Inspector, ImBoolean> entry : this.editors.entrySet()) {
            Inspector inspector = entry.getKey();
            ImBoolean enabled = entry.getValue();
            if (enabled.get()) {
                inspector.renderLast();
            }
        }
        ImGui.popFont();
    }

    @ApiStatus.Internal
    public void onFileChange(VeilResource<?> resource) {
        ResourceFileEditor<?> editor = this.resourceFileEditors.get(resource.resourceInfo().location());
        if (editor != null) {
            editor.loadFromDisk();
        }
    }

    public void show(Inspector inspector) {
        ImBoolean enabled = this.editors.get(inspector);
        if (enabled != null && !enabled.get()) {
            inspector.onShow();
            enabled.set(true);
        }
    }

    public void hide(Inspector inspector) {
        ImBoolean enabled = this.editors.get(inspector);
        if (enabled != null && enabled.get()) {
            inspector.onHide();
            enabled.set(false);
        }
    }

    public boolean isVisible(Inspector inspector) {
        ImBoolean visible = this.editors.get(inspector);
        return visible != null && visible.get();
    }

    public boolean isVisible(Predicate<Inspector> filter) {
        if (!this.enabled) {
            return false;
        }
        for (Map.Entry<Inspector, ImBoolean> entry : this.editors.entrySet()) {
            if (entry.getValue().get() && filter.test(entry.getKey())) {
                return true;
            }
        }
        return false;
    }

    public synchronized void add(Inspector inspector) {
        this.editors.computeIfAbsent(inspector, unused -> {
            return new ImBoolean();
        });
    }

    public synchronized void remove(Inspector inspector) {
        hide(inspector);
        this.editors.remove(inspector);
    }

    public void toggle() {
        this.enabled = !this.enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @NotNull
    public CompletableFuture<Void> reload(@NotNull PreparableReloadListener.PreparationBarrier preparationBarrier, @NotNull ResourceManager resourceManager, @NotNull ProfilerFiller prepareProfiler, @NotNull ProfilerFiller applyProfiler, @NotNull Executor backgroundExecutor, @NotNull Executor gameExecutor) {
        List<PreparableReloadListener> listeners = new ArrayList<>(this.editors.size());
        Iterator<Inspector> it = this.editors.keySet().iterator();
        while (it.hasNext()) {
            PreparableReloadListener preparableReloadListener = (Inspector) it.next();
            if (preparableReloadListener instanceof PreparableReloadListener) {
                PreparableReloadListener listener = preparableReloadListener;
                listeners.add(listener);
            }
        }
        Iterator<ResourceFileEditor<?>> it2 = this.resourceFileEditors.values().iterator();
        while (it2.hasNext()) {
            PreparableReloadListener preparableReloadListener2 = (ResourceFileEditor) it2.next();
            if (preparableReloadListener2 instanceof PreparableReloadListener) {
                PreparableReloadListener listener2 = preparableReloadListener2;
                listeners.add(listener2);
            }
        }
        if (listeners.isEmpty()) {
            return preparationBarrier.wait((Object) null);
        }
        PreparableReloadListener listener3 = CompositeReloadListener.of((PreparableReloadListener[]) listeners.toArray(x$0 -> {
            return new PreparableReloadListener[x$0];
        }));
        return listener3.reload(preparationBarrier, resourceManager, prepareProfiler, applyProfiler, backgroundExecutor, gameExecutor);
    }

    @Override // foundry.veil.api.resource.VeilEditorEnvironment
    public <T extends VeilResource<?>> void open(T resource, ResourceFileEditor.Factory<T> editor) {
        try {
            ResourceFileEditor<T> open = editor.open(this, resource);
            if (open != null) {
                this.resourceFileEditors.put(resource.resourceInfo().location(), open);
            }
        } catch (Throwable t) {
            Veil.LOGGER.error("Failed to open editor for resource: {}", resource.resourceInfo().location(), t);
        }
    }

    @Override // foundry.veil.api.resource.VeilEditorEnvironment
    public VeilResourceManager getResourceManager() {
        return VeilClient.resourceManager();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/editor/EditorManager$EditorRegistry.class */
    private static final class EditorRegistry extends Record implements VeilRegisterInspectorsEvent.Registry {
        private final EditorManager editorManager;

        private EditorRegistry(EditorManager editorManager) {
            this.editorManager = editorManager;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, EditorRegistry.class), EditorRegistry.class, "editorManager", "FIELD:Lfoundry/veil/api/client/editor/EditorManager$EditorRegistry;->editorManager:Lfoundry/veil/api/client/editor/EditorManager;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, EditorRegistry.class), EditorRegistry.class, "editorManager", "FIELD:Lfoundry/veil/api/client/editor/EditorManager$EditorRegistry;->editorManager:Lfoundry/veil/api/client/editor/EditorManager;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, EditorRegistry.class, Object.class), EditorRegistry.class, "editorManager", "FIELD:Lfoundry/veil/api/client/editor/EditorManager$EditorRegistry;->editorManager:Lfoundry/veil/api/client/editor/EditorManager;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        @Override // foundry.veil.api.event.VeilRegisterInspectorsEvent.Registry
        public EditorManager editorManager() {
            return this.editorManager;
        }

        @Override // foundry.veil.api.event.VeilRegisterInspectorsEvent.Registry
        public void registerInspector(Inspector inspector) {
            this.editorManager.add(inspector);
        }
    }
}
