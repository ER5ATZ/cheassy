package ch.eassy.utils

class SpriteShader {
    companion object {
        const val VERTEX_SHADER_FILE = "sprite_vertex_shader.glsl"
        const val FRAGMENT_SHADER_FILE = "sprite_fragment_shader.glsl"
    }
    val vertexShader = loadShader(VERTEX_SHADER_FILE, GLSLShader.Type.VERTEX)
    val fragmentShader = loadShader(FRAGMENT_SHADER_FILE, GLSLShader.Type.FRAGMENT)
    val program = GLSLProgram(vertexShader, fragmentShader)
    init {
        program.use()
        program.setInt("image", 0)
        program.setInt("sprite", 1)
        program.setInt("mask", 2)
        program.setInt("alpha", 3)
        program.setInt("color", 4)
        program.setInt("outline", 5)
        program.setInt("outlineColor", 6)
        program.setInt("outlineAlpha", 7)
        program.setInt("outlineWidth", 8)
        program.setInt("outlineBlur", 9)
        program.setInt("outlineOffset", 10)
        program.setInt("outlineMask", 11)
        program.setInt("outlineMaskColor", 12)
        program.setInt("outlineMaskAlpha", 13)
        program.setInt("outlineMaskBlur", 14)
        program.setInt("outlineMaskOffset", 15)
        program.setInt("outlineMaskWidth", 16)
        program.setInt("outlineMaskHeight", 17)
        program.setInt("outlineMaskScale", 18)
        program.setInt("outlineMaskRotation", 19)
    }

    fun use() {

        program.use()
        program.setInt("image", 0)
        program.setInt("sprite", 1)
        program.setInt("mask", 2)
        program.setInt("alpha", 3)
        program.setInt("color", 4)
        program.setInt("outline", 5)
        program.setInt("outlineColor", 6)
        program.setInt("outlineAlpha", 7)
        program.setInt("outlineWidth", 8)
        program.setInt("outlineBlur", 9)
        program.setInt("outlineOffset", 10)
        program.setInt("outlineMask", 11)
        program.setInt("outlineMaskColor", 12)
        program.setInt("outlineMaskAlpha", 13)
        program.setInt("outlineMaskBlur", 14)
        program.setInt("outlineMaskOffset", 15)
        program.setInt("outlineMaskWidth", 16)
        program.setInt("outlineMaskHeight", 17)
        program.setInt("outlineMaskScale", 18)
        program.setInt("outlineMaskRotation", 19)
        program.setInt("outlineMaskScale", 18)
        program.setInt("outlineMaskRotation", 19)
    }


    fun loadShader(filename: String, type: GLSLShader.Type): GLSLShader {
        return GLSLShader(filename, type)
    }


}