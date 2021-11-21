package com.example.samqueen.obd

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    var m_bluetoothadapter: BluetoothAdapter? = null;
    lateinit var m_pairedDevices: Set<BluetoothDevice>;
    val REQUEST_ENABLE_BLUETOOTH = 1;

    companion object {
        val EXTRA_ADDRESS: String = "Device_address"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        m_bluetoothadapter = BluetoothAdapter.getDefaultAdapter();

        if(m_bluetoothadapter == null) {
            toast("This device does not support bluetooth");
            return
        }

        if(!m_bluetoothadapter!!.isEnabled) {
            val enableBluethoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBluethoothIntent, REQUEST_ENABLE_BLUETOOTH);
        }
    }

    private fun pairedDeviceList() {

    }


}