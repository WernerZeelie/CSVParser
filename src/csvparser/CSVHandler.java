/*
 * Author: Werner Zeelie
 * Last modified: 31 May 2022
 * Vas-X Technical Test
 */

package csvparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVHandler {
    
    private String[] values, sales, marketing, HR, admin, support, development, operations, finance;
    private int totalSalesEmp, totalMarketingEmp, totalHrEmp, totalAdminEmp, totalSupportEmp, totalDevEmp, totalOpsEmp, totalFinanceEmp;
    private int salesHigh, marketingHigh, hrHigh, adminHigh, supportHigh, devHigh, opsHigh, financeHigh;
    private int salesLow, marketingLow, hrLow, adminLow, supportLow, devLow, opsLow, financeLow;
    private int salesSalaryTotal, marketingSalaryTotal, hrSalaryTotal, adminSalaryTotal, supportSalaryTotal, devSalaryTotal, opsSalaryTotal, financeSalaryTotal;
    private int salesSalaryAvg, marketingSalaryAvg, hrSalaryAvg, adminSalaryAvg, supportSalaryAvg, devSalaryAvg, opsSalaryAvg, financeSalaryAvg;
    private int overallEmployees,overallMinSalary, overallAvgSalary, overallMaxSalary, overallSalaryTot;
    
    List<Integer> salesSalaries = new ArrayList<>();
    List<Integer> marketingSalaries = new ArrayList<>();
    List<Integer> hrSalaries = new ArrayList<>();
    List<Integer> adminSalaries = new ArrayList<>();
    List<Integer> supportSalaries = new ArrayList<>();
    List<Integer> devSalaries = new ArrayList<>();
    List<Integer> opsSalaries = new ArrayList<>();
    List<Integer> financeSalaries = new ArrayList<>();
    
    
  
    public void summarizeCSV(String filepath){
        try {
             
             String currentLine;
             BufferedReader br = new BufferedReader(new FileReader(filepath));
             while((currentLine = br.readLine()) != null){
                 values = currentLine.split("\\|");
                 //values[3] is the deparment
                 if(values[3].equalsIgnoreCase("Sales")){
                     
                     //Calculate the total Employees in the department
                     totalSalesEmp = totalSalesEmp + 1;
                     //Add the salaries a list to be used later
                     salesSalaries.add(Integer.parseInt(values[4]));
                     //Calculate the combined salary
                     salesSalaryTotal = salesSalaryTotal + Integer.parseInt(values[4]);
 
                 }else if(values[3].equalsIgnoreCase("Marketing")){
                     
                     totalMarketingEmp = totalMarketingEmp + 1;
                     marketingSalaries.add(Integer.parseInt(values[4]));
                     marketingSalaryTotal = marketingSalaryTotal + Integer.parseInt(values[4]);
                    
                 }else if(values[3].equalsIgnoreCase("HR")){
                     
                     totalHrEmp = totalHrEmp + 1;
                     hrSalaries.add(Integer.parseInt(values[4]));
                     hrSalaryTotal = hrSalaryTotal + Integer.parseInt(values[4]);
                    
                 }else if(values[3].equalsIgnoreCase("Admin")){
                     
                     totalAdminEmp = totalAdminEmp + 1;
                     adminSalaries.add(Integer.parseInt(values[4]));
                     adminSalaryTotal = adminSalaryTotal + Integer.parseInt(values[4]);
                    
                 }else if(values[3].equalsIgnoreCase("Support")){
                     
                     totalSupportEmp = totalSupportEmp + 1;
                     supportSalaries.add(Integer.parseInt(values[4]));
                     supportSalaryTotal = supportSalaryTotal + Integer.parseInt(values[4]);
                     
                 }else if(values[3].equalsIgnoreCase("Development")){
                     
                     totalDevEmp = totalDevEmp + 1;
                     devSalaries.add(Integer.parseInt(values[4]));
                     devSalaryTotal = devSalaryTotal + Integer.parseInt(values[4]);
                     
                 }else if(values[3].equalsIgnoreCase("Operations")){
                     
                     totalOpsEmp = totalOpsEmp + 1;
                     opsSalaries.add(Integer.parseInt(values[4]));
                     opsSalaryTotal = opsSalaryTotal + Integer.parseInt(values[4]);
                    
                     
                 }else if(values[3].equalsIgnoreCase("Finance")){
                     
                     totalFinanceEmp = totalFinanceEmp + 1;
                     financeSalaries.add(Integer.parseInt(values[4]));
                     financeSalaryTotal = financeSalaryTotal + Integer.parseInt(values[4]);
                     
                 }
                 
             }
            
             //Calculate the max salaries for each department
             salesHigh = Collections.max(salesSalaries);
             marketingHigh = Collections.max(marketingSalaries);
             hrHigh = Collections.max(hrSalaries);
             adminHigh = Collections.max(adminSalaries);
             supportHigh = Collections.max(supportSalaries);
             devHigh = Collections.max(devSalaries);
             opsHigh = Collections.max(opsSalaries);
             financeHigh = Collections.max(financeSalaries);
             
             //Calculate the min salaries for each department
             salesLow = Collections.min(salesSalaries);
             marketingLow = Collections.min(marketingSalaries);
             hrLow = Collections.min(hrSalaries);
             adminLow = Collections.min(adminSalaries);
             supportLow = Collections.min(supportSalaries);
             devLow = Collections.min(devSalaries);
             opsLow = Collections.min(opsSalaries);
             financeLow = Collections.min(financeSalaries);
             
             //Calculate the avg salary for each department
             salesSalaryAvg = salesSalaryTotal / totalSalesEmp;
             marketingSalaryAvg = marketingSalaryTotal / totalMarketingEmp;
             hrSalaryAvg = hrSalaryTotal / totalHrEmp;
             adminSalaryAvg = adminSalaryTotal / totalAdminEmp;
             supportSalaryAvg = supportSalaryTotal / totalSupportEmp;
             devSalaryAvg = devSalaryTotal / totalDevEmp;
             opsSalaryAvg = opsSalaryTotal / totalOpsEmp;
             financeSalaryAvg = financeSalaryTotal / totalFinanceEmp;
             
             //Calculate the combined totals of all departments
             overallEmployees = totalSalesEmp + totalMarketingEmp + totalHrEmp + totalAdminEmp + totalSupportEmp + totalDevEmp + totalOpsEmp + totalFinanceEmp;
             overallMinSalary = salesLow + marketingLow + hrLow + adminLow + supportLow + devLow + opsLow + financeLow;
             overallAvgSalary = salesSalaryAvg + marketingSalaryAvg + hrSalaryAvg + adminSalaryAvg + supportSalaryAvg + devSalaryAvg + opsSalaryAvg + financeSalaryAvg;    
             overallMaxSalary = salesHigh + marketingHigh + hrHigh + adminHigh + supportHigh + devHigh + opsHigh + financeHigh;
             overallSalaryTot = salesSalaryTotal + marketingSalaryTotal + hrSalaryTotal + adminSalaryTotal + supportSalaryTotal + devSalaryTotal + opsSalaryTotal + financeSalaryTotal;    
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            //Creation of the summary file to be written to
             File myFile = new File("CSVSummary.txt");
             
             if(myFile.createNewFile()){
                 System.out.println("File Created");
             }else{
                 System.out.println("File already exists");
             }
             
            try (FileWriter writer = new FileWriter("CSVSummary.txt")) {
                writer.write("Department,Employees,MinSalary,AvgSalary,MaxSalary,TotalSalary \n"
                        + "Admin," + totalAdminEmp + "," + adminLow + "," + adminSalaryAvg + "," + adminHigh + "," + adminSalaryTotal + "\n"
                        + "Development," + totalDevEmp + "," + devLow + "," + devSalaryAvg + "," + devHigh + "," + devSalaryTotal + "\n"
                        + "Finance," + totalFinanceEmp + "," + financeLow + "," + financeSalaryAvg + "," + financeHigh + "," + financeSalaryTotal + "\n"
                        + "HR," + totalHrEmp + "," + hrLow + "," + hrSalaryAvg + "," + hrHigh + "," + hrSalaryTotal + "\n"
                        + "Marketing," + totalMarketingEmp + "," + marketingLow + "," + marketingSalaryAvg + "," + marketingHigh + "," + marketingSalaryTotal + "\n"
                        + "Operations," + totalOpsEmp + "," + opsLow + "," + opsSalaryAvg + "," + opsHigh + "," + opsSalaryTotal + "\n"
                        + "Sales," + totalSalesEmp + "," + salesLow + "," + salesSalaryAvg + "," + salesHigh + "," + salesSalaryTotal + "\n"
                        + "Support," + totalSupportEmp + "," + supportLow + "," + supportSalaryAvg + "," + supportHigh + "," + supportSalaryTotal + "\n"
                        + "Totals," + overallEmployees+ "," + overallMinSalary + "," + overallAvgSalary+ "," + overallMaxSalary + "," + overallSalaryTot + "\n"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
}
