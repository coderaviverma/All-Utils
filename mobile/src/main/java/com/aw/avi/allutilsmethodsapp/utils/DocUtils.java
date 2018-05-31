package com.aw.avi.allutilsmethodsapp.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;

import com.aw.avi.allutilsmethodsapp.applications.MyApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by avinash.verma on 1/16/2018.
 */

public class DocUtils {

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void printPDFDoc(final Context mContext, final String filePath) {
        final File exportDir = new File(filePath);

        PrintDocumentAdapter pda = new PrintDocumentAdapter() {

            @Override
            public void onWrite(PageRange[] pages, ParcelFileDescriptor destination,
                                CancellationSignal cancellationSignal, WriteResultCallback
                                        callback) {
                InputStream input = null;
                OutputStream output = null;

                try {
                    input = new FileInputStream(exportDir);
                    output = new FileOutputStream(destination.getFileDescriptor());

                    byte[] buf = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = input.read(buf)) > 0) {
                        output.write(buf, 0, bytesRead);
                    }

                    callback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});

                } catch (FileNotFoundException ee) {
                    //Catch exception
                } catch (Exception e) {
                    //Catch exception
                } finally {
                    try {
                        input.close();
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onLayout(PrintAttributes oldAttributes, PrintAttributes newAttributes,
                                 CancellationSignal cancellationSignal, LayoutResultCallback
                                         callback, Bundle extras) {

                if (cancellationSignal.isCanceled()) {
                    callback.onLayoutCancelled();
                    return;
                }


                PrintDocumentInfo pdi = new PrintDocumentInfo.Builder("Name of file")
                        .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT).build();

                callback.onLayoutFinished(pdi, true);
            }
        };

        PrintManager printManager = (PrintManager) mContext.getSystemService(Context.PRINT_SERVICE);
        String jobName = exportDir.getName();
        printManager.print(jobName, pda, null);

    }

    // Send Any File using Email
    public static void sendFileToMailIntent(Context context, final String filePath, String
            subject) {
        // For More Android Methods www.androidwarriors.com
        Uri path = Uri.fromFile(new File(filePath));
        //This is added to show only Email apps - part 1
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        // set the type to 'email'
        emailIntent.setType("vnd.android.cursor.dir/email");

        //This is added to show only Email apps - part 2
        String recepientEmail = ""; // either set to destination email or leave empty
        emailIntent.setData(Uri.parse("mailto:" + recepientEmail));

        // the attachment
        emailIntent.putExtra(Intent.EXTRA_STREAM, path);
        // the mail subject
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "" + subject);
        if (emailIntent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
//            context.startActivity(emailIntent);
            context.startActivity(Intent.createChooser(emailIntent, "Send email..."));

        } else {
            // if you reach this place, it means there is no any Email Applicaition Found
            Utilities.showToast(context, "No Email application found! Please download one");
        }
    }

    public static void writeStringAsFile(final String fileContents, String fileName) {
        Context context = MyApplication.getApplicationContexts();
        try {
            FileWriter out = new FileWriter(new File(context.getFilesDir(), fileName));
            out.write(fileContents);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileAsString(String filePath) {
        Context context = MyApplication.getApplicationContexts();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(new File(filePath)));


            while ((line = in.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (FileNotFoundException e) {
//            Logger.logError(TAG, e);
            e.printStackTrace();
        } catch (IOException e) {
//            Logger.logError(TAG, e);
            e.printStackTrace();

        }

        return stringBuilder.toString();
    }


    public static String getFileNameFromFullPath(String fullPath) {
        int index = fullPath.lastIndexOf("\\");
        return fullPath.substring(index + 1);
    }
}
