package foundry.veil.api.quasar.emitters.module.update;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import foundry.veil.api.client.editor.EditorAttributeProvider;
import foundry.veil.api.util.FastNoiseLite;
import imgui.ImGui;
import imgui.type.ImInt;
import java.util.Arrays;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/* JADX INFO: loaded from: BlockFront-1.21.1-0.9.0.26b-RELEASE.jar:META-INF/jarjar/veil-neoforge-1.21.1-4.4.1.jar:foundry/veil/api/quasar/emitters/module/update/VectorField.class */
public final class VectorField implements EditorAttributeProvider {
    public static Codec<VectorField> CODEC = RecordCodecBuilder.create(instance -> {
        return instance.group(FastNoiseLite.CODEC.fieldOf("noise").forGetter((v0) -> {
            return v0.noise();
        }), Codec.FLOAT.fieldOf("strength").forGetter((v0) -> {
            return v0.strength();
        })).apply(instance, (v1, v2) -> {
            return new VectorField(v1, v2);
        });
    });
    private final FastNoiseLite noise;
    private float strength;

    public VectorField(FastNoiseLite noise, float strength) {
        this.noise = noise;
        this.strength = strength;
    }

    public Vector3d getVector(Vector3dc position, Vector3d result) {
        float x = (float) position.x();
        float y = (float) position.y();
        float z = (float) position.z();
        float xNoise = this.noise.GetNoise(x, y, z);
        float yNoise = this.noise.GetNoise(x + 100.0f, y + 100.0f, z + 100.0f);
        float zNoise = this.noise.GetNoise(x + 200.0f, y + 200.0f, z + 200.0f);
        return result.set(xNoise, yNoise, zNoise).normalize(this.strength);
    }

    public Vector3d getVector(Vector3dc position) {
        return getVector(position, new Vector3d());
    }

    @Override // foundry.veil.api.client.editor.EditorAttributeProvider
    public void renderImGuiAttributes() {
        float[] editFrequency = {this.noise.GetFrequency()};
        if (ImGui.dragFloat("frequency", editFrequency, 0.02f, 0.0f)) {
            this.noise.SetFrequency(editFrequency[0]);
        }
        if (ImGui.button("Randomize Seed")) {
            this.noise.SetSeed((int) (Math.random() * 2.147483647E9d));
        }
        ImGui.sameLine();
        ImGui.text(String.valueOf(this.noise.GetSeed()));
        FastNoiseLite.FractalType fractalType = (FastNoiseLite.FractalType) enumCombo("fractal_type", FastNoiseLite.FractalType.values(), this.noise.GetFractalType());
        if (fractalType != null) {
            this.noise.SetFractalType(fractalType);
        }
        int[] editOctaves = {this.noise.GetFractalOctaves()};
        if (ImGui.dragInt("octaves", editOctaves, 0.03f)) {
            this.noise.SetFractalOctaves(editOctaves[0]);
        }
        float[] editLacunarity = {this.noise.GetFractalLacunarity()};
        if (ImGui.dragFloat("lacunarity", editLacunarity, 0.01f)) {
            this.noise.SetFractalLacunarity(editLacunarity[0]);
        }
        float[] editGain = {this.noise.GetFractalGain()};
        if (ImGui.dragFloat("gain", editGain, 0.015f)) {
            this.noise.SetFractalGain(editGain[0]);
        }
        FastNoiseLite.CellularDistanceFunction cellularDistanceFunction = (FastNoiseLite.CellularDistanceFunction) enumCombo("cellular_distance_function", FastNoiseLite.CellularDistanceFunction.values(), this.noise.GetCellularDistanceFunction());
        if (cellularDistanceFunction != null) {
            this.noise.SetCellularDistanceFunction(cellularDistanceFunction);
        }
        FastNoiseLite.CellularReturnType cellularReturnType = (FastNoiseLite.CellularReturnType) enumCombo("cellular_return_type", FastNoiseLite.CellularReturnType.values(), this.noise.GetCellularReturnType());
        if (cellularReturnType != null) {
            this.noise.SetCellularReturnType(cellularReturnType);
        }
        FastNoiseLite.NoiseType noiseType = (FastNoiseLite.NoiseType) enumCombo("noise_type", FastNoiseLite.NoiseType.values(), this.noise.GetNoiseType());
        if (noiseType != null) {
            this.noise.SetNoiseType(noiseType);
        }
        FastNoiseLite.RotationType3D rotationType3D = (FastNoiseLite.RotationType3D) enumCombo("rotation_type_3d", FastNoiseLite.RotationType3D.values(), this.noise.GetRotationType3D());
        if (rotationType3D != null) {
            this.noise.SetRotationType3D(rotationType3D);
        }
        FastNoiseLite.DomainWarpType domainWarpType = (FastNoiseLite.DomainWarpType) enumCombo("domain_warp_type", FastNoiseLite.DomainWarpType.values(), this.noise.GetDomainWarpType());
        if (domainWarpType != null) {
            this.noise.SetDomainWarpType(domainWarpType);
        }
        float[] editDomainWarpAmp = {this.noise.GetDomainWarpAmp()};
        if (ImGui.dragFloat("domain_warp_amp", editDomainWarpAmp, 0.01f)) {
            this.noise.SetDomainWarpAmp(editDomainWarpAmp[0]);
        }
        float[] noiseStrength = {this.strength};
        if (ImGui.dragFloat("noise_strength", noiseStrength, 0.01f)) {
            this.strength = noiseStrength[0];
        }
    }

    public FastNoiseLite noise() {
        return this.noise;
    }

    public float strength() {
        return this.strength;
    }

    @Nullable
    private static <T extends Enum<T>> T enumCombo(String label, T[] enumArray, T currentValue) {
        Object[] enumObjectArray = Stream.of((Object[]) enumArray).map((v0) -> {
            return v0.name();
        }).toArray();
        String[] nameArray = (String[]) Arrays.copyOf(enumObjectArray, enumObjectArray.length, String[].class);
        ImInt selectedType = new ImInt();
        for (int i = 0; i < nameArray.length; i++) {
            if (currentValue == enumArray[i]) {
                selectedType.set(i);
            }
        }
        if (ImGui.combo(label, selectedType, nameArray)) {
            return enumArray[selectedType.get()];
        }
        return null;
    }
}
