package com.github.ramonrabello.smartfood.shared.model

/**
 * Models of the app.
 */
abstract class Item(id:Int, name:String, image:String){
    lateinit var price:Price
    var quantity = 0
}
//data class Ingredient():Item(0, "", ""){}

//data class Snack(var ingredients:IntArray):Item(0, "", ""){
//    fun inLightPromo():Boolean = ingredients.contains()return
//}
//class ShoppingCart(){
//    var totalPrice:Int = 0
//    var totalQuantity:Int = 0
//    lateinit var snacks:Map<Int, Snack>
//    lateinit var extras:Map<Int, Ingredient>
//
//    fun add(item:Item, quantity:Int){
//        if (snacks.containsKey(item.id)){
//            snacks
//        }
//    }
//}