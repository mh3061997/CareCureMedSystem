package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resServicePriceList;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/servicePriceList")
public interface contIntServicePriceList {



        @RequestMapping
        List<resServicePriceList> getServicePriceListAll();

        @RequestMapping("/speciality")
        List<resServicePriceList> getServicePriceListBySpeciality(@RequestParam("speciality")String speciality);

        @RequestMapping(method = RequestMethod.POST)
        void addServicePriceList(@RequestBody resServicePriceList newServicePriceList);

        @RequestMapping(method = RequestMethod.PUT,value="/{servicePriceListCode}")
        void updateServicePriceList(@PathVariable("servicePriceListCode") long code, @RequestBody resServicePriceList updatedServicePriceList);

        @RequestMapping(method= RequestMethod.DELETE,value="/{servicePriceListCode}")
        void deleteServicePriceList(@PathVariable("servicePriceListCode") long code);
    }