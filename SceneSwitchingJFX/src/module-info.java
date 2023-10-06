module SceneSwitchingJFX {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires java.desktop;
	requires java.sql;
	requires org.jsoup;
	requires org.apache.poi.poi;
	requires org.apache.poi.ooxml;
	requires org.apache.poi.ooxml.schemas;
	opens application to javafx.graphics, javafx.fxml;
}
