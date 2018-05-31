package com.aw.avi.allutilsmethodsapp.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Environment;
import android.provider.ContactsContract;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.Context.CLIPBOARD_SERVICE;
import static android.content.Context.DOWNLOAD_SERVICE;

/**
 * Created by Avinash on 12/5/2017.
 */

public class Utilities {
    public static final String LOG = Utilities.class.getName();

    /**
     * Checks and returns whether the device is connected to internet or not
     *
     * @param context Application's context
     * @return Whether internet is connected or not
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService
                (Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, "" + msg, Toast.LENGTH_SHORT).show();
    }

    public static void showToastLengthLong(Context context, String msg) {
        Toast.makeText(context, "" + msg, Toast.LENGTH_LONG).show();
    }

    public static void showAlertDialogDefault(Context context, String msg) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg)
                .setCancelable(true)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
// startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    public static boolean isValidEmail(CharSequence text) {
        if (text == null) {

            return false;
        } else {

            return Patterns.EMAIL_ADDRESS.matcher(text).matches();
        }
    }

    public static void hideKeyboard(Activity activity) {
        try {
            InputMethodManager manager = (InputMethodManager) activity.getSystemService(Context
                    .INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(activity.getCurrentFocus()
                            .getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {

        }

    }

    public static void getListViewSize(ListView myListView) {
        ListAdapter myListAdapter = myListView.getAdapter();
        if (myListAdapter == null) {
// do nothing return null
            return;
        }
// set listAdapter in loop for getting final size
        int totalHeight = 0;
        for (int size = 0; size < myListAdapter.getCount(); size++) {
            View listItem = myListAdapter.getView(size, null, myListView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
// setting listview item in adapter
        ViewGroup.LayoutParams params = myListView.getLayoutParams();
        params.height = totalHeight
                + (myListView.getDividerHeight() * (myListAdapter.getCount() - 1));
        myListView.setLayoutParams(params);

    }

    public static boolean isValidMobile(String phone) {
        String regex = "[0-9]+";
        StringBuilder bul = new StringBuilder(phone);

        if (phone.contains("(")) {
            bul.deleteCharAt(0);
        }
        if (phone.contains(")")) {
            bul.deleteCharAt(4);
        }
        if (phone.contains(" ")) {
            if (String.valueOf(bul.charAt(0)).equalsIgnoreCase("1")) {
                bul.deleteCharAt(1);
            } else {
                bul.deleteCharAt(3);
            }

        }
        Log.i(LOG, "phone:" + bul);
        if (bul.substring(0, 3).equalsIgnoreCase("000")) {
            return false;
        }
        return bul.toString().matches(regex);
        //return android.util.Patterns.PHONE.matcher(phone).matches();
    }

    public static boolean isLastActivityInTheStack(Context context, String className) {
        ActivityManager mngr = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        List<ActivityManager.RunningTaskInfo> taskList = mngr.getRunningTasks(10);

        if (taskList.get(0).numActivities == 1 &&
                taskList.get(0).topActivity.getClassName().equals(className))

        {
            Log.i(Utilities.LOG, "This is last activity in the stack");
            return true;
        } else {

        }
        for (ActivityManager.RunningTaskInfo info : taskList) {
            Log.i(Utilities.LOG, "T  info.getClass().getName():" + info.getClass().getName());

        }
        return false;
    }

    public static int convertPixelsToDp(float px, Context mContext) {
        Resources resources = mContext.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int dp = (int) (px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }

    public static float convertDPtoPixel(int dpValue, Context mContext) {

        Resources r = mContext.getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, r
                .getDisplayMetrics
                        ());
        return px;
    }

    public static String formattedDate(String inputString) {
        String reformattedStr = "";
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat myFormat = new SimpleDateFormat("MMM-dd-yyyy");
        try {
            reformattedStr = myFormat.format(fromUser.parse(inputString));
        } catch (ParseException e) {
            reformattedStr = "";
            e.printStackTrace();
        }
        return reformattedStr;
    }

    public static String findCurrentDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMM-dd-yyyy");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

    public static void disableEditText(EditText[] editText) {
        for (int i = 0; i < editText.length; i++) {
            editText[i].setFocusable(false);
            editText[i].setFocusableInTouchMode(false);
            editText[i].setClickable(false);
        }
    }

    public static void enableEditText(EditText[] editText) {
        for (int i = 0; i < editText.length; i++) {
            editText[i].setFocusable(true);
            editText[i].setFocusableInTouchMode(true);
            editText[i].setClickable(true);
        }
    }

    public static Uri urlToURIConverter(String url) {
//        Uri uri = Uri.parse("http://www.facebook.com");
        Uri uri = Uri.parse(url);
        return uri;
    }

    public static void downloadEnqueue(Context mContext, String url) {

        DownloadManager.Request r = new DownloadManager.Request(Utilities.urlToURIConverter(url));

// This put the download in the same Download dir the browser uses
        r.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, Utilities
                .getFilename(url));

// When downloading music and videos they will be listed in the player
// (Seems to be available since Honeycomb only)
        r.allowScanningByMediaScanner();

// Notify user when download is completed
// (Seems to be available since Honeycomb only)
        r.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

// Start download
        DownloadManager dm = (DownloadManager) mContext.getSystemService
                (DOWNLOAD_SERVICE);
        dm.enqueue(r);

    }

    //Name Utility
    public static String getFilename(String url) {

        String[] separated = url.split("/");
        String filename = null;
        for (int i = 0; i < separated.length; i++) {
            if (i == separated.length - 1) {
                filename = separated[i];
            }
        }
        return filename;
    }

    public static void getStringArrayFromXML(Context mContext) {

//                String[] imagemimetypes = mContext.getResources().getStringArray(R.array.image_extensions);
//        Arrays.asList(transcribeauthlist).contains(userEmail)
    }

    public static void clickableTextView(Context mContext, TextView myTextView) {

//        TextView myTextView = (TextView) findViewById(R.id.myText);
        ClickableSpan termsOfServicesClick = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Terms of services Clicked", Toast.LENGTH_SHORT).show();
            }
        };

        ClickableSpan privacyPolicyClick = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Privacy Policy Clicked", Toast.LENGTH_SHORT).show();
            }
        };

        makeLinks(myTextView, new String[]{"Term of services", "Privacy Policy"}, new ClickableSpan[]{
                termsOfServicesClick, privacyPolicyClick
        });

    }

    private static void makeLinks(TextView textView, String[] links, ClickableSpan[] clickableSpans) {
        SpannableString spannableString = new SpannableString(textView.getText());
        for (int i = 0; i < links.length; i++) {
            ClickableSpan clickableSpan = clickableSpans[i];
            String link = links[i];

            int startIndexOfLink = textView.getText().toString().indexOf(link);
            spannableString.setSpan(clickableSpan, startIndexOfLink, startIndexOfLink + link.length(),
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

//    public static Bitmap drawableToBitmap(){
////        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
////                R.drawable.icon_resource);
//    }

    public static void sendEmail(Context mContext, String email) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

        mContext.startActivity(Intent.createChooser(intent, "Send Email"));
    }

    public static File convertBitmaptoFile(Context context, String filename, Bitmap bitmapImage) {
        String filenameNew = UUID.randomUUID().toString();
        //create a file to write bitmap data
        File imageFile;
        imageFile = new File(context.getCacheDir(), filenameNew + ".png");
        try {
            imageFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
//Convert bitmap to byte array
        Bitmap bitmap = bitmapImage;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(imageFile);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageFile;
    }

    public static Integer getFileSize(File file) {
        return Integer.parseInt(String.valueOf(file.length() / 1024));
    }

    public static String getContactName(Context context, String phoneNumber) {

        ContentResolver cr = context.getContentResolver();
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri
                .encode(phoneNumber));
        Cursor cursor = cr.query(uri, new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME},
                null, null, null);
        if (cursor == null) {
            return null;
        }
        String contactName = "";//null
        if (cursor.moveToFirst()) {
            do {

                contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup
                        .DISPLAY_NAME));
                String regex = "[a-zA-Z]+";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(contactName);
                if (m.matches()) {
                    return contactName;
                }
            } while (cursor.moveToNext());

        }

        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return contactName;
    }

    public static String getContactPic(Context context, String phoneNumber) {

        ContentResolver cr = context.getContentResolver();
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri
                .encode(phoneNumber));
        Cursor cursor = cr.query(uri, new String[]{ContactsContract.PhoneLookup.PHOTO_URI},
                null, null, null);
        if (cursor == null) {
            return null;
        }
        String contactName = "";//null
        if (cursor.moveToFirst()) {
            do {

                contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup
                        .PHOTO_URI));

                if (contactName != null && contactName.length() > 5) {
                    return contactName;
                }
            } while (cursor.moveToNext());

        }

        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return contactName;
    }

    public static void copyToClipboard(Context mContext, String email) {
        try {
            ClipboardManager myClipboard = (ClipboardManager) mContext.getSystemService(CLIPBOARD_SERVICE);
            ClipData clipData = ClipData.newPlainText("text", email);
            myClipboard.setPrimaryClip(clipData);
        } catch (Exception e) {
            Utilities.showToast(mContext, "Unable to copy!");
        }

        Utilities.showToast(mContext, "Email copy to Clipboard");

    }

    private void playAlarm(boolean playAlarm, Context mContext) {
        //this will sound the alarm tone
        //this will sound the alarm once, if you wish to
        //raise alarm in loop continuously then use MediaPlayer and setLooping(true)
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(mContext, alarmUri);

        if (playAlarm) {

            ringtone.play();
        } else {

            ringtone.stop();
        }
    }

    private void setCountDownTimer() {
        new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
//                mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            @Override
            public void onFinish() {
//                mTextField.setText("done!");
            }

        }.start();
    }

}
