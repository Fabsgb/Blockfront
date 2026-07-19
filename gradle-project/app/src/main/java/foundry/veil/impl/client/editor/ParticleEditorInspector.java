package foundry.veil.impl.client.editor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.serialization.JsonOps;
import foundry.imgui.api.ImGuiMC;
import foundry.imgui.api.ImGuiTextureProvider;
import foundry.veil.Veil;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.client.editor.SingleWindowInspector;
import foundry.veil.api.client.render.MatrixStack;
import foundry.veil.api.client.render.VeilRenderSystem;
import foundry.veil.api.quasar.data.EmitterSettings;
import foundry.veil.api.quasar.data.EmitterShapeSettings;
import foundry.veil.api.quasar.data.ParticleEmitterData;
import foundry.veil.api.quasar.data.ParticleModuleTypeRegistry;
import foundry.veil.api.quasar.data.ParticleSettings;
import foundry.veil.api.quasar.data.QuasarParticleData;
import foundry.veil.api.quasar.data.QuasarParticles;
import foundry.veil.api.quasar.data.module.ModuleType;
import foundry.veil.api.quasar.data.module.ParticleModuleData;
import foundry.veil.api.quasar.emitters.shape.EmitterShape;
import foundry.veil.api.quasar.particle.ParticleEmitter;
import foundry.veil.api.quasar.particle.ParticleSystemManager;
import foundry.veil.api.quasar.particle.RenderStyle;
import foundry.veil.api.quasar.particle.SpriteData;
import foundry.veil.api.quasar.registry.EmitterShapeRegistry;
import foundry.veil.api.quasar.registry.RenderStyleRegistry;
import imgui.ImGui;
import imgui.type.ImBoolean;
import imgui.type.ImInt;
import imgui.type.ImString;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import net.minecraft.ChatFormatting;
import net.minecraft.ResourceLocationException;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.ApiStatus;
import org.joml.Matrix4f;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/ParticleEditorInspector.class */
@ApiStatus.Internal
public class ParticleEditorInspector extends SingleWindowInspector {
    public static final Component TITLE = Component.literal("Particle Editor");
    private int selectedEmitter;
    private final List<MutableParticleEmitter> emitters = new ArrayList();
    private final ImInt selectedModule = new ImInt();
    private final ImBoolean saveWindowOpen = new ImBoolean(false);
    private final ImString savePath = new ImString();
    private final ImString saveNamespace = new ImString();
    private final ImBoolean saveSeparateSettings = new ImBoolean(false);
    private final ImBoolean saveSeparateShape = new ImBoolean(false);
    private final ImBoolean saveSeparateData = new ImBoolean(false);
    private final ImBoolean loadWindowOpen = new ImBoolean(false);
    private final List<String> shapeKeys = EmitterShapeRegistry.REGISTRY.keySet().stream().map((v0) -> {
        return v0.toString();
    }).toList();
    private final String[] shapeArray = (String[]) Arrays.copyOf(this.shapeKeys.toArray(), this.shapeKeys.toArray().length, String[].class);
    private final List<String> renderStyleKeys = RenderStyleRegistry.REGISTRY.keySet().stream().map((v0) -> {
        return v0.toString();
    }).toList();
    private final String[] renderStyleArray = (String[]) Arrays.copyOf(this.renderStyleKeys.toArray(), this.renderStyleKeys.toArray().length, String[].class);
    private final ResourceLocation[] moduleKeys = (ResourceLocation[]) ParticleModuleTypeRegistry.REGISTRY.keySet().stream().sorted().toArray(x$0 -> {
        return new ResourceLocation[x$0];
    });
    private final String[] modulesArray = (String[]) Arrays.stream(this.moduleKeys).map((v0) -> {
        return v0.toString();
    }).toArray(x$0 -> {
        return new String[x$0];
    });

