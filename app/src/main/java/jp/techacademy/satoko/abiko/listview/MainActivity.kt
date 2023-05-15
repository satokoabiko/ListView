package jp.techacademy.satoko.abiko.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SimpleAdapter
import jp.techacademy.satoko.abiko.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Map<String, String> 型のArrayListを作成します
        val list = ArrayList<Map<String, String>>()

        for (i in 0..10) {
            val map = HashMap<String, String>()
            map["main"] = "メイン $i"
            map["sub"] = "サブ $i"
            list.add(map)
        }

        val adapter = SimpleAdapter(
            this,
            list,
            android.R.layout.simple_list_item_2,
            arrayOf("main", "sub"),
            intArrayOf(android.R.id.text1, android.R.id.text2)
        )

        binding.listView.adapter = adapter
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            Log.d("UI_PARTS", "クリック $position")
        }
    }
}