#version 410

uniform vec4 ColorModulator;

in vec4 vertexColor;
in float localX;

out vec4 fragColor;

void main() {
    float aa = 1.0 - smoothstep(0.85, 1.0, abs(localX));

    vec4 color = vertexColor * ColorModulator;
    color.a *= aa;

    if (color.a < 0.0001) discard;

    // No fog: tracers are emissive pyrotechnics, they shouldn't atmospheric-fade like solid surfaces.
    fragColor = color;
}
