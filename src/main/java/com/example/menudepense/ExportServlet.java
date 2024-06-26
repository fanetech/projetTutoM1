
package com.example.menudepense;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.menudepense.database.Database;
import com.example.menudepense.models.Caisse;
import com.example.menudepense.models.MvmtCaisse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@WebServlet(name = "ExportServletServlet", value = "/export-servlet/*")
public class ExportServlet extends HttpServlet {
    private String message;
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRENCH);

    public void init() {
        message = "Hello World!";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String pathInfo = request.getPathInfo(); // /{id}
            if (pathInfo == null || pathInfo.equals("/")) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing user ID");
                return;
            }

            String[] pathParts = pathInfo.split("/");
            if (pathParts.length < 1) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
                return;
            }

            Database db = new Database();
            switch (pathParts[1]){
                case "mvnt-caisse":
                    List<MvmtCaisse> mvmList = new ArrayList<>();
                    ResultSet caisses =  db.get("SELECT * FROM mvment_caisse");
                    while (caisses.next()) {
                        int id = caisses.getInt("id");
                        Integer montant = caisses.getInt("montant");
                        String commentaire = caisses.getString("commentaire");
                        String libelle = caisses.getString("libelle");
                        String beneficiaire = caisses.getString("beneficiaire");
                        String type = caisses.getString("type");
                        String receveur = caisses.getString("receveur");
                        Date createdAt = caisses.getDate("createdAt");
                        mvmList.add(new MvmtCaisse( id, montant, commentaire, libelle, beneficiaire, type, receveur, createdAt));
                    }
                    // Create a Workbook
                    Workbook workbook = new XSSFWorkbook();
                    Sheet sheet = workbook.createSheet("Mouvement-caisse");

                    // Create a row and put some cells in it. Rows are 0-based.
                    Row row = sheet.createRow(0);

                    // Create header cells
                    Cell cell0 = row.createCell(0);
                    cell0.setCellValue("id");

                    Cell cell2 = row.createCell(1);
                    cell2.setCellValue("montant");
                    Cell cell3 = row.createCell(2);
                    cell3.setCellValue("commentaire");
                    Cell cell4 = row.createCell(3);
                    cell4.setCellValue("libelle");
                    Cell cell5 = row.createCell(4);
                    cell5.setCellValue("beneficiaire");
                    Cell cell6 = row.createCell(5);
                    cell6.setCellValue("type");
                    Cell cell7 = row.createCell(6);
                    cell7.setCellValue("receveur");
                    Cell cell8 = row.createCell(7);
                    cell8.setCellValue("createdAt");

                    // Fetch your data from your data source (e.g., database) and populate the cells
                    // For demonstration, let's add some dummy data
                    int idMvmtCaisse=1;
                    for (MvmtCaisse caisse : mvmList) {
                        Row dataRow = sheet.createRow(idMvmtCaisse);
                        dataRow.createCell(0).setCellValue(idMvmtCaisse);
                        dataRow.createCell(1).setCellValue(caisse.getMontant());
                        dataRow.createCell(2).setCellValue(caisse.getCommentaire());
                        dataRow.createCell(3).setCellValue(caisse.getLibelle());
                        dataRow.createCell(4).setCellValue(caisse.getBeneficiaire());
                        dataRow.createCell(5).setCellValue(caisse.getType());
                        dataRow.createCell(6).setCellValue(caisse.getReceveur());
                        dataRow.createCell(7).setCellValue(dateFormat.format(caisse.getCreatedAt()));
                        idMvmtCaisse++;
                    }

                    // Set the content type
                    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                    response.setHeader("Content-Disposition", "attachment; filename=mouvement-caisse.xlsx");

                    // Write the output to the response
                    workbook.write(response.getOutputStream());
                    workbook.close();
                    break;
                case "caisse":
                    List<Caisse> caissesMain = new ArrayList<>();
                    ResultSet resCaisse =  db.get("SELECT * FROM caisse");
                    while (resCaisse.next()) {
                        int id = resCaisse.getInt("id");
                        Integer montant = resCaisse.getInt("montant");
                        String libelle = resCaisse.getString("libelle");
                        Date createdAt = resCaisse.getDate("createdAt");
                        caissesMain.add(new Caisse( id, montant, libelle, createdAt));
                    }
                    // Create a Workbook
                    Workbook workbookCaisse = new XSSFWorkbook();
                    Sheet sheetCaisse = workbookCaisse.createSheet("Caisse");

                    // Create a row and put some cells in it. Rows are 0-based.
                    Row rowCaisse = sheetCaisse.createRow(0);

                    // Create header cells
                    Cell cellcaisse0 = rowCaisse.createCell(0);
                    cellcaisse0.setCellValue("id");
                    Cell cellcaisse1 = rowCaisse.createCell(1);
                    cellcaisse1.setCellValue("Montant");
                    Cell cellcaisse2 = rowCaisse.createCell(2);
                    cellcaisse2.setCellValue("Libelle");
                    Cell cellcaisse3 = rowCaisse.createCell(3);
                    cellcaisse3.setCellValue("Date creation");

                    int caisseId=1;
                    for (Caisse caisse : caissesMain) {
                        Row dataRow = sheetCaisse.createRow(caisseId);
                        dataRow.createCell(0).setCellValue(caisseId);
                        dataRow.createCell(1).setCellValue(caisse.getMoment());
                        dataRow.createCell(2).setCellValue(caisse.getLibelle());
                        dataRow.createCell(3).setCellValue(dateFormat.format(caisse.getCreatedAt()));
                        caisseId++;
                    }

                    // Set the content type
                    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                    response.setHeader("Content-Disposition", "attachment; filename=Alimentation-caisse.xlsx");

                    // Write the output to the response
                    workbookCaisse.write(response.getOutputStream());
                    workbookCaisse.close();
                    break;

                default:
                    response.sendRedirect("/");
                    break;
            }



        }catch (Exception e){
            System.out.println(e);
        }


    }

    public void destroy() {
    }
}