    @Override // foundry.veil.api.client.editor.SingleWindowInspector
    protected void renderComponents() {
        int[] value = {this.selectedEmitter};
        ImGui.beginDisabled(this.saveWindowOpen.get() || this.loadWindowOpen.get());
        ImGui.beginDisabled(this.emitters.isEmpty());
        ImGui.setNextItemWidth(ImGui.getContentRegionAvailX() * 0.6f);
        if (ImGui.sliderInt("##textures", value, 0, this.emitters.size() - 1, String.valueOf(this.selectedEmitter))) {
            this.selectedEmitter = value[0];
        }
        ImGui.endDisabled();
        ImGui.sameLine();
        ImGui.pushButtonRepeat(true);
        ImGui.beginDisabled(this.selectedEmitter <= 0);
        if (ImGui.arrowButton("##left", 0)) {
            this.selectedEmitter--;
        }
        ImGui.endDisabled();
        ImGui.beginDisabled(this.selectedEmitter >= this.emitters.size() - 1);
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        if (ImGui.arrowButton("##right", 1)) {
            this.selectedEmitter++;
        }
        ImGui.endDisabled();
        ImGui.popButtonRepeat();
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        if (ImGui.button("Create Emitter", ImGui.getContentRegionAvailX() * 0.5f, 0.0f)) {
            createEmitterFromData(new ParticleEmitterData(20, false, 1, 1, Integer.MAX_VALUE, new EmitterSettings(List.of(Holder.direct(new EmitterShapeSettings(EmitterShapeRegistry.POINT.get(), new Vector3f(1.0f), new Vector3f(0.0f), true))), Holder.direct(new ParticleSettings(0.1f, 0.1f, 0.0f, 60, 0.0f, new Vector3f(1.0f), true, new Vector3f(0.0f), false, false, false, false)), false), Holder.direct(new QuasarParticleData(true, false, 0.0f, List.of(), null, false, RenderStyleRegistry.CUBE.get()))));
        }
        ImGui.beginDisabled(this.emitters.isEmpty());
        ImGui.sameLine(0.0f, ImGui.getStyle().getItemInnerSpacingX());
        if (ImGui.button("Remove Emitter", ImGui.getContentRegionAvailX(), 0.0f)) {
            MutableParticleEmitter emitter = this.emitters.get(this.selectedEmitter);
            emitter.trim(999);
            emitter.forceRemove();
            this.emitters.remove(this.selectedEmitter);
            this.selectedEmitter = Mth.clamp(this.selectedEmitter - 1, 0, this.emitters.size());
        }
        ImGui.endDisabled();
        ImGui.pushItemWidth(ImGui.getContentRegionAvailX() * 0.5f);
        if (ImGui.button("Save")) {
            this.saveWindowOpen.set(true);
        }
        ImGui.sameLine();
        if (ImGui.button("Load")) {
            this.loadWindowOpen.set(true);
        }
        ImGui.popItemWidth();
        ImGui.separator();
        if (ImGui.beginListBox("Properties", ImGui.getContentRegionAvail())) {
            if (!this.emitters.isEmpty() && this.emitters.get(this.selectedEmitter) != null) {
                renderParticleAttributes();
            }
            ImGui.endListBox();
        }
        ImGui.endDisabled();
    }

    @Override // foundry.veil.api.client.editor.SingleWindowInspector, foundry.veil.api.client.editor.Inspector
    public void render() {
        ImGui.setNextWindowSizeConstraints(300.0f, 500.0f, Float.MAX_VALUE, Float.MAX_VALUE);
        super.render();
        if (this.saveWindowOpen.get()) {
            ImGui.setNextWindowSizeConstraints(300.0f, 300.0f, Float.MAX_VALUE, Float.MAX_VALUE);
            if (ImGui.begin("Save Emitter", this.saveWindowOpen, 256)) {
                if (this.saveSeparateSettings.get() || this.saveSeparateShape.get() || this.saveSeparateData.get()) {
                    ImGui.inputText("Namespace", this.saveNamespace);
                }
                ImGui.inputText("Filename", this.savePath);
                ImGui.checkbox("Separate Particle Settings file", this.saveSeparateSettings);
                ImGui.checkbox("Separate Emitter Shape file", this.saveSeparateShape);
                ImGui.checkbox("Separate Particle Data file", this.saveSeparateData);
                if (ImGui.button("Save")) {
                    if (this.savePath.get().endsWith(".json")) {
                        saveEmitterToFile(this.emitters.get(this.selectedEmitter), this.savePath.get().substring(0, this.savePath.get().length() - 5), this.saveNamespace.get());
                    } else {
                        saveEmitterToFile(this.emitters.get(this.selectedEmitter), this.savePath.get(), this.saveNamespace.get());
                    }
                }
            }
            ImGui.end();
        }
        if (this.loadWindowOpen.get()) {
            ImGui.setNextWindowSizeConstraints(300.0f, 300.0f, Float.MAX_VALUE, Float.MAX_VALUE);
            if (ImGui.begin("Load Emitter", this.loadWindowOpen, 256) && ImGui.beginListBox("Emitters")) {
                Set<ResourceLocation> emitterLocations = ((Registry) QuasarParticles.registryAccess().registry(QuasarParticles.EMITTER).get()).keySet();
                for (ResourceLocation emitter : emitterLocations) {
                    if (ImGui.selectable(emitter.toString())) {
                        createEmitterFromData((ParticleEmitterData) ((Registry) QuasarParticles.registryAccess().registry(QuasarParticles.EMITTER).get()).get(emitter));
                        this.loadWindowOpen.set(false);
                    }
                }
                ImGui.endListBox();
            }
            ImGui.end();
        }
    }

