package foundry.veil.impl.client.editor;

import com.mojang.blaze3d.systems.RenderSystem;
import foundry.imgui.api.ImGuiMC;
import foundry.veil.Veil;
import foundry.veil.api.client.editor.SingleWindowInspector;
import foundry.veil.api.client.imgui.VeilImGuiUtil;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.client.render.shader.ShaderPreDefinitions;
import foundry.veil.api.client.render.shader.program.ShaderProgram;
import foundry.veil.api.client.render.shader.program.ShaderUniformCache;
import foundry.veil.api.compat.IrisCompat;
import foundry.veil.api.compat.SodiumCompat;
import foundry.veil.mixin.debug.accessor.DebugGameRendererAccessor;
import foundry.veil.mixin.debug.accessor.DebugLevelRendererAccessor;
import foundry.veil.mixin.debug.accessor.DebugPostChainAccessor;
import imgui.ImGui;
import imgui.ImGuiListClipper;
import imgui.callback.ImListClipperCallback;
import imgui.type.ImBoolean;
import imgui.type.ImString;
import it.unimi.dsi.fastutil.ints.Int2IntArrayMap;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.IntIterator;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntRBTreeMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.client.renderer.PostPass;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.opengl.ARBProgramInterfaceQuery;
import org.lwjgl.opengl.GL40C;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.NativeResource;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/editor/ShaderInspector.class */
@ApiStatus.Internal
public class ShaderInspector extends SingleWindowInspector implements ResourceManagerReloadListener {
    public static final Component TITLE = Component.translatable("inspector.veil.shader.title");
    private static final Component REFRESH = Component.translatable("inspector.veil.shader.button.refresh");
    private static final Component SEARCH = Component.translatable("inspector.veil.shader.search");
    private static final Component SHADER_PROGRAMS = Component.translatable("inspector.veil.shader.shader_programs");
    private static final Component SHADER_DEFINITIONS = Component.translatable("inspector.veil.shader.definitions");
    private static final Component SHADER_DEFINITIONS_HINT = Component.translatable("inspector.veil.shader.definitions.hint");
    private static final Component OPEN_SOURCE = Component.translatable("inspector.veil.shader.open_source");
    private static final Component OPEN_SHADER_INFO = Component.translatable("inspector.veil.shader.open_shader_info");
    private static final Component SHADER_INFO_WINDOW = Component.translatable("inspector.veil.shader.shader_info");
    private static final Component SAMPLERS = Component.translatable("inspector.veil.shader.samplers");
    private static final Component UNIFORMS = Component.translatable("inspector.veil.shader.uniforms");
    private static final Component UNIFORM_BLOCKS = Component.translatable("inspector.veil.shader.uniform_blocks");
    private static final Component STORAGE_BLOCKS = Component.translatable("inspector.veil.shader.storage_blocks");
    private final Object2IntMap<ResourceLocation> shaders = new Object2IntRBTreeMap((a, b) -> {
        int compare = a.getNamespace().compareTo(b.getNamespace());
        if (compare == 0) {
            return a.getPath().compareTo(b.getPath());
        }
        return compare;
    });
    private final ImBoolean shaderInfoVisible = new ImBoolean(false);
    private final ImString programFilterText = new ImString(128);
    private Pattern programFilter = null;
    private SelectedProgram selectedProgram = null;
    private int selectedTab = 0;
    private final ImString addDefinitionText = new ImString(128);
    private final Set<String> removedDefinitions = new HashSet(1);

    private void setSelectedProgram(@Nullable ResourceLocation name) {
        if (this.selectedProgram != null) {
            this.selectedProgram.free();
        }
        if (name != null && this.shaders.containsKey(name)) {
            int program = this.shaders.getInt(name);
            if (GL40C.glIsProgram(program)) {
                this.selectedProgram = SelectedProgram.create(name, program);
                return;
            }
            Veil.LOGGER.error("Compiled shader does not exist for program: {}", name);
        }
        this.selectedProgram = null;
    }

    private void setEditShaderSource(int shader) {
    }

    private void reloadShaders() {
        if (this.selectedProgram != null) {
            this.selectedProgram.update();
        }
        this.shaders.clear();
        TabSource tabSource = TabSource.values()[this.selectedTab];
        Object2IntMap<ResourceLocation> object2IntMap = this.shaders;
        Objects.requireNonNull(object2IntMap);
        tabSource.addShaders((v1, v2) -> {
            r1.put(v1, v2);
        });
        if (isShaderInvalid() || (this.selectedProgram != null && !this.shaders.containsKey(this.selectedProgram.name))) {
            setSelectedProgram(null);
        }
    }

