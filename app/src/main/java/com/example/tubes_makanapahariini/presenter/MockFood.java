package com.example.tubes_makanapahariini.presenter;

import com.example.tubes_makanapahariini.model.Food;

public class MockFood {
    public static String[] foodStringArr = {
            "Nasi Goreng Biasa",
            "Nasi Goreng Telor",
            "Nasi Goreng Ayam",
            "Nasi Goreng Sapi",
            "Nasi Goreng Seafood",
            "Mie Goreng Biasa",
            "Mie Goreng Telor",
            "Mie Goreng Ayam",
            "Mie Goreng Sapi",
            "Mie Goreng Seafood",
            "Baso",
            "Baso",
            "Baso",
            "Baso",
            "Baso",
            "Baso",
            "Baso",
            "Baso"
    };

    public static Food[] foodObjectArr= {
            new Food("Nasi Goreng","pake nasi","nasi,kecap,garam,telur",1),
            new Food("Mie Goreng","pake mie","mie,kecap,udang,sayur",2),
            new Food("Indomie","pake nasi","mie indomie,telur,nasi putih",3),
    };
}
