package com.betting.bettinginfo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@SpringBootTest
class BettingInfoApplicationTests {

	@Test
	void contextLoads() {
		List<Address> address = List.of(new Address("Cadiz"), new Address("Madrid"));
		List<List<Persona>> globalList = List.of(List.of(new Persona("A",address), new  Persona("B"),new Persona( "C",address)), List.of(new Persona("D"), new Persona("E"), new Persona("F", address)),List.of(new Persona("G"), new Persona("H"), new Persona("I")));
		List<List<Persona>> finalList = globalList.stream().map(listPersona -> listPersona.stream().filter(persona -> persona.getAddresses().stream().anyMatch(address1 -> address1.getCity().equals("Cadiz"))).collect(Collectors.toList())).toList();

		finalList.forEach(s -> System.out.println(s));
	}

	class Persona{
		String name;
		List<Address> addresses;

		public Persona(String name, List<Address> addresses) {
			this.name = name;
			this.addresses = addresses;
		}

		public Persona(String name) {
			this.name = name;
			this.addresses = new ArrayList<>();
		}

		public String getName() {
			return name;
		}

		public List<Address> getAddresses() {
			return addresses;
		}
	}

	class Address{
		String city;

		public Address(String city) {
			this.city = city;
		}

		public String getCity() {
			return city;
		}
	}
}
