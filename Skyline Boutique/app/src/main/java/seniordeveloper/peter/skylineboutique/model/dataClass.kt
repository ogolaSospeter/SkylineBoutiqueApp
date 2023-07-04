package seniordeveloper.peter.skylineboutique.model

import seniordeveloper.peter.skylineboutique.R


data class MenWear(val name: String, val price: Float, val description: String, val image: Int)

val menwear = listOf(
    MenWear("T-Shirt", 29.99f, "Comfortable cotton t-shirt", R.drawable.lp1),
    MenWear("Jeans", 49.69f, "Stylish denim jeans", R.drawable.st1),
    MenWear("Men Shirt", 79.23f, "Style the show.", R.drawable.st2),
    MenWear("Men Checked Shirt", 109.55f, "All events wear", R.drawable.st3),
    MenWear("Cool & Drip Shirt", 120.30f, "Fluffy Cotton Shirt", R.drawable.st4),
    MenWear("Executive wear", 134.57f, "Executive mens shirt", R.drawable.st5),
    MenWear("Golden Crowned", 126.65f, "Men Shirt", R.drawable.st6),
    MenWear("Chicago Wear", 157.67f, "Men Shirt", R.drawable.st7),

    MenWear("Sneakers", 223.90f, "Sporty sneakers", R.drawable.st5)


    )