package foundry.veil.impl.client.render.shader.program;

import foundry.veil.Veil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.client.render.shader.program.ShaderUniformCache;
import foundry.veil.api.client.render.shader.uniform.ShaderUniform;
import it.unimi.dsi.fastutil.ints.Int2IntArrayMap;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntArrayMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2LongArrayMap;
import it.unimi.dsi.fastutil.objects.Object2LongMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.system.MemoryUtil;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/render/shader/program/ShaderTextureCache.class */
@ApiStatus.Internal
public class ShaderTextureCache {
    private final ShaderProgram program;
    private boolean textureDirty;
    private boolean samplerDirty;
    private final Object2LongMap<CharSequence> textures = new Object2LongArrayMap();
    private final Int2IntMap samplers = new Int2IntArrayMap();
    private final Object2IntMap<CharSequence> boundSamplers = new Object2IntArrayMap();
    private IntBuffer textureBindings = null;
    private IntBuffer textureTargets = null;
    private IntBuffer samplerBindings = null;

    public ShaderTextureCache(ShaderProgram program) {
        this.program = program;
    }

    private void uploadTextures(ShaderUniformCache cache, int samplerStart) {
        this.boundSamplers.clear();
        int maxSampler = VeilRenderSystem.maxCombinedTextureUnits();
        int count = 0;
        int missingTexture = MissingTextureAtlasSprite.getTexture().getId();
        boolean hasMissing = false;
        String last = null;
        Iterator<Map.Entry<String, ShaderUniformCache.Uniform>> it = cache.getSamplers().entrySet().iterator();
        while (it.hasNext()) {
            String name = it.next().getKey();
            ShaderUniform uniform = this.program.getUniform((CharSequence) name);
            if (uniform != null) {
                long packed = this.textures.getLong(name);
                int textureId = getTextureId(packed);
                if (packed == 0 || textureId == missingTexture) {
                    if (!hasMissing) {
                        hasMissing = true;
                        int position = this.textureBindings.position();
                        for (int i = 0; i < position; i++) {
                            this.textureBindings.put(i + 1, this.textureBindings.get(i));
                            this.textureTargets.put(i + 1, this.textureTargets.get(i));
                        }
                        this.textureBindings.position(position + 1);
                        this.textureBindings.put(0, MissingTextureAtlasSprite.getTexture().getId());
                        this.textureTargets.position(position + 1);
                        this.textureTargets.put(0, 3553);
                        ObjectIterator it2 = this.boundSamplers.keySet().iterator();
                        while (it2.hasNext()) {
                            CharSequence boundSampler = (CharSequence) it2.next();
                            this.boundSamplers.computeInt(boundSampler, (unused, i2) -> {
                                return Integer.valueOf(i2.intValue() + 1);
                            });
                        }
                    }
                    uniform.setInt(0);
                    this.textures.removeLong(name);
                } else {
                    int sampler = samplerStart + count;
                    if (sampler >= maxSampler) {
                        if (!hasMissing) {
                            hasMissing = true;
                            int position2 = this.textureBindings.position();
                            for (int i3 = 0; i3 < position2 - 1; i3++) {
                                this.textureBindings.put(i3 + 1, this.textureBindings.get(i3));
                                this.textureTargets.put(i3 + 1, this.textureTargets.get(i3));
                            }
                            this.textureBindings.put(0, MissingTextureAtlasSprite.getTexture().getId());
                            this.textureTargets.put(0, 3553);
                            if (last != null) {
                                this.boundSamplers.removeInt(last);
                            }
                            ObjectIterator it3 = this.boundSamplers.keySet().iterator();
                            while (it3.hasNext()) {
                                CharSequence boundSampler2 = (CharSequence) it3.next();
                                this.boundSamplers.computeInt(boundSampler2, (unused2, i4) -> {
                                    return Integer.valueOf(i4.intValue() + 1);
                                });
                            }
                        }
                        uniform.setInt(0);
                    } else {
                        this.textureBindings.put(textureId);
                        this.textureTargets.put(getTarget(packed));
                        this.boundSamplers.put(name, sampler);
                    }
                    count++;
                    last = name;
                }
            }
        }
        ObjectIterator it4 = this.boundSamplers.object2IntEntrySet().iterator();
        while (it4.hasNext()) {
            Object2IntMap.Entry<CharSequence> entry = (Object2IntMap.Entry) it4.next();
            ShaderUniform uniform2 = this.program.getUniform((CharSequence) entry.getKey());
            if (uniform2 == null) {
                Veil.LOGGER.warn("Tried to bind sampler to unknown uniform '{}' for shader: {}", entry.getKey(), this.program.getName());
            } else {
                uniform2.setInt(entry.getIntValue());
            }
        }
        if (samplerStart + count >= maxSampler) {
            Veil.LOGGER.error("Too many samplers were bound for shader (max {}): {}", Integer.valueOf(maxSampler), this.program.getName());
        }
    }

