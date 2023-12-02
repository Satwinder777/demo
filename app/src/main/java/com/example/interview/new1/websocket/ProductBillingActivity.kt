package com.example.interview.new1.websocket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClient.BillingResponseCode
import com.android.billingclient.api.BillingClient.SkuType
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.SkuDetails
//import com.android.billingclient.api.QueryProductDetailsParams
import com.android.billingclient.api.SkuDetailsParams
import com.example.interview.R
import com.example.interview.databinding.ActivityProductBillingBinding
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList

class ProductBillingActivity : AppCompatActivity() ,PurchasesUpdatedListener{
    lateinit var binding :ActivityProductBillingBinding
    lateinit var billingClient: BillingClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityProductBillingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var purchasesUpdatedListener = PurchasesUpdatedListener{
            bilingResult,purchases->


        }

        billingClient = BillingClient.newBuilder(this)
            .setListener(this)
            .enablePendingPurchases()
            .build()



//        var queryProductDetailsParams = QueryProductDetailsParams.newBuilder()
//            .setProductList(
//                ImmutableList.of(
//                    QueryProductDetailsParams.Product.newBuilder()
//                        .setProductId("product_id_example")
//                        .setProductType(BillingClient.ProductType.INAPP)
//                        .build())
//            ).build()

//        billingClient.queryProductDetailsAsync(queryProductDetailsParams){
//                billingResult,
//                productDetailsList ->
//        }
        var skuList = ArrayList<String>()
        skuList.add("android.test.purchased")
        binding.button1.setOnClickListener {

            billingClient.startConnection(object:BillingClientStateListener{
                override fun onBillingServiceDisconnected() {

                }

                override fun onBillingSetupFinished(bR: BillingResult) {
                    queryAvailableProducts()
//                    if (bR.responseCode== BillingClient.BillingResponseCode.OK){
//
////                        var params = SkuDetailsParams.newBuilder()
////                        params.setSkusList(skuList)
////                            .setType(BillingClient.SkuType.INAPP)
////                        billingClient.querySkuDetailsAsync(params.build()) {
////                                billingResult, skuDetailsList ->
////
////
////                            for (skuDetails in skuDetailsList!!) {
////                                val flowPurchase = BillingFlowParams.newBuilder()
////                                    .setSkuDetails(skuDetails)
////                                    .build()
////                                val responceCode = billingClient
////                                    .launchBillingFlow(this@ProductBillingActivity,flowPurchase)
////                                    .responseCode
////                                Log.e("test121", "onBillingSetupFinished: $responceCode", )
////                            }
////                        }
//                        val queryProductDetailsParams =
//                            QueryProductDetailsParams.newBuilder()
//                                .setProductList(
//                                    ImmutableList.of(
//                                        QueryProductDetailsParams.Product.newBuilder()
//                                            .setProductId("product_id_example")
//                                            .setProductType(BillingClient.ProductType.INAPP)
//                                            .build()))
//                                .build()
//                    }else{
//                        Toast.makeText(this@ProductBillingActivity, "${bR.responseCode}", Toast.LENGTH_SHORT).show()
//                    }
                }

            })

        }
        connectToBillingService()
    }

    private fun connectToBillingService() {

    }

    override fun onPurchasesUpdated(billingResult: BillingResult, purchases: MutableList<Purchase>?) {
        if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && purchases != null) {
            for (purchase in purchases) {
                // Handle the successful purchase
                Toast.makeText(this, "$purchase", Toast.LENGTH_SHORT).show()
            }
        } else if (billingResult.responseCode == BillingClient.BillingResponseCode.USER_CANCELED) {
            // Handle the user-cancelled purchase
            Toast.makeText(this, "cancelled!!", Toast.LENGTH_SHORT).show()

        }
    }
    private fun queryAvailableProducts() {
        val skuList = listOf("android.test.purchased")
        val params = SkuDetailsParams.newBuilder()
        params.setSkusList(skuList).setType(BillingClient.SkuType.INAPP)

        billingClient.querySkuDetailsAsync(params.build()) { billingResult, skuDetailsList ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && skuDetailsList != null) {
                for (skuDetails in skuDetailsList) {
                    // Display the available products
                    purchaseProduct(skuDetails)
                }
            }
        }
    }
    private fun purchaseProduct(skuDetails: SkuDetails) {
        val billingFlowParams = BillingFlowParams.newBuilder()
            .setSkuDetails(skuDetails)
            .build()
        billingClient.launchBillingFlow(this, billingFlowParams)
    }
}