package foundry.veil.impl.client.imgui;

import foundry.imgui.api.ImGuiMCEvents;
import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.impl.client.editor.DemoInspector;
import foundry.veil.impl.client.editor.DeviceInfoViewer;
import foundry.veil.impl.client.editor.FramebufferInspector;
import foundry.veil.impl.client.editor.LightInspector;
import foundry.veil.impl.client.editor.ParticleEditorInspector;
import foundry.veil.impl.client.editor.PostInspector;
import foundry.veil.impl.client.editor.ResourceManagerInspector;
import foundry.veil.impl.client.editor.ShaderInspector;
import foundry.veil.impl.client.editor.TextureInspector;
import foundry.veil.platform.VeilEventPlatform;
import imgui.ImGui;
import io.github.ocelot.glslprocessor.lib.anarres.cpp.Token;
import net.minecraft.client.KeyMapping;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/imgui/VeilImGuiCompat.class */
@ApiStatus.Internal
public final class VeilImGuiCompat {
    public static final KeyMapping EDITOR_KEY = new KeyMapping("key.veil.editor", Token.XOR_EQ, "key.categories.veil");

    private VeilImGuiCompat() {
    }

    public static void load() {
        ImGuiMCEvents.INSTANCE.imGuiLoadPre(() -> {
            ImGui.getIO().addConfigFlags(1152);
        });
        ImGuiMCEvents.INSTANCE.preRenderImGuiEvent(() -> {
            VeilImGuiStylesheet.initStyles();
            AdvancedFboImGuiAreaImpl.begin();
            VeilRenderSystem.renderer().getEditorManager().render();
        });
        ImGuiMCEvents.INSTANCE.postRenderImGuiEvent(() -> {
            VeilImGuiStylesheet.initStyles();
            VeilRenderSystem.renderer().getEditorManager().renderLast();
            AdvancedFboImGuiAreaImpl.end();
        });
        VeilEventPlatform.INSTANCE.onVeilRegisterInspectors(registry -> {
            if (Veil.platform().isDevelopmentEnvironment()) {
                registry.registerInspector(new DemoInspector());
            }
            registry.registerInspector(new DeviceInfoViewer());
            registry.registerInspector(new PostInspector());
            registry.registerInspector(new ShaderInspector());
            registry.registerInspector(new TextureInspector());
            registry.registerInspector(new LightInspector());
            registry.registerInspector(new FramebufferInspector());
            registry.registerInspector(new ResourceManagerInspector());
            registry.registerInspector(new ParticleEditorInspector());
        });
    }
}
