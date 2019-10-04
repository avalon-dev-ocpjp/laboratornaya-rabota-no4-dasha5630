/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.java.dev.ocpjp.labs.models;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fgh
 */
class CommodityImpl implements Commodity, Cloneable{

   
    String code;
    String vendorCode;
    String name;
    double price;
    int residue;
    
    
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getVendorCode() {
        return vendorCode;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getResidue() {
        return residue;
    }
      
    @Override
    protected CommodityImpl clone(){
        try {
            return (CommodityImpl) super.clone();
        } catch (CloneNotSupportedException ex) {
           throw new IllegalArgumentException(ex);
        }
    }
    
     static CommodityBuilder builder() {
         return new CommodityBuilderImpl();
    }

    
    static class CommodityBuilderImpl implements CommodityBuilder{
        
        private final CommodityImpl dummy = new CommodityImpl(); 
        
        private CommodityBuilderImpl(){};

        @Override
        public CommodityBuilder code(String code) {
            dummy.code = code;
            return this;
        }

        @Override
        public CommodityBuilder vendorCode(String vendorCode) {
            dummy.vendorCode = vendorCode;
            return this;
        }

        @Override
        public CommodityBuilder name(String name) {
            dummy.name = name;
            return this;
        }

        @Override
        public CommodityBuilder price(double price) {
            dummy.price = price;
            return this;
        }

        @Override
        public CommodityBuilder residue(int residue) {
            dummy.residue = residue;
            return this;
        }

        @Override
        public Commodity build() {
            return dummy.clone();
        }
    }
}
