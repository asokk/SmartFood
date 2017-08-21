package com.github.ramonrabello.smartfood.snacks

import android.util.Log
import com.github.ramonrabello.smartfood.promo.Snack
import com.github.ramonrabello.smartfood.shared.repository.Specification
import com.github.ramonrabello.smartfood.shared.repository.cache.Repository
import com.google.firebase.database.*
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.FlowableOnSubscribe
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by ramonrabello on 21/08/17.
 */
class SnacksLocalRepository : Repository<SnackWrapper> {

    // Write a message to the database
    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("smartfood-ac86f")
    lateinit var disposable:Disposable

    override fun add(item: SnackWrapper) {
        myRef.setValue(item.snacks)
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(items: Iterable<SnackWrapper>) {
        for (item in items){
            myRef.setValue(item.snacks)
        }
    }

    override fun update(item: SnackWrapper) {

    }

    override fun remove(item: SnackWrapper) {

    }

    override fun query(): Observable<SnackWrapper> = //        // Read from the database
//        val snacks:MutableList<SnackWrapper> = ArrayList()
//        myRef.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                //List messages = snapshot.getValue(t);
//                if( messages === null ) {
//                    System.out.println('No messages');
//                }
//                else {
//                    System.out.println("The first message is: " + messages.get(0) );
//                }
//                snacks.add(snackWrapper)
//                Log.d("TAG","Value is: ${value}")
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Failed to read value
//                Log.w("TAG", "Failed to read value.", error.toException())
//            }
//        })
//
//        disposable = Observable.just(snacks)
//                .subscribeOn(Schedulers.computation()).subscribe()
//        )
            Observable.empty()

    override fun close() {
        disposable.dispose()
    }
}