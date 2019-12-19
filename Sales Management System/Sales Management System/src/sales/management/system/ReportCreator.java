
package sales.management.system;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.Desktop;
 

public class ReportCreator {
    public void createPdf(InvoiceData invoice) throws IOException, DocumentException {
        try {
            String dest = "Invoices/SM_" + Integer.toString(invoice.getInvoiceId()) + ".pdf";
            File file = new File(dest);
            file.getParentFile().mkdirs();
            Rectangle small = new Rectangle(280, 400);
            Font smallfont = new Font(FontFamily.HELVETICA, 10);
            Font boldfont = new Font(FontFamily.HELVETICA, 10, Font.BOLD);
            Document document = new Document(small, 5, 5, 5, 5);
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();
            int four = 4;
            PdfPTable table = new PdfPTable(four);
            
            PdfContentByte cb = writer.getDirectContent();
            
            PdfPCell cell = new PdfPCell(new Phrase("Sales Management System"));
            cell.setFixedHeight(30);
            
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(4);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Name", boldfont));
            cell.setFixedHeight(20);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Unit price", boldfont));
            cell.setFixedHeight(20);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Qty", boldfont));
            cell.setFixedHeight(20);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Sub total", boldfont));
            cell.setFixedHeight(20);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);
            
            Vector<InvoiceItem> items = invoice.getVector();
            String tempText = "";
            for (int i = 0; i < items.size(); i++) {
                for (int j = 0; j < 4; j++) {
                    
                    switch (j) {
                        case 0:
                            tempText = items.get(i).getName();
                            break;
                        case 1:
                            tempText = Double.toString(items.get(i).getUnitPrice());
                            break;
                        case 2:
                            tempText = Integer.toString(items.get(i).getQuantity());
                            break;
                        case 3:
                            tempText = Double.toString(items.get(i).getSubtotal());
                            break;
                    }
                    cell = new PdfPCell(new Phrase(tempText, smallfont));
                    cell.setFixedHeight(20);
                    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table.addCell(cell);                    
                }
            }

            //////////////////////////////////
            cell = new PdfPCell(new Phrase("Total (Rs):", boldfont));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setColspan(3);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(Double.toString(invoice.getTotal() + invoice.getDiscount()), smallfont));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setColspan(1);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Discount (Rs):", boldfont));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setColspan(3);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(Double.toString(invoice.getDiscount()), smallfont));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setColspan(1);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Payable (Rs):", boldfont));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell.setColspan(3);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(Double.toString(invoice.getTotal()), smallfont));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setColspan(1);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Date:", boldfont));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(1);
            table.addCell(cell);
            
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date date = new Date();
            
            cell = new PdfPCell(new Phrase(dateFormat.format(date), smallfont));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(3);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Id:", boldfont));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(1);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(Integer.toString(invoice.getInvoiceId()), smallfont));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setColspan(3);
            table.addCell(cell);
            
            document.add(table);
            document.close();
            
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(dest);
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    // no application registered for PDFs
                }
            }
            
        } catch (Exception e) {
        }
    }
}