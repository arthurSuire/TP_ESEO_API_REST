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
    public List<Ville> villes() {
        return villeBLOService.getAllVille();
    }

    @RequestMapping(value = "/villeCC", method = RequestMethod.GET)
    @ResponseBody
    public List<Ville> villeCodeCommune(@RequestParam(value = "codeCommune") String code) {
        return villeBLOService.getVillesByCodeCommun(code);
    }

    @RequestMapping(value = "/villeCP", method = RequestMethod.GET)
    @ResponseBody
    public List<Ville> villeCodePostal(@RequestParam(value = "codePostal") String code) {
        return villeBLOService.getVillesByCodePostal(code);
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
