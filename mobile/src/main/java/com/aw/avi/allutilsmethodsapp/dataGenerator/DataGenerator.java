package com.aw.avi.allutilsmethodsapp.datagenerator;

import com.aw.avi.allutilsmethodsapp.models.Details;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinash.verma on 1/8/2018.
 */

public class DataGenerator {


    public static List<Details> detailsGenerator() {
        List<Details> detailsList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Details details = new Details();
//            Faker faker = new Faker();
//
//            details.setName(faker.name().fullName());
//            details.setFirstname(faker.name().firstName());
//            details.setLastname(faker.name().lastName());
//            details.setAddress(faker.address().streetAddress());
//            detailsList.add(details);


            details.setName("avi " + i);
//            details.setFirstname(faker.name().firstName());
//            details.setLastname(faker.name().lastName());
            details.setAddress("address " + i);
            detailsList.add(details);
        }
        return detailsList;
    }

}
