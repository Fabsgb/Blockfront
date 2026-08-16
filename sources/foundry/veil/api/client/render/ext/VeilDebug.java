package foundry.veil.api.client.render.ext;

import foundry.veil.Veil;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.KHRDebug;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/client/render/ext/VeilDebug.class */
public enum VeilDebug {
    DISABLED { // from class: foundry.veil.api.client.render.ext.VeilDebug.1
        @Override // foundry.veil.api.client.render.ext.VeilDebug
        public void debugMessageInsert(int type, int id, int severity, CharSequence message) {
        }

        @Override // foundry.veil.api.client.render.ext.VeilDebug
        public void objectLabel(int identifier, int name, CharSequence label) {
        }

        @Override // foundry.veil.api.client.render.ext.VeilDebug
        public void pushDebugGroup(CharSequence message) {
        }

        @Override // foundry.veil.api.client.render.ext.VeilDebug
        public void popDebugGroup() {
        }
    },
    ENABLED { // from class: foundry.veil.api.client.render.ext.VeilDebug.2
        @Override // foundry.veil.api.client.render.ext.VeilDebug
        public void debugMessageInsert(int type, int id, int severity, CharSequence message) {
            KHRDebug.glDebugMessageInsert(33354, type, id, severity, message);
        }

        @Override // foundry.veil.api.client.render.ext.VeilDebug
        public void objectLabel(int identifier, int name, @Nullable CharSequence label) {
            if (label != null) {
                KHRDebug.glObjectLabel(identifier, name, label);
            } else {
                KHRDebug.nglObjectLabel(identifier, name, 0, 0L);
            }
        }

        @Override // foundry.veil.api.client.render.ext.VeilDebug
        public void pushDebugGroup(CharSequence message) {
            KHRDebug.glPushDebugGroup(33354, 10000 + (MESSAGE_ID.incrementAndGet() * 100), message);
        }

        @Override // foundry.veil.api.client.render.ext.VeilDebug
        public void popDebugGroup() {
            KHRDebug.glPopDebugGroup();
        }
    };


    @ApiStatus.Internal
    public static final AtomicInteger MESSAGE_ID = new AtomicInteger();
    private static VeilDebug debug;

    public abstract void debugMessageInsert(int i, int i2, int i3, CharSequence charSequence);

    public abstract void objectLabel(int i, int i2, @Nullable CharSequence charSequence);

    public abstract void pushDebugGroup(CharSequence charSequence);

    public abstract void popDebugGroup();

    public static VeilDebug get() {
        if (debug == null) {
            GLCapabilities caps = GL.getCapabilities();
            if (caps.OpenGL43 || caps.GL_KHR_debug) {
                debug = ENABLED;
                Veil.LOGGER.info("GL Debug supported");
            } else {
                debug = DISABLED;
                Veil.LOGGER.info("GL Debug unsupported");
            }
        }
        return debug;
    }
}
