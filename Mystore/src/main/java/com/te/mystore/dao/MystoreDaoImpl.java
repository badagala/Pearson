 package com.te.mystore.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.te.mystore.dto.Store;
import com.te.mystore.service.CityComparator;

@Repository
public class MystoreDaoImpl implements MystoreDao{

	LocalDate nowDate = LocalDate.now();

	public List<Store> getAllByid(String id) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stores.csv"));
		String details = "";
		List<Store> al = new ArrayList<Store>();

		while ((details = br.readLine()) != null) {
			String[] data = details.split(",");
			Store c = new Store();
			c.setStoreId(data[0]);
			c.setPostcode(data[1]);
			c.setCity(data[2]);
			c.setAddress(data[3]);
			c.setOpenedDate(data[4]);

			String[] date = c.getOpenedDate().split("-");

			int year = Integer.parseInt(date[2]);
			int month = Integer.parseInt(date[1]);
			int day = Integer.parseInt(date[0]);
			LocalDate pastDate = LocalDate.of(year, month, day);
			long dt = ChronoUnit.DAYS.between(pastDate,nowDate);

			c.setNumberofdays(dt);

			if (id.equalsIgnoreCase(data[0])) {
				al.add(c);
			}

		}
		return al;
	}

	public List<Store> getAll() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stores.csv"));
		String details = "";
		List<Store> al = new ArrayList<Store>();

		while ((details = br.readLine()) != null) {
			String[] data = details.split(",");
			Store c = new Store();

			c.setStoreId(data[0]);

			c.setPostcode(data[1]);
			c.setCity(data[2]);
			c.setAddress(data[3]);
			c.setOpenedDate(data[4]);

			String[] date = c.getOpenedDate().split("-");

			int year = Integer.parseInt(date[2]);
			int month = Integer.parseInt(date[1]);
			int day = Integer.parseInt(date[0]);
			LocalDate pastDate = LocalDate.of(year, month, day);
			long dt = ChronoUnit.DAYS.between(pastDate,nowDate);

			c.setNumberofdays(dt);

			al.add(c);

		}
		Collections.sort(al, new CityComparator());
		return al;
	}

//	public List<Store> getAllByCity(String city,String dates) throws IOException {
//
//		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stores.csv"));
//		String details = "";
//		List<Store> al = new ArrayList<Store>();
//
//		while ((details = br.readLine()) != null) {
//			String[] data = details.split(",");
//			Store c = new Store();
//			c.setStoreId(data[0]);
//			c.setPostcode(data[1]);
//			c.setCity(data[2]);
//			c.setAddress(data[3]);
//			c.setOpenedDate(data[4]);
//
//			String[] date = c.getOpenedDate().split("-");
//
//			int year = Integer.parseInt(date[2]);
//			int month = Integer.parseInt(date[1]);
//			int day = Integer.parseInt(date[0]);
//			LocalDate pastDate = LocalDate.of(year, month, day);
//			long dt =ChronoUnit.DAYS.between(pastDate,nowDate);
//
//			c.setNumberofdays(dt);
//
//			if (city.equalsIgnoreCase(data[2])) {
//				al.add(c);
//			}
//
//		}
//		return al;
//	}
//
//	public List<Store> getAllByDate(String date) throws IOException {
//
//		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/stores.csv"));
//		String details = "";
//		List<Store> al = new ArrayList<Store>();
//
//		while ((details = br.readLine()) != null) {
//			String[] data = details.split(",");
//			Store c = new Store();
//
//			c.setStoreId(data[0]);
//
//			c.setPostcode(data[1]);
//
//			c.setCity(data[2]);
//			c.setAddress(data[3]);
//			c.setOpenedDate(data[4]);
//
//			String[] dates = c.getOpenedDate().split("-");
//
//			int year = Integer.parseInt(dates[2]);
//			int month = Integer.parseInt(dates[1]);
//			int day = Integer.parseInt(dates[0]);
//			LocalDate pastDate = LocalDate.of(year, month, day);
//			long dt = ChronoUnit.DAYS.between(pastDate,nowDate);
//
//			c.setNumberofdays(dt);
//
//			if (date.equalsIgnoreCase(data[4])) {
//				al.add(c);
//			}
//
//		}
//		return al;
//	}

}
