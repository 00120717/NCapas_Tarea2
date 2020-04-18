package com.uca.capas.tarea2Capas.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
	
	@RequestMapping("/studentdata")
	public @ResponseBody String tarea2Capas() {
		String texto = "Nombre: Marvin\n  Apellido: Ramirez  Carnet: 00120717 Carrera: Ing. Informatica  Año cursado: 4 año" ;
		return texto;
	}
	
	
	@RequestMapping("/date")
	public @ResponseBody String date(HttpServletRequest request) {
		Integer day = Integer.parseInt(request.getParameter("day"));
		Integer month = Integer.parseInt(request.getParameter("month"));
		Integer year = Integer.parseInt(request.getParameter("year"));
		
		String dias []= {" Domingo ", " Lunes "," Martes "," Miercoles "," Jueves "," Viernes "," Sabado "};
		
		if((day < 32)&&(month < 13)&&(year < 10000)){//si la fecha es correcta
            int a = (14 - month) / 12;
            int y = year - a;
            int m = month + 12 * a - 2;

            int d = (day + y + y/4 - y/100 + y/400 + (31*m)/12) % 7;
            return "El dia es :" + dias[d];
       }else {
    	   return "Formato no valido";
       }
		
		
	}
}
