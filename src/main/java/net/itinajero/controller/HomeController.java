package net.itinajero.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.itinajero.model.Vacante;

@Controller
public class HomeController {
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
		model.addAttribute("vacantes", lista);
		
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("ingeniero de comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para soprte de comunicaciones ");
		vacante.setFecha(new Date());
		vacante.setSalarios(9700.0);
		model.addAttribute("vacante", vacante);
		return "detalle";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model ) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero de sistemas");
		lista.add("Auxiliar de contabilidad");
		lista.add("vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos", lista);
		return "listado";
		
	}
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		
		/*model.addAttribute("mensaje", "Bienvenidos a empleos APP");
		model.addAttribute("fecha", new Date());
		return "home";*/
		String nombre ="Auxiliar de contabilidad ";
		Date fechaPub = new Date();
		double salario = 900.0;
		boolean vigente =true;
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);
		
		return "home";
		
	}
	/**
	 * Metodo que regresa  una lista de objetos de tipo Vacante
	 * @return
	 */
	private List<Vacante> getVacantes(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();
		try {
			//Creamos oferta de trabajo 1.
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Solicitamos ingeniero civil para diseñar puente peatonal ");
			vacante1.setFecha(sdf.parse("08-02-2019"));
			vacante1.setSalarios(8500.0);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");
			
			//Creamos oferta de trabajo 2.
			Vacante vacante2 = new Vacante();
			vacante2.setId(3);
			vacante2.setNombre("Contador Publico");
			vacante2.setDescripcion("Empresa solicita contador con 5 años de experiancia ");
			vacante2.setFecha(sdf.parse("09-02-2019"));
			vacante2.setSalarios(8500.0);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			//Creamos oferta de trabajo 3.
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Ingeniero Electrico");
			vacante3.setDescripcion("Empresa interncaional solicita ingeniero electrico ");
			vacante3.setFecha(sdf.parse("10-02-2019"));
			vacante3.setSalarios(10500.0);
			vacante3.setDestacado(0);
			vacante3.setImagen("empresa3.png");
			
			//Creamos oferta de trabajo 4.
			Vacante vacante4 = new Vacante();
			vacante4.setId(4);
			vacante4.setNombre("Diseñador gráfico");
			vacante4.setDescripcion("Solicitamos Diselador grafico con experiancia ");
			vacante4.setFecha(sdf.parse("11-02-2019"));
			vacante4.setSalarios(7500.0);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa4.png");
			/**
			 * Agregamos los 4 objetos de tipo vacante a la lista ...
			 */
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		} catch(ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return lista;
	}
}
