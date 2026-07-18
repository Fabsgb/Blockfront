package foundry.veil.impl.client.render.perspective;

import foundry.veil.Veil;
import java.lang.invoke.MethodHandle;
import net.minecraft.client.renderer.LevelRenderer;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/perspective/IrisPipelineAccess.class */
@ApiStatus.Internal
public class IrisPipelineAccess {
    private static final MethodHandle GETTER;
    private static final MethodHandle SETTER;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
    
        r0 = java.lang.invoke.MethodHandles.privateLookupIn(net.minecraft.client.renderer.LevelRenderer.class, java.lang.invoke.MethodHandles.lookup());
        r5 = r0.findGetter(net.minecraft.client.renderer.LevelRenderer.class, r0.getName(), r0.getType());
        r6 = r0.findSetter(net.minecraft.client.renderer.LevelRenderer.class, r0.getName(), r0.getType());
     */
    static {
        /*
            r0 = 0
            r5 = r0
            r0 = 0
            r6 = r0
            foundry.veil.api.compat.IrisCompat r0 = foundry.veil.api.compat.IrisCompat.INSTANCE     // Catch: java.lang.Exception -> L73
            if (r0 == 0) goto L70
            java.lang.Class<net.minecraft.client.renderer.LevelRenderer> r0 = net.minecraft.client.renderer.LevelRenderer.class
            java.lang.reflect.Field[] r0 = r0.getDeclaredFields()     // Catch: java.lang.Exception -> L73
            r7 = r0
            r0 = r7
            r8 = r0
            r0 = r8
            int r0 = r0.length     // Catch: java.lang.Exception -> L73
            r9 = r0
            r0 = 0
            r10 = r0
        L19:
            r0 = r10
            r1 = r9
            if (r0 >= r1) goto L70
            r0 = r8
            r1 = r10
            r0 = r0[r1]     // Catch: java.lang.Exception -> L73
            r11 = r0
            r0 = r11
            java.lang.Class r0 = r0.getType()     // Catch: java.lang.Exception -> L73
            foundry.veil.api.compat.IrisCompat r1 = foundry.veil.api.compat.IrisCompat.INSTANCE     // Catch: java.lang.Exception -> L73
            java.lang.Class r1 = r1.getPipelineClass()     // Catch: java.lang.Exception -> L73
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L73
            if (r0 == 0) goto L6a
            java.lang.Class<net.minecraft.client.renderer.LevelRenderer> r0 = net.minecraft.client.renderer.LevelRenderer.class
            java.lang.invoke.MethodHandles$Lookup r1 = java.lang.invoke.MethodHandles.lookup()     // Catch: java.lang.Exception -> L73
            java.lang.invoke.MethodHandles$Lookup r0 = java.lang.invoke.MethodHandles.privateLookupIn(r0, r1)     // Catch: java.lang.Exception -> L73
            r12 = r0
            r0 = r12
            java.lang.Class<net.minecraft.client.renderer.LevelRenderer> r1 = net.minecraft.client.renderer.LevelRenderer.class
            r2 = r11
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> L73
            r3 = r11
            java.lang.Class r3 = r3.getType()     // Catch: java.lang.Exception -> L73
            java.lang.invoke.MethodHandle r0 = r0.findGetter(r1, r2, r3)     // Catch: java.lang.Exception -> L73
            r5 = r0
            r0 = r12
            java.lang.Class<net.minecraft.client.renderer.LevelRenderer> r1 = net.minecraft.client.renderer.LevelRenderer.class
            r2 = r11
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Exception -> L73
            r3 = r11
            java.lang.Class r3 = r3.getType()     // Catch: java.lang.Exception -> L73
            java.lang.invoke.MethodHandle r0 = r0.findSetter(r1, r2, r3)     // Catch: java.lang.Exception -> L73
            r6 = r0
            goto L70
        L6a:
            int r10 = r10 + 1
            goto L19
        L70:
            goto L78
        L73:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L78:
            r0 = r5
            foundry.veil.impl.client.render.perspective.IrisPipelineAccess.GETTER = r0
            r0 = r6
            foundry.veil.impl.client.render.perspective.IrisPipelineAccess.SETTER = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: foundry.veil.impl.client.render.perspective.IrisPipelineAccess.m9161clinit():void");
    }

    @Nullable
    public static Object getPipeline(LevelRenderer levelRenderer) {
        try {
            if (GETTER != null) {
                return GETTER.invokeWithArguments(levelRenderer);
            }
            return null;
        } catch (Throwable e) {
            Veil.LOGGER.error("Error getting Iris pipeline", e);
            return null;
        }
    }

    public static void setPipeline(LevelRenderer levelRenderer, Object pipeline) {
        if (SETTER != null) {
            try {
                SETTER.invokeWithArguments(levelRenderer, pipeline);
            } catch (Throwable e) {
                Veil.LOGGER.error("Error setting Iris pipeline", e);
            }
        }
    }
}
