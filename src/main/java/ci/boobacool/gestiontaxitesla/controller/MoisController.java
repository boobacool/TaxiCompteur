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

import ci.boobacool.gestiontaxitesla.domain.Mois;
import ci.boobacool.gestiontaxitesla.domain.TypeDepense;
import ci.boobacool.gestiontaxitesla.pagination.PageModel;
import ci.boobacool.gestiontaxitesla.service.MoisServiceImpl;
import ci.boobacool.gestiontaxitesla.service.TypeDepenseServiceImpl;

@Controller
@RequestMapping("mois")
public class MoisController {

	@Autowired
	private MoisServiceImpl moisService;
	@Autowired
	private PageModel pageModel;

	@GetMapping(value = "/findAll")
	public String findAllPageable(Model model) {
		pageModel.setSIZE(10);
		pageModel.initPageAndSize();
		model.addAttribute("ms", moisService.findAllPageable(pageModel.getPAGE(), pageModel.getSIZE()));
		return "views/mois";
	}

	@RequestMapping(value = "saveMois", method = RequestMethod.POST)
	public String saveMois(@Valid Mois mois, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "addTaxi";
		}
		moisService.saveMois(mois);
		return "redirect:/mois/findAll";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Mois mois = moisService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Mois Id:" + id));
		model.addAttribute("mois", mois);
		return "update";
	}

	@GetMapping("/delete/{id}")
	public String deleteMois(@PathVariable("id") long id, Model model) {
		Mois mois = moisService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Mois Id:" + id));
		moisService.deleteMois(mois);

		return "redirect:/mois/findAll";
	}

	@GetMapping("/findOne")
	@ResponseBody
	public Mois findOne(Long id) {
		return moisService.findById(id).get();
	}

}
