package alerts_in_selenium;





import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class Browser_Utility {

	
	public static WebDriver webdriver;
	public static ArrayList<String> list1=new ArrayList<String>();//Creating arraylist 
	
	public static WebDriver browser_setting(String browser_name) {
		if(browser_name.equalsIgnoreCase("Mozilla")) {
			//if(browser_name.equals("Mozilla")) {	
			System.setProperty("webdriver.gecko.driver","D:\\java\\selenium-web-driver\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			webdriver = new FirefoxDriver();
		}
		else if(browser_name.equalsIgnoreCase("chrome")) {
			//else if(browser_name.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\java\\selenium-web-driver\\chrome-driver\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			//options.addArguments("--start-maximized");
			webdriver = new ChromeDriver(options);
		}
		else if(browser_name.equalsIgnoreCase("edge")) {
			//else if(browser_name.equals("edge")) {
			System.setProperty("webdriver.edge.driver","D:\\java\\selenium-web-driver\\edge-driver\\edgedriver_win64\\msedgedriver.exe");
			webdriver=new EdgeDriver();
		}
		return webdriver;
	}

	@DataProvider 
	public Object testdata() throws IOException {
		
		
		File file = new File("D:\\java\\files\\redbus_tour_info.xlsx");   //creating a new file instance  

		FileInputStream fis_exel = new FileInputStream(file);   //obtaining bytes from the file  

		//creating Workbook instance that refers to .xlsx file  
		XSSFWorkbook wb = new XSSFWorkbook(fis_exel);   
		XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
		
		int rowNum = sheet.getLastRowNum()+1;
		
		
	    int colNum = sheet.getRow(0).getLastCellNum();
	    
	    System.out.println(" row num " +rowNum);
	    System.out.println(" col num " +colNum);
	    
	    Object[][] data1 	= new Object[rowNum-1][colNum];
	    String value = "a";
	    DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
	    
	    for (int i=1; i<rowNum; i++){
	        //get the row
	        XSSFRow row = sheet.getRow(i);
	            for (int j=0; j<colNum; j++){
	            	
	                //this gets the cell and sets it as blank if it's empty.
	            	
	                XSSFCell cell = row.getCell(j);
	                
	                	
	               
	                if(cell.getCellTypeEnum() == CellType.STRING ) {
	                //XSSFCell cell = row.getC
	                value = cell.getStringCellValue();  
	                }
	                
	                else if (cell.getCellTypeEnum() == CellType.NUMERIC ) {
	                	
	                	// value = String.valueOf(cell.getStringCellValue()); 
	                	 value = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
	                }
	                //System.out.println("Value: " + value);
	                data1[i-1][j] = value;
	                System.out.println(data1[i-1][j]);

	            }            
	    System.out.println();  
	    
	    }
	    //System.out.println("End Value:  " + data[2][2]);
	    fis_exel.close();	
		
		return data1;
	}

	
	
	
	
	public static WebDriver go_to(String url)
	{
		System.out.println("opening " +url);
		webdriver.get(url);
		return webdriver;
	}

	
	
	public static WebDriver getDriver() {
		return webdriver;
	}

	
	
	public static void close() { webdriver.close(); }

}