package br.com.cotemig.aula06.ui.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast

import br.com.cotemig.aula06.R
import br.com.cotemig.aula06.models.Post
import br.com.cotemig.aula06.services.RetrofitInitializer
import br.com.cotemig.aula06.ui.activites.MainActivity
import br.com.cotemig.aula06.ui.adapters.FeedAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFeed()
    }

    fun getFeed(){

        var s = RetrofitInitializer().serviceFeed()
        var call = s.get()

        var context = context as MainActivity

        call.enqueue(object : retrofit2.Callback<List<Post>>{

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {

                response?.let {

                    if(it.code() == 200){

                        feed.adapter = FeedAdapter(context, it.body())

                    }

                }

            }

            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                Toast.makeText(context, "Ops", Toast.LENGTH_LONG).show()
            }

        })



    }
}
