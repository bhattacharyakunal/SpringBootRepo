package com.java.kunal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.kunal.model.Country;
@Service
public class CountryService {
	List<Country> countryList;
	public List<Country> findall() {
		countryList=new ArrayList<>();
		Country india=new Country("1","INDIA","NA");
		countryList.add(india);
		Country usa=new Country("2","usa","NA");
		countryList.add(usa);
		Country germany=new Country("3","germany","NA");
		countryList.add(germany);
		Country spain=new Country("4","spain","NA");
		countryList.add(spain);
		Country argentina=new Country("5","argentina","NA");
		countryList.add(argentina);
		Country brazil=new Country("6","brazil","NA");
		countryList.add(brazil);
		Country mexico=new Country("7","mexico","NA");
		countryList.add(mexico);
		Country portugal=new Country("8","portugal","NA");
		countryList.add(portugal);
		Country japan=new Country("9","japan","NA");
		countryList.add(japan);
		Country russia=new Country("10","russia","NA");
		countryList.add(russia);
		Country italy=new Country("11","italy","NA");
		countryList.add(italy);
		Country france=new Country("12","france","NA");
		countryList.add(france);
		Country canada=new Country("13","canada","NA");
		countryList.add(canada);
		Country srilanka=new Country("14","srilanka","NA");
		countryList.add(srilanka);
		Country bulgeria=new Country("15","bulgeria","NA");
		countryList.add(bulgeria);
		Country chili=new Country("16","chili","NA");
		countryList.add(chili);
		Country burmuda=new Country("17","burmuda","NA");
		countryList.add(burmuda);
		Country china=new Country("18","china","NA");
		countryList.add(china);
		Country bangladesh=new Country("19","bangladesh","NA");
		countryList.add(bangladesh);
		Country nepal=new Country("20","nepal","NA");
		countryList.add(nepal);
		Country bhutan=new Country("21","bhutan","NA");
		countryList.add(bhutan);
		Country southkorea=new Country("22","southkorea","NA");
		countryList.add(southkorea);
		Country oman=new Country("23","oman","NA");
		countryList.add(oman);
		Country chekoslovia=new Country("24","chekoslovia","NA");
		countryList.add(chekoslovia);
		Country westindies=new Country("25","westindies","NA");
		countryList.add(westindies);
		Country newzeland=new Country("26","newzeland","NA");
		countryList.add(newzeland);
		Country iceland=new Country("27","iceland","NA");
		countryList.add(iceland);
	 return countryList;	
	}
	
	public List<Country> findall(int page,int item) {
		List<Country> countryList=findall();
		List<Country> paginatedcountryList=new ArrayList<>();
		for(int i=item*(page-1);i<=((item*page)-1);i++) {
			if(countryList.size()>i) {
				System.out.println(i+"----------------------"+countryList.get(i));
				paginatedcountryList.add(countryList.get(i));
			}
		}
		return paginatedcountryList;
	}
}
