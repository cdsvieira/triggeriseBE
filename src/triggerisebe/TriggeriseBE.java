/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triggerisebe;

import java.io.File;
import java.util.ArrayList;

import triggerise.model.BulkDiscount;
import triggerise.model.Checkout;
import triggerise.model.Discount;
import triggerise.model.XforYDiscount;
import triggerise.utils.PropertiesManager;

/**
 *
 * @author Carlos Vieira
 */
public class TriggeriseBE {

    /**
     * @param properties file location
     */
    public static void main(String[] args) {
    	File file = new File(args[0]); //such as config/config.properties in classpath
    	if(!file.exists()) {
    		System.out.println("Pass config as param");
    		System.exit(1);
    	}
    PropertiesManager prop = new PropertiesManager(file);
    
    ArrayList<Discount> pricingRules= new ArrayList<>();
    
    String xfory= prop.getProperty("XforY");
    for(String discount: xfory.split(",")) {
    	String[] aux=discount.split(":");
    	String discountedItem= aux[0];
    	int x= Integer.parseInt(aux[1]);
    	int y = Integer.parseInt(aux[2]);
    	pricingRules.add(new XforYDiscount(x, y,discountedItem));
    }
    
    String bulk= prop.getProperty("Bulk");
    for(String discount: bulk.split(",")) {
    	String[] aux=discount.split(":");
    	String discountedItem= aux[0];
    	int itemDiscount= Integer.parseInt(aux[1]);
    	int bulkAmount = Integer.parseInt(aux[2]);
    	pricingRules.add(new BulkDiscount(bulkAmount, itemDiscount,discountedItem));
    }
    
    Checkout co = new Checkout(pricingRules);
    co.scan("TICKET");
    co.scan("TICKET");
    co.scan("HOODIE");
    double total= co.total();
    
    }
    
}
