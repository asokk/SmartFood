package com.github.ramonrabello.smartfood.shared.repository.remote

import com.github.ramonrabello.smartfood.promo.Promotion
import com.github.ramonrabello.smartfood.promo.Snack
import com.github.ramonrabello.smartfood.shoppingcart.ExtraResponse
import com.github.ramonrabello.smartfood.snacks.Ingredient
import com.github.ramonrabello.smartfood.snacks.SnackWrapper
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

/**
 * Created by ramonrabello on 20/08/17.
 */
interface SmartFoodEndpoint {

    @GET("/api/promocao")
    fun promotions():Observable<List<Promotion>>

    @GET("/api/lanche")
    fun snacks(): Observable<List<Snack>>

    @GET("/api/lanche/{snack_id}")
    fun snack(snackId:Int):Flowable<Snack>

    @GET("/api/ingrediente")
    fun ingredients():Observable<List<Ingredient>>

    @GET("/api/ingrediente/de/{snack_id}")
    fun ingredientsOf(@Path("snack_id") snackId:Int):Flowable<List<Ingredient>>

    @GET("/api/pedido")
    fun currentOrder():Observable<List<ExtraResponse>>

    @PUT("/api/pedido/{snack_id}")
    fun addExtrasToOrder(@Path("snack_id") snackId:Int, @Body extras:IntArray):Observable<List<ExtraResponse>>

    @PUT("/api/pedido/{snack_id}")
    fun addItem(@Path("snack_id") snackId:Int):Observable<List<ExtraResponse>>
}