    private boolean isShaderInvalid() {
        return this.selectedProgram == null || this.selectedProgram.isShaderInvalid();
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getDisplayName() {
        return TITLE;
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getGroup() {
        return RENDERER_GROUP;
    }

    @Override // foundry.veil.api.client.editor.SingleWindowInspector
    protected void renderComponents() {
        this.removedDefinitions.clear();
        ImGui.beginChild("##shader_programs", (ImGui.getContentRegionAvailX() * 2.0f) / 3.0f, 0.0f);
        ImGuiMC.component(SHADER_PROGRAMS);
        TabSource[] sources = TabSource.values();
        if (ImGui.beginTabBar("##controls")) {
            if (ImGui.tabItemButton(REFRESH.getString())) {
                reloadShaders();
            }
            for (TabSource source : sources) {
                ImGui.beginDisabled(!source.active.getAsBoolean());
                if (ImGui.beginTabItem(source.displayName.getString())) {
                    if (this.selectedTab != source.ordinal()) {
                        this.selectedTab = source.ordinal();
                        setSelectedProgram(null);
                        reloadShaders();
                    }
                    ImGui.endTabItem();
                }
                ImGui.endDisabled();
            }
            ImGui.endTabBar();
        }
        while (!sources[this.selectedTab].active.getAsBoolean() && this.selectedTab > 0) {
            this.selectedTab--;
            setSelectedProgram(null);
            reloadShaders();
        }
        ImGui.setNextItemWidth(ImGui.getContentRegionAvailX());
        if (ImGui.inputTextWithHint("##search", SEARCH.getString(), this.programFilterText)) {
            String regex = this.programFilterText.get();
            this.programFilter = null;
            if (!regex.isBlank()) {
                try {
                    this.programFilter = Pattern.compile(regex);
                } catch (PatternSyntaxException e) {
                }
            }
        }
        if (ImGui.beginListBox("##programs", ImGui.getContentRegionAvailX(), -1.4E-45f)) {
            ObjectIterator it = this.shaders.object2IntEntrySet().iterator();
            while (it.hasNext()) {
                Object2IntMap.Entry<ResourceLocation> entry = (Object2IntMap.Entry) it.next();
                ResourceLocation name = (ResourceLocation) entry.getKey();
                boolean selected = this.selectedProgram != null && name.equals(this.selectedProgram.name);
                if (this.programFilter != null && !this.programFilter.matcher(name.toString()).find()) {
                    if (selected) {
                        setSelectedProgram(null);
                    }
                } else {
                    if (ImGui.selectable("##" + name.toString(), selected)) {
                        setSelectedProgram(name);
                    }
                    ImGui.sameLine();
                    VeilImGuiUtil.resourceLocation(name);
                    ImGui.pushStyleVar(14, 0.0f, ImGui.getStyle().getItemSpacingY());
                    ImGui.sameLine();
                    ImGui.text(" (" + entry.getIntValue() + ")");
                    ImGui.popStyleVar();
                }
            }
            ImGui.endListBox();
        }
        ImGui.endChild();
        ShaderPreDefinitions definitions = VeilRenderSystem.renderer().getShaderDefinitions();
        ImGui.sameLine();
        if (ImGui.beginChild("##panel", 0.0f, ImGui.getContentRegionAvailY())) {
            if (ImGui.beginChild("##open_source", 0.0f, ImGui.getContentRegionAvailY() / 2.0f)) {
                ImGuiMC.component(OPEN_SOURCE);
                openShaderButton(35632);
                openShaderButton(35633);
                openShaderButton(37305);
                openShaderButton(36313);
                openShaderButton(36488);
                openShaderButton(36487);
                ImGui.beginDisabled(this.shaderInfoVisible.get());
                if (ImGui.button(OPEN_SHADER_INFO.getString())) {
                    this.shaderInfoVisible.set(true);
                }
                ImGui.endDisabled();
            }
            ImGui.endChild();
            if (ImGui.beginChild("##shader_definitions", 0.0f, ImGui.getContentRegionAvailY())) {
                ImGuiMC.component(SHADER_DEFINITIONS);
                ImGui.setNextItemWidth(ImGui.getContentRegionAvailX());
                if (ImGui.inputTextWithHint("##add_definition", SHADER_DEFINITIONS_HINT.getString(), this.addDefinitionText, 64)) {
                    String[] parts = this.addDefinitionText.get().split("=", 2);
                    definitions.set(parts[0].trim(), parts.length > 1 ? parts[1].trim() : null);
                    this.addDefinitionText.clear();
                }
                if (ImGui.beginListBox("##definitions", -1.4E-45f, ImGui.getContentRegionAvailY())) {
                    for (Map.Entry<String, String> entry2 : definitions.getDefinitions().entrySet()) {
                        String name2 = entry2.getKey();
                        String value = entry2.getValue();
                        ImGui.pushID(name2);
                        ImGui.text(value);
                        float size = ImGui.getTextLineHeightWithSpacing();
                        ImGui.sameLine();
                        ImGui.dummy((ImGui.getContentRegionAvailX() - (ImGui.getStyle().getCellPaddingX() * 2.0f)) - size, 0.0f);
                        ImGui.sameLine();
                        if (ImGui.button("X", size, size)) {
                            this.removedDefinitions.add(name2);
                        }
                        ImGui.popID();
                    }
                    ImGui.endListBox();
                }
            }
            ImGui.endChild();
        }
        ImGui.endChild();
        Iterator<String> it2 = this.removedDefinitions.iterator();
        while (it2.hasNext()) {
            definitions.remove(it2.next());
        }
    }

    @Override // foundry.veil.api.client.editor.SingleWindowInspector, foundry.veil.api.client.editor.Inspector
    public void render() {
        ImGui.setNextWindowSizeConstraints(600.0f, 400.0f, Float.MAX_VALUE, Float.MAX_VALUE);
        super.render();
        if (this.shaderInfoVisible.get()) {
            ImGui.setNextWindowSizeConstraints(500.0f, 600.0f, Float.MAX_VALUE, Float.MAX_VALUE);
            if (ImGui.begin(SHADER_INFO_WINDOW.getString(), this.shaderInfoVisible, 256)) {
                boolean invalid = isShaderInvalid();
                ImGui.beginDisabled(invalid);
                int program = invalid ? 0 : this.selectedProgram.programId;
                ShaderUniformCache uniforms = this.selectedProgram != null ? this.selectedProgram.uniforms : null;
                if (ImGui.collapsingHeader(SAMPLERS.getString(), 32) && !invalid) {
                    ImGui.indent();
                    for (Map.Entry<String, ShaderUniformCache.Uniform> entry : uniforms.getSamplers().entrySet()) {
                        ImGui.selectable(entry.getKey() + ": " + GL40C.glGetUniformi(program, entry.getValue().location()));
                    }
                    ImGui.unindent();
                }
                if (ImGui.collapsingHeader(UNIFORMS.getString(), 32) && !invalid) {
                    ImGui.indent();
                    List<Map.Entry<String, ShaderUniformCache.Uniform>> sorted = uniforms.getUniforms().entrySet().stream().filter(entry2 -> {
                        return !uniforms.hasSampler((String) entry2.getKey());
                    }).sorted(Comparator.comparingInt(entry3 -> {
                        return ((ShaderUniformCache.Uniform) entry3.getValue()).location();
                    })).toList();
                    for (Map.Entry<String, ShaderUniformCache.Uniform> entry4 : sorted) {
                        String name = entry4.getKey();
                        ShaderUniformCache.Uniform uniform = entry4.getValue();
                        ImGui.selectable(formatUniform(name, program, uniform));
                    }
                    ImGui.unindent();
                }
                if (ImGui.collapsingHeader(UNIFORM_BLOCKS.getString(), 32) && !invalid) {
                    ImGui.indent();
                    List<Map.Entry<String, ShaderUniformCache.UniformBlock>> sorted2 = uniforms.getUniformBlocks().entrySet().stream().sorted(Comparator.comparingInt(entry5 -> {
                        return ((ShaderUniformCache.UniformBlock) entry5.getValue()).index();
                    })).toList();
                    for (Map.Entry<String, ShaderUniformCache.UniformBlock> entry6 : sorted2) {
                        String blockName = entry6.getKey();
                        if (ImGui.collapsingHeader(blockName)) {
                            ImGui.indent();
                            ShaderUniformCache.UniformBlock block = entry6.getValue();
                            RenderSystem.glBindBuffer(36662, GL40C.glGetIntegeri(35368, GL40C.glGetActiveUniformBlocki(program, block.index(), 35391)));
                            ByteBuffer data = GL40C.glMapBuffer(36662, 35000, block.size(), (ByteBuffer) null);
                            for (ShaderUniformCache.Uniform field : block.fields()) {
                                String name2 = field.name().startsWith(blockName) ? field.name().substring(blockName.length() + 1) : field.name();
                                ImGui.selectable(data != null ? formatBuffer(name2, data, field, 0) : name2);
                            }
                            GL40C.glUnmapBuffer(36662);
                            ImGui.unindent();
                        }
                    }
                    ImGui.unindent();
                }
                ImGui.beginDisabled(!VeilRenderSystem.shaderStorageBufferSupported());
                if (ImGui.collapsingHeader(STORAGE_BLOCKS.getString(), 32) && !invalid) {
                    ImGui.indent();
                    List<Map.Entry<String, ShaderUniformCache.StorageBlock>> sorted3 = uniforms.getStorageBlocks().entrySet().stream().sorted(Comparator.comparingInt(entry7 -> {
                        return ((ShaderUniformCache.StorageBlock) entry7.getValue()).index();
                    })).toList();
                    MemoryStack stack = MemoryStack.stackPush();
                    try {
                        IntBuffer properties = stack.ints(37634);
                        IntBuffer buffer = stack.mallocInt(1);
                        for (Map.Entry<String, ShaderUniformCache.StorageBlock> entry8 : sorted3) {
                            String blockName2 = entry8.getKey();
                            if (ImGui.collapsingHeader(blockName2)) {
                                ImGui.indent();
                                ShaderUniformCache.StorageBlock block2 = entry8.getValue();
                                ARBProgramInterfaceQuery.glGetProgramResourceiv(program, 37606, block2.index(), properties, (IntBuffer) null, buffer);
                                RenderSystem.glBindBuffer(36662, buffer.get(0));
                                int size = block2.array() ? GL40C.glGetBufferParameteri(36662, 34660) : block2.size();
                                final ByteBuffer data2 = GL40C.glMapBuffer(36662, 35000, size, (ByteBuffer) null);
                                ShaderUniformCache.Uniform[] fields = block2.fields();
                                for (int i = 0; i < fields.length; i++) {
                                    final ShaderUniformCache.Uniform field2 = fields[i];
                                    final String name3 = field2.name().startsWith(blockName2) ? field2.name().substring(blockName2.length() + 1) : field2.name();
                                    if (block2.array() && i >= fields.length - 1 && data2 != null) {
                                        ImGuiListClipper.forEach((data2.limit() - field2.offset()) / block2.arrayStride(), (int) ImGui.getTextLineHeightWithSpacing(), new ImListClipperCallback() { // from class: foundry.veil.impl.client.editor.ShaderInspector.1
                                            public void accept(int index) {
                                                ImGui.selectable(ShaderInspector.this.formatBuffer(name3, data2, field2, index));
                                            }
                                        });
                                    } else {
                                        ImGui.selectable(data2 != null ? formatBuffer(name3, data2, field2, 0) : name3);
                                    }
                                }
                                GL40C.glUnmapBuffer(36662);
                                ImGui.unindent();
                            }
                        }
                        if (stack != null) {
                            stack.close();
                        }
                        ImGui.unindent();
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
                ImGui.endDisabled();
                ImGui.endDisabled();
            }
            ImGui.end();
        }
    }

    private String formatUniform(String name, int program, ShaderUniformCache.Uniform uniform) {
        String uniformDoubles;
        MemoryStack stack = MemoryStack.stackPush();
        try {
            switch (uniform.type()) {
                case 5124:
                    uniformDoubles = formatUniformInts(stack, "int " + name, program, uniform.location(), 1);
                    break;
                case 5125:
                    uniformDoubles = formatUniformUInts(stack, "uint " + name, program, uniform.location(), 1);
                    break;
                case 5126:
                    uniformDoubles = formatUniformFloats(stack, "float " + name, program, uniform.location(), 1, 1);
                    break;
                case 5130:
                    uniformDoubles = formatUniformDoubles(stack, "double " + name, program, uniform.location(), 1, 1);
                    break;
                case 35664:
                    uniformDoubles = formatUniformFloats(stack, "vec2 " + name, program, uniform.location(), 2, 1);
                    break;
                case 35665:
                    uniformDoubles = formatUniformFloats(stack, "vec3 " + name, program, uniform.location(), 3, 1);
                    break;
                case 35666:
                    uniformDoubles = formatUniformFloats(stack, "vec4 " + name, program, uniform.location(), 4, 1);
                    break;
                case 35667:
                    uniformDoubles = formatUniformInts(stack, "ivec2 " + name, program, uniform.location(), 2);
                    break;
                case 35668:
                    uniformDoubles = formatUniformInts(stack, "ivec3 " + name, program, uniform.location(), 3);
                    break;
                case 35669:
                    uniformDoubles = formatUniformInts(stack, "ivec4 " + name, program, uniform.location(), 4);
                    break;
                case 35674:
                    uniformDoubles = formatUniformFloats(stack, "mat2 " + name, program, uniform.location(), 2, 2);
                    break;
                case 35675:
                    uniformDoubles = formatUniformFloats(stack, "mat3 " + name, program, uniform.location(), 3, 3);
                    break;
                case 35676:
                    uniformDoubles = formatUniformFloats(stack, "mat4 " + name, program, uniform.location(), 4, 4);
                    break;
                case 35685:
                    uniformDoubles = formatUniformFloats(stack, "mat2x3 " + name, program, uniform.location(), 2, 3);
                    break;
                case 35686:
                    uniformDoubles = formatUniformFloats(stack, "mat2x4 " + name, program, uniform.location(), 2, 4);
                    break;
                case 35687:
                    uniformDoubles = formatUniformFloats(stack, "mat3x2 " + name, program, uniform.location(), 3, 2);
                    break;
                case 35688:
                    uniformDoubles = formatUniformFloats(stack, "mat3x4 " + name, program, uniform.location(), 3, 4);
                    break;
                case 35689:
                    uniformDoubles = formatUniformFloats(stack, "mat4x2 " + name, program, uniform.location(), 4, 2);
                    break;
                case 35690:
                    uniformDoubles = formatUniformFloats(stack, "mat4x3 " + name, program, uniform.location(), 4, 3);
                    break;
                case 36294:
                    uniformDoubles = formatUniformUInts(stack, "uvec2 " + name, program, uniform.location(), 2);
                    break;
                case 36295:
                    uniformDoubles = formatUniformUInts(stack, "uvec3 " + name, program, uniform.location(), 3);
                    break;
                case 36296:
                    uniformDoubles = formatUniformUInts(stack, "uvec4 " + name, program, uniform.location(), 4);
                    break;
                case 36678:
                    uniformDoubles = formatUniformDoubles(stack, "dmat2 " + name, program, uniform.location(), 2, 2);
                    break;
                case 36679:
                    uniformDoubles = formatUniformDoubles(stack, "dmat3 " + name, program, uniform.location(), 3, 3);
                    break;
                case 36680:
                    uniformDoubles = formatUniformDoubles(stack, "dmat4 " + name, program, uniform.location(), 4, 4);
                    break;
                case 36681:
                    uniformDoubles = formatUniformDoubles(stack, "dmat2x3 " + name, program, uniform.location(), 2, 3);
                    break;
                case 36682:
                    uniformDoubles = formatUniformDoubles(stack, "dmat2x4 " + name, program, uniform.location(), 2, 4);
                    break;
                case 36683:
                    uniformDoubles = formatUniformDoubles(stack, "dmat3x2 " + name, program, uniform.location(), 3, 2);
                    break;
                case 36684:
                    uniformDoubles = formatUniformDoubles(stack, "dmat3x4 " + name, program, uniform.location(), 3, 4);
                    break;
                case 36685:
                    uniformDoubles = formatUniformDoubles(stack, "dmat4x2 " + name, program, uniform.location(), 4, 2);
                    break;
                case 36686:
                    uniformDoubles = formatUniformDoubles(stack, "dmat4x3 " + name, program, uniform.location(), 4, 3);
                    break;
                case 36860:
                    uniformDoubles = formatUniformDoubles(stack, "dvec2 " + name, program, uniform.location(), 2, 1);
                    break;
                case 36861:
                    uniformDoubles = formatUniformDoubles(stack, "dvec3 " + name, program, uniform.location(), 3, 1);
                    break;
                case 36862:
                    uniformDoubles = formatUniformDoubles(stack, "dvec4 " + name, program, uniform.location(), 4, 1);
                    break;
                default:
                    uniformDoubles = name;
                    break;
            }
            String str = uniformDoubles;
            if (stack != null) {
                stack.close();
            }
            return str;
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

    private String formatBuffer(String name, ByteBuffer buffer, ShaderUniformCache.Uniform uniform, int offset) {
        switch (uniform.type()) {
            case 5124:
                return formatInts((uniform.offset() + offset) + ": int " + name, i -> {
                    return Integer.valueOf(buffer.getInt(uniform.offset() + offset + (i.intValue() << 2)));
                }, 1);
            case 5125:
                return formatUInts((uniform.offset() + offset) + ": uint " + name, i2 -> {
                    return Integer.valueOf(buffer.getInt(uniform.offset() + offset + (i2.intValue() << 2)));
                }, 1);
            case 5126:
                return formatFloats((uniform.offset() + offset) + ": float " + name, i3 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i3.intValue() << 2)));
                }, 1, 1);
            case 5130:
                return formatDoubles((uniform.offset() + offset) + ": double " + name, i4 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i4.intValue() << 3)));
                }, 1, 1);
            case 35664:
                return formatFloats((uniform.offset() + offset) + ": vec2 " + name, i5 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i5.intValue() << 2)));
                }, 2, 1);
            case 35665:
                return formatFloats((uniform.offset() + offset) + ": vec3 " + name, i6 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i6.intValue() << 2)));
                }, 3, 1);
            case 35666:
                return formatFloats((uniform.offset() + offset) + ": vec4 " + name, i7 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i7.intValue() << 2)));
                }, 4, 1);
            case 35667:
                return formatInts((uniform.offset() + offset) + ": ivec2 " + name, i8 -> {
                    return Integer.valueOf(buffer.getInt(uniform.offset() + offset + (i8.intValue() << 2)));
                }, 2);
            case 35668:
                return formatInts((uniform.offset() + offset) + ": ivec3 " + name, i9 -> {
                    return Integer.valueOf(buffer.getInt(uniform.offset() + offset + (i9.intValue() << 2)));
                }, 3);
            case 35669:
                return formatInts((uniform.offset() + offset) + ": ivec4 " + name, i10 -> {
                    return Integer.valueOf(buffer.getInt(uniform.offset() + offset + (i10.intValue() << 2)));
                }, 4);
            case 35674:
                return formatFloats((uniform.offset() + offset) + ": mat2 " + name, i11 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i11.intValue() << 2)));
                }, 2, 2);
            case 35675:
                return formatFloats((uniform.offset() + offset) + ": mat3 " + name, i12 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i12.intValue() << 2)));
                }, 3, 3);
            case 35676:
                return formatFloats((uniform.offset() + offset) + ": mat4 " + name, i13 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i13.intValue() << 2)));
                }, 4, 4);
            case 35685:
                return formatFloats((uniform.offset() + offset) + ": mat2x3 " + name, i14 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i14.intValue() << 2)));
                }, 2, 3);
            case 35686:
                return formatFloats((uniform.offset() + offset) + ": mat2x4 " + name, i15 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i15.intValue() << 2)));
                }, 2, 4);
            case 35687:
                return formatFloats((uniform.offset() + offset) + ": mat3x2 " + name, i16 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i16.intValue() << 2)));
                }, 3, 2);
            case 35688:
                return formatFloats((uniform.offset() + offset) + ": mat3x4 " + name, i17 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i17.intValue() << 2)));
                }, 3, 4);
            case 35689:
                return formatFloats((uniform.offset() + offset) + ": mat4x2 " + name, i18 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i18.intValue() << 2)));
                }, 4, 2);
            case 35690:
                return formatFloats((uniform.offset() + offset) + ": mat4x3 " + name, i19 -> {
                    return Float.valueOf(buffer.getFloat(uniform.offset() + offset + (i19.intValue() << 2)));
                }, 4, 3);
            case 36294:
                return formatUInts((uniform.offset() + offset) + ": uvec2 " + name, i20 -> {
                    return Integer.valueOf(buffer.getInt(uniform.offset() + offset + (i20.intValue() << 2)));
                }, 2);
            case 36295:
                return formatUInts((uniform.offset() + offset) + ": uvec3 " + name, i21 -> {
                    return Integer.valueOf(buffer.getInt(uniform.offset() + offset + (i21.intValue() << 2)));
                }, 3);
            case 36296:
                return formatUInts((uniform.offset() + offset) + ": uvec4 " + name, i22 -> {
                    return Integer.valueOf(buffer.getInt(uniform.offset() + offset + (i22.intValue() << 2)));
                }, 4);
            case 36678:
                return formatDoubles((uniform.offset() + offset) + ": dmat2 " + name, i23 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i23.intValue() << 3)));
                }, 2, 2);
            case 36679:
                return formatDoubles((uniform.offset() + offset) + ": dmat3 " + name, i24 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i24.intValue() << 3)));
                }, 3, 3);
            case 36680:
                return formatDoubles((uniform.offset() + offset) + ": dmat4 " + name, i25 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i25.intValue() << 3)));
                }, 4, 4);
            case 36681:
                return formatDoubles((uniform.offset() + offset) + ": dmat2x3 " + name, i26 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i26.intValue() << 3)));
                }, 2, 3);
            case 36682:
                return formatDoubles((uniform.offset() + offset) + ": dmat2x4 " + name, i27 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i27.intValue() << 3)));
                }, 2, 4);
            case 36683:
                return formatDoubles((uniform.offset() + offset) + ": dmat3x2 " + name, i28 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i28.intValue() << 3)));
                }, 3, 2);
            case 36684:
                return formatDoubles((uniform.offset() + offset) + ": dmat3x4 " + name, i29 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i29.intValue() << 3)));
                }, 3, 4);
            case 36685:
                return formatDoubles((uniform.offset() + offset) + ": dmat4x2 " + name, i30 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i30.intValue() << 3)));
                }, 4, 2);
            case 36686:
                return formatDoubles((uniform.offset() + offset) + ": dmat4x3 " + name, i31 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i31.intValue() << 3)));
                }, 4, 3);
            case 36860:
                return formatDoubles((uniform.offset() + offset) + ": dvec2 " + name, i32 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i32.intValue() << 3)));
                }, 2, 1);
            case 36861:
                return formatDoubles((uniform.offset() + offset) + ": dvec3 " + name, i33 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i33.intValue() << 3)));
                }, 3, 1);
            case 36862:
                return formatDoubles((uniform.offset() + offset) + ": dvec4 " + name, i34 -> {
                    return Double.valueOf(buffer.getDouble(uniform.offset() + offset + (i34.intValue() << 3)));
                }, 4, 1);
            default:
                return name;
        }
    }

    private String formatUniformFloats(MemoryStack stack, String key, int program, int location, int cols, int rows) {
        FloatBuffer values = stack.mallocFloat(rows * cols);
        GL40C.glGetUniformfv(program, location, values);
        Objects.requireNonNull(values);
        return formatFloats(key, (v1) -> {
            return r2.get(v1);
        }, cols, rows);
    }

    private String formatUniformDoubles(MemoryStack stack, String key, int program, int location, int cols, int rows) {
        DoubleBuffer values = stack.mallocDouble(rows * cols);
        GL40C.glGetUniformdv(program, location, values);
        Objects.requireNonNull(values);
        return formatDoubles(key, (v1) -> {
            return r2.get(v1);
        }, cols, rows);
    }

    private String formatUniformInts(MemoryStack stack, String key, int program, int location, int cols) {
        IntBuffer values = stack.mallocInt(cols);
        GL40C.glGetUniformiv(program, location, values);
        Objects.requireNonNull(values);
        return formatInts(key, (v1) -> {
            return r2.get(v1);
        }, cols);
    }

    private String formatUniformUInts(MemoryStack stack, String key, int program, int location, int cols) {
        IntBuffer values = stack.mallocInt(cols);
        GL40C.glGetUniformuiv(program, location, values);
        Objects.requireNonNull(values);
        return formatUInts(key, (v1) -> {
            return r2.get(v1);
        }, cols);
    }

    private String formatFloats(String key, Function<Integer, Float> deserializer, int cols, int rows) {
        StringBuilder matrix = new StringBuilder(key + ":" + (rows > 1 ? '\n' : ' '));
        int[] colWidths = new int[cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int size = "%+.4f".formatted(deserializer.apply(Integer.valueOf((col * rows) + row))).length();
                if (size > colWidths[col]) {
                    colWidths[col] = size;
                }
            }
        }
        for (int row2 = 0; row2 < rows; row2++) {
            matrix.append('[');
            for (int col2 = 0; col2 < cols; col2++) {
                String value = ("%+" + colWidths[col2] + ".4f").formatted(deserializer.apply(Integer.valueOf((col2 * rows) + row2)));
                matrix.append(value).append(", ");
            }
            matrix.replace(matrix.length() - 2, matrix.length(), "]\n");
        }
        matrix.delete(matrix.length() - 1, matrix.length());
        return matrix.toString();
    }

    private String formatDoubles(String key, Function<Integer, Double> deserializer, int cols, int rows) {
        StringBuilder matrix = new StringBuilder(key + ":" + (rows > 1 ? '\n' : ' '));
        int[] colWidths = new int[cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int size = "%+.4f".formatted(deserializer.apply(Integer.valueOf((col * rows) + row))).length();
                if (size > colWidths[col]) {
                    colWidths[col] = size;
                }
            }
        }
        for (int row2 = 0; row2 < rows; row2++) {
            matrix.append('[');
            for (int col2 = 0; col2 < cols; col2++) {
                String value = ("%+" + colWidths[col2] + ".4f").formatted(deserializer.apply(Integer.valueOf((col2 * rows) + row2)));
                matrix.append(value).append(", ");
            }
            matrix.replace(matrix.length() - 2, matrix.length(), "]\n");
        }
        matrix.delete(matrix.length() - 1, matrix.length());
        return matrix.toString();
    }

    private String formatInts(String key, Function<Integer, Integer> deserializer, int cols) {
        StringBuilder matrix = new StringBuilder(key + ": [");
        int[] colWidths = new int[cols];
        for (int col = 0; col < cols; col++) {
            int size = "%+d".formatted(deserializer.apply(Integer.valueOf(col))).length();
            if (size > colWidths[col]) {
                colWidths[col] = size;
            }
        }
        for (int col2 = 0; col2 < cols; col2++) {
            String value = ("%+" + colWidths[col2] + "d").formatted(deserializer.apply(Integer.valueOf(col2)));
            matrix.append(value).append(", ");
        }
        matrix.replace(matrix.length() - 2, matrix.length(), "]");
        return matrix.toString();
    }

    private String formatUInts(String key, Function<Integer, Integer> deserializer, int cols) {
        StringBuilder matrix = new StringBuilder(key + ": [");
        int[] colWidths = new int[cols];
        for (int col = 0; col < cols; col++) {
            int size = "%+d".formatted(Long.valueOf(Integer.toUnsignedLong(deserializer.apply(Integer.valueOf(col)).intValue()))).length();
            if (size > colWidths[col]) {
                colWidths[col] = size;
            }
        }
        for (int col2 = 0; col2 < cols; col2++) {
            String value = ("%+" + colWidths[col2] + "d").formatted(Long.valueOf(Integer.toUnsignedLong(deserializer.apply(Integer.valueOf(col2)).intValue())));
            matrix.append(value).append(", ");
        }
        matrix.replace(matrix.length() - 2, matrix.length(), "]");
        return matrix.toString();
    }

    private void openShaderButton(int type) {
        boolean disabled = isShaderInvalid() || !this.selectedProgram.shaders.containsKey(type);
        ImGui.beginDisabled(disabled);
        if (disabled) {
            ImGui.pushStyleColor(21, ImGui.getColorU32(7));
        }
        ImGui.beginDisabled();
        if (ImGui.button(DeviceInfoViewer.getShaderName(type).getString())) {
            setEditShaderSource(this.selectedProgram.shaders.get(type));
        }
        if (ImGui.isItemHovered()) {
            ImGui.beginTooltip();
            ImGui.text("Text Editing is no longer supported in ImGui\nThis will be re-implemented in a future release");
            ImGui.endTooltip();
        }
        ImGui.endDisabled();
        if (disabled) {
            ImGui.popStyleColor();
        }
        ImGui.endDisabled();
    }

    @Override // foundry.veil.api.client.editor.SingleWindowInspector, foundry.veil.api.client.editor.Inspector
    public void onShow() {
        super.onShow();
        reloadShaders();
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public void onHide() {
        super.onHide();
        this.shaders.clear();
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public void free() {
        super.free();
        if (this.selectedProgram != null) {
            this.selectedProgram.free();
            this.selectedProgram = null;
        }
    }

    public void onResourceManagerReload(@NotNull ResourceManager resourceManager) {
        if (isOpen()) {
            reloadShaders();
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/editor/ShaderInspector$SelectedProgram.class */
    private static final class SelectedProgram extends Record implements NativeResource {
        private final ResourceLocation name;
        private final int programId;
        private final Int2IntMap shaders;
        private final ShaderUniformCache uniforms;
        private final Int2ObjectMap<ByteBuffer> data;

        private SelectedProgram(ResourceLocation name, int programId, Int2IntMap shaders, ShaderUniformCache uniforms, Int2ObjectMap<ByteBuffer> data) {
            this.name = name;
            this.programId = programId;
            this.shaders = shaders;
            this.uniforms = uniforms;
            this.data = data;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, SelectedProgram.class), SelectedProgram.class, "name;programId;shaders;uniforms;data", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->programId:I", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->shaders:Lit/unimi/dsi/fastutil/ints/Int2IntMap;", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->uniforms:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache;", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->data:Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, SelectedProgram.class), SelectedProgram.class, "name;programId;shaders;uniforms;data", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->programId:I", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->shaders:Lit/unimi/dsi/fastutil/ints/Int2IntMap;", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->uniforms:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache;", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->data:Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object o) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, SelectedProgram.class, Object.class), SelectedProgram.class, "name;programId;shaders;uniforms;data", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->name:Lnet/minecraft/resources/ResourceLocation;", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->programId:I", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->shaders:Lit/unimi/dsi/fastutil/ints/Int2IntMap;", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->uniforms:Lfoundry/veil/api/client/render/shader/program/ShaderUniformCache;", "FIELD:Lfoundry/veil/impl/client/editor/ShaderInspector$SelectedProgram;->data:Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;").dynamicInvoker().invoke(this, o) /* invoke-custom */;
        }

        public ResourceLocation name() {
            return this.name;
        }

        public int programId() {
            return this.programId;
        }

        public Int2IntMap shaders() {
            return this.shaders;
        }

        public ShaderUniformCache uniforms() {
            return this.uniforms;
        }

        public Int2ObjectMap<ByteBuffer> data() {
            return this.data;
        }

        public static SelectedProgram create(ResourceLocation name, int program) {
            int[] attachedShaders = new int[GL40C.glGetProgrami(program, 35717)];
            GL40C.glGetAttachedShaders(program, (int[]) null, attachedShaders);
            Int2IntArrayMap int2IntArrayMap = new Int2IntArrayMap(attachedShaders.length);
            for (int shader : attachedShaders) {
                int2IntArrayMap.put(GL40C.glGetShaderi(shader, 35663), shader);
            }
            ShaderUniformCache cache = new ShaderUniformCache(() -> {
                return program;
            });
            Int2ObjectArrayMap<ByteBuffer> data = new Int2ObjectArrayMap<>(cache.getUniformBlocks().size());
            return new SelectedProgram(name, program, Int2IntMaps.unmodifiable(int2IntArrayMap), cache, data);
        }

        public boolean isShaderInvalid() {
            return this.programId == 0 || !GL40C.glIsProgram(this.programId);
        }

        public void update() {
            this.uniforms.clear();
        }

        public void free() {
            this.uniforms.clear();
        }
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/impl/client/editor/ShaderInspector$TabSource.class */
    private enum TabSource {
        VANILLA(Component.translatable("inspector.veil.shader.source.vanilla")) { // from class: foundry.veil.impl.client.editor.ShaderInspector.TabSource.1
            @Override // foundry.veil.impl.client.editor.ShaderInspector.TabSource
            public void addShaders(ObjIntConsumer<ResourceLocation> registry) {
                DebugGameRendererAccessor accessor = Minecraft.getInstance().gameRenderer;
                Map<String, ShaderInstance> shaders = accessor.getShaders();
                for (ShaderInstance shader : shaders.values()) {
                    String name = shader.getName().isBlank() ? Integer.toString(shader.getId()) : shader.getName();
                    registry.accept(ResourceLocation.parse(name), shader.getId());
                }
                ShaderInstance blitShader = accessor.getBlitShader();
                registry.accept(ResourceLocation.parse(blitShader.getName()), blitShader.getId());
            }
        },
        VANILLA_POST(Component.translatable("inspector.veil.shader.source.vanilla_post")) { // from class: foundry.veil.impl.client.editor.ShaderInspector.TabSource.2
            @Override // foundry.veil.impl.client.editor.ShaderInspector.TabSource
            public void addShaders(ObjIntConsumer<ResourceLocation> registry) {
                DebugLevelRendererAccessor levelRendererAccessor = Minecraft.getInstance().levelRenderer;
                addChainPasses(registry, levelRendererAccessor.getEntityEffect());
                addChainPasses(registry, levelRendererAccessor.getTransparencyChain());
                DebugGameRendererAccessor gameRendererAccessor = Minecraft.getInstance().gameRenderer;
                addChainPasses(registry, gameRendererAccessor.getPostEffect());
            }

            private void addChainPasses(ObjIntConsumer<ResourceLocation> registry, @Nullable PostChain chain) {
                if (chain == null) {
                    return;
                }
                List<PostPass> passes = ((DebugPostChainAccessor) chain).getPasses();
                for (PostPass pass : passes) {
                    EffectInstance effect = pass.getEffect();
                    registry.accept(ResourceLocation.parse(effect.getName()), effect.getId());
                }
            }
        },
        VEIL(Component.translatable("inspector.veil.shader.source.veil")) { // from class: foundry.veil.impl.client.editor.ShaderInspector.TabSource.3
            @Override // foundry.veil.impl.client.editor.ShaderInspector.TabSource
            public void addShaders(ObjIntConsumer<ResourceLocation> registry) {
                Map<ResourceLocation, ShaderProgram> shaders = VeilRenderSystem.renderer().getShaderManager().getShaders();
                for (ShaderProgram shader : shaders.values()) {
                    registry.accept(shader.getName(), shader.getProgram());
                }
            }
        },
        IRIS(Component.translatable("inspector.veil.shader.source.iris"), () -> {
            return IrisCompat.INSTANCE != null;
        }) { // from class: foundry.veil.impl.client.editor.ShaderInspector.TabSource.4
            @Override // foundry.veil.impl.client.editor.ShaderInspector.TabSource
            public void addShaders(ObjIntConsumer<ResourceLocation> registry) {
                for (ShaderInstance shader : IrisCompat.INSTANCE.getLoadedShaders()) {
                    String name = shader.getName().isBlank() ? Integer.toString(shader.getId()) : shader.getName();
                    registry.accept(ResourceLocation.parse(name), shader.getId());
                }
            }
        },
        SODIUM(Component.translatable("inspector.veil.shader.source.sodium"), () -> {
            return SodiumCompat.INSTANCE != null;
        }) { // from class: foundry.veil.impl.client.editor.ShaderInspector.TabSource.5
            @Override // foundry.veil.impl.client.editor.ShaderInspector.TabSource
            public void addShaders(ObjIntConsumer<ResourceLocation> registry) {
                ObjectIterator it = SodiumCompat.INSTANCE.getLoadedShaders().object2IntEntrySet().iterator();
                while (it.hasNext()) {
                    Object2IntMap.Entry<ResourceLocation> entry = (Object2IntMap.Entry) it.next();
                    registry.accept((ResourceLocation) entry.getKey(), entry.getIntValue());
                }
            }
        },
        OTHER(Component.translatable("inspector.veil.shader.source.unknown")) { // from class: foundry.veil.impl.client.editor.ShaderInspector.TabSource.6
            @Override // foundry.veil.impl.client.editor.ShaderInspector.TabSource
            public void addShaders(ObjIntConsumer<ResourceLocation> registry) {
                IntOpenHashSet intOpenHashSet = new IntOpenHashSet();
                for (int i = 1; i < 10000; i++) {
                    if (GL40C.glIsProgram(i)) {
                        intOpenHashSet.add(i);
                    }
                }
                for (TabSource value : TabSource.values()) {
                    if (value != this && value.active.getAsBoolean()) {
                        value.addShaders((name, id) -> {
                            intOpenHashSet.remove(id);
                        });
                    }
                }
                IntIterator it = intOpenHashSet.iterator();
                while (it.hasNext()) {
                    int program = ((Integer) it.next()).intValue();
                    registry.accept(ResourceLocation.fromNamespaceAndPath("unknown", Integer.toString(program)), program);
                }
            }
        };

        private final Component displayName;
        private final BooleanSupplier active;

        public abstract void addShaders(ObjIntConsumer<ResourceLocation> objIntConsumer);

        TabSource(Component displayName) {
            this(displayName, () -> {
                return true;
            });
        }

        TabSource(Component displayName, BooleanSupplier active) {
            this.displayName = displayName;
            this.active = active;
        }
    }
}
