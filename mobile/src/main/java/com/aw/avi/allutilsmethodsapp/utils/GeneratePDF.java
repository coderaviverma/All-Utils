package com.aw.avi.allutilsmethodsapp.utils;

import android.os.AsyncTask;
import android.os.Environment;

import com.aw.avi.allutilsmethodsapp.models.MyItem;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinash.verma on 1/16/2018.
 */

public class GeneratePDF extends AsyncTask<Object, String, String> {
    private List<String> headersList = new ArrayList<>();

    public void insertCell(PdfPTable table, String text, int align, int colspan, Font font) {

        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
        //set the cell alignment
        cell.setHorizontalAlignment(align);
        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);
        //in case there is no text and you wan to create an empty row
        if (text.trim().equalsIgnoreCase("")) {
            cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);

    }

    @Override
    protected String doInBackground(Object... objects) {
        addHeaderDataToList();

        List<MyItem> myItems = (List<MyItem>) objects[0];

        File exportDir = new File(Environment.getExternalStorageDirectory(), "My Conversion Folder");
        if (!exportDir.exists()) {
            exportDir.mkdirs();
        }
        String docFileName = "FireDrills";

        File pdfFile = new File(docFileName);

        Document doc = new Document();

        PdfWriter docWriter = null;


        try {
            //special font sizes
            Font bfBold12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new
                    BaseColor(0, 0, 0));
            Font bf12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);

            docWriter = PdfWriter.getInstance(doc, new FileOutputStream(pdfFile));
            //document header attributes
            doc.addAuthor("Inficare ");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("inficaretech.com");
            doc.addTitle("Report with Column Headings");
            doc.setPageSize(PageSize.LETTER);

            //open document
            doc.open();

            //create a paragraph
            Paragraph paragraph = new Paragraph("Title");

            //specify column widths
            float[] columnWidths = {1f, 1f, 1f, 1f, 1f, 1f};

            //create PDF table with the given widths
            PdfPTable table = new PdfPTable(columnWidths);

            // set table width a percentage of the page width
            table.setWidthPercentage(95f);

            //insert column headings
            insertCell(table, headersList.get(0), Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, headersList.get(1), Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, headersList.get(2), Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, headersList.get(3), Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, headersList.get(4), Element.ALIGN_LEFT, 1, bfBold12);
            insertCell(table, headersList.get(5), Element.ALIGN_LEFT, 1, bfBold12);
            table.setHeaderRows(1);

            for (MyItem building : myItems) {

                insertCell(table, building.getTitle(), Element.ALIGN_LEFT, 1, bfBold12);

            }


            //add the PDF table to the paragraph
            paragraph.add(table);
            // add the paragraph to the document
            doc.add(paragraph);
        } catch (Exception e) {

        } finally {
            if (doc != null) {
                //close the document
                doc.close();
            }
            if (docWriter != null) {
                //close the writer
                docWriter.close();
            }
            return "" + pdfFile.getPath();
        }
    }

    private void addHeaderDataToList() {
        headersList.clear();
        headersList.add("Asset Name");
        headersList.add("Location");
        headersList.add("Last Inspection Date");
        headersList.add("Comment");
        headersList.add("Responsible");
        headersList.add("Standard,EP");

    }
}
