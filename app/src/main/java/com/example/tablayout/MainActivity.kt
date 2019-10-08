package com.example.tablayout
//add in dependency and sync otherwise not creater
//    implementation 'com.android.support:design:27.0.0'
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter=MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment() ,"Android")
        adapter.addFragment(MovieFragment() ,"Php")
        adapter.addFragment(SportFragment() ,"Java")
        adapter.addFragment(AboutFragment(),"Python")
        adapter.addFragment(KotlinFragment(),"Kotlin")
        adapter.addFragment(HtmlFragment(),"HTML")
        adapter.addFragment(CFragment(),"C++")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)



    }
    class MyViewPagerAdapter(manager : FragmentManager) : FragmentPagerAdapter(manager){

       val fragmentList:MutableList<Fragment> = ArrayList()
           val titleList:MutableList<String> = ArrayList()
        override fun getItem(position: Int): Fragment {
             return fragmentList[position]
        }

        override fun getCount(): Int {
            return titleList.size
        }
        fun addFragment( fragment : Fragment ,title: String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

    }
}

