package com.controller;

import com.blo.VilleBLO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VilleController {

    @Autowired
    VilleBLO villeBLOService;

    @RequestMapping(value = "/villes", method = RequestMethod.GET)
    @ResponseBody
    public List villes() {
        return villeBLOService.getAllVille();
    }

    @RequestMapping(value = "/ville", method = RequestMethod.GET)
    @ResponseBody
    public List ville(@RequestParam(value = "codeCommune") String code) {
        return villeBLOService.getVille(code);
    }

    @RequestMapping(value = "/ajouter_ville", method = RequestMethod.POST)
    @ResponseBody
    public void creerVille(@RequestBody Ville villeAjoutee) {
        villeBLOService.addVille(villeAjoutee);
    }

    @RequestMapping(value = "/modifier_ville", method = RequestMethod.PUT)
    @ResponseBody
    public void modifierVille(@RequestBody Ville villeModifiee) {
        villeBLOService.modifyVille(villeModifiee);
    }

    @RequestMapping(value = "/supprimer_ville", method = RequestMethod.DELETE)
    @ResponseBody
    public void supprimerVille(@RequestParam(value = "codeCommune") String codeCommune) {
        villeBLOService.deleteVille(codeCommune);
    }
}
