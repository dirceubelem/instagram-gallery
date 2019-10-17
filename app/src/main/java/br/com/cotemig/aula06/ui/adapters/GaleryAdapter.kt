package br.com.cotemig.aula06.ui.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import br.com.cotemig.aula06.R
import br.com.cotemig.aula06.models.Image
import com.bumptech.glide.Glide

class GaleryAdapter(var context: Context, var list: List<Image>) :
        RecyclerView.Adapter<GaleryAdapter.ViewHolderGalery>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGalery {
        val view = LayoutInflater.from(context).inflate(R.layout.item_galery, parent, false)
        return ViewHolderGalery(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderGalery, position: Int) {
        holder.bind(context, list[position])
    }

    class ViewHolderGalery(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(context: Context, item: Image){

            var image = itemView.findViewById<ImageView>(R.id.image)
            Glide.with(context).load(item.image).into(image)

        }
    }
}