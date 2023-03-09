package com.mygdx.game

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import me.jhonn.game.main.Game
import java.awt.DisplayMode

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {

        val config = Lwjgl3ApplicationConfiguration()
        config.setTitle("MyEngine")
        config.setWindowedMode(640, 360)
        config.setResizable(true)
        Lwjgl3Application(Game(), config)
    }
}