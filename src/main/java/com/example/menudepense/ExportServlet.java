
package com.example.menudepense;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.menudepense.models.MvmtCaisse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@WebServlet(name = "ExportServletServlet", value = "/export-servlet/*")
public class ExportServlet extends HttpServlet {
    private String message;

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
                case "caisse":
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
                    for (MvmtCaisse caisse : mvmList) {
                        Row dataRow = sheet.createRow(caisse.getId());
                        dataRow.createCell(0).setCellValue(caisse.getId());
                        dataRow.createCell(1).setCellValue(caisse.getMontant());
                        dataRow.createCell(2).setCellValue(caisse.getCommentaire());
                        dataRow.createCell(3).setCellValue(caisse.getLibelle());
                        dataRow.createCell(4).setCellValue(caisse.getBeneficiaire());
                        dataRow.createCell(5).setCellValue(caisse.getType());
                        dataRow.createCell(6).setCellValue(caisse.getReceveur());
                        dataRow.createCell(7).setCellValue(caisse.getCreatedAt());
                    }

                    // Set the content type
                    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                    response.setHeader("Content-Disposition", "attachment; filename=DataTable.xlsx");

                    // Write the output to the response
                    workbook.write(response.getOutputStream());
                    workbook.close();
                    break;
                case "arret":
                    int userRes =  db.delete("DELETE FROM user WHERE id = '"+pathParts[2]+"'");
                    if(userRes!=0){
                        response.sendRedirect("/employe-servlet");
                    }else{
                        response.sendRedirect("/employe-servlet");
                    }
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