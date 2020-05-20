package ci.boobacool.gestiontaxitesla.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ci.boobacool.gestiontaxitesla.domain.Taxi;
import ci.boobacool.gestiontaxitesla.pagination.PageModel;
import ci.boobacool.gestiontaxitesla.service.TaxiServiceImpl;

@Controller
@RequestMapping("taxi")
public class TaxiController {

	@Autowired
	private TaxiServiceImpl taxiService;
	@Autowired
	private PageModel pageModel;

	@GetMapping(value = "/findAll")
	public String findAllPageable(Model model) {
		pageModel.setSIZE(10);
		pageModel.initPageAndSize();
		model.addAttribute("taxis", taxiService.findAllPageable(pageModel.getPAGE(), pageModel.getSIZE()));
		int erreur = 0;
		String errText = null;
		model.addAttribute("error", erreur);
		model.addAttribute("errText", errText);
		return "views/taxi";
	}

	@RequestMapping(value = "saveTaxi", method = RequestMethod.POST)
	public String saveTaxi(@Valid Taxi taxi, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("error", 1);
			model.addAttribute("errText", "Verifier les informations saisies");
			return "views/taxi";
		}

		taxiService.saveTaxi(taxi);
		/*
		 * pageModel.setSIZE(10); pageModel.initPageAndSize();
		 * model.addAttribute("taxis", taxiService.findAllPageable(pageModel.getPAGE(),
		 * pageModel.getSIZE()));
		 */

		return "redirect:/taxi/findAll";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Taxi taxi = taxiService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid taxi Id:" + id));
		model.addAttribute("taxi", taxi);
		return "updateTaxi";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid Taxi taxi, BindingResult result, Model model) {
		if (result.hasErrors()) {
			taxi.setId(id);
			return "updateTaxi";
		}

		taxiService.saveTaxi(taxi);
		pageModel.setSIZE(10);
		pageModel.initPageAndSize();
		model.addAttribute("taxis", taxiService.findAllPageable(pageModel.getPAGE(), pageModel.getSIZE()));
		return "views/taxi";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Taxi taxi = taxiService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid taxi Id:" + id));
		taxiService.deleteTaxi(taxi);

		return "redirect:/taxi/findAll";
	}

	@GetMapping("/findOne")
	@ResponseBody
	public Taxi findOne(Long id) {
		return taxiService.findById(id).get();
	}

}
