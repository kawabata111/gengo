package jp.ac.nkc_ai06.myallergy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import jp.ac.nkc_ai06.myallergy.fragments.CameraFragment
import jp.ac.nkc_ai06.myallergy.fragments.HomePagerAdapter.HomePagerAdapter
import jp.ac.nkc_ai06.myallergy.fragments.RegisterFragment
import jp.ac.nkc_ai06.myallergy.fragments.SettingFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)

        // ViewPager2に表示するフラグメントのリストを作成
        val fragments = listOf<Fragment>(
            CameraFragment(),
            SettingFragment()
        )

        // ViewPager2にアダプターを設定
        viewPager.adapter = HomePagerAdapter(this, fragments)

        // TabLayoutとViewPager2を関連付けて、タブのタイトルを設定
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Camera"
                1 -> tab.text = "Setting"
            }
        }.attach()
    }
}