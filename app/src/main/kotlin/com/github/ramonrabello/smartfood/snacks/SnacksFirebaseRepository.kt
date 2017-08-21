package com.github.ramonrabello.smartfood.snacks

import android.util.Log
import com.github.ramonrabello.smartfood.promo.Snack
import com.github.ramonrabello.smartfood.shared.repository.Specification
import com.github.ramonrabello.smartfood.shared.repository.cache.Repository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener

/**
 * Created by ramonrabello on 21/08/17.
 */
class SnacksFirebaseRepository : Repository<Snack> {

    // Write a message to the database
    var database = FirebaseDatabase.getInstance()
    var myRef = database.getReference("smartfood-ac86f")

    override fun add(item: Snack) {
        myRef.setValue(item)
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun add(items: Iterable<Snack>) {
        for (item in items){
            myRef.setValue(item)
        }
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(item: Snack) {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(item: Snack) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun query(specification: Specification): MutableList<Snack> {
        // Read from the database
        val snacks:MutableList<Snack> = ArrayList<Snack>()
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(Snack::class.java)
                snacks.add(value)
                Log.d("TAG","Value is: " + value)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException())
            }
        })
        return snacks
    }
}