package com.controller;

import com.blo.VilleBLO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class VilleController {

    @Autowired
    VilleBLO villeBLOService;

    @RequestMapping(value = "/ville", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Ville> get(@RequestParam (required = false, value = "codePostal") String codePostal) {
        ArrayList<Ville> listeVilles = villeBLOService.getInfoVilles(codePostal);
        return listeVilles;
    }

}
