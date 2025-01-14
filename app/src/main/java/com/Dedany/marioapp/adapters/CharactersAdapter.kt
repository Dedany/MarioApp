package com.Dedany.marioapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.Dedany.marioapp.R
import com.Dedany.marioapp.databinding.ItemCharacterListBinding

import com.Dedany.marioapp.entities.Character
import com.bumptech.glide.Glide

class CharactersAdapter(

    private val onCharacterClick: (Character) -> Unit
) : ListAdapter<Character, CharactersAdapter.CharacterVH>(ListAdapterCallback()) {

    inner class CharacterVH(private val binding: ItemCharacterListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            binding.textCharacter.text = character.name
            Glide.with(binding.root).load(character.image)
                .placeholder((R.drawable.tiempo))
                .error(android.R.drawable.ic_dialog_info)
                .into(binding.imageCharacter)

            binding.root.setOnClickListener {
                onCharacterClick(character)
            }

        }
    }

    class ListAdapterCallback : DiffUtil.ItemCallback<Character>() {


        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharactersAdapter.CharacterVH {
        val binding =
            ItemCharacterListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterVH(binding)
    }

    override fun onBindViewHolder(holder: CharactersAdapter.CharacterVH, position: Int) {
        holder.bind(getItem(position))
    }



}