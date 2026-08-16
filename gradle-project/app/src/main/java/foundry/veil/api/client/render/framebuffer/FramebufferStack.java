package foundry.veil.api.client.render.framebuffer;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import foundry.veil.Veil;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector4i;
import org.lwjgl.opengl.GL30C;
import org.lwjgl.system.MemoryStack;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/framebuffer/FramebufferStack.class */
public class FramebufferStack {
    private static final List<State> STATE_STACK = new ArrayList(1);
    private static ResourceLocation lastPop;

    public static void push(@Nullable ResourceLocation name) {
        if (name != null && !STATE_STACK.isEmpty() && name.equals(((State) STATE_STACK.getLast()).name)) {
            return;
        }
        Vector4i viewport = new Vector4i();
        MemoryStack stack = MemoryStack.stackPush();
        try {
            IntBuffer bufer = stack.mallocInt(4);
            GL30C.glGetIntegerv(2978, bufer);
            viewport.set(bufer);
            if (stack != null) {
                stack.close();
            }
            STATE_STACK.add(new State(viewport, GL30C.glGetInteger(36006), GL30C.glGetInteger(36010), GL30C.glGetInteger(36006), name));
            lastPop = null;
        } catch (Throwable th) {
            if (stack != null) {
                try {
                    stack.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static void pop(@Nullable ResourceLocation name) {
        if (lastPop != null && lastPop.equals(name)) {
            return;
        }
        if (STATE_STACK.isEmpty()) {
            Veil.LOGGER.error("Popped empty Framebuffer stack");
            lastPop = null;
            return;
        }
        lastPop = name;
        State state = (State) STATE_STACK.removeFirst();
        if (state.framebuffer == AdvancedFbo.getMainFramebuffer().getId()) {
            AdvancedFbo.unbind();
            return;
        }
        Vector4i viewport = state.viewport;
        GlStateManager._glBindFramebuffer(36160, state.framebuffer);
        GlStateManager._glBindFramebuffer(36008, state.readFramebuffer);
        GlStateManager._glBindFramebuffer(36009, state.drawFramebuffer);
        RenderSystem.viewport(viewport.x, viewport.y, viewport.z, viewport.w);
    }

    public static void clear() {
        if (!STATE_STACK.isEmpty()) {
            STATE_STACK.clear();
            AdvancedFbo.unbind();
            lastPop = null;
        }
    }

    public static boolean isEmpty() {
        return STATE_STACK.isEmpty();
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/framebuffer/FramebufferStack$State.class */
    private static final class State extends Record {
        private final Vector4i viewport;
        private final int framebuffer;
        private final int readFramebuffer;
        private final int drawFramebuffer;

        @Nullable
        private final ResourceLocation name;

        private State(Vector4i viewport, int framebuffer, int readFramebuffer, int drawFramebuffer, @Nullable ResourceLocation name) {
            this.viewport = viewport;
            this.framebuffer = framebuffer;
            this.readFramebuffer = readFramebuffer;
            this.drawFramebuffer = drawFramebuffer;
            this.name = name;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, State.class), State.class, "viewport;framebuffer;readFramebuffer;drawFramebuffer;name", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->viewport:Lorg/joml/Vector4i;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->framebuffer:I", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->readFramebuffer:I", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->drawFramebuffer:I", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->name:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, State.class), State.class, "viewport;framebuffer;readFramebuffer;drawFramebuffer;name", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->viewport:Lorg/joml/Vector4i;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->framebuffer:I", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->readFramebuffer:I", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->drawFramebuffer:I", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->name:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, State.class, Object.class), State.class, "viewport;framebuffer;readFramebuffer;drawFramebuffer;name", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->viewport:Lorg/joml/Vector4i;", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->framebuffer:I", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->readFramebuffer:I", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->drawFramebuffer:I", "FIELD:Lfoundry/veil/api/client/render/framebuffer/FramebufferStack$State;->name:Lnet/minecraft/resources/ResourceLocation;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public Vector4i viewport() {
            return this.viewport;
        }

        public int framebuffer() {
            return this.framebuffer;
        }

        public int readFramebuffer() {
            return this.readFramebuffer;
        }

        public int drawFramebuffer() {
            return this.drawFramebuffer;
        }

        @Nullable
        public ResourceLocation name() {
            return this.name;
        }
    }
}
