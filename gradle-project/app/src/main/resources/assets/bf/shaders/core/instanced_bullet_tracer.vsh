#version 410

// Base mesh: a unit quad. Position.x ∈ [-1, +1] = ribbon width axis,
// Position.y ∈ [0, 1] = along-line interpolant (0 = tail, 1 = head).
layout(location = 0) in vec3 Position;

// Per-instance data
layout(location = 1) in vec3  InstanceStart;
layout(location = 2) in vec3  InstanceEnd;
layout(location = 3) in float InstanceThickness;
layout(location = 4) in vec4  InstanceStartColor;
layout(location = 5) in vec4  InstanceEndColor;

uniform mat4 ModelViewMat;
uniform mat4 ProjMat;

out vec4 vertexColor;
out float localX;

void main() {
    // Project endpoints to clip space. ModelViewMat carries only the camera rotation; the
    // renderer writes camera-relative positions on the Java side.
    vec4 clipStart = ProjMat * (ModelViewMat * vec4(InstanceStart, 1.0));
    vec4 clipEnd   = ProjMat * (ModelViewMat * vec4(InstanceEnd,   1.0));
    vec4 clipBase  = mix(clipStart, clipEnd, Position.y);

    // NDC positions for the line endpoints
    vec2 ndcStart = clipStart.xy / clipStart.w;
    vec2 ndcEnd   = clipEnd.xy   / clipEnd.w;
    vec2 ndcBase  = clipBase.xy  / clipBase.w;

    // Aspect ratio derived from the projection matrix (avoids needing a ViewportSize uniform).
    // ProjMat[1][1] = 1/tan(fov_y/2); ProjMat[0][0] = 1/(aspect * tan(fov_y/2)).
    float aspect = ProjMat[1][1] / ProjMat[0][0];

    // Compute the perpendicular in aspect-corrected (square) space so screen-space thickness
    // is equal in both axes, then undo the aspect correction when applying the offset.
    vec2 dirSquare = vec2((ndcEnd.x - ndcStart.x) * aspect, ndcEnd.y - ndcStart.y);
    float dirLen = length(dirSquare);
    vec2 perpSquare = dirLen > 0.0001 ? vec2(-dirSquare.y, dirSquare.x) / dirLen : vec2(0.0, 1.0);
    vec2 perpNdc = vec2(perpSquare.x / aspect, perpSquare.y);

    // Offset in NDC. InstanceThickness is interpreted as a fraction of the vertical NDC range.
    vec2 finalNdc = ndcBase + perpNdc * Position.x * InstanceThickness;

    // Reproject back to clip space, preserving the base depth.
    gl_Position = vec4(finalNdc * clipBase.w, clipBase.z, clipBase.w);

    vertexColor = mix(InstanceStartColor, InstanceEndColor, Position.y);
    localX = Position.x;
}
