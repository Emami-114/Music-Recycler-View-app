package de.syntax_institut.myapplication.adapter.model

import android.content.Context

class MusicLoader(private val context:Context) {


    fun loadGenres():MutableList<Genre>{
        val genres = mutableListOf<Genre>(
            Genre("Popular",loadMusic()), Genre("Today",loadMusic()),
            Genre("Pop",loadMusic()),Genre("Rap",loadMusic()),Genre("Classic",loadMusic())
        )
        return genres
    }

    fun loadMusic(): MutableList<Music> {
        val musics = mutableListOf<Music>()

        for (i in 1..20){
            musics.add(Music(getImage(i),getTitle(i),getSubTitle(i)))
        }

        return musics
    }



    private fun getTitle(index:Int): Int {
        return context.resources.getIdentifier(
            "musicName$index",
            "string",
            context.packageName
        )
    }

    private fun getImage(index:Int):Int{
        return context.resources.getIdentifier(
            "music$index",
            "drawable",
            context.packageName
        )

    }
    private fun getSubTitle(index:Int):Int{
        return context.resources.getIdentifier(
            "musicSubTitle$index",
            "string",
            context.packageName
        )

    }
}