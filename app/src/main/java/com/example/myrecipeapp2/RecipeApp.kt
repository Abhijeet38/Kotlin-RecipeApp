package com.example.myrecipeapp2

import android.R.attr.category
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myrecipeapp2.Screen.DetailScreen

@Composable
fun RecipeApp(navController: NavHostController){
    val recipeViewModel : MainViewModel = viewModel()
    val viewState by recipeViewModel.categoriesState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route){
        composable(route = Screen.RecipeScreen.route){
            RecipeScreen(viewState = viewState, navigateToDetail = { it ->
                navController.currentBackStackEntry?.savedStateHandle?.set("category", it)
                navController.navigate(DetailScreen.route)
            })
        }
        composable(route = DetailScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.
                get<Category>("category") ?: Category("", "", "", "")
            CategoryDetailScreen(category = category)
        }
    }
}