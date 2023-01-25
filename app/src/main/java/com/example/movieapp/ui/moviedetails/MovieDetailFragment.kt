package com.example.movieapp.ui.moviedetails

import android.graphics.Movie
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieDetailBinding


//primero se crea la vista q lo hacemos aqui abajo : Fragment(R.layout.fragment_movie_detail
class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {

   // esta variable de abajo la creamos por q se han generado un binding gracais a buildfeatures q hemos creado en build.gradle que crea una clase binding para cada una de nuestras layouts
    private lateinit var binding: FragmentMovieDetailBinding //usamos lateinit porq vamos a inicializarlo luego
    private val args by navArgs<MovieDetailFragmentArgs>() //esto de moviedatailfragmentargs se ha generado cuando hemos hecho rebuild project en lo de navigation graphics

    //Y aquí accedemos a la vista
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailBinding.bind(view) //esto fragmentmoviedetailbinding hace punto bind sobre la view que es R.layout.fragment_movie_detail

        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/${args.posterImageUrl}").centerCrop().into(binding.imgMovie) //con el Glide para pillar la url de la imagen
        Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/${args.backgroundImageUrl}").centerCrop().into(binding.imgBackground) //con el Glide para pillar la url de la imagen
        binding.txtDescription.text = args.overview
        binding.txtMovieTitle.text = args.title
        binding.txtLanguage.text = "Language ${args.language}"
        binding.txtRating.text = "${args.voteAverage} (${args.voteCount} Reviews)"
        binding.txtReleased.text = "Released ${args.releaseDate}"
    }

}