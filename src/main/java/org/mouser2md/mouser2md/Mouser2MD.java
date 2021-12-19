package org.mouser2md.mouser2md;

import java.io.IOException;
import java.util.StringTokenizer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author 1sand0s
 */

public class Mouser2MD {

	/**
	 * @param args the command line arguments
	 */

	public static void main(String[] args) throws IOException {

		String url = args[0];

		Document doc = Jsoup.connect(url).get();
		Document doc2 = Jsoup.parse(doc.html());

		Element table = doc2.getElementById("ctl00_ContentMain_CartGrid_grid");

		String markdown = "| Component   | Quantity | Total Cost | Description |\n";
		markdown += "|:------------|:--------:|:----------:|:------------|\n";

		if (table.childrenSize() == 1) {

			Elements comp1 = table.getElementsByClass("cartRowWhite");
			Elements comp2 = table.getElementsByClass("alt-grey");

			Elements components = new Elements();
			components.addAll(comp1);
			components.addAll(comp2);

			for (Element e : components) {
				Elements component = e.getElementsByAttributeValueEnding("id", "lnkMouserPartNumber");
				Elements quantity = e.getElementsByClass("td-qty");
				Elements description = e.getElementsByAttributeValueEnding("id", "trDescription");
				Elements extPrice = e.getElementsByAttributeValueEnding("id", "lblExtendedPrice");

				String mouserPartNameStr = component.first().ownText();
				String linkStr = "https://www.mouser.com/" + component.attr("href");
				String quantityStr = quantity.first().ownText();
				String priceStr = extPrice.first().ownText();
				String descrpStr = (description.first().child(1)).child(0).ownText();
				String cNameMD = "<a href=\"" + linkStr + "\">" + mouserPartNameStr + "</a>";

				markdown += "| " + cNameMD + " | " + quantityStr + " | " + priceStr + " | " + descrpStr + " |\n";
			}
		}

		System.out.println(markdown);
	}
}