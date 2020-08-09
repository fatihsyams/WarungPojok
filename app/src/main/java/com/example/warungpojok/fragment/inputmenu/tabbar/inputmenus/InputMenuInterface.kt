package com.example.warungpojok.fragment.inputmenu.tabbar.inputmenus

interface InputMenuInterface {
    interface InputMenusView {
        fun showAlertSuccess(msg: String)
        fun showAlertFailed(msg: String)
        fun navigateToHome()
    }

    interface InputMenusPresenter {
        fun logicInputMenus(
            name: String,
            description: String,
            price: String,
            category: String,
            stock: String,
            image: String
        )
    }
}