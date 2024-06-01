package com.example.asm_ph35067_kotlin.model

data class ModelProduct(
    val id_prod: Int,
    val name_prod: String,
    val type_prod: String,
    val price_prod: Double,
    val imgUrl_prod: String,
    val favorite_prod: Int,
    val evaluate_prod: String,
    val reviews_prod: Int,
    val description_prod: String
) {
    companion object {
        fun getModelProduct() = listOf(
            // Popular
            ModelProduct(
                id_prod = 1,
                name_prod = "Modern Sofa",
                type_prod = "Popular",
                price_prod = 499.99,
                imgUrl_prod = "https://i.pinimg.com/736x/56/93/43/5693432ac9e03b7cf8a4aec5bb7eff50.jpg",
                favorite_prod = 1,
                evaluate_prod = "4.5",
                reviews_prod = 120,
                description_prod = "A comfortable modern sofa with a stylish design."
            ),
            ModelProduct(
                id_prod = 2,
                name_prod = "Luxury Armchair",
                type_prod = "Popular",
                price_prod = 259.99,
                imgUrl_prod = "https://m.media-amazon.com/images/I/71YUDttY9-L._AC_UL320_.jpg",
                favorite_prod = 0,
                evaluate_prod = "4.7",
                reviews_prod = 90,
                description_prod = "A luxury armchair with elegant design."
            ),
            ModelProduct(
                id_prod = 3,
                name_prod = "Elegant Coffee Table",
                type_prod = "Popular",
                price_prod = 199.99,
                imgUrl_prod = "https://assets.wfcdn.com/im/74499058/compr-r85/1872/187218616/brhianna-solid-wood-elegant-coffee-table.jpg",
                favorite_prod = 1,
                evaluate_prod = "4.6",
                reviews_prod = 80,
                description_prod = "An elegant coffee table with a glass top."
            ),
            ModelProduct(
                id_prod = 4,
                name_prod = "Modern Bookshelf",
                type_prod = "Popular",
                price_prod = 299.99,
                imgUrl_prod = "https://www.lafurniturestore.com/media/catalog/product/cache/538cc4518959cfdf52cabbc47ba94e19/b/r/brewer_vgbb_78413_walnut_shelf_unit_0.jpg",
                favorite_prod = 1,
                evaluate_prod = "4.4",
                reviews_prod = 75,
                description_prod = "A modern bookshelf to organize your books."
            ),
            ModelProduct(
                id_prod = 5,
                name_prod = "Stylish TV Stand",
                type_prod = "Popular",
                price_prod = 399.99,
                imgUrl_prod = "https://m.media-amazon.com/images/I/81Welz1N8OL._AC_UF894,1000_QL80_.jpg",
                favorite_prod = 0,
                evaluate_prod = "4.5",
                reviews_prod = 60,
                description_prod = "A stylish TV stand with ample storage."
            ),
            // Bed
            ModelProduct(
                id_prod = 6,
                name_prod = "King Size Bed",
                type_prod = "Bed",
                price_prod = 799.99,
                imgUrl_prod = "https://media.karousell.com/media/photos/products/2023/7/15/mid_century_modern_style_queen_1689412633_227ffb80_progressive.jpg",
                favorite_prod = 0,
                evaluate_prod = "4.8",
                reviews_prod = 45,
                description_prod = "A luxurious king size bed for ultimate comfort."
            ),
            ModelProduct(
                id_prod = 7,
                name_prod = "Queen Size Bed",
                type_prod = "Bed",
                price_prod = 699.99,
                imgUrl_prod = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTuOtwAgTFm-rGTH4jARztwA7V8h0Py2hL8fRec7f-o5rF0SmX25BEMYbL4GTXGBjMMiYc&usqp=CAU",
                favorite_prod = 1,
                evaluate_prod = "4.7",
                reviews_prod = 50,
                description_prod = "A spacious queen size bed with a modern design."
            ),
            ModelProduct(
                id_prod = 8,
                name_prod = "Single Bed",
                type_prod = "Bed",
                price_prod = 499.99,
                imgUrl_prod = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST-TBk9pLneGydjsdGdaf7QoA2FFdxT54QH7HAl4a57pTjPkiRehhyCBXLsRsdUSr9zgs&usqp=CAU",
                favorite_prod = 1,
                evaluate_prod = "4.5",
                reviews_prod = 65,
                description_prod = "A comfortable single bed perfect for a small room."
            ),
            ModelProduct(
                id_prod = 9,
                name_prod = "Bunk Bed",
                type_prod = "Bed",
                price_prod = 599.99,
                favorite_prod = 0,
                imgUrl_prod = "https://m.media-amazon.com/images/I/81FWBIAxoiL._AC_UF894,1000_QL80_.jpg",
                evaluate_prod = "4.6",
                reviews_prod = 70,
                description_prod = "A practical bunk bed for kids."
            ),
            ModelProduct(
                id_prod = 10,
                name_prod = "Platform Bed",
                type_prod = "Bed",
                price_prod = 749.99,
                imgUrl_prod = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0pYig85iPnpAojDw__olIaZXv_nFussoU8TED0C6GZ9hunsFZslYWOkV4CcFFSaKjJmQ&usqp=CAU",
                favorite_prod = 1,
                evaluate_prod = "4.8",
                reviews_prod = 55,
                description_prod = "A stylish platform bed with ample storage."
            ),
            // Table
            ModelProduct(
                id_prod = 11,
                name_prod = "Glass Coffee Table",
                type_prod = "Table",
                price_prod = 249.99,
                imgUrl_prod = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTuehe4wJwau7jAlqNNequHMpl-s1dp36GUzQ&usqp=CAU",
                favorite_prod = 0,
                evaluate_prod = "4.7",
                reviews_prod = 60,
                description_prod = "A sleek coffee table with a glass top."
            ),
            ModelProduct(
                id_prod = 12,
                name_prod = "Dining Table",
                type_prod = "Table",
                price_prod = 599.99,
                imgUrl_prod = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_H2dj7yP_g-1QledFJmP3r3Ra_0ZHFwEqBQ&usqp=CAU",
                favorite_prod = 0,
                evaluate_prod = "4.5",
                reviews_prod = 40,
                description_prod = "A modern dining table set with 6 chairs."
            ),
            ModelProduct(
                id_prod = 13,
                name_prod = "Office Desk",
                type_prod = "Table",
                price_prod = 249.99,
                imgUrl_prod = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTTABf3Qz0bU5fxMEvOn1Tc-4F8wcDjHwqMMA&s",
                favorite_prod = 0,
                evaluate_prod = "4.3",
                reviews_prod = 75,
                description_prod = "A spacious office desk with drawers."
            ),
            ModelProduct(
                id_prod = 14,
                name_prod = "Bedside Table",
                type_prod = "Table",
                price_prod = 89.99,
                imgUrl_prod = "https://wakefitdev.gumlet.io/img/bedside-tables/New/WBDSTATONE/1.jpg?w=732",
                favorite_prod = 1,
                evaluate_prod = "4.2",
                reviews_prod = 50,
                description_prod = "A compact bedside table with storage space."
            ),
            ModelProduct(
                id_prod = 15,
                name_prod = "Console Table",
                type_prod = "Table",
                price_prod = 159.99,
                imgUrl_prod = "https://images.thdstatic.com/productImages/994ef633-b330-4591-8997-575b7ba34457/svn/white-console-tables-ct1676ff-64_600.jpg",
                favorite_prod = 1,
                evaluate_prod = "4.4",
                reviews_prod = 65,
                description_prod = "A modern console table for your entryway."
            ),
            // Armchair
            ModelProduct(
                id_prod = 16,
                name_prod = "Leather Recliner",
                type_prod = "Armchair",
                price_prod = 299.99,
                imgUrl_prod = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSq8Q1fMirx9-rpYn9VOXWGlqIsnvq3tkHGHw&s",
                favorite_prod = 0,
                evaluate_prod = "4.6",
                reviews_prod = 55,
                description_prod = "A comfortable leather recliner with adjustable settings."
            ),
            ModelProduct(
                id_prod = 17,
                name_prod = "Fabric Armchair",
                type_prod = "Armchair",
                price_prod = 199.99,
                imgUrl_prod = "https://cdn.shopify.com/s/files/1/0418/9080/7961/products/BrooksLightGreyFabricArmchairCarousel.jpg?v=1648289009&width=900",
                favorite_prod = 1,
                evaluate_prod = "4.5",
                reviews_prod = 70,
                description_prod = "A stylish fabric armchair with modern design."
            ),
            ModelProduct(
                id_prod = 18,
                name_prod = "Wingback Chair",
                type_prod = "Armchair",
                price_prod = 279.99,
                imgUrl_prod = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTGJu3pbf6s3lN9P6HryNJDaENWKrYgUxeDg&s",
                favorite_prod = 1,
                evaluate_prod = "4.7",
                reviews_prod = 80,
                description_prod = "A classic wingback chair with elegant design."
            ),
            ModelProduct(
                id_prod = 19,
                name_prod = "Rocking Chair",
                type_prod = "Armchair",
                price_prod = 249.99,
                imgUrl_prod = "https://images-cdn.ubuy.ae/633abe890d4bdc41321a6948-rocking-chair-nursery-glider-with.jpg",
                favorite_prod = 1,
                evaluate_prod = "4.6",
                reviews_prod = 65,
                description_prod = "A comfortable rocking chair perfect for relaxation."
            ),
            ModelProduct(
                id_prod = 20,
                name_prod = "Swivel Chair",
                type_prod = "Armchair",
                price_prod = 189.99,
                imgUrl_prod = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9F5-WoB0Lrc8dugxTAaAVsEEF6iB495-MDA&s",
                favorite_prod = 0,
                evaluate_prod = "4.4",
                reviews_prod = 75,
                description_prod = "A modern swivel chair with ergonomic design."
            ),
            // Chair
            ModelProduct(
                id_prod = 21,
                name_prod = "Ergonomic Office Chair",
                type_prod = "Chair",
                price_prod = 199.99,
                imgUrl_prod = "https://astride.furniture/cdn/shop/files/Chair_Info_1A_800x.jpg?v=1704082017",
                favorite_prod = 0,
                evaluate_prod = "4.8",
                reviews_prod = 90,
                description_prod = "A comfortable ergonomic office chair with lumbar support."
            ),
            ModelProduct(
                id_prod = 22,
                name_prod = "Wooden Dining Chair",
                type_prod = "Chair",
                price_prod = 129.99,
                imgUrl_prod = "https://ik.imagekit.io/durian1985/Durian/durian/product/800x800/product_2022100612171665058669_1477.jpg?tr=w-938,q-100,pr-true",
                favorite_prod = 1,
                evaluate_prod = "4.5",
                reviews_prod = 75,
                description_prod = "A classic wooden dining chair with cushioned seat."
            ),
            ModelProduct(
                id_prod = 23,
                name_prod = "Outdoor Patio Chair",
                type_prod = "Chair",
                price_prod = 89.99,
                imgUrl_prod = "https://assets.wfcdn.com/im/25161597/c_crop_resize_zoom-h450-w800%5Ecompr-r85/1512/151209211/default_name.jpg",
                favorite_prod = 0,
                evaluate_prod = "4.4",
                reviews_prod = 60,
                description_prod = "A durable outdoor patio chair made of weather-resistant materials."
            ),
            ModelProduct(
                id_prod = 24,
                name_prod = "Kids Chair",
                type_prod = "Chair",
                price_prod = 49.99,
                imgUrl_prod = "https://m.media-amazon.com/images/I/71I+rhS60zL._AC_SL1500_.jpg",
                favorite_prod = 1,
                evaluate_prod = "4.6",
                reviews_prod = 80,
                description_prod = "A colorful and sturdy chair designed for kids."
            ),
            ModelProduct(
                id_prod = 25,
                name_prod = "Gaming Chair",
                type_prod = "Chair",
                price_prod = 299.99,
                imgUrl_prod = "https://cdn.shopify.com/s/files/1/0073/0169/3551/files/playstation-legend-pedestal-2021029_1_abf77133-6820-4c4a-b19b-84fc0b491173.jpg?v=1697461959",
                favorite_prod = 1,
                evaluate_prod = "4.7",
                reviews_prod = 110,
                description_prod = "A high-quality gaming chair with adjustable features."
            )
        )
    }
}
