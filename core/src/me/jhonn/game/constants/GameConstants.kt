package me.jhonn.game.constants

object ConvertUnits {
    const val PPM = 16f


    fun toGameUnits(value: Float): Float {
        return value * PPM
    }

    fun toBox2DUnits(value: Float): Float {
        return value / PPM
    }

}
object Screen{
    const val VIEWPORT_WIDTH =16f
    const val VIEWPORT_HEIGHT = 9f
    val UI_VIEWPORT_WIDTH = ConvertUnits.toGameUnits(VIEWPORT_WIDTH)
    val UI_VIEWPORT_HEIGHT = ConvertUnits.toGameUnits(VIEWPORT_HEIGHT)
}
object Physical{
    const val GRAVITY_FORCE = 0f
    const val STEP_TIME = 1f / 60f
    const val VELOCITY_ITERATIONS = 6
    const val POSITION_ITERATIONS = 2
}