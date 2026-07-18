package foundry.veil.api.client.render;

import foundry.veil.api.client.registry.VeilShaderBufferRegistry;
import foundry.veil.api.client.render.shader.block.ShaderBlock;
import net.minecraft.client.Minecraft;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/api/client/render/GuiInfo.class */
public class GuiInfo {
    private float guiScale = 0.0f;
    private boolean enabled = false;

    public static VeilShaderBufferLayout<GuiInfo> createLayout() {
        return VeilShaderBufferLayout.builder().f32("GuiScale", (v0) -> {
            return v0.getGuiScale();
        }).build();
    }

    public void update() {
        ShaderBlock<GuiInfo> block = VeilRenderSystem.getBlock(VeilShaderBufferRegistry.GUI_INFO.get());
        if (block == null) {
            return;
        }
        this.guiScale = (float) Minecraft.getInstance().getWindow().getGuiScale();
        block.set(this);
        VeilRenderSystem.bind(VeilShaderBufferRegistry.GUI_INFO.get());
        this.enabled = true;
    }

    public void unbind() {
        VeilRenderSystem.unbind(VeilShaderBufferRegistry.GUI_INFO.get());
        this.enabled = false;
    }

    public float getGuiScale() {
        return this.guiScale;
    }

    public boolean isGuiRendering() {
        return this.enabled;
    }
}
