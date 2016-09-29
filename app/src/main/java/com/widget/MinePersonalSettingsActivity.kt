package com.widget

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.mine_personal_settings.*

/**
 * Created by Jin on 2016/7/26.
 * Description
 */
class MinePersonalSettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mine_personal_settings)

        nickname.setRightText("LBJ")
        nickname.setLeftText("昵称")

        sex.setRightText("男")

        birthDay.setRightText("2016-07-26")

        ids.setRightText("居民")

        phoneNum.setRightText("188 8888 1111")
    }
}
