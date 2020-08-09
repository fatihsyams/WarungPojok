package com.example.warungpojok.fragment.inputmenu.tabbar.inputmenus


import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.warungpojok.R
import com.example.warungpojok.utils.RESULT_OKE
import kotlinx.android.synthetic.main.fragment_input_menus.*
import retrofit2.HttpException


class InputMenusFragment : Fragment(), InputMenuInterface.InputMenusView {

    lateinit var presenter: InputMenusPresenter


    companion object {
        val PICK_IMAGE = 1
        var uri: Uri? = null
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_menus, container, false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = InputMenusPresenter(this)

        btnInputMenu.setOnClickListener {
            presenter.logicInputMenus(
                edtInputNamaMenu.text.toString(),
                edtInputKeteranganMenu.text.toString(),
                edtInputHargaMenu.text.toString(),
                edtInputKategoriMenu.text.toString(),
                edtInputStokMenu.text.toString(),
                "https://www.google.com/search?q=gambar&safe=strict&rlz=1C5CHFA_enID863ID863&sxsrf=ALeKk00YU_eBkRvp9tLcJjjI1prxt8hyDA:1596952997104&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjm3vXAuY3rAhVK63MBHU3fDMgQ_AUoAXoECAwQAw&biw=1440&bih=732#imgrc=8NHXSQWB7K_PtM"
            )
        }

        imgInputMenus.setOnClickListener {
            Toast.makeText(context, "TEST", Toast.LENGTH_LONG).show()
            val intentGallery = Intent()
            intentGallery.apply {
                type = "image/*"
                action = Intent.ACTION_GET_CONTENT
                startActivityForResult(
                    Intent.createChooser(intentGallery, "Pilih Photo"),
                    PICK_IMAGE
                )
            }
        }


    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val resolver = activity!!.contentResolver

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OKE) {
            try {
                uri = data?.data
                val bitmap: Bitmap =
                    MediaStore.Images.Media.getBitmap(resolver, uri)
                imgInputMenus.setImageBitmap(bitmap)
            } catch (e: HttpException) {
                Toast.makeText(context, e.message(), Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun showAlertSuccess(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showAlertFailed(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun navigateToHome() {
        TODO("Not yet implemented")
    }
}
