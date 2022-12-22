package teeu.android.musicbox

import android.content.res.AssetFileDescriptor
import android.content.res.AssetManager
import android.media.SoundPool
import android.util.Log

private const val TAG = "MusicBox"
private const val SOUNDS_FOLDER = "sample_sounds"
private const val MAX_SOUNDS = 1

class MusicBox(private val assets: AssetManager) {
    val sounds : List<Sound>
    val soundPool = SoundPool.Builder().setMaxStreams(MAX_SOUNDS).build()
    init {
        sounds = loadSounds()
    }
    private fun loadSounds() : List<Sound> {
        val soundName : Array<String>

        try {
            soundName = assets.list(SOUNDS_FOLDER)!!
        } catch (e : Exception) {
            Log.e(TAG,"Could not list assets", e)
            return emptyList()
        }

        val sounds = mutableListOf<Sound>()
        soundName.forEach { fileName ->
            val assetPath = "$SOUNDS_FOLDER/$fileName"
            val sound = Sound(assetPath)
            try {
                load(sound)
                sounds.add(sound)
            } catch (e : Exception) {
                Log.e(TAG,"Could not load sound ${fileName}", e)
            }
        }

        return sounds
    }

    private fun load(sound : Sound) {
        val afd : AssetFileDescriptor = assets.openFd(sound.assetPath)
        val soundId = soundPool.load(afd, 1)
        sound.soundId = soundId
    }

    fun play(sound : Sound) {
        sound.soundId?.let {
            soundPool.play(it,1f,1f,1,0,1f) //priority는 0이 최저우선순위, loop는 0이면 안하고 -1이면 무한반복, 그외 숫자는 반복횟수
        }
    }

    fun release() {
        soundPool.release()
    }
}