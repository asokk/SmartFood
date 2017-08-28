package com.github.ramonrabello.smartfood.snacks

import com.github.ramonrabello.smartfood.ingredients.Ingredient
import com.github.ramonrabello.smartfood.shared.repository.cache.Repository
import com.github.ramonrabello.smartfood.shared.repository.remote.Api
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by ramonrabello on 21/08/17.
 */
class SnacksRemoteRepository : Repository<SnackModel> {

    override fun add(item: SnackModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(items: Iterable<SnackModel>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(item: SnackModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(item: SnackModel) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun query(): Observable<List<SnackModel>> {
        val snackModelList = mutableListOf<SnackModel>()
        Api.get().snacks().enqueue(object : Callback<List<Snack>> {
            override fun onResponse(call: Call<List<Snack>>?, response: Response<List<Snack>>) {

                if (response.isSuccessful) {

                    val snackList: List<Snack>? = response.body()

                    for (snack in snackList!!) {

                        Api.get().ingredients().enqueue(object : Callback<List<Ingredient>> {
                            override fun onFailure(call: Call<List<Ingredient>>?, t: Throwable?) {

                            }

                            override fun onResponse(call: Call<List<Ingredient>>?, response: Response<List<Ingredient>>) {
                                if (response.isSuccessful) {
                                    val ingredientList = response.body()
                                    snackModelList.add(SnackModel(snack.id, snack.name, ingredientList, snack.image))
                                }
                            }
                        })
                    }
                }
            }

            override fun onFailure(call: Call<List<Snack>>?, t: Throwable?) {
                //view.notifyLoadingError()
            }
        })
        return Observable.fromArray(snackModelList)
    }

    override fun queryById(id: Int): Observable<SnackModel> = Api.get().snack(id)

    override fun close() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}