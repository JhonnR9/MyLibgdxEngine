package me.jhonn.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
import com.badlogic.gdx.scenes.scene2d.Event
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.utils.viewport.FitViewport
import me.jhonn.game.constants.Screen.UI_VIEWPORT_HEIGHT
import me.jhonn.game.constants.Screen.UI_VIEWPORT_WIDTH
import me.jhonn.game.constants.Screen.VIEWPORT_HEIGHT
import me.jhonn.game.constants.Screen.VIEWPORT_WIDTH
import me.jhonn.game.main.BaseGame


abstract class BaseScreen(val game: BaseGame) : Stage(FitViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)), Screen {
    var uiStage: Stage = Stage(FitViewport(UI_VIEWPORT_WIDTH, UI_VIEWPORT_HEIGHT))
    val skin: Skin = Skin(Gdx.files.internal("skin/uiskin.json"))
    private val tag = "Screen"
    private var dDebugRenderer: Box2DDebugRenderer = createBox2DDebug()

    fun setOpacity(layerName: String, opacity: Float) {
        // tiledMapLoader?.setOpacityLayer(layerName, opacity)
    }

    private fun createBox2DDebug(): Box2DDebugRenderer {
        return Box2DDebugRenderer(
            true,
            false,
            false,
            true,
            false,
            true
        )
    }

    fun isTouchDownEvent(e: Event): Boolean {
        return if (e is InputEvent) {
            e.type.equals(Type.touchDown)
        } else false
    }


    override fun show() {
        Gdx.app.log(tag, "show")
        val input = InputMultiplexer(uiStage, this)
        Gdx.input.inputProcessor = input
        println((Gdx.input.inputProcessor as InputMultiplexer).size())
    }

    override fun hide() {
        Gdx.app.log(tag, "hide")
        if (Gdx.input.inputProcessor != null) {
            (Gdx.input.inputProcessor as InputMultiplexer).clear()
        }

    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(.1f, .1f, .14f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        super.act()
        uiStage.act()
        super.draw()
        uiStage.draw()
        dDebugRenderer.render(game.world.getWorld(), camera.combined)
    }

    override fun resize(width: Int, height: Int) {
        Gdx.app.log(tag, "resize")
        viewport.update(width, height, true)
        uiStage.viewport.update(width, height, true)

    }

    override fun pause() {}
    override fun resume() {}


    override fun dispose() {
        super.dispose()
        uiStage.dispose()
    }

    override fun keyDown(keyCode: Int): Boolean {
        return super.keyDown(keyCode)
    }


}