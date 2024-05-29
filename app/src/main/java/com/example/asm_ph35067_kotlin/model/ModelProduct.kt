package com.example.asm_ph35067_kotlin.model

data class ModelProduct(
    val id_prod : Int,
    val ten_prod: String,
    val gia_prod: Double,
    val anh_prod: String,
    val danhGia_prod :String,
    val luot_prod: String,
    val mota_prod: String
) {
    companion object {
        fun getModelProduct() = listOf(
            ModelProduct(
                id_prod = 1,
                ten_prod = "Queen size bed",
                gia_prod = 200.0,
                anh_prod = "qwewqewqeqe",
                danhGia_prod = "4.5",
                luot_prod = "50 reviews",
                mota_prod = "qweqwewqewqewqewqewq"
            ),
        )
    }
}
