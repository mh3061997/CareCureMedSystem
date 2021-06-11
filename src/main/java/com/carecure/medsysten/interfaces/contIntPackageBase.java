package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resPackageBase;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/packageBase")
@Api(tags = "Package")
public interface contIntPackageBase {

    @RequestMapping(method = RequestMethod.GET)
    List<resPackageBase> getPackageBaseAll();

    @RequestMapping(method = RequestMethod.GET,value = "/status")
    List<resPackageBase> getPackageBaseAllByStatus(@RequestParam String status);

    @RequestMapping(method = RequestMethod.GET,value = "/{packageBaseCode}")
    resPackageBase getPackageBaseById(@PathVariable("packageBaseCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addPackageBase(@RequestBody resPackageBase newPackageBase);

    @RequestMapping(method = RequestMethod.PUT,value="/{packageBaseCode}")
    void updatePackageBase(@PathVariable("packageBaseCode") long code, @RequestBody resPackageBase updatedPackageBase);

    @RequestMapping(method= RequestMethod.DELETE,value="/{packageBaseCode}")
    void deletePackageBase(@PathVariable("packageBaseCode") long code);
}
