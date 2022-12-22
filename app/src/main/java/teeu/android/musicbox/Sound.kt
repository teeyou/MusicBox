package teeu.android.musicbox

class Sound(val assetPath : String, var soundId : Int? = null) {
    val name = assetPath.split("/").last().removeSuffix(".mp3")
}