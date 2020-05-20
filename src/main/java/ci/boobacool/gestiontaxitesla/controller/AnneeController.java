package ci.boobacool.gestiontaxitesla.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ci.boobacool.gestiontaxitesla.domain.Annee;
import ci.boobacool.gestiontaxitesla.domain.Mois;
import ci.boobacool.gestiontaxitesla.domain.TypeDepense;
import ci.boobacool.gestiontaxitesla.pagination.PageModel;
import ci.boobacool.gestiontaxitesla.service.AnneeServiceImpl;
import ci.boobacool.gestiontaxitesla.service.MoisServiceImpl;
import ci.boobacool.gestiontaxitesla.service.TypeDepenseServiceImpl;

@Controller
@RequestMapping("annee")
public class AnneeController {

	@Autowired
	private AnneeServiceImpl anneeService;
	@Autowired
	private PageModel pageModel;

	@GetMapping(value = "/findAll")
	public String findAllPageable(Model model) {
		pageModel.setSIZE(10);
		pageModel.initPageAndSize();
		model.addAttribute("annees", anneeService.findAllPageable(pageModel.getPAGE(), pageModel.getSIZE()));
		return "views/annee";
	}

	@RequestMapping(value = "saveAnnee", method = RequestMethod.POST)
	public String saveAnnee(@Valid Annee annee, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "addTaxi";
		}
		anneeService.saveAnnee(annee);
		return "redirect:/annee/findAll";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Annee annee = anneeService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Annee Id:" + id));
		model.addAttribute("annee", annee);
		return "update";
	}

	@GetMapping("/delete/{id}")
	public String deleteAnnee(@PathVariable("id") long id, Model model) {
		Annee annee = anneeService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Mois Id:" + id));
		anneeService.deleteAnnee(annee);

		return "redirect:/annee/findAll";
	}

	@GetMapping("/findOne")
	@ResponseBody
	public Annee findOne(Long id) {
		return anneeService.findById(id).get();
	}

}
