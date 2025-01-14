package com.Dedany.marioapp.fragment.Villain


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.Dedany.marioapp.entities.Character

class VillainViewModel: ViewModel() {

    private val _villainList= MutableLiveData<List<Character>>()
    val VillainList: LiveData<List<Character>> = _villainList
    val isLogged = MutableLiveData<Boolean>()


    fun getCharacterList(){

        this._villainList.value= listOf(

            Character(0,"Goomba","https://img.buzzfeed.com/buzzfeed-static/static/2015-02/22/13/enhanced/webdr11/enhanced-buzz-29278-1424629328-24.jpg?downsize=700%3A%2A&output-quality=auto&output-format=auto"
            ),
            Character(0,"Bowser","https://static.wikia.nocookie.net/villano/images/6/62/Bowser.jpg/revision/latest?cb=20200725225550&path-prefix=es"
            )
        )

    }

    fun updateCharacterList(position: Int, character:Character){
        _villainList.value?.get(position)?.apply {
            name = character.name
            image= character.image
        }
    }

}