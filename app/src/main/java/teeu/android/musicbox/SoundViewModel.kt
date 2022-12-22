package teeu.android.musicbox

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class SoundViewModel(private val musicBox: MusicBox) : BaseObservable() {
    var sound : Sound? = null
    set(value) {
        field = value
        notifyChange()
    }

    @get:Bindable
    val title : String?
    get() = sound?.name

    fun onButtonClicked() {
        sound?.let {
            musicBox.play(it)
        }
    }
}