package com.defaria.springbootmicroservice.domain;

public enum Region {
    Northern_California("Northern California"), Central_Coast("Central Coast"), Southern_California("Central California"), Varies("Varies");
    private String label;
    private Region(String label){
        this.label = label;
    }

    public static Region findByLabel(String rLabel){
        for(Region r: Region.values()){
            if(r.label.equalsIgnoreCase(rLabel))
                System.out.println("Region Label Found");
                return r;
        }
        System.out.println("Given region label not found!");
        return null;
    }
}
