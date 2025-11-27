package com.yuhdeveloper.firebaseeventssample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.firebase.Firebase
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.analytics
import com.yuhdeveloper.firebaseeventssample.ui.theme.FirebaseEventsSampleTheme

class MainActivity : ComponentActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAnalytics = Firebase.analytics

        setContent {
            FirebaseEventsSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        getEvents(firebaseAnalytics).forEachIndexed { index, event ->
                            Button(
                                onClick = event.onClick
                            ) {
                                Text(event.eventName)
                            }
                        }
                    }
                }
            }
        }
    }
}

data class MyEvents(
    val eventName: String,
    val onClick: () -> Unit
)

fun getEvents(firebaseAnalytics: FirebaseAnalytics) = listOf(
    MyEvents("Event With Custom Parameter") {
        val bundle = Bundle().apply {
            putString("urun_id", "1")
            putString("urun_adi", "çay")
        }
        firebaseAnalytics.logEvent("Event_With_Custom_Parameter",bundle)
    },
    MyEvents("Event With Firebase Parameter") {
        val bundle = Bundle().apply {
            putString(FirebaseAnalytics.Param.ITEM_ID, "1")
            putString(FirebaseAnalytics.Param.ITEM_NAME, "Çay")
        }
        firebaseAnalytics.logEvent("Event_With_Firebase_Parameter",bundle)
    },
    MyEvents("Event Parameter Limit 25") {
        val bundle = Bundle().apply {
            putString(FirebaseAnalytics.Param.ACHIEVEMENT_ID, "achv_001")
            putString(FirebaseAnalytics.Param.AD_FORMAT, "banner")
            putString(FirebaseAnalytics.Param.AD_PLATFORM, "admob")
            putString(FirebaseAnalytics.Param.AD_SOURCE, "google_ads")
            putString(FirebaseAnalytics.Param.AD_UNIT_NAME, "main_banner_top")
            putString(FirebaseAnalytics.Param.CHARACTER, "Asami")
            putString(FirebaseAnalytics.Param.TRAVEL_CLASS, "economy")
            putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
            putString(FirebaseAnalytics.Param.CURRENCY, "TRY")
            putString(FirebaseAnalytics.Param.COUPON, "NEWUSER10")
            putString(FirebaseAnalytics.Param.START_DATE, "2025-10-21")
            putString(FirebaseAnalytics.Param.END_DATE, "2025-10-25")
            putString(FirebaseAnalytics.Param.EXTEND_SESSION, "true")
            putString(FirebaseAnalytics.Param.FLIGHT_NUMBER, "TK1234")
            putString(FirebaseAnalytics.Param.GROUP_ID, "group_01")
            putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "beverage")
            putString(FirebaseAnalytics.Param.ITEM_ID, "item_001")
            putString(FirebaseAnalytics.Param.ITEM_NAME, "Çay")
            putString(FirebaseAnalytics.Param.LOCATION, "Istanbul")
            putLong(FirebaseAnalytics.Param.LEVEL, 5L)
            putString(FirebaseAnalytics.Param.LEVEL_NAME, "Bronze")
            putString(FirebaseAnalytics.Param.METHOD, "email")
            putLong(FirebaseAnalytics.Param.NUMBER_OF_NIGHTS, 3L)
            putLong(FirebaseAnalytics.Param.NUMBER_OF_PASSENGERS, 2L)
            putLong(FirebaseAnalytics.Param.NUMBER_OF_ROOMS, 1L)
        }
        firebaseAnalytics.logEvent("Event_Parameter_Limit_25",bundle)
    },
    MyEvents("Event Parameter Limit Other Parameter") {
        val bundle = Bundle().apply {
            putString(FirebaseAnalytics.Param.DESTINATION, "Ankara")
            putString(FirebaseAnalytics.Param.ORIGIN, "Istanbul")
            putDouble(FirebaseAnalytics.Param.PRICE, 29.99)
            putLong(FirebaseAnalytics.Param.QUANTITY, 1L)
            putLong(FirebaseAnalytics.Param.SCORE, 950L)
            putDouble(FirebaseAnalytics.Param.SHIPPING, 5.50)
            putString(FirebaseAnalytics.Param.TRANSACTION_ID, "txn_123456")
            putString(FirebaseAnalytics.Param.SEARCH_TERM, "yeşil çay")
            putString(FirebaseAnalytics.Param.SUCCESS, "true")
            putDouble(FirebaseAnalytics.Param.TAX, 3.25)
            putDouble(FirebaseAnalytics.Param.VALUE, 34.49)
            putString(FirebaseAnalytics.Param.VIRTUAL_CURRENCY_NAME, "gold")
            putString(FirebaseAnalytics.Param.CAMPAIGN, "black_friday")
            putString(FirebaseAnalytics.Param.SOURCE, "instagram")
            putString(FirebaseAnalytics.Param.MEDIUM, "social")
            putString(FirebaseAnalytics.Param.TERM, "çay kampanyası")
            putString(FirebaseAnalytics.Param.CONTENT, "banner_1")
            putString(FirebaseAnalytics.Param.ACLID, "aclid_5678")
            putString(FirebaseAnalytics.Param.CP1, "cp1_value")
            putString(FirebaseAnalytics.Param.CAMPAIGN_ID, "cmp_001")
            putString(FirebaseAnalytics.Param.SOURCE_PLATFORM, "android")
            putString(FirebaseAnalytics.Param.CREATIVE_FORMAT, "video")
            putString(FirebaseAnalytics.Param.MARKETING_TACTIC, "retargeting")
        }
        firebaseAnalytics.logEvent("Event_Parameter_Limit_Other_Parameter", bundle)
    },
    MyEvents("Event For Basket Items") {
        val bundleArray: ArrayList<Bundle> = arrayListOf(
            Bundle().apply {
                putString(FirebaseAnalytics.Param.ITEM_NAME, "jeggings")
                putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "pants")
                putString(FirebaseAnalytics.Param.PRICE, "25")
                putString(FirebaseAnalytics.Param.COUPON, "NEWUSER10")
                putString(FirebaseAnalytics.Param.ITEM_ID, "item_001")
                putLong(FirebaseAnalytics.Param.QUANTITY, 1L)
            },
            Bundle().apply {
                putString(FirebaseAnalytics.Param.ITEM_NAME, "jegging2s")
                putString(FirebaseAnalytics.Param.ITEM_CATEGORY, "pants")
                putString(FirebaseAnalytics.Param.PRICE, "25")
                putString(FirebaseAnalytics.Param.COUPON, "NEWUSER10")
                putString(FirebaseAnalytics.Param.ITEM_ID, "item_001")
                putLong(FirebaseAnalytics.Param.QUANTITY, 1L)
            }
        )

        val bundle = Bundle().apply {
            putParcelableArrayList(FirebaseAnalytics.Param.ITEMS, bundleArray)
            putString(FirebaseAnalytics.Param.CURRENCY, "TRY")
        }

        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM_LIST, bundle)
    }
)