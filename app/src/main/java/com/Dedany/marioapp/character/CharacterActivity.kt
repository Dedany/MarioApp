package com.Dedany.marioapp.character

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.Dedany.marioapp.adapters.CharactersAdapter
import com.Dedany.marioapp.databinding.ActivityCharacterBinding
import com.Dedany.marioapp.entities.Character

class CharacterActivity : AppCompatActivity() {

    private var binding: ActivityCharacterBinding? = null
    private var characterAdapter: CharactersAdapter? = null

    private var viewModel: CharacterViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)

        setAdapters()
        setUpObservers()


        viewModel?.getCharacterList()



    }

    private fun setAdapters() {
        characterAdapter = CharactersAdapter {}

        binding?.recyclerCharacter?.layoutManager = LinearLayoutManager(this)
        binding?.recyclerCharacter?.adapter = characterAdapter
    }


    private fun setUpObservers() {

        viewModel?.isLogged?.observe(this) {

        }
        viewModel?.characterList?.observe(this) { it ->

        }

        viewModel?.characterList?.observe(this) {
            characterAdapter?.submitList(it)
        }
    }


}