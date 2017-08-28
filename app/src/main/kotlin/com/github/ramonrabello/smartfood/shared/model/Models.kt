package com.github.ramonrabello.smartfood.shared.model

/**
 * Models of the app.
 */
abstract class Item(var id:Int, var name:String, var image:String){
    lateinit var price:Price
    var quantity = 0
}
//data class IngredientJsonModel():Item(0, "", ""){}

//data class SnackJsonModel(var ingredients:IntArray):Item(0, "", ""){
//    fun inLightPromo():Boolean = ingredients.contains()return
//}
//class ShoppingCart(){
//    var totalPrice:Int = 0
//    var totalQuantity:Int = 0
//    lateinit var snacks:Map<Int, SnackJsonModel>
//    lateinit var extras:Map<Int, IngredientJsonModel>
//
//    fun add(item:Item, quantity:Int){
//        if (snacks.containsKey(item.id)){
//            snacks
//        }
//    }
//}