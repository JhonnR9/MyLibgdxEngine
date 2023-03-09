package me.jhonn.game.main

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion


class AnimationManager() {
    private var stateTime: Float = 0f
    fun update(deltaTime: Float){
        stateTime += deltaTime
    }
    fun getFrame(): TextureRegion?{
       return null
    }

    fun loadAnimationFromFiles(){

    }
    fun loadAnimationFromAtlas(){

    }


}