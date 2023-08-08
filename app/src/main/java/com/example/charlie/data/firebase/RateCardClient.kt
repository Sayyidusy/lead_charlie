package com.example.charlie.data.firebase

import com.example.charlie.data.firebase.Constant.COLLECTION_RATE_CARD
import com.example.charlie.data.firebase.Constant.COLLECTION_REQUEST
import com.example.charlie.data.model.RequestRateCard
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RateCardClient {
    private val db = Firebase.firestore


    fun getAllRateCard()= db.collection(COLLECTION_RATE_CARD).get()
    fun getRateCard(id: String) = db.collection(COLLECTION_RATE_CARD).document(id).get()
    fun getAllRequest() = db.collection(COLLECTION_REQUEST)
    fun getRequest(id: String) = db.collection(COLLECTION_REQUEST).document(id).get()
    fun addRequest(request: RequestRateCard) = db.collection(COLLECTION_REQUEST).add(request)
    fun updateRequestStatus(id: String,value: String) = db.collection(COLLECTION_REQUEST).document(id).update("status", value)
}