package com.Dedany.marioapp.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.Dedany.marioapp.entities.Character

class CharacterViewModel: ViewModel() {

    private val _characterList= MutableLiveData<List<Character>>()
    val characterList: LiveData<List<Character>> = _characterList
    val isLogged = MutableLiveData<Boolean>()


    fun getCharacterList(){

        this._characterList.value= listOf(

            Character(0,"Mario Bross","https://static.wikia.nocookie.net/caracteres/images/7/75/Mario.png/revision/latest?cb=20120910002750&path-prefix=es"
            ),
            Character(0,"Luigi Bross","https://static.wikia.nocookie.net/loquendocity/images/8/8d/Mario_Verrde.png/revision/latest?cb=20190518141334&path-prefix=es"
        )
        )

    }

    fun updateCharacterList(position: Int, character:Character){
        _characterList.value?.get(position)?.apply {
            name = character.name
            image= character.image
        }
    }
    
}