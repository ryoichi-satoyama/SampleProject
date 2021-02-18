package jp.techacademy.ryoichi.satoyama.sampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userList = mutableListOf<User>()
        for (i in 1..5) {
            val user = User(i.toLong(), "user$i")
            userList.add(user)
        }

        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, userList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        userSpinner.adapter = adapter
        userSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val id = userList[position].id
                Log.d("LOGLOG", "aaa:$id")
                var bid = userSpinner.selectedItemId
                Log.d("LOGLOG", "bbb:$bid")
                var user = userSpinner.selectedItem as User
                Log.d("LOGLOG", user.toString())
                userSpinner.setSelection(adapter.getPosition(user))
            }
        }

        var user = userList[2]
        userSpinner.setSelection(adapter.getPosition(user))

//        var index = 0
//        for(u in userList) {
//            if(u.name == "user3") {
//                user = u
//                break
//            }
//            index++
//        }
//        userSpinner.setSelection(index)



    }
}