package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resPackageMembership;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/packageMembership")
public interface contIntPackageMembership {

    @RequestMapping
    List<resPackageMembership> getPackageMembershipAll();

    @RequestMapping("/{packageMembershipCode}")
    resPackageMembership getPackageMembershipById(@PathVariable("packageMembershipCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addPackageMembership(@RequestBody resPackageMembership newPackageMembership);

    @RequestMapping(method = RequestMethod.PUT,value="/{packageMembershipCode}")
    void updatePackageMembership(@PathVariable("packageMembershipCode") long code, @RequestBody resPackageMembership updatedPackageMembership);

    @RequestMapping(method= RequestMethod.DELETE,value="/{packageMembershipCode}")
    void deletePackageMembership(@PathVariable("packageMembershipCode") long code);
}
