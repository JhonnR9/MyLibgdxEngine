package me.jhonn.game.util

import com.badlogic.gdx.physics.box2d.*
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType
import me.jhonn.game.enuns.UserData

class Physical(
    private val x: Float,
    private val y: Float,
    private val width: Float,
    private val height: Float
) {

    lateinit var body: Body

    fun createBox2dBody(bodyType: BodyType, userData: UserData) {
        println("$width")
        val bodyDef = BodyDef()
        bodyDef.fixedRotation = true
        bodyDef.type = bodyType
        bodyDef.position.set(x, y)

        val shape = PolygonShape()
        shape.setAsBox(width / 2, height / 2)

        val fixtureDef = FixtureDef()
        fixtureDef.shape = shape
        fixtureDef.density = 1f

        fun createBody(world: World){
            body = world.createBody(bodyDef)
            body.createFixture(fixtureDef).userData = userData
        }


    }


}