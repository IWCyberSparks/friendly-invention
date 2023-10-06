package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneController {
	/*
	 * 
	 * 
	 * */
	Workbook wb;
	org.apache.poi.ss.usermodel.Sheet sh;
	FileInputStream fis;
	FileOutputStream fos,fos1,fos2;
	Row row,row1,row2;
	Cell cell,cell1,cell2;
	String ExcelVar = "";
	int counts = 1;
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	public TextField hosttextfield , databaseTextfield, PortNumberTextfield, PasswordTextField,pagestxt;

	
	public String host , database,port, password, pages;
	public String url = "https://auctionbankindia.com/property-list?page=";
	
	
	public void SwitchToSceneOne(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SceneOne.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void SwitchToSceneTwo(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("SceneTwo.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	
	

	
	public void runscrap(ActionEvent event)throws Exception {
		host = hosttextfield.getText();
		database = databaseTextfield.getText();
		port = PortNumberTextfield.getText();
		password= PasswordTextField.getText();
		pages= pagestxt.getText();
		
		System.out.println(host);
		System.out.println(database);
		System.out.println(password);
		System.out.println(port);
		System.out.println(pages);
		getTitle(pages);
	}
	
	
	void getData(String pgUrls) {
		try {
			Document doc = Jsoup.connect(pgUrls).get();
			
			Elements moreurl = doc.select(".icon");
			
			for(Element morelinks : moreurl) {
				String MoreURLs = morelinks.attr("href");
				Document morebtn = Jsoup.connect(MoreURLs).get();
				String morePageUrl = morebtn.baseUri();
				System.out.println(morePageUrl);
				
				
				Element AuctionBank = morebtn.select("th ~ td span").first();
				System.out.println("Auction Bank: "+AuctionBank.text());
				String AuctionBankstr = AuctionBank.text();
				
				Elements Phone = morebtn.select("th~td span b");
				System.out.println(Phone.text());
				String Phonestr = Phone.text();
				
				Elements ReservePrice = morebtn.select(".mb-4 .price");
				System.out.println("Reserve Price: "+ReservePrice.text());
				String ReservePricestr = ReservePrice.text();
				
				Element EMD = morebtn.select("tr td").get(3);
				System.out.println("EMD: "+EMD.text());
				String EMDstr = EMD.text();
				
				Element AuctionPublicationDate = morebtn.select("tr td").get(4);
				System.out.println("Auction Publication Date: "+AuctionPublicationDate.text());
				String AuctionPublicationDatestr = AuctionPublicationDate.text();
				
				Element AuctionSubmitionDeadline = morebtn.select("tr td").get(5);
				System.out.println("Auction Submition Deadline: "+AuctionSubmitionDeadline.text());
				String AuctionSubmitionDeadlinestr = AuctionSubmitionDeadline.text();
				
				Element AuctionDate= morebtn.select("tr td").get(6);
				System.out.println("Auction Date: "+AuctionDate.text());
				String AuctionDatestr = AuctionDate.text();
				
				Element PropertyType= morebtn.select("tr td span").get(2);
				System.out.println("Property Type: "+PropertyType.text());
				String PropertyTypestr = PropertyType.text();
				
				Element AuctionStatus= morebtn.select("tr td span").get(3);
				System.out.println("Auction Status: "+AuctionStatus.text());
				String AuctionStatusstr = AuctionStatus.text();
				
				Element BorrowersName= morebtn.select("tr td span").get(4);
				System.out.println("Borrowers Name: "+BorrowersName.text());
				String BorrowersNamestr = BorrowersName.text();
				
				Element Address = morebtn.select("tr td").get(13);
				System.out.println("Address: "+Address.text());
				String Addressstr = Address.text();
				
				Element Area = morebtn.select("tr td").get(14);
				System.out.println("Area: "+Area.text());
				String Areastr = Area.text();
				
				Element City = morebtn.select("tr td").get(15);
				System.out.println("City: "+City.text());
				String Citystr = City.text();
				
				Element State = morebtn.select("tr td").get(16);
				System.out.println("State: "+State.text());
				String Statestr = State.text();
				
				Element Locality = morebtn.select("tr td").get(17);
				System.out.println("Locality: "+Locality.text());
				String Localitystr = Locality.text();
				
				Element PinCode = morebtn.select("tr td").get(18);
				System.out.println("Pincode: "+PinCode.text());
				String PinCodestr = PinCode.text();
				
				System.out.println("\n");
				
				fis =  new FileInputStream("./Temp.xlsx");
				
				
				
				
				// Create The File
				wb  = WorkbookFactory.create(fis);
				
				//Select Sheet 
				sh = wb.getSheet("Sheet1");
					row = sh.createRow(counts);
					counts++;
					
					
					
					cell = row.createCell(0);
					cell.setCellValue(AuctionBankstr);


					cell = row.createCell(1);
					cell.setCellValue(Phonestr);

					
					cell = row.createCell(2);
					cell.setCellValue(ReservePricestr);
					
					
					cell = row.createCell(3);
					cell.setCellValue(EMDstr);
					
					
					cell = row.createCell(4);
					cell.setCellValue(AuctionPublicationDatestr);
					

					cell = row.createCell(5);
					cell.setCellValue(AuctionSubmitionDeadlinestr);
					
					cell = row.createCell(6);
					cell.setCellValue(AuctionDatestr);
					
					cell = row.createCell(7);
					cell.setCellValue(PropertyTypestr);
					
					cell = row.createCell(8);
					cell.setCellValue(AuctionStatusstr);
					
					cell = row.createCell(9);
					cell.setCellValue(BorrowersNamestr);
					
					cell = row.createCell(10);
					cell.setCellValue(Addressstr);
					
					cell = row.createCell(11);
					cell.setCellValue(Areastr);
					
					cell = row.createCell(12);
					cell.setCellValue(Citystr);
					
					cell = row.createCell(13);
					cell.setCellValue(Statestr);
					
					
					cell = row.createCell(14);
					cell.setCellValue(Localitystr);
								
					cell = row.createCell(15);
					cell.setCellValue(PinCodestr);
					
					fos = new FileOutputStream("./Temp.xlsx");
//					
					wb.write(fos);
				
				
				System.out.println("\n\n");
				
			}
			
		}catch(Exception eee) {}
	}
	
	
	
	
	void getTitle(String pages) {
//		try {
//			Document doc = Jsoup.connect(url).get();
//			
//			String titleURL =  doc.title();
//			System.out.println(titleURL);
//
//			
//}catch(Exception E) {}
		
		int pageno = Integer.parseInt(pages);
		
		for(int i =1; i<=pageno; i++) {
			try {
				Document docs = Jsoup.connect("https://auctionbankindia.com/property-list?page="+i).get();
				String pgUrls = docs.baseUri();
				System.out.println("\n");
				System.out.println(pgUrls);
				System.out.println("\n");
				getData(pgUrls);
				
				
//				CardCount = CardCount + 20;
			} catch (IOException e) {
				e.printStackTrace();
				 try {
					Thread.sleep(20 * 1000);
				} catch (InterruptedException e1) {}
			}
		}
		
		
	}
	
	
}