    private void renderParticleAttributes() {
        MutableParticleEmitter emitter = this.emitters.get(this.selectedEmitter);
        ImGui.text("Particles: " + emitter.getParticleCount());
        float[] editPos = {(float) emitter.getPosition().x(), (float) emitter.getPosition().y(), (float) emitter.getPosition().z()};
        if (ImGui.dragFloat3("position", editPos, 0.02f)) {
            emitter.setPosition(editPos[0], editPos[1], editPos[2]);
        }
        int[] editMaxLifetime = {emitter.getMaxLifetime()};
        int[] editRate = {emitter.getRate()};
        int[] editCount = {emitter.getCount()};
        if (ImGui.dragScalar("max_lifetime", editMaxLifetime, 0.02f)) {
            emitter.setMaxLifetime(editMaxLifetime[0]);
        }
        if (ImGui.checkbox("loop", emitter.isLoop())) {
            emitter.setLoop(!emitter.isLoop());
        }
        float width = ImGui.getContentRegionAvailX() * 0.333f;
        ImGui.setNextItemWidth(width);
        if (ImGui.dragScalar("rate", editRate, 0.02f)) {
            emitter.setRate(editRate[0]);
        }
        ImGui.sameLine();
        ImGui.setNextItemWidth(width);
        if (ImGui.dragScalar("count", editCount, 0.02f, 0, Integer.MAX_VALUE)) {
            emitter.setCount(editCount[0]);
        }
        boolean shapeInspectorOpen = false;
        if (ImGui.collapsingHeader("Emitter Shapes")) {
            shapeInspectorOpen = true;
            ImGui.indent();
            renderShapeAttributes(emitter);
            ImGui.unindent();
        }
        boolean settingsInspectorOpen = false;
        if (ImGui.collapsingHeader("Particle Settings")) {
            settingsInspectorOpen = true;
            ImGui.indent();
            renderParticleSettings(emitter);
            ImGui.unindent();
        }
        int i = 0;
        while (i < this.emitters.size()) {
            this.emitters.get(i).renderEmitterShape = i == this.selectedEmitter && shapeInspectorOpen;
            this.emitters.get(i).renderDirection = i == this.selectedEmitter && settingsInspectorOpen;
            i++;
        }
        if (ImGui.collapsingHeader("Particle Data")) {
            ImGui.indent();
            renderParticleData(emitter);
            ImGui.unindent();
        }
        if (ImGui.collapsingHeader("Modules")) {
            renderModules(emitter);
        }
    }

    private void renderShapeAttributes(MutableParticleEmitter emitter) {
        int i = 0;
        while (i < emitter.getEmitterShapeSettings().size()) {
            EmitterShapeSettings shapeSettings = emitter.getEmitterShapeSettings().get(i);
            ImInt selectedShape = new ImInt();
            for (Map.Entry<ResourceKey<EmitterShape>, EmitterShape> e : EmitterShapeRegistry.REGISTRY.entrySet()) {
                if (e.getValue().getClass() == shapeSettings.shape().getClass()) {
                    selectedShape.set(this.shapeKeys.indexOf(e.getKey().location().toString()));
                }
            }
            ImGui.pushID(i);
            if (ImGui.combo("shape", selectedShape, this.shapeArray)) {
                ResourceLocation shapeKey = ResourceLocation.bySeparator(this.shapeKeys.get(selectedShape.get()), ':');
                EmitterShape shape = (EmitterShape) EmitterShapeRegistry.REGISTRY.get(shapeKey);
                emitter.setShape(i, shape);
            }
            float[] editDimensions = {shapeSettings.dimensions().x(), shapeSettings.dimensions().y(), shapeSettings.dimensions().z()};
            if (ImGui.dragFloat3("dimensions", editDimensions, 0.01f)) {
                emitter.setShapeDimensions(i, editDimensions[0], editDimensions[1], editDimensions[2]);
            }
            float[] editRotation = {shapeSettings.rotation().x(), shapeSettings.rotation().y(), shapeSettings.rotation().z()};
            if (ImGui.dragFloat3("rotation", editRotation, 0.05f)) {
                emitter.setShapeRotation(i, editRotation[0], editRotation[1], editRotation[2]);
            }
            if (ImGui.button("Reset Transform")) {
                emitter.resetShapeTransform(i);
            }
            if (ImGui.checkbox("from_surface", shapeSettings.fromSurface())) {
                emitter.setShapeFromSurface(i, !shapeSettings.fromSurface());
            }
            if (i == emitter.getEmitterShapeSettings().size() - 1) {
                if (ImGui.button("Add Shape")) {
                    emitter.getEmitterShapeSettings().add(new EmitterShapeSettings((EmitterShape) EmitterShapeRegistry.REGISTRY.get(Veil.veilPath("sphere")), new Vector3f(1.0f), new Vector3f(0.0f), true));
                }
                ImGui.sameLine();
            }
            if (emitter.getEmitterShapeSettings().size() > 1 && ImGui.button("Remove Shape")) {
                int i2 = i;
                i--;
                emitter.getEmitterShapeSettings().remove(i2);
            }
            ImGui.separator();
            ImGui.popID();
            i++;
        }
    }

