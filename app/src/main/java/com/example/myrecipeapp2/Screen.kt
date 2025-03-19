package com.example.myrecipeapp2

sealed class Screen(val route: String ) {
    object RecipeScreen: Screen("recipe_screen")
    object DetailScreen: Screen("detail_screen")
}