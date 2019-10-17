package br.com.cotemig.aula06.ui.activites

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import br.com.cotemig.aula06.R
import br.com.cotemig.aula06.ui.fragments.AddFragment
import br.com.cotemig.aula06.ui.fragments.HomeFragment
import br.com.cotemig.aula06.ui.fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(HomeFragment())

        home.setOnClickListener {
            setFragment(HomeFragment())
        }

        search.setOnClickListener {
            setFragment(SearchFragment())
        }

        add.setOnClickListener {
            setFragment(AddFragment())
        }
    }

    fun setFragment(f: Fragment){
        var ft = supportFragmentManager.beginTransaction() // iniciando uma troca de fragment
        ft.replace(R.id.content, f) // local onde será trocado o frament
        ft.addToBackStack(null) // empilha os fragments que foram adicionados no FrameLayout
        ft.commit() // confirmo a troca
    }
}
