package com.example.asm_ph35067_kotlin.model

data class ModelUser(
    val id_user : Int,
    val name_user : String,
    val email_user : String,
    val img_user : String,
    val password_user:String
){
    companion object{
        fun getModelUser()= listOf(
            ModelUser(
                id_user = 1,
                name_user = "Nguyen dung",
                email_user = "dungntph35067@gmail.com",
                img_user = "https://cdn.pixabay.com/photo/2024/04/05/05/17/airplane-8676556_1280.jpg",
                password_user = "123456"
            ),
            ModelUser(
                id_user = 2,
                name_user = "Nguyen anh",
                email_user = "anhntph99999@gmail.com",
                img_user = "https://i.pinimg.com/originals/ca/49/d2/ca49d2a4ccb6702fdf4cb70d4a524c3c.jpg",
                password_user = "123456"
            )
        )
    }
}
