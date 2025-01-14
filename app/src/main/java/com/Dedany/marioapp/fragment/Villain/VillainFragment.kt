package com.Dedany.marioapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.Dedany.marioapp.adapters.CharactersAdapter
import com.Dedany.marioapp.character.CharacterViewModel
import com.Dedany.marioapp.databinding.FragmentHeroBinding
import com.Dedany.marioapp.databinding.FragmentVillainBinding
import com.Dedany.marioapp.fragment.Hero.HeroViewModel
import com.Dedany.marioapp.fragment.Villain.VillainViewModel

class VillainFragment : Fragment() {
    private var binding: FragmentVillainBinding? = null
    private var characterAdapter: CharactersAdapter? = null

    private var viewModel: VillainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVillainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(VillainViewModel::class.java)

        setAdapters()
        setUpObservers()


        viewModel?.getCharacterList()
        return binding?.root
    }

    private fun setAdapters() {
        characterAdapter = CharactersAdapter {}

        binding?.recyclerCharacter?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recyclerCharacter?.adapter = characterAdapter
    }


    private fun setUpObservers() {

        viewModel?.isLogged?.observe(requireActivity()) {

        }
        viewModel?.VillainList?.observe(requireActivity()) { it ->

        }

        viewModel?.VillainList?.observe(requireActivity()) {
            characterAdapter?.submitList(it)
        }
    }
}
