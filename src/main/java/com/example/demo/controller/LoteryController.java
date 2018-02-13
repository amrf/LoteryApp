package com.example.demo.controller;

import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.basic.Jogos;
import com.example.demo.basic.LoteryCheck;
import com.example.demo.config.MainConfig;

@RestController
@RequestMapping("/")
public class LoteryController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody LoteryCheck readBookmarks() {
		

		TreeSet<Integer> lastNumbers = null;
		try {
			lastNumbers = getNumbers();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new LoteryCheck("Nós Ganhamos!!", lastNumbers);

	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody LoteryCheck readGamesPlayed(@RequestBody Jogos jogos) {
		System.out.println(jogos.toString());
		TreeSet<Integer> lastNumbers = null;
		try {
			lastNumbers = getNumbers();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new LoteryCheck("Nós Ganhamos!!", lastNumbers);

	}

	public TreeSet<Integer> getNumbers() throws Exception {
		TreeSet<Integer> lastNumbers = new TreeSet<Integer>();
		Document doc = Jsoup.connect("https://noticias.uol.com.br/loterias/mega-sena/").get();
		Elements content = doc.getElementsByClass("jogo");
		Element headline = content.first();

		Elements content1 = headline.getElementsByTag("td");
		for (Element element : content1) {

			String number = new String(element.toString());
			number = number.replaceFirst("<td>", "");
			number = number.replaceFirst("</td>", "");
			lastNumbers.add(Integer.valueOf(number));
		}

		return lastNumbers;

	}

}
