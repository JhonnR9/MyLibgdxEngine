package me.jhonn.game.main

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.Box2D
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
import com.badlogic.gdx.physics.box2d.World
import me.jhonn.game.actors.BaseActor
import me.jhonn.game.constants.ConvertUnits
import me.jhonn.game.constants.Physical
import me.jhonn.game.listeners.ContactListener

class World {
    private var contactListener: ContactListener
    private var world: World
    private var gravity: Vector2
    private var accumulator = 0f
    private lateinit var worldBounds: Rectangle


    init {
        Box2D.init()
        gravity = Vector2(0f, Physical.GRAVITY_FORCE)
        world = World(gravity, true)
        contactListener = ContactListener()
        world.setContactListener(contactListener)
    }

    fun getWorld(): World {
        return world
    }

    fun dispose() {
        world.dispose()
    }

    fun stepWorldBox2d() {
        val deltaTime = Gdx.graphics.deltaTime
        accumulator += deltaTime.coerceAtMost(0.25f)
        if (accumulator >= Physical.STEP_TIME) {
            accumulator -= Physical.STEP_TIME
            world.step(Physical.STEP_TIME, Physical.VELOCITY_ITERATIONS, Physical.POSITION_ITERATIONS)
        }
    }

    fun createWorldBoundsOfTiledMap(tiledMap: TiledMap) {
        val w = (
                tiledMap.properties.get("width").toString().toFloat()
                        * tiledMap.properties.get("tilewidth")
                    .toString()
                    .toFloat()) / ConvertUnits.PPM
        val h = (tiledMap.properties.get("height").toString().toFloat()
                * tiledMap.properties.get("tileheight")
            .toString()
            .toFloat()) / ConvertUnits.PPM
        worldBounds = Rectangle(0f, 0f, w, h)
    }

    fun alignCameraToActor(camera: Camera, actor: BaseActor) {
        camera.apply {
            position.set(
                actor.body.position.x + ConvertUnits.toBox2DUnits(actor.originX),
                actor.body.position.y + ConvertUnits.toBox2DUnits(actor.originY), 0f
            )

            val minX = viewportWidth / 2
            val maxX = worldBounds.width - viewportWidth / 2
            position.x = MathUtils.clamp(position.x, minX, maxX)

            val minY = viewportHeight / 2
            val maxY = worldBounds.height - viewportHeight / 2
            position.y = MathUtils.clamp(position.y, minY, maxY)

            update()
        }
    }
}


