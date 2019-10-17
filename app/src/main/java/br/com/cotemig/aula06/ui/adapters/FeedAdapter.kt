package br.com.cotemig.aula06.ui.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.aula06.R
import br.com.cotemig.aula06.models.Post
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import android.support.v7.widget.PagerSnapHelper



class FeedAdapter(var context:Context, var feed: List<Post>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = LayoutInflater.from(context).inflate(R.layout.item_feed, parent, false)

        var avatar = view.findViewById<ImageView>(R.id.avatar)
        var gallery = view.findViewById<RecyclerView>(R.id.gallery)
        var local = view.findViewById<TextView>(R.id.local)
        var user = view.findViewById<TextView>(R.id.user)
        var description = view.findViewById<TextView>(R.id.description)
        var likes = view.findViewById<TextView>(R.id.likes)

        Glide.with(view).
            load(feed[position].avatar).
            apply(RequestOptions.circleCropTransform()).
            into(avatar)

        gallery.adapter = GaleryAdapter(context, feed[position].gallery)
        gallery.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL, false)

        // add pager behavior
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(gallery)

        gallery.addItemDecoration(LinePagerIndicatorDecoration())


        local.text = feed[position].local
        user.text = feed[position].user
        description.text = feed[position].description

        if(feed[position].likes.size > 1){
            likes.text = feed[position].likes[0].plus(" e outros")
        }else if(feed[position].likes.size == 1){
            likes.text = feed[position].likes[0]
        }

        return view

    }

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return feed.size
    }
}