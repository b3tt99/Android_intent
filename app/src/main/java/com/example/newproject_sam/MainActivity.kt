package com.example.newproject_sam

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnsms:Button
    private lateinit var btnemail: Button
    private lateinit var btncamera: Button
    private lateinit var btnshare: Button
    private lateinit var btnmpesa: Button
    private lateinit var btncall:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsms = findViewById(R.id.BtnSMS)
        btnemail = findViewById(R.id.BtnEMAIL)
        btncamera = findViewById(R.id.BtnCAMERA)
        btnshare = findViewById(R.id.BtnSHARE)
        btnmpesa = findViewById(R.id.BtnMPESA)
        btncall = findViewById(R.id.BtnCALL)

        btnsms.setOnClickListener {

            val uri: Uri = Uri.parse("smsto:0112490096")
            val intent = Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("sms_body","Hey girlie. Have a beautiful day.")
            startActivity(intent)
        }

        btnemail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "b3tt992gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear sir/madam, I am applying for... ")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }

        btncamera.setOnClickListener {
            val takePictureintent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureintent,1)
        }

        btnmpesa.setOnClickListener {
            val simToolKitintent = applicationContext.packageManager.getLaunchIntentForPackage("co.android.stk")
            simToolKitintent?.let { startActivity(it) }
        }

        btncall.setOnClickListener {
            val callintent = Intent(Intent.ACTION_CALL, Uri.parse())
            if (ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    android.Manifest.permission.CALL_PHONE
            ))
        }

    }
}