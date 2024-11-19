package jp.ac.nkc_ai06.myallergy.fragments

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import jp.ac.nkc_ai06.myallergy.R

class SettingFragment : Fragment() {

    private lateinit var SetlistView: ListView
    private lateinit var SetoplistView: ListView
    private lateinit var detailTextView: TextView
    private lateinit var Tvsample: TextView
    private lateinit var TextSizechange: RadioGroup
    private var currentTextSize: Float = 24f

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)




        SetlistView = view.findViewById(R.id.LvSetting)
        SetoplistView = view.findViewById(R.id.LvSettingOpt)
        detailTextView = view.findViewById(R.id.detailTextView)
        Tvsample = view.findViewById(R.id.Tvsample)
        TextSizechange = view.findViewById(R.id.rgTextSize)

        SetoplistView.visibility = View.GONE
        Tvsample.visibility = View.GONE
        TextSizechange.visibility = View.GONE



        // アイテムクリックリスナーを設定
        SetlistView.setOnItemClickListener { parent, view, position, id ->
            // クリックされたアイテムのテキストを取得
            val item = parent.getItemAtPosition(position) as String

            // ListViewを非表示にし、詳細表示用のTextViewを表示、対応するアイテムの展開先のListも表示
            if (item == "アカウント設定"){
                SetlistView.visibility = android.view.View.GONE
                detailTextView.visibility = android.view.View.VISIBLE
                SetoplistView.visibility = android.view.View.VISIBLE
                detailTextView.text = "<戻る"
            }else {
                SetlistView.visibility = android.view.View.GONE
                SetoplistView.visibility = android.view.View.GONE
                TextSizechange.visibility = android.view.View.VISIBLE
                Tvsample.visibility = android.view.View.VISIBLE
                detailTextView.visibility = android.view.View.VISIBLE
                detailTextView.text = "<戻る"

                TextSizechange.setOnCheckedChangeListener { _, checkedId ->
                    currentTextSize = when (checkedId){
                        R.id.rbTextmid -> currentTextSize - 12f
                        R.id.rbTextlar -> currentTextSize + 12f
                        else -> currentTextSize
                    }

                    Tvsample.setTextSize(TypedValue.COMPLEX_UNIT_SP,currentTextSize)
                }
            }
        }

        // 詳細表示のTextViewをクリックするとListViewに戻る
        detailTextView.setOnClickListener {
            detailTextView.visibility = View.GONE
            SetoplistView.visibility = View.GONE
            Tvsample.visibility = View.GONE
            TextSizechange.visibility = View.GONE
            SetlistView.visibility = View.VISIBLE
        }
        return view


    }
}