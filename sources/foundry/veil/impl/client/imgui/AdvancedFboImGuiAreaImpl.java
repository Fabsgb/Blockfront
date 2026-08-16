package foundry.veil.impl.client.imgui;

import foundry.veil.api.client.render.framebuffer.AdvancedFbo;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/imgui/AdvancedFboImGuiAreaImpl.class */
@ApiStatus.Internal
public final class AdvancedFboImGuiAreaImpl {
    private static final List<AdvancedFbo> FBO_STACK = new ArrayList();
    private static int pointer;

    private AdvancedFboImGuiAreaImpl() {
    }

    public static AdvancedFbo allocate(int width, int height) {
        if (pointer >= FBO_STACK.size()) {
            AdvancedFbo fbo = AdvancedFbo.withSize(width, height).addColorTextureBuffer().setDepthRenderBuffer().setDebugLabel("ImGui Temp " + pointer).build(true);
            FBO_STACK.add(fbo);
            pointer++;
            return fbo;
        }
        AdvancedFbo fbo2 = FBO_STACK.get(pointer);
        if (fbo2.getWidth() != width || fbo2.getHeight() != height) {
            fbo2.free();
            fbo2 = AdvancedFbo.withSize(width, height).addColorTextureBuffer().setDepthRenderBuffer().setDebugLabel("ImGui Temp " + pointer).build(true);
            FBO_STACK.set(pointer, fbo2);
        }
        pointer++;
        return fbo2;
    }

    public static void begin() {
        pointer = 0;
    }

    public static void end() {
        ListIterator<AdvancedFbo> iterator = FBO_STACK.listIterator(pointer);
        while (iterator.hasNext()) {
            AdvancedFbo next = iterator.next();
            next.free();
            iterator.remove();
        }
    }
}
