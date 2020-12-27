package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resPackageBase;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/packageBase")
public interface contIntPackageBase {

    @RequestMapping
    List<resPackageBase> getPackageBaseAll();

    @RequestMapping("/{packageBaseCode}")
    resPackageBase getPackageBaseById(@PathVariable("packageBaseCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addPackageBase(@RequestBody resPackageBase newPackageBase);

    @RequestMapping(method = RequestMethod.PUT,value="/{packageBaseCode}")
    void updatePackageBase(@PathVariable("packageBaseCode") long code, @RequestBody resPackageBase updatedPackageBase);

    @RequestMapping(method= RequestMethod.DELETE,value="/{packageBaseCode}")
    void deletePackageBase(@PathVariable("packageBaseCode") long code);
}
