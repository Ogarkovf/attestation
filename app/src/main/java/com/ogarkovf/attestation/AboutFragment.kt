package com.ogarkovf.attestation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AboutFragment : Fragment() {

    lateinit var developerRecyclerView: RecyclerView
    lateinit var siteButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_about, container, false)

        val developersNames: List<String> = listOf("Organizers","Maxim the Teacher","Curators")

        siteButton=view.findViewById(R.id.site_button)
        developerRecyclerView=view.findViewById(R.id.developers_recycler_view)
        developerRecyclerView.layoutManager=
            LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        developerRecyclerView.adapter=DeveloperAdapter(developersNames)

        siteButton.setOnClickListener {
            val link= Uri.parse("https://tgu-dpo.ru/program/DevelopAndroidApplications/")
            val intent=Intent(Intent.ACTION_VIEW,link)
            context?.startActivity(intent)
        }


        return view
    }

}