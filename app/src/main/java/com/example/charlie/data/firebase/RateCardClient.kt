package com.example.charlie.data.firebase

import com.example.charlie.data.firebase.Constant.COLLECTION_RATE_CARD
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RateCardClient {
    private val db = Firebase.firestore


    fun getAllRateCard()= db.collection(COLLECTION_RATE_CARD).get()
    fun getRateCard(id: String) = db.collection(COLLECTION_RATE_CARD).document(id).get()
}