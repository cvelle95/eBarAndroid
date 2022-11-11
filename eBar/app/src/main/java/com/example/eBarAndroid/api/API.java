package com.example.eBarAndroid.api;

import android.os.AsyncTask;
import android.os.Build;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;

public class API {
    public static void getJSON(String url,final ReadDataHandler rdh) {
        if (Build.VERSION.SDK_INT < 30) {
            AsyncTask<String, Void, String> task = new AsyncTask<String, Void, String>() {

                @Override
                protected String doInBackground(String... strings) {
                    String response = "";

                    try {
                        URL link = new URL(strings[0]);
                        HttpURLConnection con = (HttpURLConnection) link.openConnection();
                        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        String line;
                        while ((line = br.readLine()) != null) {
                            response += line + "\n";
                        }
                        br.close();
                        con.disconnect();

                    } catch (Exception e) {
                        response = "[]";
                        e.printStackTrace();
                    }

                    return response;
                }

                @Override
                protected void onPostExecute(String response) {
                    rdh.setJson(response);
                    rdh.sendEmptyMessage(0);
                }
            };

            task.execute(url);
        }
    }

    public static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