    private void renderParticleSettings(MutableParticleEmitter emitter) {
        ParticleSettings settings = emitter.getParticleSettings();
        if (ImGui.checkbox("random_initial_direction", settings.randomInitialDirection())) {
            emitter.toggleRandomDirection();
        }
        float[] editDirection = {settings.initialDirection().x(), settings.initialDirection().y(), settings.initialDirection().z()};
        if (ImGui.dragFloat3("initial_direction", editDirection, 0.01f)) {
            emitter.setParticleDirection(editDirection[0], editDirection[1], editDirection[2]);
        }
        if (ImGui.checkbox("random_initial_rotation", settings.randomInitialRotation())) {
            emitter.toggleRandomRotation();
        }
        float[] editRotation = {settings.initialRotation().x(), settings.initialRotation().y(), settings.initialRotation().z()};
        if (ImGui.dragFloat3("initial_rotation", editRotation, 0.025f)) {
            emitter.setParticleRotation(editRotation[0], editRotation[1], editRotation[2]);
        }
        if (ImGui.checkbox("random_speed", settings.randomSpeed())) {
            emitter.toggleRandomSpeed();
        }
        float[] editSpeed = {settings.particleSpeed()};
        if (ImGui.dragScalar("particle_speed", editSpeed, 0.01f)) {
            emitter.setParticleSpeed(editSpeed[0]);
        }
        if (ImGui.checkbox("random_size", settings.randomSize())) {
            emitter.toggleRandomSize();
        }
        if (settings.randomSize()) {
            float[] editParticleSize = {settings.particleSize(), settings.particleSize() + settings.particleSizeVariation()};
            if (ImGui.dragFloat2("particle_size", editParticleSize, 0.01f, Math.max(editParticleSize[0], 0.001f), editParticleSize[1])) {
                emitter.setParticleSize(editParticleSize[0], editParticleSize[1]);
            }
        } else {
            float[] editParticleSize2 = {settings.particleSize()};
            if (ImGui.dragScalar("particle_size", editParticleSize2, 0.01f)) {
                emitter.setParticleSize(editParticleSize2[0], 0.0f);
            }
        }
        if (ImGui.checkbox("random_lifetime", settings.randomLifetime())) {
            emitter.toggleParticleHasRandomLifetime();
        }
        if (settings.randomLifetime()) {
            int[] editParticleLifetime = {settings.particleLifetime(), settings.particleLifetime() + ((int) settings.particleLifetimeVariation())};
            if (ImGui.dragInt2("particle_lifetime", editParticleLifetime, 0.03f, Math.max(editParticleLifetime[0], 0))) {
                emitter.setParticleLifetime(editParticleLifetime[0], editParticleLifetime[1]);
                return;
            }
            return;
        }
        int[] editLifetimeMin = {settings.particleLifetime()};
        if (ImGui.dragInt("particle_lifetime", editLifetimeMin, 0.03f, 0)) {
            emitter.setParticleLifetime(editLifetimeMin[0], 0);
        }
    }

    private void renderParticleData(MutableParticleEmitter emitter) {
        QuasarParticleData data = emitter.getParticleData();
        ImInt selectedRenderStyle = new ImInt();
        for (Map.Entry<ResourceKey<RenderStyle>, RenderStyle> e : RenderStyleRegistry.REGISTRY.entrySet()) {
            if (e.getValue().getClass() == data.renderStyle().getClass()) {
                selectedRenderStyle.set(this.renderStyleKeys.indexOf(e.getKey().location().toString()));
            }
        }
        if (ImGui.combo("render_style", selectedRenderStyle, this.renderStyleArray)) {
            data.setRenderStyle((RenderStyle) RenderStyleRegistry.REGISTRY.get(ResourceLocation.parse(this.renderStyleArray[selectedRenderStyle.get()])));
        }
        SpriteData spriteData = data.spriteData();
        if (spriteData == null) {
            if (ImGui.button("Create Sprite Data")) {
                data.setSpriteData(new SpriteData(ResourceLocation.fromNamespaceAndPath("", ""), 1, 1.0f, 1, 1, false));
            }
        } else {
            if (ImGui.button("Delete Sprite Data")) {
                data.setSpriteData(null);
            }
            ImGuiTextureProvider texture = ImGuiMC.getTexture(Minecraft.getInstance().getTextureManager().getTexture(spriteData.sprite()));
            ImString value = new ImString(spriteData.sprite().toString(), 256);
            ImGuiMC.image(texture, 64.0f, 64.0f);
            ImGui.sameLine();
            if (ImGui.inputText("sprite", value)) {
                try {
                    data.setSpriteData(new SpriteData(ResourceLocation.parse(value.get()), spriteData.frameCount(), spriteData.frameTime(), spriteData.frameWidth(), spriteData.frameHeight(), spriteData.stretchToLifetime()));
                } catch (ResourceLocationException e2) {
                }
            }
            int[] editFrameCount = {spriteData.frameCount()};
            if (ImGui.dragScalar("frame_count", editFrameCount, 0.03f)) {
                data.setSpriteData(new SpriteData(spriteData.sprite(), editFrameCount[0], spriteData.frameTime(), spriteData.frameWidth(), spriteData.frameHeight(), spriteData.stretchToLifetime()));
            }
            int[] editFrameSize = {spriteData.frameWidth(), spriteData.frameHeight()};
            if (ImGui.dragInt2("size", editFrameSize, 0.03f, 0)) {
                data.setSpriteData(new SpriteData(spriteData.sprite(), spriteData.frameCount(), spriteData.frameTime(), editFrameSize[0], editFrameSize[1], spriteData.stretchToLifetime()));
            }
            float[] editFrameTime = {spriteData.frameTime()};
            if (ImGui.dragScalar("frame_time", editFrameTime)) {
                data.setSpriteData(new SpriteData(spriteData.sprite(), spriteData.frameCount(), editFrameTime[0], spriteData.frameWidth(), spriteData.frameHeight(), spriteData.stretchToLifetime()));
            }
            if (ImGui.checkbox("stretch_to_lifetime", spriteData.stretchToLifetime())) {
                data.setSpriteData(new SpriteData(spriteData.sprite(), spriteData.frameCount(), spriteData.frameTime(), spriteData.frameWidth(), spriteData.frameHeight(), !spriteData.stretchToLifetime()));
            }
        }
        if (ImGui.checkbox("additive", data.additive())) {
            data.setAdditive(!data.additive());
        }
        if (ImGui.checkbox("collision", data.shouldCollide())) {
            data.setShouldCollide(!data.shouldCollide());
        }
        if (ImGui.checkbox("face_velocity", data.faceVelocity())) {
            data.setFaceVelocity(!data.faceVelocity());
        }
        float[] editStretchFactor = {data.velocityStretchFactor()};
        if (ImGui.dragScalar("velocity_stretch_factor", editStretchFactor, 0.005f)) {
            data.setVelocityStretchFactor(editStretchFactor[0]);
        }
    }

