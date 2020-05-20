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

import ci.boobacool.gestiontaxitesla.domain.TypeDepense;
import ci.boobacool.gestiontaxitesla.pagination.PageModel;
import ci.boobacool.gestiontaxitesla.service.TypeDepenseServiceImpl;

@Controller
@RequestMapping("typedepense")
public class TypeDepenseController {

	@Autowired
	private TypeDepenseServiceImpl typeDepenseServiceImpl;
	@Autowired
	private PageModel pageModel;

	@GetMapping(value = "/findAll")
	public String findAllPageable(Model model) {
		pageModel.setSIZE(10);
		pageModel.initPageAndSize();
		model.addAttribute("tds", typeDepenseServiceImpl.findAllPageable(pageModel.getPAGE(), pageModel.getSIZE()));
		return "views/taxi";
	}

	@RequestMapping(value = "savetd", method = RequestMethod.POST)
	public String saveTaxi(@Valid TypeDepense td, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "addTaxi";
		}

		typeDepenseServiceImpl.saveTD(td);
		/*
		 * pageModel.setSIZE(10); pageModel.initPageAndSize();
		 * model.addAttribute("taxis", taxiService.findAllPageable(pageModel.getPAGE(),
		 * pageModel.getSIZE()));
		 */

		return "redirect:/typedepense/findAll";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		TypeDepense td = typeDepenseServiceImpl.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid TypeDepense Id:" + id));
		model.addAttribute("td", td);
		return "update";
	}

	

	@GetMapping("/delete/{id}")
	public String deleteTD(@PathVariable("id") long id, Model model) {
		TypeDepense td = typeDepenseServiceImpl.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid taxi Id:" + id));
		typeDepenseServiceImpl.deleteTD(td);

		return "redirect:/typedepense/findAll";
	}

	@GetMapping("/findOne")
	@ResponseBody
	public TypeDepense findOne(Long id) {
		return typeDepenseServiceImpl.findById(id).get();
	}

}
