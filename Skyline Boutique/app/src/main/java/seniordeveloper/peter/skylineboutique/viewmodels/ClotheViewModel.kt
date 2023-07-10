package seniordeveloper.peter.skylineboutique.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import seniordeveloper.peter.skylineboutique.models.ClotheData

class ClotheViewModel: ViewModel() {
        private val _clotheData = mutableStateListOf<ClotheData>()

        val clotheData: List<ClotheData>
            get() = _clotheData

        fun addClothe(data: ClotheData) {
            _clotheData.add(data)
        }

        fun deleteClothe(data: ClotheData) {
            _clotheData.remove(data)
        }
        private val _cartItems = mutableStateListOf<ClotheData>()

        val cartItems: List<ClotheData>
            get() = _cartItems

        fun addItemToCart(item: ClotheData) {
            _cartItems.add(item)
        }

        fun removeItemFromCart(item: ClotheData) {
            _cartItems.remove(item)
        }

        fun clearCart() {
            _cartItems.clear()
        }
    }