    public void bind(ShaderUniformCache cache, int samplerStart) {
        if (this.textures.isEmpty()) {
            return;
        }
        if (this.textureDirty) {
            this.textureDirty = false;
            this.samplerDirty = true;
            if (this.textureBindings == null || this.textureBindings.capacity() < 1 + this.textures.size()) {
                this.textureBindings = MemoryUtil.memRealloc(this.textureBindings, 1 + this.textures.size());
            }
            if (this.textureTargets == null || this.textureTargets.capacity() < 1 + this.textures.size()) {
                this.textureTargets = MemoryUtil.memRealloc(this.textureTargets, 1 + this.textures.size());
            }
            this.textureBindings.clear();
            this.textureTargets.clear();
            uploadTextures(cache, samplerStart);
            this.textureBindings.flip();
            this.textureTargets.flip();
            if (this.textureBindings.limit() == 0) {
                MemoryUtil.memFree(this.textureBindings);
                MemoryUtil.memFree(this.textureTargets);
                MemoryUtil.memFree(this.samplerBindings);
                this.textureBindings = null;
                this.textureTargets = null;
                this.samplerBindings = null;
            }
        }
        if (this.textureBindings != null && this.textureBindings.limit() > 0) {
            VeilRenderSystem.bindTextures(samplerStart, this.textureTargets, this.textureBindings);
            if (this.samplerDirty) {
                this.samplerDirty = false;
                if (this.samplerBindings == null || this.samplerBindings.capacity() < this.textureBindings.limit()) {
                    this.samplerBindings = MemoryUtil.memRealloc(this.samplerBindings, this.textureBindings.limit());
                }
                this.samplerBindings.limit(this.textureBindings.limit());
                for (int i = 0; i < this.textureBindings.limit(); i++) {
                    this.samplerBindings.put(i, this.samplers.get(this.textureBindings.get(i)));
                }
            }
            VeilRenderSystem.bindSamplers(samplerStart, this.samplerBindings);
        }
    }

    public void put(CharSequence name, int target, int textureId, int samplerId) {
        long packed = packTexture(target, textureId);
        this.textureDirty |= this.textures.put(name, packed) != packed;
        if (samplerId != 0) {
            this.samplerDirty |= this.samplers.put(textureId, samplerId) != samplerId;
        } else {
            this.samplerDirty |= this.samplers.remove(textureId) != samplerId;
        }
    }

    public void remove(CharSequence name) {
        long oldPacked = this.textures.removeLong(name);
        if (oldPacked != 0) {
            this.textures.put(name, 0L);
            this.textureDirty = true;
            if (this.samplers.remove(getTextureId(oldPacked)) != 0) {
                this.samplerDirty = true;
            }
        }
    }

    public void clear() {
        this.textures.clear();
        this.samplers.clear();
        this.boundSamplers.clear();
        if (this.textureBindings != null) {
            MemoryUtil.memFree(this.textureBindings);
            this.textureBindings = null;
        }
        if (this.textureTargets != null) {
            MemoryUtil.memFree(this.textureTargets);
            this.textureTargets = null;
        }
        if (this.samplerBindings != null) {
            MemoryUtil.memFree(this.samplerBindings);
            this.samplerBindings = null;
        }
        this.textureDirty = true;
        this.samplerDirty = true;
    }

    public static long packTexture(int target, int textureId) {
        return (((long) target) << 32) | ((long) textureId);
    }

    public static int getTarget(long packed) {
        return (int) ((packed >> 32) & 4294967295L);
    }

    public static int getTextureId(long packed) {
        return (int) (packed & 4294967295L);
    }
}
