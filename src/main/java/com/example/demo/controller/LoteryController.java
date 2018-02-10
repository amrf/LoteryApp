package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.basic.LoteryCheck;

@RestController
@RequestMapping("/")
public class LoteryController {

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody LoteryCheck readBookmarks() {

		TreeSet<Integer> lastNumbers = null;
		try {
			lastNumbers = readPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new LoteryCheck("Nós Ganhamos!!", lastNumbers);

	}

	public TreeSet<Integer> readPage() throws Exception {
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