    private void renderModules(MutableParticleEmitter emitter) {
        Supplier supplierDefaultValue;
        ImGui.indent();
        int id = 333;
        for (ParticleModuleData module : List.copyOf(emitter.getModules())) {
            ImGui.pushID(id);
            String name = String.valueOf(ParticleModuleTypeRegistry.REGISTRY.getKey(module.getType()));
            if (ImGui.collapsingHeader(name)) {
                ImGui.indent();
                if (module instanceof EditorAttributeProvider) {
                    EditorAttributeProvider attributeProvider = (EditorAttributeProvider) module;
                    attributeProvider.renderImGuiAttributes();
                }
                if (ImGui.button("Remove Module")) {
                    emitter.removeModule(module);
                    ImGui.unindent();
                    ImGui.popID();
                } else {
                    ImGui.unindent();
                }
            }
            ModuleType.DeprecationStatus status = module.getType().deprecationStatus();
            if (status != null && ImGui.isItemHovered()) {
                ImGui.setTooltip("%s will be removed in %s".formatted(name, status.removeVersion()));
            }
            ImGui.popID();
            id++;
        }
        ImGui.separator();
        ImGui.combo("module", this.selectedModule, this.modulesArray);
        if (ImGui.button("Add Module")) {
            ResourceLocation moduleKey = this.moduleKeys[this.selectedModule.get()];
            ModuleType<? extends ParticleModuleData> moduleType = (ModuleType) ParticleModuleTypeRegistry.REGISTRY.get(moduleKey);
            if (moduleType != null && (supplierDefaultValue = moduleType.defaultValue()) != null) {
                emitter.addModule((ParticleModuleData) supplierDefaultValue.get());
            }
        }
        ImGui.unindent();
    }

