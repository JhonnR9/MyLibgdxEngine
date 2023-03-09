package me.jhonn.game.main

import com.badlogic.gdx.Game


abstract class BaseGame() : Game() {
    lateinit var world: World
    override fun create() {
        world = World()
    }

    override fun render() {
        super.render()
        world.stepWorldBox2d()
    }

    override fun dispose() {
        world.dispose()
        super.dispose()
    }


}
