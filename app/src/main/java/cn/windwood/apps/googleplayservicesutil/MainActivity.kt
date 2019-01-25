package cn.windwood.apps.googleplayservicesutil

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val LOG_TAG = "GooglePlayServicesUtil"

    private val GOOGLE_PLAY_SERVICES_PACKAGE = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_PACKAGE
    private val GOOGLE_PLAY_STORE_PACKAGE = GoogleApiAvailability.GOOGLE_PLAY_STORE_PACKAGE
    private val GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE
    private val GOOGLE_SERVICES_FRAMEWORK_PACKAGE = "com.google.android.gsf"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        detectGoogleServices()
    }

    private fun detectGoogleServices() {
        Log.i(
            LOG_TAG,
            "GOOGLE_PLAY_SERVICES_VERSION_CODE = $GOOGLE_PLAY_SERVICES_VERSION_CODE"
        )

        val apiAvailability = GoogleApiAvailability.getInstance()

        val errorCode = apiAvailability.isGooglePlayServicesAvailable(this)
        val errorString = apiAvailability.getErrorString(errorCode)

        if (errorCode != ConnectionResult.SUCCESS) {
            Log.w(LOG_TAG, errorCode.toString());
            Log.w(LOG_TAG, errorString);
        }

        tvOutput.text = errorString
    }

    fun servicesInfo(view: View) {
        val constantValue =
            ("Services Package: $GOOGLE_PLAY_SERVICES_PACKAGE\nVersion code: $GOOGLE_PLAY_SERVICES_VERSION_CODE")

        tvOutput!!.text = constantValue
    }

    fun storeInfo(view: View) {
        val constantValue = ("Store Package: $GOOGLE_PLAY_STORE_PACKAGE")

        tvOutput!!.text = constantValue
    }

    fun aboutInfo(view: View) {
        val constantValue = ("")

        tvOutput!!.text = constantValue
    }
}
