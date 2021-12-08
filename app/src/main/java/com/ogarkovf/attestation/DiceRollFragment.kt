package com.ogarkovf.attestation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

private const val LAST_ROLLED_IMAGE="image"
class DiceRollFragment : Fragment() {

    lateinit var diceImageView: ImageView
    lateinit var rollButton: Button

    private val diceImageList: List<Int> = listOf(
        R.drawable.answer1,
        R.drawable.answer2,
        R.drawable.answer3,
        R.drawable.answer4,
        R.drawable.answer5,
        R.drawable.answer6,
    )

var lastRolledImageRes=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_dice_roll, container, false)

        diceImageView = view.findViewById(R.id.dice_image_view)
        rollButton = view.findViewById(R.id.roll_button)

        if (savedInstanceState != null)
            diceImageView.setImageResource(savedInstanceState.getInt(LAST_ROLLED_IMAGE))

        rollButton.setOnClickListener {
            lastRolledImageRes=diceImageList.random()
diceImageView.setImageResource(lastRolledImageRes)

        }


        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_ROLLED_IMAGE, lastRolledImageRes)
    }
}