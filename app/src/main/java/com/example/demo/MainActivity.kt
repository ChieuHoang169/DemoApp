package com.example.demo

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
  import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var folderFragment: FolderFragment
    lateinit var notesFragment: NotesFragment
    lateinit var todoFragment: TodoFragment
    lateinit var calenderFragment: CalenderFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        loadFragment(FolderFragment())
        folderFragment = FolderFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_nav,folderFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        val bottomNavigation:BottomNavigationView = findViewById(R.id.button_navigation)
       bottomNavigation.setOnNavigationItemSelectedListener {item->
            when(item.itemId){
                R.id.folderFragment->{
                    folderFragment = FolderFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_nav,folderFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                    loadFragment(FolderFragment())
//                    return@setOnNavigationItemSelectedListener true
                }
                R.id.notesFragment ->{
                    notesFragment= NotesFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_nav,notesFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                    loadFragment(NotesFragment())
//                    return@setOnNavigationItemSelectedListener true
                }

                R.id.todoFragment ->{
                    todoFragment = TodoFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_nav,todoFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                    loadFragment(TodoFragment())
//                    return@setOnNavigationItemSelectedListener true
                }
                R.id.calenderFragment ->{
                    calenderFragment= CalenderFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_nav,calenderFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                    loadFragment(CalenderFragment())
//                    return@setOnNavigationItemSelectedListener true
                }
            }
            true
        }


    }
//    private fun loadFragment(fragment:Fragment){
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.nav_host,fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu.findItem(R.id.search)
        val searchView = searchItem.actionView as SearchView
        searchView.queryHint = "Search View Hint"
        searchView.setOnQueryTextListener(object :  SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                searchView.clearFocus()
                searchView.setQuery("",false)
                searchItem.collapseActionView()
                Toast.makeText(this@MainActivity,"Looking $query",Toast.LENGTH_LONG ).show()
                return true
            }

        })

        return true
    }


}
