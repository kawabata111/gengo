package jp.ac.nkc_ai06.myallergy.fragments.HomePagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomePagerAdapter(fragmentActivity: FragmentActivity, private val fragments: List<Fragment>) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