    private void saveEmitterToFile(MutableParticleEmitter emitter, String filename, String namespace) {
        ParticleEmitterData data = emitter.dataFromMutable();
        JsonElement result = (JsonElement) ParticleEmitterData.DIRECT_CODEC.encodeStart(JsonOps.INSTANCE, data).getOrThrow();
        if (this.saveSeparateShape.get()) {
            result.getAsJsonObject().get("emitter_settings").getAsJsonObject().addProperty("shape", namespace + ":" + filename);
        }
        if (this.saveSeparateSettings.get()) {
            result.getAsJsonObject().get("emitter_settings").getAsJsonObject().addProperty("particle_settings", namespace + ":" + filename);
        }
        if (this.saveSeparateData.get()) {
            result.getAsJsonObject().addProperty("particle_data", namespace + ":" + filename);
        }
        Path baseQuasarPath = Path.of(Minecraft.getInstance().gameDirectory.toURI()).resolve("quasar");
        try {
            writePrettyPrintedJson(result, baseQuasarPath.resolve("emitters").toString(), filename);
            Minecraft.getInstance().gui.getChat().addMessage(Component.literal("Saved emitter to quasar/emitters/" + filename + ".json").withStyle(s -> {
                return s.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, baseQuasarPath.resolve("emitters").toAbsolutePath().toString()));
            }));
            if (this.saveSeparateShape.get()) {
                writePrettyPrintedJson((JsonElement) EmitterShapeSettings.DIRECT_CODEC.listOf().encodeStart(JsonOps.INSTANCE, data.emitterSettings().emitterShapeSettings()).getOrThrow(), baseQuasarPath.resolve("modules/emitter/shape").toString(), filename);
                Minecraft.getInstance().gui.getChat().addMessage(Component.literal("Saved emitter shape to quasar/modules/emitter/shape/" + filename + ".json").withStyle(s2 -> {
                    return s2.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, baseQuasarPath.resolve("modules/emitter/shape").toAbsolutePath().toString()));
                }));
            }
            if (this.saveSeparateSettings.get()) {
                writePrettyPrintedJson((JsonElement) ParticleSettings.DIRECT_CODEC.encodeStart(JsonOps.INSTANCE, data.emitterSettings().particleSettings()).getOrThrow(), baseQuasarPath.resolve("modules/emitter/particle").toString(), filename);
                Minecraft.getInstance().gui.getChat().addMessage(Component.literal("Saved emitter particle settings to quasar/modules/emitter/particle/" + filename + ".json").withStyle(s3 -> {
                    return s3.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, baseQuasarPath.resolve("modules/emitter/particle").toAbsolutePath().toString()));
                }));
            }
            if (this.saveSeparateData.get()) {
                writePrettyPrintedJson((JsonElement) QuasarParticleData.DIRECT_CODEC.encodeStart(JsonOps.INSTANCE, data.particleData()).getOrThrow(), baseQuasarPath.resolve("modules/particle_data").toString(), filename);
                Minecraft.getInstance().gui.getChat().addMessage(Component.literal("Saved emitter particle data to quasar/modules/particle_data/" + filename + ".json").withStyle(s4 -> {
                    return s4.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, baseQuasarPath.resolve("modules/particle_data").toAbsolutePath().toString()));
                }));
            }
        } catch (IOException e) {
            Minecraft.getInstance().gui.getChat().addMessage(Component.literal("Failed to save emitter! Check logs for details.").withStyle(ChatFormatting.RED));
            e.printStackTrace();
        }
    }

    private void writePrettyPrintedJson(JsonElement element, String folderPath, String filename) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJsonString = gson.toJson(element);
        new File(folderPath).mkdirs();
        String emitterFilePath = folderPath + File.separator + filename + ".json";
        File emitterFile = new File(emitterFilePath);
        FileWriter emitterWriter = new FileWriter(emitterFile);
        emitterWriter.write(prettyJsonString);
        emitterWriter.close();
    }

    private void createEmitterFromData(ParticleEmitterData data) {
        Vec3 position;
        if (data == null) {
            return;
        }
        ParticleSystemManager particleManager = VeilRenderSystem.renderer().getParticleManager();
        MutableParticleEmitter emitter = new MutableParticleEmitter(particleManager, particleManager.getLevel(), data);
        HitResult hitResult = Minecraft.getInstance().hitResult;
        if (hitResult != null && hitResult.getType() != HitResult.Type.MISS) {
            position = hitResult.getLocation();
        } else {
            position = new Vec3(Minecraft.getInstance().gameRenderer.getMainCamera().getLookVector()).multiply(3.0d, 3.0d, 3.0d).add(Minecraft.getInstance().gameRenderer.getMainCamera().getPosition());
        }
        emitter.setPosition(position);
        particleManager.addParticleSystem(emitter);
        this.emitters.add(emitter);
        this.selectedEmitter = this.emitters.size() - 1;
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getDisplayName() {
        return TITLE;
    }

    @Override // foundry.veil.api.client.editor.Inspector
    public Component getGroup() {
        return RESOURCE_GROUP;
    }

    /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/ParticleEditorInspector$MutableParticleEmitter.class */
    private static class MutableParticleEmitter extends ParticleEmitter {
        private boolean forceRemoved;
        public boolean renderEmitterShape;
        public boolean renderDirection;

        private MutableParticleEmitter(ParticleSystemManager particleManager, ClientLevel level, ParticleEmitterData data) {
            super(particleManager, level, data);
            this.forceRemoved = false;
            this.renderEmitterShape = false;
            this.particleData = new QuasarParticleData(this.particleData.shouldCollide(), this.particleData.faceVelocity(), this.particleData.velocityStretchFactor(), this.particleData.modules(), this.particleData.spriteData(), this.particleData.additive(), this.particleData.renderStyle());
        }

        public ParticleEmitterData dataFromMutable() {
            QuasarParticleData withModules = new QuasarParticleData(this.particleData.shouldCollide(), this.particleData.faceVelocity(), this.particleData.velocityStretchFactor(), getModules().stream().map((v0) -> {
                return Holder.direct(v0);
            }).toList(), this.particleData.spriteData(), this.particleData.additive(), this.particleData.renderStyle());
            EmitterSettings emitterSettings = new EmitterSettings(getEmitterShapeSettings().stream().map((v0) -> {
                return Holder.direct(v0);
            }).toList(), Holder.direct(getParticleSettings()), isForceSpawn());
            return new ParticleEmitterData(getMaxLifetime(), isLoop(), getRate(), getCount(), getMaxParticles(), emitterSettings, Holder.direct(withModules));
        }

        @Override // foundry.veil.api.quasar.particle.ParticleEmitter
        public void render(MatrixStack matrixStack, MultiBufferSource bufferSource, Camera camera, float partialTicks) {
            if (this.renderEmitterShape) {
                VertexConsumer debugBuilder = bufferSource.getBuffer(RenderType.debugLineStrip(1.0d));
                matrixStack.matrixPush();
                matrixStack.translate(-camera.getPosition().x, -camera.getPosition().y, -camera.getPosition().z);
                for (EmitterShapeSettings shapeSettings : getEmitterShapeSettings()) {
                    matrixStack.matrixPush();
                    matrixStack.translate((Vector3dc) getPosition());
                    shapeSettings.shape().renderShape(matrixStack.toPoseStack(), debugBuilder, shapeSettings.dimensions(), shapeSettings.rotation());
                    matrixStack.matrixPop();
                }
                matrixStack.matrixPop();
            }
            if (this.renderDirection) {
                VertexConsumer debugBuilder2 = bufferSource.getBuffer(RenderType.lineStrip());
                matrixStack.matrixPush();
                matrixStack.translate(-camera.getPosition().x, -camera.getPosition().y, -camera.getPosition().z);
                matrixStack.matrixPush();
                matrixStack.translate((Vector3dc) getPosition());
                Matrix4f matrix4f = matrixStack.position();
                debugBuilder2.addVertex(matrix4f, 0.0f, 0.0f, 0.0f).setColor(1.0f, 1.0f, 1.0f, 1.0f).setNormal(0.0f, 1.0f, 0.0f);
                Vector3f direction = getParticleSettings().initialDirection().normalize(new Vector3f()).mul(getParticleSettings().particleSpeed() * 10.0f);
                debugBuilder2.addVertex(matrix4f, direction.x, direction.y, direction.z).setColor(1.0f, 0.15f, 0.15f, 1.0f).setNormal(0.0f, 1.0f, 0.0f);
                matrixStack.matrixPop();
                matrixStack.matrixPop();
            }
            super.render(matrixStack, bufferSource, camera, partialTicks);
        }

        @Override // foundry.veil.api.quasar.particle.ParticleEmitter
        protected void tick() {
            super.tick();
            if (isRemoved() && !this.forceRemoved) {
                reset();
                this.spawnTask = this.particleManager.getScheduler().scheduleAtFixedRate(() -> {
                    this.spawn();
                }, 1L, getRate()).toCompletableFuture();
            }
        }

        @Override // foundry.veil.api.quasar.particle.ParticleEmitter
        public void setRate(int rate) {
            super.setRate(rate);
            if (this.spawnTask != null) {
                this.spawnTask.cancel(true);
            }
            this.spawnTask = this.particleManager.getScheduler().scheduleAtFixedRate(() -> {
                this.spawn();
            }, 1L, rate).toCompletableFuture();
            reset();
        }

        private void updateShapeSettings(int index, EmitterShape shape, Vector3fc dimension, Vector3fc rotation, boolean fromSurface) {
            EmitterShapeSettings shapeSettings = new EmitterShapeSettings(shape, dimension, rotation, fromSurface);
            getEmitterShapeSettings().set(index, shapeSettings);
        }

        public void setShape(int index, EmitterShape shape) {
            EmitterShapeSettings oldShape = getEmitterShapeSettings().get(index);
            updateShapeSettings(index, shape, oldShape.dimensions(), oldShape.rotation(), oldShape.fromSurface());
        }

        public void setShapeDimensions(int index, float x, float y, float z) {
            EmitterShapeSettings oldShape = getEmitterShapeSettings().get(index);
            updateShapeSettings(index, oldShape.shape(), new Vector3f(x, y, z), oldShape.rotation(), oldShape.fromSurface());
        }

        public void setShapeRotation(int index, float x, float y, float z) {
            EmitterShapeSettings oldShape = getEmitterShapeSettings().get(index);
            updateShapeSettings(index, oldShape.shape(), oldShape.dimensions(), new Vector3f(x, y, z), oldShape.fromSurface());
        }

        public void setShapeFromSurface(int index, boolean fromSurface) {
            EmitterShapeSettings oldShape = getEmitterShapeSettings().get(index);
            updateShapeSettings(index, oldShape.shape(), oldShape.dimensions(), oldShape.rotation(), fromSurface);
        }

        public void resetShapeTransform(int index) {
            EmitterShapeSettings oldShape = getEmitterShapeSettings().get(index);
            updateShapeSettings(index, oldShape.shape(), new Vector3f(1.0f, 1.0f, 1.0f), new Vector3f(0.0f, 0.0f, 0.0f), oldShape.fromSurface());
        }

        public void setParticleSpeed(float speed) {
            setParticleSettings(new ParticleSettingsBuilder(getParticleSettings()).setParticleSpeed(speed).build());
        }

        public void toggleRandomDirection() {
            setParticleSettings(new ParticleSettingsBuilder(getParticleSettings()).setRandomInitialDirection(!getParticleSettings().randomInitialDirection()).build());
        }

        public void toggleRandomRotation() {
            setParticleSettings(new ParticleSettingsBuilder(getParticleSettings()).setRandomInitialRotation(!getParticleSettings().randomInitialRotation()).build());
        }

        public void toggleRandomSize() {
            setParticleSettings(new ParticleSettingsBuilder(getParticleSettings()).setRandomSize(!getParticleSettings().randomSize()).build());
        }

        public void toggleRandomSpeed() {
            setParticleSettings(new ParticleSettingsBuilder(getParticleSettings()).setRandomSpeed(!getParticleSettings().randomSpeed()).build());
        }

        public void toggleParticleHasRandomLifetime() {
            setParticleSettings(new ParticleSettingsBuilder(getParticleSettings()).setRandomLifetime(!getParticleSettings().randomLifetime()).build());
        }

        public void setParticleSize(float min, float max) {
            setParticleSettings(new ParticleSettingsBuilder(getParticleSettings()).setParticleSize(min).setParticleSizeVariation(Math.max(min, max) - min).build());
        }

        public void setParticleLifetime(int min, int max) {
            setParticleSettings(new ParticleSettingsBuilder(getParticleSettings()).setParticleLifetime(min).setParticleLifetimeVariation(Math.max(min, max) - min).build());
        }

        public void setParticleDirection(float x, float y, float z) {
            setParticleSettings(new ParticleSettingsBuilder(getParticleSettings()).setInitialDirection(new Vector3f(x, y, z)).build());
        }

        public void setParticleRotation(float x, float y, float z) {
            setParticleSettings(new ParticleSettingsBuilder(getParticleSettings()).setInitialRotation(new Vector3f(x, y, z)).build());
        }

        public void forceRemove() {
            this.forceRemoved = true;
            remove();
        }

        /* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.14b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.3.0.jar:foundry/veil/impl/client/editor/ParticleEditorInspector$MutableParticleEmitter$ParticleSettingsBuilder.class */
        private static class ParticleSettingsBuilder {
            private float particleSpeed;
            private float particleSize;
            private float particleSizeVariation;
            private int particleLifetime;
            private float particleLifetimeVariation;
            private Vector3fc initialDirection;
            private boolean randomInitialDirection;
            private Vector3fc initialRotation;
            private boolean randomInitialRotation;
            private boolean randomSpeed;
            private boolean randomSize;
            private boolean randomLifetime;

            public ParticleSettingsBuilder(ParticleSettings from) {
                this.particleSpeed = from.particleSpeed();
                this.particleSize = from.particleSize();
                this.particleSizeVariation = from.particleSizeVariation();
                this.particleLifetime = from.particleLifetime();
                this.particleLifetimeVariation = from.particleLifetimeVariation();
                this.initialDirection = from.initialDirection();
                this.randomInitialDirection = from.randomInitialDirection();
                this.initialRotation = from.initialRotation();
                this.randomInitialRotation = from.randomInitialRotation();
                this.randomSpeed = from.randomSpeed();
                this.randomSize = from.randomSize();
                this.randomLifetime = from.randomLifetime();
            }

            public ParticleSettingsBuilder setParticleSpeed(float particleSpeed) {
                this.particleSpeed = particleSpeed;
                return this;
            }

            public ParticleSettingsBuilder setParticleSize(float particleSize) {
                this.particleSize = particleSize;
                return this;
            }

            public ParticleSettingsBuilder setParticleSizeVariation(float particleSizeVariation) {
                this.particleSizeVariation = particleSizeVariation;
                return this;
            }

            public ParticleSettingsBuilder setParticleLifetime(int particleLifetime) {
                this.particleLifetime = particleLifetime;
                return this;
            }

            public ParticleSettingsBuilder setParticleLifetimeVariation(float particleLifetimeVariation) {
                this.particleLifetimeVariation = particleLifetimeVariation;
                return this;
            }

            public ParticleSettingsBuilder setInitialDirection(Vector3fc initialDirection) {
                this.initialDirection = initialDirection;
                return this;
            }

            public ParticleSettingsBuilder setRandomInitialDirection(boolean randomInitialDirection) {
                this.randomInitialDirection = randomInitialDirection;
                return this;
            }

            public ParticleSettingsBuilder setInitialRotation(Vector3fc initialRotation) {
                this.initialRotation = initialRotation;
                return this;
            }

            public ParticleSettingsBuilder setRandomInitialRotation(boolean randomInitialRotation) {
                this.randomInitialRotation = randomInitialRotation;
                return this;
            }

            public ParticleSettingsBuilder setRandomSpeed(boolean randomSpeed) {
                this.randomSpeed = randomSpeed;
                return this;
            }

            public ParticleSettingsBuilder setRandomSize(boolean randomSize) {
                this.randomSize = randomSize;
                return this;
            }

            public ParticleSettingsBuilder setRandomLifetime(boolean randomLifetime) {
                this.randomLifetime = randomLifetime;
                return this;
            }

            public ParticleSettings build() {
                return new ParticleSettings(this.particleSpeed, this.particleSize, this.particleSizeVariation, this.particleLifetime, this.particleLifetimeVariation, this.initialDirection, this.randomInitialDirection, this.initialRotation, this.randomInitialRotation, this.randomSpeed, this.randomSize, this.randomLifetime);
            }
        }
    }
}
