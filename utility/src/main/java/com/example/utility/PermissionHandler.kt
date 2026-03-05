package com.example.utility



import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager

object PermissionHandler {


    // Request codes
    const val CAMERA_PERMISSION_CODE = 100
    const val GALLERY_PERMISSION_CODE = 101
    const val VIDEO_PERMISSION_CODE = 102
    const val PDF_PERMISSION_CODE = 103
    const val LOCATION_PERMISSION_CODE = 104
    const val NOTIFICATION_PERMISSION_CODE = 105

    // ------------------------
// CAMERA PERMISSION
// ------------------------
    fun requestCameraPermission(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(Manifest.permission.CAMERA),
            CAMERA_PERMISSION_CODE
        )
    }

    fun isCameraPermissionGranted(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    // ------------------------
// GALLERY / IMAGE PERMISSION
// ------------------------
    fun requestGalleryPermission(activity: Activity) {
        val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_IMAGES
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }

        ActivityCompat.requestPermissions(
            activity,
            arrayOf(permission),
            GALLERY_PERMISSION_CODE
        )
    }

    fun isGalleryPermissionGranted(context: Context): Boolean {
        val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_IMAGES
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }

        return ContextCompat.checkSelfPermission(
            context,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    // ------------------------
// VIDEO PERMISSION
// ------------------------
    fun requestVideoPermission(activity: Activity) {
        val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_VIDEO
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }

        ActivityCompat.requestPermissions(
            activity,
            arrayOf(permission),
            VIDEO_PERMISSION_CODE
        )
    }

    fun isVideoPermissionGranted(context: Context): Boolean {
        val permission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Manifest.permission.READ_MEDIA_VIDEO
        } else {
            Manifest.permission.READ_EXTERNAL_STORAGE
        }

        return ContextCompat.checkSelfPermission(
            context,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }

    // ------------------------


    // ------------------------
// LOCATION PERMISSION
// ------------------------
    fun requestLocationPermission(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            LOCATION_PERMISSION_CODE
        )
    }

    fun isLocationPermissionGranted(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    // ------------------------
// NOTIFICATION PERMISSION (Android 13+)
// ------------------------
    fun requestNotificationPermission(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                NOTIFICATION_PERMISSION_CODE
            )
        }
    }

    fun isNotificationPermissionGranted(context: Context): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        } else true
    }

    // ------------------------
// OPEN APP SETTINGS (for permanently denied permissions)
// ------------------------
    fun openAppSettings(activity: Activity) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.data = Uri.fromParts("package", activity.packageName, null)
        activity.startActivity(intent)
    }
}

//Usage Code

//override fun onRequestPermissionsResult(
//    requestCode: Int,
//    permissions: Array<String>,
//    grantResults: IntArray
//) {
//    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//
//    when(requestCode) {
//
//        PermissionHandler.GALLERY_PERMISSION_CODE -> {
//            // gallery granted
//        }
//
//        PermissionHandler.LOCATION_PERMISSION_CODE -> {
//            // location granted
//        }
//
//        PermissionHandler.NOTIFICATION_PERMISSION_CODE -> {
//            // notification granted
//        }
//    }
//}


//PermissionHandler.request(
//    this,
//    arrayOf(android.Manifest.permission.CAMERA),
//    100
//)


















