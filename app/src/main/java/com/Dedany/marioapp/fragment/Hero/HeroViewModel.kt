package com.Dedany.marioapp.fragment.Hero


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.Dedany.marioapp.entities.Character

class HeroViewModel : ViewModel() {

    private val _heroList = MutableLiveData<List<Character>>()
    val HeroList: LiveData<List<Character>> = _heroList
    val isLogged = MutableLiveData<Boolean>()


    fun getCharacterList() {

        this._heroList.value = listOf(

            Character(
                0,
                "Mario Bross",
                "https://static.wikia.nocookie.net/caracteres/images/7/75/Mario.png/revision/latest?cb=20120910002750&path-prefix=es"
            ),
            Character(
                1,
                "Luigi Bross",
                "https://static.wikia.nocookie.net/loquendocity/images/8/8d/Mario_Verrde.png/revision/latest?cb=20190518141334&path-prefix=es"
            ),
            Character(
                2,
                "Princesa Peach",
                "https://www.debate.com.mx/__export/1687463477603/sites/debate/img/2023/06/22/princesa-peach_x1x_x1x.jpeg_172596871.jpeg"
            ), Character(
                3,
                "Toad",
                "https://images.wikidexcdn.net/mwuploads/esssbwiki/4/4f/latest/20230118173635/Toad_Mario_Party_Superstars.png")
            )

    }

    fun updateCharacterList(position: Int, character: Character) {
        _heroList.value?.get(position)?.apply {
            name = character.name
            image = character.image
        }
    }

}