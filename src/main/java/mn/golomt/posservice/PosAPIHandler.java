package mn.golomt.posservice;

import java.math.BigDecimal;

import org.json.JSONArray;
import org.json.JSONObject;

import mn.mta.pos.exam.BridgePosAPI;

public class PosAPIHandler 
{
	public static String putHandler(String amount)
	{
		double floatAmount = Double.parseDouble(amount);
		double vatAmount = floatAmount * 0.0909;
		JSONObject obj = new JSONObject();
        JSONArray stocks = new JSONArray();
        JSONObject stock1 = new JSONObject();
        stock1.put("code", "1");
        stock1.put("name", "baraa");
        stock1.put("measureUnit", "piece");
        stock1.put("qty", "1.00");
        stock1.put("unitPrice", String.format("%.2f", new BigDecimal(floatAmount)));
        stock1.put("totalAmount", String.format("%.2f", new BigDecimal(floatAmount)));
        stock1.put("cityTax", "1.00");
        stock1.put("vat", String.format("%.2f", new BigDecimal(vatAmount)));
        stock1.put("barCode", "123456789");
        stocks.put(stock1);
        obj.put("amount", String.format("%.2f", new BigDecimal(floatAmount)));
        obj.put("vat", String.format("%.2f", new BigDecimal(vatAmount)));
        obj.put("cashAmount", "0.00");
        obj.put("nonCashAmount", String.format("%.2f", new BigDecimal(floatAmount)));
        obj.put("cityTax", "1.00");
        obj.put("districtCode", "25");
        //obj.put("posNo", "0000");
        obj.put("customerNo", "");
        obj.put("billType", "1");
        //obj.put("billIdSuffix", "000000");
        //obj.put("returnBillId", "10000000000000000000000000000000");
        //obj.put("taxType", "1");
        //obj.put("invoiceId", "000000000000000000000000000000000");
        //obj.put("reportMonth", "2020-07");
        //obj.put("branchNo", "000");
        obj.put("stocks", stocks);
        
        String result = BridgePosAPI.put(obj.toString());
        JSONObject res = new JSONObject(result);
        JSONObject returnResult = new JSONObject();
        returnResult.put("success", "true");
        returnResult.put("qrData", res.get("qrData"));
        returnResult.put("lottery", res.get("lottery"));
        returnResult.put("errorCode", "00");
        returnResult.put("message", "");
        
        return returnResult.toString();
	}
}
