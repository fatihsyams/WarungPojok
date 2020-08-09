package com.example.warungpojok.fragment.inputmenu.tabbar.inputmenus

import android.util.Log
import android.widget.Toast
import com.example.warungpojok.RequestInputMenu
import com.example.warungpojok.ResponseInputMenu
import com.example.warungpojok.network.WarungPojokService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputMenusPresenter(model: InputMenuInterface.InputMenusView) :
    InputMenuInterface.InputMenusPresenter {

    var view: InputMenuInterface.InputMenusView? = null

    init {
        view = model
    }

    override fun logicInputMenus(
        name: String,
        description: String,
        price: String,
        category: String,
        stock: String,
        image: String
    ) {
        val menusBody = RequestInputMenu(name, description, price, category, stock, image)
 z        val doLogin = WarungPojokService.create()
        doLogin.inputMenu(menusBody).enqueue(object : Callback<ResponseInputMenu> {
            override fun onFailure(call: Call<ResponseInputMenu>, t: Throwable) {
                Log.d("TAG", "${t.message}")
                view?.showAlertFailed(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<ResponseInputMenu>,
                response: Response<ResponseInputMenu>
            ) {

                if (response.body() != null) {
                    var responseMenus = response.body()
                    view?.showAlertSuccess(response.message())
                    Log.d("TAG", responseMenus.toString())
                }

            }

        })
    }

}